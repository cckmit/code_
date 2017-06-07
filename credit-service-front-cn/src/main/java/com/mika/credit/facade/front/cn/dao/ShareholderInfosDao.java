package com.mika.credit.facade.front.cn.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.cn.ShareholderInfos;

import java.util.List;

/**
 * 注册信息
 * Created by jack on 2017/2/17.
 */
public interface ShareholderInfosDao extends BaseDao<ShareholderInfos> {
    ShareholderInfos findById(Integer id);


    List<ShareholderInfos> findByFullReportId(Integer fullReportId);

}
