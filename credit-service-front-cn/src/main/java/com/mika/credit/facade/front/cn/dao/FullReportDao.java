package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.FullReport;

/**
 * Created by jack on 2017/2/17.
 */
public interface FullReportDao extends BaseDao<FullReport> {

    FullReport findById(Integer id);


    FullReport findByName(String name);
}
