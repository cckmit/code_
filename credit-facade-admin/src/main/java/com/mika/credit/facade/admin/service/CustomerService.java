package com.mika.credit.facade.admin.service;


import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.pay.RechargeBean;
import com.mika.credit.facade.admin.model.Customer;

/**
 * Customer接口
 * @author dhl007
 */
public interface CustomerService {

	/**
	 * 用户登录
	 * @param customer 登录的信息
	 * @return 登录结果
	 */
	ResponseResult<Customer> getLoginInfo(Customer customer);

	/**
	 * 用户注册
	 * @param customer 注册的信息
	 * @return 注册结果
	 */
	ResponseResult<Customer> getRegisterInfo(Customer customer);

	/**
	 * 注册并发送email
	 * @param customer Customer的信息
	 * @return email发送结果
	 */
	ResponseResult<Customer> registerSendEmail(Customer customer);

	/**
	 * 游客注册一个账号
	 * 下单前的注册
	 * @param customer 游客的信息
	 * @return 注册结果
	 */
	ResponseResult<Customer> visitorRegister(Customer customer);

	/**
	 * 修改个人信息
	 * @param customer 个人信息
	 * @return 修改结果
	 */
	ResponseResult<Customer> modifyMyInfomation(Customer customer);

	/**
	 * 客户认证
	 * @param customer 认证信息
	 * @return 认证结果
	 */
	ResponseResult<Customer> modifyCertify(Customer customer);

	/**
	 * 条件查询用户信息
	 * @param customer Customer的查询条件
	 * @return 查询结果
	 */
	BootGrid<Customer> getCustomers(Customer customer);

	/**
	 * 删除用户信息
	 * @param id 删除的Customer的id
	 * @return 删除结果
	 */
	ResponseResult<Customer> deleteCustomer(int id);

	/**
	 * 全球鹰更新余额
	 * @param rechargeBean 充值记录
	 * @param customer Customer的信息
	 * @return 更新结果
	 */
	boolean updateOrderBalanceGE(RechargeBean rechargeBean, Customer customer);

	/**
	 * 全搜更新余额
	 * @param rechargeBean 充值记录
	 * @param customer Customer的信息
	 * @return 更新结果
	 */
	boolean updateOrderBalanceGS(RechargeBean rechargeBean, Customer customer);

	/**
	 * 全球鹰通过id查用户信息
	 * @param id Customer的id
	 * @return 查询结果
	 */
	ResponseResult<Customer> getCustomerInfoByIdGE(int id);

	/**
	 * 全搜通过id查用户信息
	 * @param id Customer的id
	 * @return 查询结果
	 */
	ResponseResult<Customer> getCustomerInfoByIdGS(int id);

	/**
	 * 检查余额
	 * @param price 传入价格
	 * @param customerId customer的id
	 * @return 检查结果
	 */
	ResponseResult<Customer> customerCheckBalance(float price, int customerId);

	/**
	 * 忘记密码
	 * @param email customer的email
	 * @param url 来源
	 * @return 检测此email结果
	 */
	//忘记密码
	ResponseResult<Customer> forgetPW(String email, String url);

	/**
	 * 重设密码
	 * @param email customer的email
	 * @return 重设结果
	 */
	ResponseResult<Customer> resetPW(Customer email);

	/**
	 * 添加客户信息
	 * @param record customer的信息
	 * @return 添加结果
	 */
    int add(Customer record);

	/**
	 * 修改客户信息
	 * @param customer Customer的信息
	 * @return 修改结果
	 */
	int modify(Customer customer);

	/**
	 * 合并客户信息
	 * @param customer customer的信息
	 * @return 添加或修改结果
	 */
	int merge(Customer customer);

	/**
	 * 更新未读信息数量
	 * @param customer
	 * @return
	 */

//	void countInfo(Customer customer);

	/**
	 * 修改验证状态
	 * @param customer
	 * @return
	 */
	ResponseResult<Customer> editCheckStatus(Customer customer);



}
