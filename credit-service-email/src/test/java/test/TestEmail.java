package test;


import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetail;
import com.mika.credit.common.entity.order.OrderDetailView;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.common.entity.order.QuickOrder;
import com.mika.credit.facade.email.service.EmailService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-core.xml","classpath:spring-mybatis.xml"})
public class TestEmail {

private static final Logger logger = Logger.getLogger(TestEmail.class);

	@Autowired
    EmailService emailService;

//	@Test
//	public void emailTest(){
//		MailSenderInfo email = new MailSenderInfo();
//		email.setContent("<p>您订购的报告已发送至邮箱</p>");
//		email.setToAddress("michael.shen@3acredit.cn");
//		email.setFromAddress("123");
//		email.setPassword("123321");
//		email.setCopyToAddress("jackZhu@qq.com");
//		ResponseResult result = emailService.sendEmail(email,"globalEagle");
//		logger.debug(result);
//		logger.error("转码出错了!");
//	}
//
//
//	//@Test
//	public void emailParameterTest(){
//		String receiverEmail = "408623618@qq.com";
//		String content = "<p>您好</p><p>您订购的报告收到了吗?</p><a href=\"www.baidu.com\" >点我有惊喜！</a>";
//		ResponseResult result = emailService.sendEmailParameter(receiverEmail,content,"globalEagle");
//		logger.debug(result);
//		logger.error("转码出错了!");
//	}

//	@Test
//	public void emailGETest(){
//		EmailData email = new EmailData();
//
//		email.setDataToAddress("408623618@qq.com");
//		email.setDataCopyToAddress("jack.zhu@3acredit.com");
//		email.setDataUrl("http://www.global-eagle.cn/toResetPW.do?email=137238131@qq.com");
//		Orders orders = new Orders();
//		orders.setNo("123456");
//		orders.setCreateTime(new Date());
//		orders.setCustomerEmail("408623618@qq.com");
//		List<OrderDetail> orderDetails = new ArrayList<>();
//		OrderDetail orderDetail = new OrderDetail();
//		BigDecimal price =new BigDecimal("999");
//		BigDecimal priceActual =new BigDecimal("2999");
//		orderDetail.setCountryName("中国");
//		orderDetail.setCompanyName("Oracle");
//		orderDetail.setProductId(1);
//		orderDetail.setPrice(price);
//		orderDetail.setRemark("请查收");
//		orders.setAmountActual(priceActual);
//		orderDetails.add(orderDetail);
//
//		orders.setOrderDetails(orderDetails);
//
//		email.setEntity(orders);
//
//		orders.setOrderDetails(orderDetails);
//		ResponseResult result = emailService.sendEmail(2,email);
//		System.out.println("result--------> "+result.getMsg());
//		logger.debug(result.getMsg());
//	}

