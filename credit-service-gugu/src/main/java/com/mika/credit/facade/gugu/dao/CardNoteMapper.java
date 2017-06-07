package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.CardNote;

import java.util.List;

public interface CardNoteMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteSelective(CardNote cardNote);

    int insert(CardNote record);

    int insertSelective(CardNote record);

    CardNote selectByPrimaryKey(Integer id);

    List<CardNote> selectByPrimaryKeySelective(CardNote cardNote);

    int updateByPrimaryKeySelective(CardNote record);

    int updateByPrimaryKey(CardNote record);

    int selectCountByType(Integer id);
}