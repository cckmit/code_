package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.BankInfos;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.ShareholdersChain;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 股东链翻译
 */
public class TranslateShareholdersChainImpl {
	/**
	 * 股东链翻译
	 * @param fullReport
	 * @return
	 * @throws Exception
	 */
	public FullReport getEnterpriseShareholdersChain(FullReport fullReport) throws Exception {
        List<ShareholdersChain> shareholdersChainList = fullReport.getShareholdersChainList();
			TranslatorJson namejson = new TranslatorJson();
			namejson.text = new String[shareholdersChainList.size()];
			for (int i = 0; i < shareholdersChainList.size(); i++) {
				ShareholdersChain shareholdersChain = shareholdersChainList.get(i);
				namejson.text[i] =  isNull(shareholdersChain.getShareholdingNameCN());//持股公司
			}
			if(shareholdersChainList.size()==1){
				shareholdersChainList.get(0).setShareholdingNameEN(Translator.translateOnly(1, shareholdersChainList.get(0).getShareholdingNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			}else{
				namejson = Translator.translateMany(1, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < shareholdersChainList.size(); i++) {
					ShareholdersChain shareholdersChain = shareholdersChainList.get(i);
					if(null==shareholdersChain.getShareholdingNameEN()||"".equals(shareholdersChain.getShareholdingNameEN())){
						shareholdersChain.setShareholdingNameEN(Tool.isStringNullPicc(namejson.dest[i]));
					}
					shareholdersChainList.set(i, shareholdersChain);
				}
			}

			namejson = new TranslatorJson();
			namejson.text = new String[shareholdersChainList.size()];
			for (int i = 0; i < shareholdersChainList.size(); i++) {
				ShareholdersChain shareholdersChain = shareholdersChainList.get(i);
				namejson.text[i] =  isNull(shareholdersChain.getBeShareholdingNameCN());//被持股公司
			}
			if(shareholdersChainList.size()==1){
				shareholdersChainList.get(0).setBeShareholdingNameEN(Translator.translateOnly(1, shareholdersChainList.get(0).getBeShareholdingNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			}else{
				namejson = Translator.translateMany(1, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
				for (int i = 0; i < shareholdersChainList.size(); i++) {
					ShareholdersChain shareholdersChain = shareholdersChainList.get(i);
					if(null==shareholdersChain.getBeShareholdingNameEN()||"".equals(shareholdersChain.getBeShareholdingNameEN())){
						shareholdersChain.setBeShareholdingNameEN(Tool.isStringNullPicc(namejson.dest[i]));}
					shareholdersChainList.set(i, shareholdersChain);
				}
			}
		fullReport.setShareholdersChainList(shareholdersChainList);
		return fullReport;
	}

}
