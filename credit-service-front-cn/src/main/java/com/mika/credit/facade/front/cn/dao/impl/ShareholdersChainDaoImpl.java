package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.ShareholdersChain;
import com.mika.credit.facade.front.cn.dao.ShareholdersChainDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("shareholdersChainDao")
public class ShareholdersChainDaoImpl extends BaseDaoImpl<ShareholdersChain> implements ShareholdersChainDao {
    @Override
    public ShareholdersChain findById(Integer id) {
        ShareholdersChain result = getById(id);
        return result;
    }

    @Override
    public List<ShareholdersChain> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<ShareholdersChain> result = listBy(params);
        return result;
    }
}
