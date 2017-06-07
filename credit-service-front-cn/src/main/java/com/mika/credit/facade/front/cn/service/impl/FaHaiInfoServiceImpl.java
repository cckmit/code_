package com.mika.credit.facade.front.cn.service.impl;


import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.HttpUtil;
import com.mika.credit.facade.front.cn.common.ProAccounts;
import com.mika.credit.facade.front.cn.dao.FaHaiDao;
import com.mika.credit.facade.front.cn.service.FaHaiInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mike on 2016/12/9.
 */
@Service("faHaiInfoService")
public class FaHaiInfoServiceImpl implements FaHaiInfoService {

    private static Logger logger = Logger.getLogger(FaHaiInfoServiceImpl.class);

    @Autowired
    private FaHaiDao faHaiDao;


   /* @Override
    public ResponseResult<String> getFahaiData(String method, Map param) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        logger.debug("fhQueryOrder start");
        int histoyDay = Constant.faHaiExpiry ;
        FaHai faHai = new FaHai();
        if( param == null || param.equals("")||method == null || method.equals("") ){
            logger.debug("传参错误");
            logger.debug("fhQueryOrder 返回结果:");
            logger.debug("fhQueryOrder end");
            logger.info("向法海发送数据失败,参数错误");
            responseResult.setCode(false);
            responseResult.setMsg("向法海发送数据失败,参数错误");
            return responseResult;
        }
        logger.debug("fhQueryOrder 参数:" + param.toString());
        if(method.equals("query")){
            method = "fahaiQueryUrl";
        }
        else if(method.equals("entry")){
            method = "fahaiEntryUrl";
        }
        else if(method.equals("person")){
            method = "fahaiPersonUrl";
        }
        StringBuilder url = new StringBuilder();
        if(param.get("q")!=null && !param.get("q").equals("")){
            url.append("&q=" + param.get("q"));
        }
        if(param.get("datatype")!=null && !param.get("datatype").equals("")){
            url.append("&datatype=" + param.get("datatype"));
        }
        if(param.get("id")!=null && !param.get("id").equals("")){
            url.append("&id=" + param.get("id"));
        }
        if(param.get("pageno")!=null && !param.get("pageno").equals("")){
            url.append("&pageno=" + param.get("pageno"));
        }
        if(param.get("searchType")!=null && !param.get("searchType").equals("")){
            url.append("&searchType=" + param.get("searchType"));
        }
        if(param.get("range")!=null && !param.get("range").equals("")){
            url.append("&range=" + param.get("range"));
        }
        if(param.get("pname")!=null && !param.get("pname").equals("")){
            url.append("&pname=" + param.get("pname"));
        }
        if(param.get("idcardNo")!=null && !param.get("idcardNo").equals("")){
            url.append("&idcardNo=" + param.get("idcardNo"));
        }
        String strUrl = url.toString();
        //查询数据库中记录
        faHai = faHaiDao.findByCompanyName(url.toString());
        if (faHai == null) {
            logger.debug("MySql : 本地没有" +  strUrl + " 相关的数据");
            //开始Web查询
            String requestJson = null;
            Map<String, String> map = new HashMap<String, String>();
            map.put("companyName", strUrl);
            map.put("method", method);
            requestJson = JSON.toJSONString(map);
            String sendBack = sendfahaiDataOrderData(map);
            if (sendBack==null || sendBack.equals("") || sendBack.contains("\"code\":\"e\"")){
                logger.info("订单查询没有返回数据或者调用接口参数错误");
                responseResult.setCode(false);
                responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
            }else{
                //插入数据记录
                faHai = new FaHai();
                // 插入数据
                faHai.setCompanyName(faHai.getCompanyName());
//                    faHai.setUrl(mapResult.get("url"));
                faHai.setResponseJson(sendBack);
                faHai.setRequestJson(requestJson);
                faHai.setIp(faHai.getIp());
                faHai.setCreateTime(new Date());
                faHai.setUpdateTime(new Date());
                faHai.setRequestTime(new Date());
                faHaiDao.insert(faHai);
                logger.debug("前海本地库 " +  " " + faHai.getCompanyName() + " 添加成功");
                responseResult.setCode(true);
                responseResult.setContent(sendBack);
            }
        } else {
            logger.debug("过期时间:" + ProAccounts.getCalculateDate(faHai.getRequestTime()));
            if (histoyDay < ProAccounts.getCalculateDate(faHai.getRequestTime())) {
                //开始Web查询
                JSONObject requestJson = null;
                Map<String, String> map = new HashMap<String, String>();
                map.put("companyName", faHai.getCompanyName());
                map.put("method", method);
                requestJson = JSONObject.parseObject(String.valueOf(map));
                String sendBack = sendfahaiDataOrderData(map);
                if (sendBack==null || sendBack.equals("") || sendBack.contains("\"code\":\"e\"")){
                    logger.info("订单查询没有返回数据或者调用接口参数错误");
                    responseResult.setCode(false);
                    responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
                }else{
                    //更新数据记录
                    faHai.setCompanyName(faHai.getCompanyName());
//                        faHai.setUrl(mapResult.get("url"));
                    faHai.setResponseJson(sendBack);
                    faHai.setIp(faHai.getIp());
                    faHai.setUpdateTime(new Date());
                    faHaiDao.insert(faHai);
                    logger.debug("前海本地库 " +  " " + faHai.getCompanyName() + " 更新成功");
                    responseResult.setCode(true);
                    responseResult.setContent(sendBack);
                }
            } else{
                responseResult.setCode(true);
                responseResult.setContent(faHai.getResponseJson());
                logger.info("前海订单"+" "+faHai.getCompanyName()+"发送提交成功,返回结果:"+responseResult.getContent());
            }
        }
        logger.debug("fhSendOrder 返回结果:" + responseResult.getContent());
        logger.debug("fhSendOrder end");
        //logger.info("格兰德订单" + cur.getSaxNum() + " " + cur.getComName() + "操作成功,本地库是新数据所以不需要更新,返回结果:" + outTxt);
        return responseResult;
    }*/


