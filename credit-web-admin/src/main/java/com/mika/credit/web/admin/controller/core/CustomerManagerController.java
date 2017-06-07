package com.mika.credit.web.admin.controller.core;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.UtilEncode;
import com.mika.credit.facade.admin.model.Customer;
import com.mika.credit.facade.admin.service.CustomerManagerService;
import com.mika.credit.facade.admin.service.CustomerService;
import com.mika.credit.facade.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
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
public class CustomerManagerController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
    @Autowired
    private CustomerManagerService customerManagerService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private EmailService emailService;

	/**
	 * 后台客户信息列表 AJAX
	 * @return
	 */	
	@RequestMapping(value = "/core/customerListGE" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String customerListGE(Customer customer, BootGrid<Customer> grid) {
		//Customer customer = new Customer();
		BootGrid<Customer> result = customerManagerService.getCustomersGE(grid,customer);
		return JSON.toJSONString(result);
	}

	@RequestMapping(value = "/core/customerListGS" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String customerListGS(Customer customer, BootGrid<Customer> grid) {
		//Customer customer = new Customer();
		BootGrid<Customer> result = customerManagerService.getCustomersGS(grid,customer);
		return JSON.toJSONString(result);
	}


	/**
	 * 删除客户 AJAX
	 * @return
	 */
	@RequestMapping(value = "/core/delCustomerGE" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String delCustomerGE(@RequestBody Customer customer) {
		ResponseResult<Customer> results=customerManagerService.deleteCusGE(customer.getId());
		return JSON.toJSONString(results);
	}

	@RequestMapping(value = "/core/delCustomerGS" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String delCustomerGS(@RequestBody Customer customer) {
		ResponseResult<Customer> results=customerManagerService.deleteCusGS(customer.getId());
		return JSON.toJSONString(results);
	}

	/**
	 * 新增客户 AJAX
	 * @return
	 */
	@RequestMapping(value = "/core/addCustomerGE" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String addCustomerGE(Customer customer) {
		customer.setPasswd(UtilEncode.encodeMD5(customer.getPasswd()));
		ResponseResult<Customer> result=customerManagerService.addCusGE(customer);
		String s = JSON.toJSONString(result);
		return s;
	}

	@RequestMapping(value = "/core/addCustomerGS" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String addCustomerGS(Customer customer) {
		customer.setPasswd(UtilEncode.encodeMD5(customer.getPasswd()));
		ResponseResult<Customer> result=customerManagerService.addCusGS(customer);
		String s = JSON.toJSONString(result);
		return s;
	}

	/**
	 * 修改客户 AJAX
	 * @return
	 */
	@RequestMapping(value = "/core/updateCustomerGE" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String updateCustomerGE(@RequestBody Customer customer) {
	    ResponseResult<Customer> resulta=customerManagerService.updateCusGE(customer);
		if(resulta.getCode()){
			ResponseResult<Customer> result1=customerService.getCustomerInfoByIdGE(customer.getId());    //修改customer查找customer的email发送邮件
			Map<String,Object> map=new HashMap<>();
			map.put("toAddress",result1.getContent().getEmail());
			emailService.sendEmail("globalEagle","count",map);
		}

		return JSON.toJSONString(resulta);
	}

	@RequestMapping(value = "/core/updateCustomerGS" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String updateCustomerGS(@RequestBody Customer customer) {
		ResponseResult<Customer> resulta=customerManagerService.updateCusGS(customer);
		if(resulta.getCode()){
			ResponseResult<Customer> result1=customerService.getCustomerInfoByIdGS(customer.getId());    //修改customer查找customer的email发送邮件
			Map<String,Object> map=new HashMap<>();
			map.put("toAddress",result1.getContent().getEmail());
			emailService.sendEmail("globalSearch","count",map);
		}
		return JSON.toJSONString(resulta);
	}


	/**
	 * 认证客户
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/core/modifyCertifyGE",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String modifyCertifyGE(@RequestBody Customer customer) {
		ResponseResult<Customer> result = customerManagerService.modifyCertifyGE(customer);
		return JSON.toJSONString(result);
	}

	@RequestMapping(value = "/core/modifyCertify",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String modifyCertifyGS(@RequestBody Customer customer) {
		ResponseResult<Customer> result = customerManagerService.modifyCertifyGS(customer);
		return JSON.toJSONString(result);
	}

	/**
	 * 修改验证状态
	 * @param
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/core/editCheckStatusGE",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String editCheckStatusGE(@RequestBody String json,HttpServletRequest request) {
		Customer customer = new Customer();
		JSONObject jsonObject = JSON.parseObject(json);
		String id = jsonObject.getString("id");
		String companyNameStatus = jsonObject.getString("companyNameStatus");
		String companyAddressStatus = jsonObject.getString("companyAddressStatus");
		String companyPhoneStatus = jsonObject.getString("companyPhoneStatus");
		String positionStatus = jsonObject.getString("positionStatus");
		customer.setId(Integer.parseInt(id));
		if (companyNameStatus.equals("1")&&companyAddressStatus.equals("1")&&companyPhoneStatus.equals("1")&&positionStatus.equals("1")){
			customer.setCheckStatus("是");
		}else{
			customer.setCheckStatus("否");
		}
		JSONObject jsonObj = new JSONObject();
		Map<String, String> data = new HashMap<String, String>();
		data.put("companyNameStatus", companyNameStatus);
		data.put("companyAddressStatus", companyAddressStatus);
		data.put("companyPhoneStatus", companyPhoneStatus);
		data.put("positionStatus", positionStatus);
		jsonObj.put("data", data);
		customer.setCheckStatusOption(jsonObj.toString());
		ResponseResult<Customer> result = customerManagerService.editCheckStatusGE(customer);
		System.out.println("in editCheckStatus................" + result);
		return JSON.toJSONString(result);
	}

	@RequestMapping(value = "/core/editCheckStatusGS",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String editCheckStatus(@RequestBody String json,HttpServletRequest request) {
		Customer customer = new Customer();
		JSONObject jsonObject = JSON.parseObject(json);
		String id = jsonObject.getString("id");
		String companyNameStatus = jsonObject.getString("companyNameStatus");
		String companyAddressStatus = jsonObject.getString("companyAddressStatus");
		String companyPhoneStatus = jsonObject.getString("companyPhoneStatus");
		String positionStatus = jsonObject.getString("positionStatus");
		customer.setId(Integer.parseInt(id));
		if (companyNameStatus.equals("1")&&companyAddressStatus.equals("1")&&companyPhoneStatus.equals("1")&&positionStatus.equals("1")){
			customer.setCheckStatus("是");
		}else{
			customer.setCheckStatus("否");
		}
		JSONObject jsonObj = new JSONObject();
		Map<String, String> data = new HashMap<String, String>();
		data.put("companyNameStatus", companyNameStatus);
		data.put("companyAddressStatus", companyAddressStatus);
		data.put("companyPhoneStatus", companyPhoneStatus);
		data.put("positionStatus", positionStatus);
		jsonObj.put("data", data);
		customer.setCheckStatusOption(jsonObj.toString());
		ResponseResult<Customer> result = customerManagerService.editCheckStatusGS(customer);
		System.out.println("in editCheckStatus................" + result);
		return JSON.toJSONString(result);
	}

}