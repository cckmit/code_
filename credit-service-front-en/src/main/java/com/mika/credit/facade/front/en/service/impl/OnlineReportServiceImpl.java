package com.mika.credit.facade.front.en.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.creditsafe.globaldata.datatypes.CompanyReportType;
import com.creditsafe.globaldata.datatypes.CustomData;
import com.creditsafe.globaldata.datatypes.Language;
import com.creditsafe.globaldata.datatypes.reports.CompanyReport;
import com.creditsafe.globaldata.datatypes.reports.CompanyReportSet;
import com.creditsafe.globaldata.datatypes.reports.LtdCompanyFullReport;
import com.creditsafe.globaldata.operations.RetrieveCompanyOnlineReport;
import com.microsoft.schemas._2003._10.serialization.ObjectFactory;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfunsignedInt;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.front.en.Util.UtilDate;
import com.mika.credit.facade.front.en.entity.JsonReport;
import com.mika.credit.facade.front.en.service.OnlineReportService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by mika on 2016/5/25.
 */
@Service("onlineReportService")
public class OnlineReportServiceImpl extends BaseCreditSafeServiceImpl implements OnlineReportService {

    private static Logger logger = Logger.getLogger(OnlineReportServiceImpl.class);

//    @Resource(name="jsonReportDao")
////    @Autowired
//    private JsonReportDao jsonReportDao;

