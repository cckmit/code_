package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.SharePledgeHis;
import com.mika.credit.facade.front.cn.dao.SharePledgeHisDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("sharePledgeHisDao")
public class SharePledgeHisDaoImpl extends BaseDaoImpl<SharePledgeHis> implements SharePledgeHisDao {
    @Override
    public SharePledgeHis findById(Integer id) {
        SharePledgeHis result = getById(id);
        return result;
    }

    @Override
    public List<SharePledgeHis> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<SharePledgeHis> result = listBy(params);
        return result;    }
}
