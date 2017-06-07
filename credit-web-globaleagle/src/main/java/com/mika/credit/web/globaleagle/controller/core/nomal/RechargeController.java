package com.mika.credit.web.globaleagle.controller.core.nomal;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.model.Recharge;
import com.mika.credit.facade.globaleagle.core.service.RechargeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class RechargeController {
	private static Logger logger = Logger.getLogger(RechargeController.class);
	@Autowired
	private RechargeService rechargeService;

	/**
	 * 用户充值记录
	 * @param grid
	 * @param customer
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/customer/rechargeList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String customRechargeList(BootGrid<Recharge> grid, @SessionAttribute("customerInfo") Customer customer, ModelMap map) {
		logger.info("用户充值记录开始...");
		Recharge recharge = new Recharge();
		recharge.setCustomerId(customer.getId());
		BootGrid<Recharge> result = rechargeService.getRecharges(recharge);
		String json = JSON.toJSONString(result);
		return json;
	}


	/**
	 * 用户充值
	 * @param recharge
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/customer/addRecharge",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String customAddRecharge(@RequestBody Recharge recharge,@SessionAttribute("customerInfo") Customer customer) {
		logger.info("用户充值开始...");
		String discribe = "";
		ResponseResult<Recharge> result = null;
		if(recharge.getAmount()==null || recharge.getAmount()==0){
			discribe += "充值金额不能为空 ";
		}
		if(recharge.getMethodId()==null){
			discribe += "支付方式不能为空 ";
		}
		if(discribe.equals("")){
			recharge.setCustomerId(customer.getId());
			result = rechargeService.addRecharge(recharge);
		}
		else{
			result = new ResponseResult<>();
			result.setCode(false);
			result.setMsg(discribe);
		}
		return JSON.toJSONString(result);
	}



}