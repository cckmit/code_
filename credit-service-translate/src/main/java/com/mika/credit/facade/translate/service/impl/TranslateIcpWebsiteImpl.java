package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.Brands;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.IcpWebsite;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

public class TranslateIcpWebsiteImpl {
	/**
	 * 网站
	 * @param fullReport
	 * @return
	 * @throws Exception
	 */
	public FullReport getEnterpriseIcpWebsite(FullReport fullReport) throws Exception{
		List<IcpWebsite> list=fullReport.getIcpWebsiteList();
		TranslatorJson namejson = new TranslatorJson();
		namejson.text = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			IcpWebsite icpWebsite = list.get(i);
			namejson.text[i] = isNull(icpWebsite.getLicenseKey());
		}
		if(list.size()==1){
			list.get(0).setLicenseKeyEN(Translator.translateOnly(0, list.get(0).getLicenseKey()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
		}else{
			namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
			for (int i = 0; i < list.size(); i++) {
				IcpWebsite icpWebsite = list.get(i);
				if(null==icpWebsite.getLicenseKeyEN()||"".equals(icpWebsite.getLicenseKeyEN())){
					icpWebsite.setLicenseKeyEN(Tool.isStringNullPicc(namejson.dest[i]));
				}
				list.set(i, icpWebsite);
			}
		}
		fullReport.setIcpWebsiteList(list);
		return fullReport;
	}

}
