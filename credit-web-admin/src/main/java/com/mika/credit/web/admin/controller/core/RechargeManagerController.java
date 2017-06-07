package com.mika.credit.web.admin.controller.core;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.pay.RechargeBean;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.common.util.UtilString;
import com.mika.credit.facade.admin.model.Customer;
import com.mika.credit.facade.admin.model.Manager;
import com.mika.credit.facade.admin.service.CustomerService;
import com.mika.credit.facade.email.service.EmailService;
import com.mika.credit.facade.pay.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
public class RechargeManagerController {

	@Autowired
	private RechargeService rechargeService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private EmailService emailService;

	/**
	 * 后台管理充值
	 * @param grid
	 * @param manager
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/core/rechargeList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String managerRechargeList(BootGrid<RechargeBean> grid, @SessionAttribute("managerInfo") Manager manager, ModelMap map) {
		RechargeBean recharge = new RechargeBean();
		BootGrid<RechargeBean> result = rechargeService.findRechargeBeans(grid,recharge);
		String json = JSON.toJSONString(result);
		return json;
	}

//	/**
//	 * 确认充值信息
//	 * @param recharge
//	 * @param manager
//	 * @return
//	 */
//	@RequestMapping(value = "/core/okRecharge",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
//	public @ResponseBody String managerOkRecharge(@RequestBody RechargeBean recharge,@SessionAttribute("managerInfo") Manager manager) {
//		String discribe = "";
//		ResponseResult<RechargeBean> result = null;
//		if(recharge.getId()==null){
//			discribe += "充值信息ID不能为空 ";
//		}
//		if(discribe.equals("")){
//			recharge.setManagerId(manager.getId());
//			result = rechargeService.modifyOkRecharge(recharge);
//		}
//		else{
//			result = new ResponseResult<>();
//			result.setCode(false);
//			result.setMsg(discribe);
//		}
//		return JSON.toJSONString(result);
//	}

	/**
	 * 取消充值
	 * @param recharge
	 * @param manager
	 * @return
//	 */
//	@RequestMapping(value = "/core/cancelRecharge",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
//	public @ResponseBody String managerCancelRecharge(@RequestBody RechargeBean recharge,@SessionAttribute("managerInfo") Manager manager) {
//		String discribe = "";
//		ResponseResult<RechargeBean> result = null;
//		if(recharge.getId()==null){
//			discribe += "充值信息ID不能为空 ";
//		}
//		if(discribe.equals("")){
//			recharge.setManagerId(manager.getId());
//			result = rechargeService.modifyCancelRecharge(recharge);
//		}
//		else{
//			result = new ResponseResult<>();
//			result.setCode(false);
//			result.setMsg(discribe);
//		}
//		return JSON.toJSONString(result);
//	}


