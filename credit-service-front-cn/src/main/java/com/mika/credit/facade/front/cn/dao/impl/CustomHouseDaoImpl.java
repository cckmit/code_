package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.CustomHouse;
import com.mika.credit.facade.front.cn.dao.CustomHouseDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhu Jun on 2017/3/13.
 */
@Repository("customHouseDao")
public class CustomHouseDaoImpl extends BaseDaoImpl<CustomHouse> implements CustomHouseDao {
    @Override
    public CustomHouse findById(Integer id) {
        CustomHouse result = getById(id);
        return result;
    }

    @Override
    public List<CustomHouse> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<CustomHouse> result = listBy(params);
        return result;
    }
}
