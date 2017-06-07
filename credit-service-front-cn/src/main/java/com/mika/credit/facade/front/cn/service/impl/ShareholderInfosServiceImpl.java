package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.ShareholderInfos;
import com.mika.credit.facade.front.cn.dao.ShareholderInfosDao;
import com.mika.credit.facade.front.cn.service.ShareholderInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("shareholderInfosService")
public class ShareholderInfosServiceImpl implements ShareholderInfosService {
    @Autowired
    ShareholderInfosDao shareholderInfosDao;
    @Override
    public ShareholderInfos findById(Integer id) {
        return shareholderInfosDao.findById(id);
    }

    @Override
    public List<ShareholderInfos> findByFullReportId(Integer fullReportId) {
        return shareholderInfosDao.findByFullReportId(fullReportId);
    }
}
