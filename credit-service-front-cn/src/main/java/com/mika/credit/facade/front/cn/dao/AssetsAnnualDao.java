package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.AssetsAnnual;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */
public interface AssetsAnnualDao extends BaseDao<AssetsAnnual> {

    AssetsAnnual findById(Integer id);

    List<AssetsAnnual> findByFullReportId(Integer fullReportId);
}
