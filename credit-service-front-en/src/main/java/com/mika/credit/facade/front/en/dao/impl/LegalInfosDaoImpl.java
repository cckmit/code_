package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.LegalInfos;
import com.mika.credit.facade.front.en.dao.LegalInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("legalInfosDao")
public class LegalInfosDaoImpl extends BaseDaoImpl<LegalInfos> implements LegalInfosDao {
    @Override
    public LegalInfos findById(Integer id) {
        LegalInfos result = getById(id);
        return null;
    }

    @Override
    public List<LegalInfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<LegalInfos>  result =listBy(params);
        return result;
    }
}
