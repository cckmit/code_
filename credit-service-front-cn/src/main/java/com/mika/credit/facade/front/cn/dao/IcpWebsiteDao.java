package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.IcpWebsite;

import java.util.List;

/**
 * Created by jack on 2017/2/17.
 */
public interface IcpWebsiteDao extends BaseDao<IcpWebsite> {

    IcpWebsite findById(Integer id);

    List<IcpWebsite> findByFullReportId(Integer fullReportId);
}
