package com.mika.credit.facade.front.cn.parse;

import com.mika.credit.common.entity.report.cn.FullReport;

/**
 * Created by dell on 2017/2/16.
 */
public interface ParseGrande {

    void SaveAssetsAnnual(FullReport report);

    void SaveBusiness(FullReport report);

    FullReport getGlobalReport(FullReport report);

    FullReport getGlobalRegReport(FullReport report);

    FullReport getGlobalChangeList(FullReport report);

}