	@Test
	public void sendEmailApproveSuccessTest(){
		Map<String,Object> mapData = new HashedMap();
//		OrderDetailView orderDetailView = new OrderDetailView();
//		orderDetailView.setCompanyName("商安信");
//		orderDetailView.setCountryName("中国");
//		orderDetailView.setCreateTime(new Date());
//		orderDetailView.setOrderNo("112233");
//		orderDetailView.setRemark("报告需打印");
//		orderDetailView.setFinishTime(new Date());
//		QuickOrder quickOrder = new QuickOrder();
//		quickOrder.setNo("123456");
//		quickOrder.setCreateTime(new Date());
//		quickOrder.setRemark("请查收");
//		quickOrder.setCompanyCountry("中国");
//		quickOrder.setCompanyName("商安信");
//		Orders orders = new Orders();
//		orders.setCreateTime(new Date());
//		orders.setNo("123456");
//		orders.setRemark("请查收");
//		BigDecimal amountActual = new BigDecimal("1999");
//		orders.setAmountActual(amountActual);
//
//		BigDecimal price = new BigDecimal("199");
//
//		OrderDetail orderDetail = new OrderDetail();
//		orderDetail.setCountryName("中国");
//		orderDetail.setProductId(3);
//		orderDetail.setCompanyName("商安信");
//		orderDetail.setPrice(price);
//		OrderDetail orderDetail1 = new OrderDetail();
//		orderDetail1.setCountryName("美国");
//		orderDetail1.setProductId(4);
//		orderDetail1.setCompanyName("Oracle");
//		orderDetail1.setPrice(price);
//		List<OrderDetail> orderDetailsList = new ArrayList<>();
//		orderDetailsList.add(orderDetail);
//		orderDetailsList.add(orderDetail1);
//		orders.setOrderDetails(orderDetailsList);

//		String ordersJsonObj = (String) JSONObject.toJSONString(orders);
//		System.out.println(ordersJsonObj);
//		String url = "http://www.global-eagle.cn/toResetPW.do?email=137238131@qq.com";
//		String quickOrderObj = (String) JSONObject.toJSONString(quickOrder);
//		mapData.put("quickOrder",quickOrderObj);
//		String orderDetailViewObj = (String) JSONObject.toJSONString(orderDetailView);
//		System.out.println(orderDetailViewObj);
//		mapData.put("orderDetailView",orderDetailViewObj);
//		Orders orders = new Orders();
//		orders.setCreateTime(new Date());
//		orders.setNo("123456");
//		orders.setRemark("请查收");
//		BigDecimal amountActual = new BigDecimal("1999");
//		orders.setAmountActual(amountActual);
//		String ordersJsonObj = (String) JSONObject.toJSONString(orders);
//		mapData.put("orders",ordersJsonObj);
//		mapData.put("quickOrder",quickOrderObj);
//		mapData.put("toAddress","fan1046625003@outlook.com");
		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
//		mapData.put("orders",ordersJsonObj);
//		mapData.put("url",url);
//		mapData.put("orders",ordersJsonObj);
//		mapData.put("url",url);
//		mapData.put("url","http://www.global-eagle.cn/toResetPW.do?email=137238131@qq.com");
//		mapData.put("orders",ordersJsonObj);
		ResponseResult result = emailService.sendEmail("globalEagle","approveSuccess",mapData);
//		ResponseResult result = emailService.sendEmail("globalSearch","registerEN",mapData);
//		System.out.println(result.getMsg());
	}

	@Test
	public void sendEmailCancelTest(){
		Map<String,Object> mapData = new HashedMap();
		Orders orders = new Orders();
		orders.setCreateTime(new Date());
		orders.setNo("123456");
		orders.setRemark("请查收");
		BigDecimal amountActual = new BigDecimal("1999");
		orders.setAmountActual(amountActual);
		String ordersJsonObj = (String) JSONObject.toJSONString(orders);
		mapData.put("orders",ordersJsonObj);
//		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("toAddress","fanxuqing41@163.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalEagle","cancel",mapData);
	}

	@Test
	public void sendEmailCountTest(){
		Map<String,Object> mapData = new HashedMap();
		mapData.put("toAddress","fanxuqing41@163.com");
//		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalEagle","count",mapData);
	}

	@Test
	public void sendEmailFastOrderTest(){
		Map<String,Object> mapData = new HashedMap();
		QuickOrder quickOrder = new QuickOrder();
		quickOrder.setNo("123456");
		quickOrder.setCreateTime(new Date());
		quickOrder.setRemark("请查收");
		quickOrder.setCompanyCountry("中国");
		quickOrder.setCompanyName("商安信");
		String quickOrderObj = (String) JSONObject.toJSONString(quickOrder);
		mapData.put("quickOrder",quickOrderObj);
		mapData.put("toAddress","fan1046625003@aliyun.com");
//		mapData.put("toAddress","1046625003@qq.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalEagle","fastOrder",mapData);
	}

	@Test
	public void sendEmailForgetTest(){
		Map<String,Object> mapData = new HashedMap();
		String url = "http://www.global-eagle.cn/toResetPW.do?email=137238131@qq.com";
		mapData.put("url",url);
//		mapData.put("toAddress","fanxuqing41@163.com");
		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalEagle","forget",mapData);
	}

