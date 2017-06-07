package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.Brands;
import com.mika.credit.common.entity.report.cn.ChangeInfos;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

public class TranslateBrandsImpl {
	/**
	 * 品牌专利
	 * @param fullReport
	 * @return
	 * @throws Exception
	 */
	public FullReport getEnterpriseBrands(FullReport fullReport) throws Exception{
		List<Brands> list=fullReport.getBrandsList();
		TranslatorJson namejson = new TranslatorJson();
		namejson.text = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			Brands brands = list.get(i);
			namejson.text[i] = isNull(brands.getPatentName());
		}
		if(list.size()==1){
			list.get(0).setPatentNameEN(Translator.translateOnly(0, list.get(0).getPatentName()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				Brands brands = list.get(i);
				if(null==brands.getPatentNameEN()||"".equals(brands.getPatentNameEN())){
					brands.setPatentNameEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, brands);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Brands brands = list.get(i);
			namejson.text[i] = isNull(brands.getType());
		}
		if(list.size()==1){
			list.get(0).setTypeEN(Translator.translateOnly(0, list.get(0).getType()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				Brands brands = list.get(i);
				if(null==brands.getTypeEN()||"".equals(brands.getTypeEN())){
					brands.setTypeEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, brands);
			}
		}
		fullReport.setBrandsList(list);
		return fullReport;
	}

}
