package com.mika.credit.facade.front.cn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.front.cn.common.ProAccounts;
import com.mika.credit.facade.front.cn.service.QianHaiInfoService;
import com.mika.credit.facade.front.cn.util.qianhai.DataSecurityUtil;
import com.mika.credit.facade.front.cn.util.qianhai.HttpRequestUtil;
import com.mika.credit.facade.front.cn.util.qianhai.MessageUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Mike on 2016/12/9.
 */
@Service("qianHaiInfoService")
public class QianHaiInfoServiceImpl implements QianHaiInfoService {

    private static Logger logger = Logger.getLogger(QianHaiInfoServiceImpl.class);

//    @Autowired
//    QianHaiDao qianHaiDao;
//
//    @Override
//    public ResponseResult<String> getQianHaiData(String companyName, String crefoNo) {
//
//        ResponseResult<String> responseResult = new ResponseResult<>();
//        logger.debug("getQianHaiData start");
//        //数据过期时间
//        int histoyDay = Constant.qianhaiDataExpiry;
//        if( companyName == null || companyName.equals("") ){
//            responseResult.setCode(false);
//            responseResult.setMsg("向法海发送数据失败,参数错误");
//            logger.info("向法海发送数据失败,参数错误");
//            logger.debug("getQianHaiData end");
//            return responseResult;
//        }
//        logger.debug("getQianHaiData 参数 : companyName = " + companyName + "crefoNo = "+crefoNo);
//        QianHai qianHai = null;
//        qianHai = qianHaiDao.findByCompanyName(companyName);
//        if (qianHai == null) {
//            logger.debug("MySql : 本地没有" + companyName + " 相关的数据");
//            //开始Web查询
//            String sendBack = sendQianHaiData(companyName,crefoNo);
//            if (sendBack==null){
//                responseResult.setCode(false);
//                responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
//                logger.info("订单查询没有返回数据或者调用接口参数错误");
//            }else{
//                //插入数据记录
//                qianHai = new QianHai();
//                // 插入数据
//                qianHai.setCompanyName(companyName);
////                    faHai.setUrl(mapResult.get("url"));
//                qianHai.setResponseJson(sendBack);
//                qianHai.setCreateTime(new Date());
//                qianHai.setUpdateTime(new Date());
//                qianHai.setRequestTime(new Date());
//                qianHaiDao.save(qianHai);
//                responseResult.setCode(true);
//                responseResult.setContent(sendBack);
//                logger.info("前海本地库 " + companyName + " 添加成功,并且获取最新数据");
//            }
//        } else {
//            logger.debug("过期时间计算结果:" + ProAccounts.getCalculateDate(qianHai.getRequestTime()));
//            if (histoyDay < ProAccounts.getCalculateDate(qianHai.getRequestTime())) {
//                //开始Web查询
//                String sendBack = sendQianHaiData(companyName,crefoNo);
//                if (sendBack==null){
//                    responseResult.setCode(false);
//                    responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
//                    logger.info("订单查询没有返回数据或者调用接口参数错误");
//                }else{
//                    //更新数据记录
//                    qianHai.setCompanyName(companyName);
//                    qianHai.setResponseJson(sendBack);
//                    qianHai.setCreateTime(new Date());
//                    qianHai.setUpdateTime(new Date());
//                    qianHai.setRequestTime(new Date());
//                    qianHaiDao.save(qianHai);
//                    responseResult.setCode(true);
//                    responseResult.setContent(sendBack);
//                    logger.info("前海本地库 " + companyName + " 更新成功,并且获取最新数据");
//                }
//            }
//            else{
//                //数据库中数据没有过期
//                responseResult.setCode(true);
//                responseResult.setContent(qianHai.getResponseJson());
//                logger.info("数据没有过期,获取数据库中缓存数据");
//            }
//        }
//        logger.debug("getQianHaiData end");
//        return responseResult;
//
//    }

    @Override
    public ResponseResult<String> getQianHaiData(String companyName, String crefoNo) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        logger.debug("getQianHaiData start");
        if(companyName == null || "".equals(companyName)){
            responseResult.setCode(false);
            responseResult.setMsg("sendQianHaiData 公司名称不能为空");
            logger.info("sendQianHaiData 公司名称不能为空");
        }
        if(crefoNo == null || "".equals(crefoNo)){
            responseResult.setCode(false);
            responseResult.setMsg("sendQianHaiData 科氏号码不能为空");
            logger.info("sendQianHaiData 科氏号码不能为空");
        }
        String sendBack = sendQianHaiData(companyName,crefoNo);
        if (sendBack==null){
            responseResult.setCode(false);
            responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
            logger.info("订单查询没有返回数据或者调用接口参数错误");
        }else{
            responseResult.setCode(true);
            responseResult.setContent(sendBack);
            logger.info("前海本地库 " + companyName + " 添加成功,并且获取最新数据");
        }
        logger.debug("getQianHaiData end");
        return responseResult;
    }

    public String sendQianHaiData(String companyName,String crefoNo){
        logger.debug("sendQianHaiData start");
        logger.debug("sendQianHaiData 参数 " + companyName);
        if(companyName==null && companyName.equals("")){
            logger.debug("sendQianHaiData 参数 错误");
            return null;
        }
        Map<String,String> map = ProAccounts.getQhMap();
        String baseUrl = map.get("qianHaiUrl");
        String header = "\"header\":" + MessageUtil.getMHeader_DMZ();
        String verifyType = "2";
        String encBusiData = null;
        String content = null;
        try {
            encBusiData = DataSecurityUtil.encrypt(MessageUtil.getBusiData_MSC8004(verifyType, companyName, crefoNo).getBytes("utf-8"), "RyuqWGPBVKMP_KR0VGAY41MA");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String str = DataSecurityUtil.decrypt(encBusiData, "RyuqWGPBVKMP_KR0VGAY41MA");
            String busiData = "\"busiData\":\"" + encBusiData + "\"";
            String sigValue = DataSecurityUtil.signData(encBusiData);
            String pwd = DataSecurityUtil.digest(map.get("qianHaiPwd").getBytes());
            String securityInfo = "\"securityInfo\":" + MessageUtil.getSecurityInfo(sigValue, map.get("qianHaiUser"), pwd);
            String message = "{" + header + "," + busiData + "," + securityInfo + "}";
            //通过Web Curl获得此记录
            String res = HttpRequestUtil.sendJsonWithHttps(baseUrl, message);
            JSONObject msgJSON = JSONObject.parseObject(res);
            // 一定要验证签名的合法性！！！！！！！！
            DataSecurityUtil.verifyData(msgJSON.getString("busiData"),msgJSON.getJSONObject("securityInfo").getString("signatureValue"));
            content = DataSecurityUtil.decrypt(msgJSON.getString("busiData"),"RyuqWGPBVKMP_KR0VGAY41MA");
            logger.debug("请求前海查询订单返回值 = " + content);
            logger.debug("sendQianHaiData end");
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("获取前海数据出错");
        }
        return content;
    }
}
