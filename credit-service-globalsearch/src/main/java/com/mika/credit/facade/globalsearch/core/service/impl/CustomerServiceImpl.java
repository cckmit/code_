package com.mika.credit.facade.globalsearch.core.service.impl;

import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.common.entity.pay.PayBackBean;
import com.mika.credit.facade.email.service.EmailService;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.Tool;
import com.mika.credit.common.util.UtilEncode;

import com.mika.credit.facade.email.util.MailSenderInfo;
import com.mika.credit.facade.globalsearch.core.dao.CustomerMapper;
import com.mika.credit.facade.globalsearch.core.dao.OrderDetailMapper;
import com.mika.credit.facade.globalsearch.core.dao.OrderMapper;
import com.mika.credit.facade.globalsearch.core.model.Customer;
import com.mika.credit.facade.globalsearch.core.model.OrderDetailQuery;
import com.mika.credit.facade.globalsearch.core.model.OrderQuery;
import com.mika.credit.facade.globalsearch.core.service.CustomerService;
import com.mika.credit.facade.order.service.OrderService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	private static Logger logger = Logger.getLogger(CustomerService.class);
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private EmailService emailService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailMapper orderDetailMapper;

	/**
	 * 条件查询用户信息
	 * @param customer
	 * @return
	 */
	public BootGrid<Customer> getCustomers(Customer customer) {
		logger.info("条件查询用户信息方法开始...");
		BootGrid<Customer> result = new BootGrid<>();
		result.setTotal(customerMapper.selectCountSelective(customer));
		result.setRows(customerMapper.selectSelective(customer));
		result.setResult(true);
		return result;
	}


	/**
	 * 用户登陆
	 * @param customer
	 * @return
	 */
	public ResponseResult<Customer> getLoginInfo(Customer customer) {
		logger.info("用户登录方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		//账户密码加密
		customer.setPasswd(UtilEncode.encodeMD5(customer.getPasswd()));
		List<Customer> customers = customerMapper.selectSelective(customer);
		Customer customerResult = null;
		if(customers.size()>0){
			customerResult = customers.get(0);
		}
		if(customerResult != null){
			result.setCode(true);
			result.setMsg("Login Success");
			result.setContent(customerResult);
			return result;
		}
		else{
			result.setCode(false);
			result.setMsg(" Logon failed");
			return result;
		}
	}
	/**
	 * 修改个人信息
	 * @param customer
	 * @return
	 */
	public ResponseResult<Customer> modifyMyInfomation(Customer customer) {
		logger.info("修改个人信息方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		//更新个人信息
		int changedSel = customerMapper.updateByPrimaryKeySelective(customer);
		if (changedSel>0) {
			result.setCode(true);
			result.setMsg("Modify the information successfully");
		}
		else{
			result.setCode(false);
			result.setMsg("Failed to modify information");
		}
		return result;
	}
	/**
	 * 通过id查用户信息
	 * @param id
	 * @return
	 */
	public ResponseResult<Customer> getCustomerInfoById(int id) {
		logger.info("通过id查询用户信息方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		Customer customer = customerMapper.selectByPrimaryKey(id);
		if(customer != null){
			result.setCode(true);
			result.setMsg("The query is successful");
			result.setContent(customer);
			return result;
		}
		else{
			result.setCode(false);
			result.setMsg("query fails");
			return result;
		}
	}

	/**
	 * 用户注册
	 * @param customer
	 * @return
	 */
	public ResponseResult<Customer> getRegisterInfo(Customer customer) {
		logger.info("用户注册方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		Customer c=new Customer();
		c.setCode(customer.getCode());
		List<Customer> customers = customerMapper.selectSelective(c);
		Customer customerResult = null;
		for (int i = 0; i < customers.size(); i++) {
			if (customer.getCode().equals(customers.get(i).getCode())) {
				result.setCode(false);
				result.setMsg("User name already exists");
				return result;
			}
		}
		if(customers.size()>0){
			customerResult = customers.get(0);
		}
		if(customerResult != null){
			result.setCode(false);
			result.setMsg("fail to register");
//			result.setContent(customerResult);
			return result;
		}else{
			result.setCode(true);
			//添加创建账号信息
			customer.setCreateTime(new Date());
//			//账户密码加密
			customer.setPasswd(UtilEncode.encodeMD5(customer.getPasswd()));
			//注册时添加非认证
			customer.setCheckStatus("否");
			//添加普通用户等级
			customer.setLevelId(1);
			customerMapper.insert(customer);
			result.setContent(customer);
			result.setMsg(" Registration Successful");
			return result;
		}
	}

	/**
	 * 更新余额
	 * @param customer
	 * @return
	 */
	public boolean updateOrderBalance(Customer customer){
		logger.info("更新余额方法开始...");
		int updateSel = customerMapper.updateByPrimaryKeySelective(customer);
		if (updateSel>0) {
			return true;
		}
		return false;
	}

	/**
	 * 检查余额
	 * @param price
	 * @param customerId
	 * @return
	 */
	public ResponseResult<Customer> customerCheckBalance(float price,int customerId){
		logger.info("检查余额方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		Customer customer = customerMapper.selectByPrimaryKey(customerId);
		if (customer.getBalance()-price>0) {
			result.setCode(true);
			result.setMsg("Balance is enough");
		}
		else {
			result.setCode(false);
			result.setMsg("not sufficient funds");
		}
		return result;
	}

	/**
	 * 忘记密码
	 * @param email
	 * @return
	 */
	public ResponseResult<Customer> forgetPW(String email,String url){
		logger.info("忘记密码方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		Customer customer = customerMapper.selectByEmail(email);
		if (customer==null) {
			result.setCode(false);
			result.setMsg("This account is not registered members！");
		}
		else {
			MailSenderInfo mail = new MailSenderInfo();
			// 设置邮件内容
			StringBuffer demo = new StringBuffer();
			demo.append(url+"/toResetPW.do?email="+email);
			Map<String,Object> mapData = new HashedMap();
			mapData.put("url", demo);
			mapData.put("toAddress",customer.getEmail());
			emailService.sendEmail("globalSearch","forgetEN",mapData);
			result.setCode(true);
			result.setMsg("Change the password email sent successfully");
		}
		return result;
	}

	/**
	 * 重置密码
	 * @param c
	 * @return
	 */
	public ResponseResult<Customer> resetPW(Customer c){
		logger.info("重置密码方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		//账户密码加密
		c.setPasswd(UtilEncode.encodeMD5(c.getPasswd()));
		boolean choose = customerMapper.updatePasswordByEmail(c)>0;
		if (choose){
			result.setCode(true);
			result.setMsg("passwd all authentication tokens updated successfully");
		}else{
			result.setCode(false);
			result.setMsg(" Modify your password failure");
		}
		return result;
	}
	/**
	 * 合并客户信息
	 * @param record
	 * @return
	 */
	@Override
	public int merge(Customer record) {
		logger.info("合并客户信息方法开始...");
		System.out.println("合并客户信息");
		Integer id = record.getId();
		if(id == null || id.intValue() == 0){
			return add(record);
		}else {
			return modify(record);
		}
	}
	//	添加客户信息
	@Override
	public int add(Customer customer) {
		logger.info("添加客户信息方法开始...");
		System.out.println("添加客户信息-----------------");
		return customerMapper.insert(customer);
	}
	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	public ResponseResult<Customer> deleteCustomer(int id){
		logger.info("删除用户信息方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		if(customerMapper.deleteByPrimaryKey(id)>0){
			result.setCode(true);
			result.setMsg("客户信息删除成功");
		}
		else{
			result.setCode(false);
			result.setMsg("客户信息删除失败");
		}
		return result;
	}
	/**
	 * 客户认证
	 * @param record
	 * @return
	 */
	@Override
	public ResponseResult<Customer> modifyCertify(Customer record) {
		logger.info("客户认证方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		if(customerMapper.updateCheckStatusById(record) > 0){
			result.setCode(true);
		}
		return result;
	}
	//修改认证状态
	@Override
	public ResponseResult<Customer> editCheckStatus(Customer customer) {
		logger.info("修改认证状态方法开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		if(customerMapper.updateCheckStatusById(customer)>0){
			if (customer.getCheckStatus().equals("是")){
				result.setMsg("AuthenticationOk");
			}else{
				result.setMsg("Save successful");
			}
			result.setCode(true);
		}else {
			result.setMsg("Save/authentication failure");
			result.setCode(false);
		}
		return result;
	}
	/**
	 * 修改客户信息
	 * @param record
	 * @return
	 */
	@Override
	public int modify(Customer record) {
		logger.info("修改客户信息方法开始...");
		return customerMapper.updateByPrimaryKey(record);
	}
	/**
	 * 余额付款
	 *
	 * @param orderId
	 * @param customerId
	 * @param emailAddress
	 * @return
	 */
	public ResponseResult<Orders> modifyOrderPayment(Integer orderId, Integer customerId, String emailAddress) {
		logger.info("余额付款方法开始...");
		ResponseResult<Orders> result = new ResponseResult<>();
		ResponseResult<Orders> responseResult = orderService.findOrdersById(Long.valueOf(orderId));
		Orders order = responseResult.getContent();
		Customer c = customerMapper.selectByPrimaryKey(customerId);
		if (c.getBalance() >= order.getAmountActual().floatValue()) {
			c.setBalance(c.getBalance()-order.getAmountActual().floatValue());
			PayBackBean payBackBean = new PayBackBean();
			payBackBean.setOrderNo(order.getNo());
			payBackBean.setAmount(order.getAmountActual());
			payBackBean.setPayMethod(0);
			payBackBean.setPayTime(new Date());
			ResponseResult<Orders> payOrders = orderService.paid(payBackBean);
			if (payOrders.getCode()){
				if (order.getCustomerEmail()==null||order.getCustomerEmail().equals("")){
					order.setCustomerEmail(emailAddress);
					//更新订单email
					orderService.saveOrder(order);
					if (c.getEmail()==null||c.getEmail().equals("")){
						c.setEmail(emailAddress);
					}
				}
				//更新
				customerMapper.updateByPrimaryKey(c);
				result.setCode(true);
				result.setMsg("pay success");
				result.setContent(payOrders.getContent());
			}else{
				result.setCode(false);
				result.setMsg("Order payment failure");
			}
		} else {
			result.setCode(false);
			result.setMsg("not sufficient funds");
		}
		return result;
	}
}
