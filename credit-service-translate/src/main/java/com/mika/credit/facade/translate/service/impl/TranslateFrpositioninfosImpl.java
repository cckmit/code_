package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.Frpositioninfos;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.ArrayList;
import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;


public class TranslateFrpositioninfosImpl {
	/**
     * 法人其他任职信息
	 * @param fullReport
     * @return
     * @throws Exception
	 */
	public FullReport getFrpositioninfos(FullReport fullReport) throws Exception {
        //翻译
		List<Frpositioninfos> list = fullReport.getFrpositioninfosList();
		List<Frpositioninfos> list1_30=new ArrayList<Frpositioninfos>();
		List<Frpositioninfos> list30_60=new ArrayList<Frpositioninfos>();
		int count = 0;
		if(null!=list && list.size()>20){
			list30_60=new ArrayList<Frpositioninfos>();
			for (int i = 0; i < list.size(); i+=10) {
				count = i;
				list1_30 = new ArrayList<Frpositioninfos>();
				for (int j = i; j < 10+i; j++) {
					System.out.println("j=="+j);
					try {
						Frpositioninfos frpositioninfos = new Frpositioninfos();
						frpositioninfos = list.get(j);
						list1_30.add(frpositioninfos);
					} catch (Exception e) {

					}
					TranslatorJson json = new TranslatorJson();
					json.text = new String[list1_30.size()*2];
					for (int s = 0; s < list1_30.size(); s++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						if(null!=frpositioninfos.getRegOrgCN()&&!"".equals(frpositioninfos.getRegOrgCN())){
							frpositioninfos.setRegOrgCN(frpositioninfos.getRegOrgCN().replace(",", ""));
							frpositioninfos.setRegOrgCN(frpositioninfos.getRegOrgCN().replace("、", "."));
							frpositioninfos.setRegOrgCN(frpositioninfos.getRegOrgCN().replace('"', ' '));
							frpositioninfos.setRegOrgCN(frpositioninfos.getRegOrgCN().replace(",", ""));
						}
						json.text[s] = Tool.isStringNullPicc(frpositioninfos.getRegOrgCN());
					}
					for (int s = list1_30.size(), c=0; s < list1_30.size()*2&&c<list1_30.size(); s++,c++) {
						Frpositioninfos frpositioninfos = list1_30.get(c);
						if(null!=frpositioninfos.getPositionCN()&&!"".equals(frpositioninfos.getPositionCN())){
							frpositioninfos.setPositionCN(frpositioninfos.getPositionCN().replace(",", ""));
							frpositioninfos.setPositionCN(frpositioninfos.getPositionCN().replace("、", "."));
							frpositioninfos.setPositionCN(frpositioninfos.getPositionCN().replace('"', ' '));
							frpositioninfos.setPositionCN(frpositioninfos.getPositionCN().replace(",", ""));
						}
						json.text[s] = Tool.isStringNullPicc(frpositioninfos.getPositionCN());
					}
					json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
					for (int s = 0,a = count; s < list1_30.size(); s++,a++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						frpositioninfos.setRegOrgEN(Tool.isStringNullPicc(json.dest[s]));
						list.set(a, frpositioninfos);
					}
					for (int s = list1_30.size(), c=0,a = count; s < list1_30.size()*2&&c<list1_30.size(); s++,c++,a++) {
						Frpositioninfos frpositioninfos = list1_30.get(c);
						frpositioninfos.setPositionEN(Tool.isStringNullPicc(json.dest[s]));
						list.set(a, frpositioninfos);
					}


					TranslatorJson entNameCNJson = new TranslatorJson();
					entNameCNJson.text = new String[list1_30.size()];
					for (int s = 0; s < list1_30.size(); s++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						if(null!=frpositioninfos.getEnterpriseNameCN()&&!"".equals(frpositioninfos.getEnterpriseNameCN())){
							frpositioninfos.setEnterpriseNameCN(frpositioninfos.getEnterpriseNameCN().replace(",", ""));
							frpositioninfos.setEnterpriseNameCN(frpositioninfos.getEnterpriseNameCN().replace("、", "."));
							frpositioninfos.setEnterpriseNameCN(frpositioninfos.getEnterpriseNameCN().replace('"', ' '));
							frpositioninfos.setEnterpriseNameCN(frpositioninfos.getEnterpriseNameCN().replace(",", ""));
						}
						entNameCNJson.text[s] = Tool.isStringNullPicc(frpositioninfos.getEnterpriseNameCN());
					}

					entNameCNJson = Translator.translateMany(1, entNameCNJson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
					for (int s = 0,a = count; s < list1_30.size(); s++,a++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						frpositioninfos.setEnterpriseNameEN(Tool.isStringNullPicc(entNameCNJson.dest[s]));
						list.set(a, frpositioninfos);
					}

					TranslatorJson nameCNJson = new TranslatorJson();
					nameCNJson.text = new String[list1_30.size()];
					for (int s = 0; s < list1_30.size(); s++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						if(null!=frpositioninfos.getNameCN()&&!"".equals(frpositioninfos.getNameCN())){
							frpositioninfos.setNameCN(frpositioninfos.getNameCN().replace(",", ""));
							frpositioninfos.setNameCN(frpositioninfos.getNameCN().replace("、", "."));
							frpositioninfos.setNameCN(frpositioninfos.getNameCN().replace('"', ' '));
							frpositioninfos.setNameCN(frpositioninfos.getNameCN().replace(",", ""));
						}
						nameCNJson.text[s] = Tool.isStringNullPicc(frpositioninfos.getNameCN());
					}

					nameCNJson = Translator.translateMany(3, nameCNJson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
					for (int s = 0,a = count; s < list1_30.size(); s++,a++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						frpositioninfos.setNameEN(Tool.isStringNullPicc(nameCNJson.dest[s]));
						list.set(a, frpositioninfos);
					}

					TranslatorJson addressCNJson = new TranslatorJson();
					addressCNJson.text = new String[list1_30.size()];
					for (int s = 0; s < list1_30.size(); s++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						if(null!=frpositioninfos.getAddressCN()&&!"".equals(frpositioninfos.getAddressCN())){
							frpositioninfos.setAddressCN(frpositioninfos.getAddressCN().replace(",", ""));
							frpositioninfos.setAddressCN(frpositioninfos.getAddressCN().replace("、", "."));
							frpositioninfos.setAddressCN(frpositioninfos.getAddressCN().replace('"', ' '));
							frpositioninfos.setAddressCN(frpositioninfos.getAddressCN().replace(",", ""));
						}
						addressCNJson.text[s] = Tool.isStringNullPicc(frpositioninfos.getAddressCN());
					}

					addressCNJson = Translator.translateMany(2, addressCNJson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
					for (int s = 0,a = count; s < list1_30.size(); s++,a++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						frpositioninfos.setAddressEN(Tool.isStringNullPicc(addressCNJson.dest[s]));
						list.set(a, frpositioninfos);
					}

//					TranslatorJson positionJson = new TranslatorJson();
//					positionJson.text = new String[list1_30.size()];
//					for (int s = 0; s < list1_30.size(); s++) {
//						Frpositioninfos frpositioninfos = list1_30.get(s);
//						if(null!=frpositioninfos.getPosition()&&!"".equals(frpositioninfos.getPosition())){
//							frpositioninfos.setPosition(frpositioninfos.getPosition().replace(",", ""));
//							frpositioninfos.setPosition(frpositioninfos.getPosition().replace("、", "."));
//							frpositioninfos.setPosition(frpositioninfos.getPosition().replace('"', ' '));
//							frpositioninfos.setPosition(frpositioninfos.getPosition().replace(",", ""));
//						}
//						positionJson.text[s] = Tool.isStringNullPicc(frpositioninfos.getPosition());
//					}
//
//					positionJson = Translator.translateMany(2, positionJson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
//					for (int s = 0,a = count; s < list1_30.size(); s++,a++) {
//						Frpositioninfos frpositioninfos = list1_30.get(s);
//						frpositioninfos.setPositionEN(Tool.isStringNullPicc(positionJson.dest[s]));
//						list.set(a, frpositioninfos);
//					}

					TranslatorJson enterpriseTypeJson = new TranslatorJson();
					enterpriseTypeJson.text = new String[list1_30.size()];
					for (int s = 0; s < list1_30.size(); s++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						if(null!=frpositioninfos.getEnterpriseTypeCN()&&!"".equals(frpositioninfos.getEnterpriseTypeCN())){
							frpositioninfos.setEnterpriseTypeCN(frpositioninfos.getEnterpriseTypeCN().replace(",", ""));
							frpositioninfos.setEnterpriseTypeCN(frpositioninfos.getEnterpriseTypeCN().replace("、", "."));
							frpositioninfos.setEnterpriseTypeCN(frpositioninfos.getEnterpriseTypeCN().replace('"', ' '));
							frpositioninfos.setEnterpriseTypeCN(frpositioninfos.getEnterpriseTypeCN().replace(",", ""));
						}
						enterpriseTypeJson.text[s] = Tool.isStringNullPicc(frpositioninfos.getEnterpriseTypeCN());
					}

					enterpriseTypeJson = Translator.translateMany(0, enterpriseTypeJson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
					for (int s = 0,a = count; s < list1_30.size(); s++,a++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						frpositioninfos.setEnterpriseTypeEN(Tool.isStringNullPicc(enterpriseTypeJson.dest[s]));
						list.set(a, frpositioninfos);
					}

					TranslatorJson regCapitalCurrencyJson = new TranslatorJson();
					regCapitalCurrencyJson.text = new String[list1_30.size()];
					for (int s = 0; s < list1_30.size(); s++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						if(null!=frpositioninfos.getRegCapitalCurrencyCN()&&!"".equals(frpositioninfos.getRegCapitalCurrencyCN())){
							frpositioninfos.setRegCapitalCurrencyCN(frpositioninfos.getRegCapitalCurrencyCN().replace(",", ""));
							frpositioninfos.setRegCapitalCurrencyCN(frpositioninfos.getRegCapitalCurrencyCN().replace("、", "."));
							frpositioninfos.setRegCapitalCurrencyCN(frpositioninfos.getRegCapitalCurrencyCN().replace('"', ' '));
							frpositioninfos.setRegCapitalCurrencyCN(frpositioninfos.getRegCapitalCurrencyCN().replace(",", ""));
						}
						regCapitalCurrencyJson.text[s] = Tool.isStringNullPicc(frpositioninfos.getRegCapitalCurrencyCN());
					}

					regCapitalCurrencyJson = Translator.translateMany(0, regCapitalCurrencyJson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
					for (int s = 0,a = count; s < list1_30.size(); s++,a++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						frpositioninfos.setRegCapitalCurrencyEN(Tool.isStringNullPicc(regCapitalCurrencyJson.dest[s]));
						list.set(a, frpositioninfos);
					}

					TranslatorJson fundedRatioJson = new TranslatorJson();
					fundedRatioJson.text = new String[list1_30.size()];
					for (int s = 0; s < list1_30.size(); s++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						if(null!=frpositioninfos.getFundedRatioCN()&&!"".equals(frpositioninfos.getFundedRatioCN())){
							frpositioninfos.setFundedRatioCN(frpositioninfos.getFundedRatioCN().replace(",", ""));
							frpositioninfos.setFundedRatioCN(frpositioninfos.getFundedRatioCN().replace("、", "."));
							frpositioninfos.setFundedRatioCN(frpositioninfos.getFundedRatioCN().replace('"', ' '));
							frpositioninfos.setFundedRatioCN(frpositioninfos.getFundedRatioCN().replace(",", ""));
						}
						fundedRatioJson.text[s] = Tool.isStringNullPicc(frpositioninfos.getFundedRatioCN());
					}

					fundedRatioJson = Translator.translateMany(0, fundedRatioJson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
					for (int s = 0,a = count; s < list1_30.size(); s++,a++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						frpositioninfos.setFundedRatioEN(Tool.isStringNullPicc(fundedRatioJson.dest[s]));
						list.set(a, frpositioninfos);
					}


					TranslatorJson entStatusCNJson = new TranslatorJson();
					entStatusCNJson.text = new String[list1_30.size()];
					for (int s = 0; s < list1_30.size(); s++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						if(null!=frpositioninfos.getEnterpriseStatusCN() && !"".equals(frpositioninfos.getEnterpriseStatusCN())){
							frpositioninfos.setEnterpriseStatusCN(frpositioninfos.getEnterpriseStatusCN().replace(",", ""));
							frpositioninfos.setEnterpriseStatusCN(frpositioninfos.getEnterpriseStatusCN().replace("、", "."));
							frpositioninfos.setEnterpriseStatusCN(frpositioninfos.getEnterpriseStatusCN().replace('"', ' '));
							frpositioninfos.setEnterpriseStatusCN(frpositioninfos.getEnterpriseStatusCN().replace(",", ""));
						}
						entStatusCNJson.text[s] = Tool.isStringNullPicc(frpositioninfos.getEnterpriseStatusCN());
					}

					entStatusCNJson = Translator.translateMany(0, entStatusCNJson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
					for (int s = 0,a = count; s < list1_30.size(); s++,a++) {
						Frpositioninfos frpositioninfos = list1_30.get(s);
						frpositioninfos.setEnterpriseStatusEN(Tool.isStringNullPicc(entStatusCNJson.dest[s]));
						list.set(a, frpositioninfos);
					}
				}
			}
		}else {
			TranslatorJson namejson = new TranslatorJson();
			namejson.text = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Frpositioninfos frpositioninfos = list.get(i);
				namejson.text[i] = isNull(frpositioninfos.getNameCN());
			}
			if (list.size() == 1) {
				list.get(0).setNameEN(Translator.translateOnly(3, list.get(0).getNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			} else {
				namejson = Translator.translateMany(3, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < list.size(); i++) {
					Frpositioninfos frpositioninfos = list.get(i);
					if (null == frpositioninfos.getNameEN() || "".equals(frpositioninfos.getNameEN())) {
						frpositioninfos.setNameEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					list.set(i, frpositioninfos);
				}
			}

			//翻译
			namejson = new TranslatorJson();
			namejson.text = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Frpositioninfos frpositioninfos = list.get(i);
				namejson.text[i] = isNull(frpositioninfos.getEnterpriseNameCN());
			}
			if (list.size() == 1) {
				list.get(0).setEnterpriseNameEN(Translator.translateOnly(1, list.get(0).getEnterpriseNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			} else {
				namejson = Translator.translateMany(1, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < list.size(); i++) {
					Frpositioninfos frpositioninfos = list.get(i);
					if (null == frpositioninfos.getEnterpriseNameEN() || "".equals(frpositioninfos.getEnterpriseNameEN())) {
						frpositioninfos.setEnterpriseNameEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					list.set(i, frpositioninfos);
				}
			}

			//翻译
			namejson = new TranslatorJson();
			namejson.text = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Frpositioninfos frpositioninfos = list.get(i);
				namejson.text[i] = isNull(frpositioninfos.getRegOrgCN());
			}
			if (list.size() == 1) {
				list.get(0).setRegOrgEN(Translator.translateOnly(0, list.get(0).getRegOrgCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			} else {
				namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < list.size(); i++) {
					Frpositioninfos frpositioninfos = list.get(i);
					if (null == frpositioninfos.getRegOrgEN() || "".equals(frpositioninfos.getRegOrgEN())) {
						frpositioninfos.setRegOrgEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					list.set(i, frpositioninfos);
				}
			}

			//翻译
			namejson = new TranslatorJson();
			namejson.text = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Frpositioninfos frpositioninfos = list.get(i);
				namejson.text[i] = isNull(frpositioninfos.getPositionCN());
			}
			if (list.size() == 1) {
				list.get(0).setPositionEN(Translator.translateOnly(0, list.get(0).getPositionCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			} else {
				namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < list.size(); i++) {
					Frpositioninfos frpositioninfos = list.get(i);
					if (null == frpositioninfos.getPositionEN() || "".equals(frpositioninfos.getPositionEN())) {
						frpositioninfos.setPositionEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					list.set(i, frpositioninfos);
				}
			}

			//翻译
			namejson = new TranslatorJson();
			namejson.text = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Frpositioninfos frpositioninfos = list.get(i);
				namejson.text[i] = isNull(frpositioninfos.getAddressCN());
			}
			if (list.size() == 1) {
				list.get(0).setAddressEN(Translator.translateOnly(2, list.get(0).getAddressCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			} else {
				namejson = Translator.translateMany(2, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < list.size(); i++) {
					Frpositioninfos frpositioninfos = list.get(i);
					if (null == frpositioninfos.getAddressEN() || "".equals(frpositioninfos.getAddressEN())) {
						frpositioninfos.setAddressEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					list.set(i, frpositioninfos);
				}
			}
			//翻译
			namejson = new TranslatorJson();
			namejson.text = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Frpositioninfos frpositioninfos = list.get(i);
				namejson.text[i] = isNull(frpositioninfos.getPosition());
			}
			if (list.size() == 1) {
				list.get(0).setPositionEN(Translator.translateOnly(0, list.get(0).getPosition()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			} else {
				namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < list.size(); i++) {
					Frpositioninfos frpositioninfos = list.get(i);
					if (null == frpositioninfos.getPositionEN() || "".equals(frpositioninfos.getPositionEN())) {
						frpositioninfos.setPositionEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					list.set(i, frpositioninfos);
				}
			}
			//翻译
			namejson = new TranslatorJson();
			namejson.text = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Frpositioninfos frpositioninfos = list.get(i);
				namejson.text[i] = isNull(frpositioninfos.getEnterpriseTypeCN());
			}
			if (list.size() == 1) {
				list.get(0).setEnterpriseTypeEN(Translator.translateOnly(0, list.get(0).getEnterpriseTypeCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			} else {
				namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < list.size(); i++) {
					Frpositioninfos frpositioninfos = list.get(i);
					if (null == frpositioninfos.getEnterpriseTypeEN() || "".equals(frpositioninfos.getEnterpriseTypeEN())) {
						frpositioninfos.setEnterpriseTypeEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					list.set(i, frpositioninfos);
				}
			}
			//翻译
			namejson = new TranslatorJson();
			namejson.text = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Frpositioninfos frpositioninfos = list.get(i);
				namejson.text[i] = isNull(frpositioninfos.getRegCapitalCurrencyCN());
			}
			if (list.size() == 1) {
				list.get(0).setRegCapitalCurrencyEN(Translator.translateOnly(0, list.get(0).getRegCapitalCurrencyCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			} else {
				namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < list.size(); i++) {
					Frpositioninfos frpositioninfos = list.get(i);
					if (null == frpositioninfos.getRegCapitalCurrencyEN() || "".equals(frpositioninfos.getRegCapitalCurrencyEN())) {
						frpositioninfos.setRegCapitalCurrencyEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					list.set(i, frpositioninfos);
				}
			}
			//翻译
			namejson = new TranslatorJson();
			namejson.text = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Frpositioninfos frpositioninfos = list.get(i);
				namejson.text[i] = isNull(frpositioninfos.getFundedRatioCN());
			}
			if (list.size() == 1) {
				list.get(0).setFundedRatioEN(Translator.translateOnly(0, list.get(0).getFundedRatioCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			} else {
				namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < list.size(); i++) {
					Frpositioninfos frpositioninfos = list.get(i);
					if (null == frpositioninfos.getFundedRatioEN() || "".equals(frpositioninfos.getFundedRatioEN())) {
						frpositioninfos.setFundedRatioEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					list.set(i, frpositioninfos);
				}
			}

			//翻译
			namejson = new TranslatorJson();
			namejson.text = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				Frpositioninfos frpositioninfos = list.get(i);
				namejson.text[i] = isNull(frpositioninfos.getEnterpriseStatusCN());
			}
			if (list.size() == 1) {
				list.get(0).setFundedRatioEN(Translator.translateOnly(0, list.get(0).getEnterpriseStatusCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			} else {
				namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < list.size(); i++) {
					Frpositioninfos frpositioninfos = list.get(i);
					if (null == frpositioninfos.getEnterpriseStatusEN() || "".equals(frpositioninfos.getEnterpriseStatusEN())) {
						frpositioninfos.setEnterpriseStatusEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					list.set(i, frpositioninfos);
				}
			}


		}
		fullReport.setFrpositioninfosList(list);
		return fullReport;
	}

}
