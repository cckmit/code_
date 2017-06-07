package com.mika.credit.facade.front.cn.service.impl;



import com.mika.credit.common.entity.report.cn.SharePledgeHis;
import com.mika.credit.facade.front.cn.dao.SharePledgeHisDao;
import com.mika.credit.facade.front.cn.service.SharePledgeHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("sharePledgeHisService")
public class SharePledgeHisServiceImpl implements SharePledgeHisService {
    @Autowired
    SharePledgeHisDao sharePledgeHisDao;

    @Override
    public SharePledgeHis findById(Integer id) {
        return sharePledgeHisDao.findById(id);
    }

    @Override
    public List<SharePledgeHis> findByFullReportId(Integer fullReportId) {
        return sharePledgeHisDao.findByFullReportId(fullReportId);
    }
}
