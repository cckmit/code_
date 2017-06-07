package com.mika.credit.facade.front.cn.parse;

import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.util.Page;

/**
 * Created by dong jian hua on 2017/2/18.
 */
public interface Litigation {
    /**
     * 解析保存法海数据
     * @param report
     */
    public void getFHLitigationAllList(FullReport report);

    public void getFHLitigationList(FullReport report);

    Page getGlobalLitigationList(FullReport report);

    Page getGlobaBadList(FullReport report);

    /**
     * 保存法海数据至cn中间库
     * @param report
     */
    void saveBusiness(FullReport report);

    /**
     * 获取法海数据
     * @param report
     * @return
     */
    FullReport getFaHaiReport(FullReport report);
    /**
     * 拷贝法海数据至report
     * @param report
     * @return
     */
    FullReport copyFullreport(FullReport report);
}
