package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.CustomHouse;

import java.util.List;

/**
 * 海关信息
 * @author jack，michael
 */
public interface CustomHouseService {
    /**
     * 查询海关信息
     * @param id
     * @return
     */
    CustomHouse findById(Integer id);

    /**
     * 查询海关信息
     * @param fullReportId
     * @return
     */
    List<CustomHouse> findByFullReportId(Integer fullReportId);
}
