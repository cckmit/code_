package com.mika.credit.facade.front.cn.dao;


import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.DataType;

import java.util.List;

/**
 * 银行信息
 * Created by michael on 2017/2/17.
 */
public interface DataTypeDao extends BaseDao<DataType> {

    List<DataType> findByCode(String code);

   // List<DataType> findByFullReportId(Integer fullReportId);



}
