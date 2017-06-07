package com.mika.credit.facade.admin.dao.admin;


import com.mika.credit.facade.admin.model.CorpType;

import java.util.List;

/**
 * Created by credit on 2017/3/16.
 */
public interface CorpTypeMapper {
    CorpType queryById(String id);
    List<CorpType> queryList(CorpType corpType);
    List<CorpType> queryAll();
    int save(CorpType corpType);
    int update(CorpType corpType);
    int updateByIdSelective(CorpType corpType);
    int deleteById(String id);
    int delete(CorpType corpType);
}
