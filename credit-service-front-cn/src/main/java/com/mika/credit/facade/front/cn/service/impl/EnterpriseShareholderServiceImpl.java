package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.EnterpriseShareholder;
import com.mika.credit.facade.front.cn.dao.EnterpriseShareholderDao;
import com.mika.credit.facade.front.cn.service.EnterpriseShareholderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Zhu Jun on 2017/3/13.
 */
public class EnterpriseShareholderServiceImpl implements EnterpriseShareholderService {
    @Autowired
    EnterpriseShareholderDao enterpriseShareholderDao;
    @Override
    public EnterpriseShareholder findById(Integer id) {
        return enterpriseShareholderDao.findById(id);
    }

    @Override
    public List<EnterpriseShareholder> findByFullReportId(Integer fullReportId) {
        return enterpriseShareholderDao.findByFullReportId(fullReportId);
    }
}
