package com.mika.credit.web.admin.controller.core;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.common.util.UtilEncode;
import com.mika.credit.facade.admin.model.Category;
import com.mika.credit.facade.admin.model.Resource;
import com.mika.credit.facade.admin.model.User;
import com.mika.credit.facade.admin.service.ResourceService;
import com.mika.credit.facade.admin.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mika.credit.web.admin.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gavin on 2017/3/13.
 */
@Controller
public class LoginController {
    @Autowired
    private PasswordHelper passwordHelper;

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/checkLoginStatus")
    @ResponseBody
    public boolean checkLoginStatus() {
        return ShiroUtils.getUser() != null;
    }

    @RequestMapping(value = "/login")
    public String login(User user) {
        Subject subject = ShiroUtils.getSubject();
        Session session = subject.getSession();
        if (!subject.isAuthenticated()) {    //判断是否认证
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPasswd());
            token.setRememberMe(true);
            try {
                System.out.println("1. " + token.hashCode());
                subject.login(token);
            }// 若没有指定的账户, 则 shiro 将会抛出 UnknownAccountException 异常.
            catch (UnknownAccountException uae) {
                System.out.println("该用户不存在: " + uae.getMessage());
                session.setAttribute("message", "登录名或密码错误");
                return "redirect:/toLogin.do";
            }
            // 若账户存在, 但密码不匹配, 则 shiro 会抛出 IncorrectCredentialsException 异常。
            catch (IncorrectCredentialsException ice) {
                System.out.println("密码错误: " + ice.getMessage());
                session.setAttribute("message", "登录名或密码错误");
                return "redirect:/toLogin.do";
            }
            // 用户被锁定的异常 LockedAccountException
            catch (LockedAccountException lae) {
                System.out.println("该用户被锁定: " + lae.getMessage());
                session.setAttribute("message", "该用户被锁定");
                return "redirect:/toLogin.do";
                // ... catch more exceptions here (maybe custom ones specific to your application?
                // 所有认证时异常的父类.
            } catch (AuthenticationException e) {
                System.out.println("登录失败: " + e.getMessage());
                session.setAttribute("message", "登录失败");
                return "redirect:/toLogin.do";
            }
        }
        ResponseResult<List> result = userService.findResourceMenus(user.getUsername());
        Map<String,List> menus = new HashMap<>();
        if(result.getCode()){
            List<Resource> resourceList = result.getContent();
            for(Resource resource : resourceList) {
                Category category = resourceService.getResourceById(resource.getId()).getContent().getCategory();     //得到资源菜单所属的类别
                List<Resource> resources;
                if (StringUtil.isNotNull(category)) {
                    if (menus.containsKey(category.getName())) {      //判断是否已经有这个类别，如果有，就在所对应的list值添加一个，再进行添加替换。如果没有，就new一个list值，再添加
                        resources = menus.get(category.getName());
                        int i=0;
                        for(Resource resource1:resources){     //设置个变量，判断有没有相同资源，如果有，变量值改变
                            if((resource1.getId()).equals(resource.getId())){      //根据id判断是否相同对象
                                i=1;
                                break;
                            }
                        }
                        if(i != 1){
                            resources.add(resource);
                        }
                    } else {
                        resources = new ArrayList<>();
                        resources.add(resource);
                    }
                    menus.put(category.getName(), resources);
                }
            }
            session.setAttribute("menus",menus);
        }
        return "redirect:/index.do";
    }

    /**
     * 查看密码是否输入正确
     * @return
     */
    @RequestMapping(value = "/core/pwdExist",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String pwdExist(@RequestBody Map map) {
        String oldpwd=(String) map.get("oldPw");
        ResponseResult<User> result=new ResponseResult<>();
        User user=ShiroUtils.getUser();    //得到当前user
        System.out.printf("颜值：-----"+user.getSalt());
        String pwd=passwordHelper.encryptPassword(oldpwd, user.getSalt());   //对输入的密码加密再进行比较
        if(pwd.equals(user.getPasswd())){
            result.setCode(false);
        }else{
            result.setCode(true);
        }
        return JSON.toJSONString(result);
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping(value = "/core/updPw",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String updPw(@RequestBody Map map) {
        String repwd=(String) map.get("re_pw");
        User user=ShiroUtils.getUser();    //得到当前user
        user.setPasswd(passwordHelper.encryptPassword(repwd, user.getSalt()));
        ResponseResult<User> result = userService.margeUser(user);
        return JSON.toJSONString(result);
    }
}
