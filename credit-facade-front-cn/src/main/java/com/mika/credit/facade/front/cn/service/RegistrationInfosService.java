package com.mika.credit.facade.front.cn.service;

import com.mika.credit.common.entity.report.cn.RegistrationInfos;

/**
 * 注册信息
 */
public interface RegistrationInfosService {

    /**
     *
     * @param
     * @return
     */

    RegistrationInfos findById(Integer id);

    RegistrationInfos findByFullReportId(Integer fullReportId);


}
