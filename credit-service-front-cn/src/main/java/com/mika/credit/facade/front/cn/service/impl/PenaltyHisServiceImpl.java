package com.mika.credit.facade.front.cn.service.impl;



import com.mika.credit.common.entity.report.cn.PenaltyHis;
import com.mika.credit.facade.front.cn.dao.PenaltyHisDao;
import com.mika.credit.facade.front.cn.service.PenaltyHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("penaltyHisService")
public class PenaltyHisServiceImpl implements PenaltyHisService {

    @Autowired
    PenaltyHisDao penaltyHisDao;

    @Override
    public PenaltyHis findById(Integer id) {
        return penaltyHisDao.findById(id);
    }

    @Override
    public List<PenaltyHis> findByFullReportId(Integer fullReportId) {
        return penaltyHisDao.findByFullReportId(fullReportId);
    }
}
