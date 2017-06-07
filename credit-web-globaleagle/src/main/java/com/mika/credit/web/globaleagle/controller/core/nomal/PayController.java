package com.mika.credit.web.globaleagle.controller.core.nomal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.common.entity.pay.AlipayBean;
import com.mika.credit.common.entity.pay.WXPayBean;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.service.CustomerService;
import com.mika.credit.facade.order.service.OrderService;
import com.mika.credit.facade.pay.service.AlipayService;
import com.mika.credit.facade.pay.service.WXPayService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by Mike on 2017/3/14.
 */
@Controller
public class PayController {
    private static Logger logger = Logger.getLogger(PayController.class);
    @Autowired
    AlipayService alipayService;

    @Autowired
    WXPayService wxPayService;

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;


    /**
     * @param request
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/customer/wxPayment", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String wxPayment(HttpServletRequest request, String orderId) {
        logger.info("微信支付开始...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        ResponseResult<Orders> payOrderRe = orderService.findOrdersById(Long.valueOf(orderId));
        Orders payOrder = payOrderRe.getContent();
        if (payOrder.getCustomerEmail() == null || payOrder.getCustomerEmail().equals("")) {
            if (customer.getEmail() == null || customer.getEmail().equals("")){
            } else{
                payOrder.setCustomerEmail(customer.getEmail());
            }
            //更新订单email
            orderService.saveOrder(payOrder);
        }

        WXPayBean wxPayBean = new WXPayBean();
        wxPayBean.setAmount(payOrder.getAmountActual());
        wxPayBean.setAppName((byte) 1);
        wxPayBean.setCurrency("CNY");
        wxPayBean.setDes("即时查询超过3亿企业信用信息");
        wxPayBean.setOrderNo(payOrder.getNo());
        wxPayBean.setTitle("全球鹰征信订单");
        wxPayBean.setUserCode(payOrder.getCustomerEmail());
        String wxString = wxPayService.pay(wxPayBean);
        JSONObject jsonObject = JSON.parseObject(wxString);
        Boolean result = jsonObject.getBoolean("result");
        if (result){
            wxString = jsonObject.getString("obj");
        }else {
            wxString = null;
        }
        return wxString;
    }


    @RequestMapping(value = "/customer/balancePayment")
    public String balancePayment(HttpServletRequest request, String orderId, ModelMap map) {
        logger.info("余额支付开始...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        ResponseResult<Orders> ordersResponseResult = customerService.modifyOrderPayment(Integer.parseInt(orderId), customer.getId());
        if (ordersResponseResult.getCode()) {
            map.addAttribute("msg", "支付成功");
        } else {
            map.addAttribute("msg", "支付失败," + ordersResponseResult.getMsg());
        }
        map.addAttribute("order", ordersResponseResult.getContent());
        return "/user/confirmSuccess";
    }

    /**
     * 支付宝
     *
     * @param id
     */
    @RequestMapping(value = "/customer/aliPayment")
    public void toAlipay(HttpServletRequest request, HttpServletResponse response, Integer id, String emailAddress, ModelMap modelMap) {
        logger.info("支付宝支付开始...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        ResponseResult<Orders> ordersResponseResult = orderService.findOrdersById(Long.valueOf(id));
        Orders payOrder = ordersResponseResult.getContent();
        if (payOrder.getCustomerEmail() == null || payOrder.getCustomerEmail().equals("")) {
            payOrder.setCustomerEmail(emailAddress);
            //更新订单email
            orderService.saveOrder(payOrder);
            if (customer.getEmail() == null || customer.getEmail().equals("")) {
                customer.setEmail(emailAddress);
            }
            customerService.modify(customer);
        }
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setAmount(payOrder.getAmountActual());
        alipayBean.setAppName((byte) 1);
        alipayBean.setCurrency("CNY");
        alipayBean.setDes("即时查询超过3亿企业信用信息");
        alipayBean.setOrderNo(payOrder.getNo());
        alipayBean.setTitle("全球鹰征信订单");
        alipayBean.setUserCode(payOrder.getCustomerEmail());
        String alString = alipayService.pay(alipayBean);
        try {

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(alString);
            out.flush();
            out.close();
        } catch (IOException e) {
            logger.error("报错信息:"+e.getMessage());
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/customer/checkHasPay")
    @ResponseBody
    public String checkHasPay(String id) {
        logger.info("根据订单id查询订单开始...");
        ResponseResult<Orders> responseResult = orderService.findOrdersById(Long.parseLong(id));
        Orders payOrder = responseResult.getContent();
        if (payOrder == null) {
            return "没找到相关订单！";
        }
        if (!payOrder.getHasPay()) {
            return "该订单未完成支付";
        }
        return "";
    }

    @RequestMapping(value = "/customer/hasPay")
    public String hasPay(Integer id, HttpServletRequest request, ModelMap map){
        logger.info("查询订单信息开始...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        ResponseResult<Orders> responseResult = orderService.findOrdersById(Long.valueOf(id));
        Orders payOrder = responseResult.getContent();
        map.addAttribute("order", payOrder);
        map.addAttribute("msg", "支付成功");
        request.getSession().setAttribute("customerInfo", customerService.getCustomerInfoById(customer.getId()).getContent());
        return "/user/confirmSuccess";
    }




    @RequestMapping(value = "/customer/toCustomerPay")
    public String toCustomerPay(Integer orderId, HttpServletRequest request, ModelMap map) {
        logger.info("查询订单和余额开始...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        ResponseResult<Orders> responseResult = orderService.findOrdersById(Long.valueOf(orderId));
        Orders payOrder = responseResult.getContent();
        map.addAttribute("order", payOrder);
        map.addAttribute("balance", customerService.getCustomerInfoById(customer.getId()).getContent().getBalance());
        return "/customer/payOrder";
    }

}
