package com.mika.credit.facade.email.service.impl;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetail;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.common.util.Tool;
import com.mika.credit.facade.email.dao.EmailLogFileMapper;
import com.mika.credit.facade.email.model.EmailLogFile;
import com.mika.credit.facade.email.service.EmailServiceGE;
import com.mika.credit.facade.email.util.EmailData;
import com.mika.credit.facade.email.util.MailSenderInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by dong jian hua on 2017/3/16.
 */
@Service("emailServiceOrderImpl")
public class EmailServiceOrderImpl implements EmailServiceGE {

    private static Logger logger = Logger.getLogger(EmailServiceOrderImpl.class);

    @Autowired
    private EmailLogFileMapper emailLogFileMapper;

    @Override
    public ResponseResult<String> sendEmail(EmailData emailData) {
        logger.info("进入订购订单后的发送Eamil方法");
        ResponseResult result = new ResponseResult();
        Orders orders = (Orders)emailData.getEntity();
        if(null == emailData.getEntity() || "".equals(emailData.getEntity())){
            result.setMsg("订单信息不能为空");
            result.setCode(false);
            logger.debug("订单信息为空："+emailData.getEntity());
            return result;
        }
        if(null == orders.getCustomerEmail() || "".equals(orders.getCustomerEmail())){
            result.setMsg("收件地址不能为空");
            result.setCode(false);
            logger.debug("收件地址为空："+orders.getCustomerEmail());
            return result;
        }
        EmailLogFile emailDetail = new EmailLogFile();
        //设定调用方法起始时间
        emailDetail.setStartTime(new Date());
        emailDetail.setInvokeObj("globalEagle");
        MailSenderInfo mail = new MailSenderInfo();
        mail = generateOrderContent(orders);
        Map<String, String> map = Tool.loadEmailInfo();
        logger.debug("获取email基本信息数据："+map);
        mail.setMailServerHost(map.get("emailSmtp"));
        mail.setMailServerPort(map.get("emailServerPort"));
        mail.setValidate(true);
        mail.setUserName(map.get("emailName"));
        mail.setPassword(map.get("emailPwd"));
        mail.setFromAddress(map.get("emailFromAddress"));
        mail.setToAddress(orders.getCustomerEmail());
        if(null == emailData.getDataSubject() || "".equals(emailData.getDataSubject())){
            mail.setSubject("感谢您的订购，我们正在处理您的订购信息");
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
    public MailSenderInfo generateOrderContent(Orders orders) {
        MailSenderInfo mailSenderInfo = new MailSenderInfo();
        Date orderDate = orders.getCreateTime();//订购日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String orderDateTime = sdf.format(orderDate);

        //设置邮件内容
        StringBuffer content = new StringBuffer();
        content.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>Document</title>\n" +
                "\t<style>\n" +
                "\t\t*{margin: 0;padding: 0;border: 0;list-style: none;color: #494949;font-family: \"微软雅黑\";}\n" +
                "\t\ta{text-decoration: none;color: #fff;font-size: 16px;}\n" +
                "\t\t.order_table tr,.order_table td,.order_table th{border: 2px solid #e5e5e5;line-height: 40px;text-align: center;}\n" +
                "\t\t.order_table td,.order_table th{min-width: 60px}\n" +
                "\t\t.order_p dt,.order_p dd{color: #fff}\n" +
                "\t\t.companys li{width:130px;height:180px;color:#000;background: #eeeeee;border-radius: 5px;text-align: center;margin:0 10px;padding-bottom:6px;float: left;}\n" +
                "\t\t.companys div{color: #000;font-weight: bold}\n" +
                "\t\t.companys img{width: 114px;height: 66px;margin-top: 6px}\n" +
                "\t\t.companys p{width:140px;transform: scale(0.7);line-height: 18px;margin: -3px 0;color:#000;text-break:break-all;}\n" +
                "\t\t.companys span{color:#000;display: block;font-size: xx-small;width:260px;transform: scale(0.7);margin-left: -50%;}\n" +
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
                "\t<div style=\"padding: 40px 60px 50px;\">\n" +
                "\t\t<ul>\n" +
                "\t\t\t<li style=\"color: #0872b0;font-size: 22px;font-weight: bold;\">感谢您的订购，我们正在处理您的订购信息</li>\n" +
                "\t\t\t<li style=\"font-size: 12px;margin:20px 0;line-height: 20px\">\n" +
                "\t\t\t    <div>订购日期：<span>"+orderDateTime+"</span></div>\n" +
                "\t\t\t\t<div>订单号：&nbsp;<span>"+orders.getNo()+"</span></div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li style=\"color: #494949;font-size: 16px;margin: 20px 0\">本次订购会显示在您的账户中，您可以登陆全球鹰进行管理\n" +
                "\t\t\t</li>\n" +
                "\t\t</ul>\n" +
                "\t\t<!-- table -->\n" +
                "\t\t<table class=\"order_table\" style=\"width: 100%;border: 2px solid #e5e5e5;border-collapse: collapse;\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t\t\t<tr>\n" +
                "<th>国家</th>\n" +
                "<th>类型</th>\n" +
                "<th>公司名称</th>\n" +
                "<th>价格</th>\n");
        if(orders.getOrderDetails().size()>0){
            for(OrderDetail orderDetail : orders.getOrderDetails()){
                content.append(" \n<tr><td>"+orderDetail.getCountryName()+"</td>\n" +
                        "                <td>"+orderDetail.getProductId()+"</td>\n" +
                        "                <td>"+orderDetail.getCompanyName()+"</td>\n" +
                        "                <td>"+orderDetail.getPrice()+"</td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                <td>总价</td>\n" +
                        "                <td colspan=\\\"2\\\">"+orders.getAmountActual()+"</td>\n" +
                        "                <td></td>\n" +
                        "                </tr>\n" +
                        "                <tr>\n" +
                        "                <td>备注</td>\n" +
                        "                <td colspan=\\\"2\\\">"+orders.getRemark()+"</td>\n" +
                        "                <td></td>\n" +
                        "                </tr>\n" +
                        "                </table>\n" +
                        "                </div>\n");
            }
        }

        content.append("<!-- 订购有问题 -->\n" +
                "\t<dl class=\"order_p\" style=\"width:694px;margin:0 auto;padding:15px 20px;font-size: 12px;line-height: 20px;background: #444444\">\n" +
                "\t\t<dt style=\"font-size: 16px;margin-bottom: 18px\">订购有问题？</dt>\n" +
                "\t\t<dd>你可以在邮件收到后6小时内，将问题发送至邮件 \n" +
                "\t\t\t<a href=\"##\" style=\"font-size: 12px;text-decoration:underline;color:#ab2828\">global@3acredit.cn</a>\n" +
                "\t\t</dd>\n" +
                "\t\t<dd>版权所有&nbsp;2016-2020全球鹰&nbsp;保留所有权利</dd>\n" +
                "\t\t<dd>建议用户在使用之前先仔细阅读“条款和条件”</dd>\n" +
                "\t</dl>\n" +
                "\t<!-- companys -->\n" +
                "\t<ul class=\"companys\" style=\"width: 734px;margin: 0 auto;padding: 50px 0;font-size: 12px;line-height: 15px\">\n" +
                "\t\t<li style=\"margin-left: 0\">\n" +
                "\t\t\t<img src=\"imgs/fxq-banner.png\" alt=\"\">\n" +
                "\t\t\t<div>商安信(欧洲)公司</div>\n" +
                "\t\t\t<p>Address: Route de Gland 32B 1267Vich Switzerland</p>\n" +
                "\t\t\t<span>Phone: 41.(0)21.824.3777</span>\n" +
                "\t\t\t<span>Email: europe@3ACredit.com</span>\n" +
                "\t\t</li>\n" +
                "\t\t<li>\n" +
                "\t\t\t<img src=\"imgs/fxq-banner.png\" alt=\"\">\n" +
                "\t\t\t<div>商安信(北美地区)公司</div>\n" +
                "\t\t\t<p>Address: P.O. Box 271761 Flower Mound,TX 75027-1761 U.S.A</p>\n" +
                "\t\t\t<span>Phone: +1.972.896.8548</span>\n" +
                "\t\t\t<span>Email: usa@3ACredit.com</span>\n" +
                "\t\t</li>\n" +
                "\t\t<li>\n" +
                "\t\t\t<img src=\"imgs/fxq-banner.png\" alt=\"\">\n" +
                "\t\t\t<div>商安信(上海)总部</div>\n" +
                "\t\t\t<p>地址: 上海市逸仙路2816号华滋奔腾大厦B座12楼</p>\n" +
                "\t\t\t<span>电话: +86 21-36386226</span>\n" +
                "\t\t</li>\n" +
                "\t\t<li>\n" +
                "\t\t\t<img src=\"imgs/fxq-banner.png\" alt=\"\">\n" +
                "\t\t\t<div>商安信(北京)分公司</div>\n" +
                "\t\t\t<p>地址: 北京市朝阳区东四环中路41号嘉泰国际大厦A415-416</p>\n" +
                "\t\t\t<span>电话: +86 10-85711686</span>\n" +
                "\t\t</li>\n" +
                "\t\t<li style=\"margin-right: 0\">\n" +
                "\t\t\t<img src=\"imgs/fxq-banner.png\" alt=\"\">\n" +
                "\t\t\t<div>商安信(欧洲)营运中心</div>\n" +
                "\t\t\t<p>地址：江苏省巴城镇学院路828号上海浦东软件园昆山园4座306-7</p>\n" +
                "\t\t\t<span>电话：+86 21-36386227</span>\n" +
                "\t\t</li>\n" +
                "\t\t<div style=\"clear: both\"></div>\n" +
                "\t</ul>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");



        mailSenderInfo.setContent(content.toString());

        return mailSenderInfo;
    }
}
