package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.facade.front.cn.service.FullReportService;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.gugu.service.IndexDetailService;
import com.mika.credit.facade.gugu.util.TranslateTools;
import com.mika.credit.facade.index.bean.Company;
import com.mika.credit.facade.index.service.CompanyIndexService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by dell on 2017/4/18.
 */
@Service("indexDetailService")
public class IndexDetailServiceImpl implements IndexDetailService{
    private static Logger logger = Logger.getLogger(IndexDetailServiceImpl.class);

    @Autowired
    private CompanyIndexService companyIndexService;

    @Autowired
    private FullReportService fullReportService;



    @Override
    public String fillCompanyIndex(String json) {
        logger.debug("进入搜索列表的方法！");
        BootGrid<Company> bootGrid=new BootGrid<>();
        BootGrid bootGrid1= JSON.parseObject(json,BootGrid.class);      //得到传入的分页对象信息，包括搜索值
        bootGrid=companyIndexService.fillCompanyIndex(bootGrid1);
        bootGrid.setResult(true);
        bootGrid.setResultDes("搜索成功！");
        logger.info("搜索列表方法的返回结果："+ JSON.toJSONString(bootGrid));
        return JSON.toJSONString(bootGrid);
    }

    @Override
    public String targetRegistration(String data) {
        logger.debug("进入获取搜索目标工商信息的方法！");
        JSONObject json = JSONObject.parseObject(data);
        String nameCN = json.getString("nameCN");
        String type = json.getString("type");
        //TODO 目标对象详情
        JSONObject jsons = new JSONObject();
        if(StringUtil.isNotNull(nameCN) && StringUtil.isNotNull(type)){
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(nameCN);
            FullReport fr = fullReportService.getGlobalAllReport(fullReport);
            if(null != fr){
                JSONArray array = new JSONArray();
                if(null != fr){
                    Integer sum = Integer.valueOf(type);
                    switch (sum){
                        case 1:
                            //注册
                            RegistrationInfos registrationInfos = fr.getRegistrationInfos();
                            if (null != registrationInfos){
                                jsons.put("registrationInfos",registrationInfos);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 2:
                            //变更
                            List<ChangeInfos> changeInfos = fr.getChangeInfosList();
                            if(changeInfos.size()>0){
                                for (ChangeInfos changeInfosList:changeInfos) {
                                    array.add(changeInfosList);
                                }
                                jsons.put("changeInfos",array);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 3:
                            //股东
                            List<ShareholderInfos> shareholderInfos = fr.getShareholderInfosList();
                            if(shareholderInfos.size()>0){
                                for (ShareholderInfos shareholderInfosList:shareholderInfos) {
                                    array.add(shareholderInfosList);
                                }
                                jsons.put("shareholderInfos",array);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 4:
                            //管理层
                            List<Managements> managements = fr.getManagementsList();
                            if (managements.size()>0){
                                for (Managements managementsList:managements) {
                                    array.add(managementsList);
                                }
                                jsons.put("managements",array);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 5:
                            //法院公告
                            List<Fygg> fygg = fr.getFyggList();
                            if(fygg.size()>0){
                                for (Fygg fyggList:fygg) {
                                    array.add(fyggList);
                                }
                                jsons.put("fygg",array);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 6:
                            //裁判文书
                            List<Rulingdocuments> rulingdocuments = fr.getRulingdocumentsList();
                            if(rulingdocuments.size()>0){
                                for (Rulingdocuments rulingdocumentsList:rulingdocuments) {
                                    array.add(rulingdocumentsList);
                                }
                                jsons.put("rulingdocuments",array);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 7:
                            //失信被执行人
                            List<Sxgg> sxgg = fr.getSxggList();
                            if(sxgg.size()>0){
                                for (Sxgg sxggList:sxgg) {
                                    array.add(sxggList);
                                }
                                jsons.put("sxgg",array);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 8:
                            //被执行人
                            List<Executive> executives = fr.getExecutiveList();
                            if(executives.size()>0){
                                for (Executive executivesList:executives){
                                    array.add(executivesList);
                                }
                                jsons.put("executives",array);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 9:
                            //经营异常
                            List<OperationAbnormalInfos> operationAbnormalInfos = fr.getOperationAbnormalInfosList();
                            if(operationAbnormalInfos.size()>0){
                                for (OperationAbnormalInfos operationAbnormalInfosList:operationAbnormalInfos) {
                                    array.add(operationAbnormalInfosList);
                                }
                                jsons.put("operationAbnormalInfos",array);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 10:
                            //新闻列表
                            List<MediaRecords> mediaRecords = fr.getMediaRecordsList();
                            if(mediaRecords.size()>0){
                                for (MediaRecords mediaRecordsList:mediaRecords) {
                                    array.add(mediaRecordsList);
                                }
                                jsons.put("mediaRecords",array);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 11:
                            //专利列表
                            List<Brands> brands = fr.getBrandsList();
                            if(brands.size()>0){
                                for (Brands brandsList:brands) {
                                    array.add(brandsList);
                                }
                                jsons.put("brands",array);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 12:
                            //网站列表
                            List<IcpWebsite> icpWebsites = fr.getIcpWebsiteList();
                            if(icpWebsites.size()>0){
                                for (IcpWebsite icpWebsitesList:icpWebsites) {
                                    array.add(icpWebsitesList);
                                }
                                jsons.put("icpWebsites",array);
                            }else{
                                return failureInfo();
                            }
                            break;
                        case 13:
                            //年报列表
                            List<BasicAnnua> baiscAnnuaList = fr.getBaiscAnnuaList();
                            if(baiscAnnuaList.size()>0){
                                for (BasicAnnua baiscAnnuaLists:baiscAnnuaList) {
                                    array.add(baiscAnnuaLists);
                                }
                                jsons.put("baiscAnnuas",array);
                            }else{
                               return failureInfo();
                            }
                            break;
                    }
                    jsons.put("code",true);
                    jsons.put("msg","获取目标对象列表成功");
                }
            }else{
                jsons.put("code",false);
                jsons.put("msg","获取目标对象列表失败,数据异常");
            }
        }else{
            jsons.put("code",false);
            jsons.put("msg","获取目标对象列表失败");
        }
        logger.info("获取搜索目标工商信息方法的返回结果："+ jsons.toString());
        return jsons.toString();
    }

    public String failureInfo(){
        JSONObject jsons = new JSONObject();
        jsons.put("code",false);
        jsons.put("msg","获取目标对象列表失败,没有数据");
        return jsons.toString();
    }

    @Override
    public String searchRegistration(String data) {
        logger.debug("进入获取搜索目标工商信息的方法！");
        JSONObject jsons = new JSONObject();
        JSONObject json = JSONObject.parseObject(data);
        String nameCN = json.getString("cardCompany");
        //TODO 获取搜索目标工商信息
        if(StringUtil.isNotNull(nameCN)){
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(nameCN);
            FullReport fr = fullReportService.getGlobalAllReport(fullReport);
            if(StringUtil.isNotNull(fr)){
                DecimalFormat myformat = new DecimalFormat();
                myformat.applyPattern("###,###,###,###.00");
                RegistrationInfos registrationInfos = fr.getRegistrationInfos();
                List<ChangeInfos> changeInfos = fr.getChangeInfosList();
                List<ShareholderInfos> shareholderInfos = fr.getShareholderInfosList();
                List<Managements> managements = fr.getManagementsList();
                List<Fygg> fygg = fr.getFyggList();
                List<Rulingdocuments> rulingdocuments = fr.getRulingdocumentsList();
                List<Sxgg> sxgg = fr.getSxggList();
                List<Executive> executives = fr.getExecutiveList();
                List<OperationAbnormalInfos> operationAbnormalInfos = fr.getOperationAbnormalInfosList();
                List<MediaRecords> mediaRecords = fr.getMediaRecordsList();
                List<Brands> brands = fr.getBrandsList();
                List<IcpWebsite> icpWebsites = fr.getIcpWebsiteList();
                List<BasicAnnua> baiscAnnuaList = fr.getBaiscAnnuaList();
                if(null != registrationInfos){
                    Double money = Double.valueOf(0);
                    String regist = TranslateTools.currencyType(registrationInfos.getRegCapital());
                    if (StringUtil.isNotNull(registrationInfos.getRegCapital())){
                        if(registrationInfos.getRegCapital().contains("万")){
                            money = Double.valueOf(regist)*10000;
                        }else{
                            money = Double.valueOf(regist);
                        }
                    }
                    BigDecimal paid = new BigDecimal(money);
                    String GS_RegCapital = myformat.format(paid);
                    registrationInfos.setRegCapital(GS_RegCapital);
                    jsons.put("code",true);
                    jsons.put("msg","获取工商信息成功");
                    jsons.put("registrationInfos",registrationInfos);
                    if (StringUtil.isNotNull(changeInfos)){
                        jsons.put("changeInfos",changeInfos.size());
                    }
                    if (StringUtil.isNotNull(shareholderInfos)){
                        jsons.put("shareholderInfos",shareholderInfos.size());
                    }
                    if (StringUtil.isNotNull(managements)){
                        jsons.put("managements",managements.size());
                    }
                    if (StringUtil.isNotNull(fygg)){
                        jsons.put("fygg",fygg.size());
                    }
                    if (StringUtil.isNotNull(rulingdocuments)){
                        jsons.put("rulingdocuments",rulingdocuments.size());
                    }
                    if (StringUtil.isNotNull(sxgg)){
                        jsons.put("sxgg",sxgg.size());
                    }
                    if (StringUtil.isNotNull(executives)){
                        jsons.put("executives",executives.size());
                    }
                    if (StringUtil.isNotNull(operationAbnormalInfos)){
                        jsons.put("operationAbnormalInfos",operationAbnormalInfos.size());
                    }
                    if (StringUtil.isNotNull(mediaRecords)){
                        jsons.put("mediaRecords",mediaRecords.size());
                    }
                    if (StringUtil.isNotNull(brands)){
                        jsons.put("brands",brands.size());
                    }
                    if (StringUtil.isNotNull(icpWebsites)){
                        jsons.put("icpWebsites",icpWebsites.size());
                    }
                    if (StringUtil.isNotNull(baiscAnnuaList)){
                        jsons.put("baiscAnnuaList",baiscAnnuaList.size());
                    }
                }else{
                    jsons.put("code",false);
                    jsons.put("msg","获取工商信息失败");
                }
            }else{
                jsons.put("code",false);
                jsons.put("msg","获取工商信息失败");
            }
        }else{
            jsons.put("code",false);
            jsons.put("msg","获取工商信息失败");
        }
        logger.info("获取搜索目标工商信息方法的返回结果："+ jsons.toJSONString());
        return jsons.toJSONString();
    }

    @Override
    public String basicInfoDetail(String data) {
        logger.debug("进入获取搜索目标的基本信息的方法！");
        ResponseResult<BasicInfos> result = new ResponseResult<>();
        //TODO 获取搜索目标的基本信息
        JSONObject json = JSONObject.parseObject(data);
        String nameCN = json.getString("cardCompany");
        if(null != nameCN){
            FullReport fullReport = new FullReport();
            fullReport.setNameCN(nameCN);
            FullReport fr = fullReportService.getFullReport(fullReport);
            if(null != fr){
                BasicInfos basicInfos = fr.getBasicInfos();
                if(null != basicInfos){
                    result.setCode(true);
                    result.setMsg("获取目标基本对象信息成功");
                    result.setContent(basicInfos);
                }else{
                    result.setCode(false);
                    result.setMsg("获取目标基本对象信息失败");
                }
            }else{
                result.setCode(false);
                result.setMsg("获取目标基本对象信息失败");
            }
        }else{
            result.setCode(false);
            result.setMsg("获取详情失败");
        }
        logger.info("获取搜索目标的基本信息方法的返回结果："+ JSONObject.toJSONString(result));
        return JSONObject.toJSONString(result);
    }
}
