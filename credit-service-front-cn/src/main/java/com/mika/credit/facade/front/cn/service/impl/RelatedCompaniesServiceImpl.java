package com.mika.credit.facade.front.cn.service.impl;

import com.mika.credit.common.entity.report.cn.RelatedCompanies;
import com.mika.credit.facade.front.cn.dao.RelatedCompaniesDao;
import com.mika.credit.facade.front.cn.service.RelatedCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/17.
 */
@Service("relatedCompaniesService")
public class RelatedCompaniesServiceImpl implements RelatedCompaniesService {

    @Autowired
    RelatedCompaniesDao relatedCompaniesDao;

    @Override
    public RelatedCompanies findById(Integer id) {
        return relatedCompaniesDao.findById(id);
    }

    @Override
    public List<RelatedCompanies> findByFullReportId(Integer fullReportId) {
        return relatedCompaniesDao.findByFullReportId(fullReportId);
    }
}
