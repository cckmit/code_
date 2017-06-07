package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.ShareholdersChain;

import java.util.List;

/**
 * 股东链
 * Created by jack on 2017/2/17.
 */
public interface ShareholdersChainDao extends BaseDao<ShareholdersChain> {
    ShareholdersChain findById(Integer id);

    List<ShareholdersChain> findByFullReportId(Integer fullReportId);

}
