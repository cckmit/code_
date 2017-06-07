package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.BasicInfos;
import com.mika.credit.facade.front.cn.dao.BasicInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("basicInfosDao")
public class BasicInfosDaoImpl extends BaseDaoImpl<BasicInfos> implements BasicInfosDao {
    @Override
    public BasicInfos findById(Integer id) {
        BasicInfos result = getById(id);
        return result;
    }

    @Override
    public BasicInfos findByNameCN(String nameCN) {
        Map<String,Object> params = new HashMap<>();
        params.put("nameCN",nameCN);
        List<BasicInfos> result = listBy(params);
        if(null!=result  && result.size()>0){
            return result.get(0);
        }else{
            return  new BasicInfos();
        }
    }

    @Override
    public BasicInfos findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<BasicInfos> result = listBy(params);
        if(null!=result  && result.size()>0){
            return result.get(0);
        }else{
            return  new BasicInfos();
        }
    }
}
