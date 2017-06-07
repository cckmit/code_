package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Bgt;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */
public interface BgtDao extends BaseDao<Bgt> {

    Bgt findById(Integer id);

    List<Bgt> findByFullReportId(Integer fullReportId);
}
