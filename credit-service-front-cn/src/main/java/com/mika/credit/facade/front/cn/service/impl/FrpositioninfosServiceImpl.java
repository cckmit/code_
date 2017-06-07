package com.mika.credit.facade.front.cn.service.impl;


import com.mika.credit.common.entity.report.cn.Frpositioninfos;
import com.mika.credit.facade.front.cn.dao.FrpositioninfosDao;
import com.mika.credit.facade.front.cn.service.FrpositioninfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("frpositioninfosService")
public class FrpositioninfosServiceImpl implements FrpositioninfosService {

    @Autowired
    FrpositioninfosDao frpositioninfosDao;

    @Override
    public Frpositioninfos findById(Integer id) {
        return frpositioninfosDao.findById(id);
    }

    @Override
    public List<Frpositioninfos> findByFullReportId(Integer fullReportId) {
        return frpositioninfosDao.findByFullReportId(fullReportId);
    }
}
