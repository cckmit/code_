package com.mika.credit.facade.globalsearch.core.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.facade.globalsearch.core.model.Customer;

import javax.servlet.http.HttpServletRequest;


public interface CustomerService {
	//登录
	ResponseResult<Customer> getLoginInfo(Customer customer);
	//注册
	ResponseResult<Customer> getRegisterInfo(Customer customer);
	//修改个人信息
	ResponseResult<Customer> modifyMyInfomation(Customer customer);
	//客户信息列表
	BootGrid<Customer> getCustomers(Customer customer);
	//更新余额
	boolean updateOrderBalance(Customer customer);
	//根据ID查询
	ResponseResult<Customer> getCustomerInfoById(int id);
	//检查余额
	ResponseResult<Customer> customerCheckBalance(float price, int customerId);
	//忘记密码
	ResponseResult<Customer> forgetPW(String email, String url);
	//重设密码
	ResponseResult<Customer> resetPW(Customer email);
	//余额支付
	ResponseResult<Orders> modifyOrderPayment(Integer orderId, Integer customerId, String emailAddress);
	//合并客户信息
	int merge(Customer record);
	//添加客户信息
	int add(Customer customer);
	//修改客户信息
	int modify(Customer record);
	//删除用户信息
	ResponseResult<Customer> deleteCustomer(int id);
	//客户认证
	ResponseResult<Customer> modifyCertify(Customer record);
	// 修改认证状态
	ResponseResult<Customer> editCheckStatus(Customer customer);
}
