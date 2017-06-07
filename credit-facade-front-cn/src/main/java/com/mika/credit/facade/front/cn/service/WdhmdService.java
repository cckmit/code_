package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.Wdhmd;

import java.util.List;

/**
 * 网贷黑名单
 */
public interface WdhmdService {

    /**
     * 查询网贷黑名单
     * @param
     * @return
     */
    Wdhmd findById(Integer id);

    List<Wdhmd> findByFullReportId(Integer fullReportId);


}
