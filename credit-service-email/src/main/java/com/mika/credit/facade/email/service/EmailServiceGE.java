package com.mika.credit.facade.email.service;

import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.email.util.EmailData;

/**
 * Created by Michael on 2017/1/20.
 */
public interface EmailServiceGE {

    /**
     *
     * @param
     * @param  //globalEagle在不同情况下需发送邮件内容的类型（1代表forget忘记密码、2代表order订单、3代表register注册、4代表report报告）
     * @return
     *
     */
    ResponseResult<String> sendEmail(EmailData emailData);


}
