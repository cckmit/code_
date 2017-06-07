package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.ChangeInfos;
import com.mika.credit.facade.front.cn.dao.ChangeInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("changeInfosDao")
public class ChangeInfosDaoImpl extends BaseDaoImpl<ChangeInfos> implements ChangeInfosDao {


    @Override
    public ChangeInfos findById(Integer id) {
        ChangeInfos result = getById(id);
        return result;
    }

    @Override
    public List<ChangeInfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<ChangeInfos> result = listBy(params);
        return result;
    }
}
