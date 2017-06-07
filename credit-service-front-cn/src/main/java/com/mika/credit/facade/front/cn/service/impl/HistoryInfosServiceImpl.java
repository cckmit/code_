package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.HistoryInfos;
import com.mika.credit.facade.front.cn.dao.HistoryInfosDao;
import com.mika.credit.facade.front.cn.service.HistoryInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("historyInfosService")
public class HistoryInfosServiceImpl implements HistoryInfosService {
    @Autowired
    HistoryInfosDao historyInfosDao;


    @Override
    public HistoryInfos findById(Integer id) {
        return historyInfosDao.findById(id);
    }

    @Override
    public List<HistoryInfos> findByFullReportId(Integer fullReportId) {
        return historyInfosDao.findByFullReportId(fullReportId);
    }
}
