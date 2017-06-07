package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.ChangeInfos;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.ArrayList;
import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

public class TranslateChangeInfosImpl {
	/**
	 * 注册变更表信息
	 * @param fullReport
	 * @return
	 * @throws Exception
	 */
	public FullReport getEnterpriseChangeInfos(FullReport fullReport) throws Exception{
		List<ChangeInfos> list=fullReport.getChangeInfosList();
		List<ChangeInfos> list1_30=new ArrayList<ChangeInfos>();
		List<ChangeInfos> list30_60=new ArrayList<ChangeInfos>();
		int count = 0;
		if(null!=list && list.size()>20){
			list30_60=new ArrayList<ChangeInfos>();
			for (int i = 0; i < list.size(); i+=5) {
				count = i;
				list1_30 = new ArrayList<ChangeInfos>();
				for (int j = i; j < 5+i; j++) {
					System.out.println("j=="+j);
					try {
						ChangeInfos change = new ChangeInfos();
						change = list.get(j);
						list1_30.add(change);
					} catch (Exception e) {

					}
				}
				TranslatorJson json = new TranslatorJson();
				json.text = new String[list1_30.size()*2];
				for (int s = 0; s < list1_30.size(); s++) {
					ChangeInfos chang = list1_30.get(s);
					if(null!=chang.getAfterCN()&&!"".equals(chang.getAfterCN())){
						chang.setAfterCN(chang.getAfterCN().replace("、", "."));
						chang.setAfterCN(chang.getAfterCN().replace('"', '“'));
						chang.setAfterCN(chang.getAfterCN().replace(",", "，"));
//						chang.setAfterCN(chang.getAfterCN().replace("%", "percent"));
						chang.setAfterCN(chang.getAfterCN().replace(":", "："));
						chang.setAfterCN(chang.getAfterCN().replace(";", "；"));
					}
					json.text[s] = Tool.isStringNullPicc(chang.getAfterCN());
				}
				for (int s = list1_30.size(), c=0; s < list1_30.size()*2&&c<list1_30.size(); s++,c++) {
					ChangeInfos chang = list1_30.get(c);
					if(null!=chang.getBeforeCN()&&!"".equals(chang.getBeforeCN())){
						chang.setBeforeCN(chang.getBeforeCN().replace("、", "."));
						chang.setBeforeCN(chang.getBeforeCN().replace('"', '“'));
						chang.setBeforeCN(chang.getBeforeCN().replace(",", "，"));
//						chang.setBeforeCN(chang.getBeforeCN().replace("%", "percent"));
						chang.setBeforeCN(chang.getBeforeCN().replace(":", "："));
						chang.setBeforeCN(chang.getBeforeCN().replace(";", "；"));
					}
					json.text[s] = Tool.isStringNullPicc(chang.getBeforeCN());
				}
				for (int c =0;c<json.text.length;c++){
					System.out.println("json.text[c]"+c+"=="+json.text[c]);
				}
				json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名

				for (int s = 0,a = count; s < list1_30.size(); s++,a++) {
					ChangeInfos chang = list1_30.get(s);
					chang.setAfterEN(Tool.isStringNullPicc(json.dest[s]));
					list.set(a, chang);
				}
				for (int s = list1_30.size(), c=0,a = count; s < list1_30.size()*2&&c<list1_30.size(); s++,c++,a++) {
					ChangeInfos chang = list1_30.get(c);
					chang.setBeforeEN(Tool.isStringNullPicc(json.dest[s]));
					list.set(a, chang);
				}
			}
//			System.out.println("list30_60=="+list.size());

		}else{
			for (int i = 0; i < list.size(); i+=2) {
				count = i;
				list1_30 = new ArrayList<ChangeInfos>();
				for (int j = i; j < 2+i; j++) {
					System.out.println("j=="+j);
					try {
						ChangeInfos change = new ChangeInfos();
						change = list.get(j);
						list1_30.add(change);
					} catch (Exception e) {

					}
				}
				TranslatorJson json = new TranslatorJson();
				json.text = new String[list1_30.size()*2];
				for (int s = 0; s < list1_30.size(); s++) {
					ChangeInfos chang = list1_30.get(s);
					if(null!=chang.getAfterCN()&&!"".equals(chang.getAfterCN())){
						chang.setAfterCN(chang.getAfterCN().replace("、", "."));
						chang.setAfterCN(chang.getAfterCN().replace('"', '“'));
						chang.setAfterCN(chang.getAfterCN().replace(",", "，"));
//						chang.setAfterCN(chang.getAfterCN().replace("%", "percent"));
						chang.setAfterCN(chang.getAfterCN().replace(":", "："));
						chang.setAfterCN(chang.getAfterCN().replace(";", "；"));
					}
					json.text[s] = Tool.isStringNullPicc(chang.getAfterCN());
				}
				for (int s = list1_30.size(), c=0; s < list1_30.size()*2&&c<list1_30.size(); s++,c++) {
					ChangeInfos chang = list1_30.get(c);
					if(null!=chang.getBeforeCN()&&!"".equals(chang.getBeforeCN())){
						chang.setBeforeCN(chang.getBeforeCN().replace("、", "."));
						chang.setBeforeCN(chang.getBeforeCN().replace('"', '“'));
						chang.setBeforeCN(chang.getBeforeCN().replace(",", "，"));
//						chang.setBeforeCN(chang.getBeforeCN().replace("%", "percent"));
						chang.setBeforeCN(chang.getBeforeCN().replace(":", "："));
						chang.setBeforeCN(chang.getBeforeCN().replace(";", "；"));
					}
					json.text[s] = Tool.isStringNullPicc(chang.getBeforeCN());
				}
				for (int c =0;c<json.text.length;c++){
					System.out.println("json.text[c]"+c+"=="+json.text[c]);
				}
				json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名

				for (int s = 0,a = count; s < list1_30.size(); s++,a++) {
					ChangeInfos chang = list1_30.get(s);
					chang.setAfterEN(Tool.isStringNullPicc(json.dest[s]));
					list.set(a, chang);
				}
				for (int s = list1_30.size(), c=0,a = count; s < list1_30.size()*2&&c<list1_30.size(); s++,c++,a++) {
					ChangeInfos chang = list1_30.get(c);
					chang.setBeforeEN(Tool.isStringNullPicc(json.dest[s]));
					list.set(a, chang);
				}
			}
//			TranslatorJson namejson = new TranslatorJson();
//			namejson.text = new String[list.size()];
//			for (int i = 0; i < list.size(); i++) {
//				ChangeInfos changeInfos = list.get(i);
//				namejson.text[i] = isNull(changeInfos.getBeforeCN());
//			}
//			if(list.size()==1){
//				list.get(0).setBeforeEN(Translator.translateOnly(0, list.get(0).getBeforeCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
//			}else{
//				namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
//				for (int i = 0; i < list.size(); i++) {
//					ChangeInfos changeInfos = list.get(i);
//					if(null==changeInfos.getBeforeEN()||"".equals(changeInfos.getBeforeEN())){
//						changeInfos.setBeforeEN(Tool.isStringNullPicc(namejson.dest[i]));
//					}
//					list.set(i, changeInfos);
//				}
//			}
//
//			namejson = new TranslatorJson();
//			namejson.text = new String[list.size()];
//			for (int i = 0; i < list.size(); i++) {
//				ChangeInfos changeInfos = list.get(i);
//				namejson.text[i] = isNull(changeInfos.getAfterCN());
//			}
//			if(list.size()==1){
//				list.get(0).setAfterEN(Translator.translateOnly(0, list.get(0).getAfterCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
//			}else{
//				namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
//				for (int i = 0; i < list.size(); i++) {
//					ChangeInfos changeInfos = list.get(i);
//					if(null==changeInfos.getAfterEN()||"".equals(changeInfos.getAfterEN())){
//						changeInfos.setAfterEN(Tool.isStringNullPicc(namejson.dest[i]));
//					}
//					list.set(i, changeInfos);
//				}
//			}
//			fullReport.setChangeInfosList(list);
		}

		//变更类型
		TranslatorJson namejson = new TranslatorJson();
		namejson.text = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ChangeInfos changeInfos = list.get(i);
			namejson.text[i] = isNull(changeInfos.getChangeType());
		}
		if(list.size()==1){
			list.get(0).setChangeTypeEN(Translator.translateOnly(0, list.get(0).getChangeType()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				ChangeInfos changeInfos = list.get(i);
				if(null==changeInfos.getChangeTypeEN()||"".equals(changeInfos.getChangeTypeEN())){
					changeInfos.setChangeTypeEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, changeInfos);
			}
		}
		fullReport.setChangeInfosList(list);
		return fullReport;
	}

}
