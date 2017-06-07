package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.HttpUtil;
import com.mika.credit.facade.front.cn.common.Constant;
import com.mika.credit.facade.front.cn.common.ProAccounts;
import com.mika.credit.facade.front.cn.service.GrandeInfoService;
import com.mika.credit.facade.front.cn.util.Tool;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by Mike on 2016/12/9.
 */
@Service("grandeInfoService")
public class GrandeInfoServiceImpl implements GrandeInfoService {

    private static Logger logger = Logger.getLogger(GrandeInfoServiceImpl.class);

//    @Autowired
//    GrandeOrgDataDao grandeOrgDataDao;
//
//    @Autowired
//    GrandeOrgDataDaoV2 grandeOrgDataDaoV2;
//
//    @Autowired
//    GrandeSifaDataDao grandeSifaDataDao;

//    @Override
//    public ResponseResult<String> grandeOrgData(String companyName) {
//        ResponseResult<String> responseResult = new ResponseResult<>();
//        logger.debug("grandeOrgData start");
//        //数据过期时间
       int histoyDay = Constant.grandeOrgDataExpiry;
//        if( companyName == null || companyName.equals("") ){
//            responseResult.setCode(false);
//            responseResult.setMsg("向法海发送数据失败,参数错误");
//            logger.info("向法海发送数据失败,参数错误");
//            logger.debug("grandeOrgData end");
//            return responseResult;
//        }
//        logger.debug("grandeOrgData 参数:" + companyName);
//        GrandeOrgData grandeOrgData = null;
//        grandeOrgData = grandeOrgDataDao.findByCompanyName(companyName);
//        if (grandeOrgData == null) {
//            logger.debug("MySql : 本地没有" + companyName + " 相关的数据");
//            //开始Web查询
//            String sendBack = sendGLDOrgData(companyName);
//            if (sendBack==null || sendBack.equals("") || sendBack.contains("\"code\":\"0\"")){
//                responseResult.setCode(false);
//                responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
//                logger.info("订单查询没有返回数据或者调用接口参数错误");
//            }else{
//                //插入数据记录
//                grandeOrgData = new GrandeOrgData();
//                // 插入数据
//                grandeOrgData.setCompanyName(companyName);
////                    faHai.setUrl(mapResult.get("url"));
//                grandeOrgData.setResponseJson(sendBack);
//                grandeOrgData.setCreateTime(new Date());
//                grandeOrgData.setUpdateTime(new Date());
//                grandeOrgData.setRequestTime(new Date());
//                grandeOrgDataDao.save(grandeOrgData);
//                responseResult.setCode(true);
//                responseResult.setContent(sendBack);
//                logger.info("前海本地库 " + companyName + " 添加成功,并且获取最新数据");
//            }
//        } else {
//            logger.debug("过期时间计算结果:" + ProAccounts.getCalculateDate(grandeOrgData.getRequestTime()));
//            if (histoyDay < ProAccounts.getCalculateDate(grandeOrgData.getRequestTime())) {
//                //开始Web查询
//                String sendBack = sendGLDOrgData(companyName);
//                if (sendBack==null){
//                    responseResult.setCode(false);
//                    responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
//                    logger.info("订单查询没有返回数据或者调用接口参数错误");
//                }else{
//                    //更新数据记录
//                    grandeOrgData.setCompanyName(companyName);
//                    grandeOrgData.setResponseJson(sendBack);
//                    grandeOrgData.setCreateTime(new Date());
//                    grandeOrgData.setUpdateTime(new Date());
//                    grandeOrgData.setRequestTime(new Date());
//                    grandeOrgDataDao.save(grandeOrgData);
//                    responseResult.setCode(true);
//                    responseResult.setContent(sendBack);
//                    logger.info("前海本地库 " + companyName + " 更新成功,并且获取最新数据");
//                }
//            }
//            else{
//                //数据库中数据没有过期
//                responseResult.setCode(true);
//                responseResult.setContent(grandeOrgData.getResponseJson());
//                logger.info("数据没有过期,获取数据库中缓存数据");
//            }
//        }
//        logger.debug("grandeOrgData end");
//        return responseResult;
//    }

