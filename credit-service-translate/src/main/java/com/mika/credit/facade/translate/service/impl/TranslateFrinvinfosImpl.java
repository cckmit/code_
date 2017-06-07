package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.Frinvinfos;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.sql.SQLException;


public class TranslateFrinvinfosImpl {

	/**
	 * 法人对外投资信息
	 *
	 * @param fullReport
	 * @throws SQLException
	 */

	public FullReport getEnterpriseFrinvinfos(FullReport fullReport) throws Exception {
		//翻译
		TranslatorJson frinvinJsonname = new TranslatorJson();
		frinvinJsonname.text = new String[fullReport.getFrinvinfosList().size()];
		for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
			Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
			frinvinJsonname.text[i] = frin.getEnterpriseNameCN();//公司名称
		}
		if (fullReport.getFrinvinfosList().size() == 1) {
			fullReport.getFrinvinfosList().get(0).setEnterpriseNameEN(Translator.translateOnly(1, fullReport.getFrinvinfosList().get(0).getEnterpriseNameCN()));
		} else {
			frinvinJsonname = Translator.translateMany(1, frinvinJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
				Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
				if (frin.getEnterpriseNameEN() == null || "".equals(frin.getEnterpriseNameEN())) {
					frin.setEnterpriseNameEN(Tool.isStringNullPicc(frinvinJsonname.dest[i]));//公司名称
				}
				fullReport.getFrinvinfosList().set(i, frin);
			}
		}
		frinvinJsonname = new TranslatorJson();
		frinvinJsonname.text = new String[fullReport.getFrinvinfosList().size()];
		for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
			Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
			frinvinJsonname.text[i] = frin.getRegOrgCN();//登记机关
		}
		if (fullReport.getFrinvinfosList().size() == 1) {
			fullReport.getFrinvinfosList().get(0).setRegOrgEN(Translator.translateOnly(0, fullReport.getFrinvinfosList().get(0).getRegOrgCN()));
		} else {
			frinvinJsonname = Translator.translateMany(0, frinvinJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
				Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
				if (frin.getRegOrgEN() == null || "".equals(frin.getRegOrgEN())) {
					frin.setRegOrgEN(Tool.isStringNullPicc(frinvinJsonname.dest[i]));//公司名称
				}
				fullReport.getFrinvinfosList().set(i, frin);
			}
		}

		frinvinJsonname = new TranslatorJson();
		frinvinJsonname.text = new String[fullReport.getFrinvinfosList().size()];
		for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
			Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
			frinvinJsonname.text[i] = frin.getAddressCN();//中文地址
		}
		if (fullReport.getFrinvinfosList().size() == 1) {
			fullReport.getFrinvinfosList().get(0).setAddressEN(Translator.translateOnly(2, fullReport.getFrinvinfosList().get(0).getAddressCN()));
		} else {
			frinvinJsonname = Translator.translateMany(2, frinvinJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
				Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
				if (frin.getAddressEN() == null || "".equals(frin.getAddressEN())) {
					frin.setAddressEN(Tool.isStringNullPicc(frinvinJsonname.dest[i]));//中文地址
				}
				fullReport.getFrinvinfosList().set(i, frin);
			}
		}

		frinvinJsonname = new TranslatorJson();
		frinvinJsonname.text = new String[fullReport.getFrinvinfosList().size()];
		for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
			Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
			frinvinJsonname.text[i] = frin.getNameCN();//法定代表人姓名
		}
		if (fullReport.getFrinvinfosList().size() == 1) {
			fullReport.getFrinvinfosList().get(0).setNameEN(Translator.translateOnly(3, fullReport.getFrinvinfosList().get(0).getNameCN()));
		} else {
			frinvinJsonname = Translator.translateMany(3, frinvinJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
				Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
				if (frin.getNameEN() == null || "".equals(frin.getNameEN())) {
					frin.setNameEN(Tool.isStringNullPicc(frinvinJsonname.dest[i]));//法定代表人姓名
				}
				fullReport.getFrinvinfosList().set(i, frin);
			}
		}

		frinvinJsonname = new TranslatorJson();
		frinvinJsonname.text = new String[fullReport.getFrinvinfosList().size()];
		for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
			Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
			frinvinJsonname.text[i] = frin.getEnterpriseTypeCN();//企业（机构）类型
		}
		if (fullReport.getFrinvinfosList().size() == 1) {
			fullReport.getFrinvinfosList().get(0).setEnterpriseTypeEN(Translator.translateOnly(0, fullReport.getFrinvinfosList().get(0).getEnterpriseTypeCN()));
		} else {
			frinvinJsonname = Translator.translateMany(0, frinvinJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
				Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
				if (frin.getEnterpriseTypeEN() == null || "".equals(frin.getEnterpriseTypeEN())) {
					frin.setEnterpriseTypeEN(Tool.isStringNullPicc(frinvinJsonname.dest[i]));//法定代表人姓名
				}
				fullReport.getFrinvinfosList().set(i, frin);
			}
		}

		frinvinJsonname = new TranslatorJson();
		frinvinJsonname.text = new String[fullReport.getFrinvinfosList().size()];
		for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
			Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
			frinvinJsonname.text[i] = frin.getRegCapitalCurrencyCN();//注册资本币种
		}
		if (fullReport.getFrinvinfosList().size() == 1) {
			fullReport.getFrinvinfosList().get(0).setRegCapitalCurrencyEN(Translator.translateOnly(0, fullReport.getFrinvinfosList().get(0).getRegCapitalCurrencyCN()));
		} else {
			frinvinJsonname = Translator.translateMany(0, frinvinJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
				Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
				if (frin.getRegCapitalCurrencyEN() == null || "".equals(frin.getRegCapitalCurrencyEN())) {
					frin.setRegCapitalCurrencyEN(Tool.isStringNullPicc(frinvinJsonname.dest[i]));//法定代表人姓名
				}
				fullReport.getFrinvinfosList().set(i, frin);
			}
		}

		frinvinJsonname = new TranslatorJson();
		frinvinJsonname.text = new String[fullReport.getFrinvinfosList().size()];
		for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
			Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
			frinvinJsonname.text[i] = frin.getEnterpriseStatusCN();//企业状态
		}
		if (fullReport.getFrinvinfosList().size() == 1) {
			fullReport.getFrinvinfosList().get(0).setEnterpriseStatusEN(Translator.translateOnly(0, fullReport.getFrinvinfosList().get(0).getEnterpriseStatusCN()));
		} else {
			frinvinJsonname = Translator.translateMany(0, frinvinJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getFrinvinfosList().size(); i++) {
				Frinvinfos frin = fullReport.getFrinvinfosList().get(i);
				if (frin.getEnterpriseStatusEN() == null || "".equals(frin.getEnterpriseStatusEN())) {
					frin.setEnterpriseStatusEN(Tool.isStringNullPicc(frinvinJsonname.dest[i]));//企业状态
				}
				fullReport.getFrinvinfosList().set(i, frin);
			}
		}

		fullReport.setFrinvinfosList(fullReport.getFrinvinfosList());
		return fullReport;
	}


}
