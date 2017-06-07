package com.mika.credit.facade.front.en.service.impl;

import com.alibaba.fastjson.JSON;
import com.creditsafe.globaldata.datatypes.*;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.front.en.Util.PossibleSearchCriteria;
import com.mika.credit.facade.front.en.service.CompaniesService;
import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.creditsafe.ArrayOfCountryCode;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mika on 2016/5/19.
 */
@Service("companiesService")
public class CompaniesServiceImpl extends BaseCreditSafeServiceImpl implements CompaniesService {

    private static Logger logger = Logger.getLogger(CompaniesServiceImpl.class);


    public CompaniesList requestCompanies(List<CountryCode> countryCodes, SearchCriteria searchCriteria, CustomData customData, String chargeReference) throws RemoteException {
        ArrayOfCountryCode arrayOfCountryCode = new ArrayOfCountryCode();
        arrayOfCountryCode.setCountryCode(countryCodes);
        CompaniesList companiesList = JSON.parseObject(JSON.toJSONString( getGlobalDataService().findCompanies(arrayOfCountryCode, searchCriteria, customData, chargeReference)),CompaniesList.class);
        return companiesList;
    }


    public CompaniesList requestCompaniesByCountryCodeAndCompanyName(CountryCode countryCode, String companyName) throws RemoteException {
        List<CountryCode> countryCodes = new ArrayList<CountryCode>();
        countryCodes.add(countryCode) ;
        QueryString queryString = new QueryString();
        queryString.setValue(companyName);
        queryString.setMatchType(PossibleSearchCriteria.criteria.get(countryCode));
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setName(queryString);
        CompaniesList companiesList =  requestCompanies(countryCodes, searchCriteria, new CustomData(), "");
        return companiesList;
    }

    public ResponseResult<CompaniesList> requestCompaniesByCountryCodeAndCompanyName(String strCountryCode, String companyName) throws RemoteException {
        logger.debug("requestCompaniesByCountryCodeAndCompanyName 开始");
        logger.debug("strCountryCode = "+ strCountryCode + " companyName = " + companyName);
        ResponseResult<CompaniesList> result = new ResponseResult<>();
        String msg = "";
        if(strCountryCode == null){
            msg += "城市编码不能为空";
        }
        if(companyName == null){
            msg += "公司名称不能为空";
        }
        CountryCode countryCode = CountryCode.fromValue(strCountryCode);
        if(countryCode == null){
            msg += "城市编码不正确";
        }
        if(!msg.equals("")){
            result.setCode(false);
            result.setMsg(msg);
            result.setContent(null);
            logger.info("requestCompaniesByCountryCodeAndCompanyName 方法参数错误" + msg);
            logger.debug("requestCompaniesByCountryCodeAndCompanyName 结束");
            return result;
        }
        CompaniesList companiesList = requestCompaniesByCountryCodeAndCompanyName(countryCode, companyName);
        if(companiesList == null){
            result.setCode(false);
            result.setMsg("数据获取失败");
            result.setContent(null);
            logger.info("requestCompaniesByCountryCodeAndCompanyName 远程获取creditsafe接口数据失败" + msg);
        }
        else {
            result.setCode(true);
            result.setMsg("");
            result.setContent(companiesList);
            logger.info("requestCompaniesByCountryCodeAndCompanyName 远程获取creditsafe接口数据成功" + msg);
        }
        logger.debug("requestCompaniesByCountryCodeAndCompanyName 结束");
        return result;
    }


    public CompaniesList requestCompaniesByCountryCodeAndId(CountryCode countryCode, String id) throws RemoteException {
        List<CountryCode> countryCodes = new ArrayList<CountryCode>();
        countryCodes.add(countryCode) ;
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setId(id);
        CompaniesList companiesList =  requestCompanies(countryCodes, searchCriteria, new CustomData(), "");
        return companiesList;
    }

    public ResponseResult<CompaniesList> requestCompaniesByCountryCodeAndId(String strCountryCode, String id) throws RemoteException {
        logger.debug("requestCompaniesByCountryCodeAndId 开始");
        logger.debug("strCountryCode = "+ strCountryCode + " id = " + id);
        ResponseResult<CompaniesList> result = new ResponseResult<>();
        String msg = "";
        if(strCountryCode == null){
            msg += "城市编码不能为空";
        }
        if(id == null){
            msg += "ID不能为空";
        }
        CountryCode countryCode = CountryCode.fromValue(strCountryCode);
        if(countryCode == null){
            msg += "城市编码不正确";
        }
        if(!msg.equals("")) {
            result.setCode(false);
            result.setMsg(msg);
            result.setContent(null);

            logger.info("requestCompaniesByCountryCodeAndId 方法参数错误" + msg);
            logger.debug("requestCompaniesByCountryCodeAndId 结束");
            return result;
        }
        CompaniesList companiesList = requestCompaniesByCountryCodeAndId(countryCode,id);
        if(companiesList == null){
            result.setCode(false);
            result.setMsg("数据获取失败");
            result.setContent(null);
            logger.info("requestCompaniesByCountryCodeAndId 远程获取creditsafe接口数据失败" + msg);
        }
        else {
            result.setCode(true);
            result.setMsg("");
            result.setContent(companiesList);
            logger.info("requestCompaniesByCountryCodeAndId 远程获取creditsafe接口数据成功" + msg);
        }
        logger.debug("requestCompaniesByCountryCodeAndId 结束");
        return result;
    }

