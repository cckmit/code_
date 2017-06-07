package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.ChangeInfos;
import com.mika.credit.facade.front.cn.dao.ChangeInfosDao;
import com.mika.credit.facade.front.cn.service.ChangeInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("changeInfosService")
public class ChangeInfosServiceImpl implements ChangeInfosService {

    @Autowired
    ChangeInfosDao changeInfosDao;

    @Override
    public ChangeInfos findById(Integer id) {
        return changeInfosDao.findById(id);
    }

    @Override
    public List<ChangeInfos> findByFullReportId(Integer fullReportId) {
        return changeInfosDao.findByFullReportId(fullReportId);
    }
}
