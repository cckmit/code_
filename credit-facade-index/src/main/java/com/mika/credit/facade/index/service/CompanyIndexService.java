package com.mika.credit.facade.index.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.index.BaseSearchParam;
import com.mika.credit.common.entity.index.BaseSearchResult;
import com.mika.credit.facade.index.bean.Company;
import com.mika.credit.facade.index.bean.QueryENByName;
import com.mika.credit.facade.index.bean.QueryENByProduct;

/**
 * Created by Gavin on 2017/2/8.
 */
public interface CompanyIndexService {
    BootGrid<Company> fillCompanyIndex(BootGrid<Company> param);
    BootGrid<Company> fillCompanyIndexSimple(String keyword);
    BootGrid<Company> fillCompanyIndex(String keyword, Integer pageNo, Integer pageSize);
    BootGrid<String> fillCompanyNameIndexSimple(String keyword, Integer pageSize);

    //以下是英文索引
    BootGrid<Company> fillCompanyIndexENByName(BootGrid<Company> param, QueryENByName condition);
    BootGrid<Company> fillCompanyIndexENByName(BootGrid<Company> param, QueryENByName condition,boolean isHighLight);
    BootGrid<Company> fillCompanyIndexENByProduct(BootGrid<Company> param, QueryENByProduct condition);
    BootGrid<Company> fillCompanyIndexENByProduct(BootGrid<Company> param, QueryENByProduct condition,boolean isHighLight);
    BootGrid<Company> fillCompanyIndexSimpleENByName(QueryENByName condition);
    BootGrid<Company> fillCompanyIndexSimpleENByName(QueryENByName condition,boolean isHighLight);
    BootGrid<Company> fillCompanyIndexSimpleENByProduct(QueryENByProduct condition);
    BootGrid<Company> fillCompanyIndexSimpleENByProduct(QueryENByProduct condition,boolean isHighLight);
    BootGrid<String> fillCompanyNameIndexSimpleEN(QueryENByName condition, Integer pageSize);

    //作为基本索引方法
    BootGrid<BaseSearchResult> fillCompanyIndexWithCondition(BaseSearchParam condition);
    BootGrid<BaseSearchResult> fillCompanyIndexWithConditionEN(BaseSearchParam condition);
    BootGrid<BaseSearchResult> fillCompanyIndexWithConditionCN(BaseSearchParam condition);
    BootGrid<BaseSearchResult> fillCompanyIndexWithConditionBigNet(BaseSearchParam condition);
}
