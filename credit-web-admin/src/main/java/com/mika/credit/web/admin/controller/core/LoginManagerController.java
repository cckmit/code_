package com.mika.credit.web.admin.controller.core;


import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Manager;
import com.mika.credit.facade.admin.service.ManagerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginManagerController {

	@Autowired
	private ManagerManagerService managerService;

	/**
	 * 管理员登录
	 * @param manager
	 * @param session
	 * @return
	 */
	@RequestMapping("/gEML2016")
	public String login(Manager manager, HttpSession session){

		if(manager.getCode()!=null && !manager.getCode().equals("") && manager.getPasswd()!=null && !manager.getPasswd().equals("")){
			ResponseResult<Manager> managerResult = managerService.getLoginInfo(manager);
			if(managerResult.getCode()){
				session.setAttribute("managerInfo",managerResult.getContent());
				session.setAttribute("managerName",manager.getCode());       //将当前登录管理员名字存入session中
				return "redirect:/index.do";
			}else{
				//若不对,则将错误信息显示到错误页面
				session.setAttribute("message", managerResult.getMsg());
				return "/login";
			}
		}
		else{
			//若不对,则将错误信息显示到错误页面
			session.setAttribute("message","用户名密码不能为空");
			return "/login";
		}
	}

	/**
	 * 管理员登出
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String managerLogout(HttpSession session) {
		session.removeAttribute("managerInfo");
		return "/login";
	}


}