package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 经营现状翻译
 * Created by Zhu Jun on 2017/3/29.
 */

public class TranslateOperatingsImpl {
	
	/**
	 * 经营现状获取信息
	 * @param fullReport
	 */
	public FullReport getEnterpriseOperatings(FullReport fullReport) throws Exception {
		//翻译
		TranslatorJson json = new TranslatorJson();
		json.text = new String[25];
		json.text[0] = isNull(Tool.isStringRN(fullReport.getOperatings().getMainDiscriptionCN()));//中文主营描述
		json.text[1] = isNull(Tool.isStringRN(fullReport.getOperatings().getMainProductCN()));//中文主要产品
		json.text[2] = isNull(Tool.isStringRN(fullReport.getOperatings().getProductionCN()));//中文产能规模
		json.text[3] = isNull(Tool.isStringRN(fullReport.getOperatings().getActivityOneCN()));//中文业务1
		json.text[4] = isNull(Tool.isStringRN(fullReport.getOperatings().getActivityTwoCN()));//中文业务2
		json.text[5] = isNull(Tool.isStringRN(fullReport.getOperatings().getActivityThreeCN()));//中文业务3
		json.text[6] = isNull(Tool.isStringRN(fullReport.getOperatings().getInfoCN()));//中文来自目标公司
		json.text[7] = isNull(Tool.isStringRN(fullReport.getOperatings().getPurchaseDomesticCN()));//中文国内采购
		json.text[8] = isNull(Tool.isStringRN(fullReport.getOperatings().getPurchaseInternationlCN()));//中文国外采购
		json.text[9] = isNull(Tool.isStringRN(fullReport.getOperatings().getSaleDomesticCN()));//中文国内销售
		json.text[10] = isNull(Tool.isStringRN(fullReport.getOperatings().getSaleInternationlCN()));//中文国际销售
		json.text[11] = isNull(Tool.isStringRN(fullReport.getOperatings().getImportAreaCN()));//中文进口地区
		json.text[12] = isNull(Tool.isStringRN(fullReport.getOperatings().getExportAreaCN()));//中文出口地区
		json.text[13] = isNull(Tool.isStringRN(fullReport.getOperatings().getPurchaseTermCN()));//中文采购方式
		json.text[14] = isNull(Tool.isStringRN(fullReport.getOperatings().getSaleTermCN()));//中文销售方式
		json.text[15] = isNull(Tool.isStringRN(fullReport.getOperatings().getCertificationCN()));//中文行业认证
		json.text[16] = isNull(Tool.isStringRN(fullReport.getOperatings().getPremiseCN()));//中文场地描述
		json.text[17] = isNull(Tool.isStringRN(fullReport.getOperatings().getLocationCN()));//中文当地描述
		json.text[18] = isNull(Tool.isStringRN(fullReport.getOperatings().getIndustryCertificationCN()));//行业认证
		json.text[19] = isNull(Tool.isStringRN(fullReport.getOperatings().getMainBrandCN()));//中文主要商标
		json.text[20] = isNull(Tool.isStringRN(fullReport.getOperatings().getMainPatentCN()));//中文主要专利
		json.text[21] = isNull(Tool.isStringRN(fullReport.getOperatings().getDealershipCN()));//中文代理权
		json.text[22] = isNull(Tool.isStringRN(fullReport.getOperatings().getLocationType()));//中文当地描述
		json.text[23] = isNull(Tool.isStringRN(fullReport.getOperatings().getOwnership()));//中文当地描述
		json.text[24] = isNull(Tool.isStringRN(fullReport.getOperatings().getPosition()));//中文当地描述
		json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		if (null == fullReport.getOperatings().getMainDiscriptionEN() || "".equals(fullReport.getOperatings().getMainDiscriptionEN())) {
			fullReport.getOperatings().setMainDiscriptionEN(Tool.isStringNullPicc(json.dest[0]));
		}
		if (null == fullReport.getOperatings().getMainProductEN() || "".equals(fullReport.getOperatings().getMainProductEN())) {
			fullReport.getOperatings().setMainProductEN(Tool.isStringNullPicc(json.dest[1]));
		}
		if (null == fullReport.getOperatings().getProductionEN() || "".equals(fullReport.getOperatings().getProductionEN())) {
			fullReport.getOperatings().setProductionEN(Tool.isStringNullPicc(json.dest[2]));
		}
		if (null == fullReport.getOperatings().getActivityOneEN() || "".equals(fullReport.getOperatings().getActivityOneEN())) {
			fullReport.getOperatings().setActivityOneEN(Tool.isStringNullPicc(json.dest[3]));
		}
		if (null == fullReport.getOperatings().getActivityTwoEN() || "".equals(fullReport.getOperatings().getActivityTwoEN())) {
			fullReport.getOperatings().setActivityTwoEN(Tool.isStringNullPicc(json.dest[4]));
		}
		if (null == fullReport.getOperatings().getActivityThreeEN() || "".equals(fullReport.getOperatings().getActivityThreeEN())) {
			fullReport.getOperatings().setActivityThreeEN(Tool.isStringNullPicc(json.dest[5]));
		}
		if (null == fullReport.getOperatings().getInfoEN() || "".equals(fullReport.getOperatings().getInfoEN())) {
			fullReport.getOperatings().setInfoEN(Tool.isStringNullPicc(json.dest[6]));
		}
		if (null == fullReport.getOperatings().getPurchaseDomesticEN() || "".equals(fullReport.getOperatings().getPurchaseDomesticEN())) {
			fullReport.getOperatings().setPurchaseDomesticEN(Tool.isStringNullPicc(json.dest[7]));
		}
		if (null == fullReport.getOperatings().getPurchaseInternationlEN() || "".equals(fullReport.getOperatings().getPurchaseInternationlEN())) {
			fullReport.getOperatings().setPurchaseInternationlEN(Tool.isStringNullPicc(json.dest[8]));
		}
		if (null == fullReport.getOperatings().getSaleDomesticEN() || "".equals(fullReport.getOperatings().getSaleDomesticEN())) {
			fullReport.getOperatings().setSaleDomesticEN(Tool.isStringNullPicc(json.dest[9]));
		}
		if (null == fullReport.getOperatings().getSaleInternationlEN() || "".equals(fullReport.getOperatings().getSaleInternationlEN())) {
			fullReport.getOperatings().setSaleInternationlEN(Tool.isStringNullPicc(json.dest[10]));
		}
		if (null == fullReport.getOperatings().getImportAreaEN() || "".equals(fullReport.getOperatings().getImportAreaEN())) {
			fullReport.getOperatings().setImportAreaEN(Tool.isStringNullPicc(json.dest[11]));
		}
		if (null == fullReport.getOperatings().getExportAreaEN() || "".equals(fullReport.getOperatings().getExportAreaEN())) {
			fullReport.getOperatings().setExportAreaEN(Tool.isStringNullPicc(json.dest[12]));
		}
		if (null == fullReport.getOperatings().getPurchaseTermEN() || "".equals(fullReport.getOperatings().getPurchaseTermEN())) {
			fullReport.getOperatings().setPurchaseTermEN(Tool.isStringNullPicc(json.dest[13]));
		}
		if (null == fullReport.getOperatings().getSaleTermEN() || "".equals(fullReport.getOperatings().getSaleTermEN())) {
			fullReport.getOperatings().setSaleTermEN(Tool.isStringNullPicc(json.dest[14]));
		}
		if (null == fullReport.getOperatings().getCertificationEN() || "".equals(fullReport.getOperatings().getCertificationEN())) {
			fullReport.getOperatings().setCertificationEN(Tool.isStringNullPicc(json.dest[15]));
		}
		if (null == fullReport.getOperatings().getPremiseEN() || "".equals(fullReport.getOperatings().getPremiseEN())) {
			fullReport.getOperatings().setPremiseEN(Tool.isStringNullPicc(json.dest[16]));
		}
		if (null == fullReport.getOperatings().getLocationEN() || "".equals(fullReport.getOperatings().getLocationEN())) {
			fullReport.getOperatings().setLocationEN(Tool.isStringNullPicc(json.dest[17]));
		}
		if (null == fullReport.getOperatings().getIndustryCertificationEN() || "".equals(fullReport.getOperatings().getIndustryCertificationEN())) {
			fullReport.getOperatings().setIndustryCertificationEN(Tool.isStringNullPicc(json.dest[18]));
		}
		if (null == fullReport.getOperatings().getMainBrandEN() || "".equals(fullReport.getOperatings().getMainBrandEN())) {
			fullReport.getOperatings().setMainBrandEN(Tool.isStringNullPicc(json.dest[19]));
		}
		if (null == fullReport.getOperatings().getMainPatentEN() || "".equals(fullReport.getOperatings().getMainPatentEN())) {
			fullReport.getOperatings().setMainPatentEN(Tool.isStringNullPicc(json.dest[20]));
		}
		if (null == fullReport.getOperatings().getDealershipEN() || "".equals(fullReport.getOperatings().getDealershipEN())) {
			fullReport.getOperatings().setDealershipEN(Tool.isStringNullPicc(json.dest[21]));
		}
		if (null == fullReport.getOperatings().getLocationTypeEN() || "".equals(fullReport.getOperatings().getLocationTypeEN())) {
			fullReport.getOperatings().setLocationTypeEN(Tool.isStringNullPicc(json.dest[22]));
		}
		if (null == fullReport.getOperatings().getOwnershipEN() || "".equals(fullReport.getOperatings().getOwnershipEN())) {
			fullReport.getOperatings().setOwnershipEN(Tool.isStringNullPicc(json.dest[23]));
		}
		if (null == fullReport.getOperatings().getPositionEN() || "".equals(fullReport.getOperatings().getPositionEN())) {
			fullReport.getOperatings().setPositionEN(Tool.isStringNullPicc(json.dest[24]));
		}
		return fullReport;

	}
		

	

}