    public String sendGLDOrgData(String companyName){
        companyName = Tool.replaceSymbolCN(companyName);
        logger.debug("sendGLDOrgData start");
        logger.debug("sendGLDOrgData 参数 " + companyName);
        if(companyName==null || companyName.equals("")){
            logger.debug("sendGLDOrgData 参数 错误");
            return null;
        }
        Map<String,String> map = ProAccounts.getGldMap();
        String key =  map.get("grandeKey") ;
        String baseUurl = map.get("grandeOrgDataUrl");
        //通过Web Curl获得此记录
        String url = baseUurl+"?appToken="+ key +"&parameters="+ URLEncoder.encode("{\"orgName\":\"" + companyName+ "\"}");
        String strContext = HttpUtil.syncData(url);
        logger.debug("请求格兰德查询订单返回值 = " + strContext);
        logger.debug("sendGLDOrgData end");
        return strContext;
    }

//    @Override
//    public ResponseResult<String> grandeOrgDataV2(String companyName) {
//        ResponseResult<String> responseResult = new ResponseResult<>();
//        logger.debug("grandeOrgDataV2 start");
//        //数据过期时间
//        int histoyDay = Constant.grandeOrgDataV2Expiry;
//        if( companyName == null || companyName.equals("") ){
//            responseResult.setCode(false);
//            responseResult.setMsg("向法海发送数据失败,参数错误");
//            logger.info("向法海发送数据失败,参数错误");
//            logger.debug("grandeOrgDataV2 end");
//            return responseResult;
//        }
//        logger.debug("grandeOrgDataV2 参数:" + companyName);
//        GrandeOrgDataV2 grandeOrgDataV2 = null;
//        grandeOrgDataV2 = grandeOrgDataDaoV2.findByCompanyName(companyName);
//        if (grandeOrgDataV2 == null) {
//            logger.debug("MySql : 本地没有" + companyName + " 相关的数据");
//            //开始Web查询
//            String sendBack = sendGLDOrgDataV2(companyName);
//            if (sendBack==null || sendBack.equals("") || sendBack.contains("\"code\":\"0\"")){
//                responseResult.setCode(false);
//                responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
//                logger.info("订单查询没有返回数据或者调用接口参数错误");
//            }else{
//                //插入数据记录
//                grandeOrgDataV2 = new GrandeOrgDataV2();
//                // 插入数据
//                grandeOrgDataV2.setCompanyName(companyName);
////                    faHai.setUrl(mapResult.get("url"));
//                grandeOrgDataV2.setResponseJson(sendBack);
//                grandeOrgDataV2.setCreateTime(new Date());
//                grandeOrgDataV2.setUpdateTime(new Date());
//                grandeOrgDataV2.setRequestTime(new Date());
//                grandeOrgDataDaoV2.save(grandeOrgDataV2);
//                responseResult.setCode(true);
//                responseResult.setContent(sendBack);
//                logger.info("前海本地库 " + companyName + " 添加成功,并且获取最新数据");
//            }
//        } else {
//            logger.debug("过期时间计算结果:" + ProAccounts.getCalculateDate(grandeOrgDataV2.getRequestTime()));
//            if (histoyDay < ProAccounts.getCalculateDate(grandeOrgDataV2.getRequestTime())) {
//                //开始Web查询
//                String sendBack = sendGLDOrgData(companyName);
//                if (sendBack==null){
//                    responseResult.setCode(false);
//                    responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
//                    logger.info("订单查询没有返回数据或者调用接口参数错误");
//                }else{
//                    //更新数据记录
//                    grandeOrgDataV2.setCompanyName(companyName);
//                    grandeOrgDataV2.setResponseJson(sendBack);
//                    grandeOrgDataV2.setCreateTime(new Date());
//                    grandeOrgDataV2.setUpdateTime(new Date());
//                    grandeOrgDataV2.setRequestTime(new Date());
//                    grandeOrgDataDaoV2.save(grandeOrgDataV2);
//                    responseResult.setCode(true);
//                    responseResult.setContent(sendBack);
//                    logger.info("前海本地库 " + companyName + " 更新成功,并且获取最新数据");
//                }
//            }
//            else{
//                //数据库中数据没有过期
//                responseResult.setCode(true);
//                responseResult.setContent(grandeOrgDataV2.getResponseJson());
//                logger.info("数据没有过期,获取数据库中缓存数据");
//            }
//        }
//        logger.debug("grandeOrgDataV2 end");
//        return responseResult;
//    }

