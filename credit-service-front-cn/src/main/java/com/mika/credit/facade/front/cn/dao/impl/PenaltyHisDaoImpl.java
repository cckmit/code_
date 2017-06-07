package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.PenaltyHis;
import com.mika.credit.facade.front.cn.dao.PenaltyHisDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/28.
 */
@Repository("penaltyHisDao")
public class PenaltyHisDaoImpl extends BaseDaoImpl<PenaltyHis> implements PenaltyHisDao {
    @Override
    public PenaltyHis findById(Integer id) {
        PenaltyHis result = getById(id);
        return result;
    }

    @Override
    public List<PenaltyHis> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<PenaltyHis> result = listBy(params);
        return result;
    }
}
