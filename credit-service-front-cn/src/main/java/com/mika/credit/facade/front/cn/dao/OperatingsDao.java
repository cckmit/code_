package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Operatings;

import java.util.List;

/**
 * 经营现状表
 * Created by jack on 2017/2/17.
 */
public interface OperatingsDao extends BaseDao<Operatings> {
    Operatings findById(Integer id);


    List<Operatings> findByFullReportId(Integer fullReportId);
}
