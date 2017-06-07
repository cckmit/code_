package com.mika.credit.facade.front.en.dao;

import com.mika.credit.common.core.dao.BaseDao;
import com.mika.credit.common.entity.report.en.ShareholderInfos;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ShareholderInfosDao extends BaseDao<ShareholderInfos> {

    ShareholderInfos findById(Integer id);

    List<ShareholderInfos> findByFullReportId(Integer fullReportId);
//    int deleteByPrimaryKey(Integer shareid);
//
//    int insert(ShareholderInfos record);
//
//    int insertSelective(ShareholderInfos record);
//
//    ShareholderInfos selectByPrimaryKey(Integer shareid);
//
//    int updateByPrimaryKeySelective(ShareholderInfos record);
//
//    int updateByPrimaryKeyWithBLOBs(ShareholderInfos record);
//
//    int updateByPrimaryKey(ShareholderInfos record);
}