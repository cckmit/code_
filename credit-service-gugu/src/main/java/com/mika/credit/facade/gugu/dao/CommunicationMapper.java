package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.Communication;

import java.util.List;

public interface CommunicationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Communication record);

    int insertSelective(Communication record);

    Communication selectByPrimaryKey(Integer id);

    List<Communication> selectByPrimaryKeySelective(Communication communication);


    int updateByPrimaryKeySelective(Communication record);

    int updateByPrimaryKey(Communication record);
}