package com.mika.credit.facade.front.cn.service.impl;



import com.mika.credit.common.entity.report.cn.DataType;
import com.mika.credit.facade.front.cn.dao.DataTypeDao;
import com.mika.credit.facade.front.cn.service.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("dataTypeService")
public class DataTypeServiceImpl implements DataTypeService {
    @Autowired
    DataTypeDao dataTypeDao;

    @Override
    public List<DataType> findByCode(String code) {
        return dataTypeDao.findByCode(code);
    }

   /* @Override
    public List<DataType> findByFullReportId(Integer fullReportId) {
        return dataTypeDao.findByFullReportId(fullReportId);
    }*/
}
