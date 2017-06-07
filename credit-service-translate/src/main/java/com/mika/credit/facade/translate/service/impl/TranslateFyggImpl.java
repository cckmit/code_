package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.Fygg;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;


public class TranslateFyggImpl {
	/**
	 * 法院公告
	 * @param fullReport
	 * @return
	 * @throws Exception
	 */
	public FullReport getEnterpriseFygg(FullReport fullReport) throws Exception {
        List<Fygg> list = fullReport.getFyggList();
		TranslatorJson namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Fygg fygg = list.get(i);
			namejson.text[i] =  isNull(fygg.getPname());//姓名
		}
		if(list.size()==1){
			list.get(0).setPnameEN(Translator.translateOnly(0, list.get(0).getPname()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				Fygg fygg = list.get(i);
				if(null==fygg.getPnameEN()||"".equals(fygg.getPnameEN())){
					fygg.setPnameEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, fygg);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Fygg fygg = list.get(i);
			namejson.text[i] =  isNull(fygg.getCourt());//法院名称
		}
		if(list.size()==1){
			list.get(0).setCourtEN(Translator.translateOnly(0, list.get(0).getCourt()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				Fygg fygg = list.get(i);
				if(null==fygg.getCourtEN()||"".equals(fygg.getCourtEN())){
					fygg.setCourtEN(Tool.isStringNullPicc(namejson.dest[i]));}
				list.set(i, fygg);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Fygg fygg = list.get(i);
			namejson.text[i] =  isNull(fygg.getNoticeType());//公告类型
		}
		if(list.size()==1){
			list.get(0).setNoticeTypeEN(Translator.translateOnly(0, list.get(0).getNoticeType()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				Fygg fygg = list.get(i);
				if(null==fygg.getNoticeTypeEN()||"".equals(fygg.getNoticeTypeEN())){
					fygg.setNoticeTypeEN(Tool.isStringNullPicc(namejson.dest[i]));}
				list.set(i, fygg);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Fygg fygg = list.get(i);
			namejson.text[i] =  isNull(fygg.getBody());//内容
		}
		if(list.size()==1){
			list.get(0).setBodyEN(Translator.translateOnly(0, list.get(0).getBody()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				Fygg fygg = list.get(i);
				if(null==fygg.getBodyEN()||"".equals(fygg.getBodyEN())){
					fygg.setBodyEN(Tool.isStringNullPicc(namejson.dest[i]));}
				list.set(i, fygg);
			}
		}

		fullReport.setFyggList(list);
		return fullReport;
	}

}
