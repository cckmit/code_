package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.OtherInfos;
import com.mika.credit.facade.front.en.dao.OtherInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("otherInfosDao")
public class OtherInfosDaoImpl extends BaseDaoImpl<OtherInfos> implements OtherInfosDao {
    @Override
    public OtherInfos findById(Integer id) {
        OtherInfos result =  getById(id);
        return null;
    }

    @Override
    public List<OtherInfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<OtherInfos> result = listBy(params);
        return result;
    }
}
