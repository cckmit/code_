package com.mika.credit.facade.index.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.index.BaseSearchParam;
import com.mika.credit.common.entity.index.BaseSearchResult;
import com.mika.credit.common.entity.index.BigNetSearchParam;
import com.mika.credit.common.util.HttpUtil;
import com.mika.credit.facade.index.bean.Company;
import com.mika.credit.facade.index.bean.QueryENByName;
import com.mika.credit.facade.index.bean.QueryENByProduct;
import com.mika.credit.facade.index.service.CompanyIndexService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 索引服务
 * <p>
 * Created by Gavin on 2017/2/8.
 */
@Service("companyIndexService")
public class CompanyIndexServiceImpl implements CompanyIndexService {
    private static final String INDEX_URL_CN = "http://180.169.17.53:6060/solr/company/select";
    private static final String INDEX_URL_EN = "http://180.169.17.53:6060/solr/companyen/select";
    private static final String INDEX_URL_BIGNET = "http://192.168.1.184:8080/solr/companybignet/select";
    private static ThreadLocal<String> indexURL = new ThreadLocal<>();
    private String username = "solr";
    private String password = "gogogo";
    private String[] stopWords = {
            " ",
            "\\(",
            "\\)",
            "\\（",
            "\\）"

    };
    private static final List<String> notParamField = Arrays.asList("current", "rowCount", "maxHitCount", "serialVersionUID");
    private static Logger logger = Logger.getLogger(CompanyIndexServiceImpl.class);

    @Override
    public BootGrid<Company> fillCompanyIndex(BootGrid<Company> param) {
        indexURL.set(INDEX_URL_CN);
        param = checkBootGrid(param);
        if (!param.getResult()) {
            return param;
        }

        param.setSearchPhrase("all:" + filterStopWord(param.getSearchPhrase()));

        return fillCompanyIndexBasic(param, null);
    }

    @Override
    public BootGrid<Company> fillCompanyIndexSimple(String keyword) {
        indexURL.set(INDEX_URL_CN);
        BootGrid<Company> param = new BootGrid<>();
        if (keyword == null || keyword.length() < 1) {
            param.setResult(false);
            param.setResultDes("查询条件为空！");
            return param;
        }
        param.setSearchPhrase(keyword);
        return fillCompanyIndex(param);
    }

    @Override
    public BootGrid<Company> fillCompanyIndex(String keyword, Integer pageNo, Integer pageSize) {
        indexURL.set(INDEX_URL_CN);
        BootGrid<Company> param = new BootGrid<>();
        if (keyword == null || keyword.length() < 1) {
            param.setResult(false);
            param.setResultDes("查询条件为空！");
            return param;
        }
        param.setSearchPhrase(keyword);
        param.setRowCount(pageSize);
        param.setCurrent(pageNo);
        return fillCompanyIndex(param);
    }

    @Override
    public BootGrid<String> fillCompanyNameIndexSimple(String keyword, Integer pageSize) {
        indexURL.set(INDEX_URL_CN);
        BootGrid<String> param = new BootGrid<>();
        if (keyword == null || keyword.length() < 1) {
            param.setResult(false);
            param.setResultDes("查询条件为空！");
            return param;
        }
        param.setSearchPhrase(keyword);
        Map<String, String> params = getDefaultParams();
        params.put("q", "all:" + filterStopWord(param.getSearchPhrase()));
        params.put("fl", "nameCN");
        //组织分页
        params.put("start", "0");
        params.put("rows", pageSize + "");

        String result = null;
        try {
            result = HttpUtil.syncData(indexURL.get(), params, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == null || result.length() == 0) {
            param.setResult(false);
            param.setResultDes("服务器异常！");
            System.out.println("服务器异常！\n参数：" + params);
            return param;
        }
//        System.out.print(result);
        JSONObject response = JSON.parseObject(result).getJSONObject("response");
        param.setTotal(response.getIntValue("numFound"));
        JSONArray docs = response.getJSONArray("docs");
        List<String> docList = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            JSONObject jsonObject = (JSONObject) docs.get(i);
            if (jsonObject.getString("nameCN") == null) {
                continue;
            }
            docList.add(jsonObject.getString("nameCN"));
        }
        param.setRows(docList);
        param.setResult(true);
        return param;
    }


