package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.Rulingdocuments;

import java.util.List;

/**
 * 裁判文书
 * Created by michael on 2017/2/17.
 */
public interface RulingdocumentsDao extends BaseDao<Rulingdocuments> {
    Rulingdocuments findById(Integer id);


    List<Rulingdocuments> findByFullReportId(Integer fullReportId);
}
