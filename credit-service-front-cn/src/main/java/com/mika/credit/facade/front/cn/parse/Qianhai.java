package com.mika.credit.facade.front.cn.parse;

import com.mika.credit.common.entity.report.cn.FullReport;

/**
 * Created by dell on 2017/2/23.
 */
public interface Qianhai {

    public void getQianhaiAllLIst(FullReport report);

    public void getQianhaiLIst(FullReport report);

    public FullReport getGlobalReport(FullReport report);

    /**
     * 保存前海数据至cn中间库
     * @param report
     */
    void saveBusiness(FullReport report);

    /**
     * 调用interface接口获取前海数据
     * @param report
     * @return
     */
    FullReport getQianHaiReport(FullReport report);

    /**
     * 拷贝前海数据至report
     * @param report
     * @return
     */
    FullReport copyFullreport(FullReport report);
}
