package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.GuaranteeAnnual;
import com.mika.credit.facade.front.cn.dao.GuaranteeAnnualDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/28.
 */
@Repository("guaranteeAnnualDao")
public class GuaranteeAnnualDaoImpl extends BaseDaoImpl<GuaranteeAnnual> implements GuaranteeAnnualDao {
    @Override
    public GuaranteeAnnual findById(Integer id) {
        GuaranteeAnnual result = getById(id);
        return result;
    }

    @Override
    public List<GuaranteeAnnual> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<GuaranteeAnnual> result = listBy(params);
        return result;
    }
}