    //=================================================================================================================
    @Override
    public BootGrid<Company> fillCompanyIndexENByName(BootGrid<Company> param, QueryENByName condition) {
        return fillCompanyIndexENByName(param, condition, false);
    }

    @Override
    public BootGrid<Company> fillCompanyIndexENByName(BootGrid<Company> param, QueryENByName condition, boolean isHighLight) {
        indexURL.set(INDEX_URL_EN);
        String query = getNameCondition(condition);
        param.setSearchPhrase(query);
        param = checkBootGrid(param);

        if (!param.getResult()) {
            return param;
        }
        Map<String, String> param2 = new HashMap<>();
        param2.put("df", "nameEN");
        if (isHighLight) {
            param2.putAll(getHighLightParams("nameEN"));
        }
        return fillCompanyIndexBasic(param, param2);
    }

    @Override
    public BootGrid<Company> fillCompanyIndexENByProduct(BootGrid<Company> param, QueryENByProduct condition) {
        return fillCompanyIndexENByProduct(param, condition, false);
    }

    @Override
    public BootGrid<Company> fillCompanyIndexENByProduct(BootGrid<Company> param, QueryENByProduct condition, boolean isHighLight) {
        indexURL.set(INDEX_URL_EN);
        String query = getProductCondition(condition);
        param.setSearchPhrase(query);
        param = checkBootGrid(param);
        if (!param.getResult()) {
            return param;
        }
        Map<String, String> param2 = new HashMap<>();
        param2.put("df", "productLabel");
        if (isHighLight) {
            param2.putAll(getHighLightParams("productLabel"));
        }
        return fillCompanyIndexBasic(param, param2);
    }

    @Override
    public BootGrid<Company> fillCompanyIndexSimpleENByName(QueryENByName condition) {
        return fillCompanyIndexSimpleENByName(condition, false);
    }

    @Override
    public BootGrid<Company> fillCompanyIndexSimpleENByName(QueryENByName condition, boolean isHighLight) {
        indexURL.set(INDEX_URL_EN);
        BootGrid<Company> param = new BootGrid<>();
        String query = getNameCondition(condition);
        param.setSearchPhrase(query);
        param = checkBootGrid(param);
        Map<String, String> param2 = new HashMap<>();
        param2.put("df", "nameEN");
        if (isHighLight) {
            param2.putAll(getHighLightParams("nameEN"));
        }
        return fillCompanyIndexBasic(param, param2);
    }

    @Override
    public BootGrid<Company> fillCompanyIndexSimpleENByProduct(QueryENByProduct condition) {
        return fillCompanyIndexSimpleENByProduct(condition, false);
    }

    @Override
    public BootGrid<Company> fillCompanyIndexSimpleENByProduct(QueryENByProduct condition, boolean isHighLight) {
        indexURL.set(INDEX_URL_EN);
        BootGrid<Company> param = new BootGrid<>();
        String query = getProductCondition(condition);
        param.setSearchPhrase(query);
        param = checkBootGrid(param);
        Map<String, String> param2 = new HashMap<>();
        param2.put("df", "productLabel");
        if (isHighLight) {
            param2.putAll(getHighLightParams("productLabel"));
        }
        return fillCompanyIndexBasic(param, param2);
    }

