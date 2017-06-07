package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.EnterpriseShareholder;
import com.mika.credit.common.entity.report.cn.Entinvinfos;
import com.mika.credit.facade.front.cn.dao.EnterpriseShareholderDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhu Jun on 2017/3/13.
 */
@Repository("enterpriseShareholderDao")
public class EnterpriseShareholderDaoImpl extends BaseDaoImpl<EnterpriseShareholder> implements EnterpriseShareholderDao {
    @Override
    public EnterpriseShareholder findById(Integer id) {
        EnterpriseShareholder result = getById(id);
        return result;
    }

    @Override
    public List<EnterpriseShareholder> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<EnterpriseShareholder> result = listBy(params);
        return result;
    }
}
