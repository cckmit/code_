package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.CustomHouse;
import com.mika.credit.facade.front.cn.dao.CustomHouseDao;
import com.mika.credit.facade.front.cn.service.CustomHouseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Zhu Jun on 2017/3/13.
 */

public class CustomHouseServiceImpl implements CustomHouseService {
    @Autowired
    CustomHouseDao customHouseDao;
    @Override
    public CustomHouse findById(Integer id) {
        return customHouseDao.findById(id);
    }

    @Override
    public List<CustomHouse> findByFullReportId(Integer fullReportId) {
        return customHouseDao.findByFullReportId(fullReportId);
    }
}
