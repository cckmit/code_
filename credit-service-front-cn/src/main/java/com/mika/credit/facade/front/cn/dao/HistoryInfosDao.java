package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.HistoryInfos;

import java.util.List;

/**
 * 历史背景沿革
 * Created by jack on 2017/2/17.
 */
public interface HistoryInfosDao extends BaseDao<HistoryInfos> {
    HistoryInfos findById(Integer id);


    List<HistoryInfos> findByFullReportId(Integer fullReportId);
}
