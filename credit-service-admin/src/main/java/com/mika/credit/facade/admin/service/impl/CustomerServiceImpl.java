package com.mika.credit.facade.admin.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.pay.RechargeBean;
import com.mika.credit.common.util.Tool;
import com.mika.credit.common.util.UtilEncode;
import com.mika.credit.facade.admin.dao.ge.GECustomerMapper;
import com.mika.credit.facade.admin.dao.gs.GSCustomerMapper;
import com.mika.credit.facade.admin.model.Customer;
import com.mika.credit.facade.admin.service.CustomerService;
import com.mika.credit.facade.email.service.EmailService;
import com.mika.credit.facade.email.util.MailSenderInfo;
import com.mika.credit.facade.pay.service.RechargeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	private static Logger logger = Logger.getLogger(CustomerService.class);
	@Autowired
	private GECustomerMapper geCustomerMapper;
	@Autowired
	private GSCustomerMapper gsCustomerMapper;
	@Autowired
	private EmailService emailService;
	@Autowired
	private RechargeService rechargeService;


	/**
	 * 条件查询用户信息
	 * @param customer
	 * @return
	 */
	@Override
	public BootGrid<Customer> getCustomers(Customer customer) {
		BootGrid<Customer> result = new BootGrid<>();
		Page<Customer> page = PageHelper.startPage(result.getCurrent(), result.getRowCount());
		result.setTotal(geCustomerMapper.selectCountSelective(customer));
		result.setRows(geCustomerMapper.selectSelective(customer));
		result.setResult(true);
		return result;
	}

	/**
	 * 删除用户信息
	 * @param id
	 * @return
	 */
	@Override
	public ResponseResult<Customer> deleteCustomer(int id){
		ResponseResult<Customer> result = new ResponseResult<>();
		if(geCustomerMapper.deleteByPrimaryKey(id)>0){
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
	 * 用户登陆
	 * @param customer
	 * @return
	 */
	@Override
	public ResponseResult<Customer> getLoginInfo(Customer customer) {
		ResponseResult<Customer> result = new ResponseResult<>();
		//账户密码加密
		customer.setPasswd(UtilEncode.encodeMD5(customer.getPasswd()));
		List<Customer> customers = geCustomerMapper.selectSelective(customer);
		Customer customerResult = null;
		if(customers.size()>0){
			customerResult = customers.get(0);
		}
		if(customerResult != null){
			if (customerResult.getLoginCount()==null){
				customerResult.setLoginCount(1);
			}else{
				customerResult.setLoginCount(customerResult.getLoginCount()+1);
			}
			geCustomerMapper.updateByPrimaryKeySelective(customerResult);
			result.setCode(true);
			result.setMsg("登录成功");
			result.setContent(customerResult);
			return result;
		}
		else{
			result.setCode(false);
			result.setMsg("登录失败");
			return result;
		}
	}

	/**
	 * 通过id查用户信息
	 * @param id
	 * @return
	 */
	@Override
	public ResponseResult<Customer> getCustomerInfoByIdGE(int id) {
		ResponseResult<Customer> result = new ResponseResult<>();
		Customer customer = geCustomerMapper.selectByPrimaryKey(id);
		if(customer != null){
			result.setCode(true);
			result.setMsg("查询成功");
			result.setContent(customer);
			return result;
		}
		else{
			result.setCode(false);
			result.setMsg("查询失败");
			return result;
		}
	}

	@Override
	public ResponseResult<Customer> getCustomerInfoByIdGS(int id) {
		ResponseResult<Customer> result = new ResponseResult<>();
		Customer customer = gsCustomerMapper.selectByPrimaryKey(id);
		if(customer != null){
			result.setCode(true);
			result.setMsg("查询成功");
			result.setContent(customer);
			return result;
		}
		else{
			result.setCode(false);
			result.setMsg("查询失败");
			return result;
		}
	}


	/**
	 * 用户注册
	 * @param customer
	 * @return
	 */
	@Override
	public ResponseResult<Customer> getRegisterInfo(Customer customer) {
		ResponseResult<Customer> result = new ResponseResult<>();
		Customer c = new Customer();
		c.setEmail(customer.getEmail());
		List<Customer> customers = geCustomerMapper.selectSelective(c);
		Customer customerResult = null;
		if(customers.size()>0){
			customerResult = customers.get(0);
		}
		if(customerResult != null){
			result.setCode(false);
			result.setMsg("注册失败");
//			result.setResultcontent(customerResult);
			return result;
		}else{
			result.setCode(true);
			//添加创建账号信息
			customer.setCreateTime(new Date());
			//账户密码加密
			customer.setPasswd(UtilEncode.encodeMD5(customer.getPasswd()));
			//注册时添加非认证
			customer.setCheckStatus("否");
			//添加普通用户等级
			customer.setLevelId(1);
			geCustomerMapper.insert(customer);
			result.setContent(customer);
			result.setMsg("注册成功");
			return result;
		}
	}
	@Override
	public ResponseResult<Customer> registerSendEmail(Customer customer) {
		ResponseResult<Customer> result = new ResponseResult<>();
		MailSenderInfo mail = new MailSenderInfo();
		Map<String, String> map = Tool.loadEmailInfo();
		mail.setMailServerHost(map.get("emailSmtp"));
		mail.setMailServerPort("25");
		mail.setValidate(true);
		mail.setUserName(map.get("emailName"));
		mail.setPassword(map.get("emailPwd"));
		mail.setFromAddress(map.get("emailFromAddress"));
		mail.setToAddress(customer.getEmail());
		mail.setSubject("全球鹰用户信息");
		// 设置邮件内容
		StringBuffer demo = new StringBuffer();
		demo.append("注册成功");
//		SimpleMailSender sms = new SimpleMailSender();
//		mail.setContent(demo.toString());
		mail.setCopyToAddress("service@3acredit.com");
//		SimpleMailSender.sendHtmlMail(mail);
//		emailService.sendEmail(mail,"globalEagle");

		result.setCode(true);
		result.setMsg("修改密码邮件发送成功");
		return result;
	}

		/**
         * 游客模式 默认下单到默认用户下service@3acredit.com
         * 下单前的注册
         * @param customer
         * @return
         */
		@Override
	public ResponseResult<Customer> visitorRegister(Customer customer) {
		ResponseResult<Customer> result = new ResponseResult<>();
		Customer customers = geCustomerMapper.selectByEmail(customer.getEmail());
		Customer customerResult = null;
		customerResult = customers;
		if(customerResult != null){
			result.setCode(false);
			result.setMsg("注册失败");
			result.setContent(customerResult);
			return result;
		}else{
			result.setCode(true);
			//账户密码加密
			customer.setPasswd(UtilEncode.encodeMD5(customer.getPasswd()));
			geCustomerMapper.insert(customer);
			result.setContent(customer);
			result.setMsg("注册成功");
			return result;
		}
	}

	/**
	 * 修改个人信息
	 * @param customer
	 * @return
	 */
	@Override
	public ResponseResult<Customer> modifyMyInfomation(Customer customer) {
		ResponseResult<Customer> result = new ResponseResult<>();
		//更新个人信息
		int changedSel = geCustomerMapper.updateByPrimaryKeySelective(customer);
		if (changedSel>0) {
			result.setCode(true);
			result.setMsg("修改信息成功");
		}
		else{
			result.setCode(false);
			result.setMsg("修改信息失败");
		}
		return result;
	}

	/**
	 * 更新余额
	 * @param customer
	 * @return
	 */
	@Override
	public boolean updateOrderBalanceGE(RechargeBean rechargeBean, Customer customer) {
		ResponseResult<RechargeBean> result = rechargeService.saveRecharge(rechargeBean);
		if (result.getCode()) {       //当充值记录成功时，再实现充值
			int updateSel = geCustomerMapper.updateByPrimaryKeySelective(customer);
			if (updateSel > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateOrderBalanceGS(RechargeBean rechargeBean, Customer customer) {
		ResponseResult<RechargeBean> result = rechargeService.saveRecharge(rechargeBean);
		if (result.getCode()) {       //当充值记录成功时，再实现充值
			int updateSel = gsCustomerMapper.updateByPrimaryKeySelective(customer);
			if (updateSel > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 检查余额
	 * @param price
	 * @param customerId
	 * @return
	 */
	@Override
	public ResponseResult<Customer> customerCheckBalance(float price,int customerId){
		ResponseResult<Customer> result = new ResponseResult<>();
		Customer customer = geCustomerMapper.selectByPrimaryKey(customerId);
		if (customer.getBalance()-price>0) {
			result.setCode(true);
			result.setMsg("余额足够");
		}
		else {
			result.setCode(false);
			result.setMsg("余额不足");
		}
		return result;
	}

	/**
	 * 忘记密码
	 * @param email
	 * @return
	 */
	@Override
	public ResponseResult<Customer> forgetPW(String email,String url){
		ResponseResult<Customer> result = new ResponseResult<>();
		Customer customer = geCustomerMapper.selectByEmail(email);
		if (customer==null) {
			result.setCode(false);
			result.setMsg("此账号不是注册会员！");
		}
		else {
			MailSenderInfo mail = new MailSenderInfo();
//			Map<String, String> map = Tool.loadEmailInfo();
//			mail.setMailServerHost(map.get("emailSmtp"));
//			mail.setMailServerPort("25");
//			mail.setValidate(true);
//			mail.setUserName(map.get("emailName"));
//			mail.setPassword(map.get("emailPwd"));
//			mail.setFromAddress(map.get("emailFromAddress"));
			mail.setToAddress(email);
//			mail.setSubject("全球鹰用户信息");
			// 设置邮件内容
			StringBuffer demo = new StringBuffer();
			demo.append(url+"/toResetPW.do?email="+email);
//			SimpleMailSender sms = new SimpleMailSender();
//			mail.setContent(demo.toString());
//			SimpleMailSender.sendHtmlMail(mail);
//			emailService.sendEmail(mail, "globalEagle");
			result.setCode(true);
			result.setMsg("修改密码邮件发送成功");
		}
		return result;
	}

	/**
	 * 重置密码
	 * @param c
	 * @return
	 */
	@Override
	public ResponseResult<Customer> resetPW(Customer c){
		ResponseResult<Customer> result = new ResponseResult<>();
		//账户密码加密
		c.setPasswd(UtilEncode.encodeMD5(c.getPasswd()));
		boolean choose = geCustomerMapper.updatePasswordByEmail(c)>0;
		if (choose){
			result.setCode(true);
			result.setMsg("修改密码成功");
		}else{
			result.setCode(false);
			result.setMsg("修改密码失败");
		}
		return result;
	}

//	添加客户信息
	@Override
	public int add(Customer customer) {
		System.out.println("添加客户信息-----------------");
		return geCustomerMapper.insert(customer);
	}
	/**
	 * 修改客户信息
	 * @param record
	 * @return
	 */
    @Override
    public int modify(Customer record) {
        return geCustomerMapper.updateByPrimaryKey(record);
    }
	
	 /**
		 * 合并客户信息
		 * @param record
		 * @return
		 */
	    @Override
	    public int merge(Customer record) {
	    	System.out.println("合并客户信息");
	        Integer id = record.getId();
	        if(id == null || id.intValue() == 0){
	        	
	            return add(record);
	        }else {
	            return modify(record);
	        }
	    }
	    
		 /**
			 * 客户认证
			 * @param record
			 * @return
			 */
		@Override
		public ResponseResult<Customer> modifyCertify(Customer record) {
			ResponseResult<Customer> result = new ResponseResult<>();
			if(geCustomerMapper.updateCheckStatusById(record) > 0){
				result.setCode(true);
			}
			return result;
		}

//	/**
//	 * 更新未读信息数量
//	 * @param customer
//	 */
//	@Override
//	public void countInfo(Customer customer){
//		ResponseResult<Customer> result = new ResponseResult<>();
//		OrderQuery order1 = new OrderQuery();
//		order1.setCustomerId(customer.getId());
//		order1.setIsPay("是");
//		order1.setIsRead("否");
//		int orderCount = orderMapper.selectCountSelective(order1);
//		OrderDetailQuery orderDetail1 = new OrderDetailQuery();
//		orderDetail1.setCustomerId(customer.getId());
//		orderDetail1.setIsPay("是");
//		orderDetail1.setIsRead("否");
//		int orderDetailCount = orderDetailMapper.selectCountSelective(orderDetail1);
//	}


	@Override
	public ResponseResult<Customer> editCheckStatus(Customer customer) {
		ResponseResult<Customer> result = new ResponseResult<>();
		if(geCustomerMapper.updateCheckStatusById(customer)>0){
			if (customer.getCheckStatus().equals("是")){
				result.setMsg("认证成功");
			}else{
				result.setMsg("保存成功");
			}
			result.setCode(true);
		}else {
			result.setMsg("保存/认证失败");
			result.setCode(false);
		}
		return result;
	}
}
