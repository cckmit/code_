package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.*;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 翻译执行公告
 * Created by Zhu Jun on 2017/3/29.
 */
public class TranslateExecutiveImpl {

    public FullReport getEnterpriseExecutive(FullReport fullReport) throws Exception {
        List<Executive> executiveList = fullReport.getExecutiveList();//执行公告
        //翻译企业（机构）名称
            TranslatorJson json = new TranslatorJson();
            json.text = new String[executiveList.size()];
            for (int i = 0; i < executiveList.size(); i++) {
                Executive executive = executiveList.get(i);
                json.text[i] = isNull(executive.getEntNameCN());
            }
            if (executiveList.size() == 1) {
                executiveList.get(0).setEntNameEN(Tool.isStringNullPicc(Translator.translateOnly(1, executiveList.get(0).getEntNameCN())));
            } else {
                json = Translator.translateMany(1, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
                for (int i = 0; i < executiveList.size(); i++) {
                    Executive executive = executiveList.get(i);
                    if (null == executive.getEntNameEN() || "".equals(executive.getEntNameEN())) {
                        executive.setEntNameEN(Tool.isStringNullPicc(json.dest[i]));
                    }
                    executiveList.set(i, executive);
                }
            }

            //翻译被执行人姓名
            json = new TranslatorJson();
            json.text = new String[executiveList.size()];
            for (int i = 0; i < executiveList.size(); i++) {
                Executive executive = executiveList.get(i);
                json.text[i] = isNull(executive.getEnforceNameCN());
            }
            if (executiveList.size() == 1) {
                executiveList.get(0).setEnforceNameEN(Tool.isStringNullPicc(Translator.translateOnly(0, executiveList.get(0).getEnforceNameCN())));
            } else {
                json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
                for (int i = 0; i < executiveList.size(); i++) {
                    Executive executive = executiveList.get(i);
                    if (null == executive.getEnforceNameEN() || "".equals(executive.getEnforceNameEN())) {
                        executive.setEnforceNameEN(Tool.isStringNullPicc(json.dest[i]));
                    }
                    executiveList.set(i, executive);
                }
            }

            //翻译执行法院名称
            json = new TranslatorJson();
            json.text = new String[executiveList.size()];
            for (int i = 0; i < executiveList.size(); i++) {
                Executive executive = executiveList.get(i);
                json.text[i] = isNull(executive.getEnterpriseCourtNameCN());
            }
            if (executiveList.size() == 1) {
                executiveList.get(0).setEnterpriseCourtNameEN(Tool.isStringNullPicc(Translator.translateOnly(0, executiveList.get(0).getEnterpriseCourtNameCN())));
            } else {
                json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
                for (int i = 0; i < executiveList.size(); i++) {
                    Executive executive = executiveList.get(i);
                    if (null == executive.getEnterpriseCourtNameEN() || "".equals(executive.getEnterpriseCourtNameEN())) {
                        executive.setEnterpriseCourtNameEN(Tool.isStringNullPicc(json.dest[i]));
                    }
                    executiveList.set(i, executive);
                }
            }

            //翻译案号
            json = new TranslatorJson();
            json.text = new String[executiveList.size()];
            for (int i = 0; i < executiveList.size(); i++) {
                Executive executive = executiveList.get(i);
                json.text[i] = isNull(executive.getDocketNoCN());
            }
            if (executiveList.size() == 1) {
                executiveList.get(0).setDocketNoEN(Tool.isStringNullPicc(Translator.translateOnly(0, executiveList.get(0).getDocketNoCN())));
            } else {
                json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
                for (int i = 0; i < executiveList.size(); i++) {
                    Executive executive = executiveList.get(i);
                    if (null == executive.getDocketNoEN() || "".equals(executive.getDocketNoEN())) {
                        executive.setDocketNoEN(Tool.isStringNullPicc(json.dest[i]));
                    }
                    executiveList.set(i, executive);
                }
            }

            //翻译案件状态
            json = new TranslatorJson();
            json.text = new String[executiveList.size()];
            for (int i = 0; i < executiveList.size(); i++) {
                Executive executive = executiveList.get(i);
                json.text[i] = isNull(executive.getCaseStatusCN());
            }
            if (executiveList.size() == 1) {
                executiveList.get(0).setCaseStatusEN(Tool.isStringNullPicc(Translator.translateOnly(0, executiveList.get(0).getCaseStatusCN())));
            } else {
                json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
                for (int i = 0; i < executiveList.size(); i++) {
                    Executive executive = executiveList.get(i);
                    if (null == executive.getCaseStatusEN() || "".equals(executive.getCaseStatusEN())) {
                        executive.setCaseStatusEN(Tool.isStringNullPicc(json.dest[i]));
                    }
                    executiveList.set(i, executive);
                }
            }

        //翻译案件状态
        json = new TranslatorJson();
        json.text = new String[executiveList.size()];
        for (int i = 0; i < executiveList.size(); i++) {
            Executive executive = executiveList.get(i);
            json.text[i] = isNull(executive.getBody());
        }
        if (executiveList.size() == 1) {
            executiveList.get(0).setBodyEN(Tool.isStringNullPicc(Translator.translateOnly(0, executiveList.get(0).getBody())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < executiveList.size(); i++) {
                Executive executive = executiveList.get(i);
                if (null == executive.getBodyEN() || "".equals(executive.getBodyEN())) {
                    executive.setBodyEN(Tool.isStringNullPicc(json.dest[i]));
                }
                executiveList.set(i, executive);
            }
        }

            fullReport.setExecutiveList(executiveList);
            return fullReport;


    }
}