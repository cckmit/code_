package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.TradeReferences;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 贸易参考翻译
 * Created by Zhu Jun on 2017/3/29.
 */
public class TranslateTradeReferencesImpl {


    public FullReport getEnterpriseTradeReferences(FullReport fullReport) throws Exception {
        List<TradeReferences> tradclist = fullReport.getTradeReferencesList();//贸易参考


        TranslatorJson namejson = new TranslatorJson();
        namejson.text = new String[tradclist.size()];
        for (int i = 0; i < tradclist.size(); i++) {
            TradeReferences trade = tradclist.get(i);
            namejson.text[i] = isNull(trade.getNameCN());
        }
        if (tradclist.size() == 1) {
            tradclist.get(0).setNameEN(Translator.translateOnly(1, tradclist.get(0).getNameCN()));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
        } else {
            namejson = Translator.translateMany(1, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < tradclist.size(); i++) {
                TradeReferences trade = tradclist.get(i);
                if (null == trade.getNameEN() || "".equals(trade.getNameEN())) {
                    trade.setNameEN(Tool.isStringNullPicc(namejson.dest[i]));
                }
                tradclist.set(i, trade);
            }
        }

        namejson = new TranslatorJson();
        namejson.text = new String[tradclist.size()];
        for (int i = 0; i < tradclist.size(); i++) {
            TradeReferences trade = tradclist.get(i);
            namejson.text[i] = isNull(trade.getNoteCN());
        }
        if (tradclist.size() == 1) {
            tradclist.get(0).setNoteEN(Tool.isStringNullPicc(Translator.translateOnly(0, tradclist.get(0).getNoteCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
        } else {
            namejson = Translator.translateMany(0, namejson.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < tradclist.size(); i++) {
                TradeReferences trade = tradclist.get(i);
                if (null == trade.getNoteEN() || "".equals(trade.getNoteEN())) {
                    trade.setNoteEN(Tool.isStringNullPicc(namejson.dest[i]));
                }
                tradclist.set(i, trade);
            }
        }
        fullReport.setTradeReferencesList(tradclist);
        return fullReport;
    }

}
