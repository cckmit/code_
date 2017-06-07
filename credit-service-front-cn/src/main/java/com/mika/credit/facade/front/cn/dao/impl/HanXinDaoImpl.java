package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.HanXin;
import com.mika.credit.facade.front.cn.dao.HanXinDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("hanXinDao")
public class HanXinDaoImpl extends BaseDaoImpl<HanXin> implements HanXinDao {
    @Override
    public List<HanXin> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<HanXin> result =  listBy(params);
        return result;
    }

    @Override
    public HanXin findById(Integer id) {
        HanXin result =  getById(id);
        return result;
    }

    @Override
    public HanXin findByNumber(String number) {
        Map<String,Object> params = new HashMap<>();
        params.put("number",number);
        HanXin result =  getBy(params);
        return result;
    }
}
