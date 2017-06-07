package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.BankInfos;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;
import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;


public class TranslateBankInfosImpl {
	/**
	 * 银行信息
	 * @param fullReport
	 * @return
	 * @throws Exception
	 */
	public FullReport getEnterpriseBankInfos(FullReport fullReport) throws Exception {
        List<BankInfos> list = fullReport.getBankInfosList();
		TranslatorJson namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			BankInfos bank = list.get(i);
			namejson.text[i] =  isNull(bank.getNameCN());//中文名称
		}
		if(list.size()==1){
			list.get(0).setNameEN(Translator.translateOnly(1, list.get(0).getNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(1, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				BankInfos bank = list.get(i);
				if(null==bank.getNameEN()||"".equals(bank.getNameEN())){
					bank.setNameEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, bank);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			BankInfos bank = list.get(i);
			namejson.text[i] =  isNull(bank.getCommentCN());//中文银行评价
		}
		if(list.size()==1){
			list.get(0).setCommentEN(Translator.translateOnly(0, list.get(0).getCommentCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				BankInfos bank = list.get(i);
				if(null==bank.getCommentEN()||"".equals(bank.getCommentEN())){
					bank.setCommentEN(Tool.isStringNullPicc(namejson.dest[i]));}
				list.set(i, bank);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			BankInfos bank = list.get(i);
			namejson.text[i] =  isNull(bank.getAddressCN());//中文地址
		}
		if(list.size()==1){
			list.get(0).setAddressEN(Translator.translateOnly(2, list.get(0).getAddressCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(2, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				BankInfos bank = list.get(i);
				if(null==bank.getAddressEN()||"".equals(bank.getAddressEN())){
					bank.setAddressEN(Tool.isStringNullPicc(namejson.dest[i]));}
				list.set(i, bank);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			BankInfos bank = list.get(i);
			namejson.text[i] =  isNull(bank.getInterviewedCN());//采访对象
		}
		if(list.size()==1){
			list.get(0).setInterviewedEN(Translator.translateOnly(0, list.get(0).getInterviewedCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				BankInfos bank = list.get(i);
				if(null==bank.getInterviewedEN()||"".equals(bank.getInterviewedEN())){
					bank.setInterviewedEN(Tool.isStringNullPicc(namejson.dest[i]));}
				list.set(i, bank);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			BankInfos bank = list.get(i);
			namejson.text[i] =  isNull(bank.getNoteCN());//中文备注
		}
		if(list.size()==1){
			list.get(0).setNoteEN(Translator.translateOnly(0, list.get(0).getNoteCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				BankInfos bank = list.get(i);
				if(null==bank.getNoteEN()||"".equals(bank.getNoteEN())){
					bank.setNoteEN(Tool.isStringNullPicc(namejson.dest[i]));}
				list.set(i, bank);
			}
		}

		namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			BankInfos bank = list.get(i);
			namejson.text[i] =  isNull(bank.getPledgeCN());//中文质押
		}
		if(list.size()==1){
			list.get(0).setPledgeEN(Translator.translateOnly(0, list.get(0).getPledgeCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				BankInfos bank = list.get(i);
				if(null==bank.getPledgeEN()||"".equals(bank.getPledgeEN())){
					bank.setPledgeEN(Tool.isStringNullPicc(namejson.dest[i]));}
				list.set(i, bank);
			}
		}
		fullReport.setBankInfosList(list);
		return fullReport;
	}

}
