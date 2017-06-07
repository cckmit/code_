package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.common.util.UtilDateTime;
import com.mika.credit.common.util.UtilEncode;
import com.mika.credit.common.util.UtilString;
import com.mika.credit.facade.email.service.EmailService;
import com.mika.credit.facade.email.util.MailSenderInfo;
import com.mika.credit.facade.gugu.dao.UserTokenMapper;
import com.mika.credit.facade.gugu.dao.UsersMapper;
import com.mika.credit.facade.gugu.dao.VerificationCodeMapper;
import com.mika.credit.facade.gugu.model.UserToken;
import com.mika.credit.facade.gugu.model.Users;
import com.mika.credit.facade.gugu.model.VerificationCode;
import com.mika.credit.facade.gugu.service.UserService;
import com.mika.credit.facade.gugu.util.VerificationCodeTools;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private UserTokenMapper userTokenMapper;

	@Autowired
	private VerificationCodeMapper verificationCodeMapper;

	@Autowired
	private EmailService emailService;

	/**
	 * 判断token
	 * @param userId
	 * @param token
	 * @return
	 */
	@Override
	public Boolean judgeToken(Integer userId, String token){
		logger.debug("进入判断token的方法！");
		UserToken userToken = new UserToken();
		userToken.setuId(userId);
		List<UserToken> userTokens = userTokenMapper.selectByPrimaryKeySelective(userToken);
		if (userTokens.size()>0){
			userToken = userTokens.get(0);
			//判断是否在有效时间内
			if (UtilDateTime.isBeforeDate(userToken.getExpireTime(),0,new Date())){
				//判断token是否相等
				if ((userToken.getToken().toString()).equals(token)){
				}else{
					logger.info("判断token方法的返回结果："+false);
					return false;
				}
			}else{
				logger.info("判断token方法的返回结果："+false);
				return false;
			}
		}
		logger.info("判断token方法的返回结果："+true);
		return true;
	}

	/**
	 * 登录
	 * @param data
	 * @return
	 */
	@Override
	public String userLogin(String data){
		logger.debug("进入用户登录方法！");
		ResponseResult<Map<String,Objects>> responseResult = new ResponseResult<>();
		UserToken userToken = new UserToken();
		Users users = JSON.parseObject(data,Users.class);
		if (users!=null&& StringUtil.isNotNull(users.getPwd())&&StringUtil.isNotNull(users.getUserName())) {
			Users usersChangedName = new Users();
			usersChangedName.setUserName(users.getUserName());
			usersChangedName.setPwd(UtilEncode.encodeMD5(users.getPwd()));
			List<Users> usersList = usersMapper.selectByPrimaryKeySelective(usersChangedName);
			if (usersList.size()>0){
				users = usersList.get(0);
				userToken.setuId(users.getId());
				if(StringUtil.isNotNull(users.getPhoneToken())) {    //得到传过来的phoneToken，在每次登录的时候更新当前登录手机的标识
					Users users2 = new Users();
					users2.setPhoneToken(users.getPhoneToken());
					users2.setId(users.getId());
					usersMapper.updateByPrimaryKeySelective(users2);
				}
				List<UserToken> userTokens = userTokenMapper.selectByPrimaryKeySelective(userToken);
				userToken = userTokens.get(0);
				//判断是否过期
				if (UtilDateTime.isBeforeDate(userToken.getExpireTime(),0,new Date())){
					//重新生成token值
					userToken.setToken(Integer.parseInt(UtilString.getRandomNumberByLength(6)));
					userToken.setLastTime(new Date());
					//最后登录时间+30天
					userToken.setExpireTime(dateAdd(30));
					userTokenMapper.updateByPrimaryKeySelective(userToken);
					Map map = new HashedMap();
					map.put("user",users);
					map.put("userToken",userToken);
					responseResult.setCode(true);
					responseResult.setMsg("登录成功!");
					responseResult.setContent(map);
				}else{
					responseResult.setCode(false);
					responseResult.setMsg("登录已过期!");
				}
			}else{
				responseResult.setCode(false);
				responseResult.setMsg("账号密码错误!");
			}
		}else{
			responseResult.setCode(false);
			responseResult.setMsg("用户名密码不为空!");
		}
		logger.info("用户登录方法的返回结果："+JSON.toJSONString(responseResult));
		return JSON.toJSONString(responseResult);
	}

	/**
	 * 注册
	 * @param data
	 * @return
	 */
	@Override
	public String userRegister(String data){
		logger.debug("进入用户注册方法！");
		ResponseResult<Map<String,Objects>> responseResult = new ResponseResult<>();
		UserToken userToken = new UserToken();
		Users users = JSON.parseObject(data,Users.class);
		if (users!=null&& StringUtil.isNotNull(users.getPwd())&&StringUtil.isNotNull(users.getUserName())){
			Users usersChangedName = new Users();
			usersChangedName.setUserName(users.getUserName());
			List<Users> usersList = usersMapper.selectByPrimaryKeySelective(usersChangedName);
			if (usersList.size()>0){
				responseResult.setCode(false);
				responseResult.setMsg("该用户已存在!");
			}else {
				users.setPwd(UtilEncode.encodeMD5(users.getPwd()));
				usersMapper.insert(users);
				//生成token 6位随机数
				userToken.setToken(Integer.parseInt(UtilString.getRandomNumberByLength(6)));
				userToken.setuId(users.getId());
				userToken.setLastTime(new Date());
				//最后登录时间+30天
				userToken.setExpireTime(dateAdd(30));
				userTokenMapper.insert(userToken);
				responseResult.setCode(true);
				responseResult.setMsg("注册成功!");
				Map map = new HashedMap();
				map.put("user",users);
				map.put("userToken",userToken);
				responseResult.setContent(map);
			}
		}else{
			responseResult.setCode(false);
			responseResult.setMsg("用户名密码不为空!");
		}
		logger.info("用户注册方法的返回结果："+JSON.toJSONString(responseResult));
		return JSON.toJSONString(responseResult);
	}

	private Date dateAdd(int days){
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date); //你自己的数据进行类型转换
		calendar.add(calendar.DATE,days);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime();
		return date;
	}

	/**
	 * 发送验证码
	 * @param data
	 * @return
	 */
	@Override
	public String sendVerificationCode(String data){
		logger.debug("进入发送验证码的方法！");
		ResponseResult<String> responseResult = new ResponseResult<>();
		VerificationCode verification = new VerificationCode();
		Users users = new Users();
		JSONObject jsonObject = JSON.parseObject(data);
		String username = jsonObject.getString("userName");
		String type = jsonObject.getString("type");
		if (StringUtil.isNotNull(username)&&StringUtil.isNotNull(type)){
			//生成6位验证码
			String verificationCode = UtilString.getRandomStringByLength(6);
			verification.setTokenCode(verificationCode);
			verification.setUserName(username);
			verification.setCreateTime(new Date());
			verification.setTokenStatus("1");//1为未使用 0为使用

			users.setUserName(username);
			List<Users> usersList = usersMapper.selectByPrimaryKeySelective(users);
			if (usersList.size()>0){
				users = usersList.get(0);
				if (type.equals("phone")){
					if (StringUtil.isNotNull(users.getMobileNum())){
						verification.setUserPhone(users.getMobileNum());
						//手机号发送验证码
						try {
							VerificationCodeTools.sendMobileVerificationCode(users.getMobileNum(),verificationCode);
						} catch (IOException e) {
							e.printStackTrace();
							responseResult.setCode(false);
							responseResult.setMsg("验证码发送失败，接口调用失败!");
							return JSON.toJSONString(responseResult);
						}
						//验证码存库
						verificationCodeMapper.insert(verification);
						responseResult.setCode(true);
						responseResult.setMsg("验证码发送成功!");
					}else{
						responseResult.setCode(false);
						responseResult.setMsg("验证码发送失败，手机号为空!");
					}
				}else if(type.equals("email")){
					if (StringUtil.isNotNull(users.getEmail())){
						verification.setUserEmail(users.getEmail());
						//email发送验证码
						MailSenderInfo mailSenderInfo = VerificationCodeTools.sendEmailVerificationCode(users.getEmail(),verificationCode);
						emailService.sendEmail(mailSenderInfo,"gugu");
						//验证码存库
						verificationCodeMapper.insert(verification);
						responseResult.setCode(true);
						responseResult.setMsg("验证码发送成功!");
					}else{
						responseResult.setCode(false);
						responseResult.setMsg("验证码发送失败，email为空!");
					}
				}else{
					responseResult.setCode(false);
					responseResult.setMsg("验证码发送失败，方法错误!");
				}

			}else{
				responseResult.setCode(false);
				responseResult.setMsg("验证码发送失败，查无此用户!");
			}
		}else{
			responseResult.setCode(false);
			responseResult.setMsg("验证码发送失败，参数不能为空!");
		}
		logger.info("发送验证码方法的返回结果："+JSON.toJSONString(responseResult));
		return JSON.toJSONString(responseResult);
	}

	/**
	 * 核实验证码
	 * @param data
	 * @return
	 */
	@Override
	public String verifyVerificationCode(String data){
		logger.debug("进入核实验证码的方法！");
		ResponseResult<String> responseResult = new ResponseResult<>();
		VerificationCode verification = new VerificationCode();
		JSONObject jsonObject = JSON.parseObject(data);
		String username = jsonObject.getString("userName");
		String tokenCode = jsonObject.getString("tokenCode");
		if (StringUtil.isNotNull(username)&&StringUtil.isNotNull(tokenCode)) {
			verification.setUserName(username);
			verification.setTokenCode(tokenCode);
			verification.setTokenStatus("1");//1为未使用 0为使用
			List<VerificationCode> verificationCodeList = verificationCodeMapper.selectByPrimaryKeySelective(verification);
			if (verificationCodeList.size()>0){
				//使用验证码
				verification = verificationCodeList.get(0);
				verification.setTokenStatus("0");
				verificationCodeMapper.updateByPrimaryKeySelective(verification);
				responseResult.setCode(true);
				responseResult.setMsg("核实验证码成功!");
			}else{
				responseResult.setCode(false);
				responseResult.setMsg("核实验证码失败，验证码无效!");

			}
		}else{
			responseResult.setCode(false);
			responseResult.setMsg("核实验证码失败，参数不能为空!");
		}
		logger.info("核实验证码方法的返回结果："+JSON.toJSONString(responseResult));
		return JSON.toJSONString(responseResult);
	}


	/**
	 * 获取用户资料
	 * @param data
	 * @return
	 */
	@Override
	public String getUserInfo(String data){
		logger.debug("进入获取用户资料的方法！");
		ResponseResult<Users> responseResult = new ResponseResult<>();
		JSONObject jsonObject = JSON.parseObject(data);
		String userId = jsonObject.getString("userId");
		if (StringUtil.isNotNull(userId)){
			Users users = usersMapper.selectByPrimaryKey(Integer.parseInt(userId));
			if (StringUtil.isNotNull(users)){
				responseResult.setCode(true);
				responseResult.setMsg("获取用户资料成功!");
				responseResult.setContent(users);
			}else{
				responseResult.setCode(false);
				responseResult.setMsg("获取用户资料失败，查无此用户!");
			}

		}else{
			responseResult.setCode(false);
			responseResult.setMsg("获取用户资料失败，参数错误!");
		}
		logger.info("获取用户资料方法的返回结果："+JSON.toJSONString(responseResult));
		return JSON.toJSONString(responseResult);
	}


	/**
	 * 通过username修改密码
	 * @param data
	 * @return
	 */
	@Override
	public String changeUserPwd(String data){
		logger.debug("进入通过username修改密码的方法！");
		ResponseResult<String> responseResult = new ResponseResult<>();
		Users users = new Users();
		JSONObject jsonObject = JSON.parseObject(data);
		String username = jsonObject.getString("userName");
		String pwd = jsonObject.getString("pwd");
		if (StringUtil.isNotNull(username)&&StringUtil.isNotNull(pwd)) {
			users.setUserName(username);
			List<Users> usersList = usersMapper.selectByPrimaryKeySelective(users);
			if (usersList.size()>0){
				users = usersList.get(0);
				users.setPwd(UtilEncode.encodeMD5(pwd));
				usersMapper.updateByPrimaryKeySelective(users);
				responseResult.setCode(true);
				responseResult.setMsg("修改密码成功!");
			}else{
				responseResult.setCode(false);
				responseResult.setMsg("修改密码失败，未查到该账户!");
			}
		}else{
			responseResult.setCode(false);
			responseResult.setMsg("修改密码失败，用户名密码不能为空!");
		}
		logger.info("通过username修改密码方法的返回结果："+JSON.toJSONString(responseResult));
		return JSON.toJSONString(responseResult);
	}


	/**
	 * 修改用户资料
	 * @param data
	 * @return
	 */
	@Override
	public String changeUserInfo(String data){
		logger.debug("进入修改用户资料的方法！");
		ResponseResult<String> responseResult = new ResponseResult<>();
		Users users = JSON.parseObject(data,Users.class);
		if (StringUtil.isNotNull(users)&&StringUtil.isNotNull(users.getId())){
			usersMapper.updateByPrimaryKeySelective(users);
			responseResult.setCode(true);
			responseResult.setMsg("修改用户资料成功!");
		}else{
			responseResult.setCode(false);
			responseResult.setMsg("修改用户资料失败，参数错误!");
		}
		logger.info("修改用户资料方法的返回结果："+JSON.toJSONString(responseResult));
		return JSON.toJSONString(responseResult);
	}

	/**
	 * 上传用户头像图片
	 * @param data
	 * @return
	 */
	@Override
	public String changeUserPic(String data,String path){
		logger.debug("进入上传用户头像图片的方法！");
		ResponseResult<String> responseResult = new ResponseResult<>();
		Users users = JSON.parseObject(data,Users.class);
		if (StringUtil.isNotNull(users)&&StringUtil.isNotNull(users.getId())){
			//上传图片
//			String path = UploadFile.uploadMufile(file);
			if (StringUtil.isNotNull(path)){
				users.setShowPhotoPath(path);
				usersMapper.updateByPrimaryKeySelective(users);
				responseResult.setCode(true);
				responseResult.setMsg("用户头像图片修改成功!");
			}else{
				responseResult.setCode(false);
				responseResult.setMsg("用户头像图片修改失败，图片上传失败!");
			}
		}else{
			responseResult.setCode(false);
			responseResult.setMsg("用户头像图片修改失败，参数错误!");
		}
		logger.info("上传用户头像图片方法的返回结果："+JSON.toJSONString(responseResult));
		return JSON.toJSONString(responseResult);
	}
	/**
	 * 获取用户信息
	 * @param data
	 * @return
	 */
	@Override
	public String getUser(String data) {
		logger.debug("进入获取用户信息的方法！");
		ResponseResult<Users> responseResult = new ResponseResult<>();
		Users users = JSON.parseObject(data,Users.class);
		List<Users> usersList = usersMapper.selectByPrimaryKeySelective(users);
		if (usersList.size()>0){
			responseResult.setContent(usersList.get(0));
			responseResult.setCode(true);
			responseResult.setMsg("获取用户信息成功!");
		}else {
			responseResult.setCode(false);
			responseResult.setMsg("获取用户信息失败，查无此用户!");
		}
		logger.info("获取用户信息方法的返回结果："+JSON.toJSONString(responseResult));
		return JSON.toJSONString(responseResult);
	}


}
