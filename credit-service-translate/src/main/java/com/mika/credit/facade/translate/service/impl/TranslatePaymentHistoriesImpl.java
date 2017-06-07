package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.PaymentHistories;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;
import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 支付款记录翻译
 * Created by Zhu Jun on 2017/3/29.
 */
public class TranslatePaymentHistoriesImpl {


	public FullReport getEnterprisePaymentHistories(FullReport fullReport)throws Exception{
		List<PaymentHistories> list = fullReport.getPaymentHistoriesList();//支付款记录
		//翻译名称
			TranslatorJson namejson = new TranslatorJson();
			namejson.text = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				PaymentHistories pay = list.get(i);
				namejson.text[i] = isNull(pay.getNameCN());
			}
			if(list.size()==1){
				list.get(0).setNameEN(Translator.translateOnly(1, list.get(0).getNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			}else{
				namejson = Translator.translateMany(1, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < list.size(); i++) {
					PaymentHistories pay = list.get(i);
					if(null==pay.getNameEN()||"".equals(pay.getNameEN())){
						pay.setNameEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					list.set(i, pay);
				}
			}

		//翻译主要供应商品
        namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			PaymentHistories pay = list.get(i);
			namejson.text[i] = isNull(pay.getMainSuppliersCN());
		}
		if(list.size()==1){
			list.get(0).setMainSuppliersEN(Translator.translateOnly(3, list.get(0).getMainSuppliersCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(3, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				PaymentHistories pay = list.get(i);
				if(null==pay.getMainSuppliersEN()||"".equals(pay.getMainSuppliersEN())){
					pay.setMainSuppliersEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, pay);
			}
		}

		//翻译采访对象
		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			PaymentHistories pay = list.get(i);
			namejson.text[i] = isNull(pay.getInterviewedCN());
		}
		if(list.size()==1){
			list.get(0).setInterviewedEN(Translator.translateOnly(0, list.get(0).getInterviewedCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				PaymentHistories pay = list.get(i);
				if(null==pay.getInterviewedEN()||"".equals(pay.getInterviewedEN())){
					pay.setInterviewedEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, pay);
			}
		}

		//翻译拖欠付款情况
		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			PaymentHistories pay = list.get(i);
			namejson.text[i] = isNull(pay.getPaymentCN());
		}
		if(list.size()==1){
			list.get(0).setPaymentEN(Translator.translateOnly(0, list.get(0).getPaymentCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				PaymentHistories pay = list.get(i);
				if(null==pay.getPaymentEN()||"".equals(pay.getPaymentEN())){
					pay.setPaymentEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, pay);
			}
		}

		//翻译债务催收情况
		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			PaymentHistories pay = list.get(i);
			namejson.text[i] = isNull(pay.getCollectionCN());
		}
		if(list.size()==1){
			list.get(0).setCollectionEN(Translator.translateOnly(0, list.get(0).getCollectionCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				PaymentHistories pay = list.get(i);
				if(null==pay.getCollectionEN()||"".equals(pay.getCollectionEN())){
					pay.setCollectionEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, pay);
			}
		}

		//翻译支付模式
		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			PaymentHistories pay = list.get(i);
			namejson.text[i] = isNull(pay.getPaymentMode());
		}
		if(list.size()==1){
			list.get(0).setPaymentModeEN(Translator.translateOnly(0, list.get(0).getPaymentMode()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				PaymentHistories pay = list.get(i);
				if(null==pay.getPaymentModeEN()||"".equals(pay.getPaymentModeEN())){
					pay.setPaymentModeEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, pay);
			}
		}

		//翻译支付方式
		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			PaymentHistories pay = list.get(i);
			namejson.text[i] = isNull(pay.getPaymentMethod());
		}
		if(list.size()==1){
			list.get(0).setPaymentMethodEN(Translator.translateOnly(0, list.get(0).getPaymentMethod()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				PaymentHistories pay = list.get(i);
				if(null==pay.getPaymentMethodEN()||"".equals(pay.getPaymentMethodEN())){
					pay.setPaymentMethodEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, pay);
			}
		}
		fullReport.setPaymentHistoriesList(list);
		return  fullReport;
	}

}
