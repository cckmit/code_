package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.HistoryInfos;
import com.mika.credit.common.entity.report.cn.OtherInfos;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 历史背景沿革翻译
 */
public class TranslateHistoryInfosImpl {
	/**
	 * 历史背景沿革翻译
	 * @param fullReport
	 * @return
	 * @throws Exception
	 */
	public FullReport getEnterpriseHistoryInfos(FullReport fullReport) throws Exception {
        List<HistoryInfos> historyInfosList = fullReport.getHistoryInfosList();
			TranslatorJson namejson = new TranslatorJson();
			namejson.text = new String[historyInfosList.size()];
			for (int i = 0; i < historyInfosList.size(); i++) {
				HistoryInfos historyInfos = historyInfosList.get(i);
				namejson.text[i] =  isNull(historyInfos.getDetailCN());//来自目标公司中文
			}
			if(historyInfosList.size()==1){
				historyInfosList.get(0).setDetailEN(Translator.translateOnly(1, historyInfosList.get(0).getDetailCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			}else{
				namejson = Translator.translateMany(1, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < historyInfosList.size(); i++) {
					HistoryInfos historyInfos = historyInfosList.get(i);
					if(null==historyInfos.getDetailEN()||"".equals(historyInfos.getDetailEN())){
						historyInfos.setDetailEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					historyInfosList.set(i, historyInfos);
				}
			}
		fullReport.setHistoryInfosList(historyInfosList);
		return fullReport;
	}

}
