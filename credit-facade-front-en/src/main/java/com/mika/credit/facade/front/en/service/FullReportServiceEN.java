package com.mika.credit.facade.front.en.service;

import com.mika.credit.common.entity.report.en.FullReport;

/**
 * 英语全报告对象
 */
public interface FullReportServiceEN {

    /**
     * 英语全报告对象
     * @param
     * @return
     */

    FullReport getFullReport(FullReport report);

    /**
     * 全球鹰老版本拿赛弗数据
     * @param report
     * @return
     */
    String getSafeReport(FullReport report);



    }
