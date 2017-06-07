package com.mika.credit.web.globaleagle.controller.core.nomal;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.UtilString;
import com.mika.credit.facade.email.service.EmailService;
import com.mika.credit.facade.globaleagle.core.model.*;
import com.mika.credit.facade.globaleagle.core.service.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Controller
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmailService emailService;

    /**
     * 登录
     *
     * @param customer
     * @param map
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(Customer customer, ModelMap map, HttpServletRequest request) {
        logger.info("登录开始...");
        String url = "index.do";
        if (request.getSession().getAttribute("url") == null) {
        } else {
            url = request.getSession().getAttribute("url").toString();
        }
        request.getSession().setAttribute("url", null);
        if (customer.getCode() != null && !customer.getCode().equals("") && customer.getPasswd() != null && !customer.getPasswd().equals("")) {
            ResponseResult<Customer> customerResult = customerService.getLoginInfo(customer);
            if (customerResult.getCode()) {
                if (url.toLowerCase().indexOf("logout.do") >= 0 || url.toLowerCase().indexOf("login.do") >= 0) {
                    url = "/user/toCartList.do";
                }
                if (url.toLowerCase().indexOf("register.do") >= 0) {
                    url = "/user/toCartList.do";
                }

                request.getSession().setAttribute("customerInfo", customerResult.getContent());
                request.getSession().removeAttribute("message");
                request.getSession().removeAttribute("messageRegister");
                return "redirect:" + url;
            } else {
                //若不对,则将错误信息显示到错误页面
                map.addAttribute("message", "用户名密码错误");
                return "/login";
            }
        } else {
            map.addAttribute("message", "用户名密码不能为空");
            return "/login";
        }
    }

    /**
     * 登出
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        logger.info("登出开始...");
        request.getSession().removeAttribute("message");
        request.getSession().removeAttribute("messageRegister");
        request.getSession().removeAttribute("customerInfo");
        return "/index";

    }

    /**
     * 手机号发送验证码
     *
     * @param request
     * @param customer
     * @return
     */
    @RequestMapping(value = "/sendVerificationCode", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String sendVerificationCode(HttpServletRequest request, Customer customer) {
        logger.info("手机号发送验证码开始...");
        ResponseResult<Customer> customerResponseResult = new ResponseResult<>();
        if (!isChinaPhoneLegal(customer.getMobile())) {
            customerResponseResult.setCode(false);
            customerResponseResult.setMsg("请输入正确的手机格式");
            return JSON.toJSONString(customerResponseResult);
        }
        if (customer.getMobile() == null || customer.getMobile().equals("")){
            customerResponseResult.setCode(false);
            customerResponseResult.setMsg("手机号不能为空");
            return JSON.toJSONString(customerResponseResult);
        } else {
            //生成随机验证码4位
            String VerificationCode = UtilString.getRandomNumberByLength(4);
            try {
                //发送验证码
                sendMobileVerificationCode(customer.getMobile(), VerificationCode);
            } catch (IOException e) {
                e.printStackTrace();
            }
            customer.setTheme(VerificationCode);
            customerResponseResult = customerService.registerVerificationCode(customer);
        }
        return JSON.toJSONString(customerResponseResult);
    }




    /**
     * 手机号注册
     *
     * @param request
     * @param customer
     * @param map
     * @return
     */
    @RequestMapping(value = "/mobileRegister")
    public String mobileRegister(HttpServletRequest request, Customer customer, ModelMap map) {
        logger.info("手机号注册开始...");
        if (customer.getMobile() != null && !customer.getMobile().equals("") && customer.getPasswd() != null && !customer.getPasswd().equals("")&& customer.getTheme() != null && !customer.getTheme().equals("")) {
            customer.setCode(customer.getMobile());
            ResponseResult<Customer> customerResult = customerService.getRegisterInfo(customer);
            if (customerResult.getCode()) {
                //注册成功跳转首页
                request.getSession().setAttribute("customerInfo", customerResult.getContent());
                map.addAttribute("messageRegister", "注册成功");
                return "/index";
            } else {
                map.addAttribute("messageRegister", "用户名已存在");
                return "/login";
            }
        } else {
            map.addAttribute("messageRegister", "用户名密码验证码不能为空");
            return "/login";
        }
    }


    /**
     * 邮箱注册
     *
     * @param request
     * @param customer
     * @param map
     * @return
     */
    @RequestMapping(value = "/emailRegister")
    public String emailRegister(HttpServletRequest request, Customer customer, ModelMap map) {
        logger.info("邮箱注册开始...");
        if (customer.getEmail() != null && !customer.getEmail().equals("") && customer.getPasswd() != null && !customer.getPasswd().equals("")) {
            customer.setCode(customer.getEmail());
        } else {
            map.addAttribute("messageRegister", "用户名密码不能为空");
            return "/login";
        }
        ResponseResult<Customer> customerResult = customerService.getRegisterInfo(customer);
        if (customerResult.getCode()) {
            Map<String,Object> mapData = new HashedMap();
            mapData.put("toAddress",customerResult.getContent().getEmail());
            emailService.sendEmail("globalEagle","register",mapData);
            //注册成功跳转首页
            request.getSession().setAttribute("customerInfo", customerResult.getContent());
            map.addAttribute("messageRegister", "注册成功");
            return "/index";
        } else {
            map.addAttribute("messageRegister", "用户名已存在");
            return "/login";
        }

    }


    /**
     * 忘记密码
     *
     * @param json
     * @return
     */
    @RequestMapping(value = "/forgetPW", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String forgetPW(HttpServletRequest request, @RequestBody String json) {
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
     *
     * @param json
     * @return
     */
    @RequestMapping(value = "/resetPW", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String resetPW(@RequestBody String json) {
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

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
    public static boolean isChinaPhoneLegal( String str ) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 发送email短信
     *
     * @param mobileNumber
     * @throws IOException
     */
    public void sendMobileVerificationCode(String mobileNumber, String VerificationCode) throws IOException {
        //发送内容
        String number = VerificationCode;
        String content = "欢迎注册，您的验证码是" + number + "。有效期一个小时请在页面中提交验证码完成验证。";
        String sign = "全球鹰";

        // 创建StringBuffer对象用来操作字符串
        StringBuffer sb = new StringBuffer("http://web.duanxinwang.cc/asmx/smsservice.aspx?");

        // 向StringBuffer追加用户名
        sb.append("name=dxwaaron");

        // 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
        sb.append("&pwd=A8801F141C5F1B75479C4C492A28");

        // 向StringBuffer追加手机号码
        sb.append("&mobile=");

        sb.append(mobileNumber);

        // 向StringBuffer追加消息内容转URL标准码
        sb.append("&content=" + URLEncoder.encode(content, "UTF-8"));

        //追加发送时间，可为空，为空为及时发送
        sb.append("&stime=");

        //加签名
        sb.append("&sign=" + URLEncoder.encode(sign, "UTF-8"));

        //type为固定值pt  extno为扩展码，必须为数字 可为空
        sb.append("&type=pt&extno=");
        // 创建url对象
        //String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
        System.out.println("sb:" + sb.toString());
        URL url = new URL(sb.toString());

        // 打开url连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 设置url请求方式 ‘get’ 或者 ‘post’
        connection.setRequestMethod("POST");

        // 发送
        InputStream is = url.openStream();

        //转换返回值
        String returnStr = convertStreamToString(is);

        // 返回结果为‘0，20140009090990,1，提交成功’ 发送成功   具体见说明文档
        System.out.println(returnStr);
        // 返回发送结果
    }

    /**
     * 转换返回值类型为UTF-8格式.
     *
     * @param is
     * @return
     */
    public static String convertStreamToString(InputStream is) {
        StringBuilder sb1 = new StringBuilder();
        byte[] bytes = new byte[4096];
        int size = 0;

        try {
            while ((size = is.read(bytes)) > 0) {
                String str = new String(bytes, 0, size, "UTF-8");
                sb1.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb1.toString();
    }
}