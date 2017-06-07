package com.mika.credit.web.globaleagle.controller.core.nomal;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.globaleagle.core.model.Continent;
import com.mika.credit.facade.globaleagle.core.model.Country;
import com.mika.credit.facade.globaleagle.core.service.ContinentService;
import com.mika.credit.facade.globaleagle.core.service.CountryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class CountryController {
	private static Logger logger = Logger.getLogger(CountryController.class);
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
		logger.info("查询国家信息开始...");
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
	@RequestMapping(value = "/manager/countryList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String managerCountryList(BootGrid<Country> grid, Country condition) {
		logger.info("查询国家信息开始...");
		grid = countryService.getCountries(condition);
		String json = JSON.toJSONString(grid);
		return json;
	}

	/**
	 * 根据ID获取国家信息 AJAX
	 * @param id
	 * @return
	 */
    @RequestMapping(value = "/manager/getCountry",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerGetCountry(Integer id) {
		logger.info("根据id获取国家信息开始...");
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
    @RequestMapping(value = "/manager/countrySave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerCountrySave(BootGrid<Country> grid, Country country) {
		logger.info("保存国家信息开始...");
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
    @RequestMapping(value = "/manager/countryDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerCountryDel(BootGrid<Country> grid, Integer id) {
		logger.info("删除国家信息开始...");
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
	@RequestMapping(value = "/manager/continentList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String managerContinentList() {
		logger.info("查询区域信息开始...");
		BootGrid<Continent> grid = continentService.getContinents();
		return JSON.toJSONString(grid);
	}

	/**
	 * 保存区域信息
	 * @param grid
	 * @param continent
	 * @return
	 */
	@RequestMapping(value = "/manager/continentSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String managerContinentSave(BootGrid<Continent> grid, Continent continent) {
		logger.info("保存区域信息开始...");
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
	@RequestMapping(value = "/manager/continentDel",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String managerContinentDel(BootGrid<Continent> grid, Integer id) {
		logger.info("删除区域信息开始...");
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