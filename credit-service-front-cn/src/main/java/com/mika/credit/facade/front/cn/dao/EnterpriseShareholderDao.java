package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.EnterpriseShareholder;
import com.mika.credit.common.entity.report.cn.Entinvinfos;

import java.util.List;

/**
 * Created by Zhu Jun on 2017/3/13.
 */
public interface EnterpriseShareholderDao extends BaseDao<EnterpriseShareholder> {
    EnterpriseShareholder findById(Integer id);

    List<EnterpriseShareholder> findByFullReportId(Integer fullReportId);
}
