package test;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.report.en.FullReport;
import com.mika.credit.common.entity.report.en.UCCs;
import com.mika.credit.facade.front.en.dao.*;
import com.mika.credit.facade.front.en.service.FullReportServiceEN;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-dubbo-provider.xml" ,"classpath:spring-mybatis.xml"})
public class TestFrontEN {

private static final Logger logger = Logger.getLogger(TestFrontEN.class);

	@Autowired
	FullReportServiceEN fullReportServiceEN;
	@Autowired
	BankInfosDao bankInfosDao;
	@Autowired
	BasicInfosDao basicInfosDao;
	@Autowired
	ChangeInfosDao changeInfosDao;
	@Autowired
	FinancialFiguresDao financialFiguresDao;
	@Autowired
	FinancialStatementDao financialStatementDao;
	@Autowired
	HistoryInfosDao historyInfosDao;
	@Autowired
	IdentificationDao identificationDao;
	@Autowired
	LegalInfosDao legalInfosDao;
	@Autowired
	UCCsDao uCCsDao;






	@Test
	public void fullReport() throws RemoteException {
		FullReport fullReport = new FullReport();
		fullReport.setName("ROYAL DUTCH SHELL PLC");
		fullReport.setCompanyNo("US023/X/US29440147");
		String a=fullReportServiceEN.getSafeReport(fullReport);
		System.out.println("----------------------------------");
		System.out.println(a);
	}

	@Test
	public void test() throws RemoteException {
		List<UCCs> financialStatementList = new ArrayList<>();
		UCCs bankInfos = new UCCs();
		bankInfos.setFullReportId(123);
		bankInfos.setCrefoNo("123456");
		bankInfos.setDelFlag("1");
		financialStatementList.add(bankInfos);
		int success = uCCsDao.insert(financialStatementList);
		System.out.println(success);

	}



}
