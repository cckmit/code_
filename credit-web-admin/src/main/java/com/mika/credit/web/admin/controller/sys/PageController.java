package com.mika.credit.web.admin.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gavin on 16-11-3.
 */
@Controller
public class PageController {


    @RequestMapping(value = "/to")
    public String to(String page) {
        return page;
    }

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String toIndex() {
        return "index";
    }

    /**
     * 跳转个人中心
     */
    @RequestMapping(value = "/basic/home")
    public String toBasicHome() {
        return "basic/home";
    }

    /**
     * 跳转管理员首页
     */
    @RequestMapping(value = "/core/index")
    public String toCoreIndex() {
        return "core/index";
    }


    /**
     * 跳转用户管理
     * @return
     */
    @RequestMapping(value = "/core/toManagerList")
    public String toManagerList() {
        return "core/managerList";
    }

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }


    /**
     * 跳转用户管理页面
     * @return
     */
    @RequestMapping(value = "/core/toUserManager")
    public String toUserManager() {
        return "core/userManager";
    }

    /**
     * 跳转资源管理页面
     * @return
     */
    @RequestMapping(value = "/core/toResourceManager")
    public String toResourceManager() {
        return "core/resourceManager";
    }

    /**
     * 跳转机构管理页面
     * @return
     */
    @RequestMapping(value = "/core/toCorpManager")
    public String toCorpManager() {
        return "core/corpManager";
    }

    /**
     * 跳转组管理页面
     * @return
     */
    @RequestMapping(value = "/core/toGroupManager")
    public String toGroupManager() {
        return "core/groupManager";
    }


    /**
     * 跳转管理员帮助页面
     * @return
     */
    @RequestMapping(value = "/core/toHelpList")
    public String toHelpList() {
        return "core/helpList";
    }

    /**
     * 跳转全球鹰客户列表页面
     * @return
     */
    @RequestMapping(value = "/core/toCustomerListGE")
    public String toCustomerListGE() {
        return "core/customerListGE";
    }

    /**
     * 跳转全搜客户列表页面
     * @return
     */
    @RequestMapping(value = "/core/toCustomerListGS")
    public String toCustomerListGS() {
        return "core/customerListGS";
    }


    @RequestMapping(value = "/core/toCustomerSave")
    public String toCustomerSave() {
        System.out.println("in ServiceImpl's toCustomerSave--------------");
        return "core/customerSave";
    }
    /**
     * 跳转对账单页面
     * @return
     */
    @RequestMapping(value = "/core/toAccountStatementrListAll")
    public String toOrderList() {
        return "core/accountStatement";
    }

    /**
     * 跳转快速订购页面
     * @return
     */
    @RequestMapping(value = "/core/toQuickOrder")
    public String toQuickOrder() {
        return "core/quickOrder";
    }

    /**
     * 跳转管理员订单管理页面（通过订单等级和状态）
     * @return
     */
    @RequestMapping(value = "/core/toOrderListAll")
    public String toOrderListAll() {
        return "core/orderList";
    }
    /**
    * 跳转邮箱设置页面
     */
    @RequestMapping(value = "/core/toEmailListAll")
    public String toEmailListAll() {
        return "core/emailListAll";
    }
    /**
     * 跳转系统日志设置页面
     */
    @RequestMapping(value = "/core/toLogListAll")
    public String toLogListAll() {
        return "core/logListAll";
    }
    /**
     * 跳转优惠活动页面
     */
    @RequestMapping(value = "/core/toActivitiesListAll")
    public String toActivitiesListAll() {
        return "core/activitiesListAll";
    }
    /**
     * 跳转帮助文档页面
     */
    @RequestMapping(value = "/basic/toHelpLiListAll")
    public String toHelpLiListAll() {
        return "basic/helpLiListAll";
    }
    /**
     * 跳转帮助文档页面
     */
    @RequestMapping(value = "/basic/toCustomerLiListAll")
    public String toCustomerLiListAll() {
        return "basic/customerLiListAll";
    }
    /**
     * 跳转管理员报告管理页面
     * @return
     */
    @RequestMapping(value = "/core/toOrderDetailListAll")
    public String toOrderDetailListAll(String productType,ModelMap map) {
        map.addAttribute("productType", productType);
        return "core/orderDetailList";
    }

    /**
     * 跳转管理员对账单管理页面
     * @return
     */
    @RequestMapping(value = "/core/toAccountStatement")
    public String toAccountStatement(String orderLevel, String orderStatusId, ModelMap map) {
        map.addAttribute("orderLevel", orderLevel);
        map.addAttribute("orderStatusId", orderStatusId);
        return "core/accountStatement";
    }

    /**
     * 跳转管理员报告管理页面（中国）
     * @return
     */
    @RequestMapping(value = "/core/toOrderDetailListAllChina")
    public String toOrderDetailListAllChina(String orderLevel, String orderStatusId, ModelMap map) {
        map.addAttribute("orderLevel", orderLevel);
        map.addAttribute("orderStatusId", orderStatusId);
        return "core/orderDetailListChina";
    }


    @RequestMapping(value = "/core/toOrderDetailListAllCustom")
    public String toOrderDetailListAllCustom(String orderLevel, String orderStatusId, ModelMap map) {
        map.addAttribute("orderLevel", orderLevel);
        map.addAttribute("orderStatusId", orderStatusId);
        return "core/orderDetailListCustom";
    }

    @RequestMapping(value = "/core/toRechargeList")
    public String toRechargeList() {
        return "core/rechargeList";
    }

    @RequestMapping(value = "/core/toReChargeCustomerGE")
    public String toReChargeCustomerGE() {
        return "core/reChargeCustomerGE";
    }

    @RequestMapping(value = "/core/toReChargeCustomerGS")
    public String toReChargeCustomerGS() {
        return "core/reChargeCustomerGS";
    }

    /**
     * 跳转管理员洲和国家页面
     * @return
     */
    @RequestMapping(value = "/basic/toRegionAndCountry")
    public String toManagerRegionAndCountry() {
        return "basic/regionAndCountry";
    }

    /**
     * 跳转帮助页面
     * @return
     */
    @RequestMapping(value = "/help")
    public String toHelp(String cateId, ModelMap map) {
        map.put("cateId", cateId);
        return "helpList";
    }
    /**
     * 跳转登录记录页面
     * @return
     */
    @RequestMapping(value = "/core/toLoginRecordList")
    public String toLoginRecordList() {
        return "core/loginRecordList";
    }

    /**
     * 跳转商品模块列表页面
     * @return
     */
    @RequestMapping(value = "/core/toModuleList")
    public String toModuleList() {
        return "core/moduleList";
    }

    /**
     * 跳转商品列表页面
     * @return
     */
    @RequestMapping(value = "/core/toProductList")
    public String toProductList() {
        return "core/productList";
    }

    /**
     * 跳转待办事项页面
     * @return
     */
    @RequestMapping(value = "/core/toBacklogList")
    public String toBacklogList() {
        return "core/backlogList";
    }
}
