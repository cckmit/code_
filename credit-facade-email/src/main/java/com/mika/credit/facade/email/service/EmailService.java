package com.mika.credit.facade.email.service;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.email.util.MailSenderInfo;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Michael on 2017/1/20.
 */
public interface EmailService {
    /**
     * 通用发送Email方法
     * @param mailSenderInfo 邮件数据封装
     * @param invokeObj 调用方
     * @return
     * @throws UnsupportedEncodingException
     */
    ResponseResult<String> sendEmail(MailSenderInfo mailSenderInfo, String invokeObj);

    /**
     *
     * @param receiverEmail 收件方
     * @param content 发送内容
     * @param invokeObj 调用方
     * @return
     * @throws UnsupportedEncodingException
     */
    ResponseResult<String> sendEmailParameter(String receiverEmail,String content,String invokeObj);

    /**
     *
     * @param invokeObj 调用方 例如 全球鹰必须定义为("globalEagle") 全搜必须定义为（"globalSearch"）均为字符串类型
     * @param templateType 模版类型 "忘记密码"必须定义为("forget") 注册成功必须定义为("register") 发送报告必须("report") 支付成功必须定义为("order")
     * @param mapData 接收Map传递的数据 根据约定
     *                                    forget:放入map的key必须定义成"url"(表示链接至修改密码的页面)、"toAddress"(表示收件人) 跟上相应的值即可
     *                                    register:放入map的key必须定义成"toAddress"(表示收件人) 跟上相应的值即可
     *                                    report：放入map的key必须定义成"toAddress"(表示收件人) 跟上相应的值即可 后期需加上附件内容
     *                                    order: 放入map的key必须定义成"toAddress"(表示收件人) 另须将传送的数据封装至orders对象再转成String的格式，其中key必须定义成"orders" 跟上相应的值即可
     *                补充：1、map中的"toAddress"为基础数据 所有的模版必须传该值
     *                      2、抄送人若没有则可以不传，视为无抄送人
     * @return
     */
    ResponseResult<String> sendEmail(String invokeObj, String templateType,Map<String,Object> mapData);
}
