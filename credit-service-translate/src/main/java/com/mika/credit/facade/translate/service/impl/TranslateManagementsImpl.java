package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.Managements;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import static com.mika.credit.facade.translate.util.Tool.isNull;

public class TranslateManagementsImpl {
	/**
	 * 管理层信息
	 * @param fullReport
	 * @return
	 * @throws Exception
	 */
	public FullReport getEnterpriseManagements(FullReport fullReport) throws Exception{

		TranslatorJson jsonmanname = new TranslatorJson();
		jsonmanname.text = new String[fullReport.getManagementsList().size()];
		for (int i = 0; i < fullReport.getManagementsList().size(); i++) {
			Managements manage = fullReport.getManagementsList().get(i);
			jsonmanname.text[i] = isNull(manage.getNameCN());//中文名称
		}
		if(fullReport.getManagementsList().size()==1){
			fullReport.getManagementsList().get(0).setNameEN(Tool.isStringNullPicc(Translator.translateOnly(3, fullReport.getManagementsList().get(0).getNameCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			jsonmanname = Translator.translateMany(3, jsonmanname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getManagementsList().size(); i++) {
				Managements manage = fullReport.getManagementsList().get(i);
				if (manage.getNameEN() == null || "".equals(manage.getNameEN()) ) {
					manage.setNameEN(Tool.isStringNullPicc(jsonmanname.dest[i]));
				}
				fullReport.getManagementsList().set(i, manage);
			}
		}

		jsonmanname = new TranslatorJson();
		jsonmanname.text = new String[fullReport.getManagementsList().size()];
		for (int i = 0; i < fullReport.getManagementsList().size(); i++) {
			Managements manage = fullReport.getManagementsList().get(i);
			jsonmanname.text[i] = isNull(manage.getExperienceCN());//中文工作经验
		}
		if(fullReport.getManagementsList().size()==1){
			fullReport.getManagementsList().get(0).setExperienceEN(Tool.isStringNullPicc(Translator.translateOnly(0, fullReport.getManagementsList().get(0).getExperienceCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			jsonmanname = Translator.translateMany(0, jsonmanname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getManagementsList().size(); i++) {
				Managements manage = fullReport.getManagementsList().get(i);
				if (manage.getExperienceEN() == null || "".equals(manage.getExperienceEN()) ) {
					manage.setExperienceEN(Tool.isStringNullPicc(jsonmanname.dest[i]));
				}
				fullReport.getManagementsList().set(i, manage);
			}
		}

		jsonmanname = new TranslatorJson();
		jsonmanname.text = new String[fullReport.getManagementsList().size()];
		for (int i = 0; i < fullReport.getManagementsList().size(); i++) {
			Managements manage = fullReport.getManagementsList().get(i);
			jsonmanname.text[i] = isNull(manage.getNoteCN());//中文备注
		}
		if(fullReport.getManagementsList().size()==1){
			fullReport.getManagementsList().get(0).setNoteEN(Tool.isStringNullPicc(Translator.translateOnly(0, fullReport.getManagementsList().get(0).getNoteCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			jsonmanname = Translator.translateMany(0, jsonmanname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getManagementsList().size(); i++) {
				Managements manage = fullReport.getManagementsList().get(i);
				if (manage.getNoteEN() == null || "".equals(manage.getNoteEN()) ) {
					manage.setNoteEN(Tool.isStringNullPicc(jsonmanname.dest[i]));
				}
				fullReport.getManagementsList().set(i, manage);
			}
		}

		jsonmanname = new TranslatorJson();
		jsonmanname.text = new String[fullReport.getManagementsList().size()];
		for (int i = 0; i < fullReport.getManagementsList().size(); i++) {
			Managements manage = fullReport.getManagementsList().get(i);
			jsonmanname.text[i] = isNull(manage.getPosition());//职位
		}
		if(fullReport.getManagementsList().size()==1){
			fullReport.getManagementsList().get(0).setPositionEN(Tool.isStringNullPicc(Translator.translateOnly(0, fullReport.getManagementsList().get(0).getPosition())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			jsonmanname = Translator.translateMany(0, jsonmanname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getManagementsList().size(); i++) {
				Managements manage = fullReport.getManagementsList().get(i);
				if (manage.getPositionEN() == null || "".equals(manage.getPositionEN()) ) {
					manage.setPositionEN(Tool.isStringNullPicc(jsonmanname.dest[i]));
				}
				fullReport.getManagementsList().set(i, manage);
			}
		}
		fullReport.setManagementsList(fullReport.getManagementsList());
		return fullReport;
	}




}
