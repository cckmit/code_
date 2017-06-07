package com.mika.credit.facade.globaleagle.core.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetailView;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.common.entity.pay.PayBackBean;
import com.mika.credit.common.util.Tool;
import com.mika.credit.common.util.UtilDateTime;
import com.mika.credit.common.util.UtilEncode;
import com.mika.credit.facade.email.service.EmailService;
import com.mika.credit.facade.email.util.MailSenderInfo;
import com.mika.credit.facade.globaleagle.core.dao.CustomerMapper;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.service.CustomerService;
import com.mika.credit.facade.order.service.OrderService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private static Logger logger = Logger.getLogger(CustomerService.class);
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private EmailService emailService;
    @Autowired
    private OrderService orderService;

    /**
     * 保存验证码
     * @param customer
     * @return
     */
    @Override
    public ResponseResult<Customer> registerVerificationCode(Customer customer) {
        logger.info("保存验证码方法开始...");
        ResponseResult<Customer> result = new ResponseResult<>();
        Customer c = new Customer();
        c.setCode(customer.getMobile());
        List<Customer> customers = customerMapper.selectSelective(c);
        Customer customerResult = null;
        if (customers.size() > 0) {
            customerResult = customers.get(0);
        }
        if (customerResult != null) {
            result.setCode(false);
            result.setMsg("该手机号已绑定");
            return result;
        } else {
            result.setCode(true);
            //添加创建账号信息
            customer.setCode(customer.getMobile());
            customerMapper.insert(customer);
            result.setContent(customer);
            return result;
        }
    }


    /**
     * 用户登陆
     *
     * @param customer
     * @return
     */
    @Override
    public ResponseResult<Customer> getLoginInfo(Customer customer) {
        logger.info("用户登录方法开始...");
        ResponseResult<Customer> result = new ResponseResult<>();
        //账户密码加密
        customer.setPasswd(UtilEncode.encodeMD5(customer.getPasswd()));
        List<Customer> customers = customerMapper.selectSelective(customer);
        Customer customerResult = null;
        if (customers.size() > 0) {
            customerResult = customers.get(0);
        }
        if (customerResult != null) {
            if (customerResult.getLoginCount() == null) {
                customerResult.setLoginCount(1);
            } else {
                customerResult.setLoginCount(customerResult.getLoginCount() + 1);
            }
            customerMapper.updateByPrimaryKeySelective(customerResult);
            result.setCode(true);
            result.setMsg("登录成功");
            result.setContent(customerResult);
            return result;
        } else {
            result.setCode(false);
            result.setMsg("登录失败");
            return result;
        }
    }

    /**
     * 通过id查用户信息
     *
     * @param id
     * @return
     */
    @Override
    public ResponseResult<Customer> getCustomerInfoById(int id) {
        logger.info("通过id查询用户信息方法开始...");
        ResponseResult<Customer> result = new ResponseResult<>();
        Customer customer = customerMapper.selectByPrimaryKey(id);
        if (customer != null) {
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(customer);
            return result;
        } else {
            result.setCode(false);
            result.setMsg("查询失败");
            return result;
        }
    }

    /**
     * 用户注册
     *
     * @param customer
     * @return
     */
    @Override
    public ResponseResult<Customer> getRegisterInfo(Customer customer) {
        logger.info("用户注册方法开始...");
        ResponseResult<Customer> result = new ResponseResult<>();
        Customer c = new Customer();
        c.setCode(customer.getCode());
        List<Customer> customers = customerMapper.selectSelective(c);
        Customer customerResult = null;
        if (customers.size() > 0) {
            customerResult = customers.get(0);
        }
        if (customerResult != null) {
            if (customerResult.getTheme() == null || customerResult.getTheme().equals("")) {
                result.setCode(false);
                result.setMsg("注册失败");
            } else {
                if (customerResult.getTheme().equals(customer.getTheme())) {
                    //添加创建账号信息
                    customerResult.setCreateTime(new Date());
                    //账户密码加密
                    customerResult.setPasswd(UtilEncode.encodeMD5(customer.getPasswd()));
                    //注册时添加非认证
                    customerResult.setCheckStatus("否");
                    //添加普通用户等级
                    customerResult.setLevelId(1);
                    customerMapper.updateByPrimaryKeySelective(customerResult);
                    result.setContent(customerResult);
                    result.setCode(true);
                    result.setMsg("注册成功");
                } else {
                    result.setCode(false);
                    result.setMsg("注册失败");
                }
            }

        } else {
            result.setCode(true);
            //添加创建账号信息
            customer.setCreateTime(new Date());
            //账户密码加密
            customer.setPasswd(UtilEncode.encodeMD5(customer.getPasswd()));
            //注册时添加非认证
            customer.setCheckStatus("否");
            //添加普通用户等级
            customer.setLevelId(1);
            customerMapper.insert(customer);
            result.setContent(customer);
            result.setMsg("注册成功");
        }
        return result;
    }


    /**
     * 修改个人信息
     *
     * @param customer
     * @return
     */
    @Override
    public ResponseResult<Customer> modifyMyInfomation(Customer customer) {
        logger.info("修改个人信息方法开始...");
        ResponseResult<Customer> result = new ResponseResult<>();
        //更新个人信息
        int changedSel = customerMapper.updateByPrimaryKeySelective(customer);
        if (changedSel > 0) {
            result.setCode(true);
            result.setMsg("修改信息成功");
        } else {
            result.setCode(false);
            result.setMsg("修改信息失败");
        }
        return result;
    }

    /**
     * 更新余额
     *
     * @param customer
     * @return
     */
    @Override
    public boolean updateOrderBalance(Customer customer) {
        logger.info("更新余额方法开始...");
        int updateSel = customerMapper.updateByPrimaryKeySelective(customer);
        if (updateSel > 0) {
            return true;
        }
        return false;
    }

    /**
     * 检查余额
     *
     * @param price
     * @param customerId
     * @return
     */
    @Override
    public ResponseResult<Customer> customerCheckBalance(float price, int customerId) {
        logger.info("检查余额方法开始...");
        ResponseResult<Customer> result = new ResponseResult<>();
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        if (customer.getBalance() - price > 0) {
            result.setCode(true);
            result.setMsg("余额足够");
        } else {
            result.setCode(false);
            result.setMsg("余额不足");
        }
        return result;
    }

    /**
     * 忘记密码
     *
     * @param email
     * @return
     */
    @Override
    public ResponseResult<Customer> forgetPW(String email, String url) {
        logger.info("忘记密码方法开始...");
        ResponseResult<Customer> result = new ResponseResult<>();
        Customer customer = customerMapper.selectByEmail(email);
        if (customer == null) {
            result.setCode(false);
            result.setMsg("此账号不是注册会员！");
        } else {
            if (customer.getEmail() == null || customer.getEmail().equals("")){
                result.setCode(false);
                result.setMsg("此账号未绑定邮箱！");
                return result;
            }
            // 设置邮件内容
            StringBuffer demo = new StringBuffer();
            demo.append(url + "/toResetPW.do?email=" + email);
            Map<String,Object> mapData = new HashedMap();
            mapData.put("url", demo);
            mapData.put("toAddress",customer.getEmail());
            emailService.sendEmail("globalEagle","forget",mapData);
            result.setCode(true);
            result.setMsg("修改密码邮件发送成功");
        }
        return result;
    }

    /**
     * 重置密码
     *
     * @param c
     * @return
     */
    @Override
    public ResponseResult<Customer> resetPW(Customer c) {
        logger.info("充值密码方法开始...");
        ResponseResult<Customer> result = new ResponseResult<>();
        //账户密码加密
        c.setPasswd(UtilEncode.encodeMD5(c.getPasswd()));
        boolean choose = customerMapper.updatePasswordByEmail(c) > 0;
        if (choose) {
            result.setCode(true);
            result.setMsg("修改密码成功");
        } else {
            result.setCode(false);
            result.setMsg("修改密码失败");
        }
        return result;
    }


    /**
     * 修改客户信息
     *
     * @param record
     * @return
     */
    @Override
    public int modify(Customer record) {
        logger.info("修改客户信息方法开始...");
        return customerMapper.updateByPrimaryKey(record);
    }


    @Override
    public ResponseResult<Customer> editCheckStatus(Customer customer) {
        logger.info("客户认证方法开始...");
        ResponseResult<Customer> result = new ResponseResult<>();
        if (customerMapper.updateCheckStatusById(customer) > 0) {
            if (customer.getCheckStatus().equals("是")) {
                result.setMsg("认证成功");
            } else {
                result.setMsg("保存成功");
            }
            result.setCode(true);
        } else {
            result.setMsg("保存/认证失败");
            result.setCode(false);
        }
        return result;
    }


    /**
     * 余额付款
     *
     * @param orderId
     * @param customerId
     * @return
     */
    public ResponseResult<Orders> modifyOrderPayment(Integer orderId, Integer customerId) {
        logger.info("余额付款方法开始...");
        ResponseResult<Orders> result = new ResponseResult<>();
        ResponseResult<Orders> orderRE = orderService.findOrdersById(Long.valueOf(orderId));
        if (orderRE.getCode()){
            if(orderRE.getContent().getHasPay()){
                result.setCode(true);
                result.setMsg("支付成功");
                return result;
            }
        }
        Orders order = orderRE.getContent();
        Customer c = customerMapper.selectByPrimaryKey(customerId);
        if (c.getBalance() >= order.getAmountActual().floatValue()) {
            c.setBalance(c.getBalance() - order.getAmountActual().floatValue());
            PayBackBean payBackBean = new PayBackBean();
            payBackBean.setOrderNo(order.getNo());
            payBackBean.setAmount(order.getAmountActual());
            payBackBean.setPayMethod(0);
            payBackBean.setPayTime(new Date());
            ResponseResult<Orders> payOrders = orderService.paid(payBackBean);
            if (payOrders.getCode()) {
                if (order.getCustomerEmail() == null || order.getCustomerEmail().equals("")) {
                    //更新订单email
                   // orderService.saveOrder(order);
                }
                //更新
                customerMapper.updateByPrimaryKey(c);
                result.setCode(true);
                result.setMsg("支付成功");
                result.setContent(payOrders.getContent());
            } else {
                result.setCode(false);
                result.setMsg("订单支付失败");
            }
        } else {
            result.setCode(false);
            result.setMsg("余额不足");
        }
        return result;
    }


}
