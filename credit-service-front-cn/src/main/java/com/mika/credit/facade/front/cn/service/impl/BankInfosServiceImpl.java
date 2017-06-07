package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.BankInfos;
import com.mika.credit.facade.front.cn.dao.BankInfosDao;
import com.mika.credit.facade.front.cn.service.BankInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("bankInfosService")
public class BankInfosServiceImpl implements BankInfosService {

    @Autowired
    BankInfosDao bankInfosDao;

    @Override
    public BankInfos findById(Integer id) {
        return bankInfosDao.findById(id);
    }

    @Override
    public List<BankInfos> findByFullReportId(Integer fullReportId){
        return bankInfosDao.findByFullReportId(fullReportId);
    }


    @Override
    public void deleteById(BankInfos bankInfos) {
        bankInfosDao.deleteById(bankInfos.getId());
    }

    @Override
    public void insert(BankInfos bankInfos) {
        bankInfosDao.insert(bankInfos);
    }
}
