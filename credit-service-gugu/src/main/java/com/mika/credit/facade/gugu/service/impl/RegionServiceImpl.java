package com.mika.credit.facade.gugu.service.impl;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.gugu.dao.CityCodeMapper;
import com.mika.credit.facade.gugu.dao.CountryCodeMapper;
import com.mika.credit.facade.gugu.dao.DistrictCodeMapper;
import com.mika.credit.facade.gugu.dao.ProvinceCodeMapper;
import com.mika.credit.facade.gugu.model.CityCode;
import com.mika.credit.facade.gugu.model.CountryCode;
import com.mika.credit.facade.gugu.model.DistrictCode;
import com.mika.credit.facade.gugu.model.ProvinceCode;
import com.mika.credit.facade.gugu.service.RegionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mike on 2017/4/13.
 */

@Service("regionService")
public class RegionServiceImpl implements RegionService {

    private static Logger logger = Logger.getLogger(RegionService.class);

    @Autowired
    private CityCodeMapper cityCodeMapper;

    @Autowired
    private CountryCodeMapper countryCodeMapper;

    @Autowired
    private ProvinceCodeMapper provinceCodeMapper;

    @Autowired
    private DistrictCodeMapper districtCodeMapper;

    @Override
    public String getRegionList(String data) {
        logger.debug("进入获取国、省、市、区地区代码的方法！");
        ResponseResult<List> responseResult = new ResponseResult<>();

        List countryList = countryCodeMapper.selectByPrimaryKeySelective(new CountryCode());
        List provinceList = provinceCodeMapper.selectByPrimaryKeySelective(new ProvinceCode());
        List cityList = cityCodeMapper.selectByPrimaryKeySelective(new CityCode());
        List districtList = districtCodeMapper.selectByPrimaryKeySelective(new DistrictCode());
        Map map = new HashMap<>();
        map.put("country", countryList);
        map.put("province", provinceList);
        map.put("city", cityList);
        map.put("district", districtList);
        List result = new ArrayList<>();
        result.add(map);

        responseResult.setContent(result);
        responseResult.setCode(true);
        responseResult.setMsg("获取地区代码成功");

        logger.info("获取国、省、市、区地区代码方法的返回结果："+ JSON.toJSONString(responseResult));
        return JSON.toJSONString(responseResult);
    }
}