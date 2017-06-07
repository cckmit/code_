package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.Managements;
import com.mika.credit.facade.front.cn.dao.ManagementsDao;
import com.mika.credit.facade.front.cn.service.ManagementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("managementsService")
public class ManagementsServiceImpl implements ManagementsService {
    @Autowired
    ManagementsDao managementsDao;



    @Override
    public Managements findById(Integer id) {
        return managementsDao.findById(id);
    }

    @Override
    public List<Managements> findByFullReportId(Integer fullReportId) {
        return managementsDao.findByFullReportId(fullReportId);
    }
}
