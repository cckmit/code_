package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;


import static com.mika.credit.facade.translate.util.Tool.isNull;


public class TranslateBasicInfosImpl {

	/**
	 * 企业基本信息
	 * @throws Exception
	 */
	 public  FullReport getEnterpriseBasicInfos(FullReport fullReport)throws Exception{
		//翻译
		TranslatorJson json = new TranslatorJson();
		json.text = new String[6];
		json.text[0] = isNull(fullReport.getBasicInfos().getStreetCN());
		json.text[1] = isNull(fullReport.getBasicInfos().getBuildingCN());
		json.text[2] = isNull(fullReport.getBasicInfos().getAddressRecordCN());
		json.text[3] = isNull(fullReport.getBasicInfos().getCountryCN());
		json.text[4] = isNull(fullReport.getBasicInfos().getProvinceCN());
		json.text[5] = isNull(fullReport.getBasicInfos().getCityCN());
		json = Translator.translateMany(2, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		if(null==fullReport.getBasicInfos().getStreetEN() ||"".equals(fullReport.getBasicInfos().getStreetEN())){
			fullReport.getBasicInfos().setStreetEN(Tool.isStringNullPicc(json.dest[0]));
		}
		if(null==fullReport.getBasicInfos().getBuildingEN() ||"".equals(fullReport.getBasicInfos().getBuildingEN())){
			fullReport.getBasicInfos().setBuildingEN(Tool.isStringNullPicc(json.dest[1]));
		}
		if(null==fullReport.getBasicInfos().getAddressRecordEN() ||"".equals(fullReport.getBasicInfos().getAddressRecordEN())){
			fullReport.getBasicInfos().setAddressRecordEN(Tool.isStringNullPicc(json.dest[2]));
		}
		if(null==fullReport.getBasicInfos().getCountryEN() ||"".equals(fullReport.getBasicInfos().getCountryEN())){
		 fullReport.getBasicInfos().setCountryEN(Tool.isStringNullPicc(json.dest[3]));
		}
		if(null==fullReport.getBasicInfos().getProvinceEN() ||"".equals(fullReport.getBasicInfos().getProvinceEN())){
		 fullReport.getBasicInfos().setProvinceEN(Tool.isStringNullPicc(json.dest[4]));
		}
		if(null==fullReport.getBasicInfos().getCityEN() ||"".equals(fullReport.getBasicInfos().getCityEN())){
		 fullReport.getBasicInfos().setCityEN(Tool.isStringNullPicc(json.dest[5]));
		}


		//翻译
		if(null==fullReport.getBasicInfos().getNameEN() || "".equals(fullReport.getBasicInfos().getNameEN())&&null!=fullReport.getBasicInfos().getNameCN() && !"".equals(fullReport.getBasicInfos().getNameCN().trim())){
			String str = Translator.translateOnly(1, isNull(fullReport.getBasicInfos().getNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			if(null==fullReport.getBasicInfos().getNameEN() ||"".equals(fullReport.getBasicInfos().getNameEN())){
				fullReport.getBasicInfos().setNameEN(Tool.isStringNullPicc(str));
			}
		}

		 //翻译
		 json = new TranslatorJson();
		 json.text = new String[5];
		 json.text[0] = isNull(fullReport.getBasicInfos().getBackgroundCN());
		 json.text[1] = isNull(fullReport.getBasicInfos().getLitigationInfoCN());
		 json.text[2] = isNull(fullReport.getBasicInfos().getBankRuptcyCN());
		 json.text[3] = isNull(fullReport.getBasicInfos().getEnterpriseStatusCN());
		 json.text[4] = isNull(fullReport.getBasicInfos().getBusinessScopeCN());
		 json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		 if (null == fullReport.getBasicInfos().getBackgroundEN() || "".equals(fullReport.getBasicInfos().getBackgroundEN())) {
			 fullReport.getBasicInfos().setBackgroundEN(Tool.isStringNullPicc(json.dest[0]));
		 }
		 if (null == fullReport.getBasicInfos().getLitigationInfoEN() || "".equals(fullReport.getBasicInfos().getLitigationInfoEN())) {
			 fullReport.getBasicInfos().setLitigationInfoEN(Tool.isStringNullPicc(json.dest[1]));
		 }
		 if (null == fullReport.getBasicInfos().getBankRuptcyEN() || "".equals(fullReport.getBasicInfos().getBankRuptcyEN())) {
			 fullReport.getBasicInfos().setBankRuptcyEN(Tool.isStringNullPicc(json.dest[2]));
		 }
		 if (null == fullReport.getBasicInfos().getEnterpriseStatusEN() || "".equals(fullReport.getBasicInfos().getEnterpriseStatusEN())) {
			 fullReport.getBasicInfos().setEnterpriseStatusEN(Tool.isStringNullPicc(json.dest[3]));
		 }
		 if (null == fullReport.getBasicInfos().getBusinessScopeEN() || "".equals(fullReport.getBasicInfos().getBusinessScopeEN())) {
			 fullReport.getBasicInfos().setBusinessScopeEN(Tool.isStringNullPicc(json.dest[4]));
		 }


		return fullReport;
	}

}
