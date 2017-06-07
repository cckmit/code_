package com.mika.credit.facade.front.cn.service;


import com.mika.credit.common.entity.report.cn.BasicInfos;

/**
 * 企业基本信息
 * @author jack，michael
 */
public interface BasicInfosService {

    /**
     *根据id查询企业基本信息
     * @param id
     * @return
     */
    BasicInfos findById(Integer id);

    /**
     * 根据公司名查询企业基本信息
     * @param nameCN
     * @return
     */
    BasicInfos findByNameCN(String nameCN);

    /**
     * 根据fullReportId查询企业基本信息
     * @param fullReportId
     * @return
     */
    BasicInfos findByFullReportId(Integer fullReportId);

}
