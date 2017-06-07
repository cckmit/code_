package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Ajlc;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */
public interface AjlcDao extends BaseDao<Ajlc> {

    Ajlc findById(Integer id);

    List<Ajlc> findByFullReportId(Integer fullReportId);
}
