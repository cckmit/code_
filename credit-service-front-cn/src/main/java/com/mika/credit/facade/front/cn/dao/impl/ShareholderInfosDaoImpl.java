package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.ShareholderInfos;
import com.mika.credit.facade.front.cn.dao.ShareholderInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("shareholderInfosDao")
public class ShareholderInfosDaoImpl extends BaseDaoImpl<ShareholderInfos> implements ShareholderInfosDao {
    @Override
    public ShareholderInfos findById(Integer id) {
        ShareholderInfos result = getById(id);
        return result;
    }

    @Override
    public List<ShareholderInfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<ShareholderInfos> result = listBy(params);
        return result;
    }
}
