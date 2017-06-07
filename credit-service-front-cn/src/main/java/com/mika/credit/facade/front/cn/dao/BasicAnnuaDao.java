package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.BasicAnnua;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */
public interface BasicAnnuaDao extends BaseDao<BasicAnnua> {

    BasicAnnua findById(Integer id);

    List<BasicAnnua> findByFullReportId(Integer fullReportId);
}
