//package com.mika.credit.web.admin.controller.pay;
//
//import com.mika.credit.common.entity.pay.AlipayBean;
//import com.mika.credit.facade.order.service.OrderService;
//import com.mika.credit.facade.pay.service.AliGoBackService;
//import com.mika.credit.facade.pay.service.AlipayService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//
///**
// * Created by Hunter on 2017/3/8.
// */
//@Controller
//public class AlipayController {
//    @Autowired
//    private AlipayService alipayService;
//
//    @Autowired
//    private AliGoBackService aliGoBackService;
//
//    /**
//     *
//     * 调用支付宝支付页面  测试
//     * @return
//     */
////    @RequestMapping(value="/credit/AlipayReceive")
////    public void AlipayReceive(AlipayBean alipayBean,HttpServletResponse response){
////        String result = "";
////        try {
////            alipayBean.setUserCode("TEST");
////            alipayBean.setCurrency("CNY");
////            alipayBean.setOrderNo("6823789339978248");
////            alipayBean.setTitle("全球鹰征信订单");
////            alipayBean.setAmount(new BigDecimal("1"));
////            alipayBean.setDes("即时查询超过3亿企业信用信息");
////            result = alipayService.pay(alipayBean);
////            response.setContentType("text/html;charset=UTF-8");
////            PrintWriter out = response.getWriter();
////            out.print(result);
////            out.flush();
////            out.close();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
//
//    /**
//     * 支付宝回调
//     * 正常：{result:true,obj:付款成功}
//     * 错误：{result:false,resultDes:报错内容}
//     */
//    @RequestMapping(value="/credit/alipayTrade")
//    public @ResponseBody String alipayTrade(HttpServletRequest request) {
//        String result = "";
//        if(request != null || "".equals(request)){
//            result = aliGoBackService.alipayTrade(request);
//        }
//        return result;
//    }
//
//}
