package com.mika.credit.common.entity.report.cn;


import com.mika.credit.common.entity.BaseEntity;
import com.mika.credit.common.util.Page;

import java.util.List;

/**
 * 数据库报告
 * @author ZhuJun，ShenYi.
 * TODO:fullreport 缺失商标,工商被执行人
 * Created by dell on 2017/2/19.
 */
public class FullReport extends BaseEntity {
    /**
     * 企业名称
     */
    private String nameCN;
    /**
     * 科氏号码
     */
    private String crefoNo;
    /**
     *更新时间
     */
    private String updateTime;
    /**
     *格兰德数据更新时间
     */
    private String grandeUpdeTime;
    /**
     *前海更新时间
     */
    private String qianHaiUpdateTime;
    /**
     *诉讼更新时间
     */
    private String litigationUpdateTime;
    /**
     *cpm数据更新时间
     */
    private String cpMUpdateTime;
    /**
     *财务更新时间
     */
    private String financialUpdateTime;

    /**
     * 启信宝更新时间
     */
    private String qiXinBaoUpdateTime;

    /**
     *案件流程信息
     */
    private List<Ajlc> ajlcList;
    /**
     *年报资产信息
     */
    private List<AssetsAnnual> assetsAnnualList;
    /**
     *年报基本信息
     */
    private List<BasicAnnua> baiscAnnuaList;
    /**
     *银行信息
     */
    private List<BankInfos> bankInfosList;
    /**
     *企业基本信息
     */
    private BasicInfos basicInfos;
    /**
     *曝光台
     */
    private List<Bgt> bgtList;
    /**
     *品牌专利
     */
    private List<Brands> brandsList;
    /**
     *注册变更表
     */
    private List<ChangeInfos> changeInfosList;
    /**
     *动产抵押登记信息
     */
    private List<ChattelMortgage> chattelMortgageList;
    /**
     *分析评估
     */
    private CreditAssessments creditAssessments;
    /**
     *企业对外投资信息
     */
    private List<Entinvinfos> entinvinfosList;
    /**
     *执行公告
     */
    private List<Executive> executiveList;
    /**
     *财物说明
     */
    private List<FinancialFigures> financialFiguresList;
    /**
     *财务分析
     */
    private List<FinancialRatios> financialRatiosList;
    /**
     *财务数据
     */
    private List<FinancialStatement> financialStatementList;
    /**
     *法人对外投资信息
     */
    private List<Frinvinfos> frinvinfosList;
    /**
     *法院公告
     */
    private List<Fygg> fyggList;
    /**
     *年报提供担保信息
     */
    private List<GuaranteeAnnual> guaranteeAnnualList;
    /**
     *历史背景沿革
     */
    private List<HistoryInfos> historyInfosList;
    /**
     *网站
     */
    private List<IcpWebsite> icpWebsiteList;
    /**
     *开庭公告
     */
    private List<Ktgg> ktggList;
    /**
     *管理层信息
     */
    private List<Managements> managementsList;
    /**
     *媒体记录表
     */
    private List<MediaRecords> mediaRecordsList;
    /**
     *经营现状表
     */
    private Operatings operatings;
    /**
     *经营异常
     */
    private List<OperationAbnormalInfos> operationAbnormalInfosList;
    /**
     *支付款记录
     */
    private List<PaymentHistories> paymentHistoriesList;
    /**
     *注册信息
     */
    private RegistrationInfos registrationInfos;
    /**
     *关联公司信息
     */
    private List<RelatedCompanies> relatedCompaniesList;
    /**
     *裁判文书
     */
    private List<Rulingdocuments> rulingdocumentsList;
    /**
     *股东信息
     */
    private List<ShareholderInfos> shareholderInfosList;
    /**
     *股东链
     */
    private List<ShareholdersChain> shareholdersChainList;
    /**
     *失信被执行人
     */
    private List<Sxgg> sxggList;
    /**
     *网单黑名单
     */
    private List<Wdhmd> wdhmdList;
    /**
     *工商行政处罚记录
     */
    private List<PenaltyHis> penaltyHisList;
    /**
     *股权冻结记录
     */
    private List<ShareFrozenHis> shareFrozenHisList;
    /**
     *股权出质记录
     */
    private List<SharePledgeHis> sharePledgeHisList;
    /**
     *法人其他任职信息
     */
    private List<Frpositioninfos> frpositioninfosList;
    /**
     *贸易参考 /供应商
     */
    private List<TradeReferences> suppliersinfosList;
    /**
     *贸易参考 /客户
     */
    private List<TradeReferences> clientinfosList;
    /**
     *贸易参考
     */
    private List<TradeReferences> tradeReferencesList;
    /**
     *其他信息
     */
    private List<OtherInfos> otherInfosList;
    /**
     *企业公示股东及出资
     */
    private List<EnterpriseShareholder> EnterpriseShareholderList;
    /**
     *海关信息
     */
    private List<CustomHouse> CustomHouseList;
    /**
     *股权股本
     */
    private ShareCapital shareCapital;
    /**
     *分页对象.
     */
    private Page litigationPage;
    /**
     *分页对象.
     */
    private Page badPage;
    //外键
    private Integer ajlcListId;
    private Integer assetsAnnualListId;
    private Integer baiscAnnuaListId;
    private Integer bankInfosListId;
    private Integer basicInfosId;
    private Integer bgtListId;
    private Integer brandsListId;
    private Integer changeInfosListId;
    private Integer chattelMortgageListId;
    private Integer creditAssessmentsId;
    private Integer entinvinfosListId;
    private Integer executiveListId;
    private Integer financialFiguresListId;
    private Integer financialRatiosListId;
    private Integer financialStatementListId;
    private Integer frinvinfosListId;
    private Integer fyggListId;
    private Integer guaranteeAnnualListId;
    private Integer historyInfosListId;
    private Integer icpWebsiteListId;
    private Integer ktggListId;
    private Integer managementsListId;
    private Integer mediaRecordsListId;
    private Integer operatingsId;
    private Integer operationAbnormalInfosListId;
    private Integer paymentHistoriesListId;
    private Integer registrationInfosId;
    private Integer relatedCompaniesListId;
    private Integer rulingDocumentsListId;
    private Integer shareholderInfosListId;
    private Integer shareholdersChainListId;
    private Integer sxggListId;
    private Integer wdhmdListId;
    private Integer penaltyHisListId;
    private Integer shareFrozenHisListId;
    private Integer sharePledgeHisListId;
    private Integer frpositioninfosListId;
    private Integer tradeReferencesListId;
    private Integer otherInfosListId;
    private Integer EnterpriseShareholderId;
    private Integer CustomHouseId;