    @Override
    public BootGrid<String> fillCompanyNameIndexSimpleEN(QueryENByName condition, Integer pageSize) {
        indexURL.set(INDEX_URL_EN);
        BootGrid<String> param = new BootGrid<>();
        if (condition == null) {
            param.setResult(false);
            param.setResultDes("查询条件为空！");
            return param;
        }
        String keyword = getNameCondition(condition);
        param.setSearchPhrase(keyword);
        Map<String, String> params = getDefaultParams();

        params.put("q.op", "OR");
        params.put("defType", "edismax");
        params.put("mm", "90%");
        params.put("df", "nameEN");
        params.put("q", "all:" + filterStopWord(param.getSearchPhrase()));
        params.put("fl", "nameEN");
        //组织分页
        params.put("start", "0");
        params.put("rows", pageSize + "");

        String result = null;
        try {
            result = HttpUtil.syncData(indexURL.get(), params, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == null || result.length() == 0) {
            param.setResult(false);
            param.setResultDes("服务器异常！");
            System.out.println("服务器异常！\n参数：" + params);
            return param;
        }
//        System.out.print(result);
        JSONObject response = JSON.parseObject(result).getJSONObject("response");
        param.setTotal(response.getIntValue("numFound"));
        JSONArray docs = response.getJSONArray("docs");
        List<String> docList = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            JSONObject jsonObject = (JSONObject) docs.get(i);
            if (jsonObject.getString("nameCN") == null) {
                continue;
            }
            docList.add(jsonObject.getString("nameCN"));
        }
        param.setRows(docList);
        param.setResult(true);
        return param;
    }

    @Override
    public BootGrid<BaseSearchResult> fillCompanyIndexWithCondition(BaseSearchParam condition) {
        BootGrid<BaseSearchResult> bootGrid = new BootGrid<>();
        if (condition != null) {
            Field[] superFields = condition.getClass().getSuperclass().getDeclaredFields();
            Field[] fields = condition.getClass().getDeclaredFields();
            List<Field> allFields = new ArrayList<>();
            allFields.addAll(Arrays.asList(superFields));
            allFields.addAll(Arrays.asList(fields));
            String superCondition = getFieldCondition(allFields.toArray(fields), condition, indexURL.get().equals(INDEX_URL_CN));//查询条件
            bootGrid.setCurrent(condition.getCurrent());
            if (condition.getMaxHitCount() != null && condition.getMaxHitCount() > 0) {
                bootGrid.setRowCount(condition.getMaxHitCount());
            } else {
                bootGrid.setRowCount(condition.getRowCount());
            }
            bootGrid.setSearchPhrase(superCondition);
            bootGrid = checkBootGrid(bootGrid);
            if (bootGrid.getResult()) {
                Map<String, String> param = new HashMap<>();
                param.put("df", "nameEN");
                return fillSearchResultIndexBasic(bootGrid, param);
            }

        }
        return bootGrid;
    }

    public BootGrid<BaseSearchResult> fillCompanyIndexWithConditionEN(BaseSearchParam condition) {
        indexURL.set(INDEX_URL_EN);
        return fillCompanyIndexWithCondition(condition);
    }

    public BootGrid<BaseSearchResult> fillCompanyIndexWithConditionCN(BaseSearchParam condition) {
        indexURL.set(INDEX_URL_CN);
        return fillCompanyIndexWithCondition(condition);
    }

    public BootGrid<BaseSearchResult> fillCompanyIndexWithConditionBigNet(BaseSearchParam condition) {
        indexURL.set(INDEX_URL_BIGNET);
        return fillCompanyIndexWithCondition(condition);
    }


    private String filterStopWord(String keyword) {
        for (String stopword : stopWords) {
            keyword = keyword.replaceAll(stopword, "");
        }
        return keyword;
    }

    private Map<String, String> getDefaultParams() {
        Map<String, String> params = new HashMap<>();
        params.put("q", "*:*");
        params.put("indent", "on");
        params.put("wt", "json");
//        params.put("q.op","OR");
//        params.put("defType","edismax");
//        params.put("mm","90%");
        return params;
    }

    private Map<String, String> getHighLightParams(String highLightField) {
        //hl.snippets=5&hl.mergeContiguous=true
        Map<String, String> params = new HashMap<>();
        params.put("hl.fl", highLightField);
        params.put("hl.simple.post", "</em>");
        params.put("hl.simple.pre", "<em style='color:#E74C3C;font-weight:bold;font-style:normal'>");
        params.put("hl", "on");
        //以下参数防止高亮数据显示不完全
        params.put("hl.fragsize", "0");//参数hl.snippets(默认=1)来控制每层循环中保留的最大个数
        //params.put("hl.mergeContiguous", "true");//参数hl.mergeContiguous来控制是否合并在一起。
        return params;
    }


