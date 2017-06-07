package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Frinvinfos;

import java.util.List;

/**
 * 法人对外投资信息
 * Created by michael on 2017/2/17.
 */
public interface FrinvinfosDao extends BaseDao<Frinvinfos> {
    Frinvinfos findById(Integer id);



    List<Frinvinfos> findByFullReportId(Integer fullReportId);
}
