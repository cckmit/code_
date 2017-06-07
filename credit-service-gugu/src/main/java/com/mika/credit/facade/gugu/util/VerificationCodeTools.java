package com.mika.credit.facade.gugu.util;

import com.mika.credit.facade.email.util.MailSenderInfo;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Mike on 2017/4/13.
 */
public class VerificationCodeTools {
    /**
     * 发送短信
     *
     * @param mobileNumber
     * @throws IOException
     */
    public static void sendMobileVerificationCode(String mobileNumber, String VerificationCode) throws IOException {
        //发送内容
        String number = VerificationCode;

        String content = "您好，您申请的验证码为："+number+"，请在30分钟内操作，谢谢。";
        String sign = "估估信用";

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
     * 发送短信
     *
     * @param email
     * @throws IOException
     */
    public static MailSenderInfo sendEmailVerificationCode(String email, String VerificationCode) {
        String emailUrl = "http://china.global-eagle.cn/images/emailimgs/";
        String code = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>Document</title>\n" +
                "</head>\n" +
                "<body style=\"background: #e5eaf1\">\n" +
                "\t<table style=\"width: 580px;font-size: 16px;margin:0 auto;background:url(" +
                emailUrl +"bg.png" +
                ") no-repeat;font-family: 'Adobe 仿宋 Std';color: #494949\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 22px;color:#2b6dac;font-family: 'SimHei';padding-left: 60px;padding-top: 55px\">亲爱的用户</td>\n" +
                "\t\t\t<td style=\"padding-right: 60px;padding-top: 55px\" align=\"right\">\n" +
                "\t\t\t\t<a href=\"#\">\n" +
                "\t\t\t\t\t<img src=\"" +
                emailUrl+ "logo.png" +
                "\" alt=\"估估信用\" style=\"width: 55px;height: 55px;border: 0\">\n" +
                "\t\t\t\t</a>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"line-height: 32px;padding-left: 60px\" colspan=\"2\">您好！您正在修改账户登录密码，请在验证码输入框内输入：</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"line-height: 32px;padding-left: 60px\"  colspan=\"2\">\n" +
                "\t\t\t\t<a href=\"#\" style=\"margin-right: 20px;text-decoration: none;font-size: 18px;color:#2b6dac\">" +
                VerificationCode +
                "</a>以完成操作\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"line-height: 32px;padding-left: 60px\"  colspan=\"2\">验证码将在30分钟后过期，请尽快完成验证操作！</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 18px;padding-top: 30px;font-family: 'SimHei';color: #000;padding-left: 60px;line-height: 30px;\"  colspan=\"2\">注意：</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px;line-height: 24px;padding-left: 60px\"  colspan=\"2\">此操作可能会修改您的密码、登录邮箱或绑定手机。如非本人操作，</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"font-size: 14px;line-height: 24px;padding-left: 60px\"  colspan=\"2\">请及时登录并修改密码以保障账号安全！</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"color:#df4848;font-size: 14px;padding-bottom: 80px;line-height: 24px;padding-left: 60px\"  colspan=\"2\">(工作人员不会向您索取此验证码，请勿泄露!)</td>\n" +
                "\t\t</tr>\n" +
                "\t</table>\n" +
                "</body>\n" +
                "</html>";
        MailSenderInfo mailSenderInfo = new MailSenderInfo();
        mailSenderInfo.setSubject("咕咕信用忘记密码");
        mailSenderInfo.setToAddress(email); //收件人邮箱
        mailSenderInfo.setContent(code); //内容
        return mailSenderInfo;
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
