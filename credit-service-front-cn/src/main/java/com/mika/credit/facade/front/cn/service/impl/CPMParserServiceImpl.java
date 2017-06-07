package com.mika.credit.facade.front.cn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.MqRecord;
import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.common.enums.MqTypeEnum;
import com.mika.credit.common.util.DateUtil;
import com.mika.credit.facade.front.cn.dao.*;
import com.mika.credit.facade.front.cn.service.CPMParserService;
import com.mika.credit.facade.front.cn.util.Tool;
import com.mika.credit.facade.translate.service.TranslateService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/4/11.
 */

@SuppressWarnings("Duplicates")
@Service("cpmParserService")
public class CPMParserServiceImpl implements CPMParserService {
    @Autowired
    private FullReportDao fullReportDao;
    @Autowired
    private MediaRecordsDao mediaRecordsDao;
    @Autowired
    RegistrationInfosDao registrationInfosDao;
    @Autowired
    ChangeInfosDao changeInfosDao;
    @Autowired
    ShareholderInfosDao shareholderInfosDao;
    @Autowired
    ManagementsDao managementsDao;
    @Autowired
    EntinvinfosDao entinvinfosDao;
    @Autowired
    FrinvinfosDao frinvinfosDao;
    @Autowired
    FrpositioninfosDao frpositioninfosDao;
    @Autowired
    BasicInfosDao basicInfosDao;
    @Autowired
    BasicAnnuaDao basicAnnuaDao;
    @Autowired
    AssetsAnnualDao assetsAnnualDao;
    @Autowired
    KtggDao ktggDao;
    @Autowired
    ExecutiveDao executiveDao;
    @Autowired
    RulingdocumentsDao rulingdocumentsDao;
    @Autowired
    SxggDao sxggDao;
    @Autowired
    BankInfosDao bankInfosDao;
    @Autowired
    ChattelMortgageDao chattelMortgageDao;
    @Autowired
    ShareholdersChainDao shareholdersChainDao;
    @Autowired
    HistoryInfosDao historyInfosDao;
    @Autowired
    RelatedCompaniesDao relatedCompaniesDao;
    @Autowired
    OperatingsDao operatingsDao;
    @Autowired
    CustomHouseDao customHouseDao;
    @Autowired
    PaymentHistoriesDao paymentHistoriesDao;
    @Autowired
    TradeReferencesDao tradeReferencesDao;
    @Autowired
    OtherInfosDao otherInfosDao;
    @Autowired
    CreditAssessmentsDao creditAssessmentsDao;
    @Autowired
    FinancialFiguresDao financialFiguresDao;
    @Autowired
    private FinancialRatiosDao financialRatiosDao;
    @Autowired
    private FinancialStatementDao financialStatementDao;
    @Autowired
    private ChattelMortgageDao mortgageDao;
    @Autowired
    private FyggDao fyggDao;
    @Autowired(required = false)
    private TranslateService translateService;
    @Autowired
    private JmsTemplate activemqJmsTemplate;
    @Autowired
    @Qualifier("creditQueue")
    private Destination creditQueue;
    private static Logger logger = Logger.getLogger(CPMParserServiceImpl.class);

