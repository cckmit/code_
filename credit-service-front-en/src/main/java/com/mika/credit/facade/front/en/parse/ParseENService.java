package com.mika.credit.facade.front.en.parse;


import com.creditsafe.globaldata.datatypes.reports.LtdCompanyFullReport;
import com.mika.credit.common.entity.report.en.FullReport;

public interface ParseENService {

    FullReport parseDate(LtdCompanyFullReport report, Integer fullReportId);

}