package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.Rulingdocuments;
import com.mika.credit.facade.front.cn.dao.RulingdocumentsDao;
import com.mika.credit.facade.front.cn.service.RulingdocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("rulingdocumentsService")
public class RulingdocumentsServiceImpl implements RulingdocumentsService {
    @Autowired
    RulingdocumentsDao rulingdocumentsDao;



    @Override
    public Rulingdocuments findById(Integer id) {
        return rulingdocumentsDao.findById(id);
    }

    @Override
    public List<Rulingdocuments> findByFullReportId(Integer fullReportId) {
        return rulingdocumentsDao.findByFullReportId(fullReportId);
    }
}
