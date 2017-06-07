package com.mika.credit.facade.front.cn.parse;

import com.mika.credit.common.entity.report.cn.FullReport;

/**
 * Created by dell on 2017/4/8.
 */
public interface QiXinBaoParser {
    /**
     * 解析启信宝数据
     * @param report
     */
    void saveBusiness(FullReport report);

    /**
     * 获取启信宝数据
     * @param companyName
     * @return
     */
    FullReport getQiXinBaoReport(String companyName);

    /**
     * 拷贝启信宝数据至report中
     * @param report
     * @return
     */
    FullReport copyFullReport(FullReport report);
}
