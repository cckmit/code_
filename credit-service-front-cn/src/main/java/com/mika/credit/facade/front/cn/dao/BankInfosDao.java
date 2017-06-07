package com.mika.credit.facade.front.cn.dao;


import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.BankInfos;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */

public interface BankInfosDao extends BaseDao<BankInfos>{

    BankInfos findById(Integer id);

    List<BankInfos> findByFullReportId(Integer fullReportId);
}