package com.mika.credit.facade.front.cn.dao;


import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Rulingdocuments;
import com.mika.credit.common.entity.report.cn.ShareCapital;

import java.util.List;

public interface ShareCapitalDao extends BaseDao<ShareCapital> {
    ShareCapital findById(Integer id);

    List<ShareCapital> findByFullReportId(Integer fullReportId);
}