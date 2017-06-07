package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.BankInfos;

import java.util.List;

/**
 * 银行信息
 * @author jack，michael
 */
public interface BankInfosService{

    /**
     *根据id查询银行信息
     * @param id
     * @return BankInfos
     */
    BankInfos findById(Integer id);

    /**
     * 根据fullReportId查询银行信息
     * @param fullReportId
     * @return  List
     */
    List<BankInfos> findByFullReportId(Integer fullReportId);

    /**
     * 根据ID删除银行信息
     * @param bankInfos
     */
    void deleteById(BankInfos bankInfos);

    /**
     * 新增银行信息
     * @param bankInfos
     */
    void insert(BankInfos bankInfos);


}
