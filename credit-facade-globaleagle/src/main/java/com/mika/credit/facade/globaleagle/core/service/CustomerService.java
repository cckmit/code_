package com.mika.credit.facade.globaleagle.core.service;


import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetailView;
import com.mika.credit.common.entity.order.OrderDetailViewQuery;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;


public interface CustomerService {
	ResponseResult<Customer> registerVerificationCode(Customer customer);
	ResponseResult<Customer> getLoginInfo(Customer customer);
	ResponseResult<Customer> getRegisterInfo(Customer customer);
	ResponseResult<Customer> modifyMyInfomation(Customer customer);
	boolean updateOrderBalance(Customer customer);
	ResponseResult<Customer> getCustomerInfoById(int id);
	ResponseResult<Customer> customerCheckBalance(float price, int customerId);
	//忘记密码
	ResponseResult<Customer> forgetPW(String email, String url);
	//重设密码
	ResponseResult<Customer> resetPW(Customer email);
//    修改客户信息
	int modify(Customer customer);
	//	修改验证状态
	ResponseResult<Customer> editCheckStatus(Customer customer);
	//余额支付
	ResponseResult<Orders> modifyOrderPayment(Integer orderId, Integer customerId);


}
