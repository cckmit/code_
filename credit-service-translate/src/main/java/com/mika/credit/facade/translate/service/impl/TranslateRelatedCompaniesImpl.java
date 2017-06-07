package com.mika.credit.facade.translate.service.impl;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.entity.report.cn.RelatedCompanies;
import com.mika.credit.facade.translate.model.TranslatorJson;
import com.mika.credit.facade.translate.util.Tool;
import com.mika.credit.facade.translate.util.Translator;

import java.util.List;

import static com.mika.credit.facade.translate.util.Tool.isNull;

/**
 * 关联公司信息翻译
 * Created by Zhu Jun on 2017/3/29.
 */
public class TranslateRelatedCompaniesImpl {

//	List<RelationCompany> list=new ArrayList<RelationCompany>();


    public FullReport getEnterpriseRelatedCompanies(FullReport fullReport) throws Exception {

        List<RelatedCompanies> list = fullReport.getRelatedCompaniesList();//关联公司信息
        //翻译名称
            TranslatorJson json = new TranslatorJson();
            json.text = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                RelatedCompanies relate = list.get(i);
                json.text[i] = isNull(relate.getNameCN());
            }
            if (list.size() == 1) {
                list.get(0).setNameEN(Tool.isStringNullPicc(Translator.translateOnly(1, list.get(0).getNameCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            } else {
                json = Translator.translateMany(1, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
                for (int i = 0; i < list.size(); i++) {
                    RelatedCompanies relate = list.get(i);
                    if (null == relate.getNameEN() || "".equals(relate.getNameEN())) {
                        relate.setNameEN(Tool.isStringNullPicc(json.dest[i]));
                    }
                    list.set(i, relate);
                }
            }

            //翻译地址
            json = new TranslatorJson();
            json.text = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                RelatedCompanies relate = list.get(i);
                json.text[i] = isNull(relate.getAddressCN());
            }
            if (list.size() == 1) {
                list.get(0).setAddressEN(Tool.isStringNullPicc(Translator.translateOnly(2, list.get(0).getAddressCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            } else {
                json = Translator.translateMany(2, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
                for (int i = 0; i < list.size(); i++) {
                    RelatedCompanies relate = list.get(i);
                    if (null == relate.getAddressEN() || "".equals(relate.getAddressEN())) {
                        relate.setAddressEN(Tool.isStringNullPicc(json.dest[i]));
                    }
                    list.set(i, relate);
                }
            }

            //翻译备注
            json = new TranslatorJson();
            json.text = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                RelatedCompanies relate = list.get(i);
                json.text[i] = isNull(relate.getNoteCN());
            }
            if (list.size() == 1) {
                list.get(0).setNoteEN(Tool.isStringNullPicc(Translator.translateOnly(0, list.get(0).getNoteCN())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            } else {
                json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
                for (int i = 0; i < list.size(); i++) {
                    RelatedCompanies relate = list.get(i);
                    if (null == relate.getNoteEN() || "".equals(relate.getNoteEN())) {
                        relate.setNoteEN(Tool.isStringNullPicc(json.dest[i]));
                    }
                    list.set(i, relate);
                }
            }

        //翻译公司性质
        json = new TranslatorJson();
        json.text = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            RelatedCompanies relate = list.get(i);
            json.text[i] = isNull(relate.getEntNature());
        }
        if (list.size() == 1) {
            list.get(0).setEntNatureEN(Tool.isStringNullPicc(Translator.translateOnly(0, list.get(0).getEntNature())));//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
        } else {
            json = Translator.translateMany(0, json.text);//0 -- 通用模式 1 -- 公司名称 2 -- 地址3 -- 姓名
            for (int i = 0; i < list.size(); i++) {
                RelatedCompanies relate = list.get(i);
                if (null == relate.getEntNatureEN() || "".equals(relate.getEntNatureEN())) {
                    relate.setEntNatureEN(Tool.isStringNullPicc(json.dest[i]));
                }
                list.set(i, relate);
            }
        }
        fullReport.setRelatedCompaniesList(list);
        return fullReport;
    }

}
