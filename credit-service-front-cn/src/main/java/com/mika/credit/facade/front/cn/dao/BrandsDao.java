package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Brands;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */
public interface BrandsDao extends BaseDao<Brands> {

    Brands findById(Integer id);

    List<Brands> findByFullReportId(Integer fullReportId);
}
