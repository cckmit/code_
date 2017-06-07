package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.GuaranteeAnnual;

import java.util.List;

/**
 * Created by jack on 2017/2/17.
 */
public interface GuaranteeAnnualDao extends BaseDao<GuaranteeAnnual> {

    GuaranteeAnnual findById(Integer id);


    List<GuaranteeAnnual> findByFullReportId(Integer fullReportId);
}
