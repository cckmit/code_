package com.mika.credit.web.admin.controller.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.common.util.UtilEncode;
import com.mika.credit.common.util.UtilString;
import com.mika.credit.facade.admin.model.User;
import com.mika.credit.facade.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mika.credit.web.admin.util.*;

/**
 * Created by dell on 2017/4/7.
 */
@Controller
public class UserManagerController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordHelper passwordHelper;

    /**
     *用户管理 AJAX
     * @return
     */
    @RequestMapping(value = "/core/usersList" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String usersList(BootGrid<User> grid, User user) {
        BootGrid<User> result = userService.getUsers(grid,user);
        return JSON.toJSONString(result);
    }
    /**
     *id查询
     * @return
     */
    @RequestMapping(value = "/core/getUsers",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String getUsers(@RequestBody User user) {
        ResponseResult<User> result =userService.getUserByIdGroup(user.getId());
        return JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
    }
    /**
     * 重置密码
     * @return
     */
    @RequestMapping(value = "/core/updUserPwd",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String updUserPwd(@RequestBody User user) {
        user.setSalt(UtilString.getRandomStringByLength(3));
        user.setPasswd(passwordHelper.encryptPassword("a123456", user.getSalt()));
        ResponseResult<User> result = userService.margeUser(user);
        if(result.getCode()){
            result.setMsg("重置密码成功！密码为：a123456");
        }else{
            result.setMsg("重置密码失败！");
        }
        return JSON.toJSONString(result);
    }
    /**
     * 修改客户信息
     * @return
     */
    @RequestMapping(value = "/core/modifyUser",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String modifyUser(@RequestBody User user) {
        ResponseResult<User> result = userService.updateUserGroup(user);
        return JSON.toJSONString(result);
    }
    /**
     * 删除客户
     */
    @RequestMapping(value = "/core/delUser",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String delUser(@RequestBody User user) {
        ResponseResult<User> result = userService.removeUserGroup(user.getId());
        return JSON.toJSONString(result);
    }

    /**
     * 添加
     */

    @RequestMapping(value = "/core/addUser",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String addUser(@RequestBody User user) {
        ResponseResult<User> result;
        if (StringUtil.isNotNull(user)) {
            user.setSalt(UtilString.getRandomStringByLength(3));
            user.setPasswd(passwordHelper.encryptPassword("a123456", user.getSalt()));
            result = userService.addUserGroup(user);
        } else {
            result = new ResponseResult<>();
            result.setCode(false);
            result.setMsg("传入参数为空");
        }
        return JSON.toJSONString(result);
    }
}
