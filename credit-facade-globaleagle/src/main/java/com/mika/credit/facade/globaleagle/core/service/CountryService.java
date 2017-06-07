package com.mika.credit.facade.globaleagle.core.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.globaleagle.core.model.Country;

import java.util.List;

/**
 * Created by mika on 2016/10/9.
 */
public interface CountryService {
	BootGrid<Country> getCountries();

	BootGrid<Country> getCountries(Country record);
	List<Country> getCountriesSuggest(String keyword, Integer pageSize);

	int selectCountByContinent(Integer id);

	List<Country> selectCountryByContinentId(Integer id);

	int merge(Country record);

	int add(Country record);

	int modify(Country record);

	int remove(Integer id);

	Country getCountryById(int id);

	Country getCountryByName(String name);
}
