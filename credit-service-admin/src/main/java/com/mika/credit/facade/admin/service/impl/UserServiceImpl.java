package com.mika.credit.facade.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.admin.dao.admin.GroupMapper;
import com.mika.credit.facade.admin.dao.admin.UserMapper;
import com.mika.credit.facade.admin.model.Group;
import com.mika.credit.facade.admin.model.Resource;
import com.mika.credit.facade.admin.model.User;
import com.mika.credit.facade.admin.model.UserGroupLink;
import com.mika.credit.facade.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Gavin on 2017/3/3.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
//    @Autowired
//    private PasswordHelper passwordHelper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public User findByUsername(String name) {
        User user = userMapper.findByUsername(name);
        System.out.println(user);
        return user;
    }

//    public ResponseResult<User> getLoginInfo(User user) {
//        ResponseResult<User> result = new ResponseResult<User>();
//        User user1=userMapper.findByUsername(user.getUsername());
//        if(user1 != null) {
//            user.setPasswd(passwordHelper.encryptPassword(user.getPasswd(), user1.getSalt()));//查找到当前登录用户的salt值，salt值结合输入密码得到真正的密码
//            List<User> users = userMapper.queryList(user);
//            User userResult = null;
//            if (users.size() > 0) {
//                userResult = users.get(0);
//            }
//            if (userResult != null) {
//                userResult.setLoginCount(userResult.getLoginCount()+1);
//                userResult.setLastTime(new Date());
//                userMapper.updateByIdSelective(userResult);
//                result.setCode(true);
//                result.setMsg("登录成功！");
//                result.setContent(userResult);
//                return result;
//            } else {
//                result.setCode(false);
//                result.setMsg("登录名或密码错误；登录失败！");
//                return result;
//            }
//        }else{
//            result.setCode(false);
//            result.setMsg("该用户不存在；登录失败！");
//            return result;
//        }
//    }

    public BootGrid<User> getUsers(BootGrid<User> grid, User user) {
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        user.setEnable(true);
        grid.setRows(userMapper.queryList(user));
        grid.setTotal(userMapper.queryList(user).size());
        grid.setResult(true);
        return grid;
    }

    public ResponseResult<User> removeUserGroup(String id) {
        ResponseResult<User> result = new ResponseResult<User>();
        if(userMapper.deleteById(id)>0){
            User user=new User();
            user.setId(id);
            UserGroupLink userGroupLink = new UserGroupLink();
            userGroupLink.setUser(user);
            groupMapper.deleteGroupUser(userGroupLink);    //解除该用户和组之间的关系
            result.setCode(true);
            result.setMsg("用户删除成功！");
        }
        else{
            result.setCode(false);
            result.setMsg("用户删除失败！");
        }
        return result;
    }

    public ResponseResult<User> addUserGroup(User user) {
        ResponseResult<User> result = new ResponseResult<User>();
        if(userMapper.findByUsername(user.getUsername())!=null){
            result.setCode(false);
            result.setMsg("该用户已存在，添加失败！");
        }else {
//            user.setSalt(UtilString.getRandomStringByLength(3));
//            user.setPasswd(passwordHelper.encryptPassword("a123456", user.getSalt()));
            user.setCreateTime(new Date());
            user.setLocked(false);
            user.setEnable(true);
            user.setLoginCount(0);
            user.setId(UtilGenerateID.generateID("USE"));
            if (userMapper.save(user) > 0) {
                List<Group> groups = user.getGroups();
                if (StringUtil.isNotNull(groups)) {    //判断参数是否包含组列表
                    for(Group group:groups) {
                        UserGroupLink userGroupLink = new UserGroupLink();
                        userGroupLink.setUser(user);
                        userGroupLink.setGroup(group);
                        userMapper.saveRelativity(userGroupLink);    //新增增该用户和组之间的关系
                    }
                }
                result.setCode(true);
                result.setMsg("用户添加成功！");
            } else {
                result.setCode(false);
                result.setMsg("用户添加失败！");
            }
        }
        return result;
    }

    public ResponseResult<User> margeUser(User user) {
        ResponseResult<User> result = new ResponseResult<User>();
        if(user != null){
            if(user.getId() != null && !"".equals(user.getId())){
                result=updateUserGroup(user);
            }else{
                result=addUserGroup(user);
            }
        }
        return result;
    }

    @Override
    public List<Resource> findResources(String name) {
        List<Resource> resources=userMapper.selectUserSourceByName(name);   //根据user表中的username查询所拥有的权限信息
        return resources;
    }

    @Override
    public List<Group> findGroups(String name) {
        User user=userMapper.selectUserGroupByName(name);   //根据username查找对应的user信息和包含的组信息
        return user.getGroups() ;
    }


    @Override
    public Set<String> findRoleNames(String name) {
        List<Group> groups=findGroups(name);   //根据username查找对应的user信息和包含的组信息
        Set<String> roles = new HashSet<>();
        Iterator<Group> it=groups.iterator();
        while (it.hasNext()){
            roles.add(it.next().getName());    //将组名封装到角色集合，进行角色授权
        }
        return roles ;
    }

    @Override
    public Set<String> findPermissionNames(String name) {
        List<Resource> resources = findResources(name);
        Set<String> permissions = new HashSet<>();
        Iterator<Resource> it = resources.iterator();    //将资源的perms封装到permissions中，进行权限授权
        while (it.hasNext()) {
            permissions.add(it.next().getPerms());
        }
        return permissions;
    }

    @Override
    public ResponseResult<User> updateUserGroup(User user) {
        ResponseResult<User> result = new ResponseResult<User>();
        if(userMapper.updateByIdSelective(user)>0){
            List<Group> groups=user.getGroups();
            if(StringUtil.isNotNull(groups)){    //判断参数是否包含组列表
                UserGroupLink userGroupLink1 = new UserGroupLink();
                userGroupLink1.setUser(user);
                groupMapper.deleteGroupUser(userGroupLink1);    //解除该用户和组之间的关系,再进行添加
                for(Group group:groups){
                    UserGroupLink userGroupLink = new UserGroupLink();
                    userGroupLink.setUser(user);
                    userGroupLink.setGroup(group);
                    userMapper.saveRelativity(userGroupLink);    //遍历新增该用户和组之间的关系
                }
            }
            result.setCode(true);
            result.setMsg("用户更新成功！");
        }
        else{
            result.setCode(false);
            result.setMsg("用户更新失败！");
        }
        return result;
    }

    public ResponseResult<User> getUserByIdGroup(String id) {
        ResponseResult<User> result = new ResponseResult<User>();
        User user=userMapper.queryById(id);
        if(user != null){
            User user1=userMapper.selectUserGroup(id);
            if(user1!=null){
                result.setContent(user1);
            }else{
                result.setContent(user);
            }
            result.setCode(true);
            result.setMsg("查找成功！");
        }
        else{
            result.setCode(false);
            result.setMsg("查找失败！");
        }
        return result;
    }

    public int selectCountByCorp(String id) {
        return userMapper.selectCountByCorp(id);
    }

    public int selectCountByDept(String id) {
        return userMapper.selectCountByDept(id);
    }

    @Override
    public ResponseResult<List> findResourceMenus(String name) {
        ResponseResult<List> result=new ResponseResult<>();
        List<Resource> resourceList = findResources(name);
        List<Resource> resources=new ArrayList();
        for(Resource resource : resourceList){
            if(resource.getType() == 1){      //判断是否为菜单资源，然后遍历重新添加到集合
                resources.add(resource);
            }
        }
        if( resources.size() > 0) {
            result.setCode(true);
            result.setContent(resources);
            result.setMsg("查找菜单资源成功！");
        }else{
            result.setCode(false);
            result.setMsg("没查找到当前用户所具有的菜单权限！");
        }
        return result;
    }
}
