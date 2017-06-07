package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.BasicAnnua;
import com.mika.credit.facade.front.cn.dao.BasicAnnuaDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("baiscAnnuaDao")
public class BaiscAnnuaDaoImpl extends BaseDaoImpl<BasicAnnua> implements BasicAnnuaDao {
    @Override
    public BasicAnnua findById(Integer id) {
        BasicAnnua result = getById(id);
        return result;
    }

    @Override
    public List<BasicAnnua> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<BasicAnnua> result = listBy(params);
        return result;
    }
}
