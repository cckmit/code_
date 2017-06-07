package com.mika.credit.facade.record.dao;

import com.mika.credit.facade.record.model.CompanyTrack;
import com.mika.credit.facade.record.model.CompanyTrackQuery;

import java.util.List;

public interface CompanyTrackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyTrack companyTrack);

    int insertSelective(CompanyTrack companyTrack);

    CompanyTrack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyTrack companyTrack);

    int updateByPrimaryKeyWithBLOBs(CompanyTrack companyTrack);

    int updateByPrimaryKey(CompanyTrack companyTrack);

    List<CompanyTrack> selectByPrimaryKeySelective(CompanyTrack companyTrack);

    List<CompanyTrackQuery> selectByPrimaryKeySelectiveQuery(CompanyTrackQuery companyTrackQuery);

    int selectCountSelective(CompanyTrackQuery companyTrackQuery);
}