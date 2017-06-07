package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.Entinvinfos;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.sql.SQLException;


public class TranslateEntinvinfosImpl {

	/**
	 * 企业对外投资信息
	 *
	 * @param fullReport
	 * @throws SQLException
	 */

	public FullReport getEnterpriseEntinvinfos(FullReport fullReport) throws Exception {

		//翻译
		TranslatorJson entinvinfosJsonname = new TranslatorJson();
		entinvinfosJsonname.text = new String[fullReport.getEntinvinfosList().size()];
		for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
			Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
			entinvinfosJsonname.text[i] = ent.getEnterpriseNameCN();//公司名称
		}
		if (fullReport.getEntinvinfosList().size() == 1) {
//			if(fullReport.getEntinvinfosList().get(0).getEnterpriseNameCN() != null && !"".equals(fullReport.getEntinvinfosList().get(0).getEnterpriseNameCN())) {
			fullReport.getEntinvinfosList().get(0).setEnterpriseNameEN(Translator.translateOnly(1, fullReport.getEntinvinfosList().get(0).getEnterpriseNameCN()));
//			}
		} else {
			entinvinfosJsonname = Translator.translateMany(1, entinvinfosJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
				Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
				if (ent.getEnterpriseNameEN() == null || "".equals(ent.getEnterpriseNameEN())) {
					ent.setEnterpriseNameEN(Tool.isStringNullPicc(entinvinfosJsonname.dest[i]));//公司名称
				}
				fullReport.getEntinvinfosList().set(i, ent);
			}
		}
		entinvinfosJsonname = new TranslatorJson();
		entinvinfosJsonname.text = new String[fullReport.getEntinvinfosList().size()];
		for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
			Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
			entinvinfosJsonname.text[i] = ent.getRegOrgCN();//登记机关
		}
		if (fullReport.getEntinvinfosList().size() == 1) {
			fullReport.getEntinvinfosList().get(0).setRegOrgEN(Translator.translateOnly(0, fullReport.getEntinvinfosList().get(0).getRegOrgCN()));
		} else {
			entinvinfosJsonname = Translator.translateMany(0, entinvinfosJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
				Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
				if (ent.getRegOrgEN() == null || "".equals(ent.getRegOrgEN())) {
					ent.setRegOrgEN(Tool.isStringNullPicc(entinvinfosJsonname.dest[i]));//公司名称
				}
				fullReport.getEntinvinfosList().set(i, ent);
			}
		}

		entinvinfosJsonname = new TranslatorJson();
		entinvinfosJsonname.text = new String[fullReport.getEntinvinfosList().size()];
		for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
			Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
			entinvinfosJsonname.text[i] = ent.getAddressCN();//中文地址
		}
		if (fullReport.getEntinvinfosList().size() == 1) {
			fullReport.getEntinvinfosList().get(0).setAddressEN(Translator.translateOnly(2, fullReport.getEntinvinfosList().get(0).getAddressCN()));
		} else {
			entinvinfosJsonname = Translator.translateMany(2, entinvinfosJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
				Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
				if (ent.getAddressEN() == null || "".equals(ent.getAddressEN())) {
					ent.setAddressEN(Tool.isStringNullPicc(entinvinfosJsonname.dest[i]));//公司名称
				}
				fullReport.getEntinvinfosList().set(i, ent);
			}
		}

		entinvinfosJsonname = new TranslatorJson();
		entinvinfosJsonname.text = new String[fullReport.getEntinvinfosList().size()];
		for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
			Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
			entinvinfosJsonname.text[i] = ent.getEnterpriseTypeCN();//企业（机构）类型
		}
		if (fullReport.getEntinvinfosList().size() == 1) {
			fullReport.getEntinvinfosList().get(0).setEnterpriseTypeEN(Translator.translateOnly(0, fullReport.getEntinvinfosList().get(0).getEnterpriseTypeEN()));
		} else {
			entinvinfosJsonname = Translator.translateMany(0, entinvinfosJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
				Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
				if (ent.getEnterpriseTypeEN() == null || "".equals(ent.getEnterpriseTypeEN())) {
					ent.setEnterpriseTypeEN(Tool.isStringNullPicc(entinvinfosJsonname.dest[i]));//公司名称
				}
				fullReport.getEntinvinfosList().set(i, ent);
			}
		}

		entinvinfosJsonname = new TranslatorJson();
		entinvinfosJsonname.text = new String[fullReport.getEntinvinfosList().size()];
		for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
			Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
			entinvinfosJsonname.text[i] = ent.getEnterpriseStatus();//企业状态
		}
		if (fullReport.getEntinvinfosList().size() == 1) {
			fullReport.getEntinvinfosList().get(0).setEnterpriseStatusEN(Translator.translateOnly(0, fullReport.getEntinvinfosList().get(0).getEnterpriseStatus()));
		} else {
			entinvinfosJsonname = Translator.translateMany(0, entinvinfosJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
				Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
				if (ent.getEnterpriseStatusEN() == null || "".equals(ent.getEnterpriseStatusEN())) {
					ent.setEnterpriseStatusEN(Tool.isStringNullPicc(entinvinfosJsonname.dest[i]));//公司名称
				}
				fullReport.getEntinvinfosList().set(i, ent);
			}
		}

		entinvinfosJsonname = new TranslatorJson();
		entinvinfosJsonname.text = new String[fullReport.getEntinvinfosList().size()];
		for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
			Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
			entinvinfosJsonname.text[i] = ent.getRegCapCurCN();//注册资本币种
		}
		if (fullReport.getEntinvinfosList().size() == 1) {
			fullReport.getEntinvinfosList().get(0).setRegCapCurEN(Translator.translateOnly(0, fullReport.getEntinvinfosList().get(0).getRegCapCurCN()));
		} else {
			entinvinfosJsonname = Translator.translateMany(0, entinvinfosJsonname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getEntinvinfosList().size(); i++) {
				Entinvinfos ent = fullReport.getEntinvinfosList().get(i);
				if (ent.getRegCapCurEN() == null || "".equals(ent.getRegCapCurEN())) {
					ent.setRegCapCurEN(Tool.isStringNullPicc(entinvinfosJsonname.dest[i]));//公司名称
				}
				fullReport.getEntinvinfosList().set(i, ent);
			}
		}


		return fullReport;
	}


}
