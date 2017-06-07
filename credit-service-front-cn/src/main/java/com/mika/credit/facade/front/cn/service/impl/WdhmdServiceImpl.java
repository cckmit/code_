package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.Wdhmd;
import com.mika.credit.facade.front.cn.dao.WdhmdDao;
import com.mika.credit.facade.front.cn.service.WdhmdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("wdhmdService")
public class WdhmdServiceImpl implements WdhmdService {
    @Autowired
    WdhmdDao wdhmdDao;

    @Override
    public Wdhmd findById(Integer id) {
        return wdhmdDao.findById(id);
    }

    @Override
    public List<Wdhmd> findByFullReportId(Integer fullReportId) {
        return wdhmdDao.findByFullReportId(fullReportId);
    }
}
