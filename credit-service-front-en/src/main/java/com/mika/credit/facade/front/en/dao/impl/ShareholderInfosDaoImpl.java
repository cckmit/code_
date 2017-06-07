package com.mika.credit.facade.front.en.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.en.ShareholderInfos;
import com.mika.credit.facade.front.en.dao.ShareholderInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/3.
 */
@Repository("shareholderInfosDao")
public class ShareholderInfosDaoImpl extends BaseDaoImpl<ShareholderInfos> implements ShareholderInfosDao {
    @Override
    public ShareholderInfos findById(Integer id) {
        ShareholderInfos result =  getById(id);
        return null;
    }

    @Override
    public List<ShareholderInfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<ShareholderInfos> result = listBy(params);
        return result;
    }
}
