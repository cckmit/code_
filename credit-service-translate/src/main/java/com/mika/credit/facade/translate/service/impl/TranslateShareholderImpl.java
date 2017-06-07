package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.ShareholderInfos;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 股东信息翻译
 * Created by Zhu Jun on 2017/3/29.
 */
public class TranslateShareholderImpl {

    public FullReport getEnterpriseShareholderInfos(FullReport fullReport) throws Exception {
        List<ShareholderInfos> list = fullReport.getShareholderInfosList();//股东信息

        //翻译名称
            TranslatorJson Tranjson = new TranslatorJson();
            Tranjson.text = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ShareholderInfos share = list.get(i);
                Tranjson.text[i] = isNull(share.getNameCN());
            }
            if (list.size() == 1) {
                list.get(0).setNameEN(Tool.isStringNullPicc(Translator.translateOnly(3, list.get(0).getNameCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            } else {
                Tranjson = Translator.translateMany(1, Tranjson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
                for (int i = 0; i < list.size(); i++) {
                    ShareholderInfos share = list.get(i);
                    if (null == share.getNameEN() || "".equals(share.getNameEN())) {
                        share.setNameEN(Tool.isStringNullPicc(Tranjson.dest[i]));
                    }
                    list.set(i, share);
                }
            }

            //翻译备注
            Tranjson = new TranslatorJson();
            Tranjson.text = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ShareholderInfos share = list.get(i);
                Tranjson.text[i] = isNull(share.getNoteCN());
            }
            if (list.size() == 1) {
                list.get(0).setNoteEN(Tool.isStringNullPicc(Translator.translateOnly(0, list.get(0).getNoteCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            } else {
                Tranjson = Translator.translateMany(0, Tranjson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
                for (int i = 0; i < list.size(); i++) {
                    ShareholderInfos share = list.get(i);
                    if (null == share.getNoteEN() || "".equals(share.getNoteEN())) {
                        share.setNoteEN(Tool.isStringNullPicc(Tranjson.dest[i]));
                    }
                    list.set(i, share);
                }
            }

            //翻译地址
            Tranjson = new TranslatorJson();
            Tranjson.text = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ShareholderInfos share = list.get(i);
                Tranjson.text[i] = isNull(share.getAddressCN());
            }
            if (list.size() == 1) {
                list.get(0).setAddressEN(Tool.isStringNullPicc(Translator.translateOnly(2, list.get(0).getAddressCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            } else {
                Tranjson = Translator.translateMany(2, Tranjson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
                for (int i = 0; i < list.size(); i++) {
                    ShareholderInfos share = list.get(i);
                    if (null == share.getAddressEN() || "".equals(share.getAddressEN())) {
                        share.setAddressEN(Tool.isStringNullPicc(Tranjson.dest[i]));
                    }
                    list.set(i, share);
                }
            }

            //翻译经营范围
        Tranjson = new TranslatorJson();
        Tranjson.text = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ShareholderInfos share = list.get(i);
            Tranjson.text[i] = isNull(share.getBusinessScopeCN());
        }
        if (list.size() == 1) {
            list.get(0).setBusinessScopeEN(Tool.isStringNullPicc(Translator.translateOnly(0, list.get(0).getBusinessScopeCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
        } else {
            Tranjson = Translator.translateMany(0, Tranjson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < list.size(); i++) {
                ShareholderInfos share = list.get(i);
                if (null == share.getBusinessScopeEN() || "".equals(share.getBusinessScopeEN())) {
                    share.setBusinessScopeEN(Tool.isStringNullPicc(Tranjson.dest[i]));
                }
                list.set(i, share);
            }
        }

        //翻译经营范围
        Tranjson = new TranslatorJson();
        Tranjson.text = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ShareholderInfos share = list.get(i);
            Tranjson.text[i] = isNull(share.getCurrency());
        }
        if (list.size() == 1) {
            list.get(0).setCurrencyEN(Tool.isStringNullPicc(Translator.translateOnly(0, list.get(0).getCurrency())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
        } else {
            Tranjson = Translator.translateMany(0, Tranjson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < list.size(); i++) {
                ShareholderInfos share = list.get(i);
                if (null == share.getCurrencyEN() || "".equals(share.getCurrencyEN())) {
                    share.setCurrencyEN(Tool.isStringNullPicc(Tranjson.dest[i]));
                }
                list.set(i, share);
            }
        }
        fullReport.setShareholderInfosList(list);
        return fullReport;
    }

}