	/**
	 * 后台充值
	 * @param manager
	 * @return
	 */
	@RequestMapping(value = "/core/addRechargeGE",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String addRechargeGE(@RequestBody Map map, @SessionAttribute("managerInfo") Manager manager) {
		RechargeBean recharge = new RechargeBean();
		Customer customer=new Customer();         //充值更新customer
		String discribe = "";
		ResponseResult result= new ResponseResult();
		Integer customerId=Integer.parseInt((String) map.get("customerId")) ;
		Integer amount=Integer.parseInt((String) map.get("amount"));
		String customerName=(String) map.get("customerName");
		Float balance=Float.parseFloat((String)map.get("balance")) ;
		//Integer appname=Integer.parseInt((String) map.get("appname")) ;
		//Byte appname=Byte.parseByte((String) map.get("appname")) ;
		if(customerId==null || customerId==0){
			discribe += "用户id不为空 ";
		}
		if(manager==null || manager.getId()==0){
			discribe += "后台管理员id不为空 ";
		}
		if(amount==null || amount<=0 ){
			discribe += "充值金额不能为空 ";
		}

		if(discribe.equals("")){
			//1为后台充值
			recharge.setPayMethod((byte)8);
			recharge.setNo(UtilGenerateID.generateID("RECHARGE"));
			recharge.setManagerId((long) manager.getId());
			recharge.setCustomerId((long)customerId);
			recharge.setAmount(new BigDecimal(amount));
			recharge.setFinishTime(new Date());
			recharge.setCustomerName(customerName);
			recharge.setCurrency("CNY");   //货币类型
			recharge.setAppName((byte)1);
			recharge.setManagerName(manager.getCode());
			customer.setId(customerId);
			if(balance!=null && balance!=0){        //判断客户余额非空，充值
				customer.setBalance(balance+amount);
			}else{
				customer.setBalance(amount);
			}
			if(customerService.updateOrderBalanceGE(recharge,customer)){    //先充值成功，再进行充值记录的生成
				result.setCode(true);
				result.setMsg("充值成功！！");
			}else{
				result.setMsg("充值失败！");
				result.setCode(false);
			}
			if(result.getCode()){
				ResponseResult<Customer> result1=customerService.getCustomerInfoByIdGE(customerId);    //充值成功查找customer的email发送邮件
				Map<String,Object> map1=new HashMap();
				map1.put("toAddress",result1.getContent().getEmail());
				emailService.sendEmail("globalEagle","count",map1);
			}
		}
		else{
			result.setCode(false);
			result.setMsg(discribe);
		}
	 	return JSON.toJSONString(result);
	}

	@RequestMapping(value = "/core/addRechargeGS",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String addRechargeGS(@RequestBody Map map, @SessionAttribute("managerInfo") Manager manager) {
		RechargeBean recharge = new RechargeBean();
		Customer customer=new Customer();         //充值更新customer
		String discribe = "";
		ResponseResult result= new ResponseResult();
		Integer customerId=Integer.parseInt((String) map.get("customerId")) ;
		Integer amount=Integer.parseInt((String) map.get("amount"));
		String customerName=(String) map.get("customerName");
		Float balance=Float.parseFloat((String)map.get("balance")) ;
		//Integer appname=Integer.parseInt((String) map.get("appname")) ;
		//Byte appname=Byte.parseByte((String) map.get("appname")) ;
		if(customerId==null || customerId==0){
			discribe += "用户id不为空 ";
		}
		if(manager==null || manager.getId()==0){
			discribe += "后台管理员id不为空 ";
		}
		if(amount==null || amount==0){
			discribe += "充值金额不能为空 ";
		}

		if(discribe.equals("")){
			//1为后台充值
			recharge.setPayMethod((byte)8);
			recharge.setNo(UtilGenerateID.generateID("RECHARGE"));
			recharge.setManagerId((long) manager.getId());
			recharge.setCustomerId((long)customerId);
			recharge.setAmount(new BigDecimal(amount));
			recharge.setFinishTime(new Date());
			recharge.setCustomerName(customerName);
			recharge.setCurrency("CNY");   //货币类型
			recharge.setAppName((byte)2);
			recharge.setManagerName(manager.getCode());
			customer.setId(customerId);
			if(balance!=null && balance!=0){        //判断客户余额非空，充值
				customer.setBalance(balance+amount);
			}else{
				customer.setBalance(amount);
			}
			if(customerService.updateOrderBalanceGS(recharge,customer)){    //先充值成功，再进行充值记录的生成
				result.setCode(true);
				result.setMsg("充值成功！！");
			}else{
				result.setMsg("充值失败！");
				result.setCode(false);
			}
			if(result.getCode()){
				ResponseResult<Customer> result1=customerService.getCustomerInfoByIdGS(customerId);    //充值成功查找customer的email发送邮件
				Map<String,Object> map1=new HashMap();
				map1.put("toAddress",result1.getContent().getEmail());
				emailService.sendEmail("globalSearch","count",map1);
			}
		}
		else{
			result.setCode(false);
			result.setMsg(discribe);
		}
		return JSON.toJSONString(result);
	}
}