	@Test
	public void sendEmailOrderTest(){
		Map<String,Object> mapData = new HashedMap();
		Orders orders = new Orders();
		orders.setCreateTime(new Date());
		orders.setNo("123456");
		orders.setRemark("请查收");
		BigDecimal amountActual = new BigDecimal("1999");
		orders.setAmountActual(amountActual);

		BigDecimal price = new BigDecimal("199");

		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCountryName("中国");
		orderDetail.setProductId(3);
		orderDetail.setCompanyName("商安信");
		orderDetail.setPrice(price);
		OrderDetail orderDetail1 = new OrderDetail();
		orderDetail1.setCountryName("美国");
		orderDetail1.setProductId(4);
		orderDetail1.setCompanyName("Oracle");
		orderDetail1.setPrice(price);
		List<OrderDetail> orderDetailsList = new ArrayList<>();
		orderDetailsList.add(orderDetail);
		orderDetailsList.add(orderDetail1);
		orders.setOrderDetails(orderDetailsList);
		String ordersJsonObj = (String) JSONObject.toJSONString(orders);
		mapData.put("orders",ordersJsonObj);
//		mapData.put("toAddress","fan1046625003@outlook.com");
		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalEagle","order",mapData);
	}

	@Test
	public void sendEmailRegisterTest(){
		Map<String,Object> mapData = new HashedMap();
//		mapData.put("toAddress","fan1046625003@outlook.com");
		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalEagle","register",mapData);
	}


	@Test
	public void sendEmailReportTest(){
		Map<String,Object> mapData = new HashedMap();
		String url = "http://www.global-eagle.cn/toResetPW.do?email=137238131@qq.com";
		mapData.put("url",url);
//		mapData.put("toAddress","fan1046625003@outlook.com");
		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalEagle","report",mapData);
	}

	@Test
	public void sendEmailReportSuccessTest(){
		Map<String,Object> mapData = new HashedMap();
		OrderDetailView orderDetailView = new OrderDetailView();
		orderDetailView.setCompanyName("商安信");
		orderDetailView.setCountryName("中国");
		orderDetailView.setCreateTime(new Date());
		orderDetailView.setOrderNo("112233");
		orderDetailView.setRemark("报告需打印");
		orderDetailView.setFinishTime(new Date());
		String orderDetailViewObj = (String) JSONObject.toJSONString(orderDetailView);
		mapData.put("orderDetailView",orderDetailViewObj);
//		mapData.put("toAddress","fan1046625003@outlook.com");
		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalEagle","reportSuccess",mapData);
	}

	@Test
	public void sendEmailForgetENTest(){
		Map<String,Object> mapData = new HashedMap();
		String url = "http://www.global-eagle.cn/toResetPW.do?email=137238131@qq.com";
		mapData.put("url",url);
		mapData.put("toAddress","fanxuqing41@163.com");
//		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalSearch","forgetEN",mapData);
	}


	@Test
	public void sendEmailOrderENTest(){
		Map<String,Object> mapData = new HashedMap();
		Orders orders = new Orders();
		orders.setCreateTime(new Date());
		orders.setNo("123456");
		orders.setRemark("请查收");
		BigDecimal amountActual = new BigDecimal("1999");
		orders.setAmountActual(amountActual);

		BigDecimal price = new BigDecimal("199");

		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCountryName("中国");
		orderDetail.setProductId(3);
		orderDetail.setCompanyName("商安信");
		orderDetail.setPrice(price);
		OrderDetail orderDetail1 = new OrderDetail();
		orderDetail1.setCountryName("美国");
		orderDetail1.setProductId(4);
		orderDetail1.setCompanyName("Oracle");
		orderDetail1.setPrice(price);
		List<OrderDetail> orderDetailsList = new ArrayList<>();
		orderDetailsList.add(orderDetail);
		orderDetailsList.add(orderDetail1);
		orders.setOrderDetails(orderDetailsList);
		String ordersJsonObj = (String) JSONObject.toJSONString(orders);
		mapData.put("orders",ordersJsonObj);
		mapData.put("toAddress","fan1046625003@outlook.com");
		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalSearch","orderEN",mapData);
	}

	@Test
	public void sendEmailRegisterENTest(){
		Map<String,Object> mapData = new HashedMap();
//		mapData.put("toAddress","1046625003@qq.com");
		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalSearch","registerEN",mapData);
	}

	@Test
	public void sendEmailReportENTest(){
		Map<String,Object> mapData = new HashedMap();
		String url = "http://www.global-eagle.cn/toResetPW.do?email=137238131@qq.com";
		mapData.put("url",url);
//		mapData.put("toAddress","fan1046625003@aliyun.com");
		mapData.put("toAddress","fan1046625003@outlook.com");
		mapData.put("copyToAddress","mike.gu@3acredit.cn");
		ResponseResult result = emailService.sendEmail("globalSearch","reportEN",mapData);
	}
}
