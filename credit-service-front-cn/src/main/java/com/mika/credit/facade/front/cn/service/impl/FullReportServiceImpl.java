package com.mika.credit.facade.front.cn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.MqRecord;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.common.enums.MqTypeEnum;
import com.mika.credit.facade.front.cn.common.Constant;
import com.mika.credit.facade.front.cn.common.ProAccounts;
import com.mika.credit.facade.front.cn.dao.*;
import com.mika.credit.facade.front.cn.parse.*;
import com.mika.credit.facade.front.cn.service.BasicInfosService;
import com.mika.credit.facade.front.cn.service.FullReportService;
import com.mika.credit.facade.front.cn.util.DateUtil;
import com.mika.credit.facade.front.cn.util.Tool;
import com.mika.credit.facade.translate.service.TranslateService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by dell on 2017/2/17.
 */
@SuppressWarnings("Duplicates")
@Service("fullReportService")
public class FullReportServiceImpl implements FullReportService {
    @Autowired
    AssetsAnnualDao assetsAnnualDao;
    @Autowired
    BasicAnnuaDao baiscAnnuaDao;
    @Autowired
    BrandsDao brandsDao;
    @Autowired
    GuaranteeAnnualDao guaranteeAnnualDao;
    @Autowired
    IcpWebsiteDao icpWebsiteDao;
    @Autowired
    OperationAbnormalInfosDao operationAbnormalInfosDao;
    @Autowired
    ChangeInfosDao changeInfosDao;
    @Autowired
    BasicInfosDao basicInfosDao;
    @Autowired
    RegistrationInfosDao registrationInfosDao;
    @Autowired
    ManagementsDao managementsDao;
    @Autowired
    DataTypeDao dataTypeDao;
    @Autowired
    BasicInfosService basicInfosService;
    @Autowired
    MediaRecordsDao mediaRecordsDao;
    @Autowired
    ShareholderInfosDao shareholderInfosDao;
    @Autowired
    ParseGrande parseGrande;
    @Autowired
    Litigation litigation;
    @Autowired
    AjlcDao ajlcDao;
    @Autowired
    BankInfosDao bankInfosDao;
    @Autowired
    BgtDao bgtDao;
    @Autowired
    ChattelMortgageDao chattelMortgageDao;
    @Autowired
    CreditAssessmentsDao creditAssessmentsDao;
    @Autowired
    EntinvinfosDao entinvinfosDao;
    @Autowired
    ExecutiveDao executiveDao;
    @Autowired
    FinancialFiguresDao financialFiguresDao;
    @Autowired
    FinancialRatiosDao financialRatiosDao;
    @Autowired
    FinancialStatementDao financialStatementDao;
    @Autowired
    FrinvinfosDao frinvinfosDao;
    @Autowired
    FyggDao fyggDao;
    @Autowired
    HistoryInfosDao historyInfosDao;
    @Autowired
    KtggDao ktggDao;
    @Autowired
    OperatingsDao operatingsDao;
    @Autowired
    PaymentHistoriesDao paymentHistoriesDao;
    @Autowired
    RelatedCompaniesDao relatedCompaniesDao;
    @Autowired
    RulingdocumentsDao rulingdocumentsDao;
    @Autowired
    ShareholdersChainDao shareholdersChainDao;
    @Autowired
    SxggDao sxggDao;
    @Autowired
    WdhmdDao wdhmdDao;
    @Autowired
    PenaltyHisDao penaltyHisDao;
    @Autowired
    ShareFrozenHisDao shareFrozenHisDao;
    @Autowired
    SharePledgeHisDao sharePledgeHisDao;
    @Autowired
    FrpositioninfosDao frpositioninfosDao;
    @Autowired
    BasicDataDao basicDateDao;
    @Autowired
    Cpm cpm;
    @Autowired
    Qianhai qianhai;
    @Autowired
    FullReportDao fullReportDao;
    @Autowired
    EnterpriseShareholderDao enterpriseShareholderDao;
    @Autowired
    TradeReferencesDao tradeReferencesDao;
    @Autowired
    CustomHouseDao customHouseDao;
    @Autowired
    private QiXinBaoParser qiXinBaoParser;

    @Autowired
    private JmsTemplate activemqJmsTemplate;
    @Autowired
    @Qualifier("creditQueue")
    private Destination creditQueue;
    @Autowired(required = false)
    TranslateService translateService;
    @Value("${qianhaiInterface}")
    private String QIANHAIURL;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String time = format.format(new Date());

    private static final Log log = LogFactory.getLog(FullReportServiceImpl.class);


