package com.mika.credit.facade.front.en.service;


import com.creditsafe.globaldata.datatypes.CompaniesList;
import com.mika.credit.common.entity.ResponseResult;

import java.rmi.RemoteException;

/**
 * Created by mika on 2016/5/23.
 */
public interface CompaniesService {

    /**
     * 根据条件查公司信息
     * @param countryCodes 城市编号
     * @param searchCriteria 查询条件
     * @param customData
     * @param chargeReference
     * @return
     * @throws RemoteException
     */
    //CompaniesList requestCompanies(List<CountryCode> countryCodes, SearchCriteria searchCriteria, CustomData customData, String chargeReference) throws RemoteException;

    /**
     * 根据条件查公司信息
     * @param countryCode 城市编号
     * @param companyName 公司名称
     * @return
     * @throws RemoteException
     */
    //CompaniesList requestCompaniesByCountryCodeAndCompanyName(CountryCode countryCode, String companyName) throws RemoteException;


    /**
     * 根据条件查公司信息
     * @param strCountryCode 城市编号
     * @param companyName 公司名称
     * @return
     * @throws RemoteException
     */
    ResponseResult<CompaniesList> requestCompaniesByCountryCodeAndCompanyName(String strCountryCode, String companyName) throws RemoteException;

    /**
     * 根据条件查公司信息
     * @param countryCode 城市编号
     * @param id 公司id
     * @return
     * @throws RemoteException
     */
    //CompaniesList requestCompaniesByCountryCodeAndId(CountryCode countryCode, String id) throws RemoteException;

    /**
     * 根据条件查公司信息
     * @param strCountryCode 城市编号
     * @param id 公司id
     * @return
     * @throws RemoteException
     */
    ResponseResult<CompaniesList> requestCompaniesByCountryCodeAndId(String strCountryCode, String id) throws RemoteException ;

        /**
         * 根据条件查公司信息
         * @param countryCode 城市编号
         * @param companyData 查询条件
         * @return
         * @throws RemoteException
         */
    //CompaniesList requestCompanies(CountryCode countryCode, CompanyData companyData) throws RemoteException;

    /**
     * 根据条件查公司信息
     * @param countryCode 城市编号
     * @param vatNumber VAT号
     * @return
     * @throws RemoteException
     */
    //CompaniesList requestCompaniesByCountryCodeAndVATNumber(CountryCode countryCode, String vatNumber) throws RemoteException ;

    /**
     * 根据条件查公司信息
     * @param strCountryCode 城市编号
     * @param vatNumber VAT号
     * @return
     * @throws RemoteException
     */
    ResponseResult<CompaniesList> requestCompaniesByCountryCodeAndVATNumber(String strCountryCode, String vatNumber) throws RemoteException;

        /**
         * 根据条件查公司信息
         * @param countryCode 城市编号
         * @param registrationNumber 注册号
         * @return
         * @throws RemoteException
         */
    //CompaniesList requestCompaniesByCountryCodeAndRegistrationNumber(CountryCode countryCode, String registrationNumber) throws RemoteException ;
    /**
     * 根据条件查公司信息
     * @param strCountryCode 城市编号
     * @param registrationNumber 注册号
     * @return
     * @throws RemoteException
     */
    ResponseResult<CompaniesList> requestCompaniesByCountryCodeAndRegistrationNumber(String strCountryCode, String registrationNumber) throws RemoteException;


    }