    @Transactional(propagation= Propagation.REQUIRED)
    public ResponseResult<LtdCompanyFullReport> checkOnlineReport(String companyId, String companyReportType, String language){
        logger.debug("checkOnlineReport 开始");
        logger.debug("companyId = "+ companyId + " companyReportType = " + companyReportType + " language = " + language);
        ResponseResult<LtdCompanyFullReport> result = new ResponseResult<>();
        String msg="";
        if(companyReportType == null){
            companyReportType = "Full";
        }
        if(language == null){
            language = "EN";
        }
        if(companyId == null){
            msg += "公司ID错误";
        }
        CompanyReportType crt = CompanyReportType.fromValue(companyReportType);
        if(crt == null){
            msg += "报告类型错误";
        }
        Language l = Language.fromValue(language);
        if(l == null){
            msg += "语言错误";
        }
        if(!msg.equals("")){
            result.setCode(false);
            result.setMsg(msg);
            result.setContent(null);
            logger.info("checkOnlineReport 方法参数错误" + msg);
            logger.debug("checkOnlineReport 结束");
            return result;
        }
//        JsonReport jsonReport = jsonReportDao.findByCompanyId(companyId);
        JsonReport jsonReport = new JsonReport();
        int cacheDay = 15;
        if(jsonReport==null){
            //如果数据库中没有数据就添加
            logger.debug("checkOnlineReport 数据库中没有该记录");
            try {
                jsonReport = new JsonReport();
                CompanyReport companyReport = requestOnlineReport(companyId, crt, l);
                if(companyReport!=null){
                    jsonReport.setCompanyId(companyId);
                    jsonReport.setReportType(crt.value());
                    jsonReport.setLanguage(l.value());
                    jsonReport.setResponseJson(JSON.toJSONString(companyReport, SerializerFeature.DisableCircularReferenceDetect));
                    jsonReport.setCreateTime(new Date());
                    jsonReport.setUpdateTime(new Date());
                    jsonReport.setRequestTime(new Date());
//                    jsonReportDao.save(jsonReport);
                    result.setCode(true);
                    result.setMsg("");
                    result.setContent(JSON.parseObject(jsonReport.getResponseJson(),LtdCompanyFullReport.class));
                    logger.info("远程获取数据成功,数据库添加新纪录成功 companyId = " + companyId);
                    logger.debug("checkOnlineReport 结束");
                    return result;
                }
                else {
                    msg += "获取数据失败";
                    result.setCode(false);
                    result.setMsg(msg);
                    result.setContent(null);
                    logger.info("远程获取数据失败 companyId = " + companyId);
                    logger.debug("checkOnlineReport 结束");
                    return result;
                }

            } catch (RemoteException e) {
                e.printStackTrace();
                msg += "获取数据失败";
                result.setCode(false);
                result.setMsg(msg);
                result.setContent(null);
                logger.info("远程获取数据失败 companyId = " + companyId + " 异常信息" + e.getMessage());
                logger.debug("checkOnlineReport 结束");
                return result;
            }

        }
        else if (cacheDay < UtilDate.getCalculateDate(new Date(), jsonReport.getUpdateTime())) {
            //如果数据库中有数据,但是过期 就更新数据
            logger.debug("checkOnlineReport 数据库中有记录 但需要更新");
            try {
                CompanyReport companyReport = requestOnlineReport(companyId, crt, l);
                if(companyReport!=null) {
                    jsonReport.setCompanyId(companyId);
                    jsonReport.setReportType(crt.value());
                    jsonReport.setLanguage(l.value());
                    jsonReport.setResponseJson(JSON.toJSONString(companyReport, SerializerFeature.DisableCircularReferenceDetect));
                    jsonReport.setUpdateTime(new Date());
//                    jsonReportDao.save(jsonReport);
                    result.setCode(true);
                    result.setMsg("");
                    result.setContent(JSON.parseObject(jsonReport.getResponseJson(),LtdCompanyFullReport.class));
                    logger.info("远程获取数据成功,数据库更新纪录成功 companyId = " + companyId + "数据库id = " + jsonReport.getId());
                    logger.debug("checkOnlineReport 结束");
                    return result;
                }
                else {
                    msg = "获取数据失败";
                    result.setCode(false);
                    result.setMsg(msg);
                    result.setContent(null);
                    logger.info("远程获取数据失败 companyId = " + companyId );
                    logger.debug("checkOnlineReport 结束");
                    return result;
                }

            } catch (RemoteException e) {
                e.printStackTrace();
                msg += "获取数据失败";
                result.setCode(false);
                result.setMsg(msg);
                result.setContent(null);
                logger.info("远程获取数据失败 companyId = " + companyId + " 异常信息" + e.getMessage());
                logger.debug("checkOnlineReport 结束");
                return result;
            }

        }
        else{
            //如果数据库中有数据而且没有过期 就使用数据库的值
            result.setCode(true);
            result.setMsg("");
            String a = jsonReport.getResponseJson();
            LtdCompanyFullReport companyReport = JSON.parseObject(a, LtdCompanyFullReport.class);
            result.setContent(companyReport);
            logger.info("数据库中为最新数据.");
            logger.debug("checkOnlineReport 结束");
            return result;
        }
    }


    public CompanyReport requestOnlineReport(RetrieveCompanyOnlineReport retrieveCompanyOnlineReport) throws RemoteException {
        String companyId = null;
        if(retrieveCompanyOnlineReport.getCompanyId()!=null){
            companyId = retrieveCompanyOnlineReport.getCompanyId().getValue();
        }
        CustomData customData = null;
        if(retrieveCompanyOnlineReport.getCustomData()!=null){
            customData = retrieveCompanyOnlineReport.getCustomData().getValue();
        }
        String chargeReference = null;
        if(retrieveCompanyOnlineReport.getChargeReference()!=null){
            chargeReference = retrieveCompanyOnlineReport.getChargeReference().getValue();
        }
        ArrayOfunsignedInt portfolioIds = null;
        if(retrieveCompanyOnlineReport.getPortfolioIds()!=null){
            portfolioIds = retrieveCompanyOnlineReport.getPortfolioIds().getValue();
        }
        String monitoringReference = null;
        if(retrieveCompanyOnlineReport.getMonitoringReference()!=null){
            monitoringReference = retrieveCompanyOnlineReport.getMonitoringReference().getValue();
        }

        CompanyReport result = null;
        CompanyReportSet companyReportSet = getGlobalDataService().retrieveCompanyOnlineReport(companyId, retrieveCompanyOnlineReport.getReportType(), retrieveCompanyOnlineReport.getLanguage(), customData, chargeReference, retrieveCompanyOnlineReport.isStoreInReportbox(), portfolioIds, monitoringReference);
        if(companyReportSet.getReports() != null && companyReportSet.getReports().getReport() != null && companyReportSet.getReports().getReport().size() > 0){
            result = companyReportSet.getReports().getReport().get(0);
            //存入数据库
        }
        return  result;
    }


