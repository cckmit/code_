package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.Executive;
import com.mika.credit.facade.front.cn.dao.ExecutiveDao;
import com.mika.credit.facade.front.cn.service.ExecutiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("executiveService")
public class ExecutiveServiceImpl implements ExecutiveService {

    @Autowired
    ExecutiveDao executiveDao;

    @Override
    public Executive findById(Integer id) {
        return executiveDao.findById(id);
    }

    @Override
    public List<Executive> findByFullReportId(Integer fullReportId) {
        return executiveDao.findByFullReportId(fullReportId);
    }
}
