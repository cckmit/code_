package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.OperationAbnormalInfos;
import com.mika.credit.facade.front.cn.dao.OperationAbnormalInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/28.
 */
@Repository("operationAbnormalInfosDao")
public class OperationAbnormalInfosDaoImpl extends BaseDaoImpl<OperationAbnormalInfos> implements OperationAbnormalInfosDao {
    @Override
    public OperationAbnormalInfos findById(Integer id) {
        OperationAbnormalInfos result = getById(id);
        return result;
    }

    @Override
    public List<OperationAbnormalInfos> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<OperationAbnormalInfos> result = listBy(params);
        return result;
    }
}