    public CompaniesList requestCompaniesByCountryCodeAndVATNumber(CountryCode countryCode, String vatNumber) throws RemoteException {
        List<CountryCode> countryCodes = new ArrayList<CountryCode>();
        countryCodes.add(countryCode) ;
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setVatNumber(vatNumber);
        CompaniesList companiesList =  requestCompanies(countryCodes, searchCriteria, new CustomData(), "");
        return companiesList;
    }

    public ResponseResult<CompaniesList> requestCompaniesByCountryCodeAndVATNumber(String strCountryCode, String vatNumber) throws RemoteException {
        logger.debug("requestCompaniesByCountryCodeAndVATNumber 开始");
        logger.debug("strCountryCode = "+ strCountryCode + " vatNumber = " + vatNumber);
        ResponseResult<CompaniesList> result = new ResponseResult<>();
        String msg = "";
        if(strCountryCode == null){
            msg += "城市编码不能为空";
        }
        if(vatNumber == null){
            msg += "VAT不能为空";
        }
        CountryCode countryCode = CountryCode.fromValue(strCountryCode);
        if(countryCode == null){
            msg += "城市编码不正确";
        }
        if(!msg.equals("")){
            result.setCode(false);
            result.setMsg(msg);
            result.setContent(null);
            logger.info("requestCompaniesByCountryCodeAndVATNumber 方法参数错误" + msg);
            logger.debug("requestCompaniesByCountryCodeAndVATNumber 结束");
            return result;
        }
        CompaniesList companiesList = requestCompaniesByCountryCodeAndVATNumber(countryCode, vatNumber);
        if(companiesList == null){
            result.setCode(false);
            result.setMsg("数据获取失败");
            result.setContent(null);
            logger.info("requestCompaniesByCountryCodeAndVATNumber 远程获取creditsafe接口数据失败" + msg);
        }
        else {
            result.setCode(true);
            result.setMsg("");
            result.setContent(companiesList);
            logger.info("requestCompaniesByCountryCodeAndVATNumber 远程获取creditsafe接口数据成功" + msg);
        }
        logger.debug("requestCompaniesByCountryCodeAndVATNumber 结束");
        return result;
    }

    public CompaniesList requestCompaniesByCountryCodeAndRegistrationNumber(CountryCode countryCode, String registrationNumber) throws RemoteException {
        List<CountryCode> countryCodes = new ArrayList<CountryCode>();
        countryCodes.add(countryCode) ;
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setRegistrationNumber(registrationNumber);
        CompaniesList companiesList =  requestCompanies(countryCodes, searchCriteria, new CustomData(), "");
        return companiesList;
    }

    public ResponseResult<CompaniesList> requestCompaniesByCountryCodeAndRegistrationNumber(String strCountryCode, String registrationNumber) throws RemoteException {
        logger.debug("requestCompaniesByCountryCodeAndRegistrationNumber 开始");
        logger.debug("strCountryCode = "+ strCountryCode + " registrationNumber = " + registrationNumber);
        ResponseResult<CompaniesList> result = new ResponseResult<>();
        String msg = "";
        if(strCountryCode == null){
            msg += "城市编码不能为空";
        }
        if(registrationNumber == null){
            msg += "注册号不能为空";
        }
        CountryCode countryCode = CountryCode.fromValue(strCountryCode);
        if(countryCode == null){
            msg += "城市编码不正确";
        }
        if(!msg.equals("")){
            result.setCode(false);
            result.setMsg(msg);
            result.setContent(null);
            logger.info("requestCompaniesByCountryCodeAndRegistrationNumber 方法参数错误" + msg);
            logger.debug("requestCompaniesByCountryCodeAndRegistrationNumber 结束");
            return result;
        }
        CompaniesList companiesList = requestCompaniesByCountryCodeAndRegistrationNumber(countryCode, registrationNumber);
        if(companiesList == null){
            result.setCode(false);
            result.setMsg("数据获取失败");
            result.setContent(null);
            logger.info("requestCompaniesByCountryCodeAndRegistrationNumber 远程获取creditsafe接口数据失败" + msg);
        }
        else {
            result.setCode(true);
            result.setMsg("");
            result.setContent(companiesList);
            logger.info("requestCompaniesByCountryCodeAndRegistrationNumber 远程获取creditsafe接口数据失败" + msg);
        }
        logger.debug("requestCompaniesByCountryCodeAndRegistrationNumber 结束");
        return result;
    }


    public CompaniesList requestCompanies(CountryCode countryCode, CompanyData companyData) throws RemoteException {
        if(countryCode==null || companyData==null){
           return null;
        }
        List<CountryCode> countryCodes = new ArrayList<CountryCode>();
        countryCodes.add(countryCode) ;
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setId(companyData.getId());
        QueryString queryString = new QueryString();
        queryString.setMatchType(PossibleSearchCriteria.criteria.get(countryCode));
        queryString.setValue(companyData.getName());
        searchCriteria.setName(queryString);
        searchCriteria.setPhoneNumber(companyData.getPhoneNumber());
        searchCriteria.setRegistrationNumber(companyData.getRegistrationNumber());
        searchCriteria.setVatNumber(companyData.getVatNumber());
        if(companyData.getAddress()!=null){
            AddressCriteria addressCriteria = new AddressCriteria();
            addressCriteria.setStreet(companyData.getAddress().getStreet());
            addressCriteria.setCity(companyData.getAddress().getCity());
            addressCriteria.setHouseNumber(companyData.getAddress().getHouseNumber());
            addressCriteria.setProvince(companyData.getAddress().getProvince());
            addressCriteria.setPostalCode(companyData.getAddress().getPostalCode());
            searchCriteria.setAddress(addressCriteria);
        }
        CompaniesList companiesList =  requestCompanies(countryCodes, searchCriteria, new CustomData(), "");
        return companiesList;
    }
}
