package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.CustomHouse;
import com.mika.credit.common.entity.report.cn.EnterpriseShareholder;

import java.util.List;

/**
 * Created by Zhu Jun on 2017/3/13.
 */
public interface CustomHouseDao extends BaseDao<CustomHouse> {
    CustomHouse findById(Integer id);

    List<CustomHouse> findByFullReportId(Integer fullReportId);
}
