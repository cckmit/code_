package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.Ktgg;
import com.mika.credit.facade.front.cn.dao.KtggDao;
import com.mika.credit.facade.front.cn.service.KtggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("ktggService")
public class KtggServiceImpl implements KtggService {
    @Autowired
    KtggDao ktggDao;



    @Override
    public Ktgg findById(Integer id) {
        return ktggDao.findById(id);
    }

    @Override
    public List<Ktgg> findByFullReportId(Integer fullReportId) {
        return ktggDao.findByFullReportId(fullReportId);
    }
}
