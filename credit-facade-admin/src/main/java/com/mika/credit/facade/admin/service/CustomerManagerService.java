package com.mika.credit.facade.admin.service;


import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Customer;

/**
 * CustomerManager接口
 * @author dhl007
 */

public interface CustomerManagerService {

	/**
	 * 全球鹰查询客户
	 * @param bootGrid 分页对象
	 * @param customer Customer的查询条件
	 * @return 分页显示
	 */
	BootGrid<Customer> getCustomersGE(BootGrid<Customer> bootGrid, Customer customer);   //查询客户

	/**
	 * 全搜查询客户
	 * @param bootGrid 分页对象
	 * @param customer Customer的查询条件
	 * @return 分页显示
	 */
	BootGrid<Customer> getCustomersGS(BootGrid<Customer> bootGrid, Customer customer);   //查询客户

	/**
	 * 全球鹰更新当前客户
	 * @param customer Customer的信息
	 * @return 更新结果
	 */
	ResponseResult<Customer> updateCusGE(Customer customer);        //更新当前客户

	/**
	 *全搜更新当前客户
	 * @param customer Customer的信息
	 * @return 更新结果
	 */
	ResponseResult<Customer> updateCusGS(Customer customer);        //更新当前客户

	/**
	 * 全球鹰增加或更新客户（新建时根据email判断，如果email相同，则保持email不变，完全更新用户）
	 * @param customer Customer的信息
	 * @return 增加或更新结果
	 */
	ResponseResult<Customer> addCusGE(Customer customer);       //增加或更新客户（新建时根据email判断，如果email相同，则保持email不变，完全更新用户）

	/**
	 * 全搜增加或更新客户
	 * @param customer Customer的信息
	 * @return 增加或更新结果
	 */
	ResponseResult<Customer> addCusGS(Customer customer);

	/**
	 * 全球鹰删除客户
	 * @param id Customer的id
	 * @return 删除结果
	 */
	ResponseResult<Customer> deleteCusGE(int id);         //删除客户

	/**
	 * 全搜删除客户
	 * @param id Customer的id
	 * @return 删除结果
	 */
	ResponseResult<Customer> deleteCusGS(int id);

	/**
	 * 全球鹰客户认证
	 * @param customer Customer的信息
	 * @return 认证结果
	 */
	ResponseResult<Customer> modifyCertifyGE(Customer customer);

	/**
	 * 全搜客户认证
	 * @param customer Customer的信息
	 * @return
	 */
	ResponseResult<Customer> modifyCertifyGS(Customer customer);

	/**
	 * 全球鹰修改验证状态
	 * @param customer Customer的信息
	 * @return 认证结果
	 */
	ResponseResult<Customer> editCheckStatusGE(Customer customer);

	/**
	 * 全搜修改验证状态
 	 * @param customer Customer的信息
	 * @return 认证结果
	 */
	ResponseResult<Customer> editCheckStatusGS(Customer customer);
}
