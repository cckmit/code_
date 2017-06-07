package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.front.cn.common.ProAccounts;
import com.mika.credit.facade.front.cn.dao.HanXinDao;
import com.mika.credit.facade.front.cn.service.HanXinInfoService;
import com.mika.credit.facade.front.cn.util.hanxin.DesUtil;
import com.mika.credit.facade.front.cn.util.hanxin.HttpUtil;
import com.mika.credit.facade.front.cn.util.hanxin.Md5Utils;
import com.mika.credit.facade.front.cn.util.hanxin.RSACoder;
import org.apache.log4j.Logger;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Mike on 2016/12/9.
 */
@SuppressWarnings("Duplicates")
@Service("hanXinInfoService")
public class HanXinInfoServiceImpl implements HanXinInfoService {

    private static Logger logger = Logger.getLogger(HanXinInfoServiceImpl.class);

    @Autowired
    HanXinDao hanXinDao;

//    @Override
//    public ResponseResult<String> getHaixinData(String number) {
//
//        ResponseResult<String> responseResult = new ResponseResult<>();
//        logger.debug("getHaixinData start");
//        //数据过期时间
//        int histoyDay = Constant.haiXinDataExpiry;
//        if( number == null || number.equals("") ){
//            responseResult.setCode(false);
//            responseResult.setMsg("向法海发送数据失败,参数错误");
//            logger.info("向法海发送数据失败,参数错误");
//            logger.debug("getHaixinData end");
//            return responseResult;
//        }
//        logger.debug("getHaixinData 参数:" + number);
//        HanXin hanXin = hanXinDao.findByNumber(number);
//        if (hanXin == null) {
//            logger.debug("MySql : 本地没有" + number + " 相关的数据");
//            //开始Web查询
//            String sendBack = sendHaixinData(number);
//            if (sendBack==null){
//                responseResult.setCode(false);
//                responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
//                logger.info("订单查询没有返回数据或者调用接口参数错误");
//            }else{
//                //插入数据记录
//                hanXin = new HanXin();
//                // 插入数据
//                hanXin.setNumber(number);
////                    faHai.setUrl(mapResult.get("url"));
//                hanXin.setResponseJson(sendBack);
//                hanXin.setCreateTime(new Date());
//                hanXin.setUpdateTime(new Date());
//                hanXin.setRequestTime(new Date());
//                hanXinDao.insert(hanXin);
//                responseResult.setCode(true);
//                responseResult.setContent(sendBack);
//                logger.info("前海本地库 " + number + " 添加成功,并且获取最新数据");
//            }
//        } else {
//            logger.debug("过期时间计算结果:" + ProAccounts.getCalculateDate(hanXin.getRequestTime()));
//            if (histoyDay < ProAccounts.getCalculateDate(hanXin.getRequestTime())) {
//                //开始Web查询
//                String sendBack = sendHaixinData(number);
//                if (sendBack==null){
//                    responseResult.setCode(false);
//                    responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
//                    logger.info("订单查询没有返回数据或者调用接口参数错误");
//                }else{
//                    //更新数据记录
//                    hanXin.setNumber(number);
//                    hanXin.setResponseJson(sendBack);
//                    hanXin.setCreateTime(new Date());
//                    hanXin.setUpdateTime(new Date());
//                    hanXin.setRequestTime(new Date());
//                    hanXinDao.insert(hanXin);
//                    responseResult.setCode(true);
//                    responseResult.setContent(sendBack);
//                    logger.info("前海本地库 " + number + " 更新成功,并且获取最新数据");
//                }
//            }
//            else{
//                //数据库中数据没有过期
//                responseResult.setCode(true);
//                responseResult.setContent(hanXin.getResponseJson());
//                logger.info("数据没有过期,获取数据库中缓存数据");
//            }
//        }
//        logger.debug("getHaixinData end");
//        return responseResult;
//    }

    @Override
    public ResponseResult<String> getHaixinData(String number) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        logger.debug("getGrandeData start");
        if (number==null||"".equals(number)){
                responseResult.setCode(false);
                responseResult.setMsg("参数错误");
                logger.info("参数错误");
        }else {
            String sendBack = sendHaixinData(number);
            if (sendBack == null) {
                responseResult.setCode(false);
                responseResult.setMsg("订单查询没有返回数据或者调用接口参数错误");
                logger.info("订单查询没有返回数据或者调用接口参数错误");
            } else {
                responseResult.setCode(true);
                responseResult.setContent(sendBack);
                logger.info("韩信本地库 " + number + " 添加成功,并且获取最新数据");
            }
        }
        logger.debug("getGrandeData end");
        return responseResult;
    }

    public String sendHaixinData(String number){
        logger.debug("sendHaixinData start");
        logger.debug("sendHaixinData 参数 " + number);
        if(number!=null && !number.equals("")){
            logger.debug("sendHaixinData 参数 错误");
            return null;
        }
        Map<String,String> map = ProAccounts.getHxMap();
        String sfUrl = map.get("hanXinUrl");
        String hanXinChannelId = map.get("hanXinChannelId");
        String hanXinPublicKey = map.get("hanXinPublicKey");
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+
                "<subatm>"+
                "<application>GwBiz.Req</application>"+
                "<version>1.0.0</version>"+
                "<sendTime>"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"</sendTime>"+
                "<transCode>100072</transCode>"+
                "<channelId>"+hanXinChannelId+"</channelId>"+
                "<channelOrderId>"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"</channelOrderId>"+
                "<queryType>2</queryType>"+
                "<name>SSS</name>"+
                "<tel>"+number+"</tel>"+
                "<subCodes>1</subCodes>"+
                "<queryReasonID>101</queryReasonID>"+
                "</subatm>";

        String mkey = UUID.randomUUID().toString();
        String res = "";

        // 加密报文体格式：BASE64(商户号)| BASE64(RSA(报文加密密钥))| BASE64(3DES(报文原文))
        String strKey = null;
        try {
            strKey = RSACoder.encryptByPublicKey(new String(mkey.getBytes(), "utf-8"), hanXinPublicKey);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String strxml = null;
        try {
            strxml = new String(Base64.encode(DesUtil.encrypt(xml.toString().getBytes("utf-8"), mkey.getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String returnXml = null;
        try {
            returnXml = new String(Base64.encode(hanXinChannelId.getBytes("utf-8"))) + "|" + strKey + "|" + strxml;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //System.out.println(returnXml);
        //System.out.println();
        //System.out.println();
        //long start = System.currentTimeMillis();
        //System.out.println("T1=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
        String reutrnResult = HttpUtil.sendXMLDataByPost(sfUrl, returnXml);
        //System.out.println("T2=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()) + ",time length:" + (System.currentTimeMillis() - start));
        //System.out.println("res data:" + reutrnResult);
        String xmlArr[] = reutrnResult.split("\\|");

        if (xmlArr[0].equals("0")) {
            try {
                res = new String(Base64.decode(xmlArr[2]), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //System.out.println(res);
        } else {
            byte[] b = new byte[0];
            try {
                b = DesUtil.decrypt(Base64.decode(xmlArr[1]), mkey.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }

            String tradeXml = null;
            try {
                tradeXml = new String(b, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            res = tradeXml;
            System.out.println(tradeXml);
            try {
                System.out.println(new String(Base64.encode(Md5Utils.md5ToHexStr(tradeXml).getBytes("utf-8"))));// BASE64(MD5(报文))
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        logger.debug("请求前海查询订单返回值 = " + res);
        logger.debug("sendHaixinData end");
        return res;
    }
}
