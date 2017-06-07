package test;

import com.mika.credit.facade.front.cn.service.FaHaiInfoService;
import com.mika.credit.facade.front.cn.service.GrandeInfoService;
import com.mika.credit.facade.front.cn.service.HanXinInfoService;
import com.mika.credit.facade.front.cn.service.QianHaiInfoService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.rmi.RemoteException;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-jpa.xml" })
public class TestFrontCN {

private static final Logger logger = Logger.getLogger(TestFrontCN.class);

	@Autowired
	FaHaiInfoService faHaiInfoService;

	@Autowired
	GrandeInfoService grandeInfoService;

	@Autowired
	HanXinInfoService hanXinInfoService;

	@Autowired
	QianHaiInfoService qianHaiInfoService;
	

//	@Test
//	public void testFaHai() throws RemoteException {
//		String method="query";
//		Map param=null;
//		faHaiInfoService.getFahaiData(method,param);
//	}
	

}
