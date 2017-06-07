package com.mika.credit.web.globalsearch.controller.core;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.order.Product;
import com.mika.credit.facade.commondata.service.IndustryClassService;
import com.mika.credit.facade.globalsearch.core.model.Customer;
import com.mika.credit.facade.globalsearch.core.service.ContinentService;
import com.mika.credit.facade.globalsearch.core.service.CountryService;
import com.mika.credit.facade.order.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by mika on 2016/8/8.
 */
@Controller
public class PageForwardController {
    private static final Logger logger = Logger.getLogger(PageForwardController.class);
    @Autowired
    private ProductService productService;

    @Autowired
    private IndustryClassService industryClassService;

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String toIndex() {
        logger.info("跳转首页面开始...");
        return "/index";
    }


    /**
     * 跳转订单页（根据订单号搜索）
     * @param orderNo
     * @param map
     * @return
     */
    @RequestMapping(value = "/customer/toOrderList")
    public String toCustomerOrderList(String orderNo, ModelMap map) {
        logger.info("跳转订单页面开始...");
        map.addAttribute("orderNo", orderNo);
        return "customer/orderList";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/customer/toIndexAddition2")
    public String toIndexAddition2(String companyName,String province,String city,ModelMap map) {
        logger.info("跳转实地认证页面开始...");
        map.addAttribute("companyNameEN",companyName);
        map.addAttribute("provinceEN",province);
        map.addAttribute("cityEN",city);
        return "/indexAddition/additional2";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/customer/toIndexAddition3")
    public String toIndexAddition3(String companyName,ModelMap map) {
        logger.info("跳转法律声明页面开始...");
        map.addAttribute("companyNameEN",companyName);
        return "/indexAddition/additional3";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/customer/toIndexAddition4")
    public String toIndexAddition4(String companyName,ModelMap map) {
        logger.info("跳转尽职调查页面开始...");
        map.addAttribute("companyNameEN",companyName);
        return "/indexAddition/additional4";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/customer/toIndexAddition5")
    public String toIndexAddition5(String companyName,String province,String city,ModelMap map) {
        logger.info("跳转账款追收页面开始...");
        map.addAttribute("companyNameEN",companyName);
        map.addAttribute("provinceEN",province);
        map.addAttribute("cityEN",city);
        return "/indexAddition/additional5";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/customer/toIndexAddition6")
    public String toIndexAddition6(String companyName,ModelMap map) {
        logger.info("跳转行业分析页面开始...");
        map.addAttribute("companyNameEN",companyName);
        return "/indexAddition/additional6";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition8")
    public String toIndexAddition11() {
        logger.info("跳转关于我们页面开始...");
        return "/indexAddition/additional8";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition9")
    public String toIndexAddition9() {
        logger.info("跳转业务认证页面开始...");
        return "/indexAddition/additional9";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition10")
    public String toIndexAddition10() {
        logger.info("跳转检查页面开始...");
        return "/indexAddition/additional10";
    }

    @RequestMapping(value = "/toIndexAddition11")
    public String toIndexAdditionl1() {
        logger.info("跳转O2C Solutions页面开始...");
        return "/indexAddition/additional11";
    }

    @RequestMapping(value = "/toBottom1")
    public String toBottom1() {
        logger.info("跳转免责声明页面开始...");
        return "/indexAddition/bottom1";
    }
    @RequestMapping(value = "/toBottom2")
    public String toBottom2() {
        logger.info("跳转版权政策页面开始...");
        return "/indexAddition/bottom2";
    }
    @RequestMapping(value = "/toBottom3")
    public String toBottom3() {
        logger.info("跳转隐私政策页面开始...");
        return "/indexAddition/bottom3";
    }
    @RequestMapping(value = "/toBottom4")
    public String toBottom4() {
        logger.info("跳转使用条款协议页面开始...");
        return "/indexAddition/bottom4";
    }

    /**
     * 跳转收藏页面
     * @return
     */
    @RequestMapping(value = "/customer/toCollectionList")
    public String toCollectionList() {
        logger.info("跳转收藏页面开始...");
        return "customer/collectionList";
    }
    /**
     * 跳转报告列表
     * @return
     */
    @RequestMapping(value = "/customer/toOrderDetailList")
    public String toCustomerOrderDetailList() {
        logger.info("跳转报告页面开始...");
        return "customer/orderDetailList";
    }

    /**
     * 跳转信用服务列表
     * @return
     */
    @RequestMapping(value = "/customer/toCreditService")
    public String toCreditService() {
        logger.info("跳转信用服务页面开始...");
        return "customer/creditService";
    }
    /**
     * index跳转注册页面/认证页面
     * @return
     */
    @RequestMapping(value = "/toApproveCompany")
    public String toApproveCompany(HttpServletRequest request) {
        logger.info("index跳转注册页面/认证页面开始...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        if (customer == null){
            return "/login";
        } else {
            return "/customer/companyCreditCart";
        }
    }

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        logger.info("跳转登录页面开始...");
        return "/login";
    }

    /**fullsearch
     * 搜索页面
     * @param map
     * @return
     */
    @RequestMapping(value = "/toSearchCompanyList")
    public String toSearchCompanyList(String type,String companyName, ModelMap map,HttpServletRequest request) {
        logger.info("跳转搜索页面开始...");
        // TODO: 2017/1/7
            map.addAttribute("companyName", companyName);
            map.addAttribute("type", type);
//        Cookie[] cookies = request.getCookies();
//        if (cookies!=null){
//            for (Cookie cookie : cookies) {
//                String name = cookie.getName();
//                if ("queryCompanyList".equals(name)){
//                    String value = cookie.getValue();
//                    String[] split = value.split(";");
//                    map.addAttribute("queryCompanyList",split);
//                }
//            }
//        }
            return "/user/searchCompanyList";
    }
    /**
     * 进入快速订购页面
     * @param map
     * @return
     */
    @RequestMapping(value = "/user/toFastAddOrder")
    public String toFastAddOrder(ModelMap map) {
        logger.info("跳转快速订购页面开始...");
        BootGrid<Product> productBootGrid = new BootGrid<>();
        Product product = new Product();
        product.setSource((byte) 2);//来源搜
        product.setProductType((byte) 3);//自定义报告
        productBootGrid = productService.findProducts(new BootGrid<Product>(), product);
        map.addAttribute("products", productBootGrid);
        return "user/fastAddCart";
    }
    /**
     * 跳转忘记密码页面
     * @return
     */
    @RequestMapping(value = "/toForgetPW")
    public String toForgetPW() {
        logger.info("跳转忘记密码页面开始...");
        return "/forgetPW";
    }

    /**
     * 跳转重置密码页面
     * @param email
     * @param map
     * @return
     */
    @RequestMapping(value = "/toResetPW")
    public String toResetPW(String email, ModelMap map) {
        logger.info("跳转重置密码页面开始...");
        map.addAttribute("email", email);
        return "/resetPW";
    }

    /**
     * 跳转帮助页面
     * @return
     */
    @RequestMapping(value = "/help")
    public String toHelp(String cateId, ModelMap map) {
        logger.info("跳转帮助页面开始...");
        map.put("cateId", cateId);
        return "helpList";
    }

    /**
     * 跳转行业搜索
     * @return
     */
    @RequestMapping(value = "/toIndustrySearch")
    public String toIndustrySearch(ModelMap map) {
//        List a = industryClassService.findAll().getContent();
        logger.info("跳转行业搜索页面开始...");
        map.put("industryBig",industryClassService.findIndustryClassBig().getContent());
        map.put("industryAll",industryClassService.findAll().getContent());
        return "/user/industrySearch";
    }
}
