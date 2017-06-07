package com.mika.credit.web.globalsearch.controller.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.pay.WXPayBean;
import com.mika.credit.common.util.UtilEncode;
import com.mika.credit.facade.email.service.EmailService;
import com.mika.credit.facade.email.util.MailSenderInfo;
import com.mika.credit.facade.globalsearch.core.model.Customer;
import com.mika.credit.facade.globalsearch.core.model.Manager;
import com.mika.credit.facade.globalsearch.core.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	@Resource
    private CustomerService customerService;
	@Resource
	private ManagerService managerService;
	@Resource
	private EmailService emailService;

	/**
	 * 登录
	 * @param customer
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login")
    public String login(Customer customer,ModelMap map,HttpServletRequest request) {
		logger.info("登录开始...");
		WXPayBean wxPayBean = new WXPayBean();
		String url = "index.do";
		if (request.getSession().getAttribute("url") == null) {
		} else {
			url = request.getSession().getAttribute("url").toString();
		}
		request.getSession().setAttribute("url", null);
		if(customer.getCode()!=null && !customer.getCode().equals("") && customer.getPasswd()!=null && !customer.getPasswd().equals("")){
			ResponseResult<Customer> customerResult = customerService.getLoginInfo(customer);
			if(customerResult.getCode()){
				if (url.toLowerCase().indexOf("logout.do")>=0 || url.toLowerCase().indexOf("login.do")>=0) {
					url = "/index.do";
				}
				if (url.toLowerCase().indexOf("login.do")>=0 || url.toLowerCase().indexOf("login.do")>=0) {
					url = "/index.do";
				}
				if (url.toLowerCase().indexOf("register.do")>=0 || url.toLowerCase().indexOf("register.do")>=0) {
					url = "/index.do";
				}
				request.getSession().setAttribute("customerInfo", customerResult.getContent());
				request.getSession().removeAttribute("message");
				request.getSession().removeAttribute("message");
				return "redirect:"+url;
			}
			else{
				//若不对,则将错误信息显示到错误页面
				map.addAttribute("message","User name password mistake");
				return "/login";
			}
		}
		else{
			map.addAttribute("message","User name password cannot be empty");
			return "/login";
		}
    }

	/**
	 * 登出
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request ) {
		logger.info("登出开始...");
		request.getSession().removeAttribute("message");
		request.getSession().removeAttribute("messageRegister");
		request.getSession().removeAttribute("customerInfo");
		request.getSession().removeAttribute("cartCount");
		return "/index";

	}

	/**
	 * 注册
	 * @param request
	 * @param customer
	 * @param map
	 * @return
	 */
    @RequestMapping(value = "/register")
    public String register(HttpServletRequest request,Customer customer,String passwdAgain,ModelMap map) {
		logger.info("注册开始...");
		if(customer.getCode()!=null && !customer.getCode().equals("") && customer.getPasswd()!=null && !customer.getPasswd().equals("")){
		ResponseResult<Customer> customerResult = customerService.getRegisterInfo(customer);
		if (customerResult.getCode()) {
			Map<String,Object> mapData = new HashedMap();
			mapData.put("toAddress",customerResult.getContent().getEmail());
			emailService.sendEmail("globalSearch","registerEN",mapData);
			//注册成功跳转首页
			request.getSession().setAttribute("customerInfo", customerResult.getContent());
			map.addAttribute("messageRegister", "Registration Successful");
			return "/index";
		} else {
			map.addAttribute("messageRegister", "User name already exists");
			return "/login";
		}
		} else {
			map.addAttribute("messageRegister", "User name password cannot be empty");
			return "/login";
		}
    }

	/**
	 * 管理员登录
	 * @param manager
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/managerLogin",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String login(Manager manager, HttpSession session){
		logger.info("管理员登录开始...");
		if(manager.getCode()!=null && !manager.getCode().equals("") && manager.getPasswd()!=null && !manager.getPasswd().equals("")){
			ResponseResult<Manager> managerResult = managerService.getLoginInfo(manager);
			if(managerResult.getCode()){
				session.setAttribute("managerInfo",managerResult.getContent());
				return "redirect:/manager/index.do";
			}else{
				//若不对,则将错误信息显示到错误页面
				session.setAttribute("message", managerResult.getMsg());
				return "/managerLogin";
			}
		}
		else{
			//若不对,则将错误信息显示到错误页面
			session.setAttribute("message","User name password cannot be empty");
			return "/managerLogin";
		}
	}

	/**
	 * 管理员登出
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/managerLogout")
	public String managerLogout(HttpSession session) {
		logger.info("管理员登出开始...");
		session.removeAttribute("managerInfo");
		return "/managerLogin";
	}

	/**
	 * 忘记密码
	 * @return
	 */
	@RequestMapping(value = "/forgetPW",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String forgetPW(HttpServletRequest request, @RequestBody String json) {
		logger.info("忘记密码开始...");
		JSONObject jsonObject = JSON.parseObject(json);
		String email = jsonObject.getString("email");
		int port = request.getServerPort();
		String portStr = "";
		if (port != 80) {
			portStr = ":" + port + "";
		}
		String url = "http://" + request.getServerName() + portStr + request.getContextPath();
		ResponseResult<Customer> result = customerService.forgetPW(email, url);
		return JSON.toJSONString(result);
	}

	/**
	 * 重置密码
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/resetPW",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String resetPW(@RequestBody String json) {
		logger.info("重置密码开始...");
		JSONObject jsonObject = JSON.parseObject(json);
		String password = jsonObject.getString("password");
		String email = jsonObject.getString("email");
		Customer c = new Customer();
		c.setEmail(email);
		c.setPasswd(password);
		ResponseResult<Customer> result = customerService.resetPW(c);
		return JSON.toJSONString(result);
	}
}