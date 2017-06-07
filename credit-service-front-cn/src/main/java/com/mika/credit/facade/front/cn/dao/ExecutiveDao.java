package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Executive;

import java.util.List;

/**
 * 执行公告
 * Created by michael on 2017/2/17.
 */
public interface ExecutiveDao extends BaseDao<Executive> {

    Executive findById(Integer id);

    List<Executive> findByFullReportId(Integer fullReportId);
}
