package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetail;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.common.entity.pay.PayBackBean;
import com.mika.credit.common.entity.report.cn.BasicInfos;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.IcpWebsite;
import com.mika.credit.common.entity.report.cn.RegistrationInfos;
import com.mika.credit.common.util.DateUtil;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.front.cn.service.FullReportService;
import com.mika.credit.facade.gugu.dao.*;
import com.mika.credit.facade.gugu.model.*;
import com.mika.credit.facade.gugu.service.CertificationService;
import com.mika.credit.facade.order.service.OrderService;
import com.mika.credit.facade.verify.service.VerifyInfoService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dong jian hua on 2017/4/14.
 */
@Service("certificationService")
public class CertificationServiceImpl implements CertificationService {
    private static Logger logger = Logger.getLogger(CertificationServiceImpl.class);

    @Autowired
    private BusinessCardMapper businessCardMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;
    @Autowired
    private FullReportService fullReportService;
    @Autowired
    private VerificationResultMapper verificationResultMapper;
    @Autowired
    private VerifyInfoService verifyInfoService;
    @Autowired
    private InformMapper informMapper;
    @Autowired
    private CreditCertificationMapper creditCertificationMapper;

    @Override
    public String addVerifyOrder(String json) {
        logger.debug("进入核实名片的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(json, BusinessCard.class);     //json参数转化为对象
        if (null != businessCard) {
            OrderDetail orderDetail = new OrderDetail();
            List<OrderDetail> orderDetailList = new ArrayList<>();
            Orders order = new Orders();
            if (null != businessCard.getCreditVerification() && null != businessCard.getUpdateTime()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    String updateStr = sdf.format(businessCard.getUpdateTime());
                    Long updateTime = new DateUtil().getTime(updateStr);
                    Long currentTime = System.currentTimeMillis();
                    if ((currentTime - updateTime) <= 5000) {
                        result.setCode(false);
                        result.setMsg("操作过于频繁");
                        return JSON.toJSONString(result);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Users users = usersMapper.selectByPrimaryKey(businessCard.getUserId());
            if (null != users) {
                order.setCustomerId(users.getId());
                order.setCustomerEmail(users.getEmail());
                order.setSource((byte) 4);
                orderDetail.setCompanyName(businessCard.getCardCompany());
                if (null != businessCard.getOrderId()) {
                    orderDetail.setOrderId(Long.valueOf(businessCard.getOrderId()));
                }
                orderDetail.setPriceActual(new BigDecimal(0));
                orderDetail.setPrice(new BigDecimal(0));
                orderDetailList.add(orderDetail);
                order.setOrderDetails(orderDetailList);
                ResponseResult<Orders> ordersResponseResult = orderService.saveOrder(order);
                if (ordersResponseResult.getCode()) {

                    PayBackBean payBackBean = new PayBackBean();
                    payBackBean.setOrderNo("GE15B0F24B0D5");
                    payBackBean.setAmount(new BigDecimal(99));
                    payBackBean.setPayMethod(0);
                    ResponseResult<Orders> paid = orderService.paid(payBackBean);
                    if (!paid.getCode()) {
                        FullReport  fullReport = new FullReport();
                        String companyName =  businessCard.getCardCompany();
                        companyName = companyName.replace("（", "(");
                        companyName = companyName.replace("）", ")");
                        fullReport.setNameCN(companyName);
                        FullReport fr = fullReportService.getFullReport(fullReport);
                        logger.debug("获取核实计算分数");
                        String verificationResult = getVerificationResultByCardId(businessCard, fr);
                        return verificationResult;
                    }
                }
            } else {
                result.setCode(false);
                result.setMsg("未查到此用户的信息");
            }

        } else {
            result.setCode(false);
            result.setMsg("公司名或用户名为空!");
        }
        logger.info("核实名片方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String addMobiletOrder(String json) {
        logger.debug("进入认购(认证)的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(json, BusinessCard.class);     //json参数转化为对象
        if (null != businessCard && null != businessCard.getId()) {
//                Order selectOrder = orderMapper.selectByPrimaryKey(businessCard.getOrderId());
//                if(selectOrder == null){
            try {
                OrderDetail orderDetail = new OrderDetail();
                Order order = new Order();
                List<OrderDetail> orderDetailList = new ArrayList<>();
                order.setSubjectName(businessCard.getCardCompany());
                order.setSubjectAdd(businessCard.getCardAddress());
                order.setSubjectTel(businessCard.getAreaCode() + businessCard.getCardTel());
                order.setOrderDate(new Date());
                order.setOrderNum(DateUtil.getCurrentDate("yyyyMMddHHmmddssSSS"));
                order.setDelFlag("1");
                Users users = usersMapper.selectByPrimaryKey(businessCard.getUserId());
                if (StringUtil.isNotNull(users)) {
                    order.setRealName(users.getRealName());
                    order.setUserId(users.getId());
                    order.setUserName(users.getUserName());
                    order.setOrderStatus("1");
                    orderMapper.insert(order);
                }

                //添加订单信息
                Orders orders = new Orders();
                if(StringUtil.isNotNull(users)&&StringUtil.isNotNull(users.getId())){
                    orders.setCustomerId(users.getId());
                }
                if (StringUtil.isNotNull(users.getEmail()) && StringUtil.isNotNull(businessCard.getCardCompany())){
                    orders.setCustomerEmail(users.getEmail());
                    orderDetail.setCompanyName(businessCard.getCardCompany());
                }
                if (null != businessCard.getOrderId()){
                    orderDetail.setOrderId(Long.valueOf(businessCard.getOrderId()));
                }
                orders.setSource((byte) 4);
                orderDetail.setPriceActual(new BigDecimal(0));
                orderDetail.setPrice(new BigDecimal(0));
                orderDetailList.add(orderDetail);
                orders.setOrderDetails(orderDetailList);
                ResponseResult<Orders> ordersResponseResult = orderService.saveOrder(orders);
                if (ordersResponseResult.getCode()) {
                    PayBackBean payBackBean = new PayBackBean();
                    payBackBean.setOrderNo("GE15B0F24B0D5");
                    payBackBean.setAmount(new BigDecimal(99));
                    payBackBean.setPayMethod(0);
                    ResponseResult<Orders> paid = orderService.paid(payBackBean);
                    if (!paid.getCode()) {
                        //TODO 获取认证信息
                        String map = getcertificationInfos(businessCard, ordersResponseResult);
                        return map;

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                result.setCode(false);
                result.setMsg("获取认证失败");
            }
        } else {
            result.setCode(false);
            result.setMsg("获取认证失败");
        }
        logger.info("认购(认证)方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String addsubscribe(String json) {
        logger.debug("进入认购(认证)的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        JSONObject jsons = JSONObject.parseObject(json);
        String companyName = jsons.getString("nameCN");
        Integer userId = jsons.getInteger("userId");
        if (StringUtil.isNotNull(companyName) && null != userId) {
            BusinessCard businessCard = new BusinessCard();
            businessCard.setCardCompany(companyName);
            businessCard.setUserId(userId);
            List<BusinessCard> businessCards = businessCardMapper.selectByPrimaryKeySelective(businessCard);
            if (businessCards.size() > 0) {
                for (BusinessCard bs : businessCards) {
//                    Order selectOrder = orderMapper.selectByPrimaryKey(bs.getOrderId());
//                    if(selectOrder == null){
                    try {
                        OrderDetail orderDetail = new OrderDetail();
                        Order order = new Order();
                        List<OrderDetail> orderDetailList = new ArrayList<>();
                        order.setSubjectName(bs.getCardCompany());
                        order.setSubjectAdd(bs.getCardAddress());
                        order.setSubjectTel(bs.getAreaCode() + bs.getCardTel());
                        order.setOrderDate(new Date());
                        order.setOrderNum(DateUtil.getCurrentDate("yyyyMMddHHmmddssSSS"));
                        order.setDelFlag("1");
                        Users users = usersMapper.selectByPrimaryKey(bs.getUserId());
                        if (null != users) {
                            order.setRealName(users.getRealName());
                            order.setUserId(users.getId());
                            order.setUserName(users.getUserName());
                            order.setOrderStatus("1");
                            orderMapper.insert(order);
                        }

                        //添加订单信息
                        Orders orders = new Orders();
                        orders.setCustomerId(users.getId());
                        orders.setCustomerEmail(users.getEmail());
                        orders.setSource((byte) 4);
                        orderDetail.setCompanyName(bs.getCardCompany());
                        if (null != bs.getOrderId()) {
                            orderDetail.setOrderId(Long.valueOf(bs.getOrderId()));
                        }
                        orderDetail.setPriceActual(new BigDecimal(0));
                        orderDetail.setPrice(new BigDecimal(0));
                        orderDetailList.add(orderDetail);
                        orders.setOrderDetails(orderDetailList);
                        ResponseResult<Orders> ordersResponseResult = orderService.saveOrder(orders);
                        if (ordersResponseResult.getCode()) {
                            PayBackBean payBackBean = new PayBackBean();
                            payBackBean.setOrderNo("GE15B0F24B0D5");
                            payBackBean.setAmount(new BigDecimal(99));
                            payBackBean.setPayMethod(0);
                            ResponseResult<Orders> paid = orderService.paid(payBackBean);
                            if (!paid.getCode()) {
                                //TODO 获取认证信息
                                String map = getcertificationInfos(bs, ordersResponseResult);
                                return map;

                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        result.setCode(false);
                        result.setMsg("获取认证信息失败");
                    }
//                    }
                }
            } else {
                result.setCode(false);
                result.setMsg("获取认证信息失败,用户或者公司名不存在");
            }
        }
        return JSON.toJSONString(result);
    }


    public String getVerificationResultByCardId(BusinessCard businessCard,FullReport fr) {
        JSONObject jsons = new JSONObject();
        try{
            String verifyInfo = "";
            if(null != businessCard.getVerificationUpdateTime()){
                Long verificationTime = businessCard.getVerificationUpdateTime().getTime();
                Long currentTime = System.currentTimeMillis();
                Long Interval=(long) (30L*24L*60L*60L*1000L);
                if ((currentTime - verificationTime)<Interval){
                    //TODO 核实
//                    verifyInfo = getVerifyInfoModel(businessCard,fr);
                    logger.debug("调用Verify接口的核实方法");
                    ResponseResult<VerificationResult>  verificationResult = verifyInfoService.getVerifyInfoModel(businessCard,fr);
                    if(verificationResult.getCode()){
                        VerificationResult vr = verificationResult.getContent();
                        if(null == businessCard.getVerficationId()){
                            vr.setUserId(businessCard.getUserId());
                            vr.setCardId(businessCard.getId());
                            logger.debug("新增核实信息");
                            verificationResultMapper.insert(vr);
                            businessCard.setVerificationScore(vr.getTotalScore());
                            businessCard.setCreditVerification("1");
                            businessCard.setVerficationId(vr.getId());
                            logger.debug("修改businessCard");
                            businessCardMapper.updateByPrimaryKeySelective(businessCard);
                        }else{
                            vr.setUserId(businessCard.getUserId());
                            vr.setCardId(businessCard.getId());
                            vr.setId(businessCard.getVerficationId());
                            verificationResultMapper.updateByPrimaryKeySelective(vr);

                            businessCard.setVerificationScore(vr.getTotalScore());
                            businessCard.setCreditVerification("1");
                            businessCardMapper.updateByPrimaryKeySelective(businessCard);
                        }
                        jsons.put("verifyInfo",vr);
                    }else{
                        jsons.put("code",false);
                        jsons.put("msg",verificationResult.getMsg());
                        return jsons.toJSONString();
                    }
                    jsons.put("code",true);
                    jsons.put("msg","加载核实信息成功");
                    jsons.put("businessCard",businessCard);
                    return jsons.toJSONString();
                }else{
                    //TODO 调用外部接口进行计算，暂时没有外部接口，暂时为空
                    verifyInfo = "";
                }
            }else{
                businessCard.setVerificationUpdateTime(new Date());
                ResponseResult<VerificationResult>  verificationResult = verifyInfoService.getVerifyInfoModel(businessCard,fr);
                if(verificationResult.getCode()){
                    VerificationResult vr = verificationResult.getContent();
                    if(null ==vr.getId()){
                        vr.setUserId(businessCard.getUserId());
                        vr.setCardId(businessCard.getId());
                        verificationResultMapper.insertSelective(vr);

                        businessCard.setVerificationScore(vr.getTotalScore());
                        businessCard.setCreditVerification("1");
                        businessCard.setVerficationId(vr.getId());
                        businessCardMapper.updateByPrimaryKeySelective(businessCard);
                    }else{
                        vr.setUserId(businessCard.getUserId());
                        vr.setCardId(businessCard.getId());
                        verificationResultMapper.updateByPrimaryKeySelective(vr);

                        businessCard.setVerificationScore(vr.getTotalScore());
                        businessCard.setCreditVerification("1");
                        businessCardMapper.updateByPrimaryKeySelective(businessCard);
                    }
                    jsons.put("verifyInfo",vr);
                }else{
                    jsons.put("code",false);
                    jsons.put("msg",verificationResult.getMsg());
                    return jsons.toJSONString();
                }

                //添加通知信息
                Inform inform = new Inform();
                inform.setUserId(businessCard.getUserId());
                inform.setOrderId(businessCard.getOrderId());
                inform.setSubjectCompany(businessCard.getCardCompany());
                inform.setDelFlag("1");
                informMapper.selectByPrimaryKeySelective(inform);

                jsons.put("code",true);
                jsons.put("msg","加载核实信息成功");
                jsons.put("businessCard",businessCard);
                return jsons.toJSONString();
            }
        }catch(Exception e){
            e.printStackTrace();
            jsons.put("code",false);
            jsons.put("msg","加载核实信息失败");
        }
        return jsons.toJSONString();
    }

    /**
     * 获得认证信息
     * @param businessCard
     * @param result
     * @return
     */
    public String getcertificationInfos(BusinessCard businessCard,ResponseResult<Orders> result) {
        JSONObject json = new JSONObject();
        FullReport fullReport = new FullReport();
        fullReport.setNameCN(businessCard.getCardCompany());
        FullReport fr =  fullReportService.getFullReport(fullReport);

        if(null !=fr && null != fr.getBasicInfos()){

            //TODO 认证的计算
            ResponseResult<CreditCertification> creditCertification = verifyInfoService.getCreditCertification(fr);
            if(!creditCertification.getCode()){
                json.put("code",false);
                json.put("msg","获取认证失败");
                return JSON.toJSONString(json);

            }
            CreditCertification cc = creditCertification.getContent();

            //认缴资本
            if(StringUtil.isNotNull(cc.getRegCapital())){
                cc.setRegCapital("未知");
            }


            //实缴资本
            if(StringUtil.isNotNull(cc.getPaidCapital()) && cc.getPaidCapital().equals(".00")){
                    cc.setPaidCapital("未知");
            }
            //利润率
            if(StringUtils.isBlank(cc.getProfitMarginScope())){
                    cc.setProfitMarginScope("未知");
            }
            //速冻比率
            if(StringUtils.isBlank(cc.getCurrentRatioScope())){
                    cc.setCurrentRatioScope("未知");
            }
            //销售成长比率
            if(StringUtils.isBlank(cc.getSalesGrowthRateScope())){
                cc.setSalesGrowthRateScope("未知");
            }

            //资产负债
            if(StringUtils.isBlank(cc.getDebtRatioScope())){
                cc.setDebtRatioScope("未知");
            }


            String OrderId = result.getContent().getId().toString();
            if(StringUtil.isNotNull(OrderId)){
                cc.setOrderId(Integer.valueOf(OrderId));
            }
            cc.setUserId(businessCard.getUserId());
            cc.setCardId(businessCard.getId());
            cc.setDelFlag("1");
            cc.setUpdateTime(new Date());

            //工商信息
            RegistrationInfos registrationInfos = fr.getRegistrationInfos();
            if(null != registrationInfos){
                cc.setEstablishDate(registrationInfos.getEstablishDate());
                cc.setCompanyStatus(registrationInfos.getCompanyStatus());
                cc.setMainBusiness(registrationInfos.getBusinessScopeCN());
            }


            int saveCerdit = creditCertificationMapper.insertSelective(cc);
            if(saveCerdit >0){
                businessCard.setCreditCertification("1");
                businessCard.setCreditCertificationId(cc.getId());
                if(StringUtil.isNotNull(cc.getRepaymentIndex()) && StringUtil.isNotNull(cc.getCreditRiskEvaluation())){
                    businessCard.setRepaymentIndex(cc.getRepaymentIndex());
                    businessCard.setCreditRiskEvaluation(cc.getCreditRiskEvaluation());
                }
                businessCardMapper.updateByPrimaryKeySelective(businessCard);
                json.put("code",true);
                json.put("msg","认证成功");
                json.put("businessCard",businessCard);
                json.put("creditCertification",cc);
            }else{
                json.put("code",false);
                json.put("msg","获取认证失败");
            }

            //添加通知信息
            Inform inform = new Inform();
            inform.setUserId(businessCard.getUserId());
            inform.setOrderId(businessCard.getOrderId());
            inform.setSubjectCompany(businessCard.getCardCompany());
            inform.setDelFlag("1");
            informMapper.selectByPrimaryKeySelective(inform);
        }else{
            json.put("code",false);
            json.put("msg","认证失败，查询不到该公司！");
        }

        return JSON.toJSONString(json);
    }
}
