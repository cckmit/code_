package com.mika.credit.facade.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.admin.model.Country;

import java.util.List;

/**
 * Country接口
 * Created by mika on 2016/10/9.
 * @author dhl007
 */
public interface CountryService {

	/**
	 * 查询所有国家信息
	 * @return 返回BootGrid类型，进行分页显示
	 */
	BootGrid<Country> getCountries();

	/**
	 *条件查询国家信息
	 * @param record Country查询条件
	 * @return 分页显示
	 */
	BootGrid<Country> getCountries(Country record);

	/**
	 *关键字查询国家信息
	 * @param keyword 关键字模糊查询
	 * @param pageSize 当前页码
	 * @return  查询的结果
	 */
	List<Country> getCountriesSuggest(String keyword, Integer pageSize);

	/**
	 * 通过洲查国家数量
	 * @param id 洲的id
	 * @return 查询数量
	 */
	int selectCountByContinent(Integer id);

	/**
	 * 通过洲查国家信息
	 * @param id 洲的id
	 * @return 对应所有国家信息
	 */
	List<Country> selectCountryByContinentId(Integer id);

	/**
	 * 合并国家信息
	 * @param record Country的信息
	 * @return 添加或修改是否成功
	 */
	int merge(Country record);

	/**
	 * 添加国家信息
	 * @param record Country的信息
	 * @return 添加是否成功
	 */
	int add(Country record);

	/**
	 * 修改国家信息
	 * @param record Country的信息
	 * @return 修改是否成功
	 */
	int modify(Country record);

	/**
	 * 删除国家信息
	 * @param id Country的id
	 * @return 删除是否成功
	 */
	int remove(Integer id);

	/**
	 * 找的到id就返回id相应的Country 否则返回其他
	 * @param id 需要查找的id
	 * @return 查找的国家信息
	 */
	Country getCountryById(int id);

	/**
	 * 找的到name就返回name相应的Country 否则返回其他
	 * @param name 需要查找的name
	 * @return 查找的国家信息
	 */
	Country getCountryByName(String name);
}
