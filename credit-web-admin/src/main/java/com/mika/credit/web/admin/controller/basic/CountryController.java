package com.mika.credit.web.admin.controller.basic;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.admin.model.Continent;
import com.mika.credit.facade.admin.model.Country;
import com.mika.credit.facade.admin.service.ContinentService;
import com.mika.credit.facade.admin.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private ContinentService continentService;

	/**
	 * 国家列表 AJAX
	 * @param keyword
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/searchCountry",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public @ResponseBody String searchCountry(String keyword, Integer pageSize) {
		List<Country> result = countryService.getCountriesSuggest(keyword, pageSize);
		String json = JSON.toJSONString(result);
		return json;
	}

	/**
	 * 国家列表 AJAX
	 * @param grid
	 * @param condition
	 * @return
	 */
	@RequestMapping(value = "/basic/countryList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String managerCountryList(BootGrid<Country> grid, Country condition) {
		grid = countryService.getCountries(condition);
		String json = JSON.toJSONString(grid);
		return json;
	}

	/**
	 * 根据ID获取国家信息 AJAX
	 * @param id
	 * @return
	 */
    @RequestMapping(value = "/basic/getCountry",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerGetCountry(Integer id) {
        Country country = countryService.getCountryById(id);
        String json = JSON.toJSONString(country);
        return json;
    }

	/**
	 * 保存国家信息 AJAX
	 * @param grid
	 * @param country
	 * @return
	 */
    @RequestMapping(value = "/basic/countrySave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerCountrySave(BootGrid<Country> grid, Country country) {
        if(countryService.merge(country) > 0){
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

	/**
	 * 删除国家信息 AJAX
	 * @param grid
	 * @param id
	 * @return
	 */
    @RequestMapping(value = "/basic/countryDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerCountryDel(BootGrid<Country> grid, Integer id) {
        if(countryService.remove(id) > 0){
            grid.setResult(true);
        }else{
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

	/**
	 * 区域列表
	 * @return
	 */
	@RequestMapping(value = "/basic/continentList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String managerContinentList() {
		BootGrid<Continent> grid = continentService.getContinents();
		return JSON.toJSONString(grid);
	}

	/**
	 * 保存区域信息
	 * @param grid
	 * @param continent
	 * @return
	 */
	@RequestMapping(value = "/basic/continentSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String managerContinentSave(BootGrid<Continent> grid, Continent continent) {
		if(continentService.merge(continent) > 0){
			grid = continentService.getContinents();
			grid.setResult(true);
		}else{
			grid.setResult(false);
		}
		return JSON.toJSONString(grid);
	}

	/**
	 * 删除区域信息
	 * @param grid
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/basic/continentDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String managerContinentDel(BootGrid<Continent> grid, Integer id) {
		//校验是否有下属国家，如果有，不允许删除
		int count = countryService.selectCountByContinent(id);
		if(count > 0){
			grid.setResult(false);
			grid.setResultDes("该区域下还包含" + count + "个国家，不允许删除！");
			return JSON.toJSONString(grid);
		}
		if(continentService.remove(id) > 0){
			grid = continentService.getContinents();
			grid.setResult(true);
		}else{
			grid.setResult(false);
		}
		return JSON.toJSONString(grid);
	}

}