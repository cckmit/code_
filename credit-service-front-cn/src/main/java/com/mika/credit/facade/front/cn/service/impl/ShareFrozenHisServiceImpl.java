package com.mika.credit.facade.front.cn.service.impl;



import com.mika.credit.common.entity.report.cn.ShareFrozenHis;
import com.mika.credit.facade.front.cn.dao.ShareFrozenHisDao;
import com.mika.credit.facade.front.cn.service.ShareFrozenHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("shareFrozenHisService")
public class ShareFrozenHisServiceImpl implements ShareFrozenHisService {
    @Autowired
    ShareFrozenHisDao shareFrozenHisDao;




    @Override
    public ShareFrozenHis findById(Integer id) {
        return shareFrozenHisDao.findById(id);
    }

    @Override
    public List<ShareFrozenHis> findByFullReportId(Integer fullReportId) {
        return shareFrozenHisDao.findByFullReportId(fullReportId);
    }
}
