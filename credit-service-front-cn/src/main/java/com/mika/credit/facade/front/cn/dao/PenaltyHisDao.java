package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.PenaltyHis;

import java.util.List;

/**
 * Created by jack on 2017/2/17.
 */
public interface PenaltyHisDao extends BaseDao<PenaltyHis> {

    PenaltyHis findById(Integer id);

    List<PenaltyHis> findByFullReportId(Integer fullReportId);
}