    public String getQiXinBaoUpdateTime() {
        return qiXinBaoUpdateTime;
    }

    public void setQiXinBaoUpdateTime(String qiXinBaoUpdateTime) {
        this.qiXinBaoUpdateTime = qiXinBaoUpdateTime;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getCrefoNo() {
        return crefoNo;
    }

    public void setCrefoNo(String crefoNo) {
        this.crefoNo = crefoNo;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getGrandeUpdeTime() {
        return grandeUpdeTime;
    }

    public void setGrandeUpdeTime(String grandeUpdeTime) {
        this.grandeUpdeTime = grandeUpdeTime;
    }

    public String getQianHaiUpdateTime() {
        return qianHaiUpdateTime;
    }

    public void setQianHaiUpdateTime(String qianHaiUpdateTime) {
        this.qianHaiUpdateTime = qianHaiUpdateTime;
    }

    public String getLitigationUpdateTime() {
        return litigationUpdateTime;
    }

    public void setLitigationUpdateTime(String litigationUpdateTime) {
        this.litigationUpdateTime = litigationUpdateTime;
    }

    public String getCpMUpdateTime() {
        return cpMUpdateTime;
    }

    public void setCpMUpdateTime(String cpMUpdateTime) {
        this.cpMUpdateTime = cpMUpdateTime;
    }

    public String getFinancialUpdateTime() {
        return financialUpdateTime;
    }

    public void setFinancialUpdateTime(String financialUpdateTime) {
        this.financialUpdateTime = financialUpdateTime;
    }

    public List<Ajlc> getAjlcList() {
        return ajlcList;
    }

    public void setAjlcList(List<Ajlc> ajlcList) {
        this.ajlcList = ajlcList;
    }

    public List<AssetsAnnual> getAssetsAnnualList() {
        return assetsAnnualList;
    }

    public void setAssetsAnnualList(List<AssetsAnnual> assetsAnnualList) {
        this.assetsAnnualList = assetsAnnualList;
    }

    public List<BasicAnnua> getBaiscAnnuaList() {
        return baiscAnnuaList;
    }

    public void setBaiscAnnuaList(List<BasicAnnua> baiscAnnuaList) {
        this.baiscAnnuaList = baiscAnnuaList;
    }

    public List<BankInfos> getBankInfosList() {
        return bankInfosList;
    }

    public void setBankInfosList(List<BankInfos> bankInfosList) {
        this.bankInfosList = bankInfosList;
    }

    public BasicInfos getBasicInfos() {
        return basicInfos;
    }

    public void setBasicInfos(BasicInfos basicInfos) {
        this.basicInfos = basicInfos;
    }

    public List<Bgt> getBgtList() {
        return bgtList;
    }

    public void setBgtList(List<Bgt> bgtList) {
        this.bgtList = bgtList;
    }

    public List<Brands> getBrandsList() {
        return brandsList;
    }

    public void setBrandsList(List<Brands> brandsList) {
        this.brandsList = brandsList;
    }

    public List<ChangeInfos> getChangeInfosList() {
        return changeInfosList;
    }

    public void setChangeInfosList(List<ChangeInfos> changeInfosList) {
        this.changeInfosList = changeInfosList;
    }

    public List<ChattelMortgage> getChattelMortgageList() {
        return chattelMortgageList;
    }

    public void setChattelMortgageList(List<ChattelMortgage> chattelMortgageList) {
        this.chattelMortgageList = chattelMortgageList;
    }

    public CreditAssessments getCreditAssessments() {
        return creditAssessments;
    }

    public void setCreditAssessments(CreditAssessments creditAssessments) {
        this.creditAssessments = creditAssessments;
    }

    public List<Entinvinfos> getEntinvinfosList() {
        return entinvinfosList;
    }

    public void setEntinvinfosList(List<Entinvinfos> entinvinfosList) {
        this.entinvinfosList = entinvinfosList;
    }

    public List<Executive> getExecutiveList() {
        return executiveList;
    }

    public void setExecutiveList(List<Executive> executiveList) {
        this.executiveList = executiveList;
    }

    public List<FinancialFigures> getFinancialFiguresList() {
        return financialFiguresList;
    }

    public void setFinancialFiguresList(List<FinancialFigures> financialFiguresList) {
        this.financialFiguresList = financialFiguresList;
    }

    public List<FinancialRatios> getFinancialRatiosList() {
        return financialRatiosList;
    }

    public void setFinancialRatiosList(List<FinancialRatios> financialRatiosList) {
        this.financialRatiosList = financialRatiosList;
    }

    public List<FinancialStatement> getFinancialStatementList() {
        return financialStatementList;
    }

    public void setFinancialStatementList(List<FinancialStatement> financialStatementList) {
        this.financialStatementList = financialStatementList;
    }

    public List<Frinvinfos> getFrinvinfosList() {
        return frinvinfosList;
    }

    public void setFrinvinfosList(List<Frinvinfos> frinvinfosList) {
        this.frinvinfosList = frinvinfosList;
    }

    public List<Fygg> getFyggList() {
        return fyggList;
    }

    public void setFyggList(List<Fygg> fyggList) {
        this.fyggList = fyggList;
    }

    public List<GuaranteeAnnual> getGuaranteeAnnualList() {
        return guaranteeAnnualList;
    }

    public void setGuaranteeAnnualList(List<GuaranteeAnnual> guaranteeAnnualList) {
        this.guaranteeAnnualList = guaranteeAnnualList;
    }

    public List<HistoryInfos> getHistoryInfosList() {
        return historyInfosList;
    }

    public void setHistoryInfosList(List<HistoryInfos> historyInfosList) {
        this.historyInfosList = historyInfosList;
    }

    public List<IcpWebsite> getIcpWebsiteList() {
        return icpWebsiteList;
    }

    public void setIcpWebsiteList(List<IcpWebsite> icpWebsiteList) {
        this.icpWebsiteList = icpWebsiteList;
    }

    public List<Ktgg> getKtggList() {
        return ktggList;
    }

    public void setKtggList(List<Ktgg> ktggList) {
        this.ktggList = ktggList;
    }

    public List<Managements> getManagementsList() {
        return managementsList;
    }

    public void setManagementsList(List<Managements> managementsList) {
        this.managementsList = managementsList;
    }

    public List<MediaRecords> getMediaRecordsList() {
        return mediaRecordsList;
    }

    public void setMediaRecordsList(List<MediaRecords> mediaRecordsList) {
        this.mediaRecordsList = mediaRecordsList;
    }

    public Operatings getOperatings() {
        return operatings;
    }

    public void setOperatings(Operatings operatings) {
        this.operatings = operatings;
    }

    public List<OperationAbnormalInfos> getOperationAbnormalInfosList() {
        return operationAbnormalInfosList;
    }

    public void setOperationAbnormalInfosList(List<OperationAbnormalInfos> operationAbnormalInfosList) {
        this.operationAbnormalInfosList = operationAbnormalInfosList;
    }

    public List<PaymentHistories> getPaymentHistoriesList() {
        return paymentHistoriesList;
    }

    public void setPaymentHistoriesList(List<PaymentHistories> paymentHistoriesList) {
        this.paymentHistoriesList = paymentHistoriesList;
    }

    public RegistrationInfos getRegistrationInfos() {
        return registrationInfos;
    }

    public void setRegistrationInfos(RegistrationInfos registrationInfos) {
        this.registrationInfos = registrationInfos;
    }

    public List<RelatedCompanies> getRelatedCompaniesList() {
        return relatedCompaniesList;
    }

    public void setRelatedCompaniesList(List<RelatedCompanies> relatedCompaniesList) {
        this.relatedCompaniesList = relatedCompaniesList;
    }

    public List<Rulingdocuments> getRulingdocumentsList() {
        return rulingdocumentsList;
    }

    public void setRulingdocumentsList(List<Rulingdocuments> rulingdocumentsList) {
        this.rulingdocumentsList = rulingdocumentsList;
    }

    public List<ShareholderInfos> getShareholderInfosList() {
        return shareholderInfosList;
    }

    public void setShareholderInfosList(List<ShareholderInfos> shareholderInfosList) {
        this.shareholderInfosList = shareholderInfosList;
    }

    public List<ShareholdersChain> getShareholdersChainList() {
        return shareholdersChainList;
    }

    public void setShareholdersChainList(List<ShareholdersChain> shareholdersChainList) {
        this.shareholdersChainList = shareholdersChainList;
    }

    public List<Sxgg> getSxggList() {
        return sxggList;
    }

    public void setSxggList(List<Sxgg> sxggList) {
        this.sxggList = sxggList;
    }

    public List<Wdhmd> getWdhmdList() {
        return wdhmdList;
    }

    public void setWdhmdList(List<Wdhmd> wdhmdList) {
        this.wdhmdList = wdhmdList;
    }

    public List<PenaltyHis> getPenaltyHisList() {
        return penaltyHisList;
    }

    public void setPenaltyHisList(List<PenaltyHis> penaltyHisList) {
        this.penaltyHisList = penaltyHisList;
    }

    public List<ShareFrozenHis> getShareFrozenHisList() {
        return shareFrozenHisList;
    }

    public void setShareFrozenHisList(List<ShareFrozenHis> shareFrozenHisList) {
        this.shareFrozenHisList = shareFrozenHisList;
    }

    public List<SharePledgeHis> getSharePledgeHisList() {
        return sharePledgeHisList;
    }

    public void setSharePledgeHisList(List<SharePledgeHis> sharePledgeHisList) {
        this.sharePledgeHisList = sharePledgeHisList;
    }

    public List<Frpositioninfos> getFrpositioninfosList() {
        return frpositioninfosList;
    }

    public void setFrpositioninfosList(List<Frpositioninfos> frpositioninfosList) {
        this.frpositioninfosList = frpositioninfosList;
    }

    public List<TradeReferences> getSuppliersinfosList() {
        return suppliersinfosList;
    }

    public void setSuppliersinfosList(List<TradeReferences> suppliersinfosList) {
        this.suppliersinfosList = suppliersinfosList;
    }

    public List<TradeReferences> getClientinfosList() {
        return clientinfosList;
    }

    public void setClientinfosList(List<TradeReferences> clientinfosList) {
        this.clientinfosList = clientinfosList;
    }

    public List<TradeReferences> getTradeReferencesList() {
        return tradeReferencesList;
    }

    public void setTradeReferencesList(List<TradeReferences> tradeReferencesList) {
        this.tradeReferencesList = tradeReferencesList;
    }

    public List<OtherInfos> getOtherInfosList() {
        return otherInfosList;
    }

    public void setOtherInfosList(List<OtherInfos> otherInfosList) {
        this.otherInfosList = otherInfosList;
    }

    public List<EnterpriseShareholder> getEnterpriseShareholderList() {
        return EnterpriseShareholderList;
    }

    public void setEnterpriseShareholderList(List<EnterpriseShareholder> enterpriseShareholderList) {
        EnterpriseShareholderList = enterpriseShareholderList;
    }

    public List<CustomHouse> getCustomHouseList() {
        return CustomHouseList;
    }

    public void setCustomHouseList(List<CustomHouse> customHouseList) {
        CustomHouseList = customHouseList;
    }

    public Page getLitigationPage() {
        return litigationPage;
    }

    public void setLitigationPage(Page litigationPage) {
        this.litigationPage = litigationPage;
    }

    public Page getBadPage() {
        return badPage;
    }

    public void setBadPage(Page badPage) {
        this.badPage = badPage;
    }

    public ShareCapital getShareCapital() {
        return shareCapital;
    }

    public void setShareCapital(ShareCapital shareCapital) {
        this.shareCapital = shareCapital;
    }
}
