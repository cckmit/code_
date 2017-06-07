package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.Managements;
import com.mika.credit.common.entity.report.cn.MediaRecords;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import static com.mika.credit.facade.translate.util.Tool.isNull;

public class TranslateMediaRecordsImpl {
	/**
	 * 媒体记录表
	 * @param fullReport
	 * @return
	 * @throws Exception
	 */
	public FullReport getEnterpriseMediaRecords(FullReport fullReport) throws Exception{

		TranslatorJson jsonmanname = new TranslatorJson();
		jsonmanname.text = new String[fullReport.getMediaRecordsList().size()];
		for (int i = 0; i < fullReport.getMediaRecordsList().size(); i++) {
			MediaRecords mediaRecords = fullReport.getMediaRecordsList().get(i);
			jsonmanname.text[i] = isNull(mediaRecords.getTitle());//中文名称
		}
		if(fullReport.getMediaRecordsList().size()==1){
			fullReport.getMediaRecordsList().get(0).setTitleEN(Tool.isStringNullPicc(Translator.translateOnly(0, fullReport.getMediaRecordsList().get(0).getTitle())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			jsonmanname = Translator.translateMany(0, jsonmanname.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < fullReport.getMediaRecordsList().size(); i++) {
				MediaRecords mediaRecords = fullReport.getMediaRecordsList().get(i);
				if (mediaRecords.getTitleEN() == null || "".equals(mediaRecords.getTitleEN()) ) {
					mediaRecords.setTitleEN(Tool.isStringNullPicc(jsonmanname.dest[i]));
				}
				fullReport.getMediaRecordsList().set(i, mediaRecords);
			}
		}
		fullReport.setMediaRecordsList(fullReport.getMediaRecordsList());
		return fullReport;
	}




}
