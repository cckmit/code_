package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.RegistrationInfos;
import com.mika.credit.facade.front.en.dao.RegistrationInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("registrationInfosDao")
public class RegistrationInfosDaoImpl extends BaseDaoImpl<RegistrationInfos> implements RegistrationInfosDao {
    @Override
    public RegistrationInfos findById(Integer id) {
        RegistrationInfos result = getById(id);
        return null;
    }

    @Override
    public List<RegistrationInfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<RegistrationInfos> result = listBy(params);
        return result;
    }
}