    public String sendGLDOrgDataV2(String companyName){
        logger.debug("sendGLDOrgDataV2 start");
        logger.debug("sendGLDOrgDataV2 参数 " + companyName);
        if(companyName==null && companyName.equals("")){
            logger.debug("sendGLDOrgDataV2 参数 错误");
            return null;
        }
        Map<String,String> map = ProAccounts.getGldMap();
        String key =  map.get("grandeKey") ;
        String baseUurl = map.get("grandeOrgDataV2Url");
        //通过Web Curl获得此记录
        String url = baseUurl+"?appToken="+ key +"&parameters="+ URLEncoder.encode("{\"orgName\":\"" + companyName+ "\"}");
        String strContext = HttpUtil.syncData(url);
        logger.debug("请求格兰德查询订单返回值 = " + strContext);
        logger.debug("sendGLDOrgDataV2 end");
        return strContext;
    }

//    @Override
//    public ResponseResult<String> grandeSifaData(String companyName) {
//        ResponseResult<String> responseResult = new ResponseResult<>();
//        logger.debug("grandeSifaData start");
//        //数据过期时间
//        int histoyDay = Constant.grandeSifaDataExpiry;
//        if( companyName == null || companyName.equals("") ){
//            responseResult.setCode(false);
//            responseResult.setMsg("向法海发送数据失败,参数错误");
//            logger.info("向法海发送数据失败,参数错误");
//            logger.debug("grandeSifaData end");
//            return responseResult;
//        }
//        logger.debug("grandeSifaData 参数:" + companyName);
//        GrandeSifaData grandeSifaData = null;
//        grandeSifaData = grandeSifaDataDao.findByCompanyName(companyName);
//        if (grandeSifaData == null) {
//            logger.debug("MySql : 本地没有" + companyName + " 相关的数据");
//            //开始Web查询
//            String sendBack = sendGLDSifaData(companyName);
//            if (sendBack==null || sendBack.equals("") || sendBack.contains("\"code\":\"0\"")){
//                responseResult.setCode(false);
//                responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
//                logger.info("订单查询没有返回数据或者调用接口参数错误");
//            }else{
//                //插入数据记录
//                grandeSifaData = new GrandeSifaData();
//                // 插入数据
//                grandeSifaData.setCompanyName(companyName);
////                    faHai.setUrl(mapResult.get("url"));
//                grandeSifaData.setResponseJson(sendBack);
//                grandeSifaData.setCreateTime(new Date());
//                grandeSifaData.setUpdateTime(new Date());
//                grandeSifaData.setRequestTime(new Date());
//                grandeSifaDataDao.save(grandeSifaData);
//                responseResult.setCode(true);
//                responseResult.setContent(sendBack);
//                logger.info("前海本地库 " + companyName + " 添加成功,并且获取最新数据");
//            }
//        } else {
//            logger.debug("过期时间计算结果:" + ProAccounts.getCalculateDate(grandeSifaData.getRequestTime()));
//            if (histoyDay < ProAccounts.getCalculateDate(grandeSifaData.getRequestTime())) {
//                //开始Web查询
//                String sendBack = sendGLDOrgData(companyName);
//                if (sendBack==null){
//                    responseResult.setCode(false);
//                    responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
//                    logger.info("订单查询没有返回数据或者调用接口参数错误");
//                }else{
//                    //更新数据记录
//                    grandeSifaData.setCompanyName(companyName);
//                    grandeSifaData.setResponseJson(sendBack);
//                    grandeSifaData.setCreateTime(new Date());
//                    grandeSifaData.setUpdateTime(new Date());
//                    grandeSifaData.setRequestTime(new Date());
//                    grandeSifaDataDao.save(grandeSifaData);
//                    responseResult.setCode(true);
//                    responseResult.setContent(sendBack);
//                    logger.info("前海本地库 " + companyName + " 更新成功,并且获取最新数据");
//                }
//            }
//            else{
//                //数据库中数据没有过期
//                responseResult.setCode(true);
//                responseResult.setContent(grandeSifaData.getResponseJson());
//                logger.info("数据没有过期,获取数据库中缓存数据");
//            }
//        }
//        logger.debug("grandeSifaData end");
//        return responseResult;
//
//    }


    public ResponseResult<String> getGrandeData(String companyName) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        logger.debug("getGrandeData start");
        if (companyName==null||"".equals(companyName)){
                responseResult.setCode(false);
                responseResult.setMsg("参数错误");
                logger.info("参数错误");
        }else {
            String sendBack = sendGLDSifaData(companyName);
            if (sendBack == null) {
                responseResult.setCode(false);
                responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
                logger.info("订单查询没有返回数据或者调用接口参数错误");
            } else {
                responseResult.setCode(true);
                responseResult.setContent(sendBack);
                logger.info("格兰德本地库 " + companyName + " 添加成功,并且获取最新数据");
            }
        }
        logger.debug("getGrandeData end");
        return responseResult;
    }



    public String sendGLDSifaData(String companyName){
        logger.debug("sendGLDSifaData start");
        logger.debug("sendGLDSifaData 参数 " + companyName);
        if(companyName==null && companyName.equals("")){
            logger.debug("sendGLDSifaData 参数 错误");
            return null;
        }
        Map<String,String> map = ProAccounts.getGldMap();
        String key =  map.get("grandeKey") ;
        String baseUurl = map.get("grandeSifaDataUrl");
        //通过Web Curl获得此记录
        String url = baseUurl+"?appToken="+ key +"&parameters="+ URLEncoder.encode("{\"orgName\":\"" + companyName+ "\"}");
        String strContext = HttpUtil.syncData(url);
        logger.debug("请求格兰德查询订单返回值 = " + strContext);
        logger.debug("sendGLDSifaData end");
        return strContext;
    }



}
