package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.BasicInfos;
import com.mika.credit.facade.front.en.dao.BasicInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("basicInfosDao")
public class BasicInfosDaoImpl extends BaseDaoImpl<BasicInfos> implements BasicInfosDao {
    @Override
    public BasicInfos findById(Integer id) {
        BasicInfos result = getById(id);
        return result;
    }

    @Override
    public List<BasicInfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<BasicInfos> result = listBy(params);
        return result;
    }
}
