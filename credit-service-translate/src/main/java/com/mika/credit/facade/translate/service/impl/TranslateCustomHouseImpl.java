package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.CustomHouse;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 海关信息翻译
 * Created by Zhu Jun on 2017/3/29.
 */
public class TranslateCustomHouseImpl {
    public FullReport getEnterpriseCustomHouse(FullReport fullReport) throws Exception {
        TranslatorJson json = new TranslatorJson();
        json.text = new String[fullReport.getCustomHouseList().size()];
        for (int i = 0; i < fullReport.getCustomHouseList().size(); i++) {
            CustomHouse customHouse = fullReport.getCustomHouseList().get(i);
            json.text[i] = isNull(customHouse.getCid());//报关类型
        }
        if (fullReport.getCustomHouseList().size() == 1) {
            fullReport.getCustomHouseList().get(0).setCidEN(Tool.isStringNullPicc(Translator.translateOnly(0, fullReport.getCustomHouseList().get(0).getCid())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < fullReport.getCustomHouseList().size(); i++) {
                CustomHouse customHouse = fullReport.getCustomHouseList().get(i);
                if (customHouse.getCidEN() == null || "".equals(customHouse.getCidEN())) {
                    customHouse.setCidEN(Tool.isStringNullPicc(json.dest[i]));
                }
                fullReport.getCustomHouseList().set(i, customHouse);
            }
        }

        json = new TranslatorJson();
        json.text = new String[fullReport.getCustomHouseList().size()];
        for (int i = 0; i < fullReport.getCustomHouseList().size(); i++) {
            CustomHouse customHouse = fullReport.getCustomHouseList().get(i);
            json.text[i] = isNull(customHouse.getNoteCN());//备注
        }
        if (fullReport.getCustomHouseList().size() == 1) {
            fullReport.getCustomHouseList().get(0).setNoteEN(Tool.isStringNullPicc(Translator.translateOnly(0, fullReport.getCustomHouseList().get(0).getNoteCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < fullReport.getCustomHouseList().size(); i++) {
                CustomHouse customHouse = fullReport.getCustomHouseList().get(i);
                if (customHouse.getNoteEN() == null || "".equals(customHouse.getNoteEN())) {
                    customHouse.setNoteEN(Tool.isStringNullPicc(json.dest[i]));
                }
                fullReport.getCustomHouseList().set(i, customHouse);
            }
        }

        json = new TranslatorJson();
        json.text = new String[fullReport.getCustomHouseList().size()];
        for (int i = 0; i < fullReport.getCustomHouseList().size(); i++) {
            CustomHouse customHouse = fullReport.getCustomHouseList().get(i);
            json.text[i] = isNull(customHouse.getManagementCategoriesCN());//管理类别
        }
        if (fullReport.getCustomHouseList().size() == 1) {
            fullReport.getCustomHouseList().get(0).setManagementCategoriesEN(Tool.isStringNullPicc(Translator.translateOnly(0, fullReport.getCustomHouseList().get(0).getManagementCategoriesCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < fullReport.getCustomHouseList().size(); i++) {
                CustomHouse customHouse = fullReport.getCustomHouseList().get(i);
                if (customHouse.getManagementCategoriesEN() == null || "".equals(customHouse.getManagementCategoriesEN())) {
                    customHouse.setManagementCategoriesEN(Tool.isStringNullPicc(json.dest[i]));
                }
                fullReport.getCustomHouseList().set(i, customHouse);
            }
        }

        json = new TranslatorJson();
        json.text = new String[fullReport.getCustomHouseList().size()];
        for (int i = 0; i < fullReport.getCustomHouseList().size(); i++) {
            CustomHouse customHouse = fullReport.getCustomHouseList().get(i);
            json.text[i] = isNull(customHouse.getCustomsCollectionsCN());//报关类型
        }
        if (fullReport.getCustomHouseList().size() == 1) {
            fullReport.getCustomHouseList().get(0).setCustomsCollectionsEN(Tool.isStringNullPicc(Translator.translateOnly(0, fullReport.getCustomHouseList().get(0).getCustomsCollectionsCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < fullReport.getCustomHouseList().size(); i++) {
                CustomHouse customHouse = fullReport.getCustomHouseList().get(i);
                if (customHouse.getCustomsCollectionsEN() == null || "".equals(customHouse.getCustomsCollectionsEN())) {
                    customHouse.setCustomsCollectionsEN(Tool.isStringNullPicc(json.dest[i]));
                }
                fullReport.getCustomHouseList().set(i, customHouse);
            }
        }
        return fullReport;
    }
}
