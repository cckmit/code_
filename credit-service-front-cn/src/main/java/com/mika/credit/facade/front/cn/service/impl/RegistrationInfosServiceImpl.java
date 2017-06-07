package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.RegistrationInfos;
import com.mika.credit.facade.front.cn.dao.RegistrationInfosDao;
import com.mika.credit.facade.front.cn.service.RegistrationInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2017/2/17.
 */
@Service("RegistrationInfosService")
public class RegistrationInfosServiceImpl implements RegistrationInfosService {
    @Autowired
    RegistrationInfosDao registrationInfosDao;



    @Override
    public RegistrationInfos findById(Integer id) {
        return registrationInfosDao.findById(id);
    }

    @Override
    public RegistrationInfos findByFullReportId(Integer fullReportId) {
        return  registrationInfosDao.findByFullReportId(fullReportId);
    }
}
