package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Fygg;

import java.util.List;

/**
 * Created by jack on 2017/2/17.
 */
public interface FyggDao extends BaseDao<Fygg> {

    Fygg findById(Integer id);


    List<Fygg> findByFullReportId(Integer fullReportId);
}
