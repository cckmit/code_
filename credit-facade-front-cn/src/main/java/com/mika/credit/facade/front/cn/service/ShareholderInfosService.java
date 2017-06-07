package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.ShareholderInfos;

import java.util.List;

/**
 * 注册信息
 */
public interface ShareholderInfosService {

    /**
     *
     * @param
     * @return
     */

    ShareholderInfos findById(Integer id);

    List<ShareholderInfos> findByFullReportId(Integer fullReportId);

}
