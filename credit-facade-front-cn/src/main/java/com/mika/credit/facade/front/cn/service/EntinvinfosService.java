package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.Entinvinfos;

import java.util.List;

/**
 * 企业对外投资信息
 * @author jack，michael
 */
public interface EntinvinfosService {

    /**
     * 查询企业对外投资信息
     * @param id
     * @return
     */
    Entinvinfos findById(Integer id);

    /**
     * 查询企业对外投资信息
     * @param fullReportId
     * @return
     */
    List<Entinvinfos> findByFullReportId(Integer fullReportId);

}
