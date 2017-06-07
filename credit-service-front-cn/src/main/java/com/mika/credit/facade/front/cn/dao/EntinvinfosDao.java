package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Entinvinfos;

import java.util.List;

/**
 * 企业对外投资信息
 * Created by michael on 2017/2/17.
 */
public interface EntinvinfosDao extends BaseDao<Entinvinfos> {
    Entinvinfos findById(Integer id);

    List<Entinvinfos> findByFullReportId(Integer fullReportId);
}
