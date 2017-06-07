package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.Brands;
import com.mika.credit.common.entity.report.cn.ShareCapital;
import com.mika.credit.facade.front.cn.dao.ShareCapitalDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("shareCapitalDao")
public class ShareCapitalDaoImpl extends BaseDaoImpl<ShareCapital> implements ShareCapitalDao {


    @Override
    public ShareCapital findById(Integer id) {
        ShareCapital result = getById(id);
        return result;
    }

    @Override
    public List<ShareCapital> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<ShareCapital> result = listBy(params);
        return result;
    }
}
