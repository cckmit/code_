package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.OtherInfos;
import com.mika.credit.common.entity.report.cn.ShareholdersChain;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 其他信息翻译
 */
public class TranslateOtherInfosImpl {
	/**
	 * 其他信息翻译
	 * @param fullReport
	 * @return
	 * @throws Exception
	 */
	public FullReport getEnterpriseOtherInfos(FullReport fullReport) throws Exception {
        List<OtherInfos> otherInfosList = fullReport.getOtherInfosList();
			TranslatorJson namejson = new TranslatorJson();
			namejson.text = new String[otherInfosList.size()];
			for (int i = 0; i < otherInfosList.size(); i++) {
				OtherInfos otherInfos = otherInfosList.get(i);
				namejson.text[i] =  isNull(otherInfos.getNameCN());//中文名称
			}
			if(otherInfosList.size()==1){
				otherInfosList.get(0).setNameEN(Translator.translateOnly(0, otherInfosList.get(0).getNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			}else{
				namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < otherInfosList.size(); i++) {
					OtherInfos otherInfos = otherInfosList.get(i);
					if(null==otherInfos.getNameEN()||"".equals(otherInfos.getNameEN())){
						otherInfos.setNameEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					otherInfosList.set(i, otherInfos);
				}
			}

			namejson = new TranslatorJson();
			namejson.text = new String[otherInfosList.size()];
			for (int i = 0; i < otherInfosList.size(); i++) {
				OtherInfos otherInfos = otherInfosList.get(i);
				namejson.text[i] =  isNull(otherInfos.getDetailsCN());//中文信息详细
			}
			if(otherInfosList.size()==1){
				otherInfosList.get(0).setDetailsEN(Translator.translateOnly(0, otherInfosList.get(0).getDetailsCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			}else{
				namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < otherInfosList.size(); i++) {
					OtherInfos otherInfos = otherInfosList.get(i);
					if(null==otherInfos.getDetailsEN()||"".equals(otherInfos.getDetailsEN())){
						otherInfos.setDetailsEN(Tool.isStringNullPicc(namejson.dest[i]));}
					otherInfosList.set(i, otherInfos);
				}
			}
		fullReport.setOtherInfosList(otherInfosList);
		return fullReport;
	}

}
