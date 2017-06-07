package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.ChattelMortgage;

import java.util.List;

/**
 * Created by michael on 2017/2/17.
 */
public interface ChattelMortgageDao extends BaseDao<ChattelMortgage> {

    ChattelMortgage findById(Integer id);

    List<ChattelMortgage> findByFullReportId(Integer fullReportId);
}
