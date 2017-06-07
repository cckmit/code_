package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Managements;

import java.util.List;

/**
 * 管理层信息
 * Created by jack on 2017/2/17.
 */
public interface ManagementsDao extends BaseDao<Managements> {
    Managements findById(Integer id);



    List<Managements> findByFullReportId(Integer fullReportId);
}
