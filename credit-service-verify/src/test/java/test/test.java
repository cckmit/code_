package test;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.facade.gugu.model.BusinessCard;
import com.mika.credit.facade.gugu.model.VerificationResult;
import com.mika.credit.facade.gugu.service.FullReportLocalService;
import com.mika.credit.facade.verify.dao.MobilephoneNameMapper;
import com.mika.credit.facade.verify.impl.testService;
import com.mika.credit.facade.verify.model.MobilephoneName;
import com.mika.credit.facade.verify.service.VerifyInfoService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-mybatis.xml","classpath:spring-dubbo-provider.xml","classpath:spring-dubbo-consumer.xml" })
public class test {

	@Autowired
	private testService testService;

	@Autowired
	private VerifyInfoService verifyInfoService;



	@org.junit.Test
	public void test() {
//        Long startTime = System.currentTimeMillis();
//		Users users = new Users();
//		users.setPwd("asdfsad");
//		users.setAddress("sdf");
//		users.setTel("18621940318");
//		users.setPosition("上啊hi是");
//		users.setUserName("小邓子");
//
//		userService.userRegister(JSON.toJSONString(users));
//        Long entTime = System.currentTimeMillis();
//        System.out.println("耗费时间==="+(entTime-startTime));

    }

	@org.junit.Test
	public void testVerify() {
		String fullReportJson = testFull();
		FullReport fullReport = JSON.parseObject(fullReportJson,FullReport.class);
		Long startTime = System.currentTimeMillis();

		BusinessCard businessCard = new BusinessCard();
		businessCard.setId(4);
		businessCard.setCardCompany("商安信（上海）企业管理咨询股份有限公司");
//		businessCard.setCardEmail("Stenven.yao@3acredit.com");
		businessCard.setCardEmail("info@3ACredit.cn");
//        businessCard.setCardName("姚翔");
		businessCard.setCardName("吴琳玲");
		businessCard.setCardPosition("手机测试");
//        businessCard.setCardAddress("上海虹口区四川北路525号21楼");
		businessCard.setCardAddress("上海市宝山区逸仙路2816号B座12层");
		businessCard.setCardPhone("13774311477");//商安信
		businessCard.setAreaCode("021");
		businessCard.setCardTel("36386226");
		businessCard.setCardWebsite("http://www.3acredit.cn/");
		businessCard.setUserId(8);
		ResponseResult<VerificationResult> verificationResultResponseResult = verifyInfoService.getVerifyInfoModel(businessCard,fullReport);
		Long entTime = System.currentTimeMillis();
		System.out.println("耗费时间==="+(entTime-startTime));

	}

	public static String testFull() {
		InputStream in = null;
		try {
			InputStream stream = new FileInputStream("D:\\Workspaces\\workspace\\credit\\code\\credit-service-verify\\src\\test\\java\\test\\new_test.json");
			if (stream != null) {
				in = new BufferedInputStream(stream);
				byte[] bytes = new byte[1024 * 10];
				int len = 0;
				StringBuilder data = new StringBuilder();
				while ((len = in.read(bytes)) != -1) {
					data.append(new String(bytes, 0, len));
				}
				return data.toString();
			}
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
