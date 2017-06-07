package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.BankInfos;
import com.mika.credit.facade.front.en.dao.BankInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("bankInfosDao")
public class BankInfosDaoImpl extends BaseDaoImpl<BankInfos> implements BankInfosDao {

    @Override
    public BankInfos findById(Integer id) {
        BankInfos result = getById(id);
        return result;
    }

    @Override
    public List<BankInfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<BankInfos> result = listBy(params);
        return result;
    }
}
