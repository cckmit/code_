package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Ktgg;
import com.mika.credit.facade.front.cn.dao.KtggDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/28.
 */
@Repository("ktggDao")
public class KtggDaoImpl extends BaseDaoImpl<Ktgg> implements KtggDao {
    @Override
    public Ktgg findById(Integer id) {
        Ktgg result = getById(id);
        return result;
    }

    @Override
    public List<Ktgg> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Ktgg> result = listBy(params);
        return result;
    }
}
