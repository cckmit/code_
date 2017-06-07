package com.mika.credit.facade.translate.service.impl;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.service.TranslateService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service("translateService")
public class TranslateServiceImpl implements TranslateService {
	private static Logger logger = Logger.getLogger(TranslateServiceImpl.class);
	@Override
	public FullReport cnFullReportTranslate(FullReport fullReport){
		long startAll = System.currentTimeMillis();
		logger.info("进入CN翻译方法");
		if(fullReport == null || "".equals(fullReport)){
			logger.debug("fullReport为空："+fullReport);
			return null;
		}
		try {
			if(null != fullReport.getBankInfosList() && fullReport.getBankInfosList().size()>0){
				TranslateBankInfosImpl translateBankInfo = new TranslateBankInfosImpl();
				long start = System.currentTimeMillis();
				translateBankInfo.getEnterpriseBankInfos(fullReport);//银行信息
				long end = System.currentTimeMillis();
				logger.debug("翻译银行信息花费时间" + (end - start));
            }
			if(null != fullReport.getBasicInfos() && !"".equals(fullReport.getBasicInfos())){
				TranslateBasicInfosImpl translateBasicInfos = new TranslateBasicInfosImpl();
				long start = System.currentTimeMillis();
				translateBasicInfos.getEnterpriseBasicInfos(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译企业基本信息花费时间" + (end - start));
			}
			if(null != fullReport.getChangeInfosList() && fullReport.getChangeInfosList().size()>0){
				TranslateChangeInfosImpl translateChangeInfos = new TranslateChangeInfosImpl();
				long start = System.currentTimeMillis();
				translateChangeInfos.getEnterpriseChangeInfos(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译注册变更表信息花费时间" + (end - start));
			}
			if(null != fullReport.getCreditAssessments() && !"".equals(fullReport.getCreditAssessments())){
				TranslateCreditAssessmentsImpl translateCreditAssessments = new TranslateCreditAssessmentsImpl();
				long start = System.currentTimeMillis();
				translateCreditAssessments.getCreditAssessments(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译分析评估花费时间" + (end - start));
			}
			if(null != fullReport.getCustomHouseList() && fullReport.getCustomHouseList().size()>0){
				TranslateCustomHouseImpl translateCustomHouse = new TranslateCustomHouseImpl();
				long start = System.currentTimeMillis();
				translateCustomHouse.getEnterpriseCustomHouse(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译海关信息花费时间" + (end - start));
			}
			if(null != fullReport.getEntinvinfosList() && fullReport.getEntinvinfosList().size()>0){
				TranslateEntinvinfosImpl translateEntinvinfos = new TranslateEntinvinfosImpl();
				long start = System.currentTimeMillis();
				translateEntinvinfos.getEnterpriseEntinvinfos(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译企业对外投资信息花费时间" + (end - start));
			}
//			if(null != fullReport.getExecutiveList() && fullReport.getExecutiveList().size()>0){
//				TranslateExecutiveImpl translateExecutive = new TranslateExecutiveImpl();
//				long start = System.currentTimeMillis();
//				translateExecutive.getEnterpriseExecutive(fullReport);
//				long end = System.currentTimeMillis();
//				logger.debug("翻译执行公告花费时间" + (end - start));
//			}
			if(null != fullReport.getFinancialFiguresList() && fullReport.getFinancialFiguresList().size()>0){
				TranslateFinancialFiguresImpl translateFinancialFigures = new TranslateFinancialFiguresImpl();
				long start = System.currentTimeMillis();
				translateFinancialFigures.getFinancialFigures(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译财物说明花费时间" + (end - start));
			}
			if(null != fullReport.getFrinvinfosList() && fullReport.getFrinvinfosList().size()>0){
				TranslateFrinvinfosImpl translateFrinvinfos = new TranslateFrinvinfosImpl();
				long start = System.currentTimeMillis();
				translateFrinvinfos.getEnterpriseFrinvinfos(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译法人对外投资信息花费时间" + (end - start));
			}
			if(null != fullReport.getFrpositioninfosList() && fullReport.getFrpositioninfosList().size()>0){
				TranslateFrpositioninfosImpl translateFrpositioninfos = new TranslateFrpositioninfosImpl();
				long start = System.currentTimeMillis();
				translateFrpositioninfos.getFrpositioninfos(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译法人其他任职信息花费时间" + (end - start));
			}
			if(null != fullReport.getHistoryInfosList() && fullReport.getHistoryInfosList().size()>0){
				TranslateHistoryInfosImpl translateHistoryInfos = new TranslateHistoryInfosImpl();
				long start = System.currentTimeMillis();
				translateHistoryInfos.getEnterpriseHistoryInfos(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译历史背景沿革花费时间" + (end - start));
			}
//			if(null != fullReport.getKtggList() && fullReport.getKtggList().size()>0){
//				TranslateKtggImpl translateKtgg = new TranslateKtggImpl();
//				long start = System.currentTimeMillis();
//				translateKtgg.getEnterpriseKtgg(fullReport);
//				long end = System.currentTimeMillis();
//				logger.debug("翻译开庭公告花费时间" + (end - start));
//			}
			if(null != fullReport.getManagementsList() && fullReport.getManagementsList().size()>0){
				TranslateManagementsImpl translateManagements = new TranslateManagementsImpl();
				long start = System.currentTimeMillis();
				translateManagements.getEnterpriseManagements(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译管理层信息花费时间" + (end - start));
			}
			if(null != fullReport.getOperatings() && !"".equals(fullReport.getOperatings())){
				TranslateOperatingsImpl translateOperatings = new TranslateOperatingsImpl();
				long start = System.currentTimeMillis();
				translateOperatings.getEnterpriseOperatings(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译经营现状获取信息花费时间" + (end - start));
			}
			if(null != fullReport.getOtherInfosList() && !"".equals(fullReport.getOtherInfosList())){
				TranslateOtherInfosImpl translateOtherInfos = new TranslateOtherInfosImpl();
				long start = System.currentTimeMillis();
				translateOtherInfos.getEnterpriseOtherInfos(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译其他信息花费时间" + (end - start));
			}
			if(null != fullReport.getPaymentHistoriesList() && fullReport.getPaymentHistoriesList().size()>0){
				TranslatePaymentHistoriesImpl translatePaymentHistories= new TranslatePaymentHistoriesImpl();
				long start = System.currentTimeMillis();
				translatePaymentHistories.getEnterprisePaymentHistories(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译支付款记录花费时间" + (end - start));
			}
			if(null != fullReport.getRegistrationInfos() && !"".equals(fullReport.getRegistrationInfos())){
				TranslateRegistrationInfosImpl translateRegistrationInfos = new TranslateRegistrationInfosImpl();
				long start = System.currentTimeMillis();
				translateRegistrationInfos.getEnterpriseRegistrationInfos(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译企业法律注册信息花费时间" + (end - start));
			}
			if(null != fullReport.getRelatedCompaniesList() && fullReport.getRelatedCompaniesList().size()>0){
				TranslateRelatedCompaniesImpl translateRelatedCompanies = new TranslateRelatedCompaniesImpl();
				long start = System.currentTimeMillis();
				translateRelatedCompanies.getEnterpriseRelatedCompanies(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译关联公司信息花费时间" + (end - start));
			}
//			if(null != fullReport.getRulingdocumentsList() && fullReport.getRulingdocumentsList().size()>0){
//				TranslateRulingdocumentsImpl translateRulingdocuments = new TranslateRulingdocumentsImpl();
//				long start = System.currentTimeMillis();
//				translateRulingdocuments.getEnterpriseRulingdocuments(fullReport);
//				long end = System.currentTimeMillis();
//				logger.debug("翻译裁判文书花费时间" + (end - start));
//			}
			if(null != fullReport.getShareholderInfosList() && fullReport.getShareholderInfosList().size()>0){
				TranslateShareholderImpl translateShareholder = new TranslateShareholderImpl();
				long start = System.currentTimeMillis();
				translateShareholder.getEnterpriseShareholderInfos(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译股东信息花费时间" + (end - start));
			}
			if(null != fullReport.getShareholdersChainList() && fullReport.getShareholdersChainList().size()>0){
				TranslateShareholdersChainImpl translateShareholdersChain = new TranslateShareholdersChainImpl();
				long start = System.currentTimeMillis();
				translateShareholdersChain.getEnterpriseShareholdersChain(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译股东链花费时间" + (end - start));
			}
//			if(null != fullReport.getSxggList() && fullReport.getSxggList().size()>0){
//				TranslateSxggImpl translateSxgg = new TranslateSxggImpl();
//				long start = System.currentTimeMillis();
//				translateSxgg.getEnterpriseSxgg(fullReport);
//				long end = System.currentTimeMillis();
//				logger.debug("翻译失信被执行人花费时间" + (end - start));
//			}
			if(null != fullReport.getTradeReferencesList() && fullReport.getTradeReferencesList().size()>0){
				TranslateTradeReferencesImpl translateTradeReferences = new TranslateTradeReferencesImpl();
				long start = System.currentTimeMillis();
				translateTradeReferences.getEnterpriseTradeReferences(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译贸易参考花费时间" + (end - start));
			}
			if(null != fullReport.getMediaRecordsList() && fullReport.getMediaRecordsList().size()>0){
				TranslateMediaRecordsImpl translateMediaRecords = new TranslateMediaRecordsImpl();
				long start = System.currentTimeMillis();
				translateMediaRecords.getEnterpriseMediaRecords(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译媒体记录花费时间" + (end - start));
			}
			if(null != fullReport.getBrandsList() && fullReport.getBrandsList().size()>0){
				TranslateBrandsImpl translateBrands = new TranslateBrandsImpl();
				long start = System.currentTimeMillis();
				translateBrands.getEnterpriseBrands(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译品牌专利花费时间" + (end - start));
			}
			if(null != fullReport.getIcpWebsiteList() && fullReport.getIcpWebsiteList().size()>0){
				TranslateIcpWebsiteImpl translateIcpWebsite = new TranslateIcpWebsiteImpl();
				long start = System.currentTimeMillis();
				translateIcpWebsite.getEnterpriseIcpWebsite(fullReport);
				long end = System.currentTimeMillis();
				logger.debug("翻译网站花费时间" + (end - start));
			}
//			if(null != fullReport.getFyggList() && fullReport.getFyggList().size()>0){
//				TranslateFyggImpl translateFygg = new TranslateFyggImpl();
//				long start = System.currentTimeMillis();
//				translateFygg.getEnterpriseFygg(fullReport);
//				long end = System.currentTimeMillis();
//				logger.debug("翻译法院公告花费时间" + (end - start));
//			}
//			if(null != fullReport.getAjlcList() && fullReport.getAjlcList().size()>0){
//				TranslateAjlcImpl translateAjlc = new TranslateAjlcImpl();
//				long start = System.currentTimeMillis();
//				translateAjlc.getEnterpriseAjlc(fullReport);
//				long end = System.currentTimeMillis();
//				logger.debug("翻译案件流程信息花费时间" + (end - start));
//			}

		} catch (Exception e) {
			logger.error("出错了:"+e);
			e.printStackTrace();
		}
		long endAll = System.currentTimeMillis();
		logger.debug("翻译完成总共花费时间" + (endAll - startAll));
		String fullReportString = (String) JSON.toJSONString(fullReport);
		System.out.println("fullReport-------->>"+fullReportString);
		return fullReport;
	}

}
 