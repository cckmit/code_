package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.PublicizePhoto;

import java.util.List;

public interface PublicizePhotoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PublicizePhoto record);

    int insertSelective(PublicizePhoto record);

    PublicizePhoto selectByPrimaryKey(Integer id);

    List<PublicizePhoto> selectByPrimaryKeySelective(PublicizePhoto publicizePhoto);

    int updateByPrimaryKeySelective(PublicizePhoto record);

    int updateByPrimaryKey(PublicizePhoto record);
}