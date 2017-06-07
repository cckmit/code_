package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Frpositioninfos;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */
public interface FrpositioninfosDao extends BaseDao<Frpositioninfos> {

    Frpositioninfos findById(Integer id);


    List<Frpositioninfos> findByFullReportId(Integer fullReportId);
}
