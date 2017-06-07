package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.FaHai;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */
public interface FaHaiDao extends BaseDao<FaHai> {

    FaHai findById(Integer id);

    List<FaHai> findByFullReportId(Integer fullReportId);

    FaHai findByCompanyName(String param);
}
