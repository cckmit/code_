package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Ktgg;

import java.util.List;

/**
 * 开庭公告
 * Created by jack on 2017/2/17.
 */
public interface KtggDao extends BaseDao<Ktgg> {
    Ktgg findById(Integer id);


    List<Ktgg> findByFullReportId(Integer fullReportId);
}
