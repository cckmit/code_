package com.mika.credit.facade.front.cn.dao;


import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.BasicInfos;

/**
 * 企业基本信息
 * Created by dell on 2017/2/17.
 */
public interface BasicInfosDao extends BaseDao<BasicInfos> {
    BasicInfos findById(Integer id);

    BasicInfos findByNameCN(String nameCN);

    BasicInfos findByFullReportId(Integer fullReportId);

    //BasicInfos findByOrderId();



}
