package com.mika.credit.facade.front.cn.dao.impl;

import com.mika.credit.common.core.dao.BaseDaoImpl;
import com.mika.credit.common.entity.report.cn.ChattelMortgage;
import com.mika.credit.facade.front.cn.dao.ChattelMortgageDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/2/27.
 */
@Repository("chattelMortgageDao")
public class ChattelMortgageDaoImpl extends BaseDaoImpl<ChattelMortgage> implements ChattelMortgageDao {


    @Override
    public ChattelMortgage findById(Integer id) {
        ChattelMortgage result = getById(id);
        return result;
    }

    @Override
    public List<ChattelMortgage> findByFullReportId(Integer fullReportId) {
        Map<String,Object> params = new HashMap<>();
        params.put("fullReportId",fullReportId);
        List<ChattelMortgage> result = listBy(params);
        return result;
    }
}
