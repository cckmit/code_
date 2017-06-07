package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.OperationAbnormalInfos;

import java.util.List;

/**
 * Created by jack on 2017/2/17.
 */
public interface OperationAbnormalInfosDao extends BaseDao<OperationAbnormalInfos> {

    OperationAbnormalInfos findById(Integer id);

    List<OperationAbnormalInfos> findByFullReportId(Integer fullReportId);

}