    public CompanyReport  requestOnlineReport(String companyId, CompanyReportType companyReportType, Language language) throws RemoteException {
        ObjectFactory objectFactory = new ObjectFactory();
        RetrieveCompanyOnlineReport retrieveCompanyOnlineReport = new RetrieveCompanyOnlineReport();
        retrieveCompanyOnlineReport.setCompanyId(objectFactory.createString(companyId));
        retrieveCompanyOnlineReport.setReportType(companyReportType);
        retrieveCompanyOnlineReport.setLanguage(language);
        //retrieveCompanyOnlineReport.setChargeReference("User Id 1");
        String countryId = companyId.substring(0, 2);
        if(countryId.toUpperCase().equals("DE")){
            CustomData customData = new CustomData();
            CustomData.Entries.Entry entry = new CustomData.Entries.Entry();
            entry.setKey("de_reason_code");
            entry.setValue("2");
            CustomData.Entries entries = new CustomData.Entries();
            entries.getEntry().add(entry);
            customData.setEntries(entries);
//            List<CustomData.Entries.Entry> entryList = new ArrayList<CustomData.Entries.Entry>();
//            entryList.add(entry);
//            CustomData.Entries entries = new CustomData.Entries();
//            entries.
//            customData.getEntries().getEntry().add()
//        CustomDataEntriesEntry[] customDataEntriesEntries = new CustomDataEntriesEntry[1];
//        CustomDataEntriesEntry customDataEntriesEntry = new CustomDataEntriesEntry();
//
//        customDataEntriesEntries[0] = customDataEntriesEntry;
//        CustomData customData = new CustomData();
//        customData.setEntries(customDataEntriesEntries);
            com.creditsafe.globaldata.datatypes.ObjectFactory globaldataOF = new com.creditsafe.globaldata.datatypes.ObjectFactory();
          retrieveCompanyOnlineReport.setCustomData(globaldataOF.createCustomData(customData));

        }

        CompanyReport result = requestOnlineReport(retrieveCompanyOnlineReport);
        return  result;
    }

    public ResponseResult<LtdCompanyFullReport>  requestOnlineReport(String companyId,String companyReportType,String language) throws RemoteException {
        ResponseResult<LtdCompanyFullReport> result = new ResponseResult<>();
        String msg="";
        if(companyReportType == null||companyReportType.equals("")){
            companyReportType = "Full";
        }
        if(language == null||language.equals("")){
            language = "EN";
        }
        CompanyReportType crt = CompanyReportType.fromValue(companyReportType);
        if(crt == null){
            msg += "报告类型错误";
        }
        Language l = Language.fromValue(language);
        if(l == null){
            msg += "语言错误";
        }
        if(!msg.equals("")){
            result.setCode(false);
            result.setMsg(msg);
            result.setContent(null);
            return result;
        }
        CompanyReport companyReport = requestOnlineReport(companyId, CompanyReportType.fromValue(companyReportType), Language.fromValue(language));
        if(companyReport == null){
            result.setCode(false);
            result.setMsg("无法获取数据");
            result.setContent(null);
            return result;
        }
        else {
            result.setCode(true);
            result.setMsg("");
            result.setContent((LtdCompanyFullReport)companyReport);
            return result;
        }
    }
}
