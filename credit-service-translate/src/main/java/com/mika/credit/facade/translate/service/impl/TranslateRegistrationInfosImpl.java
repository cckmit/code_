package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import static com.mika.credit.facade.translate.util.Tool.isNull;


public class TranslateRegistrationInfosImpl {

	/**
	 * 企业法律注册信息
	 */
	
	public FullReport getEnterpriseRegistrationInfos(FullReport fullReport){
		//翻译
		if(null==fullReport.getRegistrationInfos().getStreetEN() || "".equals(fullReport.getRegistrationInfos().getStreetEN())&& null!=fullReport.getRegistrationInfos().getStreetCN() && !"".equals(fullReport.getRegistrationInfos().getStreetCN().trim()) ){
			if(null==fullReport.getRegistrationInfos().getBuildingEN() || "".equals(fullReport.getRegistrationInfos().getBuildingEN()) && null!=fullReport.getRegistrationInfos().getBuildingCN() && !"".equals(fullReport.getRegistrationInfos().getBuildingCN().trim())){
				TranslatorJson json = new TranslatorJson();
				json.text = new String[3];
				json.text[0] = isNull(fullReport.getRegistrationInfos().getStreetCN());
				json.text[1] = isNull(fullReport.getRegistrationInfos().getBuildingCN());
				json.text[2] = isNull(fullReport.getRegistrationInfos().getProvinceCN());
				json = Translator.translateMany(2, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				if(null == fullReport.getRegistrationInfos().getStreetEN() ||"".equals(fullReport.getRegistrationInfos().getStreetEN())){
					fullReport.getRegistrationInfos().setStreetEN(Tool.isStringNullPicc(json.dest[0]));
				}
				if(null == fullReport.getRegistrationInfos().getBuildingEN() ||"".equals(fullReport.getRegistrationInfos().getBuildingEN())){
					fullReport.getRegistrationInfos().setBuildingEN(Tool.isStringNullPicc(json.dest[1]));
				}
				if(null == fullReport.getRegistrationInfos().getProvinceEN() ||"".equals(fullReport.getRegistrationInfos().getProvinceEN())){
					fullReport.getRegistrationInfos().setProvinceEN(Tool.isStringNullPicc(json.dest[2]));
				}
			}
		}

		//翻译
		TranslatorJson json = new TranslatorJson();
		json.text = new String[6];
		json.text[0] = isNull(fullReport.getRegistrationInfos().getRegistrationCN());
		json.text[1] = isNull(fullReport.getRegistrationInfos().getBusinessScopeCN());
		json.text[2] = isNull(fullReport.getRegistrationInfos().getCompanyType());
		json.text[3] = isNull(fullReport.getRegistrationInfos().getLegalPositionCN());
		json.text[4] = isNull(fullReport.getRegistrationInfos().getRegCapital());
		json.text[5] = isNull(fullReport.getRegistrationInfos().getEntOwnership());
		json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		if(null==fullReport.getRegistrationInfos().getRegistrationEN() ||"".equals(fullReport.getRegistrationInfos().getRegistrationEN())){
			fullReport.getRegistrationInfos().setRegistrationEN(Tool.isStringNullPicc(json.dest[0]));
		}
		if(null==fullReport.getRegistrationInfos().getBusinessScopeEN() ||"".equals(fullReport.getRegistrationInfos().getBusinessScopeEN())){
			fullReport.getRegistrationInfos().setBusinessScopeEN(Tool.isStringNullPicc(json.dest[1]));
		}
		if(null==fullReport.getRegistrationInfos().getCompanyTypeEN() || "".equals(fullReport.getRegistrationInfos().getCompanyTypeEN())){
			fullReport.getRegistrationInfos().setCompanyTypeEN(Tool.isStringNullPicc(json.dest[2]));
		}
		if(null==fullReport.getRegistrationInfos().getLegalPositionEN() || "".equals(fullReport.getRegistrationInfos().getLegalPositionEN())){
			fullReport.getRegistrationInfos().setLegalPositionEN(Tool.isStringNullPicc(json.dest[3]));
		}
		if(null==fullReport.getRegistrationInfos().getRegCapitalEN() || "".equals(fullReport.getRegistrationInfos().getRegCapitalEN())){
			fullReport.getRegistrationInfos().setRegCapitalEN(Tool.isStringNullPicc(json.dest[4]));
		}
		if(null==fullReport.getRegistrationInfos().getEntOwnershipEN() || "".equals(fullReport.getRegistrationInfos().getEntOwnershipEN())){
			fullReport.getRegistrationInfos().setEntOwnershipEN(Tool.isStringNullPicc(json.dest[5]));
		}
		//翻译
		if(null==fullReport.getRegistrationInfos().getLegalNameEN() || "".equals(fullReport.getRegistrationInfos().getLegalNameEN())&&null!=fullReport.getRegistrationInfos().getLegalNameCN() && !"".equals(fullReport.getRegistrationInfos().getLegalNameCN().trim())){
			String str = Translator.translateOnly(3, isNull(fullReport.getRegistrationInfos().getLegalNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			if(null==fullReport.getRegistrationInfos().getLegalNameEN() ||"".equals(fullReport.getRegistrationInfos().getLegalNameEN())){
				fullReport.getRegistrationInfos().setLegalNameEN(Tool.isStringNullPicc(str));
			}
		}

		//翻译
		if(null==fullReport.getRegistrationInfos().getNameEN() || "".equals(fullReport.getRegistrationInfos().getNameEN())&&null!=fullReport.getRegistrationInfos().getNameCN() && !"".equals(fullReport.getRegistrationInfos().getNameCN().trim())){
			String str = Translator.translateOnly(1, isNull(fullReport.getRegistrationInfos().getNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			if(null==fullReport.getRegistrationInfos().getNameEN() ||"".equals(fullReport.getRegistrationInfos().getNameEN())){
				fullReport.getRegistrationInfos().setNameEN(Tool.isStringNullPicc(str));
			}
		}

		return fullReport;
	}

}
