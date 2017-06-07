package com.mika.credit.facade.globaleagle.core.service.impl;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.globaleagle.core.dao.CountryMapper;
import com.mika.credit.facade.globaleagle.core.model.Country;
import com.mika.credit.facade.globaleagle.core.service.CountryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("countryService")
public class CountryServiceImpl implements CountryService {

	private static Logger logger = Logger.getLogger(CountryServiceImpl.class);
	@Autowired
	private CountryMapper countryMapper;

	/**
	 * 查询所有国家信息
	 * @return
	 */
	@Override
	public BootGrid<Country> getCountries() {
		logger.info("查询所有国家信息方法开始...");
		BootGrid<Country> result = new BootGrid<>();
		result.setTotal(countryMapper.selectAllCount());
		result.setRows(countryMapper.selectAll());
		result.setResult(true);
		return result;
	}

	/**
	 * 条件查询国家信息
	 * @param record
	 * @return
	 */
	@Override
	public BootGrid<Country> getCountries(Country record) {
		logger.info("条件查询国家信息方法开始...");
		BootGrid<Country> result = new BootGrid<>();
		result.setRows(countryMapper.selectSelective(record));
		result.setResult(true);
		return result;
	}

	/**
	 * 关键字查询国家信息
	 * @param keyword
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Country> getCountriesSuggest(String keyword, Integer pageSize) {
		logger.info("关键字查询国家信息方法开始...");
		Map map = new HashMap();
		map.put("keyword", keyword);
		map.put("pageSize", pageSize);
		List<Country> result = countryMapper.selectSuggest(map);
		return result;
	}

	/**
	 * 通过洲查国家数量
	 * @param id
	 * @return
	 */
	@Override
	public int selectCountByContinent(Integer id) {
		logger.info("通过洲查询国家数量方法开始...");
		return countryMapper.selectCountByContinent(id);
	}

	/**
	 * 过洲查国家信息
	 * @param id
	 * @return
	 */
	@Override
	public List<Country> selectCountryByContinentId(Integer id) {
		logger.info("通过洲查询国家信息方法开始...");
		return countryMapper.selectByContinentId(id);
	}

	/**
	 * 合并国家信息
	 * @param record
	 * @return
	 */
    @Override
    public int merge(Country record) {
		logger.info("合并国家信息方法开始...");
        Integer id = record.getId();
        if(id == null || id.intValue() == 0){
            return add(record);
        }else {
            return modify(record);
        }
    }

	/**
	 * 添加国家信息
	 * @param record
	 * @return
	 */
    @Override
    public int add(Country record) {
		logger.info("添加国家信息方法开始...");
        return countryMapper.insert(record);
    }

	/**
	 * 修改国家信息
	 * @param record
	 * @return
	 */
    @Override
    public int modify(Country record) {
		logger.info("修改国家信息方法开始...");
        return countryMapper.updateByPrimaryKey(record);
    }

	/**
	 * 删除国家信息
	 * @param id
	 * @return
	 */
    @Override
    public int remove(Integer id) {
		logger.info("删除国家信息方法开始...");
        return countryMapper.deleteByPrimaryKey(id);
    }


	/**
	 * 找的到id就返回id相应的Country 否则返回其他
	 * @param id
	 * @return
	 */
	@Override
	public Country getCountryById(int id){
		logger.info("找的到id就返回id相应的Country 否则返回其他方法开始...");
		List<Country> countryAll = countryMapper.selectAll();
		Country elseCountry = null;
		for (Country country:countryAll) {
			if (country.getId()==id) {
				return country;
			}else if(country.getId()==247){
				elseCountry = country;
			}
		}
		return elseCountry;
	}
	/**
	 * 找的到name就返回name相应的Country 否则返回其他
	 * @param name
	 * @return
	 */
	@Override
	public Country getCountryByName(String name){
		logger.info("找的到name就返回name相应的Country 否则返回其他方法开始...");
		List<Country> countryAll = countryMapper.selectAll();
		Country elseCountry = null;
		for (Country country:countryAll) {
			if (country.getCnName().equals(name) || country.getEnName().equals(name)) {
				return country;
			}else if(country.getId()==247){
				elseCountry = country;
			}
		}
		return elseCountry;
	}
}