    @Override
    public void parseCPM(FullReport report) {
        //try {
        //    report = translateService.cnFullReportTranslate(report);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //    logger.error("翻译接口调用失败:" + e);
        //}
        Integer fullReportId = null;
        Integer insertId = null;
        String companyName = report.getNameCN();
        companyName = Tool.replaceSymbol(companyName);
        report.setNameCN(companyName);
        if (StringUtils.isNotBlank(companyName)) {
            FullReport byName = fullReportDao.findByName(companyName);
            if (byName != null) {
                fullReportId = byName.getId();
                report.setId(fullReportId);
                insertId = fullReportId;
            } else {
                fullReportDao.insert(report);
                insertId = report.getId();
            }
            report.setUpdateTime(DateUtil.getCurrentDate());
            report.setCpMUpdateTime(DateUtil.getCurrentDate());
            fullReportDao.update(report);
            //开庭公告
            List<Ktgg> ktggs = report.getKtggList();
            if (CollectionUtils.isNotEmpty(ktggs)) {
                if (fullReportId != null) {
                    List<Ktgg> ktggsList = ktggDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < ktggsList.size(); i++) {
                        ktggDao.deleteById(ktggsList.get(i).getId());
                    }
                }
                for (Ktgg ktgg : ktggs) {
                    ktgg.setFullReportId(insertId);
                    ktgg.setUpdateTime(DateUtil.getCurrentDate());
                    ktggDao.insert(ktgg);
                }
            }

            //执行公告
            List<Executive> executives = report.getExecutiveList();
            if (CollectionUtils.isNotEmpty(executives)) {
                //执行公告
                if (fullReportId != null) {
                    List<Executive> zxggsList = executiveDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < zxggsList.size(); i++) {
                        executiveDao.deleteById(zxggsList.get(i).getId());
                    }
                }
                for (Executive executive : executives) {
                    executive.setFullReportId(insertId);
                    executive.setUpdateTime(DateUtil.getCurrentDate());
                    executiveDao.insert(executive);
                }
            }

