package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.Executive;

import java.util.List;

/**
 * 执行公告
 * @author jack，michael
 */
public interface ExecutiveService {

    /**
     * 查询执行公告
     * @param id
     * @return
     */
    Executive findById(Integer id);

    /**
     * 查询执行公告
     * @param fullReportId
     * @return
     */
    List<Executive> findByFullReportId(Integer fullReportId);

}
