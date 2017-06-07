package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.ChangeInfos;

import java.util.List;

/**
 * 注册变更表
 * Created by michael on 2017/2/17.
 */
public interface ChangeInfosDao extends BaseDao<ChangeInfos> {
    ChangeInfos findById(Integer id);

    List<ChangeInfos> findByFullReportId(Integer fullReportId);
}
