package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Brands;
import com.mika.credit.facade.front.cn.dao.BrandsDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("brandsDao")
public class BrandsDaoImpl extends BaseDaoImpl<Brands> implements BrandsDao {


    @Override
    public Brands findById(Integer id) {
        Brands result = getById(id);
        return result;
    }

    @Override
    public List<Brands> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<Brands> result = listBy(params);
        return result;
    }
}
