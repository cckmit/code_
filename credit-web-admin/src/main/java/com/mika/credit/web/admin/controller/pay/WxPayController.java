//package com.mika.credit.web.admin.controller.pay;
//
//import com.mika.credit.common.entity.pay.RechargeBean;
//import com.mika.credit.common.entity.pay.WXPayBean;
//import com.mika.credit.facade.pay.service.WXPayService;
//import com.mika.credit.facade.pay.service.WxGoBackService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.math.BigDecimal;
//import java.net.URLEncoder;
//
///**
// * Created by Hunter on 2017/3/1.
// */
//@Controller
//public class WxPayController {
//
//    @Autowired
//    private WXPayService wxPayService;
//
//    @Autowired
//    private WxGoBackService wxGoBackService;
//
//    @RequestMapping(value = "/credit/pay")
//    public String wxPayOrder(){
//
//        return "pay";
//    }
//
//    /**
//     * 微信下单
//     * 返回微信支付二维码code_url，如果返回“”，则表示获取失败
//     * @param wxPayBean
//     * @throws IOException
//     *
//     */
////    @RequestMapping(value = "/credit/wxPayOrder")
////    @ResponseBody
////    public String wxPayOrder(WXPayBean wxPayBean) throws IOException {
////        String result = "";
//////        if (wxPayBean!=null || !"".equals(wxPayBean)){
////            try {
////                RechargeBean re = new RechargeBean();
////                wxPayBean.setTitle("全球鹰支付");
////                wxPayBean.setCurrency("CNY");
////                wxPayBean.setDes("99999");
////                wxPayBean.setUserCode("13123123");
////                wxPayBean.setOrderNo("1155684269729623");
////                wxPayBean.setAmount(new BigDecimal("1"));
////                result = wxPayService.pay(wxPayBean);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
////        return result;
////    }
//
//    /**
//     * 微信支付回调方法
//     *
//     * @throws IOException
//     *  AlipayApiException
//     */
//    @RequestMapping(value = "/credit/writeBackWX")
//    public String writeBackWX(HttpServletRequest request) throws IOException {
//        String result = "";
//        try {
//            result = wxGoBackService.writeBackHistory(request);
//        } catch (Exception e) {
//            e.printStackTrace();
//            result = e.getMessage();
//        }
//        return result;
//    }
//
//}
