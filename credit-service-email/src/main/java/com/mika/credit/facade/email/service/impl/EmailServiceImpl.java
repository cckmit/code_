package com.mika.credit.facade.email.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.Tool;
import com.mika.credit.facade.email.dao.EmailLogFileMapper;
import com.mika.credit.facade.email.model.EmailLogFile;
import com.mika.credit.facade.email.service.EmailService;
import com.mika.credit.facade.email.util.MailSenderInfo;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

/**
 * Created by michael on 2016/8/31.
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService {

    private static Logger logger = Logger.getLogger(EmailServiceImpl.class);

    @Autowired
    private EmailLogFileMapper emailLogFileMapper;

    /**
     * 发送email

     * @return
     * @throws UnsupportedEncodingException
     */
    /**
     * 发送email 自定义参数：toAddress(接收地址),copyToAddress(抄送地址),content(邮件内容),attachFileNames(邮件附件),imgType(图片)
     *           非自定义参数：mailServerHost(发送方服务器地址)，mailServerPort(发送发端口号),fromAddress(发送方地址),userName(发送方用户名)
     *                        password(发送方密码),validate(验证),subject(邮件主题)
     * @param mail
     * @return
     *
     */
    //发送Email(MailSenderInfo类型)
    @Override
    public ResponseResult<String> sendEmail(MailSenderInfo mail, String invokeObj){
        logger.info("发送邮件信息："+mail);
        ResponseResult result = new ResponseResult<MailSenderInfo>();
        if(invokeObj == null || "".equals(invokeObj)){
            result.setMsg("调用者不得为空");
            result.setCode(false);
            logger.debug("调用者为空："+invokeObj);
            return result;
        }
        if(mail == null){
            result.setMsg("邮件信息不能为空");
            result.setCode(false);
            logger.debug("邮件信息为空："+mail);
            return result;
        }else{
            logger.debug("进入判断和设定邮件信息方法：transMailVal");
            result = transMailVal(mail,invokeObj);
        }
        return result;
    }

    public ResponseResult<String> transMailVal(MailSenderInfo mail, String invokeObj){
        EmailLogFile emailDetail = new EmailLogFile();
        //设定调用方法起始时间
        emailDetail.setStartTime(new Date());
        emailDetail.setInvokeObj(invokeObj);

        logger.info("该方法内进行判断和设定邮件信息的值"+mail);
        ResponseResult<String> result = new ResponseResult<String>();
        Map<String, String> map = Tool.loadEmailInfo();
        logger.debug("获取email基本信息数据："+map);
        if(mail.getToAddress() == null || "".equals(mail.getToAddress())){
            result.setMsg("收件人地址不能为空");
            result.setCode(false);
            logger.debug("未能获取到收件人地址："+mail.getToAddress());
            return result;
        }
        if(mail.getContent() == null || "".equals(mail.getContent())){
            result.setMsg("发送的内容不能为空");
            result.setCode(false);
            logger.debug("发送的内容为空："+mail.getContent());
            return result;
        }else{
            StringBuffer data = new StringBuffer();
            data.append(mail.getContent().toString());
            logger.debug("将发送内容转成StringBuffer类的字符串："+data.append(mail.getContent().toString()));
        }
        if(mail.getMailServerHost() == null || "".equals(mail.getMailServerHost())){
            mail.setMailServerHost(map.get("emailSmtp"));
            logger.debug("发送方服务器："+mail.getMailServerHost());
        }else{
            mail.setMailServerHost(map.get("emailSmtp"));
        }
        if(mail.getMailServerPort() == null || "".equals(mail.getMailServerPort())){
            mail.setMailServerPort(map.get("emailServerPort"));
            logger.debug("发送方端口号："+mail.getMailServerPort());
        }else{
            mail.setMailServerPort(map.get("emailServerPort"));
        }
        if(mail.getUserName() == null || "".equals(mail.getUserName())){
            mail.setUserName(map.get("emailName"));
            logger.debug("发送方端口号："+mail.getUserName());
        }else{
            mail.setUserName(map.get("emailName"));
        }
        if(mail.getPassword() == null || "".equals(mail.getPassword())){
            mail.setPassword(map.get("emailPwd"));
            logger.debug("发送方密码："+mail.getPassword());
        }else{
            mail.setPassword(map.get("emailPwd"));
        }
        if(mail.getFromAddress() == null || "".equals(mail.getFromAddress())){
            mail.setFromAddress(map.get("emailFromAddress"));
            logger.debug("发送方地址："+mail.getFromAddress());
        }else{
            mail.setFromAddress(map.get("emailFromAddress"));
        }
        mail.setValidate(true);
        if(mail.getSubject() == null || "".equals(mail.getSubject())){
            mail.setSubject("全球鹰订购信息");
            logger.debug("发送邮件的主题："+mail.getSubject());
        }
        //todo
        //抄送地址
        //mail.setCopyToAddress("jack.zhu@3acredit.cn");
        Boolean successOrNot = true;
        try{
            successOrNot = SimpleMailSender.sendHtmlMail(mail);
            if(successOrNot == true){
                result.setMsg("邮件发送成功");
                result.setCode(true);
                logger.debug("邮件发送成功------"+successOrNot);
                emailDetail.setIsSuccess(result.getMsg());
            }else{
                result.setMsg("邮件未能成功发送");
                result.setCode(false);
                logger.debug("邮件发送不成功------"+successOrNot);
                emailDetail.setIsSuccess(result.getMsg());
            }
            emailDetail.setSendMail(mail.getFromAddress());
            emailDetail.setReceiveMail(mail.getToAddress());
            emailDetail.setCopytoMail(mail.getCopyToAddress());
            emailDetail.setMailContent(mail.getContent());
            if(mail.getSubject() != null && !"".equals(mail.getSubject())){
                emailDetail.setMailSubject(mail.getSubject());
            }
            emailDetail.setEndTime(new Date());
            if(emailLogFileMapper.insertSelective(emailDetail) > 0){
                result.setMsg("邮件日志插入成功");
                result.setCode(true);
                logger.debug("邮件日志插入成功");
            }else{
                result.setMsg("邮件日志未能成功插入");
                result.setCode(false);
                logger.debug("邮件日志未能成功插入");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("发送邮件出错了:"+e);
        }
        return result;
    }

    //发送Email(receiverEmail(收件人),content(内容))
    @Override
    public ResponseResult<String> sendEmailParameter(String receiverEmail,String content,String invokeObj){
        logger.info("发送邮件信息传参内容---收件方："+receiverEmail+"---content:"+content);
        ResponseResult result = new ResponseResult();
        if(invokeObj == null || "".equals(invokeObj)){
            result.setMsg("调用者不得为空");
            result.setCode(false);
            logger.debug("调用者为空："+invokeObj);
            return result;
        }
        logger.info("进入对参数进行判断和邮件信息判断且赋值方法：transEmailParameter");
        result = transEmailParameter(receiverEmail,content,invokeObj);
        return result;
    }

    public ResponseResult<String> transEmailParameter(String receiverEmail,String content,String invokeObj) {
        logger.info("该方法对参数进行判断和邮件信息判断且赋值方法：transEmailParameter");
        ResponseResult result = new ResponseResult();
        EmailLogFile emailDetail = new EmailLogFile();
        //设定调用方法起始时间
        emailDetail.setStartTime(new Date());
        emailDetail.setInvokeObj(invokeObj);
        MailSenderInfo mail = new MailSenderInfo();
        Map<String, String> map = Tool.loadEmailInfo();
        logger.debug("获取email基本信息数据："+map);
        if(receiverEmail == null || "".equals(receiverEmail)){
            result.setMsg("收件方不能为空");
            result.setCode(false);
            logger.debug("收件方为空："+receiverEmail);
            return result;
        }else{
            mail.setToAddress(receiverEmail);
        }
        if(content == null || "".equals(content)){
            result.setMsg("内容不能为空");
            result.setCode(false);
            logger.debug("内容为空："+content);
            return result;
        }else{
            mail.setContent(content);
        }
        mail.setMailServerHost(map.get("emailSmtp"));
        mail.setMailServerPort(map.get("emailServerPort"));
        mail.setValidate(true);
        mail.setUserName(map.get("emailName"));
        mail.setPassword(map.get("emailPwd"));
        mail.setFromAddress(map.get("emailFromAddress"));
        //mail.setCopyToAddress("jack.zhu@3acredit.cn");
        mail.setSubject("全球鹰订购信息");
        logger.debug("进入以html形式发送邮件的方法：sendHtmlMail");
        Boolean isSuccessOrNot = true;
        try{
            isSuccessOrNot = SimpleMailSender.sendHtmlMail(mail);
            if(isSuccessOrNot == true){
                result.setMsg("邮件发送成功");
                result.setCode(true);
                logger.debug("邮件发送成功------"+isSuccessOrNot);
                emailDetail.setIsSuccess(result.getMsg());
            }else{
                result.setMsg("邮件未能成功发送");
                result.setCode(false);
                logger.debug("邮件发送不成功------"+isSuccessOrNot);
                emailDetail.setIsSuccess(result.getMsg());
            }
            emailDetail.setSendMail(mail.getFromAddress());
            emailDetail.setReceiveMail(mail.getToAddress());
            emailDetail.setCopytoMail(mail.getCopyToAddress());
            emailDetail.setMailContent(mail.getContent());
            emailDetail.setMailSubject(mail.getSubject());
            emailDetail.setEndTime(new Date());
            if(emailLogFileMapper.insertSelective(emailDetail) > 0){
                result.setMsg("邮件日志插入成功");
                result.setCode(true);
                logger.debug("邮件日志插入成功");
            }else{
                result.setMsg("邮件日志未能成功插入");
                result.setCode(false);
                logger.debug("邮件日志未能成功插入");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("发送邮件出错了:"+e);
        }
        return result;
    }


    /**
     *
     * @param type globalEagle在不同情况下需发送邮件内容的类型（1代表forget忘记密码、2代表order订单、3代表register注册、4代表report报告）
     *         emailData 发送邮件需用到的数据进行封装（用于展现HTML页面样式）
     * @param emailData
     * @return
     */
//    public ResponseResult<String> sendEmail(Integer type, EmailData emailData) {
//        ResponseResult result = new ResponseResult();
//        if(type == null || type == 0 ){
//            result.setMsg("指定类型不能为空");
//            result.setCode(false);
//            logger.debug("指定类型为空："+type);
//            return result;
//        }
//        if(emailData == null || "".equals(emailData) ){
//            result.setMsg("邮件内容不能为空");
//            result.setCode(false);
//            logger.debug("邮件内容为空："+emailData);
//            return result;
//        }
//        EmailServiceGE serviceGE = null;
//        switch (type){
//            case 1:
//                serviceGE = (EmailServiceGE) SpringContextUtils.getBean("emailServiceForgetImpl");
//                break;
//            case 2:
//                serviceGE = (EmailServiceGE) SpringContextUtils.getBean("emailServiceOrderImpl");
//                break;
//            case 3:
//                serviceGE = (EmailServiceGE) SpringContextUtils.getBean("emailServiceRegisterImpl");
//                break;
//            default:
//                serviceGE = (EmailServiceGE) SpringContextUtils.getBean("emailServiceReportImpl");
//                break;
//        }
//        return serviceGE.sendEmail(emailData);
//    }

    /**
     *
     * @param invokeObj 调用方 例如 全球鹰必须定义为("globalEagle") 全搜必须定义为（"globalSearch"）均为字符串类型
     * @param templateType 模版类型 "忘记密码"必须定义为("forget") 注册成功必须定义为("register") 发送报告必须("report") 支付成功必须定义为("order")
     * @param mapData 接收Map传递的数据 根据约定
     *                                    forget:放入map的key必须定义成"url"(表示链接至修改密码的页面)、"toAddress"(表示收件人) 跟上相应的值即可
     *                                    register:放入map的key必须定义成"toAddress"(表示收件人) 跟上相应的值即可
     *                                    report：放入map的key必须定义成"toAddress"(表示收件人) 跟上相应的值即可 后期需加上附件内容
     *                                    order: 放入map的key必须定义成"toAddress"(表示收件人) 另须将传送的数据封装至orders对象再转成String类型，其中key必须定义成"orders" 跟上相应的值即可
     *                补充：1、map中的"toAddress"为基础数据 所有的模版必须传该值
     *                      2、抄送人若没有则可以不传，视为无抄送人
     * @return
     */
    @Override
    public ResponseResult<String> sendEmail(String invokeObj, String templateType, Map<String, Object> mapData) {
        logger.info("进入发送邮件信息");
        ResponseResult result = new ResponseResult<MailSenderInfo>();
        if(invokeObj == null || "".equals(invokeObj)){
            result.setMsg("调用者不得为空");
            result.setCode(false);
            logger.debug("调用者为空："+invokeObj);
            return result;
        }
        if(templateType == null || "".equals(templateType)){
            result.setMsg("模版类型不得为空");
            result.setCode(false);
            logger.debug("模版类型为空："+invokeObj);
            return result;
        }
        if(mapData == null || "".equals(mapData)){
            result.setMsg("参数不得为空");
            result.setCode(false);
            logger.debug("模版类型为空："+invokeObj);
            return result;
        }
        MailSenderInfo mail = new MailSenderInfo();
        //日志
        EmailLogFile emailDetail = new EmailLogFile();
        //设定调用方法起始时间
        emailDetail.setStartTime(new Date());
        emailDetail.setInvokeObj(invokeObj);
        Map<String, String> map = Tool.loadEmailInfo();
        String emailImagesPath = "";
        //获取email图片路径
        if(map.get("emailImagesPath")!=null && !"".equals(map.get("emailImagesPath"))){
            emailImagesPath = map.get("emailImagesPath");
            logger.debug("获取email图片路径："+map.get("emailImagesPath"));
        }else{
            result.setMsg("未能获取到email图片路径");
            result.setCode(false);
            logger.debug("获取email图片路径失败："+invokeObj);
            return result;
        }
        logger.debug("获取email基本信息数据："+map);
        if(map.get("emailSmtp")!=null && !"".equals(map.get("emailSmtp"))){
            mail.setMailServerHost(map.get("emailSmtp"));
            logger.debug("发送方服务器："+mail.getMailServerHost());
        }
        if(map.get("emailServerPort")!=null && !"".equals(map.get("emailServerPort"))){
            mail.setMailServerPort(map.get("emailServerPort"));
            logger.debug("发送方端口号："+mail.getMailServerPort());
        }
        if(map.get("emailName")!=null && !"".equals(map.get("emailName"))){
            mail.setUserName(map.get("emailName"));
            logger.debug("发送方端口号："+mail.getUserName());
        }
        if(map.get("emailPwd")!=null && !"".equals(map.get("emailPwd"))){
            mail.setPassword(map.get("emailPwd"));
            logger.debug("发送方密码："+mail.getPassword());
        }
        if(map.get("emailFromAddress")!=null && !"".equals(map.get("emailFromAddress"))){
            mail.setFromAddress(map.get("emailFromAddress"));
            logger.debug("发送方地址："+mail.getFromAddress());
        }
        if(mapData.get("toAddress") == null || "".equals(mapData.get("toAddress")) ){
            result.setMsg("收件人地址不能为空");
            result.setCode(false);
            logger.debug("未能获取到收件人地址：" + mapData.get("toAddress"));
            return result;
        }else{
            mail.setToAddress(String.valueOf(mapData.get("toAddress")));
        }
        if(mapData.get("copyToAddress") != null && !"".equals(mapData.get("copyToAddress")) ){
            mail.setCopyToAddress(String.valueOf(mapData.get("copyToAddress")));
        }
        mail.setValidate(true);
        //初始化并取得Velocity引擎
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        Properties p = new Properties();
        p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        velocityEngine.init(p);
        //取得velocity的模版
        Template template = null;
        //取得velocity的上下文context
        VelocityContext context = null;
        StringWriter stringWriter = null;
        if("globalEagle".equals(invokeObj)){
            if("forget".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalEagle/"+templateType+".vm");
                if(mapData.get("url") == null || "".equals(mapData.get("url"))){
                    result.setMsg("url不能为空");
                    result.setCode(false);
                    logger.debug("未能获取到url：" + mapData.get("url"));
                    return result;
                }else{
                    context.put("url",mapData.get("url"));
                }
                context.put("toAddress",mapData.get("toAddress"));
                context.put("emailImagesPath",emailImagesPath);
                stringWriter = new StringWriter();
                template.merge(context,stringWriter);
                mail.setContent(stringWriter.toString());
                if(null == mapData.get("subject") || "".equals(mapData.get("subject"))) {
                    mail.setSubject("欢迎使用全球鹰");
                }
            }else if("report".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalEagle/"+templateType+".vm");
                if(mapData.get("url") == null || "".equals(mapData.get("url"))){
                    result.setMsg("url不能为空");
                    result.setCode(false);
                    logger.debug("未能获取到url：" + mapData.get("url"));
                    return result;
                }else{
                    context.put("url",mapData.get("url"));
                }
                context.put("emailImagesPath",emailImagesPath);
                context.put("toAddress",mapData.get("toAddress"));
                stringWriter = new StringWriter();
                template.merge(context,stringWriter);
                mail.setContent(stringWriter.toString());
                if(null == mapData.get("subject") || "".equals(mapData.get("subject"))) {
                    mail.setSubject("欢迎使用全球鹰");
                }
            }else if("register".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalEagle/"+templateType+".vm");
                context.put("toAddress",mapData.get("toAddress"));
                context.put("emailImagesPath",emailImagesPath);
                stringWriter = new StringWriter();
                template.merge(context,stringWriter);
                mail.setContent(stringWriter.toString());
                if(null == mapData.get("subject") || "".equals(mapData.get("subject"))) {
                    mail.setSubject("欢迎使用全球鹰");
                }
            }else if("order".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalEagle/"+templateType+".vm");
                if(mapData.get("orders") == null || "".equals(mapData.get("orders"))){
                    result.setMsg("orders不能为空");
                    result.setCode(false);
                    logger.debug("未能获取到orders：" + mapData.get("orders"));
                    return result;
                }else{
                    String orders = (String)mapData.get("orders");
                    String creatTime = "";
                    String noObj = null;//订单号
                    String amountActualObj = null;//总价
                    String remarkObj = null;//备注
                    JSONArray orderDetailsArray = null;//报告内容
                    JSONObject ordersJsonObj = JSONObject.parseObject(orders);
                    if(ordersJsonObj.getString("createTime") == null || "".equals(ordersJsonObj.getString("createTime")) ){
                        result.setMsg("createTime不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到createTime：" + ordersJsonObj.getString("createTime"));
                        return result;
                    }else{
                        Date createTimeObj = ordersJsonObj.getDate("createTime");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        creatTime = sdf.format(createTimeObj);//格式化订购日期
                    }
                    if(ordersJsonObj.getString("no") == null || "".equals(ordersJsonObj.getString("no"))){
                        result.setMsg("no不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到no：" + ordersJsonObj.getString("no"));
                        return result;
                    }else{
                        noObj = ordersJsonObj.getString("no");
                    }
                    if(ordersJsonObj.getString("amountActual") == null || "".equals(ordersJsonObj.getString("amountActual"))) {
                        result.setMsg("amountActual不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到amountActual：" + ordersJsonObj.getString("amountActual"));
                        return result;
                    }else{
                        amountActualObj = ordersJsonObj.getString("amountActual");
                    }
                    if(ordersJsonObj.getString("remark") == null || "".equals(ordersJsonObj.getString("remark"))) {
                        remarkObj="-";
                    }else{
                        remarkObj = ordersJsonObj.getString("remark");
                    }

                    if(ordersJsonObj.getJSONArray("orderDetails") != null && ordersJsonObj.getJSONArray("orderDetails").size() > 0){
                        orderDetailsArray = ordersJsonObj.getJSONArray("orderDetails");
                    }else{
                        result.setMsg("OrderDetail不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到OrderDetail：" + ordersJsonObj.getJSONArray("OrderDetail"));
                        return result;
                    }
                    context.put("emailImagesPath",emailImagesPath);
                    context.put("creatTime",creatTime);
                    context.put("noObj",noObj);
                    context.put("amountActualObj",amountActualObj);
                    context.put("remarkObj",remarkObj);
                    context.put("orderDetailArray",orderDetailsArray);
                    stringWriter = new StringWriter();
                    template.merge(context,stringWriter);
                    mail.setContent(stringWriter.toString());
                    if(null == ordersJsonObj.getJSONObject("subject") || "".equals(ordersJsonObj.getJSONObject("subject"))) {
                        mail.setSubject("感谢您的订购，我们正在处理您的订购信息");
                    }
                }
            }else if("cancel".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalEagle/"+templateType+".vm");
                if(mapData.get("orders") == null || "".equals(mapData.get("orders"))){
                    result.setMsg("orders不能为空");
                    result.setCode(false);
                    logger.debug("未能获取到orders：" + mapData.get("orders"));
                    return result;
                }else{
                    String orders = (String)mapData.get("orders");
                    String creatTime = "";
                    String noObj = null;//订单号
                    String remarkObj = null;//备注
                    String amountActualObj = null;//备注
                    JSONObject ordersJsonObj = JSONObject.parseObject(orders);
                    if(ordersJsonObj.getString("createTime") == null || "".equals(ordersJsonObj.getString("createTime")) ){
                        result.setMsg("createTime不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到createTime：" + ordersJsonObj.getString("createTime"));
                        return result;
                    }else{
                        Date createTimeObj = ordersJsonObj.getDate("createTime");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        creatTime = sdf.format(createTimeObj);//格式化订购日期
                    }
                    if(ordersJsonObj.getString("no") == null || "".equals(ordersJsonObj.getString("no"))){
                        result.setMsg("no不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到no：" + ordersJsonObj.getString("no"));
                        return result;
                    }else{
                        noObj = ordersJsonObj.getString("no");
                    }
                    if(ordersJsonObj.getString("remark") == null || "".equals(ordersJsonObj.getString("remark"))) {
                        remarkObj = "-";
                    }else{
                        remarkObj = ordersJsonObj.getString("remark");
                    }
                    if(ordersJsonObj.getString("amountActual") == null || "".equals(ordersJsonObj.getString("amountActual"))) {
                        result.setMsg("amountActual不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到amountActual：" + ordersJsonObj.getString("amountActual"));
                        return result;
                    }else{
                        amountActualObj = ordersJsonObj.getString("amountActual");
                    }
                    context.put("emailImagesPath",emailImagesPath);
                    context.put("toAddress",mapData.get("toAddress"));
                    context.put("creatTime",creatTime);
                    context.put("no",noObj);
                    context.put("remark",remarkObj);
                    context.put("amountActual",amountActualObj);
                    stringWriter = new StringWriter();
                    template.merge(context,stringWriter);
                    mail.setContent(stringWriter.toString());
                    if(null == ordersJsonObj.getJSONObject("subject") || "".equals(ordersJsonObj.getJSONObject("subject"))) {
                        mail.setSubject("欢迎使用全球鹰");
                    }
                }
            }else if("count".equals(templateType) || "approveSuccess".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalEagle/"+templateType+".vm");
                context.put("toAddress",mapData.get("toAddress"));
                context.put("emailImagesPath",emailImagesPath);
                stringWriter = new StringWriter();
                template.merge(context,stringWriter);
                mail.setContent(stringWriter.toString());
                if(null == mapData.get("subject") || "".equals(mapData.get("subject"))) {
                    mail.setSubject("欢迎使用全球鹰");
                }
            }else if("fastOrder".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalEagle/"+templateType+".vm");
                if(mapData.get("quickOrder") == null || "".equals(mapData.get("quickOrder"))){
                    result.setMsg("quickOrder不能为空");
                    result.setCode(false);
                    logger.debug("未能获取到quickOrder：" + mapData.get("orders"));
                    return result;
                }else{
                    String quickOrder = (String)mapData.get("quickOrder");
                    String creatTime = "";//订购日期
                    String noObj = null;//订单号
                    String countryNameObj = null;//国家
                    String companyNameObj = null;//公司名称
                    String remarkObj = null;//备注
                    JSONObject quickOrderJsonObj = JSONObject.parseObject(quickOrder);
                    if(quickOrderJsonObj.getString("createTime") == null || "".equals(quickOrderJsonObj.getString("createTime")) ){
                        result.setMsg("createTime不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到createTime：" + quickOrderJsonObj.getString("createTime"));
                        return result;
                    }else{
                        Date createTimeObj = quickOrderJsonObj.getDate("createTime");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        creatTime = sdf.format(createTimeObj);//格式化订购日期
                    }
                    if(quickOrderJsonObj.getString("no") == null || "".equals(quickOrderJsonObj.getString("no"))){
                        result.setMsg("no不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到no：" + quickOrderJsonObj.getString("no"));
                        return result;
                    }else{
                        noObj = quickOrderJsonObj.getString("no");
                    }
                    if(quickOrderJsonObj.getString("companyCountry") == null || "".equals(quickOrderJsonObj.getString("companyCountry"))) {
                        result.setMsg("companyCountry不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到companyCountry：" + quickOrderJsonObj.getString("companyCountry"));
                        return result;
                    }else{
                        countryNameObj = quickOrderJsonObj.getString("companyCountry");
                    }
                    if(quickOrderJsonObj.getString("companyName") == null || "".equals(quickOrderJsonObj.getString("companyName"))) {
                        result.setMsg("companyName不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到companyName：" + quickOrderJsonObj.getString("companyName"));
                        return result;
                    }else{
                        companyNameObj = quickOrderJsonObj.getString("companyName");
                    }
                    if(quickOrderJsonObj.getString("remark") == null || "".equals(quickOrderJsonObj.getString("remark"))) {
                        remarkObj = "-";
                    }else{
                        remarkObj = quickOrderJsonObj.getString("remark");
                    }
                    context.put("emailImagesPath",emailImagesPath);
                    context.put("creatTime",creatTime);
                    context.put("toAddress",mapData.get("toAddress"));
                    context.put("no",noObj);
                    context.put("companyCountry",countryNameObj);
                    context.put("companyName",companyNameObj);
                    context.put("remark",remarkObj);
                    stringWriter = new StringWriter();
                    template.merge(context,stringWriter);
                    mail.setContent(stringWriter.toString());
                    if(null == quickOrderJsonObj.getJSONObject("subject") || "".equals(quickOrderJsonObj.getJSONObject("subject"))) {
                        mail.setSubject("欢迎使用全球鹰");
                    }
                }
            }else if("reportSuccess".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalEagle/"+templateType+".vm");
                if(mapData.get("orderDetailView") == null || "".equals(mapData.get("orderDetailView"))){
                    result.setMsg("orderDetailView不能为空");
                    result.setCode(false);
                    logger.debug("未能获取到orderDetailView：" + mapData.get("orderDetailView"));
                    return result;
                }else{
                    String orderDetailView = (String)mapData.get("orderDetailView");
                    String creatTime = "";//订购日期
                    String orderNo = "";//订单号
                    String countryName = "";//国家
                    String companyName = "";//公司名称
                    String finishTime = "";//上传时间
                    String remark = "";//备注
                    JSONObject orderDetailViewObj = JSONObject.parseObject(orderDetailView);
                    if(orderDetailViewObj.getString("createTime") == null || "".equals(orderDetailViewObj.getString("createTime")) ){
                        result.setMsg("createTime不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到createTime：" + orderDetailViewObj.getString("createTime"));
                        return result;
                    }else{
                        Date createTimeObj = orderDetailViewObj.getDate("createTime");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        creatTime = sdf.format(createTimeObj);//格式化订购日期
                    }
                    if(orderDetailViewObj.getString("orderNo") == null || "".equals(orderDetailViewObj.getString("orderNo")) ){
                        result.setMsg("orderNo不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到orderNo：" + orderDetailViewObj.getString("orderNo"));
                        return result;
                    }else{
                        orderNo = orderDetailViewObj.getString("orderNo");
                    }
                    if(orderDetailViewObj.getString("countryName") == null || "".equals(orderDetailViewObj.getString("countryName")) ){
                        result.setMsg("countryName不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到countryName：" + orderDetailViewObj.getString("countryName"));
                        return result;
                    }else{
                        countryName = orderDetailViewObj.getString("countryName");
                    }
                    if(orderDetailViewObj.getString("companyName") == null || "".equals(orderDetailViewObj.getString("companyName")) ){
                        result.setMsg("companyName不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到companyName：" + orderDetailViewObj.getString("companyName"));
                        return result;
                    }else{
                        companyName = orderDetailViewObj.getString("companyName");
                    }
                    if(orderDetailViewObj.getString("finishTime") == null || "".equals(orderDetailViewObj.getString("finishTime")) ){
                        result.setMsg("finishTime不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到finishTime：" + orderDetailViewObj.getString("finishTime"));
                        return result;
                    }else{
                        Date finishTimeObj = orderDetailViewObj.getDate("finishTime");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                        finishTime = sdf.format(finishTimeObj);//格式化订购日期
                    }
                    if(orderDetailViewObj.getString("remark") == null || "".equals(orderDetailViewObj.getString("remark")) ){
                        remark = "-";
                    }else{
                        remark = orderDetailViewObj.getString("remark");
                    }
                    context.put("emailImagesPath",emailImagesPath);
                    context.put("toAddress",mapData.get("toAddress"));
                    context.put("creatTime",creatTime);
                    context.put("orderNo",orderNo);
                    context.put("countryName",countryName);
                    context.put("companyName",companyName);
                    context.put("finishTime",finishTime);
                    context.put("remark",remark);
                    stringWriter = new StringWriter();
                    template.merge(context,stringWriter);
                    mail.setContent(stringWriter.toString());
                    if(null == orderDetailViewObj.getJSONObject("subject") || "".equals(orderDetailViewObj.getJSONObject("subject"))) {
                        mail.setSubject("欢迎使用全球鹰");
                    }
                }
            }else{
                result.setMsg("没有匹配的模版");
                result.setCode(false);
                logger.debug("未能获取匹配的模版："+templateType);
                return result;
            }
        }else if("globalSearch".equals(invokeObj)){
            if("forgetEN".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalSearch/"+templateType+".vm");
                if(mapData.get("url") == null || "".equals(mapData.get("url"))){
                    result.setMsg("url不能为空");
                    result.setCode(false);
                    logger.debug("未能获取到url：" + mapData.get("url"));
                    return result;
                }else{
                    context.put("url",mapData.get("url"));
                }
                context.put("toAddress",mapData.get("toAddress"));
                context.put("emailImagesPath",emailImagesPath);
                stringWriter = new StringWriter();
                template.merge(context,stringWriter);
                mail.setContent(stringWriter.toString());
                if(null == mapData.get("subject") || "".equals(mapData.get("subject"))) {
                    mail.setSubject("welcomes the use of the cnBIZsearch");
                }
            }else if("reportEN".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalSearch/"+templateType+".vm");
                if(mapData.get("url") == null || "".equals(mapData.get("url"))){
                    result.setMsg("url不能为空");
                    result.setCode(false);
                    logger.debug("未能获取到url：" + mapData.get("url"));
                    return result;
                }else{
                    context.put("url",mapData.get("url"));
                }
                context.put("emailImagesPath",emailImagesPath);
                context.put("toAddress",mapData.get("toAddress"));
                stringWriter = new StringWriter();
                template.merge(context,stringWriter);
                mail.setContent(stringWriter.toString());
                if(null == mapData.get("subject") || "".equals(mapData.get("subject"))) {
                    mail.setSubject("welcomes the use of the cnBIZsearch");
                }
            }else if("registerEN".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalSearch/"+templateType+".vm");
                context.put("toAddress",mapData.get("toAddress"));
                context.put("emailImagesPath",emailImagesPath);
                stringWriter = new StringWriter();
                template.merge(context,stringWriter);
                mail.setContent(stringWriter.toString());
                if(null == mapData.get("subject") || "".equals(mapData.get("subject"))) {
                    mail.setSubject("welcomes the use of the cnBIZsearch");
                }
            }else if("orderEN".equals(templateType)){
                context = new VelocityContext();
                template = velocityEngine.getTemplate("template/globalSearch/"+templateType+".vm");
                if(mapData.get("orders") == null || "".equals(mapData.get("orders"))){
                    result.setMsg("orders不能为空");
                    result.setCode(false);
                    logger.debug("未能获取到orders：" + mapData.get("orders"));
                    return result;
                }else{
                    String orders = (String)mapData.get("orders");
                    String creatTime = "";
                    String no = null;//订单号
                    String amountActual = null;//总价
                    String remark = null;//备注
                    JSONArray orderDetailsArray = null;//报告内容
                    JSONObject ordersJsonObj = JSONObject.parseObject(orders);
                    if(ordersJsonObj.getString("createTime") == null || "".equals(ordersJsonObj.getString("createTime")) ){
                        result.setMsg("createTime不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到createTime：" + ordersJsonObj.getString("createTime"));
                        return result;
                    }else{
                        Date createTimeObj = ordersJsonObj.getDate("createTime");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        creatTime = sdf.format(createTimeObj);//格式化订购日期
                    }
                    if(ordersJsonObj.getString("no") == null || "".equals(ordersJsonObj.getString("no"))){
                        result.setMsg("no不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到no：" + ordersJsonObj.getString("no"));
                        return result;
                    }else{
                        no = ordersJsonObj.getString("no");
                    }
                    if(ordersJsonObj.getString("amountActual") == null || "".equals(ordersJsonObj.getString("amountActual"))) {
                        result.setMsg("amountActual不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到amountActual：" + ordersJsonObj.getString("amountActual"));
                        return result;
                    }else{
                        amountActual = ordersJsonObj.getString("amountActual");
                    }
                    if(ordersJsonObj.getString("remark") == null || "".equals(ordersJsonObj.getString("remark"))) {
                        remark = "-";
                    }else{
                        remark = ordersJsonObj.getString("remark");
                    }

                    if(ordersJsonObj.getJSONArray("orderDetails") != null && ordersJsonObj.getJSONArray("orderDetails").size() > 0){
                        orderDetailsArray = ordersJsonObj.getJSONArray("orderDetails");
                    }else{
                        result.setMsg("OrderDetail不能为空");
                        result.setCode(false);
                        logger.debug("未能获取到OrderDetail：" + ordersJsonObj.getJSONArray("OrderDetail"));
                        return result;
                    }
                    context.put("emailImagesPath",emailImagesPath);
                    context.put("creatTime",creatTime);
                    context.put("toAddress",mapData.get("toAddress"));
                    context.put("no",no);
                    context.put("amountActual",amountActual);
                    context.put("remark",remark);
                    context.put("orderDetailArray",orderDetailsArray);
                    stringWriter = new StringWriter();
                    template.merge(context,stringWriter);
                    mail.setContent(stringWriter.toString());
                    if(null == ordersJsonObj.getJSONObject("subject") || "".equals(ordersJsonObj.getJSONObject("subject"))) {
                        mail.setSubject("welcomes the use of the cnBIZsearch");
                    }
                }
            }else{
                result.setMsg("没有匹配的模版");
                result.setCode(false);
                logger.debug("未能获取匹配的模版："+templateType);
                return result;
            }
        }else{
            result.setMsg("没有匹配的调用方");
            result.setCode(false);
            logger.debug("未能获取匹配的调用方："+invokeObj);
            return result;
        }
        Boolean isSuccessOrNot = true;
        try{
            logger.debug("进入以html形式发送邮件的方法：sendHtmlMail");
            isSuccessOrNot = SimpleMailSender.sendHtmlMail(mail);
            if(isSuccessOrNot == true){
                result.setMsg("邮件发送成功");
                result.setCode(true);
                logger.debug("邮件发送成功------"+isSuccessOrNot);
                emailDetail.setIsSuccess(result.getMsg());
            }else{
                result.setMsg("邮件未能成功发送");
                result.setCode(false);
                logger.debug("邮件发送不成功------"+isSuccessOrNot);
                emailDetail.setIsSuccess(result.getMsg());
            }
            emailDetail.setSendMail(mail.getFromAddress());
            emailDetail.setReceiveMail(mail.getToAddress());
            if(null != mail.getCopyToAddress() && !"".equals(mail.getCopyToAddress())){
                emailDetail.setCopytoMail(mail.getCopyToAddress());
            }
            emailDetail.setMailContent(mail.getContent());
            if(null != mail.getSubject() && !"".equals(mail.getContent())) {
                emailDetail.setMailSubject(mail.getSubject());
            }
            emailDetail.setEndTime(new Date());
            if(emailLogFileMapper.insertSelective(emailDetail) > 0){
                result.setMsg("邮件日志插入成功");
                result.setCode(true);
                logger.debug("邮件日志插入成功");
            }else{
                result.setMsg("邮件日志未能成功插入");
                result.setCode(false);
                logger.debug("邮件日志未能成功插入");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("发送邮件出错了:"+e);
        }
        return result;
    }
}
