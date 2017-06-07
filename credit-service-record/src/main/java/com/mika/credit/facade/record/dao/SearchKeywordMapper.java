package com.mika.credit.facade.record.dao;

import com.mika.credit.facade.record.model.SearchKeyword;
import com.mika.credit.facade.record.model.SearchKeywordQuery;

import java.util.List;

public interface SearchKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SearchKeyword searchKeyword);

    int insertSelective(SearchKeyword searchKeyword);

    SearchKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SearchKeyword searchKeyword);

    int updateByPrimaryKey(SearchKeyword searchKeyword);

    List<SearchKeyword> selectByPrimaryKeySelective(SearchKeyword searchKeyword);

    List<SearchKeywordQuery> selectByPrimaryKeySelectiveQuery(SearchKeywordQuery searchKeywordQuery);

    int selectCountSelective(SearchKeywordQuery searchKeywordQuery);

}