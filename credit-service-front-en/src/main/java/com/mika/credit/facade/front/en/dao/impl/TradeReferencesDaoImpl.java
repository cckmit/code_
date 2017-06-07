package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.TradeReferences;
import com.mika.credit.facade.front.en.dao.TradeReferencesDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("tradeReferencesDao")
public class TradeReferencesDaoImpl extends BaseDaoImpl<TradeReferences> implements TradeReferencesDao {
    @Override
    public TradeReferences findById(Integer id) {
        TradeReferences result = getById(id);
        return null;
    }

    @Override
    public List<TradeReferences> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<TradeReferences> result = listBy(params);
        return result;
    }
}
