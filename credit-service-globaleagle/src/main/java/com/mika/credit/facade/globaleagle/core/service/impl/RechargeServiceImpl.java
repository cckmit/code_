package com.mika.credit.facade.globaleagle.core.service.impl;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globaleagle.core.dao.CustomerMapper;
import com.mika.credit.facade.globaleagle.core.dao.RechargeMapper;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.model.Recharge;
import com.mika.credit.facade.globaleagle.core.service.RechargeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("rechargeService")
public class RechargeServiceImpl implements RechargeService {

	private static Logger logger = Logger.getLogger(RechargeServiceImpl.class);
	@Autowired
	private RechargeMapper rechargeMapper;

	@Autowired
	private CustomerMapper customerMapper;

	/**
	 * 充值记录列表
	 * @param recharge
	 * @return
	 */
	@Override
	public BootGrid<Recharge> getRecharges(Recharge recharge) {
		logger.info("查询充值记录方法开始...");
		BootGrid<Recharge> result = new BootGrid<>();
		result.setTotal(rechargeMapper.selectCountSelective(recharge));
		result.setRows(rechargeMapper.selectSelective(recharge));
		result.setResult(true);
		return result;
	}

	/**
	 * 通过充值审批
	 * @param recharge
	 * @return
	 */
	@Override
	public ResponseResult<Recharge> modifyOkRecharge(Recharge recharge) {
		logger.info("通过充值审批方法开始...");
		ResponseResult<Recharge> result = new ResponseResult<>();
		recharge.setFinishDate(new Date());
		recharge.setStatusId(2);
		Recharge temp = rechargeMapper.selectByPrimaryKey(recharge.getId());
		Customer customer = customerMapper.selectByPrimaryKey(temp.getCustomerId());
		customer.setBalance(customer.getBalance() + temp.getAmount());
		int ret1 = rechargeMapper.updateByPrimaryKeySelective(recharge);
		int ret2 = customerMapper.updateByPrimaryKey(customer);
		if(ret1>0 && ret2>0){
			result.setCode(true);
			result.setMsg("订单确认成功");
		}
		else{
			result.setCode(true);
			result.setMsg("订单确认失败");
		}
		return result;
	}

	/**
	 * 驳回充值
	 * @param recharge
	 * @return
	 */
	@Override
	public ResponseResult<Recharge> modifyCancelRecharge(Recharge recharge) {
		logger.info("驳回充值方法开始...");
		ResponseResult<Recharge> result = new ResponseResult<>();
		recharge.setFinishDate(new Date());
		recharge.setStatusId(3);
		int ret1 = rechargeMapper.updateByPrimaryKeySelective(recharge);
		if(ret1>0){
			result.setCode(true);
			result.setMsg("订单取消成功");
		}
		else{
			result.setCode(true);
			result.setMsg("订单取消失败");
		}
		return result;
	}

	/**
	 * 增加充值信息
	 * @param recharge
	 * @return
	 */
	public ResponseResult<Recharge> addRecharge(Recharge recharge){
		logger.info("增加充值信息方法开始...");
		ResponseResult<Recharge> result = new ResponseResult<>();
		recharge.setStatusId(1);
		recharge.setCreateDate(new Date());
		Customer customer = customerMapper.selectByPrimaryKey(recharge.getCustomerId());
		customer.setBalance(customer.getBalance() + recharge.getAmount());
		int ret1 = rechargeMapper.insertSelective(recharge);
		int ret2 = customerMapper.updateByPrimaryKey(customer);
		if(ret1>0 && ret2>0){
			result.setCode(true);
			result.setMsg("充值记录添加成功");
		}
		else{
			result.setCode(false);
			result.setMsg("充值记录添加失败");
		}
		return result;
	}
}
