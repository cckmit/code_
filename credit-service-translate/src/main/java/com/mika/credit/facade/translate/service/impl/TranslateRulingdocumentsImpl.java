package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.Rulingdocuments;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 裁判文书翻译
 * Created by Zhu Jun on 2017/3/29.
 */
public class TranslateRulingdocumentsImpl {

    public FullReport getEnterpriseRulingdocuments(FullReport fullReport) throws Exception {
        List<Rulingdocuments> rulingdocumentsList = fullReport.getRulingdocumentsList();//裁判文书
        //翻译文书标题
        TranslatorJson json = new TranslatorJson();
        json.text = new String[rulingdocumentsList.size()];
        for (int i = 0; i < rulingdocumentsList.size(); i++) {
            Rulingdocuments ruling = rulingdocumentsList.get(i);
            json.text[i] = isNull(ruling.getTitleCN());
        }
        if (rulingdocumentsList.size() == 1) {
            rulingdocumentsList.get(0).setTitleEN(Tool.isStringNullPicc(Translator.translateOnly(0, rulingdocumentsList.get(0).getTitleCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < rulingdocumentsList.size(); i++) {
                Rulingdocuments ruling = rulingdocumentsList.get(i);
                if (null == ruling.getTitleEN() || "".equals(ruling.getTitleEN())) {
                    ruling.setTitleEN(Tool.isStringNullPicc(json.dest[i]));
                }
                rulingdocumentsList.set(i, ruling);
            }
        }

        //翻译案号
        json = new TranslatorJson();
        json.text = new String[rulingdocumentsList.size()];
        for (int i = 0; i < rulingdocumentsList.size(); i++) {
            Rulingdocuments ruling = rulingdocumentsList.get(i);
            json.text[i] = isNull(ruling.getDocketNoCN());
        }
        if (rulingdocumentsList.size() == 1) {
            rulingdocumentsList.get(0).setDocketNoEN(Tool.isStringNullPicc(Translator.translateOnly(0, rulingdocumentsList.get(0).getDocketNoCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < rulingdocumentsList.size(); i++) {
                Rulingdocuments ruling = rulingdocumentsList.get(i);
                if (null == ruling.getDocketNoEN() || "".equals(ruling.getDocketNoEN())) {
                    ruling.setDocketNoEN(Tool.isStringNullPicc(json.dest[i]));
                }
                rulingdocumentsList.set(i, ruling);
            }
        }

        //翻译执行法院名称
        json = new TranslatorJson();
        json.text = new String[rulingdocumentsList.size()];
        for (int i = 0; i < rulingdocumentsList.size(); i++) {
            Rulingdocuments ruling = rulingdocumentsList.get(i);
            json.text[i] = isNull(ruling.getCourtNameCN());
        }
        if (rulingdocumentsList.size() == 1) {
            rulingdocumentsList.get(0).setCourtNameEN(Tool.isStringNullPicc(Translator.translateOnly(0, rulingdocumentsList.get(0).getCourtNameCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < rulingdocumentsList.size(); i++) {
                Rulingdocuments ruling = rulingdocumentsList.get(i);
                if (null == ruling.getCourtNameEN() || "".equals(ruling.getCourtNameEN())) {
                    ruling.setCourtNameEN(Tool.isStringNullPicc(json.dest[i]));
                }
                rulingdocumentsList.set(i, ruling);
            }
        }

        //翻译案件类型
        json = new TranslatorJson();
        json.text = new String[rulingdocumentsList.size()];
        for (int i = 0; i < rulingdocumentsList.size(); i++) {
            Rulingdocuments ruling = rulingdocumentsList.get(i);
            json.text[i] = isNull(ruling.getCaseTypeCN());
        }
        if (rulingdocumentsList.size() == 1) {
            rulingdocumentsList.get(0).setCaseTypeEN(Tool.isStringNullPicc(Translator.translateOnly(0, rulingdocumentsList.get(0).getCaseTypeCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < rulingdocumentsList.size(); i++) {
                Rulingdocuments ruling = rulingdocumentsList.get(i);
                if (null == ruling.getCaseTypeEN() || "".equals(ruling.getCaseTypeEN())) {
                    ruling.setCaseTypeEN(Tool.isStringNullPicc(json.dest[i]));
                }
                rulingdocumentsList.set(i, ruling);
            }
        }

        //翻译原告
        json = new TranslatorJson();
        json.text = new String[rulingdocumentsList.size()];
        for (int i = 0; i < rulingdocumentsList.size(); i++) {
            Rulingdocuments ruling = rulingdocumentsList.get(i);
            json.text[i] = isNull(ruling.getPlaintiffCN());
        }
        if (rulingdocumentsList.size() == 1) {
            rulingdocumentsList.get(0).setPlaintiffEN(Tool.isStringNullPicc(Translator.translateOnly(0, rulingdocumentsList.get(0).getPlaintiffCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < rulingdocumentsList.size(); i++) {
                Rulingdocuments ruling = rulingdocumentsList.get(i);
                if (null == ruling.getPlaintiffEN() || "".equals(ruling.getPlaintiffEN())) {
                    ruling.setPlaintiffEN(Tool.isStringNullPicc(json.dest[i]));
                }
                rulingdocumentsList.set(i, ruling);
            }
        }

        //翻译被告
        json = new TranslatorJson();
        json.text = new String[rulingdocumentsList.size()];
        for (int i = 0; i < rulingdocumentsList.size(); i++) {
            Rulingdocuments ruling = rulingdocumentsList.get(i);
            json.text[i] = isNull(ruling.getDefendantCN());
        }
        if (rulingdocumentsList.size() == 1) {
            rulingdocumentsList.get(0).setDefendantEN(Tool.isStringNullPicc(Translator.translateOnly(0, rulingdocumentsList.get(0).getDefendantCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < rulingdocumentsList.size(); i++) {
                Rulingdocuments ruling = rulingdocumentsList.get(i);
                if (null == ruling.getDefendantEN() || "".equals(ruling.getDefendantEN())) {
                    ruling.setDefendantEN(Tool.isStringNullPicc(json.dest[i]));
                }
                rulingdocumentsList.set(i, ruling);
            }
        }

        //翻译案件状态
        json = new TranslatorJson();
        json.text = new String[rulingdocumentsList.size()];
        for (int i = 0; i < rulingdocumentsList.size(); i++) {
            Rulingdocuments ruling = rulingdocumentsList.get(i);
            json.text[i] = isNull(ruling.getCaseStatusCN());
        }
        if (rulingdocumentsList.size() == 1) {
            rulingdocumentsList.get(0).setCaseStatusEN(Tool.isStringNullPicc(Translator.translateOnly(0, rulingdocumentsList.get(0).getCaseStatusCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < rulingdocumentsList.size(); i++) {
                Rulingdocuments ruling = rulingdocumentsList.get(i);
                if (null == ruling.getCaseStatusEN() || "".equals(ruling.getCaseStatusEN())) {
                    ruling.setCaseStatusEN(Tool.isStringNullPicc(json.dest[i]));
                }
                rulingdocumentsList.set(i, ruling);
            }
        }

        //翻译备注
        json = new TranslatorJson();
        json.text = new String[rulingdocumentsList.size()];
        for (int i = 0; i < rulingdocumentsList.size(); i++) {
            Rulingdocuments ruling = rulingdocumentsList.get(i);
            json.text[i] = isNull(ruling.getNoteCN());
        }
        if (rulingdocumentsList.size() == 1) {
            rulingdocumentsList.get(0).setNoteEN(Tool.isStringNullPicc(Translator.translateOnly(0, rulingdocumentsList.get(0).getNoteCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < rulingdocumentsList.size(); i++) {
                Rulingdocuments ruling = rulingdocumentsList.get(i);
                if (null == ruling.getNoteEN() || "".equals(ruling.getNoteEN())) {
                    ruling.setNoteEN(Tool.isStringNullPicc(json.dest[i]));
                }
                rulingdocumentsList.set(i, ruling);
            }
        }
        fullReport.setRulingdocumentsList(rulingdocumentsList);
        return fullReport;
    }
}
