package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FinancialFigures;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;


public class TranslateFinancialFiguresImpl {
	/**
     * 财物说明
	 * @param fullReport
     * @return
     * @throws Exception
	 */
	public FullReport getFinancialFigures(FullReport fullReport) throws Exception {
        //翻译
		List<FinancialFigures> list = fullReport.getFinancialFiguresList();
		TranslatorJson namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			FinancialFigures financialFigures = list.get(i);
			namejson.text[i] =  isNull(financialFigures.getNoteCN());
		}
		if(list.size()==1){
			list.get(0).setNoteEN(Translator.translateOnly(0, list.get(0).getNoteCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(1, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				FinancialFigures financialFigures = list.get(i);
				if(null==financialFigures.getNoteEN()||"".equals(financialFigures.getNoteEN())){
					financialFigures.setNoteEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, financialFigures);
			}
		}

		//翻译
		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			FinancialFigures financialFigures = list.get(i);
			namejson.text[i] =  isNull(financialFigures.getAuditorNameCN());
		}
		if(list.size()==1){
			list.get(0).setAuditorNameEN(Translator.translateOnly(0, list.get(0).getAuditorNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(1, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				FinancialFigures financialFigures = list.get(i);
				if(null==financialFigures.getAuditorNameEN()||"".equals(financialFigures.getAuditorNameEN())){
					financialFigures.setAuditorNameEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, financialFigures);
			}
		}

		//翻译
		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			FinancialFigures financialFigures = list.get(i);
			namejson.text[i] =  isNull(financialFigures.getAuditorCommentCN());
		}
		if(list.size()==1){
			list.get(0).setAuditorCommentEN(Translator.translateOnly(0, list.get(0).getAuditorCommentCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(1, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				FinancialFigures financialFigures = list.get(i);
				if(null==financialFigures.getAuditorCommentEN()||"".equals(financialFigures.getAuditorCommentEN())){
					financialFigures.setAuditorCommentEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, financialFigures);
			}
		}
		fullReport.setFinancialFiguresList(list);
		return fullReport;
	}

}
