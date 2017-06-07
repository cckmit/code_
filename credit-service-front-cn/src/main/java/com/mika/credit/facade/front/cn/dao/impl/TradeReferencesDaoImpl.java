package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.TradeReferences;
import com.mika.credit.facade.front.cn.dao.TradeReferencesDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("tradeReferencesDao")
public class TradeReferencesDaoImpl extends BaseDaoImpl<TradeReferences> implements TradeReferencesDao {
    @Override
    public List<TradeReferences> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<TradeReferences> result = listBy(params);
        return result;
    }

    @Override
    public TradeReferences findById(Integer id) {
        TradeReferences result = getById(id);
        return result;
    }

    @Override
    public List<TradeReferences> findByFullReportIdAndFlag(Integer fullReportId,String flag) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        params.put("flag",flag);
        List<TradeReferences> result = listBy(params);
        return result;
    }
}
