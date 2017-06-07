package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.BasicInfos;
import com.mika.credit.common.entity.report.cn.RegistrationInfos;
import com.mika.credit.facade.front.cn.dao.RegistrationInfosDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/2/27.
 */
@Repository("registrationInfosDao")
public class RegistrationInfosDaoImpl extends BaseDaoImpl<RegistrationInfos> implements RegistrationInfosDao {
    @Override
    public RegistrationInfos findById(Integer id) {
        RegistrationInfos result = getById(id);
        return result;
    }

    @Override
    public RegistrationInfos findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<RegistrationInfos> result = listBy(params);
        if(null!=result  && result.size()>0){
            return result.get(0);
        }else{
            return  new RegistrationInfos();
        }
    }
}
