package com.mika.credit.facade.front.cn.dao;


import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.OtherInfos;

import java.util.List;

/**
 * Created by jack on 2017/2/17.
 */
public interface OtherInfosDao extends BaseDao<OtherInfos> {

    OtherInfos findById(Integer id);


    List<OtherInfos> findByFullReportId(Integer fullReportId);

}
