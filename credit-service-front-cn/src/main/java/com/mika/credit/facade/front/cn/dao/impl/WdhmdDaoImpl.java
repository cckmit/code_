package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Wdhmd;
import com.mika.credit.facade.front.cn.dao.WdhmdDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("wdhmdDao")
public class WdhmdDaoImpl extends BaseDaoImpl<Wdhmd> implements WdhmdDao {
    @Override
    public Wdhmd findById(Integer id) {
        Wdhmd result =  getById(id);
        return result;
    }

    @Override
    public List<Wdhmd> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Wdhmd> result = listBy(params);
        return result;
    }
}
