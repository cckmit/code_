package com.mika.credit.facade.admin.dao.ge;

import com.mika.credit.facade.admin.model.Country;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GECountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);

//    @Cacheable(value = "annotationCache")
    List<Country> selectAll();

    @Cacheable(value = "annotationCache", key = "\"pageSelect\"")
    List<Country> selectEabled();
    int selectAllCount();

    List<Country> selectByContinentId(int continentId);

    List<Country> selectSelective(Country record);
    List<Country> selectSuggest(Map map);

    int selectCountByContinent(Integer id);
}