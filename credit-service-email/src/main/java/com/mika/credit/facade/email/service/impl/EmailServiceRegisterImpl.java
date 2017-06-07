package com.mika.credit.facade.email.service.impl;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.Tool;
import com.mika.credit.facade.email.dao.EmailLogFileMapper;
import com.mika.credit.facade.email.model.EmailLogFile;
import com.mika.credit.facade.email.service.EmailServiceGE;
import com.mika.credit.facade.email.util.EmailData;
import com.mika.credit.facade.email.util.MailSenderInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by michael on 2017/3/16.
 */
@Service("emailServiceRegisterImpl")
public class EmailServiceRegisterImpl implements EmailServiceGE {

    private static Logger logger = Logger.getLogger(EmailServiceRegisterImpl.class);

    @Autowired
    private EmailLogFileMapper emailLogFileMapper;

    @Override
    public ResponseResult<String> sendEmail(EmailData emailData) {
        logger.info("进入注册后的发送Eamil方法");
        ResponseResult result = new ResponseResult();
        if(null == emailData.getDataToAddress() || "".equals(emailData.getDataToAddress())){
            result.setMsg("收件地址不能为空");
            result.setCode(false);
            logger.debug("收件地址为空："+emailData);
            return result;
        }
        EmailLogFile emailDetail = new EmailLogFile();
        //设定调用方法起始时间
        emailDetail.setStartTime(new Date());
        emailDetail.setInvokeObj("globalEagle");
        MailSenderInfo mail = new MailSenderInfo();
        mail = generateRegisterContent(emailData.getDataToAddress());
        Map<String, String> map = Tool.loadEmailInfo();
        logger.debug("获取email基本信息数据："+map);
        mail.setMailServerHost(map.get("emailSmtp"));
        mail.setMailServerPort(map.get("emailServerPort"));
        mail.setValidate(true);
        mail.setUserName(map.get("emailName"));
        mail.setPassword(map.get("emailPwd"));
        mail.setFromAddress(map.get("emailFromAddress"));
        mail.setToAddress(emailData.getDataToAddress());
        if(null == emailData.getDataSubject() || "".equals(emailData.getDataSubject())){
            mail.setSubject("欢迎使用全球鹰");
        }
        if(null != emailData.getDataCopyToAddress()){
            mail.setCopyToAddress(emailData.getDataCopyToAddress());
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

    /**
     *
     * @param
     * @return
     */
    public MailSenderInfo generateRegisterContent(String dataToAddress) {
        MailSenderInfo mailSenderInfo = new MailSenderInfo();
        mailSenderInfo.setContent("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>Document</title>\n" +
                "\t<style>\n" +
                "\t*{margin: 0;padding: 0;border: 0;list-style: none;color: #494949;font-family: \"微软雅黑\";}\n" +
                "\ta{text-decoration: none;color: #fff;font-size: 16px;}\n" +
                "\t.big .small{width: 367px;height:215px;text-align:center;float: left;}\n" +
                "\t.small h5{font-size: 14px;margin: 20px 0 10px 0;letter-spacing: 2px}\n" +
                "\t.small p{width:226px;word-break:break-all;font-size: 12px;color: #888888;margin-left: 70px;line-height: 20px}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<!-- 整个页面 background: #fcfcfb-->\n" +
                "<div class=\"back\" style=\"width: 824px;height: auto;background: #FAF9F9;margin: 0 auto;padding-bottom:70px\">\n" +
                "\t<!-- top -->\n" +
                "\t<div class=\"top\" style=\"width: 100%;height: 40px;background: #444444;\">\n" +
                "\t\t<ul class=\"top_in\" style=\"width: 734px;line-height: 40px;margin: 0 auto;\">\n" +
                "\t\t\t<li class=\"top_l\" style=\"float: left;\">\n" +
                "\t\t\t\t<a href=\"##\">Global Eagle 全球鹰</a>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li class=\"top_r\" style=\"float: right;font-size:14px;\">\n" +
                "\t\t\t\t<img src=\"imgs/fxq-phone.png\" alt=\"\" style=\"vertical-align:middle;width: 18px;height: 18px\">\n" +
                "\t\t\t\t<span style=\"margin-right:16px;color: #fff\">热线电话：4007 729 029</span>\n" +
                "\t\t\t\t<img src=\"imgs/fxq-email.png\" alt=\"\" style=\"vertical-align:middle;width: 18px;height: 18px\">\n" +
                "\t\t\t\t<span style=\"color: #fff\">邮箱：info@global-eagle.cn</span>\n" +
                "\t\t\t</li>\n" +
                "\t\t</ul>\n" +
                "\t</div>\n" +
                "\t<!-- banner -->\n" +
                "\t<div style=\"width:100%;height: 200px;position: relative;\">\n" +
                "\t\t<img src=\"imgs/fxq-banner.png\" alt=\"\">\n" +
                "\t\t<ul style=\"width: 320px;position: absolute;right: 45px;top: 70px;text-align: center;font-size:20px\">\n" +
                "\t\t\t<li style=\"margin-bottom: 16px;color:#fff\">即时查询超过3亿企业信用信息服务</li>\n" +
                "\t\t\t<li style=\"color:#fff\">涵盖180个国家和地区</li>\n" +
                "\t\t</ul>\n" +
                "\t</div>\n" +
                "\t<!-- content -->\n" +
                "\t<div style=\"padding: 40px 45px 60px;\">\n" +
                "\t\t<ul>\n" +
                "\t\t\t<li style=\"color: #0872b0;font-size: 22px;font-weight: bold;\">\n" +
                "\t\t\t\t<span style=\"color: #0872b0\">欢迎使用全球鹰</span>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li style=\"color: #494949;font-size: 16px;margin: 20px 0\">您已通过邮箱验证，正式成为全球鹰，会员以下是您的会员确认信。\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li style=\"font-size: 12px;margin-bottom:20px;line-height: 20px\">\n" +
                "\t\t\t    <div>会员名：<span style=\"color: #ab2828\">"+dataToAddress+"</span></div>\n" +
                "\t\t\t\t<div>邮箱：&nbsp;<span style=\"color: #ab2828\">"+dataToAddress+"</span></div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li style=\"color: #ab2828;font-size: 12px;margin-bottom: 40px\">（这是一封自动产生的email，请勿回复哦。）</li>\n" +
                "\t\t</ul>\n" +
                "\t\t<dl style=\"font-size: 12px;line-height: 20px;color: #000\">\n" +
                "\t\t\t<dt style=\"font-size: 16px;margin-bottom: 18px\">订购有问题？</dt>\n" +
                "\t\t\t<dd>你可以在邮件收到后6小时内，将问题发送至邮件 \n" +
                "\t\t\t\t<a href=\"##\" style=\"font-size: 12px;text-decoration:underline;color:#ab2828\">global@3acredit.cn</a>\n" +
                "\t\t\t</dd>\n" +
                "\t\t\t<dd>版权所有&nbsp;2016-2020全球鹰&nbsp;保留所有权利</dd>\n" +
                "\t\t\t<dd>建议用户在使用之前先仔细阅读“条款和条件”</dd>\n" +
                "\t\t</dl>\n" +
                "\t</div>\n" +
                "\t<!-- 四个模块 -->\n" +
                "\t<ul class=\"big\" style=\"width:734px;height:430px;background:#fff;margin:0 auto\">\n" +
                "\t\t<li class=\"small\">\n" +
                "\t\t\t<img src=\"imgs/fxq-1.png\" alt=\"\" style=\"margin-top:42px\">\n" +
                "\t\t\t<h5>信用信息</h5>\n" +
                "\t\t\t<p>全球鹰整合全球多个实地认证机构及当地运营公司，提供专业的商业认证服务。</p>\n" +
                "\t\t</li>\n" +
                "\t\t<li class=\"small\">\n" +
                "\t\t\t<img src=\"imgs/fxq-2.png\" alt=\"\" style=\"margin-top:42px\">\n" +
                "\t\t\t<h5>应收账管理</h5>\n" +
                "\t\t\t<p>全球鹰整合全球多个实地认证机构及当地运营公司，提供专业的商业认证服务。</p>\n" +
                "\t\t</li>\n" +
                "\t\t<li class=\"small\">\n" +
                "\t\t\t<img src=\"imgs/fxq-3.png\" alt=\"\" style=\"margin-top:42px\">\n" +
                "\t\t\t<h5>信用认证</h5>\n" +
                "\t\t\t<p>全球鹰整合全球多个实地认证机构及当地运营公司，提供专业的商业认证服务。</p>\n" +
                "\t\t</li>\n" +
                "\t\t<li class=\"small\">\n" +
                "\t\t\t<img src=\"imgs/fxq-4.png\" alt=\"\" style=\"margin-top:42px\">\n" +
                "\t\t\t<h5>全球鹰</h5>\n" +
                "\t\t\t<p>全球鹰整合全球多个实地认证机构及当地运营公司，提供专业的商业认证服务。</p>\n" +
                "\t\t</li>\n" +
                "\t</ul>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");

        return mailSenderInfo;
    }
}
