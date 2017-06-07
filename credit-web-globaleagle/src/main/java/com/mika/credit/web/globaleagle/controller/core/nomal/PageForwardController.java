package com.mika.credit.web.globaleagle.controller.core.nomal;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.order.Product;
import com.mika.credit.facade.globaleagle.core.model.Continent;
import com.mika.credit.facade.globaleagle.core.model.Country;
import com.mika.credit.facade.globaleagle.core.model.CreditServices;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.service.ContinentService;
import com.mika.credit.facade.globaleagle.core.service.CountryService;
import com.mika.credit.facade.order.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by mika on 2016/8/8.
 */
@Controller
public class PageForwardController {
    private static Logger logger = Logger.getLogger(PageForwardController.class);
    @Autowired
    private CountryService countryService;

    @Autowired
    private ContinentService continentService;
    @Autowired
    private ProductService productService;
    /**
     * 跳转首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String toIndex() {
        logger.info("跳转首页开始...");
        return "index";
    }

    /**
     * 跳转简易版首页
     * @return
     */
    @RequestMapping(value = "/simple/index")
    public String toSimpleIndex() {
        logger.info("跳转简易版首页开始...");
        return "simplePage/index";
    }


    /**
     * 进入快速订购页面
     * @param map
     * @param country	城市名称
     * @param continent	洲名称
     * @return
     */
    @RequestMapping(value = "/user/toFastAddOrder")
    public String toFastAddOrder(ModelMap map,String country,String continent,String fastCompanyName) {
        logger.info("跳转快速订购页面开始...");
        BootGrid<Continent> continents = continentService.getContinents();
        for (Continent c: continents.getRows()){
            c.setCountries(countryService.selectCountryByContinentId(c.getId()));
        }
        String json = JSON.toJSONString(continents.getRows());
        if (country == null || country.equals("")){
        } else {
            try {
                country = URLDecoder.decode(country, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //除去空格 及 空字符
            country = country.replaceAll("\\s*", "");
            BootGrid<Country> countries = countryService.getCountries();
            for (Country c : countries.getRows()){
                if (c.getCnName().equals(country) || c.getEnName().equals(country)) {
                    if (c.getContinent().getCnName() == null){
                        continent = null;
                    } else {
                        continent = c.getContinent().getCnName();
                    }
                }
            }
        }
        BootGrid<Product> productBootGrid = new BootGrid<>();
        Product product = new Product();
        product.setSource((byte) 1);//来源全球鹰
        product.setProductType((byte) 3);//自定义报告
        productBootGrid = productService.findProducts(new BootGrid<Product>(), product);
        map.addAttribute("products", productBootGrid);
        map.addAttribute("fastCompanyName", fastCompanyName);
        map.addAttribute("continents", json);
        map.addAttribute("country", country);
        map.addAttribute("continent", continent);
        return "user/fastAddCart";
    }


    /**
     * 跳转订单页（根据订单号搜索）
     * @param orderNo
     * @param map
     * @return
     */
    @RequestMapping(value = "/customer/toOrderList")
    public String toCustomerOrderList(String orderNo, ModelMap map) {
        logger.info("跳转订单页开始...");
        map.addAttribute("orderNo", orderNo);
        return "customer/orderList";
    }

    /**
     * 跳转订单页（根据订单号搜索）
     * @param orderNo
     * @param map
     * @return
     */
    @RequestMapping(value = "/simple/customer/toOrderList")
    public String toSimpleCustomerOrderList(String orderNo, ModelMap map) {
        logger.info("跳转simple订单页开始...");
        map.addAttribute("orderNo", orderNo);
        return "simplePage/customer/orderList";
    }
    /**
     * 跳转我的对账单
     * @return
     */
    @RequestMapping(value = "/customer/toStatement")
    public String toCustomerStatement() {
        logger.info("跳转我的对账单开始...");
        return "customer/statement";
    }

    /**
     * 跳转我的对账单
     * @return
     */
    @RequestMapping(value = "/simple/customer/toStatement")
    public String toSimpleCustomerStatement() {
        logger.info("跳转simple我的对账单开始...");
        return "simplePage/customer/statement";
    }


    /**
     * 跳转simple报告列表
     * @return
     */
    @RequestMapping(value = "/simple/customer/toOrderDetailList")
    public String toSimpleCustomerOrderDetailList() {
        logger.info("跳转simple报告页面开始...");
        return "simplePage/customer/orderDetailList";
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
     * 跳转搜索页面
     * @return
     */
    @RequestMapping(value = "/customer/toSearchList")
    public String toSearchList() {
        logger.info("跳转搜索页面开始...");
        return "creditsafe/searchCompanyList";
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

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = "/simple/toLogin")
    public String toSimpleLogin() {
        logger.info("跳转simple登录页面开始...");
        return "simplePage/login";
    }

    /**
     * 跳转注册页面（未使用）
     * @return
     */
    @RequestMapping(value = "/toRegister")
    public String toregister() {
        return "/register";
    }

    /**
     * 跳转测试jsp页面
     * @return
     */
    @RequestMapping(value = "/toTemplate")
    public String toTemplate() {
        return "/template";
    }

    /**
     * 跳转管理员帮助页面
     * @return
     */
    @RequestMapping(value = "/manager/toHelpList")
    public String toHelpList() {
        logger.info("跳转管理员帮助页面开始...");
        return "/manager/helpList";
    }




    /**
     * 搜索页面
     * @param countryName
     * @param companyName
     * @param isAccurate
     * @param map
     * @return
     */
    @RequestMapping(value = "/toSearchCompanyList")
    public String toSearchCompanyList(String countryName, String companyName, String isAccurate, ModelMap map) {
        logger.info("跳转搜索页面开始...");
        if (countryName == null || countryName == ""){
            return "/creditsafe/searchCompanyList";
        }
        //除去空格 及 空字符
        countryName = countryName.replaceAll("\\s*", "");
        if (!countryName.equals("中国")&&!countryName.equals("英国")&&!countryName.equals("美国")&&!countryName.equals("德国")&&!countryName.equals("法国")&&!countryName.equals("比利时")&&!countryName.equals("丹麦")&&!countryName.equals("西班牙")&&!countryName.equals("意大利")&&!countryName.equals("韩国")&&!countryName.equals("卢森堡")&&!countryName.equals("墨西哥")&&!countryName.equals("荷兰")&&!countryName.equals("挪威")&&!countryName.equals("葡萄牙")&&!countryName.equals("瑞典")){
            try {
                countryName = URLEncoder.encode(countryName, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                logger.error("报错信息:"+e.getMessage());
                e.printStackTrace();
            }
            return "redirect:/user/toFastAddOrder.do?country="+ countryName;
        }
        map.addAttribute("countryName", countryName);
        map.addAttribute("companyName", companyName);
        map.addAttribute("isAccurate", isAccurate);
        if (countryName.equals("中国")) {
//            return "/cpm/searchCompanyList";
            return "/creditsafe/searchCompanyList";
        } else {
            return "/creditsafe/searchCompanyList";
        }
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
     * 跳转simple忘记密码页面
     * @return
     */
    @RequestMapping(value = "/simple/toForgetPW")
    public String toForgetPWSimple() {
        logger.info("跳转simple忘记密码页面开始...");
        return "simplePage/forgetPW";
    }

    /**
     * 跳转重置密码页面
     * @param email
     * @param map
     * @return
     */
    @RequestMapping(value = "/toResetPW")
    public String toResetPW(String email, ModelMap map) {
        logger.info("跳转充值密码页面开始...");
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
        return "/helpList";
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
     * simple/index跳转注册页面/认证页面
     * @return
     */
    @RequestMapping(value = "/simple/toSimpleApproveCompany")
    public String toSimpleApproveCompany(HttpServletRequest request) {
        logger.info("simple/index跳转注册页面/认证页面开始...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        if (customer == null){
            return "simplePage/login";
        } else {
            return "simplePage/customer/companyCreditCart";
        }
    }


    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition1")
    public String toIndexAddition1(HttpServletRequest request,ModelMap map,String country,String continent,String companyName,String companyPhone,String companyWebsite,String companyEmail,String companyAdd) {
        logger.info("跳转认证服务页面开始...");
        CreditServices creditServices = new CreditServices();
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        if (customer == null) {

        } else {
            creditServices.setName(customer.getName());
            creditServices.setEmail(customer.getEmail());
            creditServices.setPhone(customer.getPhone());
        }
        BootGrid<Continent> continents = continentService.getContinents();
        for (Continent c: continents.getRows()){
            c.setCountries(countryService.selectCountryByContinentId(c.getId()));
        }
        String json = JSON.toJSONString(continents.getRows());
        if (country == null || country.equals("")){
        } else {
            //除去空格 及 空字符
            country = country.replaceAll("\\s*", "");
            BootGrid<Country> countries = countryService.getCountries();
            for (Country c : countries.getRows()){
                if (c.getCnName().equals(country) || c.getEnName().equals(country)) {
                    if (c.getContinent().getCnName() == null){
                        continent = null;
                    } else {
                        continent = c.getContinent().getCnName();
                    }
                }
            }
        }
        creditServices.setCompanyName(companyName);
        creditServices.setCompanyPhone(companyPhone);
        creditServices.setCompanyEmail(companyEmail);
        creditServices.setCompanyWebsite(companyWebsite);
        creditServices.setCompanyAddOther(companyAdd);

        map.addAttribute("continents", json);
        map.addAttribute("creditServices", creditServices);
        map.addAttribute("country", country);
        map.addAttribute("continent", continent);
        return "/indexAddition/additional1";
    }

    /**
     * 跳转simple indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition1")
    public String toSimpleIndexAddition1(HttpServletRequest request,ModelMap map,String country,String continent,String companyName,String companyPhone,String companyWebsite,String companyEmail,String companyAdd) {
        logger.info("跳转simple认证服务页面开始...");
        CreditServices creditServices = new CreditServices();
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        if (customer == null){

        } else {
            creditServices.setName(customer.getName());
            creditServices.setEmail(customer.getEmail());
            creditServices.setPhone(customer.getPhone());
        }
        BootGrid<Continent> continents = continentService.getContinents();
        for (Continent c: continents.getRows()){
            c.setCountries(countryService.selectCountryByContinentId(c.getId()));
        }
        String json = JSON.toJSONString(continents.getRows());
        if (country == null || country.equals("")){
        } else {
            //除去空格 及 空字符
            country = country.replaceAll("\\s*", "");
            BootGrid<Country> countries = countryService.getCountries();
            for (Country c : countries.getRows()){
                if (c.getCnName().equals(country) || c.getEnName().equals(country)) {
                    if (c.getContinent().getCnName() == null){
                        continent = null;
                    } else {
                        continent = c.getContinent().getCnName();
                    }
                }
            }
        }
        creditServices.setCompanyName(companyName);
        creditServices.setCompanyPhone(companyPhone);
        creditServices.setCompanyEmail(companyEmail);
        creditServices.setCompanyWebsite(companyWebsite);
        creditServices.setCompanyAddOther(companyAdd);

        map.addAttribute("continents", json);
        map.addAttribute("creditServices", creditServices);
        map.addAttribute("country", country);
        map.addAttribute("continent", continent);
        return "simplePage/indexAddition/additional1";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition2")
    public String toIndexAddition2() {
        logger.info("跳转收账管理页面开始...");
        return "/indexAddition/additional2";
    }

    /**
     * 跳转simple indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition2")
    public String toSimpleIndexAddition2() {
        logger.info("跳转simple收账管理页面开始...");
        return "simplePage/indexAddition/additional2";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition3")
    public String toIndexAddition3() {
        logger.info("跳转司法服务页面开始...");
        return "/indexAddition/additional3";
    }

    /**
     * 跳转simple indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition3")
    public String toSimpleIndexAddition3() {
        logger.info("跳转simple司法服务页面开始...");
        return "simplePage/indexAddition/additional3";
    }

    /**
     * 跳转simple indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition4")
    public String toIndexAddition4() {
        logger.info("跳转尽职调查服务页面开始...");
        return "/indexAddition/additional4";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition4")
    public String toSimpleIndexAddition4() {
        logger.info("跳转simple尽职调查服务页面开始...");
        return "simplePage/indexAddition/additional4";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition5")
    public String toIndexAddition5() {
        logger.info("跳转商业资讯服务页面开始...");
        return "/indexAddition/additional5";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition5")
    public String toSimpleIndexAddition5() {
        logger.info("跳转simple商业资讯服务页面开始...");
        return "simplePage/indexAddition/additional5";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition6")
    public String toIndexAddition6() {
        logger.info("跳转数据对接服务页面开始...");
        return "/indexAddition/additional6";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition6")
    public String toSimpleIndexAddition6() {
        logger.info("跳转simple数据对接服务页面开始...");
        return "simplePage/indexAddition/additional6";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition7")
    public String toIndexAddition7() {
        logger.info("跳转搜索或订购服务页面开始...");
        return "/indexAddition/additional7";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition7")
    public String toSimpleIndexAddition7() {
        logger.info("跳转simple搜索或订购服务页面开始...");
        return "simplePage/indexAddition/additional7";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition8")
    public String toIndexAddition8() {
        logger.info("跳转关于我们页面开始...");
        return "/indexAddition/additional8";
    }


    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition8")
    public String toSimpleIndexAddition8() {
        logger.info("跳转simple关于我们页面开始...");
        return "simplePage/indexAddition/additional8";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition9")
    public String toIndexAddition9() {
        logger.info("跳转工作机会页面开始...");
        return "/indexAddition/additional9";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition9")
    public String toSimpleIndexAddition9() {
        logger.info("跳转simple工作机会页面开始...");
        return "simplePage/indexAddition/additional9";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition10")
    public String toIndexAddition10() {
        logger.info("跳转帮助页面开始...");
        return "/indexAddition/additional10";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition10")
    public String toSimpleIndexAddition10() {
        logger.info("跳转simple帮助页面开始...");
        return "simplePage/indexAddition/additional10";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition11")
    public String toIndexAddition11() {
        logger.info("跳转隐私及保密页面开始...");
        return "/indexAddition/additional11";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition11")
    public String toSimpleIndexAddition11() {
        logger.info("跳转simple隐私及保密页面开始...");
        return "simplePage/indexAddition/additional11";
    }
    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/toIndexAddition12")
    public String toIndexAddition12() {
        logger.info("跳转法律声明页面开始...");
        return "/indexAddition/additional12";
    }

    /**
     * 跳转indexAddition页面
     * @return
     */
    @RequestMapping(value = "/simple/toIndexAddition12")
    public String toSimpleIndexAddition12() {
        logger.info("跳转simple法律声明页面开始...");
        return "simplePage/indexAddition/additional12";
    }


}
