package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import static com.mika.credit.facade.translate.util.Tool.isNull;


public class TranslateCreditAssessmentsImpl {
	/**
     * 分析评估
	 * @param fullReport
     * @return
     * @throws Exception
	 */
	public FullReport getCreditAssessments(FullReport fullReport) throws Exception {
        //翻译
		TranslatorJson json = new TranslatorJson();
		json.text = new String[3];
		json.text[0] = isNull(fullReport.getCreditAssessments().getCreditAnalysisCN());
		json.text[1] = isNull(fullReport.getCreditAssessments().getCreditOpinionCN());
		json.text[2] = isNull(fullReport.getCreditAssessments().getCreditRating());
		json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		if (null == fullReport.getCreditAssessments().getCreditAnalysisEN() || "".equals(fullReport.getCreditAssessments().getCreditAnalysisEN())) {
			fullReport.getCreditAssessments().setCreditAnalysisEN(Tool.isStringNullPicc(json.dest[0]));
		}
		if (null == fullReport.getCreditAssessments().getCreditOpinionEN() || "".equals(fullReport.getCreditAssessments().getCreditOpinionEN())) {
			fullReport.getCreditAssessments().setCreditOpinionEN(Tool.isStringNullPicc(json.dest[1]));
		}
		if (null == fullReport.getCreditAssessments().getCreditRatingEN() || "".equals(fullReport.getCreditAssessments().getCreditRatingEN())) {
			fullReport.getCreditAssessments().setCreditRatingEN(Tool.isStringNullPicc(json.dest[2]));
		}
		return fullReport;
	}

}