    private <T> BootGrid<T> checkBootGrid(BootGrid<T> bootGrid) {
        //校验数据有效性
        if (bootGrid == null) {
            bootGrid = new BootGrid<>();
            bootGrid.setResult(false);
            bootGrid.setResultDes("查询条件为空!");
            return bootGrid;
        }
        if (bootGrid.getSearchPhrase() == null || bootGrid.getSearchPhrase().length() < 1) {
            bootGrid.setResult(false);
            bootGrid.setResultDes("查询条件为空!");
            return bootGrid;
        }
        //如果没有传送每页行数，则只返回第1页50条。
        if (bootGrid.getRowCount() < 1) {
            bootGrid.setRowCount(50);
        }
        if (bootGrid.getCurrent() < 1) {
            bootGrid.setCurrent(1);
        }
        bootGrid.setResult(true);
        return bootGrid;
    }

    public BootGrid<Company> fillCompanyIndexBasic(BootGrid<Company> bootGrid, Map<String, String> extraParam) {
        Map<String, String> param = getDefaultParams();
        //组织分页
        param.put("start", ((bootGrid.getCurrent() - 1) * bootGrid.getRowCount()) + "");
        param.put("rows", bootGrid.getRowCount() + "");
        param.put("q", bootGrid.getSearchPhrase());

        if (extraParam != null && extraParam.size() > 0) {
            param.putAll(extraParam);

        }

        String result = null;
        try {
            result = HttpUtil.syncData(indexURL.get(), param, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == null || result.length() == 0) {
            bootGrid.setResult(false);
            bootGrid.setResultDes("服务器异常！");
            System.out.println("服务器异常！\n参数：" + bootGrid);
            return bootGrid;
        }
//        System.out.print(result);
        JSONObject response = JSON.parseObject(result).getJSONObject("response");
        bootGrid.setTotal(response.getIntValue("numFound"));
        JSONArray docs = response.getJSONArray("docs");
        List<Company> companies = JSONObject.parseArray(docs.toJSONString(), Company.class);
        JSONObject highlighting = JSON.parseObject(result).getJSONObject("highlighting");
        for (Company company : companies) {
            company.setHighLightNameCN(company.getNameCN());
            company.setHighLightNameEN(company.getNameEN());
            company.setHighLightProductLabel(company.getProductLabel());
            company.setHighLightReg(company.getReg());
            String hlfl = param.get("hl.fl");
            if ("nameEN".equals(hlfl)) {
                JSONObject jsonObject = highlighting.getJSONObject(company.getCrefoNo() + "");
                String nameEN = jsonObject.getString("nameEN");
                if (StringUtils.isNotBlank(nameEN)) {
                    nameEN = nameEN.replace("[\"", "").replace("\"]", "");
                    System.out.println(nameEN);
                    company.setHighLightNameEN(nameEN);
                }

            } else if ("productLabel".equals(hlfl)) {
                JSONObject jsonObject = highlighting.getJSONObject(company.getCrefoNo() + "");
                String productLabel = jsonObject.getString("productLabel");
                if (StringUtils.isNotBlank(productLabel)) {
                    productLabel = productLabel.replace("[\"", "").replace("\"]", "");
                    System.out.println(productLabel);
                    company.setHighLightProductLabel(productLabel);
                }

            } else if ("reg".equals(hlfl)) {
                JSONObject jsonObject = highlighting.getJSONObject(company.getCrefoNo() + "");
                String reg = jsonObject.getString("reg");
                if (StringUtils.isNotBlank(reg)) {
                    reg = reg.replace("[\"", "").replace("\"]", "");
                    System.out.println(reg);
                    company.setHighLightReg(reg);
                }

            } else {
                break;
            }
        }
        bootGrid.setRows(companies);
        bootGrid.setResult(true);
        indexURL.remove();
        return bootGrid;
    }

    public BootGrid<BaseSearchResult> fillSearchResultIndexBasic(BootGrid<BaseSearchResult> bootGrid, Map<String, String> extraParam) {
        Map<String, String> param = getDefaultParams();
        //组织分页
        param.put("start", ((bootGrid.getCurrent() - 1) * bootGrid.getRowCount()) + "");
        param.put("rows", bootGrid.getRowCount() + "");
        param.put("q", bootGrid.getSearchPhrase());

        if (extraParam != null && extraParam.size() > 0) {
            param.putAll(extraParam);

        }

        String result = null;
        try {
            result = HttpUtil.syncData(indexURL.get(), param, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == null || result.length() == 0) {
            bootGrid.setResult(false);
            bootGrid.setResultDes("服务器异常！");
            System.out.println("服务器异常！\n参数：" + bootGrid);
            return bootGrid;
        }
//        System.out.print(result);
        JSONObject response = JSON.parseObject(result).getJSONObject("response");
        bootGrid.setTotal(response.getIntValue("numFound"));
        JSONArray docs = response.getJSONArray("docs");
        bootGrid.setRows(JSONObject.parseArray(docs.toJSONString(), BaseSearchResult.class));
        bootGrid.setResult(true);
        indexURL.remove();
        return bootGrid;
    }

    public static void main(String[] args) {
        BootGrid<Company> result = new BootGrid<>();
        //result.setSearchPhrase("nameEN:*Tencent*");
        result.setSearchPhrase("nameEN:*3ACredit*");
        result.setRowCount(50);
        result.setCurrent(1);
        CompanyIndexServiceImpl indexService = new CompanyIndexServiceImpl();
        //System.out.println(JSON.toJSONString(new CompanyIndexServiceImpl().fillCompanyIndex("商安信", 1, 50)));
        //System.out.println(JSON.toJSONString(new CompanyIndexServiceImpl().fillCompanyIndex("商安信", 1, 50)));
        //System.out.println(JSON.toJSONString(new CompanyIndexServiceImpl().fillCompanyIndex(null)));
        QueryENByName queryENByName = new QueryENByName();
        queryENByName.setNameEN("Guangdong");
        //queryENByName.setStatus("1");
        //queryENByName.setExIm("1");
        QueryENByProduct product = new QueryENByProduct();
        //BootGrid<Company> simple = indexService.fillCompanyIndexSimple("商安信(上海)企业管理咨询股份有限公司");
        product.setProductLabel("credit");
        //product.setChnCode("7295");
        BaseSearchParam baseSearchParam = new BaseSearchParam();
        baseSearchParam.setNameEN("credit");
        BigNetSearchParam bigNetSearchParam = new BigNetSearchParam();
        bigNetSearchParam.setRowCount(10);
        bigNetSearchParam.setCurrent(1);
        //bigNetSearchParam.setReg("911100005604497547");
        //bigNetSearchParam.setNameEN("Hengdian Group Dmegc");
        bigNetSearchParam.setCityEN("Anqing");
        bigNetSearchParam.setAreaEN("Anhui");
        bigNetSearchParam.setPostcode("246005");
        bigNetSearchParam.setPhoneNumber("0556-5325888");
        bigNetSearchParam.setNameEN("Anqing Hengchang Machinery");
        bigNetSearchParam.setStreetEN("Xingye");
        bigNetSearchParam.setCrefoNo("CN9360396014");
        //bigNetSearchParam.setReg("91310000679308430H");
        bigNetSearchParam.setMaxHitCount(1);
        //BootGrid<BaseSearchResult> grid = indexService.fillCompanyIndexWithConditionEN(bigNetSearchParam);
        //BootGrid<BaseSearchResult> grid = indexService.fillCompanyIndexWithConditionBigNet(bigNetSearchParam);
        //System.out.println(JSON.toJSONString(grid.getRows()));
        //System.out.println(JSON.toJSONString(simple));
        //List<Company> rows = indexService.fillCompanyIndexSimpleENByName(queryENByName,true).getRows();
        List<Company> rows = indexService.fillCompanyIndexSimpleENByProduct(product, true).getRows();
        System.out.println(JSON.toJSONString(rows));
    }


    //public static void main(String[] args) {
    //    List<Future<BootGrid<Company>>> futures = new ArrayList<>();
    //    CompanyIndexServiceImpl service = new CompanyIndexServiceImpl();
    //    ExecutorService threadPool = Executors.newCachedThreadPool();
    //    QueryENByName queryENByName = new QueryENByName();
    //    queryENByName.setNameEN("3ACredit (Shanghai) Management Consulting Co., Ltd.");
    //    for (int i = 0; i < 10; i++) {
    //        if (i % 2 == 0) {
    //            futures.add(threadPool.submit(() -> service.fillCompanyIndexSimple("商安信(上海)企业管理咨询股份有限公司")));
    //        } else {
    //            futures.add(threadPool.submit(() -> service.fillCompanyIndexSimpleENByName(queryENByName)));
    //        }
    //    }
    //    threadPool.shutdown();
    //    for (Future<BootGrid<Company>> future : futures) {
    //        try {
    //            BootGrid<Company> grid = future.get();
    //            System.out.println(grid.getSearchPhrase()+"---"+grid.getTotal());
    //        } catch (InterruptedException | ExecutionException e) {
    //            e.printStackTrace();
    //        }
    //    }
    //
    //}

    public String getProductCondition(QueryENByProduct condition) {
        List<String> list = new ArrayList<>();
        if (condition != null) {
            if (StringUtils.isNotBlank(condition.getProductLabel())) {
                list.add("productLabel:" + condition.getProductLabel());
            }
            if (condition.getA() != null) {
                list.add("a:" + condition.getA());
            }
            if (condition.getV() != null) {
                list.add("v:" + condition.getV());
            }
            if (StringUtils.isNotBlank(condition.getProvince())) {
                list.add("provinceEN:" + condition.getProvince());
            }
            if (StringUtils.isNotBlank(condition.getStatus())) {
                list.add("status:" + condition.getStatus());
            }
            if (StringUtils.isNotBlank(condition.getScale())) {
                list.add("scale:" + condition.getScale());
            }
            if (StringUtils.isNotBlank(condition.getChnCode())) {
                list.add("chnCode:" + condition.getChnCode());
            }
        }
        StringBuilder query = new StringBuilder();//查询条件
        if (list.size() > 0) {
            query.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                query.append(" AND " + list.get(i));
            }
        }
        return StringUtils.isBlank(query.toString()) ? "*:*" : query.toString();

    }

    public String getNameCondition(QueryENByName condition) {
        List<String> list = new ArrayList<>();
        if (condition != null) {
            if (StringUtils.isNotBlank(condition.getNameEN())) {
                list.add("nameEN:" + condition.getNameEN());
            }
            if (StringUtils.isNotBlank(condition.getNameCN())) {
                list.add("nameCN:" + condition.getNameCN());
            }
            if (StringUtils.isNotBlank(condition.getProvince())) {
                list.add("provinceEN:" + condition.getProvince());
            }
            if (StringUtils.isNotBlank(condition.getExIm())) {
                list.add("exIm:" + condition.getExIm());
            }
            if (StringUtils.isNotBlank(condition.getStatus())) {
                list.add("status:" + condition.getStatus());
            }
            if (StringUtils.isNotBlank(condition.getReg())) {
                list.add("reg:" + condition.getReg());
            }
        }
        StringBuilder query = new StringBuilder();//查询条件
        if (list.size() > 0) {
            query.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                query.append(" AND " + list.get(i));
            }
        }
        return StringUtils.isBlank(query.toString()) ? "*:*" : query.toString();
    }

    public String getFieldCondition(Field[] fields, Object target, boolean forCN) {
        List<String> list = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            if (notParamField.contains(field.getName()))
                continue;
            try {
                if (field.get(target) != null && !"".equals(field.get(target))) {
                    if (forCN) {
                        list.add("all:" + field.get(target));
                    } else {
                        list.add(field.getName() + ":" + field.get(target));
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                logger.error("字段解析错误:" + e);
            }
        }
        StringBuilder query = new StringBuilder();//查询条件
        if (list.size() > 0) {
            query.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                query.append(" AND ").append(list.get(i));
            }
        }
        return StringUtils.isNotBlank(query.toString()) ? query.toString() : "*:*";
    }

}
