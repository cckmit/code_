package com.mika.credit.facade.front.cn.service;


import com.mika.credit.common.entity.report.cn.ShareCapital;

import java.util.List;

/**
 * 网贷黑名单
 */
public interface ShareCapitalService {

    /**
     * 查询网贷黑名单
     * @param
     * @return
     */
    ShareCapital findById(Integer id);

    List<ShareCapital> findByFullReportId(Integer fullReportId);


}
