package com.mika.credit.facade.gugu.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Mike on 2017/4/12.
 */
public interface UserService {

    /**
     * 判断token
     * @param userId
     * @param token
     * @return
     */
    Boolean judgeToken(Integer userId, String token);

    /**
     * 登录
     * @param data
     * @return
     */
    String userLogin(String data);

    /**
     * 注册
     * @param data
     * @return
     */
    String userRegister(String data);

    /**
     * 发送验证码
     * @param data
     * @return
     */
    String sendVerificationCode(String data);

    /**
     * 核实验证码
     * @param data
     * @return
     */
    String verifyVerificationCode(String data);


    /**
     * 获取用户资料
     * @param data
     * @return
     */
    String getUserInfo(String data);

    /**
     * 通过username修改密码
     * @param data
     * @return
     */
    String changeUserPwd(String data);

    /**
     * 修改用户资料
     * @param data
     * @return
     */
    String changeUserInfo(String data);

    /**
     * 上传用户头像图片
     * @param data
     * @param path
     * @return
     */
    String changeUserPic(String data,String path);

    /**
     * 获取用户信息
     * @param data
     * @return
     */
    String getUser(String data);

}
