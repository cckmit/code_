package com.mika.credit.web.globalsearch.controller.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.ChnCodes;
import com.mika.credit.facade.admin.service.ChnCodesService;
import com.mika.credit.facade.index.bean.Company;
import com.mika.credit.facade.index.bean.QueryENByName;
import com.mika.credit.facade.index.bean.QueryENByProduct;
import com.mika.credit.facade.index.service.CompanyIndexService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Controller
public class SearchController {
	private static final Logger logger = Logger.getLogger(SearchController.class);
	@Autowired
	private CompanyIndexService companyIndexService;
	@Autowired
	private ChnCodesService chnCodesService;

	/**
	 * 索引 二次搜索
//	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/searchCompanyList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String searchCompanyList( HttpServletRequest request,String companyName,String type,String province,String status,String exIm,String provinceProduct,String scale,String statusProduct,String productAandV,BootGrid<Company> bootGrid) {
		logger.info("调用索引开始...");
		QueryENByName queryENByName=new QueryENByName();
		QueryENByProduct queryENByProduct=new QueryENByProduct();
		if(companyName==null||companyName.equals("")||type==null||type.equals("")){
			BootGrid<Company> result = new BootGrid<Company>();
			result.setResult(false);
			result.setResultDes("Conditions and the company name cannot be empty.");
			return JSON.toJSONString(result);
	    }else {
			BootGrid<Company> indexResult = null;
			if (type.equals("Companies")) {
				boolean matches = companyName.matches("^[^_IOZSVa-z\\W]{2}\\d{6}[^_IOZSVa-z\\W]{5,10}$");
				if (matches){
					queryENByName.setReg(companyName);
				}else {
					queryENByName.setNameEN(companyName);
				}
				queryENByName.setProvince(province);
				queryENByName.setStatus(status);
				queryENByName.setExIm(exIm);
				indexResult = companyIndexService.fillCompanyIndexENByName(bootGrid,queryENByName,true);
				return JSON.toJSONString(indexResult);
			} else {
					if (productAandV.equals("3")){
						queryENByProduct.setA(1);
						queryENByProduct.setV(1);
					}
					if (productAandV.equals("1")){
						queryENByProduct.setA(1);
					}
					if (productAandV.equals("2")){
						queryENByProduct.setV(1);
					}
				queryENByProduct.setProvince(provinceProduct);
				queryENByProduct.setScale(scale);
				queryENByProduct.setStatus(statusProduct);
				queryENByProduct.setProductLabel(companyName);
				indexResult = companyIndexService.fillCompanyIndexENByProduct(bootGrid,queryENByProduct,true);
//				if (indexResult.getResult()) {
//					map.put("companiesInfo", indexResult);
//					map.put("companyName", companyName);
//					result.setCode(true);
//					result.setMsg("Successful operation");
//					result.setContent(map);
//				} else {
//					result.setCode(false);
//					result.setMsg("Operation failure");
//				}
			}
			return JSON.toJSONString(indexResult);
		}
    }
	@RequestMapping(value = "/searchList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String searchList(@RequestBody ChnCodes chnCodes) {
        ResponseResult<ChnCodes> result = chnCodesService.findChnCodes(chnCodes);
        return JSON.toJSONString(result);
    }
}