    @Override
    public FullReport getFullReport(FullReport report) {
        FullReport fullReport = new FullReport();
        //替换中英文括号
        String nameCN = Tool.replaceSymbol(report.getNameCN());
        report.setNameCN(nameCN);
        fullReport = fullReportDao.findByName(report.getNameCN());
        //先判断数据库有没有这条记录
        Integer fid = 0;

        if (null != fullReport && null != fullReport.getId()) {//有记录
            int grandeUpdeDate = Constant.grandeUpdeTime;
            int qixinbaoUpDate = Constant.qixinbaoUpdateTime;
            int cpMUpdateDate = Constant.cpMUpdateTime;
            int qianHaiUpdateDate = Constant.qianHaiUpdateTime;
            int litigationUpdateDate = Constant.litigationUpdateTime;
            report.setId(fullReport.getId());
            report = getAllFullReport(report);
            boolean isUpdate = false;
            //if (null != fullReport.getGrandeUpdeTime()) {
            //    Date grandeDate = DateUtil.getStringToDate(fullReport.getGrandeUpdeTime());
            //    if (grandeUpdeDate < ProAccounts.getCalculateDate(grandeDate)) {
            //        parseGrande.SaveBusiness(report);
            //        parseGrande.SaveAssetsAnnual(report);
            //        fullReport.setGrandeUpdeTime(time);
            //        isUpdate = true;
            //    }
            //}

            if (fullReport.getQiXinBaoUpdateTime() != null) {
                Date qixinbaoDate = DateUtil.getStringToDate(fullReport.getQiXinBaoUpdateTime());
                if (qixinbaoUpDate < ProAccounts.getCalculateDate(qixinbaoDate)) {//启信宝超时
                    try {
                        qiXinBaoParser.copyFullReport(report);
                        //fullReport.setQiXinBaoUpdateTime(time);
                        //qiXinBaoParser.saveBusiness(report);
                        if (report.getRegistrationInfos() == null || StringUtils.isBlank(report.getRegistrationInfos().getNameCN()) || !nameCN.equals(Tool.replaceSymbol(report.getRegistrationInfos().getNameCN()))) {
                            return null;
                        }
                        isUpdate = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("启信宝数据调用错误", e);
                    }
                }
            }

            //if (null != fullReport.getCpMUpdateTime()) {
            //    Date cpMDate = DateUtil.getStringToDate(fullReport.getCpMUpdateTime());
            //    if (cpMUpdateDate < ProAccounts.getCalculateDate(cpMDate)) {
            //        cpm.getCpmList(report);
            //        fullReport.setFinancialUpdateTime(time);
            //        fullReport.setCpMUpdateTime(time);
            //        isUpdate = true;
            //    }
            //}

            if (null != fullReport.getQianHaiUpdateTime()) {
                Date qianHaiDate = DateUtil.getStringToDate(fullReport.getQianHaiUpdateTime());
                if (qianHaiUpdateDate < ProAccounts.getCalculateDate(qianHaiDate)) {
                    try {
                        qianhai.copyFullreport(report);
                        //fullReport.setQianHaiUpdateTime(time);
                        //qianhai.saveBusiness(report);
                        isUpdate = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("前海数据调用错误", e);
                    }
                }
            }

            if (null != fullReport.getLitigationUpdateTime()) {
                Date litigationDate = DateUtil.getStringToDate(fullReport.getLitigationUpdateTime());
                if (litigationUpdateDate < ProAccounts.getCalculateDate(litigationDate)) {
                    try {
                        litigation.copyFullreport(report);
                        //fullReport.setLitigationUpdateTime(time);
                        //litigation.saveBusiness(report);
                        isUpdate = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("法海数据调用错误", e);
                    }
                }
            }


            if (isUpdate) {
                Map<String, String> map = new HashMap<>();
                map.put("companyName", report.getNameCN());
                map.put("crefoNo",report.getCrefoNo());
                //全球鹰调用中国数据时，往消息队列增加一条记录
                MqRecord<Map> mqRecord = new MqRecord<>();
                mqRecord.setMqType(MqTypeEnum.CN_CN_SAVEFULLREPORT.getValue());
                mqRecord.setContent(map);
                sendMessage(mqRecord);
                //fullReportDao.update(fullReport);
            }

        } else {
            fullReport = new FullReport();
            //没有记录  拿接口数据  解析
            fullReport.setNameCN(report.getNameCN());
            try {
                qiXinBaoParser.copyFullReport(report);
                if (report.getRegistrationInfos() == null || StringUtils.isBlank(report.getRegistrationInfos().getNameCN()) || !nameCN.equals(Tool.replaceSymbol(report.getRegistrationInfos().getNameCN()))) {
                    return null;
                }
                //fullReport.setQiXinBaoUpdateTime(time);
                //qiXinBaoParser.saveBusiness(report);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("启信宝数据调用错误", e);
            }
            fullReportDao.insert(fullReport);
            fullReport = fullReportDao.findByName(report.getNameCN());
            fid = fullReport.getId();
            report.setId(fid);
            //parseGrande.SaveBusiness(report);
            //parseGrande.SaveAssetsAnnual(report);
            //fullReport.setGrandeUpdeTime(time);
            //cpm.getCpmList(report);
            //fullReport.setCpMUpdateTime(time);
            try {
                qianhai.copyFullreport(report);
                //fullReport.setQianHaiUpdateTime(time);
                //qianhai.saveBusiness(report);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("前海数据调用错误", e);
            }
            try {
                litigation.copyFullreport(report);
                //fullReport.setLitigationUpdateTime(time);
                //litigation.saveBusiness(report);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("法海数据调用错误", e);
            }

            Map<String, String> map = new HashMap<>();
            map.put("companyName", report.getNameCN());
            map.put("crefoNo",report.getCrefoNo());
            //往消息队列增加一条记录
            MqRecord<Map> mqRecord = new MqRecord<>();
            mqRecord.setMqType(MqTypeEnum.CN_CN_SAVEFULLREPORT.getValue());
            mqRecord.setContent(map);
            sendMessage(mqRecord);
            //fullReportDao.update(fullReport);

        }
        //翻译接口
        //FullReport reportTranslate = null;
        //try {
        //    reportTranslate = translateService.cnFullReportTranslate(fullReport);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //    log.error("翻译接口调用失败" + e);
        //    return fullReport;
        //}
        return report;
    }

