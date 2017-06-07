package com.mika.credit.facade.front.cn.service.impl;


import com.mika.credit.common.entity.report.cn.BasicInfos;
import com.mika.credit.facade.front.cn.dao.BasicInfosDao;
import com.mika.credit.facade.front.cn.service.BasicInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2017/2/17.
 */
@Service("basicInfosService")
public class BasicInfosServiceImpl implements BasicInfosService {

    @Autowired
    BasicInfosDao basicInfosDao;

    @Override
    public BasicInfos findById(Integer id) {
        return basicInfosDao.findById(id);
    }

    @Override
    public BasicInfos findByNameCN(String nameCN) {
        return basicInfosDao.findByNameCN(nameCN);
    }

    @Override
    public BasicInfos findByFullReportId(Integer fullReportId) {
        return basicInfosDao.findByFullReportId(fullReportId);
    }
}
