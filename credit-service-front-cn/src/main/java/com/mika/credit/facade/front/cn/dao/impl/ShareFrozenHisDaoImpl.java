package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.ShareFrozenHis;
import com.mika.credit.facade.front.cn.dao.ShareFrozenHisDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("shareFrozenHisDao")
public class ShareFrozenHisDaoImpl extends BaseDaoImpl<ShareFrozenHis> implements ShareFrozenHisDao {
    @Override
    public ShareFrozenHis findById(Integer id) {
        ShareFrozenHis result = getById(id);
        return result;
    }

    @Override
    public List<ShareFrozenHis> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<ShareFrozenHis> result = listBy(params);
        return result;
    }
}