    @Override
    public FullReport getAllFullReport(FullReport report) {
        long start = System.nanoTime();
        if (report != null) {
            FullReport fullReport = fullReportDao.findByName(report.getNameCN());
            if (fullReport != null) {
                Integer fid = fullReport.getId();
                report.setId(fid);
                //企业基本信息
                BasicInfos basics = basicInfosDao.findByFullReportId(fid);
                report.setBasicInfos(basics);
                //企业注册信息
                RegistrationInfos historyReg = registrationInfosDao.findByFullReportId(fid);
                //公司状态
                if (null != historyReg && null != historyReg.getCompanyStatusId()) {
                    Map<String, Object> params = new HashedMap();
                    params.put("dictionaryId", 32);
                    params.put("code", historyReg.getCompanyStatusId());
                    List<BasicData> companyStatusList = basicDateDao.listByDtidAndCode(params);
                    if (companyStatusList.size() > 0) {
                        historyReg.setCompanyStatus(companyStatusList.get(0).getValueCN());
                    }
                }
                //企业性质
                if (null != historyReg && null != historyReg.getCompanyStatusId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 29);
                    params.put("code", historyReg.getCompanyPropertiesId());
                    List<BasicData> companyPropertiesList = basicDateDao.listByDtidAndCode(params);
                    if (companyPropertiesList.size() > 0) {
                        historyReg.setEntOwnership(companyPropertiesList.get(0).getValueCN());
                    }
                }
                //企业类型
                if (null != historyReg && null != historyReg.getCompanyTypesId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 30);
                    params.put("code", historyReg.getCompanyTypesId());
                    List<BasicData> companyTypesList = basicDateDao.listByDtidAndCode(params);
                    if (companyTypesList.size() > 0) {
                        historyReg.setEntOwnership(companyTypesList.get(0).getValueCN());
                    }
                }
                //企业竞争力
                if (null != historyReg && null != historyReg.getCompetitionId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 44);
                    params.put("code", historyReg.getCompetitionId());
                    List<BasicData> competitionList = basicDateDao.listByDtidAndCode(params);
                    if (competitionList.size() > 0) {
                        historyReg.setCompetitiveness(competitionList.get(0).getValueCN());
                    }
                }
                //注册货币
                if (null != historyReg && null != historyReg.getRegCurrencyId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 42);
                    params.put("code", historyReg.getRegCurrencyId());
                    List<BasicData> currencyList = basicDateDao.listByDtidAndCode(params);
                    if (currencyList.size() > 0) {
                        historyReg.setRegCurrency(currencyList.get(0).getValueCN());
                    }
                }
                //实收货币
                if (null != historyReg && null != historyReg.getPaidCurrencyId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 42);
                    params.put("code", historyReg.getPaidCurrencyId());
                    List<BasicData> currencyList = basicDateDao.listByDtidAndCode(params);
                    if (currencyList.size() > 0) {
                        historyReg.setPaidCurrency(currencyList.get(0).getValueCN());
                    }
                }
                //上市地址
                if (null != historyReg && null != historyReg.getMarketCitiesId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 31);
                    params.put("code", historyReg.getMarketCitiesId());
                    List<BasicData> marketCitiesList = basicDateDao.listByDtidAndCode(params);
                    if (marketCitiesList.size() > 0) {
                        historyReg.setMarketAddress(marketCitiesList.get(0).getValueCN());
                    }
                }
                report.setRegistrationInfos(historyReg);
                //管理层
                List<Managements> managementList = managementsDao.findByFullReportId(fid);
                for (int i = 0; i < managementList.size(); i++) {
                    Managements managements = managementList.get(i);
                    //职位
                    if (null != managements && null != managements.getPostId()) {
                        Map<String, Object> params = new HashMap();
                        params.put("dictionaryId", 26);
                        params.put("code", managements.getPostId());
                        List<BasicData> postList = basicDateDao.listByDtidAndCode(params);
                        if (postList.size() > 0) {
                            managements.setPosition(postList.get(0).getValueCN());
                        }
                    }
                    //职能
                    if (null != managements && null != managements.getDutyId()) {
                        Map<String, Object> params = new HashMap();
                        params.put("dictionaryId", 35);
                        params.put("code", managements.getDutyId());
                        List<BasicData> dutyList = basicDateDao.listByDtidAndCode(params);
                        if (dutyList.size() > 0) {
                            managements.setFunction(dutyList.get(0).getValueCN());
                        }
                    }
                    //教育
                    if (null != managements && null != managements.getEducationId()) {
                        Map<String, Object> params = new HashMap();
                        params.put("dictionaryId", 27);
                        params.put("code", managements.getEducationId());
                        List<BasicData> EducationList = basicDateDao.listByDtidAndCode(params);
                        if (EducationList.size() > 0) {
                            managements.setEducationCN(EducationList.get(0).getValueCN());
                        }
                    }
                    //性别
                    if (null != managements && "0".equals(managements.getGender())) {
                        managements.setSex("男");
                    } else if (null != managements && "1".equals(managements.getGender())) {
                        managements.setSex("女");
                    } else {
                        managements.setSex("其他");
                    }
                    managementList.set(i, managements);
                }
                report.setManagementsList(managementList);

                //案件流程信息
                List<Ajlc> ajlcList = ajlcDao.findByFullReportId(fid);
                report.setAjlcList(ajlcList);

                //年报资产信息
                List<AssetsAnnual> assetsAnnualList = assetsAnnualDao.findByFullReportId(fid);
                report.setAssetsAnnualList(assetsAnnualList);

                //年报基本信息
                List<BasicAnnua> baiscAnnuaList = baiscAnnuaDao.findByFullReportId(fid);
                report.setBaiscAnnuaList(baiscAnnuaList);

                //银行信息
                List<BankInfos> bankInfosList = bankInfosDao.findByFullReportId(fid);
                report.setBankInfosList(bankInfosList);
                //曝光台
                List<Bgt> bgtList = bgtDao.findByFullReportId(fid);
                report.setBgtList(bgtList);

                //品牌专利
                List<Brands> brandsList = brandsDao.findByFullReportId(fid);
                report.setBrandsList(brandsList);

                //注册变更表
                List<ChangeInfos> changeInfosList = changeInfosDao.findByFullReportId(fid);
                for (int i = 0; i < changeInfosList.size(); i++) {
                    ChangeInfos changeInfos = changeInfosList.get(i);
                    //教育
                    if (null != changeInfos && null != changeInfos.getCompanyTypeId()) {
                        Map<String, Object> params = new HashMap();
                        params.put("dictionaryId", 30);
                        params.put("code", changeInfos.getCompanyTypeId());
                        List<BasicData> CompanyTypesList = basicDateDao.listByDtidAndCode(params);
                        if (CompanyTypesList.size() > 0) {
                            changeInfos.setChangeType(CompanyTypesList.get(0).getValueCN());
                        }
                    }
                    changeInfosList.set(i, changeInfos);
                }
                report.setChangeInfosList(changeInfosList);

                //动产抵押登记信息
                List<ChattelMortgage> chattelMortgageList = chattelMortgageDao.findByFullReportId(fid);
                report.setChattelMortgageList(chattelMortgageList);

                CreditAssessments creditAssessments = creditAssessmentsDao.findByFullReportId(fid);
                report.setCreditAssessments(creditAssessments);

                //企业对外投资信息
                List<Entinvinfos> entinvinfosList = entinvinfosDao.findByFullReportId(fid);
                for (int i = 0; i < entinvinfosList.size(); i++) {
                    Entinvinfos entinvinfos = entinvinfosList.get(i);
                    //企业状态
                    if (null != entinvinfos && null != entinvinfos.getEnterpriseStatus()) {
                        Map<String, Object> params = new HashMap();
                        params.put("dictionaryId", 32);
                        params.put("code", Tool.stringToIntStr(entinvinfos.getEnterpriseStatus()));
                        List<BasicData> CompanyStatusList = basicDateDao.listByDtidAndCode(params);
                        if (CompanyStatusList.size() > 0) {
                            entinvinfos.setEnterpriseStatus(CompanyStatusList.get(0).getValueCN());
                        }
                    }
                    //企业类型
                    if (null != entinvinfos && null != entinvinfos.getEntType()) {
                        Map<String, Object> params = new HashMap();
                        params.put("dictionaryId", 30);
                        params.put("code", Tool.stringToIntStr(entinvinfos.getEntType()));
                        List<BasicData> CompanyTypesList = basicDateDao.listByDtidAndCode(params);
                        if (CompanyTypesList.size() > 0) {
                            entinvinfos.setEnterpriseStatus(CompanyTypesList.get(0).getValueCN());
                        }
                    }
                    entinvinfosList.set(i, entinvinfos);
                }
                report.setEntinvinfosList(entinvinfosList);

                //执行公告
                List<Executive> executiveList = executiveDao.findByFullReportId(fid);
                for (int i = 0; i < executiveList.size(); i++) {
                    Executive executive = executiveList.get(i);
                    //执行标的货币单位
                    if (null != executive && null != executive.getCurrencyId()) {
                        Map<String, Object> params = new HashMap();
                        params.put("dictionaryId", 42);
                        params.put("code", Tool.stringToIntStr(executive.getCurrencyId()));
                        List<BasicData> CurrencyList = basicDateDao.listByDtidAndCode(params);
                        if (CurrencyList.size() > 0) {
                            executive.setCurrencyUnitCN(CurrencyList.get(0).getValueCN());
                        }
                    }
                    executiveList.set(i, executive);

                }
                report.setExecutiveList(executiveList);

                //财物说明
                List<FinancialFigures> financialFiguresList = financialFiguresDao.findByFullReportId(fid);
                report.setFinancialFiguresList(financialFiguresList);

                //财务分析
                List<FinancialRatios> financialRatiosList = financialRatiosDao.findByFullReportId(fid);
                for (int i = 0; i < financialRatiosList.size(); i++) {
                    FinancialRatios financialRatios = financialRatiosList.get(i);
                    //来源
                    if (null != financialRatios && null != financialRatios.getFsId()) {
                        Map<String, Object> params = new HashMap<>();
                        params.put("dictionaryId", 43);
                        params.put("code", financialRatios.getFsId());
                        List<BasicData> FinancialSourceList = basicDateDao.listByDtidAndCode(params);
                        if (FinancialSourceList.size() > 0) {
                            financialRatios.setFinancialSources(FinancialSourceList.get(0).getValueCN());
                        }
                    }
                    financialRatiosList.set(i, financialRatios);

                }
                report.setFinancialRatiosList(financialRatiosList);

                //
                List<FinancialStatement> financialStatementList = financialStatementDao.findByFullReportId(fid);
                for (int i = 0; i < financialStatementList.size(); i++) {
                    FinancialStatement financialStatement = financialStatementList.get(i);
                    //来源
                    if (null != financialStatement && null != financialStatement.getFinancialSourceId()) {
                        Map<String, Object> params = new HashMap<>();
                        params.put("dictionaryId", 43);
                        params.put("code", financialStatement.getFinancialSourceId());
                        List<BasicData> FinancialSourceList = basicDateDao.listByDtidAndCode(params);
                        if (FinancialSourceList.size() > 0) {
                            financialStatement.setFinancialSourceCN(FinancialSourceList.get(0).getValueCN());
                        }
                    }
                    financialStatementList.set(i, financialStatement);

                }
                report.setFinancialStatementList(financialStatementList);

                //法人对外投资信息
                List<Frinvinfos> frinvinfosList = frinvinfosDao.findByFullReportId(fid);
                report.setFrinvinfosList(frinvinfosList);

                //法院公告
                List<Fygg> fyggList = fyggDao.findByFullReportId(fid);
                report.setFyggList(fyggList);

                //年报提供担保信息
                List<GuaranteeAnnual> guaranteeAnnualList = guaranteeAnnualDao.findByFullReportId(fid);
                report.setGuaranteeAnnualList(guaranteeAnnualList);

                //历史背景沿革
                List<HistoryInfos> historyInfosList = historyInfosDao.findByFullReportId(fid);
                report.setHistoryInfosList(historyInfosList);

                //网站
                List<IcpWebsite> icpWebsiteList = icpWebsiteDao.findByFullReportId(fid);
                report.setIcpWebsiteList(icpWebsiteList);

                //开庭公告
                List<Ktgg> ktggList = ktggDao.findByFullReportId(fid);
                report.setKtggList(ktggList);

                //媒体记录表
                List<MediaRecords> mediaRecordsList = mediaRecordsDao.findByFullReportId(fid);
                report.setMediaRecordsList(mediaRecordsList);

                //经营现状表
                List<Operatings> operatingsList = operatingsDao.findByFullReportId(fid);
                for (int i = 0; i < operatingsList.size(); i++) {
                    Operatings operatings = operatingsList.get(i);
                    //企业大小
                    if (null != operatings && null != operatings.getCompanySizeId()) {
                        Map<String, Object> params = new HashMap<>();
                        params.put("dictionaryId", 34);
                        params.put("code", operatings.getCompanySizeId());
                        List<BasicData> CompanySizeList = basicDateDao.listByDtidAndCode(params);
                        if (CompanySizeList.size() > 0) {
                            operatings.setCompanyTypes(CompanySizeList.get(0).getValueCN());
                        }
                    }
                    //经营企业状态
                    if (null != operatings && null != operatings) {
                        Map<String, Object> params = new HashMap<>();
                        params.put("dictionaryId", 32);
                        params.put("code", operatings.getOperationalStatusId());
                        List<BasicData> CompanyStatusList = basicDateDao.listByDtidAndCode(params);
                        if (CompanyStatusList.size() > 0) {
                            operatings.setCompanyStatus(CompanyStatusList.get(0).getValueCN());
                        }
                    }
                    //地理位置
                    if (null != operatings && null != operatings.getLocationTypeId()) {
                        Map<String, Object> params = new HashMap<>();
                        params.put("dictionaryId", 32);
                        params.put("code", operatings.getLocationTypeId());
                        List<BasicData> PositionList = basicDateDao.listByDtidAndCode(params);
                        if (PositionList.size() > 0) {
                            operatings.setPosition(PositionList.get(0).getValueCN());
                        }
                    }
                    if (null != operatings && null != operatings.getOwnershipId() && operatings.getOwnershipId() == 0) {
                        operatings.setOwnership("租用");
                    } else if (null != operatings && null != operatings.getOwnershipId() && operatings.getOwnershipId() == 1) {
                        operatings.setOwnership("自有");
                    } else if (null != operatings && null != operatings.getOwnershipId() && operatings.getOwnershipId() == 2) {
                        operatings.setOwnership("无偿使用");
                    } else if (null != operatings && null != operatings.getOwnershipId() && operatings.getOwnershipId() == 3) {
                        operatings.setOwnership("未知");
                    }
                    //            //产权币种
                    //            if(null!=operatings && null!=operatings.getPrid()){
                    //                Map<String,Object> params = new HashMap<>() ;
                    //                params.put("dtid",42);
                    //                params.put("code",operatings.getPrid());
                    //                List<BasicData>  CurrencyList = basicDateDao.listByDtidAndCode(params);
                    //                if(CurrencyList.size()>0){
                    //                    operatings.setCurrencyProperty(CurrencyList.get(0).getValueCN());
                    //                }
                    //            }
                    //            //gdp币种
                    //            if(null!=operatings && null!=operatings.getGdpid()){
                    //                Map<String,Object> params = new HashMap<>() ;
                    //                params.put("dtid",42);
                    //                params.put("code",operatings.getGdpid());
                    //                List<BasicData>  CurrencyList = basicDateDao.listByDtidAndCode(params);
                    //                if(CurrencyList.size()>0){
                    //                    operatings.setGdpProperty(CurrencyList.get(0).getValueCN());
                    //                }
                    //            }
                    operatingsList.set(i, operatings);

                }
                if (null != operatingsList && operatingsList.size() > 0) {
                    report.setOperatings(operatingsList.get(0));
                }

                //经营现状
                List<OperationAbnormalInfos> operationAbnormalInfosList = operationAbnormalInfosDao.findByFullReportId(fid);
                report.setOperationAbnormalInfosList(operationAbnormalInfosList);

                //支付款记录
                List<PaymentHistories> paymentHistoriesList = paymentHistoriesDao.findByFullReportId(fid);
                for (int i = 0; i < paymentHistoriesList.size(); i++) {
                    PaymentHistories paymentHistories = paymentHistoriesList.get(i);
                    //支付模式
                    if (null != paymentHistories && null != paymentHistories.getPaymentPatternId()) {
                        Map<String, Object> params = new HashMap<>();
                        params.put("dictionaryId", 38);
                        params.put("code", paymentHistories.getPaymentPatternId());
                        List<BasicData> PaymentPatternList = basicDateDao.listByDtidAndCode(params);
                        if (PaymentPatternList.size() > 0) {
                            paymentHistories.setPaymentMode(PaymentPatternList.get(0).getValueCN());
                        }
                    }
                    //支付方式
                    if (null != paymentHistories && null != paymentHistories.getPaymentTermsId()) {
                        Map<String, Object> params = new HashMap<>();
                        params.put("dictionaryId", 39);
                        params.put("code", paymentHistories.getPaymentTermsId());
                        List<BasicData> PaymentTermsList = basicDateDao.listByDtidAndCode(params);
                        if (PaymentTermsList.size() > 0) {
                            paymentHistories.setPaymentMethod(PaymentTermsList.get(0).getValueCN());
                        }
                    }
                    paymentHistoriesList.set(i, paymentHistories);
                }
                report.setPaymentHistoriesList(paymentHistoriesList);

                //关联公司信息
                List<RelatedCompanies> relatedCompaniesList = relatedCompaniesDao.findByFullReportId(fid);
                for (int i = 0; i < relatedCompaniesList.size(); i++) {
                    RelatedCompanies relatedCompanies = relatedCompaniesList.get(i);
                    //关系
                    if (null != relatedCompanies && null != relatedCompanies.getRelationId()) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("dictionaryId", 34);
                        map.put("code", relatedCompanies.getRelationId());
                        List<BasicData> RelationList = basicDateDao.listByDtidAndCode(map);
                        if (RelationList.size() > 0) {
                            relatedCompanies.setRelationship(RelationList.get(0).getValueCN());
                        }
                    }
                    //企业性质
                    if (null != relatedCompanies && null != relatedCompanies.getCompanyPropertiesId()) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("dictionaryId", 29);
                        map.put("code", relatedCompanies.getCompanyPropertiesId());
                        List<BasicData> CompanyPropertiesList = basicDateDao.listByDtidAndCode(map);
                        if (CompanyPropertiesList.size() > 0) {
                            relatedCompanies.setEntNature(CompanyPropertiesList.get(0).getValueCN());
                        }
                    }
                    //公司状态
                    if (null != relatedCompanies && null != relatedCompanies.getCompanyStatusId()) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("dictionaryId", 30);
                        map.put("code", relatedCompanies.getCompanyStatusId());
                        List<BasicData> CompanyTypesList = basicDateDao.listByDtidAndCode(map);
                        if (CompanyTypesList.size() > 0) {
                            relatedCompanies.setEntStatus(CompanyTypesList.get(0).getValueCN());
                        }
                    }
                    relatedCompaniesList.set(i, relatedCompanies);
                }
                report.setRelatedCompaniesList(relatedCompaniesList);

                //裁判文书
                List<Rulingdocuments> rulingdocumentsList = rulingdocumentsDao.findByFullReportId(fid);
                for (int i = 0; i < rulingdocumentsList.size(); i++) {
                    Rulingdocuments rulingdocuments = rulingdocumentsList.get(i);
                    //执行标的货币单位
                    if (null != rulingdocuments && null != rulingdocuments.getCurrencyId()) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("dictionaryId", 42);
                        map.put("code", Tool.stringToIntStr(rulingdocuments.getCurrencyId()));
                        List<BasicData> CurrencyList = basicDateDao.listByDtidAndCode(map);
                        if (CurrencyList.size() > 0) {
                            rulingdocuments.setPerformingMonetaryUnit(CurrencyList.get(0).getValueCN());
                        }
                    }
                    rulingdocumentsList.set(i, rulingdocuments);
                }
                report.setRulingdocumentsList(rulingdocumentsList);

                //股东
                List<ShareholderInfos> shareholderInfosList = shareholderInfosDao.findByFullReportId(fid);
                for (int i = 0; i < shareholderInfosList.size(); i++) {
                    ShareholderInfos shareholderInfos = shareholderInfosList.get(i);
                    //企业性质
                    if (null != shareholderInfos && null != shareholderInfos.getCompanyPropertiesId()) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("dictionaryId", 29);
                        map.put("code", shareholderInfos.getCompanyPropertiesId());
                        List<BasicData> CompanyPropertiesList = basicDateDao.listByDtidAndCode(map);
                        if (CompanyPropertiesList.size() > 0) {
                            shareholderInfos.setEnterprisenature(CompanyPropertiesList.get(0).getValueCN());
                        }
                    }
                    //公司状态
                    if (null != shareholderInfos && null != shareholderInfos.getCompanyStatusId()) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("dictionaryId", 32);
                        map.put("code", shareholderInfos.getCompanyStatusId());
                        List<BasicData> CompanyStatusList = basicDateDao.listByDtidAndCode(map);
                        if (CompanyStatusList.size() > 0) {
                            shareholderInfos.setEntstatus(CompanyStatusList.get(0).getValueCN());
                        }
                    }
                    //注册货币
                    if (null != shareholderInfos && null != shareholderInfos.getRegisterId()) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("dictionaryId", 42);
                        map.put("code", shareholderInfos.getRegisterId());
                        List<BasicData> CurrencyList = basicDateDao.listByDtidAndCode(map);
                        if (CurrencyList.size() > 0) {
                            shareholderInfos.setRegCurrency(CurrencyList.get(0).getValueCN());
                        }
                    }
                    //股东出资货币
                    if (null != shareholderInfos && null != shareholderInfos.getContributionId()) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("dictionaryId", 42);
                        map.put("code", shareholderInfos.getContributionId());
                        List<BasicData> CurrencyList = basicDateDao.listByDtidAndCode(map);
                        if (CurrencyList.size() > 0) {
                            shareholderInfos.setCapitalContribution(CurrencyList.get(0).getValueCN());
                        }
                    }
                    shareholderInfosList.set(i, shareholderInfos);
                }
                report.setShareholderInfosList(shareholderInfosList);

                //法人其他任职信息
                List<Frpositioninfos> frpositioninfosList = frpositioninfosDao.findByFullReportId(fid);
                report.setFrpositioninfosList(frpositioninfosList);

                //股东链
                List<ShareholdersChain> shareholdersChainList = shareholdersChainDao.findByFullReportId(fid);
                report.setShareholdersChainList(shareholdersChainList);

                //失信被执行人
                List<Sxgg> sxggList = sxggDao.findByFullReportId(fid);
                report.setSxggList(sxggList);

                //网单黑名单
                List<Wdhmd> wdhmdList = wdhmdDao.findByFullReportId(fid);
                report.setWdhmdList(wdhmdList);


                List<PenaltyHis> penaltyHisList = penaltyHisDao.findByFullReportId(fid);
                report.setPenaltyHisList(penaltyHisList);

                List<ShareFrozenHis> shareFrozenHisList = shareFrozenHisDao.findByFullReportId(fid);
                report.setShareFrozenHisList(shareFrozenHisList);

                List<SharePledgeHis> sharePledgeHisList = sharePledgeHisDao.findByFullReportId(fid);
                report.setSharePledgeHisList(sharePledgeHisList);

                //客户
                List<TradeReferences> clientinList = tradeReferencesDao.findByFullReportIdAndFlag(fid, "1");
                report.setClientinfosList(clientinList);

                List<TradeReferences> suppliersList = tradeReferencesDao.findByFullReportIdAndFlag(fid, "0");//供应商
                report.setSuppliersinfosList(suppliersList);

                List<TradeReferences> tradeReferencesList = tradeReferencesDao.findByFullReportId(fid);
                report.setTradeReferencesList(tradeReferencesList);

                List<EnterpriseShareholder> enterpriseShareholderList = enterpriseShareholderDao.findByFullReportId(fid);
                report.setEnterpriseShareholderList(enterpriseShareholderList);

                List<CustomHouse> customHouseList = customHouseDao.findByFullReportId(fid);
                report.setCustomHouseList(customHouseList);
                log.info("数据解析耗时:" + (System.nanoTime() - start));
            }
        }
        return report;
    }

    @Override
    public FullReport getFullReportlitigation(FullReport report) {
        FullReport fullReport = new FullReport();
        report.setNameCN(Tool.replaceSymbol(report.getNameCN()));
        fullReport = fullReportDao.findByName(report.getNameCN());
        //先判断数据库有没有这条记录
        Integer fid = 0;
        if (null != fullReport && null != fullReport.getId() && !"".equals(fullReport.getId())) {
            fid = fullReport.getId();
        } else {
            //没有记录  拿接口数据  解析 保存数据库
            fullReport.setNameCN(report.getNameCN());
            fullReportDao.insert(fullReport);
            fullReport = fullReportDao.findByName(report.getNameCN());
            fid = fullReport.getId();
            //先解析json数据保存数据库
            parseGrande.SaveBusiness(report);
            parseGrande.SaveAssetsAnnual(report);
            cpm.getCpmList(report);
            litigation.getFHLitigationAllList(report);
        }

        return report;
    }

    @Override
    public FullReport getGlobalRegReport(FullReport report) {
        if (report != null && StringUtils.isNotBlank(report.getNameCN())) {
            String nameCN = Tool.replaceSymbol(report.getNameCN());
            //替换中英文括号
            report.setNameCN(nameCN);
            FullReport fullReport = fullReportDao.findByName(nameCN);
            //先判断数据库有没有这条记录
            if (null != fullReport && null != fullReport.getId()) {
                //企业基本信息
                BasicInfos basics = basicInfosDao.findByFullReportId(fullReport.getId());
                report.setBasicInfos(basics);
                //企业注册信息
                RegistrationInfos regInfo = registrationInfosDao.findByFullReportId(fullReport.getId());
                report.setRegistrationInfos(regInfo);
                report.setId(fullReport.getId());
                //公司状态
                if (null != regInfo && null != regInfo.getCompanyStatusId()) {
                    Map<String, Object> params = new HashedMap();
                    params.put("dictionaryId", 32);
                    params.put("code", regInfo.getCompanyStatusId());
                    List<BasicData> companyStatusList = basicDateDao.listByDtidAndCode(params);
                    if (companyStatusList.size() > 0) {
                        regInfo.setCompanyStatus(companyStatusList.get(0).getValueCN());
                    }
                }
                //企业性质
                if (null != regInfo && null != regInfo.getCompanyStatusId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 29);
                    params.put("code", regInfo.getCompanyPropertiesId());
                    List<BasicData> companyPropertiesList = basicDateDao.listByDtidAndCode(params);
                    if (companyPropertiesList.size() > 0) {
                        regInfo.setEntOwnership(companyPropertiesList.get(0).getValueCN());
                    }
                }
                //企业类型
                if (null != regInfo && null != regInfo.getCompanyTypesId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 30);
                    params.put("code", regInfo.getCompanyTypesId());
                    List<BasicData> companyTypesList = basicDateDao.listByDtidAndCode(params);
                    if (companyTypesList.size() > 0) {
                        regInfo.setEntOwnership(companyTypesList.get(0).getValueCN());
                    }
                }
                //企业竞争力
                if (null != regInfo && null != regInfo.getCompetitionId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 44);
                    params.put("code", regInfo.getCompetitionId());
                    List<BasicData> competitionList = basicDateDao.listByDtidAndCode(params);
                    if (competitionList.size() > 0) {
                        regInfo.setCompetitiveness(competitionList.get(0).getValueCN());
                    }
                }
                //注册货币
                if (null != regInfo && null != regInfo.getRegCurrencyId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 42);
                    params.put("code", regInfo.getRegCurrencyId());
                    List<BasicData> currencyList = basicDateDao.listByDtidAndCode(params);
                    if (currencyList.size() > 0) {
                        regInfo.setRegCurrency(currencyList.get(0).getValueCN());
                    }
                }
                //实收货币
                if (null != regInfo && null != regInfo.getPaidCurrencyId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 42);
                    params.put("code", regInfo.getPaidCurrencyId());
                    List<BasicData> currencyList = basicDateDao.listByDtidAndCode(params);
                    if (currencyList.size() > 0) {
                        regInfo.setPaidCurrency(currencyList.get(0).getValueCN());
                    }
                }
                //上市地址
                if (null != regInfo && null != regInfo.getMarketCitiesId()) {
                    Map<String, Object> params = new HashMap();
                    params.put("dictionaryId", 31);
                    params.put("code", regInfo.getMarketCitiesId());
                    List<BasicData> marketCitiesList = basicDateDao.listByDtidAndCode(params);
                    if (marketCitiesList.size() > 0) {
                        regInfo.setMarketAddress(marketCitiesList.get(0).getValueCN());
                    }
                }

            }
            // else {
            //    fullReport = new FullReport();
            //    fullReport.setNameCN(nameCN);
            //    fullReport.setUpdateTime(DateUtil.getCurrentDate());
            //    fullReportDao.insert(fullReport);
            //    fullReport = qiXinBaoParser.copyFullReport(fullReport);
            //    try {
            //        qiXinBaoParser.saveBusiness(fullReport);
            //    } catch (Exception e) {
            //        e.printStackTrace();
            //        log.error("保存启信宝数据错误", e);
            //    }
            //    return fullReport;
            //}
            //if (fullReport == null || fullReport.getQiXinBaoUpdateTime() == null || Constant.qixinbaoUpdateTime < ProAccounts.getCalculateDate(DateUtil.getStringToDate(fullReport.getQiXinBaoUpdateTime()))
            //        || fullReport.getQianHaiUpdateTime() == null || Constant.qianHaiUpdateTime < ProAccounts.getCalculateDate(DateUtil.getStringToDate(fullReport.getQianHaiUpdateTime()))
            //        || fullReport.getLitigationUpdateTime() == null || Constant.litigationUpdateTime < ProAccounts.getCalculateDate(DateUtil.getStringToDate(fullReport.getLitigationUpdateTime()))) {
            //    Map<String, String> map = new HashMap<>();
            //    map.put("nameCN", report.getNameCN());
            //    MqRecord<Map> mqRecord = new MqRecord<>();
            //    mqRecord.setMqType(MqTypeEnum.CN_CN_SAVEFULLREPORT.getValue());
            //    mqRecord.setContent(map);
            //    activemqJmsTemplate.send(creditQueue, new MessageCreator() {
            //        public Message createMessage(Session session) throws JMSException {
            //            String json = JSONObject.toJSONString(mqRecord);
            //            //把公司名称的json放进消息队列
            //            return session.createTextMessage(json);
            //        }
            //    });
            //
            //}
        }
        return report;
    }

    @Override
    public FullReport getGlobalAllReport(FullReport report) {
        if (report != null && StringUtils.isNotBlank(report.getNameCN())) {
            String nameCN = Tool.replaceSymbol(report.getNameCN());
            String crefoNo = report.getCrefoNo();
            //替换中英文括号
            report.setNameCN(nameCN);
            FullReport fullReport = fullReportDao.findByName(report.getNameCN());
            //先判断数据库有没有这条记录
            if (fullReport == null || fullReport.getQiXinBaoUpdateTime() == null || Constant.qixinbaoUpdateTime < ProAccounts.getCalculateDate(DateUtil.getStringToDate(fullReport.getQiXinBaoUpdateTime()))
                    || fullReport.getQianHaiUpdateTime() == null || Constant.qianHaiUpdateTime < ProAccounts.getCalculateDate(DateUtil.getStringToDate(fullReport.getQianHaiUpdateTime()))
                    || fullReport.getLitigationUpdateTime() == null || Constant.litigationUpdateTime < ProAccounts.getCalculateDate(DateUtil.getStringToDate(fullReport.getLitigationUpdateTime()))) {
                //report = qiXinBaoParser.copyFullReport(report);
                //report = qianhai.copyFullreport(report);
                //report = litigation.copyFullreport(report);

                //report = cpm.getGlobalReport(report);
                //全球鹰诉讼数据 TODO:分页数据解析
                //Page page = litigation.getGlobalLitigationList(report);
                //report.setLitigationPage(page);
                //page = litigation.getGlobaBadList(report);
                //report.setBadPage(page);
                Map<String, String> map = new HashMap<>();
                map.put("companyName", nameCN);
                map.put("crefoNo", crefoNo);
                //全球鹰调用中国数据时，往消息队列增加一条记录
                MqRecord<Map> mqRecord = new MqRecord<>();
                mqRecord.setMqType(MqTypeEnum.CN_CN_SAVEFULLREPORT.getValue());
                mqRecord.setContent(map);
                activemqJmsTemplate.send(creditQueue, new MessageCreator() {
                    public Message createMessage(Session session) throws JMSException {
                        String json = JSONObject.toJSONString(mqRecord);
                        //把公司名称的json放进消息队列
                        return session.createTextMessage(json);
                    }
                });
                return null;
            } else {
                report = getAllFullReport(fullReport);
            }
        }

        return report;
    }


    @Override
    public void saveFullReport(FullReport report) {
        if (report != null && StringUtils.isNotBlank(report.getNameCN())) {
            //替换中英文括号
            String nameCN = Tool.replaceSymbol(report.getNameCN());
            report.setNameCN(nameCN);
            FullReport fullReport = fullReportDao.findByName(report.getNameCN());
            String crefoNo = report.getCrefoNo();
            //先判断数据库有没有这条记录
            if (null == fullReport) {
                //没有记录生成fid
                fullReport = new FullReport();
                fullReport.setNameCN(report.getNameCN());
                fullReport.setUpdateTime(DateUtil.getCurrentDate());
                fullReport.setCrefoNo(crefoNo);
                qiXinBaoParser.copyFullReport(report);
                if (report.getRegistrationInfos() == null || StringUtils.isBlank(report.getRegistrationInfos().getNameCN()) || !nameCN.equals(Tool.replaceSymbol(report.getRegistrationInfos().getNameCN()))) {
                    return;
                }

                fullReportDao.insert(fullReport);
                report.setId(fullReport.getId());//将fid插入

                qianhai.copyFullreport(report);
                litigation.copyFullreport(report);
                cpm.copyFullReport(report);
                try {
                    long start = System.nanoTime();
                    report = translateService.cnFullReportTranslate(report);
                    log.info("翻译接口调用时间:" + (System.nanoTime() - start));
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("翻译接口调用失败", e);
                }
                //解析json数据保存数据库
                try {
                    qiXinBaoParser.saveBusiness(report);
                    fullReport.setQiXinBaoUpdateTime(DateUtil.getCurrentDate());
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("启信宝数据解析错误", e);

                }

                try {
                    qianhai.saveBusiness(report);
                    fullReport.setQianHaiUpdateTime(DateUtil.getCurrentDate());
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("前海数据解析错误", e);

                }

                try {
                    litigation.saveBusiness(report);
                    fullReport.setLitigationUpdateTime(DateUtil.getCurrentDate());
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("法海数据解析错误", e);

                }
                try {
                    cpm.saveBusiness(report);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("上市公司接口解析错误", e);
                }

                fullReportDao.update(fullReport);
            } else {
                boolean isUpdate = false;
                try {
                    if (fullReport.getQiXinBaoUpdateTime() != null) {
                        Date qixinbaoDate = DateUtil.getStringToDate(fullReport.getQiXinBaoUpdateTime());
                        if (Constant.qixinbaoUpdateTime < ProAccounts.getCalculateDate(qixinbaoDate)) {//启信宝超时
                            qiXinBaoParser.copyFullReport(fullReport);
                            isUpdate = true;
                        }
                    } else {
                        qiXinBaoParser.copyFullReport(fullReport);
                        isUpdate = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("启信宝数据解析错误" + e);
                }

                try {
                    if (null != fullReport.getQianHaiUpdateTime()) {
                        Date qianHaiDate = DateUtil.getStringToDate(fullReport.getQianHaiUpdateTime());
                        if (Constant.qianHaiUpdateTime < ProAccounts.getCalculateDate(qianHaiDate)) {//前海超时
                            qianhai.copyFullreport(fullReport);
                            isUpdate = true;
                        }
                    } else {
                        qianhai.copyFullreport(fullReport);
                        isUpdate = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("前海数据解析错误", e);

                }

                try {
                    if (null != fullReport.getLitigationUpdateTime()) {
                        Date litigationDate = DateUtil.getStringToDate(fullReport.getLitigationUpdateTime());
                        if (Constant.litigationUpdateTime < ProAccounts.getCalculateDate(litigationDate)) {//法海超时
                            litigation.copyFullreport(fullReport);
                            isUpdate = true;
                        }
                    } else {
                        litigation.copyFullreport(fullReport);
                        isUpdate = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("法海数据解析错误", e);

                }
                if (fullReport.getCpMUpdateTime() == null) {
                    try {
                        cpm.copyFullReport(fullReport);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("上市公司接口解析错误", e);
                    }
                }

                if (isUpdate) {
                    try {
                        long start = System.nanoTime();
                        if (fullReport.getCpMUpdateTime() != null &&
                                Constant.cpMUpdateTime > ProAccounts.getCalculateDate(DateUtil.getStringToDate(fullReport.getCpMUpdateTime()))) {//cpm数据已存在且未超时
                            //过滤cpm已传入的数据
                            String[] donotFields = {"basicInfos", "changeInfosList", "managementsList", "registrationInfos", "shareholderInfosList", "mediaRecordsList", "executiveList", "fyggList", "ktggList", "rulingdocumentsList", "sxggList", "frinvinfosList", "entinvinfosList", "frpositioninfosList"};
                            filterFullReport(fullReport, donotFields);
                        }
                        fullReport = translateService.cnFullReportTranslate(fullReport);
                        log.info("翻译接口调用时间:" + (System.nanoTime() - start));
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("翻译接口调用错误", e);
                    }
                    try {
                        qiXinBaoParser.saveBusiness(fullReport);
                        fullReport.setQiXinBaoUpdateTime(DateUtil.getCurrentDate());
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("启信宝数据解析错误", e);
                    }
                    try {
                        qianhai.saveBusiness(fullReport);
                        fullReport.setQianHaiUpdateTime(DateUtil.getCurrentDate());
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("前海数据解析错误", e);
                    }
                    try {
                        litigation.saveBusiness(fullReport);
                        fullReport.setLitigationUpdateTime(DateUtil.getCurrentDate());
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("法海数据解析错误", e);
                    }
                    try {
                        cpm.saveBusiness(fullReport);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("上市公司接口数据解析错误", e);
                    }
                    fullReport.setUpdateTime(DateUtil.getCurrentDate());
                    fullReportDao.update(fullReport);
                }
            }
            //广播该公司已有数据
            try {
                Map<String, String> map = new HashMap<>();
                map.put("companyName", nameCN);
                MqRecord<Map> mqRecord = new MqRecord<>();
                mqRecord.setMqType(MqTypeEnum.CN_ORDER_UPDATEFULLREPORT.getValue());
                mqRecord.setContent(map);
                activemqJmsTemplate.send(creditQueue, new MessageCreator() {
                    public Message createMessage(Session session) throws JMSException {
                        String json = JSONObject.toJSONString(mqRecord);
                        //把公司名称的json放进消息队列
                        return session.createTextMessage(json);
                    }
                });
            } catch (JmsException e) {
                e.printStackTrace();
                log.error("cn广播该公司数据失败", e);
            }
        }
    }

    @Override
    public ResponseResult getFullReportByModuleType(String companyName, String moduleTypeStr) {
        return null;
    }


    /**
     * 过滤fullReport不需要的数据
     *
     * @param fullReport
     * @param donotField
     * @return
     */
    public static void filterFullReport(FullReport fullReport, String... donotField) {
        if (fullReport != null && donotField != null) {
            List<String> donotFields = Arrays.asList(donotField);
            Field[] fields = fullReport.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (donotFields.contains(field.getName())) {
                    try {
                        field.set(fullReport, null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        log.error("过滤fullReport数据错误", e);
                    }
                }
            }
        }
    }

    public void sendMessage(MqRecord mqRecord) {
        try {
            activemqJmsTemplate.send(creditQueue, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    String json = JSONObject.toJSONString(mqRecord);
                    //把公司名称的json放进消息队列
                    return session.createTextMessage(json);
                }
            });
        } catch (JmsException e) {
            e.printStackTrace();
            log.error("消息队列发送失败", e);
        }
    }

    public static void main(String[] args) {
        FullReport report = new FullReport();
        report.setBgtList(new ArrayList<>());
        report.setWdhmdList(new ArrayList<>());
        report.setFrpositioninfosList(new ArrayList<>());
        System.out.println(report.getWdhmdList() == null);
        filterFullReport(report, "wdhmdList", "frpositioninfosList");
        System.out.println(report.getWdhmdList() == null);
        System.out.println(report.getFrpositioninfosList() == null);
        System.out.println(report.getBgtList() == null);
    }
}
