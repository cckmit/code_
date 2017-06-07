package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.HanXin;

import java.util.List;

/**
 * 失信被执行人
 * Created by jack on 2017/2/17.
 */
public interface HanXinDao extends BaseDao<HanXin> {
    HanXin findById(Integer id);

    List<HanXin> findByFullReportId(Integer fullReportId);

    HanXin findByNumber(String number);
}
