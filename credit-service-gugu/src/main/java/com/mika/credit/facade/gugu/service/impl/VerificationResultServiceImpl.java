package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.dao.CreditCertificationMapper;
import com.mika.credit.facade.gugu.dao.VerificationResultMapper;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.CreditCertification;
import com.mika.credit.facade.gugu.model.VerificationResult;
import com.mika.credit.facade.gugu.service.VerificationResultService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dong jian hua on 2017/4/15.
 */
@Service("verificationResultService")
public class VerificationResultServiceImpl implements VerificationResultService {
    private Logger logger= Logger.getLogger(VerificationResultServiceImpl.class);

    @Autowired
    private VerificationResultMapper verificationResultMapper;

    @Autowired
    private CreditCertificationMapper creditCertificationMapper;

    @Override
    public String getVerificationResultInfo(String json) {
        logger.debug("进入获取名片核实信息的方法！");
        ResponseResult<VerificationResult> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(json, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard && null != businessCard.getId()){
            VerificationResult vr = new VerificationResult();
            if (null != businessCard.getVerficationId()){
                vr.setId(businessCard.getVerficationId());
            }else{
                if(null != businessCard.getUserId()){
                    vr.setUserId(businessCard.getUserId());
                }
                vr.setCardId(businessCard.getId());
            }
            List<VerificationResult> verificationResult = verificationResultMapper.selectByPrimaryKeySelective(vr);
            if(verificationResult.size()>0){
                for (VerificationResult verificationResults:verificationResult){
                    result.setCode(true);
                    result.setMsg("获取名片核实成功");
                    result.setContent(verificationResults);
                    return JSON.toJSONString(result);
                }
            }else{
                result.setCode(false);
                result.setMsg("获取名片核实失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取名片核实失败");
        }
        logger.info("获取名片核实方法的返回结果：" + JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String authInfo(String data) {
        ResponseResult<CreditCertification> result = new ResponseResult<>();
        JSONObject json = JSONObject.parseObject(data);
        String id = json.getString("creditCertificationId");
        String userId = json.getString("userId");
        if(null != id){
            CreditCertification ccf = new CreditCertification();
            ccf.setId(Integer.valueOf(id));
            ccf.setUserId(Integer.valueOf(userId));
            List<CreditCertification> credit = creditCertificationMapper.selectByPrimaryKeySelective(ccf);
            if(credit.size()>0){
                for (CreditCertification creditCertification:credit) {
                    result.setCode(true);
                    result.setMsg("获取信用认证信息成功");
                    result.setContent(creditCertification);
                }
            }else{
                result.setCode(false);
                result.setMsg("获取信用认证信息失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取信用认证信息失败");
        }
        return JSON.toJSONString(result);
    }

    @Override
    public String newAuthInfo(String data) {
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            List<CreditCertification> cct = creditCertificationMapper.selectByPrimaryCardId(businessCard.getId());
            if(cct.size()>0){
                result.setCode(true);
                result.setMsg("获取信用认证信息成功");
                result.setResult(cct);
            }else{
                result.setCode(false);
                result.setMsg("获取信用认证信息失败");
            }

        }else{
            result.setCode(false);
            result.setMsg("获取信用认证信息失败");
        }

        return JSONObject.toJSONString(result);
    }

    @Override
    public String cardListByCertification(String data) {
        ResponseResult<CreditCertification> result = new ResponseResult<>();
        JSONObject json = JSONObject.parseObject(data);
        String cardId = json.getString("cardId");
        String userId = json.getString("userId");
        if(StringUtil.isNotNull(cardId)){
            CreditCertification ccf = new CreditCertification();
            ccf.setCardId(Integer.valueOf(cardId));
            if(StringUtil.isNotNull(userId)){
                ccf.setUserId(Integer.valueOf(userId));
            }
            List<CreditCertification> credit = creditCertificationMapper.selectByPrimaryKeySelective(ccf);
            if(credit.size()>0){
                    result.setCode(true);
                    result.setMsg("获取信用认证信息成功");
                    result.setResult(credit);
            }else{
                result.setCode(false);
                result.setMsg("获取信用认证信息失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取信用认证信息失败");
        }
        return JSON.toJSONString(result);
    }

    @Override
    public String cerificationInfo(String data) {
        ResponseResult<CreditCertification> result = new ResponseResult<>();
        JSONObject json = JSONObject.parseObject(data);
        String cardId = json.getString("cardId");
        if(null != cardId){
            List<CreditCertification> creditCertification = creditCertificationMapper.selectByPrimaryCardId(Integer.valueOf(cardId));
            if(creditCertification.size()>0){
                for (CreditCertification creditCertifications:creditCertification) {
                    if(null != creditCertifications.getId()){
                        Map m=new HashMap();
                        m.put("result",creditCertifications);
                        m.put("code",true);
                        m.put("msg","获取信用认证信息成功");
                        return JSON.toJSONString(m, SerializerFeature.WriteMapNullValue);
                    }
                }
            }else{
                result.setCode(true);
                result.setMsg("获取信用认证信息失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取信用认证信息失败");
        }
        return JSON.toJSONString(result);
    }

}
