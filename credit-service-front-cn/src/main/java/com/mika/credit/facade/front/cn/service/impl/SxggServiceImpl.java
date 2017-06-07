package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.Sxgg;
import com.mika.credit.facade.front.cn.dao.SxggDao;
import com.mika.credit.facade.front.cn.service.SxggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("sxggService")
public class SxggServiceImpl implements SxggService {
    @Autowired
    SxggDao sxggDao;

    @Override
    public Sxgg findById(Integer id) {
        return sxggDao.findById(id);
    }

    @Override
    public List<Sxgg> findByFullReportId(Integer fullReportId) {
        return sxggDao.findByFullReportId(fullReportId);
    }
}
