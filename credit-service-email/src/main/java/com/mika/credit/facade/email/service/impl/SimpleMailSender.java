package com.mika.credit.facade.email.service.impl;

import com.mika.credit.facade.email.util.MailSenderInfo;
import com.mika.credit.facade.email.util.MyAuthenticator;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

public class SimpleMailSender {
	/**
  * 以文本格式发送邮件
  * @param mailInfo 待发送的邮件的信息
  */
    public static boolean sendTextMail(MailSenderInfo mailInfo) {
      // 判断是否需要身份认证
      MyAuthenticator authenticator = null;
      Properties pro = mailInfo.getProperties();
      if (mailInfo.isValidate()) {
      // 如果需要身份认证，则创建一个密码验证器
        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
      }
      // 根据邮件会话属性和密码验证器构造一个发送邮件的session
      Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
      try {
      // 根据session创建一个邮件消息
      Message mailMessage = new MimeMessage(sendMailSession);
      // 创建邮件发送者地址
      Address from = new InternetAddress(mailInfo.getFromAddress());
      // 设置邮件消息的发送者
      mailMessage.setFrom(from);
      // 创建邮件的接收者地址，并设置到邮件消息中
      Address to = new InternetAddress(mailInfo.getToAddress());
      mailMessage.setRecipient(Message.RecipientType.TO,to);
      // 设置邮件消息的主题
      mailMessage.setSubject(mailInfo.getSubject());
      // 设置邮件消息发送的时间
      mailMessage.setSentDate(new Date());

      //放入内容和附件类
      MimeMultipart allMultipart = new MimeMultipart("mixed");
      //设置内容
      MimeBodyPart HtmlBodypart = new MimeBodyPart();
      // 设置邮件消息的主要内容
      String mailContent = mailInfo.getContent();
      HtmlBodypart.setContent(mailContent, "text/html;charset=gbk");

      //设置附件
      MimeBodyPart attachFileBodypart = new MimeBodyPart();
      MimeMultipart attachFileMMP = new MimeMultipart("related");
      String[] strArrgs = mailInfo.getAttachFileNames(); //所有文件路径
      for(int i = 0; i < strArrgs.length; i++) {
          MimeBodyPart attachFileBody = new MimeBodyPart();
          FileDataSource fds = new FileDataSource(new File(strArrgs[i]));//附件文件
          attachFileBody.setDataHandler(new DataHandler(fds));//得到附件本身并至入BodyPart
          //MimeUtility.encodeText()解决文件名乱码问题
          attachFileBody.setFileName(MimeUtility.encodeText(fds.getName()));//得到文件名同样至入BodyPart
          attachFileMMP.addBodyPart(attachFileBody);//放入BodyPart
      }
      attachFileBodypart.setContent(attachFileMMP,"text/html;charset=gbk");

      //放入内容
      allMultipart.addBodyPart(HtmlBodypart);
      //放入附件
      allMultipart.addBodyPart(attachFileBodypart);
      mailMessage.setContent(allMultipart);
      mailMessage.saveChanges();

      //文件内容写在本地，测试 用
      mailMessage.writeTo(new FileOutputStream("D:/ComplexMessage.eml"));
      // 发送邮件
      Transport.send(mailMessage);
      return true;
      } catch (Exception ex) {
          ex.printStackTrace();
      }
      return false;
    }

    /**
      * 以HTML格式发送邮件
      * @param mailInfo 待发送的邮件信息
      */
    public static boolean sendHtmlMail(MailSenderInfo mailInfo){
      // 判断是否需要身份认证
      MyAuthenticator authenticator = null;
      Properties pro = mailInfo.getProperties();
      //如果需要身份认证，则创建一个密码验证器
      if (mailInfo.isValidate()) {
        authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
      }
      // 根据邮件会话属性和密码验证器构造一个发送邮件的session
      Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
      try {
      // 根据session创建一个邮件消息
      Message mailMessage = new MimeMessage(sendMailSession);
      // 创建邮件发送者地址
      Address from = new InternetAddress(mailInfo.getFromAddress());
      // 设置邮件消息的发送者
      mailMessage.setFrom(from);
      // 创建邮件的接收者地址，并设置到邮件消息中
      Address to = new InternetAddress(mailInfo.getToAddress());
      Address Copyto = null;
      if(null != mailInfo.getCopyToAddress() && !"".equals(mailInfo.getCopyToAddress())){
        Copyto = new InternetAddress(mailInfo.getCopyToAddress());
      }else{
        Copyto = new InternetAddress("global@3acredit.cn");
      }
      if (Copyto!=null&&!"".equals(Copyto)){
        Address[] addresses = new Address[2];
        addresses[0] = to;
        addresses[1] = Copyto;
        mailMessage.setRecipients(Message.RecipientType.TO, addresses);
      }else {
        // 创建邮件的接收者地址，并设置到邮件消息中
        mailMessage.setRecipient(Message.RecipientType.TO, to);
      }
      // 设置邮件消息的主题
      if(mailInfo.getSubject() != null && !"".equals(mailInfo.getSubject())) {
        mailMessage.setSubject(mailInfo.getSubject());
      }
      // 设置邮件消息发送的时间
      mailMessage.setSentDate(new Date());
      // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
      Multipart mainPart = new MimeMultipart();
      // 创建一个包含HTML内容的MimeBodyPart
      BodyPart html = new MimeBodyPart();
      // 设置HTML内容
//      html.setText(mailInfo.getContent());
      html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
      mainPart.addBodyPart(html);
      // 将MiniMultipart对象设置为邮件内容
      mailMessage.setContent(mainPart);
      // 发送邮件
      Transport.send(mailMessage);
      return true;
      } catch (MessagingException ex) {
          ex.printStackTrace();
      }
      return false;
    }
}
