package com.mika.credit.facade.front.cn.parse;

import com.mika.credit.common.entity.report.cn.FullReport;

/**
 * Created by dong jian hua on 2017/2/24.
 */
public interface Cpm {

    void getCpmList(FullReport report);

    void getCpmAllList(FullReport report);

    FullReport getGlobalReport(FullReport report);

    FullReport copyFullReport(FullReport report);

    void saveBusiness(FullReport report);
}
