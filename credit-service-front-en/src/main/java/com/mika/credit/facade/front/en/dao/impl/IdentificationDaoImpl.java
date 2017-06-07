package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.Identification;
import com.mika.credit.facade.front.en.dao.IdentificationDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("identificationDao")
public class IdentificationDaoImpl extends BaseDaoImpl<Identification> implements IdentificationDao {
    @Override
    public Identification findById(Integer id) {
        Identification result =  getById(id);
        return null;
    }

    @Override
    public List<Identification> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Identification> result = listBy(params);
        return result;
    }
}
