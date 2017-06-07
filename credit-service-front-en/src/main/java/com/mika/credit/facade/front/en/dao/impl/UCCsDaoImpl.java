package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.UCCs;
import com.mika.credit.facade.front.en.dao.UCCsDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("uCCsDao")
public class UCCsDaoImpl extends BaseDaoImpl<UCCs> implements UCCsDao {
    @Override
    public UCCs findById(Integer id) {
        UCCs result = getById(id);
        return null;
    }

    @Override
    public List<UCCs> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<UCCs> result = listBy(params);
        return result;
    }
}
