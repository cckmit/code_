package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Wdhmd;

import java.util.List;

/**
 * Created by jack on 2017/2/17.
 */
public interface WdhmdDao extends BaseDao<Wdhmd> {

    Wdhmd findById(Integer id);

    List<Wdhmd> findByFullReportId(Integer fullReportId);
}
