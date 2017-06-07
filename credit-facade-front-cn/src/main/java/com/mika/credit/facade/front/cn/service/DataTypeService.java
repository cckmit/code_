package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.DataType;

import java.util.List;

/**
 * 字典类型
 */
public interface DataTypeService {

    /**
     *查询字典类型
     * @param code
     * @return
     */
    List<DataType> findByCode(String code);

   // List<DataType> findByFullReportId(Integer fullReportId);

}
