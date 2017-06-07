package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.IcpWebsite;
import com.mika.credit.facade.front.cn.dao.IcpWebsiteDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/28.
 */
@Repository("icpWebsiteDao")
public class IcpWebsiteDaoImpl extends BaseDaoImpl<IcpWebsite> implements IcpWebsiteDao {
    @Override
    public IcpWebsite findById(Integer id) {
        IcpWebsite result = getById(id);
        return result;
    }

    @Override
    public List<IcpWebsite> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<IcpWebsite> result = listBy(params);
        return result;
    }
}
