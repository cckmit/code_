package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.BasicData;
import com.mika.credit.facade.front.cn.dao.BasicDataDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("basicDateDao")
public class BasicDataDaoImpl extends BaseDaoImpl<BasicData> implements BasicDataDao {
    @Override
    public List<BasicData> listByDtidAndDelFlag(Map<String, Object> params) {
        List<BasicData> result = listBy(params);
        return result;
    }

    @Override
    public List<BasicData> listByDtidAndCode(Map<String, Object> params) {
        List<BasicData> result = listBy(params);
        return result;
    }

    @Override
    public List<BasicData> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<BasicData> result = listBy(params);
        return result;
    }

}
