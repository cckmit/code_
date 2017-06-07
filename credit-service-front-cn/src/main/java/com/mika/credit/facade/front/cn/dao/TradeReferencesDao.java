package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.TradeReferences;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */
public interface TradeReferencesDao extends BaseDao<TradeReferences> {

    TradeReferences findById(Integer id);

    List<TradeReferences> findByFullReportId(Integer fullReportId);

    List<TradeReferences> findByFullReportIdAndFlag(Integer fullReportId,String flag);


}
