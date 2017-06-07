package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.ChangeInfos;

import java.util.List;

/**
 * 注册变更表
 * @author jack，michael
 */
public interface ChangeInfosService {

    /**
     *根据id查询注册变更表
     * @param
     * @return
     */
    ChangeInfos findById(Integer id);

    /**
     *根据fullReportId查询注册变更表
     * @param fullReportId
     * @return
     */
    List<ChangeInfos> findByFullReportId(Integer fullReportId);

}
