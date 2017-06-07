package com.mika.credit.web.globaleagle.controller.core.nomal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.creditsafe.globaldata.datatypes.CompaniesList;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.HttpUtil;
import com.mika.credit.facade.front.en.service.CompaniesService;
import com.mika.credit.facade.globaleagle.core.model.Country;
import com.mika.credit.facade.globaleagle.core.service.CountryService;
import com.mika.credit.facade.index.bean.Company;
import com.mika.credit.facade.index.service.CompanyIndexService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mike on 2017/2/6.
 */
@Controller
public class SearchController {
    private static Logger logger = Logger.getLogger(SearchController.class);
    @Autowired
    private CountryService countryService;

    @Autowired
    private CompaniesService companiesService;

    @Autowired
    private CompanyIndexService companyIndexService;
    /**
     * 搜索公司 AJAX
     * @param json
     * @return
     */
    @RequestMapping(value = "/searchCompanyList", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String sendCompanyList(@RequestBody String json) {
        logger.info("搜索公司开始...");
        JSONObject jsonObject = JSON.parseObject(json);
        String countryName = jsonObject.getString("countryName");
        String companyName = jsonObject.getString("companyName");
        String companyRName = jsonObject.getString("companyRName");
        if (countryName == null|| countryName.equals("") || companyName == null || companyName.equals("")){
            ResponseResult result = new ResponseResult();
            result.setCode(false);
            result.setMsg("城市名称和公司名称不能为空.");
            return JSON.toJSONString(result);
        } else{
            Map map = new HashMap();
            ResponseResult result = new ResponseResult();
            Country countryInfo = countryService.getCountryByName(countryName);
            if (countryInfo != null) {
                if (countryInfo.getCnName().equals("中国")){
                    BootGrid<Company> indexResult = companyIndexService.fillCompanyIndexSimple(companyName);
                    if (indexResult.getResult()) {
                        map.put("CompaniesInfo", indexResult.getRows());
                        map.put("companyName", companyName);
                        map.put("companyRName", companyRName);
                        map.put("countryName", countryName);
                        map.put("countryNo", countryInfo.getId());
                        result.setCode(true);
                        result.setMsg("操作成功");
                        result.setContent(map);
                    } else{
                        result.setCode(false);
                        result.setMsg("操作失败");
                    }
                } else {
                    ResponseResult<CompaniesList> companiesListResponseResult = new ResponseResult<>();
                    result.setCode(true);
                    result.setMsg("操作成功");
                    try {
//                        http://192.168.1.215:8080/safe/queryCompanyByName.do?countryCode=BE&companyName=Adidas
                        String url = "http://192.168.1.215:8080/safe/queryCompanyByName.do?countryCode="+countryInfo.getCode()+"&companyName="+companyName;
                        String data = HttpUtil.syncData(url);
//                        companiesListResponseResult = companiesService.requestCompaniesByCountryCodeAndCompanyName(countryInfo.getCode(), companyName);
                        CompaniesList companiesList = JSONObject.parseObject(data,CompaniesList.class);
                        companiesListResponseResult.setContent(companiesList);
                    } catch (Exception e) {
                        result.setCode(false);
                        result.setMsg("操作失败");
                        e.printStackTrace();
                    }
                    map.put("CompaniesInfo", companiesListResponseResult.getContent().getCompanies().getCompany());
                    map.put("companyName", companyName);
                    map.put("companyRName", companyRName);
                    map.put("countryName", countryName);
                    map.put("countryNo", countryInfo.getId());
                    result.setContent(map);
                }
            }
            return JSON.toJSONString(result);
        }
    }

}
