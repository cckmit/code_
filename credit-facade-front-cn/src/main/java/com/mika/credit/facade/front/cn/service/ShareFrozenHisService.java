package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.ShareFrozenHis;

import java.util.List;

/**
 *
 */
public interface ShareFrozenHisService {

    /**
     *
     * @param
     * @return
     */



    ShareFrozenHis findById(Integer id);

    List<ShareFrozenHis> findByFullReportId(Integer fullReportId);


}
