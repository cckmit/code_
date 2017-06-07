package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.Ktgg;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 开庭公告翻译
 * Created by Zhu Jun on 2017/3/29.
 */
public class TranslateKtggImpl {
    public FullReport getEnterpriseKtgg(FullReport fullReport) throws Exception {
        List<Ktgg> ktgglist = fullReport.getKtggList();//开庭公告
        //翻译原告
        TranslatorJson json = new TranslatorJson();
        json.text = new String[ktgglist.size()];
        for (int i = 0; i < ktgglist.size(); i++) {
            Ktgg ktgg = ktgglist.get(i);
            json.text[i] = isNull(ktgg.getPlaintiffCN());
        }
        if (ktgglist.size() == 1) {
            ktgglist.get(0).setPlaintiffEN(Tool.isStringNullPicc(Translator.translateOnly(0, ktgglist.get(0).getPlaintiffCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < ktgglist.size(); i++) {
                Ktgg ktgg = ktgglist.get(i);
                if (null == ktgg.getPlaintiffEN() || "".equals(ktgg.getPlaintiffEN())) {
                    ktgg.setPlaintiffEN(Tool.isStringNullPicc(json.dest[i]));
                }
                ktgglist.set(i, ktgg);
            }
        }

        //翻译法庭名称
        json = new TranslatorJson();
        json.text = new String[ktgglist.size()];
        for (int i = 0; i < ktgglist.size(); i++) {
            Ktgg ktgg = ktgglist.get(i);
            json.text[i] = isNull(ktgg.getCourtroomCN());
        }
        if (ktgglist.size() == 1) {
            ktgglist.get(0).setCourtroomEN(Tool.isStringNullPicc(Translator.translateOnly(0, ktgglist.get(0).getCourtroomCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < ktgglist.size(); i++) {
                Ktgg ktgg = ktgglist.get(i);
                if (null == ktgg.getCourtroomEN() || "".equals(ktgg.getCourtroomEN())) {
                    ktgg.setCourtroomEN(Tool.isStringNullPicc(json.dest[i]));
                }
                ktgglist.set(i, ktgg);
            }
        }


        //翻译法院名称
        json = new TranslatorJson();
        json.text = new String[ktgglist.size()];
        for (int i = 0; i < ktgglist.size(); i++) {
            Ktgg ktgg = ktgglist.get(i);
            json.text[i] = isNull(ktgg.getCourthouseCN());
        }
        if (ktgglist.size() == 1) {
            ktgglist.get(0).setCourthouseEN(Tool.isStringNullPicc(Translator.translateOnly(0, ktgglist.get(0).getCourthouseCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < ktgglist.size(); i++) {
                Ktgg ktgg = ktgglist.get(i);
                if (null == ktgg.getCourthouseEN() || "".equals(ktgg.getCourthouseEN())) {
                    ktgg.setCourthouseEN(Tool.isStringNullPicc(json.dest[i]));
                }
                ktgglist.set(i, ktgg);
            }
        }

        //翻译案由
        json = new TranslatorJson();
        json.text = new String[ktgglist.size()];
        for (int i = 0; i < ktgglist.size(); i++) {
            Ktgg ktgg = ktgglist.get(i);
            json.text[i] = isNull(ktgg.getCaseCauseCN());
        }
        if (ktgglist.size() == 1) {
            ktgglist.get(0).setCaseCauseEN(Tool.isStringNullPicc(Translator.translateOnly(0, ktgglist.get(0).getCaseCauseCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < ktgglist.size(); i++) {
                Ktgg ktgg = ktgglist.get(i);
                if (null == ktgg.getCaseCauseEN() || "".equals(ktgg.getCaseCauseEN())) {
                    ktgg.setCaseCauseEN(Tool.isStringNullPicc(json.dest[i]));
                }
                ktgglist.set(i, ktgg);
            }
        }

        //翻译法官
        json = new TranslatorJson();
        json.text = new String[ktgglist.size()];
        for (int i = 0; i < ktgglist.size(); i++) {
            Ktgg ktgg = ktgglist.get(i);
            json.text[i] = isNull(ktgg.getChiefJusticeCN());
        }
        if (ktgglist.size() == 1) {
            ktgglist.get(0).setChiefJusticeEN(Tool.isStringNullPicc(Translator.translateOnly(3, ktgglist.get(0).getChiefJusticeCN())));
        } else {
            json = Translator.translateMany(3, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < ktgglist.size(); i++) {
                Ktgg ktgg = ktgglist.get(i);
                if (null == ktgg.getChiefJusticeEN() || "".equals(ktgg.getChiefJusticeEN())) {
                    ktgg.setChiefJusticeEN(Tool.isStringNullPicc(json.dest[i]));
                }
                ktgglist.set(i, ktgg);
            }
        }

        //翻译案号
        json = new TranslatorJson();
        json.text = new String[ktgglist.size()];
        for (int i = 0; i < ktgglist.size(); i++) {
            Ktgg ktgg = ktgglist.get(i);
            json.text[i] = isNull(ktgg.getDocketNoCN());
        }
        if (ktgglist.size() == 1) {
            ktgglist.get(0).setDocketNoEN(Tool.isStringNullPicc(Translator.translateOnly(0, ktgglist.get(0).getDocketNoCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < ktgglist.size(); i++) {
                Ktgg ktgg = ktgglist.get(i);
                if (null == ktgg.getDocketNoEN() || "".equals(ktgg.getDocketNoEN())) {
                    ktgg.setDocketNoEN(Tool.isStringNullPicc(json.dest[i]));
                }
                ktgglist.set(i, ktgg);
            }
        }

        //翻译被告
        json = new TranslatorJson();
        json.text = new String[ktgglist.size()];
        for (int i = 0; i < ktgglist.size(); i++) {
            Ktgg ktgg = ktgglist.get(i);
            json.text[i] = isNull(ktgg.getDefendantCN());
        }
        if (ktgglist.size() == 1) {
            ktgglist.get(0).setDefendantEN(Tool.isStringNullPicc(Translator.translateOnly(0, ktgglist.get(0).getDefendantCN())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < ktgglist.size(); i++) {
                Ktgg ktgg = ktgglist.get(i);
                if (null == ktgg.getDefendantEN() || "".equals(ktgg.getDefendantEN())) {
                    ktgg.setDefendantEN(Tool.isStringNullPicc(json.dest[i]));
                }
                ktgglist.set(i, ktgg);
            }
        }


        //内容
        json = new TranslatorJson();
        json.text = new String[ktgglist.size()];
        for (int i = 0; i < ktgglist.size(); i++) {
            Ktgg ktgg = ktgglist.get(i);
            json.text[i] = isNull(ktgg.getBody());
        }
        if (ktgglist.size() == 1) {
            ktgglist.get(0).setBodyEN(Tool.isStringNullPicc(Translator.translateOnly(0, ktgglist.get(0).getBody())));
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < ktgglist.size(); i++) {
                Ktgg ktgg = ktgglist.get(i);
                if (null == ktgg.getBodyEN() || "".equals(ktgg.getBodyEN())) {
                    ktgg.setBodyEN(Tool.isStringNullPicc(json.dest[i]));
                }
                ktgglist.set(i, ktgg);
            }
        }

        fullReport.setKtggList(ktgglist);
        return fullReport;
    }
}
