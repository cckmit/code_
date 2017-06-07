package com.mika.credit.facade.front.cn.dao;




import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.BasicData;

import java.util.List;
import java.util.Map;

/**
 * 银行信息
 * Created by michael on 2017/2/17.
 */
public interface BasicDataDao extends BaseDao<BasicData> {

    List<BasicData> listByDtidAndDelFlag(Map<String, Object> params);

    List<BasicData> listByDtidAndCode(Map<String, Object> params);

    List<BasicData> findByFullReportId(Integer fullReportId);



}
