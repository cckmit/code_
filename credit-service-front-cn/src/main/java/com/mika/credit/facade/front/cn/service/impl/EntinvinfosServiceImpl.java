package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.Entinvinfos;
import com.mika.credit.facade.front.cn.dao.EntinvinfosDao;
import com.mika.credit.facade.front.cn.service.EntinvinfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("entinvinfosService")
public class EntinvinfosServiceImpl implements EntinvinfosService {

    @Autowired
    EntinvinfosDao entinvinfosDao;

    @Override
    public Entinvinfos findById(Integer id) {
        return entinvinfosDao.findById(id);
    }

    @Override
    public List<Entinvinfos> findByFullReportId(Integer fullReportId) {
        return entinvinfosDao.findByFullReportId(fullReportId);
    }
}
