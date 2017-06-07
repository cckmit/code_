package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.Ajlc;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;


public class TranslateAjlcImpl {
	/**
	 * 案件流程信息
	 * @param fullReport
	 * @return
	 * @throws Exception
	 */
	public FullReport getEnterpriseAjlc(FullReport fullReport) throws Exception {
        List<Ajlc> list = fullReport.getAjlcList();
		TranslatorJson namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Ajlc ajlc = list.get(i);
			namejson.text[i] =  isNull(ajlc.getPname());//当事人
		}
		if(list.size()==1){
			list.get(0).setPnameEN(Translator.translateOnly(0, list.get(0).getPname()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				Ajlc ajlc = list.get(i);
				if(null==ajlc.getPnameEN()||"".equals(ajlc.getPnameEN())){
					ajlc.setPnameEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, ajlc);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Ajlc ajlc = list.get(i);
			namejson.text[i] =  isNull(ajlc.getAjlcStatus());//审理状态
		}
		if(list.size()==1){
			list.get(0).setAjlcStatusEN(Translator.translateOnly(0, list.get(0).getAjlcStatus()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				Ajlc ajlc = list.get(i);
				if(null==ajlc.getAjlcStatusEN()||"".equals(ajlc.getAjlcStatusEN())){
					ajlc.setAjlcStatusEN(Tool.isStringNullPicc(namejson.dest[i]));}
				list.set(i, ajlc);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Ajlc ajlc = list.get(i);
			namejson.text[i] =  isNull(ajlc.getCaseNo());//案号
		}
		if(list.size()==1){
			list.get(0).setCaseNoEN(Translator.translateOnly(0, list.get(0).getCaseNo()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				Ajlc ajlc = list.get(i);
				if(null==ajlc.getCaseNoEN()||"".equals(ajlc.getCaseNoEN())){
					ajlc.setCaseNoEN(Tool.isStringNullPicc(namejson.dest[i]));}
				list.set(i, ajlc);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Ajlc ajlc = list.get(i);
			namejson.text[i] =  isNull(ajlc.getBody());//内容
		}
		if(list.size()==1){
			list.get(0).setBodyEN(Translator.translateOnly(0, list.get(0).getBody()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				Ajlc ajlc = list.get(i);
				if(null==ajlc.getBodyEN()||"".equals(ajlc.getBodyEN())){
					ajlc.setBodyEN(Tool.isStringNullPicc(namejson.dest[i]));}
				list.set(i, ajlc);
			}
		}

		fullReport.setAjlcList(list);
		return fullReport;
	}

}
