package com.mika.credit.web.globalsearch.controller.core;

import java.util.*;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.CityInfo;
import com.mika.credit.common.entity.ProvinceInfo;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.*;
import com.mika.credit.common.entity.order.OrderDetail;
import com.mika.credit.common.entity.report.cn.BasicInfos;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.commondata.service.CountryInfoService;
import com.mika.credit.facade.front.cn.service.FullReportService;
import com.mika.credit.facade.globalsearch.core.model.*;

import com.mika.credit.facade.globalsearch.core.model.Collection;
import com.mika.credit.facade.globalsearch.core.service.CollectionService;
import com.mika.credit.facade.index.bean.Company;
import com.mika.credit.facade.index.bean.QueryENByName;
import com.mika.credit.facade.index.bean.QueryENByProduct;
import com.mika.credit.facade.index.service.CompanyIndexService;
import com.mika.credit.facade.order.service.OrderDetailViewService;
import com.mika.credit.facade.order.service.OrderService;
import com.mika.credit.facade.order.service.ProductService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ReprotController {
    private static final Logger logger = Logger.getLogger(ReprotController.class);
    @Resource
    private OrderService orderService;

    @Resource
    private OrderDetailViewService orderDetailViewService;

    @Resource
    private FullReportService fullReportService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private CountryInfoService countryInfoService;

    @Autowired
    private CompanyIndexService companyIndexService;

    /**
     * fullsearch
     * 产品选择页面
     *
     * @param map
     * @param crefoNo
     * @return
     * @throws Exception
     */
    @RequestMapping("/user/reportChoose.do")
    public String reportChoose(HttpServletRequest request, ModelMap map, String crefoNo, String companyName, String companyNameCN, String a, String v, String stockCode, String status, String reg, HttpServletResponse response,String typeId,String cnId) throws Exception {
        logger.info("跳转产品选择页面...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        BootGrid<Product> productBootGrid = new BootGrid<>();
        OrderDetailViewQuery orderDetailViewQuery = new OrderDetailViewQuery();
        Product product = new Product();
        FullReport fullReport = new FullReport();
        product.setSource((byte) 2);//来源全搜
        product.setProductType((byte) 1);//中国报告
        fullReport.setCrefoNo(crefoNo);
        fullReport.setNameCN(companyNameCN);
        orderDetailViewQuery.setCompanyName(companyName);
        orderDetailViewQuery.setCompanyNameCN(companyNameCN);

        QueryENByName queryENByName1=new QueryENByName();
        queryENByName1.setNameEN(companyName);
        BootGrid<Company> companyBootGrid = companyIndexService.fillCompanyIndexSimpleENByName(queryENByName1);
        if (companyBootGrid.getResult()){
            List<Company> rows = companyBootGrid.getRows();
            if (rows.size()>0){
                Company company = rows.get(0);
                if (a==null){
                    a=company.getA()+"";
                }
                if (v==null){
                    v=company.getV()+"";
                }
                if (stockCode==null){
                    stockCode=company.getStockCode();
                }
                if (status==null){
                    status=company.getStatus()+"";
                }
            }
        }
//        Cookie[] cookies = request.getCookies();
//        if (cookies!=null){
//            boolean flag=false;
//            for (Cookie cookie : cookies) {
//                if ("queryCompanyList".equals(cookie.getName())){
//                    cookie.setValue(StringUtils.isBlank(cookie.getValue())?companyName:cookie.getValue()+";"+companyName);
//                    cookie.setMaxAge(7*24*60*60);
//                    cookie.setPath("/");
//                    flag=true;
//                }
//                    response.addCookie(cookie);
//            }
//            if (!flag){
//                Cookie cookie = new Cookie("queryCompanyList", companyName);
//                cookie.setMaxAge(7*24*60*60);
//                cookie.setPath("/");
//                response.addCookie(cookie);
//            }
//        }

        if (customer != null) {
            orderDetailViewQuery.setCustomerId(customer.getId());
            map.addAttribute("customerId", customer.getId());
            Collection collection = new Collection();
            collection.setCustomerId(customer.getId());
            collection.setCollectionCompany(companyName);
            ResponseResult<Collection> responseResult = collectionService.getCollectionByCidAndCname(collection);
            if (responseResult.getContent() != null) {
                map.addAttribute("collectionCompany", responseResult.getContent().getCollectionCompany());
            }
        }
        productBootGrid = productService.findCustomerProducts(productBootGrid, orderDetailViewQuery, product);
        if (CollectionUtils.isEmpty(productBootGrid.getRows())) {
            BootGrid<OrderDetailView> bootGrid = new BootGrid<>();
            bootGrid.setCurrent(0);
            bootGrid.setRowCount(Integer.MAX_VALUE);
            orderDetailViewQuery.setCustomerId(customer.getId());
            orderDetailViewQuery.setCompanyName(companyName);
            BootGrid<OrderDetailView> byExample = orderDetailViewService.findByExample(bootGrid, orderDetailViewQuery);
            if (byExample.getRows().size() > 0) {
                OrderDetailView detailView = byExample.getRows().get(0);
                Orders orders = detailView.getOrders();
                productBootGrid.setResult(false);
                map.addAttribute("order", orders);
            }
        }
        fullReport = fullReportService.getGlobalRegReport(fullReport);

        if (fullReport.getBasicInfos() == null) {
            BasicInfos basicInfos = new BasicInfos();
            fullReport.setBasicInfos(basicInfos);

        } else {
            String provinceEN = isNull(fullReport.getBasicInfos().getProvinceEN());
            String cityEN = isNull(fullReport.getBasicInfos().getCityEN());
            if (StringUtil.isNotNull(cityEN)) {
                ResponseResult<CityInfo> cityInfo = countryInfoService.findCityInfoEN(cityEN);
                map.addAttribute("city", cityInfo.getContent());
                ResponseResult<ProvinceInfo> provinceInfo = countryInfoService.findProvinceInfoEN(provinceEN);
                map.addAttribute("province", provinceInfo.getContent());
            }
        }
        QueryENByName queryENByName = new QueryENByName();
        queryENByName.setNameEN(companyName);
        queryENByName.setReg(reg);
        BootGrid<Company> bootGrid = companyIndexService.fillCompanyIndexSimpleENByName(queryENByName);
        if (bootGrid.getResult()) {
            List<Company> rows = bootGrid.getRows();
            if (rows.size() > 0) {
                CompanyBasicInfo companyBasicInfo = new CompanyBasicInfo();
                Company company = rows.get(0);
                companyBasicInfo.setCompanyNameEn(companyName);
                companyBasicInfo.setCompanyName(company.getNameCN());
                companyBasicInfo.setRegistrationId(company.getReg());
                companyBasicInfo.setUrl(company.getWebsite());
                companyBasicInfo.setLocalEn(company.getCityEN() + "/" + company.getProvinceEN());
                companyBasicInfo.setProductIntroductionEn(company.getProductLabel());
                companyBasicInfo.setServicesIntroductionEn(company.getIntroduction());
                companyBasicInfo.setAboutUsEn(company.getIntroduction());
                ResponseResult<CityInfo> cityInfo = countryInfoService.findCityInfoEN(company.getCityEN());
                map.addAttribute("city", cityInfo.getContent());
                ResponseResult<ProvinceInfo> provinceInfo = countryInfoService.findProvinceInfoEN(company.getProvinceEN());
                map.addAttribute("province", provinceInfo.getContent());
                map.addAttribute("companyBasicInfo",companyBasicInfo);
            }
        }
        if (customer!=null){
            if (typeId!=null) {
                if (typeId.equals("Companies")) {
                    QueryENByName queryENByName2 = new QueryENByName();
                    queryENByName2.setNameEN(cnId);
                    BootGrid<Company> grid = companyIndexService.fillCompanyIndexSimpleENByName(queryENByName2);
                    if (grid.getResult()) {
                        for (int i = 0; i < grid.getRows().size(); i++) {
                            if (companyName.equals(grid.getRows().get(i).getNameEN())) {
                                grid.getRows().remove(i);
                                break;
                            }
                        }
                        map.addAttribute("cn", grid.getRows());
                        map.addAttribute("typeId",typeId);
                        map.addAttribute("cnId",cnId);
                    }
                } else {
                    QueryENByProduct queryENByProduct = new QueryENByProduct();
                    queryENByProduct.setProductLabel(cnId);
                    BootGrid<Company> grid = companyIndexService.fillCompanyIndexSimpleENByProduct(queryENByProduct);
                    if (grid.getResult()) {
                        for (int i = 0; i < grid.getRows().size(); i++) {
                            if (companyName.equals(grid.getRows().get(i).getNameEN())) {
                                grid.getRows().remove(i);
                                break;
                            }
                        }
                        map.addAttribute("cn", grid.getRows());
                        map.addAttribute("typeId",typeId);
                        map.addAttribute("cnId",cnId);
                    }
                }
            }
        }

        map.put("report", fullReport);
        map.addAttribute("products", productBootGrid);
        map.addAttribute("crefoNo", crefoNo);
        map.addAttribute("companyName", companyName);
        map.addAttribute("companyNameCN", companyNameCN);
        map.addAttribute("a", a);
        map.addAttribute("v", v);
        map.addAttribute("stockCode", stockCode);
        map.addAttribute("status", status);
        return "user/report";
    }

    /**
     * fullsearch
     * 报告
     *
     * @param map
     * @param orderDetailId
     * @return
     * @throws Exception
     */
    @RequestMapping("/customer/openReport.do")
    public String openReport(HttpServletRequest request, ModelMap map, String orderDetailId) throws Exception {
        logger.info("跳转报告页面...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        BootGrid<Product> productBootGrid = new BootGrid<>();
        OrderDetailViewQuery orderDetailViewQuery = new OrderDetailViewQuery();
        Product product = new Product();
        product.setSource((byte) 2);//来源全搜
        product.setProductType((byte) 1);//中国报告
        ResponseResult<OrderDetail> responseResult = orderService.findOrderDetailByIdWithData(Long.parseLong(orderDetailId));
        OrderDetail orderDetail = responseResult.getContent();
        map.addAttribute("orderDetail", orderDetail);
        orderDetailViewQuery.setCustomerId(customer.getId());
        map.addAttribute("customerId", customer.getId());
        Collection collection = new Collection();
        collection.setCustomerId(customer.getId());
        if (orderDetail!=null){
                collection.setCollectionCompany(orderDetail.getCompanyName());
                ResponseResult<Collection> responseResult1 = collectionService.getCollectionByCidAndCname(collection);
                if (responseResult1.getContent() != null) {
                    map.addAttribute("collectionCompany", responseResult1.getContent().getCollectionCompany());
                }
            orderDetailViewQuery.setCompanyName(orderDetail.getCompanyName());
            map.addAttribute("companyName",orderDetail.getCompanyName());
            ResponseResult<Orders> ordersResponseResult = orderService.findOrdersById(orderDetail.getOrderId());
            map.addAttribute("order", ordersResponseResult.getContent());
            map.addAttribute("companyNo",orderDetail.getCompanyNo());
            productBootGrid = productService.findCustomerProducts(productBootGrid, orderDetailViewQuery, product);
            if (orderDetail.getData() == null || orderDetail.getData().equals("")) {
                map.addAttribute("message", false);
            } else {
                Map<String, Object> jsonResult = JSON.parseObject(orderDetail.getData(), Map.class);
                map.putAll(jsonResult);
                QueryENByName queryENByName = new QueryENByName();
                queryENByName.setNameEN(orderDetail.getCompanyName());
                BootGrid<Company> bootGrid = companyIndexService.fillCompanyIndexSimpleENByName(queryENByName);
                if (bootGrid.getResult()) {
                    List<Company> rows = bootGrid.getRows();
                    if (rows.size() > 0) {
                        CompanyBasicInfo companyBasicInfo = new CompanyBasicInfo();
                        Company company = rows.get(0);
                        companyBasicInfo.setCompanyNameEn(responseResult.getContent().getCompanyName());
                        companyBasicInfo.setCompanyName(company.getNameCN());
                        companyBasicInfo.setRegistrationId(company.getReg());
                        companyBasicInfo.setUrl(company.getWebsite());
                        companyBasicInfo.setLocalEn(company.getCityEN() + "/" + company.getProvinceEN());
                        companyBasicInfo.setProductIntroductionEn(company.getProductLabel());
                        companyBasicInfo.setServicesIntroductionEn(company.getIntroduction());
                        companyBasicInfo.setAboutUsEn(company.getIntroduction());
                        ResponseResult<CityInfo> cityInfo = countryInfoService.findCityInfoEN(company.getCityEN());
                        map.addAttribute("city", cityInfo.getContent());
                        ResponseResult<ProvinceInfo> provinceInfo = countryInfoService.findProvinceInfoEN(company.getProvinceEN());
                        map.addAttribute("province", provinceInfo.getContent());
                        map.addAttribute("companyBasicInfo",companyBasicInfo);
                        map.addAttribute("crefoNo",company.getCrefoNo());
                    }
                }

                Object ktggList = jsonResult.get("ktggList");
                if (StringUtil.isNotNull(ktggList)){
                    Map<String, Integer> sortTimeCount = new HashMap<>();
                    JSONArray ktggs = JSON.parseArray(ktggList.toString());
                    for (Object ktgg : ktggs) {
                        JSONObject kt = JSON.parseObject(ktgg.toString());
                        String ktggSortTime = kt.getString("sortTime");
                        if (ktggSortTime != null && ktggSortTime != "" && ktggSortTime.contains("-")) {
                            String ktggSubSortTime = ktggSortTime.substring(0, ktggSortTime.indexOf("-"));
                            if (ktggSubSortTime.equals("2017")) {
                                sortTimeCount.put("Ktgg2017", sortTimeCount.get(ktggSubSortTime) == null ? 1 : sortTimeCount.get(ktggSubSortTime) + 1);
                            }
                            if (ktggSubSortTime.equals("2016")) {
                                sortTimeCount.put("Ktgg2016", sortTimeCount.get(ktggSubSortTime) == null ? 1 : sortTimeCount.get(ktggSubSortTime) + 1);
                            }
                            if (ktggSubSortTime.equals("2015")) {
                                sortTimeCount.put("Ktgg2015", sortTimeCount.get(ktggSubSortTime) == null ? 1 : sortTimeCount.get(ktggSubSortTime) + 1);
                            }
                        }
                    }
                    map.putAll(sortTimeCount);
                }


                Object cpwsList = jsonResult.get("rulingdocumentsList");
                if (StringUtil.isNotNull(cpwsList)) {
                    Map<String, Integer> sortTimeCpws = new HashMap<>();
                    JSONArray cpwss = JSON.parseArray(cpwsList.toString());
                    for (Object cpws : cpwss) {
                        JSONObject cp = JSON.parseObject(cpws.toString());
                        String cpwsSortTime = cp.getString("sortTime");
                        if (cpwsSortTime != null && cpwsSortTime != "" && cpwsSortTime.contains("-")) {
                            String cpwsSubSortTime = cpwsSortTime.substring(0, cpwsSortTime.indexOf("-"));
                            if (cpwsSubSortTime.equals("2017")) {
                                sortTimeCpws.put("Cpws2017", sortTimeCpws.get(cpwsSubSortTime) == null ? 1 : sortTimeCpws.get(cpwsSubSortTime) + 1);
                            }
                            if (cpwsSubSortTime.equals("2016")) {
                                sortTimeCpws.put("Cpws2016", sortTimeCpws.get(cpwsSubSortTime) == null ? 1 : sortTimeCpws.get(cpwsSubSortTime) + 1);
                            }
                            if (cpwsSubSortTime.equals("2015")) {
                                sortTimeCpws.put("Cpws2015", sortTimeCpws.get(cpwsSubSortTime) == null ? 1 : sortTimeCpws.get(cpwsSubSortTime) + 1);
                            }
                        }
                    }
                    map.putAll(sortTimeCpws);
                }


                Object zxggList = jsonResult.get("executiveList");
                if (StringUtil.isNotNull(zxggList)) {
                    Map<String, Integer> sortTimeZxgg = new HashMap<>();
                    JSONArray zxggs = JSON.parseArray(zxggList.toString());
                    for (Object zxgg : zxggs) {
                        JSONObject zx = JSON.parseObject(zxgg.toString());
                        String zxggSortTime = zx.getString("sortTime");
                        if (zxggSortTime != null && zxggSortTime != "" && zxggSortTime.contains("-")) {
                            String zxggSubSortTime = zxggSortTime.substring(0, zxggSortTime.indexOf("-"));
                            if (zxggSubSortTime.equals("2017")) {
                                sortTimeZxgg.put("Zxgg2017", sortTimeZxgg.get(zxggSubSortTime) == null ? 1 : sortTimeZxgg.get(zxggSubSortTime) + 1);
                            }
                            if (zxggSubSortTime.equals("2016")) {
                                sortTimeZxgg.put("Zxgg2016", sortTimeZxgg.get(zxggSubSortTime) == null ? 1 : sortTimeZxgg.get(zxggSubSortTime) + 1);
                            }
                            if (zxggSubSortTime.equals("2015")) {
                                sortTimeZxgg.put("Zxgg2015", sortTimeZxgg.get(zxggSubSortTime) == null ? 1 : sortTimeZxgg.get(zxggSubSortTime) + 1);
                            }
                        }
                    }
                    map.putAll(sortTimeZxgg);
                }


                Object sxggList = jsonResult.get("sxggList");
                if (StringUtil.isNotNull(sxggList)) {
                    Map<String, Integer> sortTimeSxgg = new HashMap<>();
                    JSONArray sxggs = JSON.parseArray(sxggList.toString());
                    for (Object sxgg : sxggs) {
                        JSONObject sx = JSON.parseObject(sxgg.toString());
                        String sxggSortTime = sx.getString("sortTime");
                        if (sxggSortTime != null && sxggSortTime != "" && sxggSortTime.contains("-")) {
                            String sxggSubSortTime = sxggSortTime.substring(0, sxggSortTime.indexOf("-"));
                            if (sxggSubSortTime.equals("2017")) {
                                sortTimeSxgg.put("Sxgg2017", sortTimeSxgg.get(sxggSubSortTime) == null ? 1 : sortTimeSxgg.get(sxggSubSortTime) + 1);
                            }
                            if (sxggSubSortTime.equals("2016")) {
                                sortTimeSxgg.put("Sxgg2016", sortTimeSxgg.get(sxggSubSortTime) == null ? 1 : sortTimeSxgg.get(sxggSubSortTime) + 1);
                            }
                            if (sxggSubSortTime.equals("2015")) {
                                sortTimeSxgg.put("Sxgg2015", sortTimeSxgg.get(sxggSubSortTime) == null ? 1 : sortTimeSxgg.get(sxggSubSortTime) + 1);
                            }
                        }
                    }
                    map.putAll(sortTimeSxgg);
                }

//                Object financialStatementList=jsonResult.get("financialStatementList");
//                if (StringUtil.isNotNull(financialStatementList)){
//                    HashMap<String, List> objectObjectHashMap = new HashMap<>();
//                    JSONArray fss = JSON.parseArray(financialStatementList.toString());
//                    for (Object fs:fss) {
//                        JSONObject f=JSON.parseObject(fs.toString());
//
//                    }
//                }

//                List list=new ArrayList();
//                list.addAll(ktggs);
//                list.addAll(cpwss);
//                list.addAll(zxggs);
//                list.addAll(sxggs);
//                map.addAttribute("list",list);
            }
        }
        map.addAttribute("products", productBootGrid);
        return "customer/report";
    }
//    public static String formatMoney(String value) throws Exception{
//        try {
//            if(value != null && value.length()!=0 && !value.trim().equals("") && !value.trim().equals("null")){
//                boolean bool = value.contains(".");
//                Double b = Double.parseDouble(value.trim());
//                BigDecimal a = new BigDecimal(b);
//                DecimalFormat format = null ;
//                if(bool){
//                    format = new DecimalFormat("##,###,###,###,###,###.00");
//                }else{
//                    format = new DecimalFormat("##,###,###,###,###,###");
//                }
//                value=format.format(a);
//                return value;
//            }else{
//                return " ";
//            }
//        } catch (Exception e) {
//            throw new Exception("格式化数值有问题-"+value);
//        }
//    }

    public static String isNull(String str) {
        if (str != null && !"".equals(str.trim())) {
            return str;
        } else if (str == null || "".equals(str.trim())) {
            return "-";
        } else {
            return "-";
        }
    }

}
