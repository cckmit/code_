package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.common.util.DateUtil;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.service.GongShangService;
import com.mika.credit.facade.gugu.util.TranslateTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.mika.credit.facade.front.cn.service.FullReportService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dong jian hua on 2017/4/18.
 */
@Service("gongShangService")
public class GongShangServiceImpl implements GongShangService {
    private static Logger logger = Logger.getLogger(GongShangServiceImpl.class);

    @Autowired
    private  FullReportService fullReportService;
//
//    @Autowired
//    private RegistrationInfosMapper registrationInfosMapper;

    @Override
    public String gongShangInfo(String data) {
        logger.debug("进入获取工商信息的方法！");
        ResponseResult<RegistrationInfos> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 获取工商信息成功
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
            FullReport fullReport1List =  fullReportService.getGlobalAllReport(fullReport);
            if(null != fullReport1List){
                DecimalFormat myformat = new DecimalFormat();
                myformat.applyPattern("###,###,###,###.00");
                RegistrationInfos registrationInfoCN = fullReport1List.getRegistrationInfos();
                if(null != registrationInfoCN){
                    Double money = Double.valueOf(0);
                    String regist = TranslateTools.currencyType(registrationInfoCN.getRegCapital());
                    if(registrationInfoCN.getRegCapital().contains("万")){
                        money = Double.valueOf(regist)*10000;
                    }else{
                        money = Double.valueOf(regist);
                    }
                    BigDecimal paid = new BigDecimal(money);
                    String GS_RegCapital = myformat.format(paid);
                    registrationInfoCN.setRegCapital(GS_RegCapital);
                    result.setCode(true);
                    result.setMsg("获取工商信息成功");
                    result.setContent(registrationInfoCN);
                }
            }else{
                result.setCode(true);
                result.setMsg("数据正在获取中，请稍后再试！");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取工商信息失败");
        }
        logger.info("获取工商信息方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String updateGongshang(String data) {
        logger.debug("进入更新工商信息的方法！");
        ResponseResult<RegistrationInfos> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 更新工商信息
            if(null != businessCard) {
                FullReport fullReport = new FullReport();
                fullReport.setNameCN(businessCard.getCardCompany());
                FullReport fullReport1List = fullReportService.getGlobalAllReport(fullReport);
                RegistrationInfos registrationInfoCN = fullReport1List.getRegistrationInfos();
                if(null != registrationInfoCN && null != registrationInfoCN.getId()){
                    registrationInfoCN.setUpdateTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
                    registrationInfoCN.setDelFlag("1");
//                    int updateRegis = registrationInfosMapper.update(registrationInfoCN);
//                    if (updateRegis>0){
//                        result.setCode(true);
//                        result.setMsg("获取更新工商信息成功");
//                    }
                }else{
                    result.setCode(false);
                    result.setMsg("获取更新工商信息失败");
                }
            }else {
                result.setCode(false);
                result.setMsg("获取更新工商信息失败");
            }
        }
        logger.info("获取更新工商信息方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangList(String data) {
        logger.debug("进入工商变更表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商变更
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
                FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
                List<ChangeInfos> changeInfosCN = frCN.getChangeInfosList();
                if(changeInfosCN.size()>0){
                    result.setCode(true);
                    result.setMsg("获取注册变更表成功");
                    result.setResult(changeInfosCN);
                }else{
                    result.setCode(false);
                    result.setMsg("获取注册变更表失败");
                }
        }else{
            result.setCode(false);
            result.setMsg("获取注册变更表失败");
        }
        logger.info("获取注册变更表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String shareholderList(String data) {
        logger.debug("进入获取工商股东列表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商股东列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
                FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
                List<ShareholderInfos> shareListCN = frCN.getShareholderInfosList();
                if(shareListCN.size()>0){
                    result.setCode(true);
                    result.setMsg("获取工商股东列表成功");
                    result.setResult(shareListCN);
                }else{
                    result.setCode(false);
                    result.setMsg("获取工商股东列表失败");
                }
        }else{
            result.setCode(false);
            result.setMsg("获取工商股东列表失败");
        }
        logger.info("获取工商股东列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangManagements(String data) {
        logger.debug("进入获取工商管理层列表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商管理层列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
                FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
                List<Managements> managementCNList = frCN.getManagementsList();
                if(managementCNList.size()>0){
                    result.setCode(true);
                    result.setMsg("获取工商管理层列表成功");
                    result.setResult(managementCNList);
                }else{
                    result.setCode(false);
                    result.setMsg("获取工商管理层列表失败");
                }
        }else{
            result.setCode(false);
            result.setMsg("获取工商管理层列表失败");
        }
        logger.info("获取工商管理层列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangLegalNotic(String data) {
        logger.debug("进入获取工商法院公告列表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商法院公告列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
                FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
                List<Fygg> fyggCNList = frCN.getFyggList();
                if(fyggCNList.size()>0){
                    result.setCode(true);
                    result.setMsg("获取工商法院公告列表成功");
                    result.setResult(fyggCNList);
                }else{
                    result.setCode(false);
                    result.setMsg("获取工商法院公告列表失败");
                }
        }else{
            result.setCode(false);
            result.setMsg("获取工商法院公告列表失败");
        }
        logger.info("获取工商法院公告列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangAdjudicationInfo(String data) {
        logger.debug("进入获取工商裁判文书列表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商裁判文书列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
                FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
                List<Rulingdocuments> rulingCNList = frCN.getRulingdocumentsList();
                if(rulingCNList.size()>0){
                    result.setCode(true);
                    result.setMsg("获取工商裁判文书列表成功");
                    result.setResult(rulingCNList);
                }else{
                    result.setCode(false);
                    result.setMsg("获取工商裁判文书列表失败");
                }
        }else{
            result.setCode(false);
            result.setMsg("获取工商裁判文书列表失败");
        }
        logger.info("获取工商裁判文书列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangEnforce(String data) {
        logger.debug("进入获取工商被执行人列表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商被执行人列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
                FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
                List<Executive> executivesCNList = frCN.getExecutiveList();
                if(executivesCNList.size()>0){
                    result.setCode(true);
                    result.setMsg("获取工商被执行人列表成功");
                    result.setResult(executivesCNList);
                }else{
                    result.setCode(false);
                    result.setMsg("获取工商被执行人列表失败");
                }
        }else{
            result.setCode(false);
            result.setMsg("获取工商被执行人列表失败");
        }
        logger.info("获取工商被执行人列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangUncreditEnforce(String data) {
        logger.debug("进入获取工商失信被执行人列表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商失信被执行人列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
                FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
                List<Sxgg> sxggCNList = frCN.getSxggList();
                if(sxggCNList.size()>0){
                    result.setCode(true);
                    result.setMsg("获取工商失信被执行人列表成功");
                    result.setResult(sxggCNList);
                }else{
                    result.setCode(false);
                    result.setMsg("获取工商失信被执行人列表失败");
                }
        }else{
            result.setCode(false);
            result.setMsg("获取工商失信被执行人列表失败");
        }
        logger.info("获取工商失信被执行人列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangBusinessAbnormity(String data) {
        logger.debug("进入获取工商失经营异常列表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商失经营异常列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
            FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
            List<OperationAbnormalInfos> operaCNList = frCN.getOperationAbnormalInfosList();
            if(operaCNList.size()>0){
                result.setCode(true);
                result.setMsg("获取工商失经营异常列表成功");
                result.setResult(operaCNList);
            }else{
                result.setCode(false);
                result.setMsg("获取工商失经营异常列表失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取工商失经营异常列表失败");
        }
        logger.info("获取工商失经营异常列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangNews(String data) {
        logger.debug("进入获取工商新闻列表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商新闻列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
            FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
            List<MediaRecords> mediaRecordsCNList = frCN.getMediaRecordsList();
            if(mediaRecordsCNList.size()>0){
                result.setCode(true);
                result.setMsg("获取工商新闻列表成功");
                result.setResult(mediaRecordsCNList);
            }else{
                result.setCode(false);
                result.setMsg("获取工商新闻列表失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取工商新闻列表失败");
        }
        logger.info("获取工商新闻列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangPatent(String data) {
        logger.debug("进入获取工商专利列表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商专利列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
            FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
            List<Brands> brandsCNList = frCN.getBrandsList();
            if(brandsCNList.size()>0){
                result.setCode(true);
                result.setMsg("获取工商专利列表成功");
                result.setResult(brandsCNList);
            }else{
                result.setCode(false);
                result.setMsg("获取工商专利列表失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取工商专利列表失败");
        }
        logger.info("获取工商专利列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangWebSite(String data) {
        logger.debug("进入获取工商网站列表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商网站列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
            FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
            List<IcpWebsite> icpWebsitesCNList = frCN.getIcpWebsiteList();
            if(icpWebsitesCNList.size()>0){
                result.setCode(true);
                result.setMsg("获取工商网站列表成功");
                result.setResult(icpWebsitesCNList);
            }else{
                result.setCode(false);
                result.setMsg("获取工商网站列表失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取工商网站列表失败");
        }
        logger.info("获取工商网站列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangRegistrationinfo(String data) {
        logger.debug("进入获取工商注册列表的方法！");
        ResponseResult<RegistrationInfos> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商注册列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
            FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
            RegistrationInfos registrationInfosCN = frCN.getRegistrationInfos();
            if(null != registrationInfosCN){
                result.setCode(true);
                result.setMsg("获取工商注册列表成功");
                result.setContent(registrationInfosCN);
            }else{
                result.setCode(false);
                result.setMsg("获取工商注册列表失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取工商注册列表失败");
        }
        logger.info("获取工商注册列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

    @Override
    public String gongShangFinancial(String data) {
        logger.debug("进入获取工商年报列表的方法！");
        ResponseResult<String> result = new ResponseResult<>();
        BusinessCard businessCard = JSON.parseObject(data, BusinessCard.class);     //json参数转化为对象
        if(null != businessCard){
            //TODO 工商年报列表
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(businessCard.getCardCompany());
            FullReport frCN = fullReportService.getGlobalAllReport(fullReport);
            List<BasicAnnua> basicAnnuaCNList = frCN.getBaiscAnnuaList();
            if(basicAnnuaCNList.size()>0){
                result.setCode(true);
                result.setMsg("获取工商年报列表成功");
                result.setResult(basicAnnuaCNList);
            }else{
                result.setCode(false);
                result.setMsg("获取工商年报列表失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取工商年报列表失败");
        }
        logger.info("获取工商年报列表方法的返回结果："+JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }
}
