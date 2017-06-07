package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Sxgg;

import java.util.List;

/**
 * 失信被执行人
 * Created by jack on 2017/2/17.
 */
public interface SxggDao extends BaseDao<Sxgg> {
    Sxgg findById(Integer id);

    List<Sxgg> findByFullReportId(Integer fullReportId);
}
