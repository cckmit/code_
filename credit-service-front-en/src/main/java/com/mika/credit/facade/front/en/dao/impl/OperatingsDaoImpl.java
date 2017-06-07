package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.Operatings;
import com.mika.credit.facade.front.en.dao.OperatingsDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("operatingsDao")
public class OperatingsDaoImpl extends BaseDaoImpl<Operatings> implements OperatingsDao {
    @Override
    public Operatings findById(Integer id) {
        Operatings result =  getById(id);
        return null;
    }

    @Override
    public List<Operatings> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Operatings> result =listBy(params);
        return result;
    }
}
