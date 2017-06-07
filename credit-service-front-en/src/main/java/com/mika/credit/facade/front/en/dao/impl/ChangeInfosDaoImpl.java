package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.ChangeInfos;
import com.mika.credit.facade.front.en.dao.ChangeInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("changeInfosDao")
public class ChangeInfosDaoImpl extends BaseDaoImpl<ChangeInfos> implements ChangeInfosDao {
    @Override
    public ChangeInfos findById(Integer id) {
        ChangeInfos result = getById(id);
        return null;
    }

    @Override
    public List<ChangeInfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<ChangeInfos> result = listBy(params);
        return result;
    }
}
