package com.mika.credit.facade.gugu.service;

import com.mika.credit.common.entity.report.cn.FullReport;

import java.util.Map;

/**
 * Created by dong jian hua on 2017/4/18.
 */
public interface FullReportLocalService {

    FullReport getFullReport(FullReport report);

    void saveFullReport(FullReport report);

    FullReport getAllFullReport(FullReport report);

}