    public ResponseResult<String> getFaHaiData(String companyName, String method) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        if(companyName!=null || !"".equals(companyName) && method!=null || !"".equals(method)) {
            Map<String, String> params = new HashMap<>();
            params.put("companyName", companyName);
            params.put("method", method);
            logger.debug("getgetFaHaiData start");

            String sendBack = sendfahaiDataOrderData(params);
            if (sendBack == null) {
                responseResult.setCode(false);
                responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
                logger.info("订单查询没有返回数据或者调用接口参数错误");
            } else {
                responseResult.setCode(true);
                responseResult.setContent(sendBack);
                logger.info("法海本地库 " + companyName + " 添加成功,并且获取最新数据");
            }
        }else {
            responseResult.setCode(false);
            responseResult.setMsg("参数错误");
            logger.info("参数错误");
        }
        logger.debug("getFaHaiData end");
        return responseResult;
    }

    //调外部接口
    public String sendfahaiDataOrderData(Map<String, String> param){
        StringBuilder url = new StringBuilder();
        if(param.get("datatype")!=null && !param.get("datatype").equals("")){
            url.append("&datatype=" + param.get("datatype"));
        }
        if(param.get("id")!=null && !param.get("id").equals("")){
            url.append("&id=" + param.get("id"));
        }
        if(param.get("pageno")!=null && !param.get("pageno").equals("")){
            url.append("&pageno=" + param.get("pageno"));
        }
        if(param.get("searchType")!=null && !param.get("searchType").equals("")){
            url.append("&searchType=" + param.get("searchType"));
        }
        if(param.get("range")!=null && !param.get("range").equals("")){
            url.append("&range=" + param.get("range"));
        }
        if(param.get("pname")!=null && !param.get("pname").equals("")){
            url.append("&pname=" + param.get("pname"));
        }
        if(param.get("idcardNo")!=null && !param.get("idcardNo").equals("")){
            url.append("&idcardNo=" + param.get("idcardNo"));
        }
        String strUrl = url.toString();
        Map<String, String> map = new HashMap<String, String>();
        map.put("companyName", strUrl);
        map.put("method", "query");

        logger.debug("sendFHOrderData start");
        logger.debug("sendFHOrderData 参数 " + map);
        if(map.get("companyName")==null || map.get("companyName").equals("") || map.get("method")==null || map.get("method").equals("")){
            logger.debug("sendFHOrderData 参数 错误");
            return null;
        }
        String faurl = null ;
        Map<String,String> security = ProAccounts.getFhMap();
        String method = map.get("method");
        //通过Web Curl获得此记录
        faurl = security.get(method)+"?authCode="+security.get("fahaiAuthCode")+"&"+map.get("companyName");
        String strContext = HttpUtil.syncData(faurl);
        logger.debug("请求前海查询订单返回值 = " + strContext);
        return strContext;
    }


}
