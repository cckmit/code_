package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.ShareholdersChain;
import com.mika.credit.facade.front.cn.dao.ShareholdersChainDao;
import com.mika.credit.facade.front.cn.service.ShareholdersChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("shareholdersChainService")
public class ShareholdersChainServiceImpl implements ShareholdersChainService {

    @Autowired
    ShareholdersChainDao shareholdersChainDao;

    @Override
    public ShareholdersChain findById(Integer id) {
        return shareholdersChainDao.findById(id);
    }

    @Override
    public List<ShareholdersChain> findByFullReportId(Integer fullReportId) {
        return shareholdersChainDao.findByFullReportId(fullReportId);
    }
}
