package com.mika.credit.facade.front.en.service;


import com.creditsafe.globaldata.datatypes.reports.LtdCompanyFullReport;
import com.mika.credit.common.entity.ResponseResult;

import java.rmi.RemoteException;

/**
 * Created by mika on 2016/5/25.
 */
public interface OnlineReportService {

    ResponseResult<LtdCompanyFullReport> checkOnlineReport(String companyId, String companyReportType, String language);

        /**
         * 根据条件查询公司详细信息
         * @param retrieveCompanyOnlineReport 查询条件
         * @return
         * @throws RemoteException
         */
    //CompanyReport requestOnlineReport(RetrieveCompanyOnlineReport retrieveCompanyOnlineReport) throws RemoteException;

    /**
     * 根据条件查询公司详细信息
     * @param companyId 公司id
     * @param companyReportType 报告类型
     * @param language 报告语言
     * @return
     * @throws RemoteException
     */
    //CompanyReport  requestOnlineReport(String companyId, CompanyReportType companyReportType, Language language) throws RemoteException;


    /**
     *
     * @param companyId 公司ID
     * @return
     * @throws RemoteException
     */
    ResponseResult<LtdCompanyFullReport> requestOnlineReport(String companyId, String companyReportType, String language) throws RemoteException;
}
