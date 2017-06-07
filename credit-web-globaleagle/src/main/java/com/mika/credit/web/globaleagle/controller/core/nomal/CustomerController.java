package com.mika.credit.web.globaleagle.controller.core.nomal;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户信息
 */
@Controller
public class CustomerController {
	private static Logger logger = Logger.getLogger(CustomerController.class);
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
    @Autowired
    private CustomerService customerService;


	/**
	 * 跳转用户修改个人信息界面
	 * @param request
	 * @param map
	 * @return
	 */
    @RequestMapping(value = "/customer/tochangedInformation")
    public String tochangedInformation(HttpServletRequest request, ModelMap map) {
		logger.info("跳转用户修改信息页面开始...");
		Customer c = (Customer) request.getSession().getAttribute("customerInfo");
		if (c == null) {
			return "/index";
		}
		Customer customerNew = customerService.getCustomerInfoById(c.getId()).getContent();
		request.setAttribute("customerInfo",customerNew);
		map.addAttribute("c",customerNew);
    	return "/customer/myInformation";
    }

	/**
	 * 修改个人信息 AJAX
	 * @param customer
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/customer/changedInformation",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String changedInformation(@RequestBody Customer customer, HttpServletRequest request, ModelMap map) {
		logger.info("修改个人信息开始...");
		Customer sessionCustomer = (Customer) request.getSession().getAttribute("customerInfo");
		customer.setId(sessionCustomer.getId());
		ResponseResult<Customer> result = customerService.modifyMyInfomation(customer);
		request.setAttribute("customerInfo", result.getContent());
		map.addAttribute("c", result.getContent());
		return JSON.toJSONString(result);
    }

	/**
	 * 提交 申请审核
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/customer/authCompanyCommit",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String authCompanyCommit(HttpServletRequest request,ModelMap map) {
		logger.info("提交申请审核开始...");
		ResponseResult<Customer> result = new ResponseResult<>();
		Customer sessionCustomer = (Customer)request.getSession().getAttribute("customerInfo");
		if (sessionCustomer.getAuthSubTime() == null) {
			sessionCustomer.setAuthSubTime(new Date());
			result = customerService.modifyMyInfomation(sessionCustomer);
			map.addAttribute("c",result.getContent());
			request.setAttribute("customerInfo",result.getContent());
		} else {
			result.setCode(false);
		}
		return JSON.toJSONString(result);
	}

	/**
	 * 检查余额
	 * @param price
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/customer/checkBalance",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String customerCheckBalance(@RequestBody String price,@SessionAttribute("customerInfo") Customer customer) {
		logger.info("检查余额开始...");
		JSONObject jsonObject = JSON.parseObject(price);
		price = jsonObject.getString("price");
		float amount = 0;
		if (price != null && !price.equals("")) {
			amount = Float.parseFloat(price);
		}
		ResponseResult<Customer> result = customerService.customerCheckBalance(amount,customer.getId());
		return JSON.toJSONString(result);
	}


}