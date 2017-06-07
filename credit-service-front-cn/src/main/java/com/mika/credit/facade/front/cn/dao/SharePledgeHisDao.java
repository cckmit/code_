package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.SharePledgeHis;

import java.util.List;

/**
 * Created by jack on 2017/2/17.
 */
public interface SharePledgeHisDao extends BaseDao<SharePledgeHis> {

    SharePledgeHis findById(Integer id);

    List<SharePledgeHis> findByFullReportId(Integer fullReportId);
}
