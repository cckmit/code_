package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.ShareholdersChain;

import java.util.List;

/**
 * 股东链
 */
public interface ShareholdersChainService {

    /**
     *
     * @param
     * @return
     */
    ShareholdersChain findById(Integer id);

    List<ShareholdersChain> findByFullReportId(Integer fullReportId);

}
