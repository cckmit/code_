package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.Fygg;
import com.mika.credit.facade.front.cn.dao.FyggDao;
import com.mika.credit.facade.front.cn.service.FyggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("fyggService")
public class FyggServiceImpl implements FyggService {

    @Autowired
    FyggDao fyggDao;

    @Override
    public Fygg findById(Integer id) {
        return fyggDao.findById(id);
    }

    @Override
    public List<Fygg> findByFullReportId(Integer fullReportId) {
        return fyggDao.findByFullReportId(fullReportId);
    }
}
