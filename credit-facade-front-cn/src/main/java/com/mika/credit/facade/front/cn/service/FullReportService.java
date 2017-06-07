package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.report.cn.FullReport;

/**
 * 中文全报告对象
 */
public interface FullReportService {

    /**
     * 中文全报告对象
     *  @param report
     *  @return
     */

    FullReport getFullReport(FullReport report);

    /**
     * 从cn库中获取全部数据
     * @param report
     * @return
     */
    FullReport getAllFullReport(FullReport report);

    FullReport getFullReportlitigation(FullReport report);

    /**
     * 获取注册信息
     * @param report
     * @return
     */
    FullReport getGlobalRegReport(FullReport report);

    FullReport getGlobalAllReport(FullReport report);

    void saveFullReport(FullReport report);

    ResponseResult getFullReportByModuleType(String companyName,String moduleTypeStr);

}
