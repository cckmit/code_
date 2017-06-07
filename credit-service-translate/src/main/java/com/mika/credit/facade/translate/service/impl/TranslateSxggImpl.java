package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.Sxgg;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 失信被执行人
 * Created by credit on 2017/3/30.
 */
public class TranslateSxggImpl {
    public FullReport getEnterpriseSxgg(FullReport fullReport) throws Exception {
        List<Sxgg> sxggList = fullReport.getSxggList();//失信被执行人
        //被执行人名称
        TranslatorJson json = new TranslatorJson();
        json.text = new String[sxggList.size()];
        for (int i = 0; i < sxggList.size(); i++) {
            Sxgg sxgg = sxggList.get(i);
            json.text[i] = isNull(sxgg.getEnforceeNameCN());
        }
        if (sxggList.size() == 1) {
            sxggList.get(0).setEnforceeNameEN(Tool.isStringNullPicc(Translator.translateOnly(1, sxggList.get(0).getEnforceeNameCN())));
        } else {
            json = Translator.translateMany(1, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < sxggList.size(); i++) {
                Sxgg sxgg = sxggList.get(i);
                if (null == sxgg.getEnforceeNameEN() || "".equals(sxgg.getEnforceeNameEN())) {
                    sxgg.setEnforceeNameEN(Tool.isStringNullPicc(json.dest[i]));
                }
                sxggList.set(i, sxgg);
            }
        }

        //执行法院名称
        json = new TranslatorJson();
        json.text = new String[sxggList.size()];
        for (int i = 0; i < sxggList.size(); i++) {
            Sxgg sxgg = sxggList.get(i);
            json.text[i] = isNull(sxgg.getEntCourtNameCN());
        }
        if (sxggList.size() == 1) {
            sxggList.get(0).setEntCourtNameEN(Tool.isStringNullPicc(Translator.translateOnly(0, sxggList.get(0).getEntCourtNameCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < sxggList.size(); i++) {
                Sxgg sxgg = sxggList.get(i);
                if (null == sxgg.getEntCourtNameEN() || "".equals(sxgg.getEntCourtNameEN())) {
                    sxgg.setEntCourtNameEN(Tool.isStringNullPicc(json.dest[i]));
                }
                sxggList.set(i, sxgg);
            }
        }

        //执行依据文号
        json = new TranslatorJson();
        json.text = new String[sxggList.size()];
        for (int i = 0; i < sxggList.size(); i++) {
            Sxgg sxgg = sxggList.get(i);
            json.text[i] = isNull(sxgg.getEnforcementBasisNumberCN());
        }
        if (sxggList.size() == 1) {
            sxggList.get(0).setEnforcementBasisNumberEN(Tool.isStringNullPicc(Translator.translateOnly(0, sxggList.get(0).getEnforcementBasisNumberCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < sxggList.size(); i++) {
                Sxgg sxgg = sxggList.get(i);
                if (null == sxgg.getEnforcementBasisNumberEN() || "".equals(sxgg.getEnforcementBasisNumberEN())) {
                    sxgg.setEnforcementBasisNumberEN(Tool.isStringNullPicc(json.dest[i]));
                }
                sxggList.set(i, sxgg);
            }
        }

        //案号
        json = new TranslatorJson();
        json.text = new String[sxggList.size()];
        for (int i = 0; i < sxggList.size(); i++) {
            Sxgg sxgg = sxggList.get(i);
            json.text[i] = isNull(sxgg.getDocketNoCN());
        }
        if (sxggList.size() == 1) {
            sxggList.get(0).setDocketNoEN(Tool.isStringNullPicc(Translator.translateOnly(0, sxggList.get(0).getDocketNoCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < sxggList.size(); i++) {
                Sxgg sxgg = sxggList.get(i);
                if (null == sxgg.getDocketNoEN() || "".equals(sxgg.getDocketNoEN())) {
                    sxgg.setDocketNoEN(Tool.isStringNullPicc(json.dest[i]));
                }
                sxggList.set(i, sxgg);
            }
        }

        //做出依据单位
        json = new TranslatorJson();
        json.text = new String[sxggList.size()];
        for (int i = 0; i < sxggList.size(); i++) {
            Sxgg sxgg = sxggList.get(i);
            json.text[i] = isNull(sxgg.getBasisUnitCN());
        }
        if (sxggList.size() == 1) {
            sxggList.get(0).setBasisUnitEN(Tool.isStringNullPicc(Translator.translateOnly(0, sxggList.get(0).getBasisUnitCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < sxggList.size(); i++) {
                Sxgg sxgg = sxggList.get(i);
                if (null == sxgg.getBasisUnitEN() || "".equals(sxgg.getBasisUnitEN())) {
                    sxgg.setBasisUnitEN(Tool.isStringNullPicc(json.dest[i]));
                }
                sxggList.set(i, sxgg);
            }
        }

        //生效法律文书确定的义务
        json = new TranslatorJson();
        json.text = new String[sxggList.size()];
        for (int i = 0; i < sxggList.size(); i++) {
            Sxgg sxgg = sxggList.get(i);
            json.text[i] = isNull(sxgg.getEffectiveObligationCN());
        }
        if (sxggList.size() == 1) {
            sxggList.get(0).setEffectiveObligationEN(Tool.isStringNullPicc(Translator.translateOnly(0, sxggList.get(0).getEffectiveObligationCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < sxggList.size(); i++) {
                Sxgg sxgg = sxggList.get(i);
                if (null == sxgg.getEffectiveObligationEN() || "".equals(sxgg.getEffectiveObligationEN())) {
                    sxgg.setEffectiveObligationEN(Tool.isStringNullPicc(json.dest[i]));
                }
                sxggList.set(i, sxgg);
            }
        }

        //被执行人的履行情况
        json = new TranslatorJson();
        json.text = new String[sxggList.size()];
        for (int i = 0; i < sxggList.size(); i++) {
            Sxgg sxgg = sxggList.get(i);
            json.text[i] = isNull(sxgg.getEnforceePerformCN());
        }
        if (sxggList.size() == 1) {
            sxggList.get(0).setEnforceePerformEN(Tool.isStringNullPicc(Translator.translateOnly(0, sxggList.get(0).getEnforceePerformCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < sxggList.size(); i++) {
                Sxgg sxgg = sxggList.get(i);
                if (null == sxgg.getEnforceePerformEN() || "".equals(sxgg.getEnforceePerformEN())) {
                    sxgg.setEnforceePerformEN(Tool.isStringNullPicc(json.dest[i]));
                }
                sxggList.set(i, sxgg);
            }
        }

        //失信被执行人行为具体情形
        json = new TranslatorJson();
        json.text = new String[sxggList.size()];
        for (int i = 0; i < sxggList.size(); i++) {
            Sxgg sxgg = sxggList.get(i);
            json.text[i] = isNull(sxgg.getSpecificCircumstanceCN());
        }
        if (sxggList.size() == 1) {
            sxggList.get(0).setSpecificCircumstanceEN(Tool.isStringNullPicc(Translator.translateOnly(0, sxggList.get(0).getSpecificCircumstanceCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < sxggList.size(); i++) {
                Sxgg sxgg = sxggList.get(i);
                if (null == sxgg.getSpecificCircumstanceEN() || "".equals(sxgg.getSpecificCircumstanceEN())) {
                    sxgg.setSpecificCircumstanceEN(Tool.isStringNullPicc(json.dest[i]));
                }
                sxggList.set(i, sxgg);
            }
        }

        fullReport.setSxggList(sxggList);
        return fullReport;
    }
}
