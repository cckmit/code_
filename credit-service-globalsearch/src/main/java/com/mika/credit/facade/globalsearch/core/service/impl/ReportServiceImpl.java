package com.mika.credit.facade.globalsearch.core.service.impl;


import com.mika.credit.facade.email.service.EmailService;
import com.mika.credit.common.util.Tool;
import com.mika.credit.common.util.UtilDateTime;
import com.mika.credit.facade.email.util.MailSenderInfo;
import com.mika.credit.facade.globalsearch.core.model.CreditServices;
import com.mika.credit.facade.globalsearch.core.model.Order;
import com.mika.credit.facade.globalsearch.core.model.OrderDetail;
import com.mika.credit.facade.globalsearch.core.service.ReportService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by mika on 2016/8/31.
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {
    private static Logger logger = Logger.getLogger(ReportServiceImpl.class);
    @Autowired
    private EmailService emailService;
    /**
     * 发送email
     * @param email
     * @param content
     * @param fileNames
     * @return
     * @throws UnsupportedEncodingException
     */
    public boolean sendReportEmail(String email,String content,String[] fileNames) throws UnsupportedEncodingException {
        logger.info("发送email方法开始...");
        MailSenderInfo mail = new MailSenderInfo();
        Map<String,String> map = Tool.loadEmailInfo();
        mail.setMailServerHost(map.get("emailSmtp"));
        mail.setMailServerPort("25");
        mail.setValidate(true);
        mail.setUserName(map.get("emailName"));
        mail.setPassword(map.get("emailPwd"));
        mail.setFromAddress(map.get("emailFromAddress"));
        mail.setToAddress(email);
        mail.setSubject("全球鹰报告信息");
        if(fileNames!=null && fileNames.length>0){
            mail.setAttachFileNames(fileNames);
        }
        // 设置邮件内容
        StringBuffer demo = new StringBuffer();
        demo.append(content);
        emailService.sendEmail(mail,"globalEagle");
//        SimpleMailSender sms = new SimpleMailSender();
//        mail.setContent(demo.toString());
//        SimpleMailSender.sendTextMail(mail);
        return true;
    }

    /**
     * 发送订单确认email
     * @param email
     * @param fileNames
     * @param order
     * @return
     * @throws UnsupportedEncodingException
     */
    public boolean sendOrderConfirmEmail(String email,String[] fileNames,Order order) throws UnsupportedEncodingException {
       if (order==null){
           return false;
       }
        MailSenderInfo mail = new MailSenderInfo();
        Map<String, String> map = Tool.loadEmailInfo();
        mail.setMailServerHost(map.get("emailSmtp"));
        mail.setMailServerPort("25");
        mail.setValidate(true);
        mail.setUserName(map.get("emailName"));
        mail.setPassword(map.get("emailPwd"));
        mail.setFromAddress(map.get("emailFromAddress"));
        mail.setToAddress(email);
        mail.setSubject("全球鹰订购信息");
        if (fileNames != null && fileNames.length > 0) {
            mail.setAttachFileNames(fileNames);
        }
        // 设置邮件内容
        StringBuffer demo = new StringBuffer();
        demo.append("<div align=\"center\">\n" +
                        "<table class=\"MsoNormalTable\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"640\" style=\"width: 384pt;\">\n" +
                        "    <tbody class=\"\">\n" +
                        "    <tr style=\"height: 24pt;\" class=\"\">\n" +
                        "        <td colspan=\"2\" style=\"padding: 0in; height: 24pt;\" class=\"\">\n" +
                        "            <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\" class=\"\">\n" +
                        "                &nbsp;<o:p class=\"\"></o:p></div>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "    <tr class=\"\">\n" +
                        "        <td width=\"418\" style=\"width: 200.8pt; padding: 0in;\" class=\"\">\n" +
                        "            <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\" class=\"\"><img\n" +
                        "                    width=\"110\" height=\"72\" id=\"_x0000_i1025\" src=\"http://china.global-eagle.cn/images/GLOBAL-EAGLE.png\" class=\"\"><o:p\n" +
                        "                    class=\"\"></o:p></div>\n" +
                        "        </td>\n" +
                        "        <td width=\"222\" style=\"width: 1.85in; padding: 0in;\" class=\"\">\n" +
                        "            <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif; text-align: right;\"\n" +
                        "                 class=\"\"><span lang=\"ZH-CN\"\n" +
                        "                                style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif; color: rgb(51, 51, 51);\" class=\"\">订购日期</span><span\n" +
                        "                    style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif; color: rgb(51, 51, 51);\" class=\"\">:<span\n" +
                        "                    style=\"border-bottom:1px dashed #ccc;\" t=\"5\" times=\"\">"+ UtilDateTime.toStdDateString(order.getCreateDate())+"</span><br class=\"\"><span\n" +
                        "                    lang=\"ZH-CN\" class=\"\">订单号：</span><strong class=\"\"><span style=\"font-family: 微软雅黑, sans-serif;\"\n" +
                        "                                                                            class=\"\">3ACB<span\n" +
                        "                    style=\"border-bottom:1px dashed #ccc;z-index:1\" t=\"7\" onclick=\"return false;\" data=\"57756653991\">"+order.getOrderNo()+"</span></span></strong></span><o:p\n" +
                        "                    class=\"\"></o:p></div>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "    <tr style=\"height: 42pt;\" class=\"\">\n" +
                        "        <td colspan=\"2\" style=\"padding: 0in; height: 42pt;\" class=\"\">\n" +
                        "            <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\" class=\"\">\n" +
                        "                &nbsp;<o:p class=\"\"></o:p></div>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "    <tr class=\"\">\n" +
                        "        <td colspan=\"2\" style=\"padding: 0in;\" class=\"\">\n" +
                        "            <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif; line-height: 13.5pt;\"\n" +
                        "                 class=\"\"><span lang=\"ZH-CN\" style=\"font-family: 微软雅黑, sans-serif; color: rgb(204, 51, 0);\" class=\"\">感谢您的订购</span><span\n" +
                        "                    style=\"font-family: 微软雅黑, sans-serif; color: rgb(204, 51, 0);\" class=\"\">,<span\n" +
                        "                    class=\"Apple-converted-space\">&nbsp;</span><span lang=\"ZH-CN\" class=\"\">我们正在处理您的订购信息</span>.<o:p\n" +
                        "                    class=\"\"></o:p></span></div>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "    <tr style=\"height: 33pt;\" class=\"\">\n" +
                        "        <td colspan=\"2\" style=\"padding: 0in; height: 33pt;\" class=\"\">\n" +
                        "            <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\" class=\"\">\n" +
                        "                &nbsp;<o:p class=\"\"></o:p></div>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "    <tr class=\"\">\n" +
                        "        <td colspan=\"2\" style=\"padding: 0in 0in 3.75pt;\" class=\"\">\n" +
                        "            <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif; line-height: 13.5pt;\"\n" +
                        "                 class=\"\"><span lang=\"ZH-CN\"\n" +
                        "                                style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif; color: rgb(51, 51, 51);\" class=\"\">本次订购会显示在您的账户中</span><span\n" +
                        "                    style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif; color: rgb(51, 51, 51);\" class=\"\">,<span\n" +
                        "                    class=\"Apple-converted-space\">&nbsp;</span><span lang=\"ZH-CN\" class=\"\">您可以登陆</span>全球鹰<span\n" +
                        "                    lang=\"ZH-CN\" class=\"\">进行管理</span><o:p class=\"\"></o:p></span></div>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "    <tr class=\"\">\n" +
                        "        <td colspan=\"2\" style=\"padding: 0in;\" class=\"\">\n" +
                        "            <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\" class=\"\">\n" +
                        "                &nbsp;<o:p class=\"\"></o:p></div>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "    <tr class=\"\">\n" +
                        "        <td colspan=\"2\" style=\"padding: 0in;\" class=\"\">\n" +
                        "            <table class=\"MsoNormalTable\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"width: 512px;\">\n" +
                        "                <tbody class=\"\">\n" +
                        "                <tr class=\"\">\n" +
                        "                    <td width=\"30%\"\n" +
                        "                        style=\"border-style: solid none none; border-top-color: rgb(102, 102, 102); border-top-width: 1pt; padding: 6.75pt 0in;\"\n" +
                        "                        class=\"\">\n" +
                        "                        <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\"\n" +
                        "                             class=\"\"><span style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\"\n" +
                        "                                            class=\"\">国家.<o:p class=\"\"></o:p></span></div>\n" +
                        "                    </td>\n" +
                        "                    <td width=\"50%\"\n" +
                        "                        style=\"border-style: solid none none; border-top-color: rgb(102, 102, 102); border-top-width: 1pt; padding: 6.75pt 0in;\"\n" +
                        "                        class=\"\">\n" +
                        "                        <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\"\n" +
                        "                             class=\"\"><span lang=\"ZH-CN\" style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\"\n" +
                        "                                            class=\"\">公司名称</span><span\n" +
                        "                                style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\" class=\"\"><o:p\n" +
                        "                                class=\"\"></o:p></span></div>\n" +
                        "                    </td>\n" +
                        "                    <td width=\"20%\"\n" +
                        "                        style=\"border-style: solid none none; border-top-color: rgb(102, 102, 102); border-top-width: 1pt; padding: 6.75pt 0in;\"\n" +
                        "                        class=\"\">\n" +
                        "                        <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\"\n" +
                        "                             class=\"\"><span lang=\"ZH-CN\" style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\"\n" +
                        "                                            class=\"\">价格</span><span\n" +
                        "                                style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\" class=\"\"><o:p\n" +
                        "                                class=\"\"></o:p></span></div>\n" +
                        "                    </td>\n" +
                        "                </tr>\n");
        if (order.getOrderDetails().size()>=0){
        for(OrderDetail orderDetail : order.getOrderDetails()){
            demo.append("                <tr class=\"\">\n" +
                    "                    <td style=\"border-style: solid none; border-top-color: rgb(153, 153, 153); border-top-width: 1pt; border-bottom-color: rgb(153, 153, 153); border-bottom-width: 1pt; padding: 6.75pt 0in;\"\n" +
                    "                        class=\"\">\n" +
                    "                        <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\"\n" +
                    "                             class=\"\"><span style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\" class=\"\"><span\n" +
                    "                                style=\"border-bottom:1px dashed #ccc;z-index:1\" t=\"7\" onclick=\"return false;\"\n" +
                    "                                data=\"9365258229\">"+orderDetail.getCountryCnName()+"</span><o:p class=\"\"></o:p></span></div>\n" +
                    "                    </td>\n" +
                    "                    <td style=\"border-style: solid none; border-top-color: rgb(153, 153, 153); border-top-width: 1pt; border-bottom-color: rgb(153, 153, 153); border-bottom-width: 1pt; padding: 6.75pt 0in;\"\n" +
                    "                        class=\"\">\n" +
                    "                        <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\"\n" +
                    "                             class=\"\"><span lang=\"ZH-CN\" style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\"\n" +
                    "                                            class=\"\">"+orderDetail.getCompanyName()+"</span><span\n" +
                    "                                style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\" class=\"\"><o:p\n" +
                    "                                class=\"\"></o:p></span></div>\n" +
                    "                    </td>\n" +
                    "                    <td style=\"border-style: solid none; border-top-color: rgb(153, 153, 153); border-top-width: 1pt; border-bottom-color: rgb(153, 153, 153); border-bottom-width: 1pt; padding: 6.75pt 0in;\"\n" +
                    "                        class=\"\">\n" +
                    "                        <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\"\n" +
                    "                             class=\"\"><span style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\" class=\"\">"+orderDetail.getTotalPrice()+"<o:p\n" +
                    "                                class=\"\"></o:p></span></div>\n" +
                    "                    </td>\n" +
                    "                </tr>\n");
        }
        }

                        demo.append("                <tr class=\"\">\n" +
                        "                    <td colspan=\"3\" valign=\"top\"\n" +
                        "                        style=\"border-style: solid none none; border-top-color: rgb(102, 102, 102); border-top-width: 1pt; padding: 6.75pt 0in;\"\n" +
                        "                        class=\"\">\n" +
                        "                        <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\"\n" +
                        "                             class=\"\"><span lang=\"ZH-CN\" style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\"\n" +
                        "                                            class=\"\">备注:</span><span\n" +
                        "                                style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\" class=\"\"><o:p\n" +
                        "                                class=\"\"></o:p></span><span style=\"font-size: 9pt; font-family: 微软雅黑, sans-serif;\" class=\"\"><o:p\n" +
                                "                                class=\"\"></o:p></span></div>\n" +
                        "                    </td>\n" +
                        "                    <td style=\"padding: 0in;\" class=\"\"></td>\n" +
                        "                </tr>\n" +
                        "                </tbody>\n" +
                        "            </table>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "    <tr class=\"\">\n" +
                        "        <td colspan=\"2\" style=\"padding: 0in;\" class=\"\">\n" +
                        "            <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\" class=\"\">\n" +
                        "                &nbsp;<o:p class=\"\"></o:p></div>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "    <tr class=\"\">\n" +
                        "        <td colspan=\"2\" style=\"padding: 0in;\" class=\"\">\n" +
                        "            <div style=\"margin: 0in 0in 0.0001pt; font-size: 12pt; font-family: 'Times New Roman', serif;\" class=\"\">\n" +
                        "                &nbsp;<o:p class=\"\"></o:p></div>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "    <tr class=\"\">\n" +
                        "        <td colspan=\"2\" style=\"padding: 0in;\" class=\"\">\n" +
                        "            <div class=\"\"><p class=\"txt\"\n" +
                        "                             style=\"margin-right: 0in; margin-left: 0in; line-height: 16.5pt; font-size: 9pt; font-family: 微软雅黑, sans-serif; margin-bottom: 12pt;\">\n" +
                        "                <strong class=\"\"><span lang=\"ZH-CN\" style=\"font-family: 微软雅黑, sans-serif;\"\n" +
                        "                                       class=\"\">订购有问题</span></strong>?<br class=\"\"><span lang=\"ZH-CN\"\n" +
                        "                                                                                         class=\"\">您可以在邮件收到后</span>6<span\n" +
                        "                    lang=\"ZH-CN\" class=\"\">小时内</span>,<span class=\"Apple-converted-space\">&nbsp;</span><span lang=\"ZH-CN\"\n" +
                        "                                                                                                            class=\"\">将问题发送至邮件</span><a\n" +
                        "                    href=\"mailto:global@3acredit.cn\" style=\"color: purple; text-decoration: underline;\" class=\"\"\n" +
                        "                    target=\"_blank\"><span style=\"color: rgb(204, 0, 51);\" class=\"\">global@3acredit.cn</span></a><br\n" +
                        "                    class=\"\"><br class=\"\"><span class=\"txt1\" style=\"font-family: 微软雅黑, sans-serif;\"><span lang=\"ZH-CN\"\n" +
                        "                                                                                                          class=\"\">版权所有</span>© <span\n" +
                        "                    style=\"border-bottom:1px dashed #ccc;z-index:1\" t=\"7\" onclick=\"return false;\" data=\"2008-2014\">2016-2020</span> 全球鹰<span\n" +
                        "                    class=\"Apple-converted-space\">&nbsp;</span><span lang=\"ZH-CN\" class=\"\">保留所有权利</span></span><br\n" +
                        "                    class=\"\"><span class=\"txt1\" style=\"font-family: 微软雅黑, sans-serif;\"><span lang=\"ZH-CN\" class=\"\">建议用户在使用之前先仔细阅读</span><span\n" +
                        "                    class=\"Apple-converted-space\">&nbsp;</span>\"<span lang=\"ZH-CN\" class=\"\">条款和条件</span>\"</span></p>\n" +
                        "            </div>\n" +
                        "        </td>\n" +
                        "    </tr>\n" +
                        "    </tbody>\n" +
                        "</table>\n" +
                        "    </div>");
        emailService.sendEmail(mail,"globalEagle");
//        SimpleMailSender sms = new SimpleMailSender();
//        mail.setContent(demo.toString());
//        SimpleMailSender.sendTextMail(mail);
        return true;
    }


    /**
     * 发送订单确认email
     * @param fileNames
     * @param creditServices
     * @return
     * @throws UnsupportedEncodingException
     */
    public boolean sendCreditEmail(String[] fileNames,CreditServices creditServices) throws UnsupportedEncodingException {
        MailSenderInfo mail = new MailSenderInfo();
        Map<String, String> map = Tool.loadEmailInfo();
        mail.setMailServerHost(map.get("emailSmtp"));
        mail.setMailServerPort("25");
        mail.setValidate(true);
        mail.setUserName(map.get("emailName"));
        mail.setPassword(map.get("emailPwd"));
        mail.setFromAddress(map.get("emailFromAddress"));
        mail.setToAddress(map.get("emailFromAddress"));
//        mail.setToAddress("273210563@qq.com");

        mail.setSubject("全球鹰信用服务");
        if (fileNames != null && fileNames.length > 0) {
            mail.setAttachFileNames(fileNames);
        }
        // 设置邮件内容
        StringBuffer demo = new StringBuffer();
//        demo.append("<table border=\"1\">\n" +
//                "    <tr>\n" +
//                "        <th>认证类型</th>\n" +
//                "        <th>洲/区域</th>\n" +
//                "        <th>国家/地区</th>\n" +
//                "        <th>公司名称</th>\n" +
//                "        <th>公司电话</th>\n" +
//                "        <th>公司网址</th>\n" +
//                "        <th>公司邮箱</th>\n" +
//                "        <th>地址及其他信息</th>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "        <td>"+creditServices.getCreditChoose()+"</td>\n" +
//                "        <td>"+creditServices.getContinent()+"</td>\n" +
//                "        <td>"+creditServices.getCountry()+"</td>\n" +
//                "        <td>"+creditServices.getCompanyName()+"</td>\n" +
//                "        <td>"+creditServices.getCompanyPhone()+"</td>\n" +
//                "        <td>"+creditServices.getCompanyWebsite()+"</td>\n" +
//                "        <td>"+creditServices.getCompanyEmail()+"</td>\n" +
//                "        <td>"+creditServices.getCompanyAddOther()+"</td>\n" +
//                "\n" +
//                "    </tr>\n" +
//                "</table><br>\n" +
//                "<table border=\"1\">\n" +
//                "    <tr>\n" +
//                "        <th>是否订制过目标企业商业资信报告</th>\n" +
//                "        <th>姓名</th>\n" +
//                "        <th>电话/手机</th>\n" +
//                "        <th>邮箱</th>\n" +
//                "        <th>备注其他信息</th>\n" +
//                "\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "        <td>"+creditServices.getOrderReport()+"</td>\n" +
//                "        <td>"+creditServices.getName()+"</td>\n" +
//                "        <td>"+creditServices.getPhone()+"</td>\n" +
//                "        <td>"+creditServices.getEmail()+"</td>\n" +
//                "        <td>"+creditServices.getComment()+"</td>\n" +
//                "\n" +
//                "\n" +
//                "    </tr>\n" +
//                "</table>");
        demo.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb 2312\" />\n" +
                "<style type=\"text/css\">\n" +
                "#tr { background-color: #E1ECEC;}\n" +
                "td {font-family: \"Times New Roman\", Times, serif Simsun;\n" +
                "\tfont-size: 14px; text-align:right; height:40px}\n" +
                "\tp {font-size: 12px; text-align:left; color:#999}\n" +
                "</style>\n" +
                "<style type=\"text/css\">\n" +
                "</style>\n" +
                "<title>无标题文档</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<table width=\"90%\" border=\"0\" cellspacing=\"10\n" +
                "0\" cellpadding=\"0\" bordercolor=\"#F6F6F6\">\n" +
                "  <tr>\n" +
                "    <td><table width=\"100%\" border=\"0\" cellspacing=\"2\" cellpadding=\"0\">\n" +
                "      <tr height=\"100px\">\n" +
                "        <td colspan=\"2\" bgcolor=\"#CCCCCC\">&nbsp;</td>\n" +
                "        </tr>\n" +
                "      <tr>\n" +
                "        <td width=\"120\">认证类型："+creditServices.getCreditChoose()+"</td>\n" +
                "        <td> </td>\n" +
                "      </tr>\n" +
                "      <tr >\n" +
                "        <td>洲/区域："+creditServices.getContinent()+"</td>\n" +
                "        <td> </td>\n" +
                "      <tr >\n" +
                "        <td>国家地区："+creditServices.getCountry()+"</td>\n" +
                "        <td> </td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>公司名称："+creditServices.getCompanyName()+"</td>\n" +
                "        <td> </td>\n" +
                "      </tr>\n" +
                "      <tr >\n" +
                "        <td>公司电话："+creditServices.getCompanyPhone()+"</td>\n" +
                "        <td> </td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>公司网址："+creditServices.getCompanyWebsite()+"</td>\n" +
                "        <td> </td>\n" +
                "      </tr>\n" +
                "            <tr >\n" +
                "        <td>电子邮箱："+creditServices.getCompanyEmail()+"</td>\n" +
                "        <td> </td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>地址及其他信息："+creditServices.getCompanyAddOther()+"</td>\n" +
                "        <td> </td>\n" +
                "      </tr>\n" +
                "      <tr >\n" +
                "        <td> </td>\n" +
                "        <td><p>"+creditServices.getOrderReport()+"订购过商安信报告</p></td>\n" +
                "      </tr>\n" +
                "              <tr>\n" +
                "        <td colspan=\"2\" align=\"justify\"><hr /></td>\n" +
                "        </tr>\n" +
                "      <tr >\n" +
                "        <td>姓　　名："+creditServices.getName()+"</td>\n" +
                "        <td> </td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>联系方式："+creditServices.getPhone()+"</td>\n" +
                "        <td> </td>\n" +
                "      </tr>\n" +
                "            <tr >\n" +
                "        <td>电子邮箱："+creditServices.getEmail()+"</td>\n" +
                "        <td> </td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "        <td>备注信息："+creditServices.getComment()+"</td>\n" +
                "        <td> </td>\n" +
                "      </tr>\n" +
                "    </table></td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>\n");
        emailService.sendEmail(mail,"globalEagle");
//        SimpleMailSender sms = new SimpleMailSender();
//        mail.setContent(demo.toString());
//        SimpleMailSender.sendTextMail(mail);
        return true;
    }



    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        ReportServiceImpl r=new ReportServiceImpl();
//        System.out.println(r.sendReportEmail("mika.zhang@3acredit.cn",null));
//      httpURLConectionGET(POST_URL);
//      httpURLConnectionPOST(POST_URL);
    }
}