            //银行信息
            List<BankInfos> bankInfoses = report.getBankInfosList();
            if (CollectionUtils.isNotEmpty(bankInfoses)) {
                if (fullReportId != null) {
                    List<BankInfos> bankInfosList = bankInfosDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(bankInfosList)) {
                        for (BankInfos bankInfos : bankInfosList) {
                            bankInfosDao.deleteById(bankInfos.getId());
                        }
                    }
                }
                for (BankInfos bankInfose : bankInfoses) {
                    bankInfose.setFullReportId(insertId);
                    bankInfose.setUpdateTime(DateUtil.getCurrentDate());
                    bankInfosDao.insert(bankInfose);
                }

            }

            //法院公告
            List<Fygg> fyggList = report.getFyggList();
            if (CollectionUtils.isNotEmpty(fyggList)) {
                if (fullReportId != null) {
                    List<Fygg> fyggs = fyggDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(fyggs)) {
                        for (Fygg fygg : fyggs) {
                            fyggDao.deleteById(fygg.getId());
                        }
                    }
                }
                for (Fygg fygg : fyggList) {
                    fygg.setFullReportId(insertId);
                    fygg.setUpdateTime(DateUtil.getCurrentDate());
                    fyggDao.insert(fygg);
                }
            }
            //裁判文书
            List<Rulingdocuments> rulingdocumentses = report.getRulingdocumentsList();
            if (CollectionUtils.isNotEmpty(rulingdocumentses)) {
                //裁判文书
                if (fullReportId != null) {
                    List<Rulingdocuments> cpwssList = rulingdocumentsDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < cpwssList.size(); i++) {
                        rulingdocumentsDao.deleteById(cpwssList.get(i).getId());
                    }
                }
                for (Rulingdocuments rulingdocuments : rulingdocumentses) {
                    rulingdocuments.setFullReportId(insertId);
                    rulingdocuments.setUpdateTime(DateUtil.getCurrentDate());
                    rulingdocumentsDao.insert(rulingdocuments);
                }
            }
            //失信被执行人
            List<Sxgg> sxggs = report.getSxggList();
            if (CollectionUtils.isNotEmpty(sxggs)) {
                if (fullReportId != null) {
                    List<Sxgg> sxggsList = sxggDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < sxggsList.size(); i++) {
                        sxggDao.deleteById(sxggsList.get(i).getId());
                    }
                }
                for (Sxgg sxgg : sxggs) {
                    sxgg.setFullReportId(insertId);
                    sxgg.setUpdateTime(DateUtil.getCurrentDate());
                    sxggDao.insert(sxgg);
                }
            }

            //注册信息
            RegistrationInfos registrationInfos = report.getRegistrationInfos();
            if (registrationInfos != null) {
                //注册信息
                if (fullReportId != null) {
                    RegistrationInfos hisReg = registrationInfosDao.findByFullReportId(fullReportId);
                    if (null != hisReg && hisReg.getId() != null) {
                        registrationInfosDao.deleteById(hisReg.getId());
                    }
                }
                registrationInfos.setFullReportId(insertId);
                registrationInfos.setUpdateTime(DateUtil.getCurrentDate());
                registrationInfosDao.insert(registrationInfos);
            }

            //股东信息
            List<ShareholderInfos> shareholderInfoses = report.getShareholderInfosList();
            if (CollectionUtils.isNotEmpty(shareholderInfoses)) {
                if (fullReportId != null) {
                    List<ShareholderInfos> shareholderInfosList = shareholderInfosDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < shareholderInfosList.size(); i++) {
                        shareholderInfosDao.deleteById(shareholderInfosList.get(i).getId());
                    }
                }
                for (ShareholderInfos shareholderInfos : shareholderInfoses) {
                    shareholderInfos.setFullReportId(insertId);
                    shareholderInfos.setUpdateTime(DateUtil.getCurrentDate());
                    String shares = shareholderInfos.getShares();
                    if (StringUtils.isNotBlank(shares) && !shares.contains("%")) {
                        shareholderInfos.setShares(shares + "%");
                    }
                    shareholderInfosDao.insert(shareholderInfos);
                }
            }

            //管理层信息
            List<Managements> managementses = report.getManagementsList();
            if (CollectionUtils.isNotEmpty(managementses)) {
                if (fullReportId != null) {
                    List<Managements> managementsList = managementsDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < managementsList.size(); i++) {
                        managementsDao.deleteById(managementsList.get(i).getId());
                    }
                }
                for (Managements managements : managementses) {
                    managements.setFullReportId(insertId);
                    managements.setUpdateTime(DateUtil.getCurrentDate());
                    managementsDao.insert(managements);
                }
            }
            //法人对外投资信息
            List<Frinvinfos> frinvinfoses = report.getFrinvinfosList();
            if (CollectionUtils.isNotEmpty(frinvinfoses)) {
                if (fullReportId != null) {
                    List<Frinvinfos> frinvinfosList = frinvinfosDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < frinvinfosList.size(); i++) {
                        frinvinfosDao.deleteById(frinvinfosList.get(i).getId());
                    }
                }
                for (Frinvinfos frinvinfos : frinvinfoses) {
                    frinvinfos.setFullReportId(insertId);
                    frinvinfos.setUpdateTime(DateUtil.getCurrentDate());
                    frinvinfosDao.insert(frinvinfos);
                }
            }
            //企业对外投资信息
            List<Entinvinfos> entinvinfoses = report.getEntinvinfosList();
            if (CollectionUtils.isNotEmpty(entinvinfoses)) {
                if (fullReportId != null) {
                    List<Entinvinfos> entinvinfosList = entinvinfosDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < entinvinfosList.size(); i++) {
                        entinvinfosDao.deleteById(entinvinfosList.get(i).getId());
                    }
                }
                for (Entinvinfos entinvinfos : entinvinfoses) {
                    entinvinfos.setFullReportId(insertId);
                    entinvinfos.setUpdateTime(DateUtil.getCurrentDate());
                    entinvinfosDao.insert(entinvinfos);
                }
            }
            //法人其他任职信息
            List<Frpositioninfos> frpositioninfoses = report.getFrpositioninfosList();
            if (CollectionUtils.isNotEmpty(frpositioninfoses)) {
                if (fullReportId != null) {
                    List<Frpositioninfos> frpositioninfosList = frpositioninfosDao.findByFullReportId(fullReportId);
                    for (int i = 0; i < frpositioninfosList.size(); i++) {
                        frpositioninfosDao.deleteById(frpositioninfosList.get(i).getId());
                    }
                }
                for (Frpositioninfos frpositioninfos : frpositioninfoses) {
                    frpositioninfos.setFullReportId(insertId);
                    frpositioninfos.setUpdateTime(DateUtil.getCurrentDate());
                    frpositioninfosDao.insert(frpositioninfos);
                }
            }


            //工商注册变更
            List<ChangeInfos> changeInfosList = report.getChangeInfosList();
            if (CollectionUtils.isNotEmpty(changeInfosList)) {
                //先删除数据库已有的注册变更数据
                if (fullReportId != null) {
                    List<ChangeInfos> changeList = changeInfosDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(changeList)) {
                        for (ChangeInfos aChangeList : changeList) {
                            changeInfosDao.deleteById(aChangeList.getId());
                        }
                    }
                }
                for (ChangeInfos changeInfos : changeInfosList) {
                    changeInfos.setFullReportId(insertId);
                    changeInfos.setUpdateTime(DateUtil.getCurrentDate());
                    changeInfosDao.insert(changeInfos);
                }
            }


            //媒体记录
            List<MediaRecords> mediaRecordsList = report.getMediaRecordsList();
            if (CollectionUtils.isNotEmpty(mediaRecordsList)) {
                if (fullReportId != null) {
                    //删除已有媒体记录
                    List<MediaRecords> recordses = mediaRecordsDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(recordses)) {
                        for (MediaRecords recordse : recordses) {
                            mediaRecordsDao.deleteById(recordse.getId());
                        }
                    }
                }
                for (MediaRecords mediaRecords : mediaRecordsList) {
                    mediaRecords.setFullReportId(insertId);
                    mediaRecords.setUpdateTime(DateUtil.getCurrentDate());
                    mediaRecordsDao.insert(mediaRecords);

                }
            }

            //股东链
            List<ShareholdersChain> shareholdersChains = report.getShareholdersChainList();
            if (CollectionUtils.isNotEmpty(shareholdersChains)) {
                if (fullReportId != null) {
                    List<ShareholdersChain> chainList = shareholdersChainDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(chainList)) {
                        for (ShareholdersChain shareholdersChain : chainList) {
                            shareholdersChainDao.deleteById(shareholdersChain.getId());
                        }
                    }
                }
                for (ShareholdersChain shareholdersChain : shareholdersChains) {
                    shareholdersChain.setFullReportId(insertId);
                    shareholdersChain.setUpdateTime(DateUtil.getCurrentDate());
                    shareholdersChainDao.insert(shareholdersChain);
                }
            }
            //历史背景沿革
            List<HistoryInfos> historyInfosList = report.getHistoryInfosList();
            if (CollectionUtils.isNotEmpty(historyInfosList)) {
                if (fullReportId != null) {
                    List<HistoryInfos> historyInfoses = historyInfosDao.findByFullReportId(fullReportId);
                    for (HistoryInfos historyInfos : historyInfoses) {
                        historyInfosDao.deleteById(historyInfos.getId());
                    }
                }
                for (HistoryInfos historyInfos : historyInfosList) {
                    historyInfos.setFullReportId(insertId);
                    historyInfos.setUpdateTime(DateUtil.getCurrentDate());
                    historyInfosDao.insert(historyInfos);
                }
            }
            //关联公司
            List<RelatedCompanies> relatedCompanies = report.getRelatedCompaniesList();
            if (CollectionUtils.isNotEmpty(relatedCompanies)) {
                if (fullReportId != null) {
                    List<RelatedCompanies> companies = relatedCompaniesDao.findByFullReportId(fullReportId);
                    for (RelatedCompanies company : companies) {
                        relatedCompaniesDao.deleteById(company.getId());
                    }
                }
                for (RelatedCompanies relatedCompany : relatedCompanies) {
                    relatedCompany.setFullReportId(insertId);
                    relatedCompany.setUpdateTime(DateUtil.getCurrentDate());
                    relatedCompaniesDao.insert(relatedCompany);
                }
            }
            //经营现状
            Operatings operatings = report.getOperatings();
            if (operatings != null) {
                if (fullReportId != null) {
                    List<Operatings> operatingses = operatingsDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(operatingses)) {
                        for (Operatings operatingse : operatingses) {
                            operatingsDao.deleteById(operatingse.getId());
                        }
                    }
                }
                operatings.setFullReportId(insertId);
                operatings.setUpdateTime(DateUtil.getCurrentDate());
                operatingsDao.insert(operatings);
            }
            //海关信息
            List<CustomHouse> customHouses = report.getCustomHouseList();
            if (CollectionUtils.isNotEmpty(customHouses)) {
                if (fullReportId != null) {
                    List<CustomHouse> customHouseList = customHouseDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(customHouseList)) {
                        for (CustomHouse customHouse : customHouseList) {
                            customHouseDao.deleteById(customHouse.getId());
                        }
                    }
                }
                for (CustomHouse customHouse : customHouses) {
                    customHouse.setFullReportId(insertId);
                    customHouse.setUpdateTime(DateUtil.getCurrentDate());
                    customHouseDao.insert(customHouse);
                }
            }
            //支付款记录
            List<PaymentHistories> paymentHistories = report.getPaymentHistoriesList();
            if (CollectionUtils.isNotEmpty(paymentHistories)) {
                if (fullReportId != null) {
                    List<PaymentHistories> historiesList = paymentHistoriesDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(historiesList)) {
                        for (PaymentHistories histories : historiesList) {
                            paymentHistoriesDao.deleteById(histories.getId());
                        }
                    }
                }
                for (PaymentHistories paymentHistory : paymentHistories) {
                    paymentHistory.setFullReportId(insertId);
                    paymentHistory.setUpdateTime(DateUtil.getCurrentDate());
                    paymentHistoriesDao.insert(paymentHistory);
                }
            }
            //贸易参考
            List<TradeReferences> tradeReferences = report.getTradeReferencesList();
            if (CollectionUtils.isNotEmpty(tradeReferences)) {
                if (fullReportId != null) {
                    List<TradeReferences> referencesList = tradeReferencesDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(referencesList)) {
                        for (TradeReferences references : referencesList) {
                            tradeReferencesDao.deleteById(references.getId());
                        }
                    }
                }
                for (TradeReferences tradeReference : tradeReferences) {
                    tradeReference.setFullReportId(insertId);
                    tradeReference.setUpdateTime(DateUtil.getCurrentDate());
                    tradeReferencesDao.insert(tradeReference);
                }
            }
            //其他信息
            List<OtherInfos> otherInfosList = report.getOtherInfosList();
            if (CollectionUtils.isNotEmpty(otherInfosList)) {
                if (fullReportId != null) {
                    List<OtherInfos> otherInfoses = otherInfosDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(otherInfoses)) {
                        for (OtherInfos otherInfose : otherInfoses) {
                            otherInfosDao.deleteById(otherInfose.getId());
                        }
                    }
                }
                for (OtherInfos otherInfos : otherInfosList) {
                    otherInfos.setFullReportId(insertId);
                    otherInfos.setUpdateTime(DateUtil.getCurrentDate());
                    otherInfosDao.insert(otherInfos);
                }
            }
            //财务数据
            List<FinancialStatement> financialStatementList = report.getFinancialStatementList();
            if (CollectionUtils.isNotEmpty(financialStatementList)) {
                if (fullReportId != null) {
                    List<FinancialStatement> byFullReportId = financialStatementDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(byFullReportId)) {
                        for (FinancialStatement financialStatement : byFullReportId) {
                            financialStatementDao.deleteById(financialStatement.getId());
                        }
                    }
                }
                for (FinancialStatement financialStatement : financialStatementList) {
                    financialStatement.setFullReportId(insertId);
                    financialStatement.setUpdateTime(DateUtil.getCurrentDate());
                    financialStatementDao.insert(financialStatement);
                }
            }

            //财务分析
            List<FinancialRatios> financialRatiosList = report.getFinancialRatiosList();
            if (CollectionUtils.isNotEmpty(financialRatiosList)) {
                if (fullReportId != null) {
                    List<FinancialRatios> byFullReportId = financialRatiosDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(byFullReportId)) {
                        for (FinancialRatios financialRatios : byFullReportId) {
                            financialRatiosDao.deleteById(financialRatios.getId());
                        }
                    }
                }
                for (FinancialRatios financialRatios : financialRatiosList) {
                    financialRatios.setFullReportId(insertId);
                    financialRatios.setUpdateTime(DateUtil.getCurrentDate());
                    financialRatiosDao.insert(financialRatios);
                }
            }

            //财物说明
            List<FinancialFigures> figuresList = report.getFinancialFiguresList();
            if (CollectionUtils.isNotEmpty(figuresList)) {
                if (fullReportId != null) {
                    List<FinancialFigures> financialFigures = financialFiguresDao.findByFullReportId(fullReportId);
                    if (CollectionUtils.isNotEmpty(financialFigures)) {
                        for (FinancialFigures financialFigure : financialFigures) {
                            financialFiguresDao.deleteById(financialFigure.getId());
                        }
                    }
                }
                for (FinancialFigures figures : figuresList) {
                    figures.setFullReportId(insertId);
                    figures.setUpdateTime(DateUtil.getCurrentDate());
                    financialFiguresDao.insert(figures);
                }
            }
            //信用评估
            CreditAssessments creditAssessments = report.getCreditAssessments();
            if (creditAssessments != null) {
                if (fullReportId != null) {
                    CreditAssessments assessments = creditAssessmentsDao.findByFullReportId(fullReportId);
                    if (assessments != null && assessments.getId() != null) {
                        creditAssessmentsDao.deleteById(assessments.getId());
                    }
                }
                creditAssessments.setFullReportId(insertId);
                creditAssessments.setUpdateTime(DateUtil.getCurrentDate());
                creditAssessmentsDao.insert(creditAssessments);
            }

            //基本信息
            BasicInfos basicInfos = report.getBasicInfos();
            if (basicInfos != null) {
                if (fullReportId != null) {
                    BasicInfos infos = basicInfosDao.findByFullReportId(fullReportId);
                    if (infos != null && infos.getId() != null) {
                        basicInfosDao.deleteById(infos.getId());
                    }
                }
                basicInfos.setFullReportId(insertId);
                basicInfos.setUpdateTime(DateUtil.getCurrentDate());
                basicInfosDao.insert(basicInfos);
            }

            //年报基本信息
            List<BasicAnnua> baiscAnnuaList = report.getBaiscAnnuaList();
            if (CollectionUtils.isNotEmpty(baiscAnnuaList)) {
                if (fullReportId != null) {
                    List<BasicAnnua> basicAnnuas = basicAnnuaDao.findByFullReportId(fullReportId);
                    for (BasicAnnua basicAnnua : basicAnnuas) {
                        basicAnnuaDao.deleteById(basicAnnua.getId());
                    }
                }
                for (BasicAnnua basicAnnua : baiscAnnuaList) {
                    basicAnnua.setFullReportId(insertId);
                    basicAnnua.setUpdateTime(DateUtil.getCurrentDate());
                    basicAnnuaDao.insert(basicAnnua);
                }
            }

            //年报资产信息
            List<AssetsAnnual> assetsAnnualList = report.getAssetsAnnualList();
            if (CollectionUtils.isNotEmpty(assetsAnnualList)) {
                if (fullReportId != null) {
                    List<AssetsAnnual> annuals = assetsAnnualDao.findByFullReportId(fullReportId);
                    for (AssetsAnnual annual : annuals) {
                        assetsAnnualDao.deleteById(annual.getId());
                    }
                }
                for (AssetsAnnual assetsAnnual : assetsAnnualList) {
                    assetsAnnual.setUpdateTime(DateUtil.getCurrentDate());
                    assetsAnnual.setFullReportId(insertId);
                    assetsAnnualDao.insert(assetsAnnual);
                }
            }

            //动产抵押基本信息
            List<ChattelMortgage> mortgages = report.getChattelMortgageList();
            if (CollectionUtils.isNotEmpty(mortgages)) {
                if (fullReportId != null) {
                    List<ChattelMortgage> mortgageList = chattelMortgageDao.findByFullReportId(fullReportId);
                    for (ChattelMortgage chattelMortgage : mortgageList) {
                        chattelMortgageDao.deleteById(chattelMortgage.getId());
                    }
                }
                for (ChattelMortgage mortgage : mortgages) {
                    mortgage.setFullReportId(insertId);
                    mortgage.setUpdateTime(DateUtil.getCurrentDate());
                    mortgageDao.insert(mortgage);
                }
            }

            try {
                //广播该公司已有数据
                Map<String, String> map = new HashMap<>();
                map.put("companyName", companyName);
                map.put("crefoNo",report.getCrefoNo());
                MqRecord<Map> mqRecord = new MqRecord<>();
                mqRecord.setMqType(MqTypeEnum.CPM_ORDER_UPDATEFULLREPORT.getValue());
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
                logger.error("cpm广播该公司已有数据失败", e);
            }
        }
    }
}
