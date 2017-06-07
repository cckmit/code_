package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.RegistrationInfos;

/**
 * 注册信息
 * Created by dell on 2017/2/17.
 */
public interface RegistrationInfosDao extends BaseDao<RegistrationInfos> {
    RegistrationInfos findById(Integer id);

    RegistrationInfos findByFullReportId(Integer fullReportId);

}
