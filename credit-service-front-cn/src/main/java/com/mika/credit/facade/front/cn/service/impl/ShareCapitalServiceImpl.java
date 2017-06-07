package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.ShareCapital;
import com.mika.credit.common.entity.report.cn.Wdhmd;
import com.mika.credit.facade.front.cn.dao.ShareCapitalDao;
import com.mika.credit.facade.front.cn.service.ShareCapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("shareCapitalService")
public class ShareCapitalServiceImpl implements ShareCapitalService {
    @Autowired
    ShareCapitalDao shareCapitalDao;

    @Override
    public ShareCapital findById(Integer id) {
        return shareCapitalDao.findById(id);
    }

    @Override
    public List<ShareCapital> findByFullReportId(Integer fullReportId) {
        return shareCapitalDao.findByFullReportId(fullReportId);
    }
}
