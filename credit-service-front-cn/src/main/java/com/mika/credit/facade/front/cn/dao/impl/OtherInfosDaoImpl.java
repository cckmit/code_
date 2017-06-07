package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.OtherInfos;
import com.mika.credit.facade.front.cn.dao.OtherInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/28.
 */
@Repository("otherInfosDao")
public class OtherInfosDaoImpl extends BaseDaoImpl<OtherInfos> implements OtherInfosDao {
    @Override
    public OtherInfos findById(Integer id) {
        OtherInfos result = getById(id);
        return result;
    }

    @Override
    public List<OtherInfos> findByFullReportId(Integer fullReportId) {
        Map<String , Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<OtherInfos> result = listBy(params);
        return result;
    }
}
