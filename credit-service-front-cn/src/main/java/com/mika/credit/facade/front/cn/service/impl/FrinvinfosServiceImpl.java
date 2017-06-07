package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.Frinvinfos;
import com.mika.credit.facade.front.cn.dao.FrinvinfosDao;
import com.mika.credit.facade.front.cn.service.FrinvinfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("frinvinfosService")
public class FrinvinfosServiceImpl implements FrinvinfosService {

    @Autowired
    FrinvinfosDao frinvinfosDao;

    @Override
    public Frinvinfos findById(Integer id) {
        return frinvinfosDao.findById(id);
    }

    @Override
    public List<Frinvinfos> findByFullReportId(Integer fullReportId) {
        return frinvinfosDao.findByFullReportId(fullReportId);
    }
}
