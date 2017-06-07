package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.DataType;
import com.mika.credit.facade.front.cn.dao.DataTypeDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("dataTypeDao")
public class DataTypeDaoImpl extends BaseDaoImpl<DataType> implements DataTypeDao {


    @Override
    public List<DataType> findByCode(String code) {
        Map<String,Object> params = new HashMap<>();
        params.put("code",code);
        List<DataType> result =  listBy(params);
        return result;
    }

    /*@Override
    public List<DataType> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<DataType> result = (List<DataType>) getBy(params);
        return result;
    }*/

}
