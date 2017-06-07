package com.mika.credit.web.globalsearch.controller.core;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.*;
import com.mika.credit.facade.email.service.EmailService;
import com.mika.credit.facade.globalsearch.core.model.CompanyBasicInfo;
import com.mika.credit.facade.globalsearch.core.model.Customer;
import com.mika.credit.facade.globalsearch.core.service.CustomerService;

import com.mika.credit.facade.index.bean.Company;
import com.mika.credit.facade.index.bean.QueryENByName;
import com.mika.credit.facade.index.service.CompanyIndexService;
import com.mika.credit.facade.order.service.OrderDetailViewService;
import com.mika.credit.facade.order.service.OrderService;
import com.mika.credit.facade.order.service.ProductService;
import com.mika.credit.facade.order.service.QuickOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class OrderController {
    private static final Logger logger = Logger.getLogger(OrderController.class);
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Resource
    private OrderService orderService;

    @Resource
    private OrderDetailViewService orderDetailQuery;

    @Resource
    private CustomerService customerService;

    @Resource
    private QuickOrderService quickOrderService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CompanyIndexService companyIndexService;
    /**
     * fullsearch
     * 添加订单
     *
     * @return
     */
    @RequestMapping(value = "/customer/addOrder", method = {RequestMethod.POST,RequestMethod.GET}, produces = "text/html;charset=UTF-8")
    public String addCustomerOrderFromCart(HttpServletRequest request, String optionsRadios, String companyName, String companyNameCN,String crefoNo, ModelMap map) {
        logger.info("添加订单开始...");
        // TODO: 2017/1/7
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        ResponseResult<Orders> result = null;
        Orders orders = new Orders();

        BootGrid<OrderDetailView> bootGrid=new BootGrid<>();
        OrderDetailViewQuery orderDetailViewQuery=new OrderDetailViewQuery();
        orderDetailViewQuery.setCompanyName(companyName);
        orderDetailViewQuery.setCustomerId(customer.getId());
        BootGrid<OrderDetailView> byExample = orderDetailQuery.findByExample(bootGrid, orderDetailViewQuery);
        if (byExample.getResult()){
            for (int i=0;i<byExample.getRows().size();i++){
                if (byExample.getRows().get(i).getOrderStatus()==1){
                    byExample.getRows().remove(i);
                }
            }
        }
        map.addAttribute("orderDetailView",byExample.getRows());
        orders.setCustomerId(customer.getId());
        orders.setCustomerEmail(customer.getEmail());
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId(Integer.valueOf(optionsRadios));
        orderDetail.setCompanyName(companyName);
        orderDetail.setCrefoNo(crefoNo);
        orderDetail.setCompanyNameCN(companyNameCN);
        orderDetail.setCountryName("china");
        orderDetails.add(orderDetail);
        orders.setSource((byte) 2);
        orders.setOrderDetails(orderDetails);
        result = orderService.saveOrder(orders);

        if (result.getCode()) {
            //显示订单详情信息
            OrderDetailViewQuery orderDetailViewQuery1=new OrderDetailViewQuery();
            orderDetailViewQuery1.setCustomerId(customer.getId());
            orderDetailViewQuery1.setProductId(Integer.valueOf(optionsRadios));
            BootGrid<OrderDetailView> byExample1 = orderDetailQuery.findByExample(bootGrid, orderDetailViewQuery1);
            if (byExample1.getResult()&&byExample1.getRows().size()>0){
                map.addAttribute("orderDetail",byExample1.getRows().get(0));
            }
            map.addAttribute("order", result.getContent());
            //显示该公司基础数据
            QueryENByName queryENByName = new QueryENByName();
            queryENByName.setNameEN(companyName);
//            queryENByName.setReg(reg);
            BootGrid<Company> bootGridCompany = companyIndexService.fillCompanyIndexSimpleENByName(queryENByName);
            if (bootGridCompany.getResult()) {
                List<Company> rows = bootGridCompany.getRows();
                if (rows.size() > 0) {
                    CompanyBasicInfo companyBasicInfo = new CompanyBasicInfo();
                    Company company = rows.get(0);
                    companyBasicInfo.setCompanyNameEn(companyName);
                    companyBasicInfo.setCompanyName(company.getNameCN());
                    companyBasicInfo.setRegistrationId(company.getReg());
                    companyBasicInfo.setUrl(company.getWebsite());
                    companyBasicInfo.setLocalEn(company.getCityEN() + "/" + company.getProvinceEN());
                    companyBasicInfo.setProductIntroductionEn(company.getProductLabel());
                    companyBasicInfo.setServicesIntroductionEn(company.getIntroduction());
                    companyBasicInfo.setAboutUsEn(company.getIntroduction());
                    map.addAttribute("companyBasicInfo",companyBasicInfo);
                }
            }
            map.addAttribute("balance", customerService.getCustomerInfoById(customer.getId()).getContent().getBalance());
            return "/customer/orderPayfo";
        } else {
            map.addAttribute("msg", result.getMsg());
            return "/customer/confirmSuccess";
        }
    }
    /**
     * 快速订购 提交
     *
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/customer/addOrderFromFast")
    public String addOrderFromFast(HttpServletRequest request, QuickOrder quickOrder,String optionsRadios, ModelMap map) {
        logger.info("快速订购开始...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        quickOrder.setProductId(Integer.parseInt(optionsRadios));
        quickOrder.setCustomerId(customer.getId());
        quickOrder.setCustomerEmail(customer.getEmail());
        quickOrder.setCustomerName(customer.getName());
        quickOrder.setSource((byte) 1);
        ResponseResult<QuickOrder> ordersResponseResult = quickOrderService.saveQuickOrder(quickOrder);
        map.addAttribute("quickOrder", ordersResponseResult.getContent());
        map.addAttribute("balance", customerService.getCustomerInfoById(customer.getId()).getContent().getBalance());
        Map<String,Object> mapQuick=new HashMap();
        mapQuick.put("toAddress",customer.getEmail());
        mapQuick.put("quickOrder",JSON.toJSONString(ordersResponseResult.getContent()));
        emailService.sendEmail("globalsearch","fastOrder",mapQuick);
        map.addAttribute("msg", "Thank you for your order, we will contact you later!");
        return "/customer/confirmSuccess";
    }
    /**
     * 余额付款方式
     * @return
     */
    @RequestMapping(value = "/customer/balancePayment")
    public String balancePayment(HttpServletRequest request, String orderId, ModelMap map,@SessionAttribute("customerInfo") Customer customer) {
        logger.info("余额付款开始...");
        BootGrid<OrderDetail> bootGrid = new BootGrid<>();
        bootGrid.setCurrent(1);
        bootGrid.setRowCount(Integer.MAX_VALUE);
        ResponseResult<Orders> ordersResponseResult = customerService.modifyOrderPayment(Integer.parseInt(orderId), customer.getId(), customer.getEmail());
        BootGrid<OrderDetail> orderDetail = orderService.findOrderDetail(bootGrid, Long.valueOf(orderId));
        if (ordersResponseResult.getCode()) {
            map.addAttribute("msg", "pay success");
            Orders orders = ordersResponseResult.getContent();
            orders.setOrderDetails(orderDetail.getRows());
            map.addAttribute("order",orders );
            return "/customer/confirmSuccess";
        } else {
            map.addAttribute("msg", "pay failure," + ordersResponseResult.getMsg());
        }
        return "/customer/confirmSuccess";
    }

    /**
     * 支付
     * @param orderId
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/customer/toCustomerPay")
    public String toCustomerPay(Integer orderId, HttpServletRequest request, ModelMap map) {
        logger.info("支付开始...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        ResponseResult<Orders> responseResult = orderService.findOrdersById(Long.valueOf(orderId));
        BootGrid<OrderDetailView> bootGrid=new BootGrid<OrderDetailView>();
        BootGrid<OrderDetailView> byOrderId = orderDetailQuery.findByOrderId(bootGrid, Long.valueOf(orderId));

        OrderDetailViewQuery orderDetailViewQuery=new OrderDetailViewQuery();
        orderDetailViewQuery.setCustomerId(customer.getId());
        orderDetailViewQuery.setCompanyName(byOrderId.getRows().get(0).getCompanyName());
        BootGrid<OrderDetailView> example = orderDetailQuery.findByExample(bootGrid, orderDetailViewQuery);
        if (example.getResult()&&example.getRows().size()>0){
            for (int i=0;i<example.getRows().size();i++){
                if (example.getRows().get(i).getOrderStatus()==1){
                    example.getRows().remove(i);
                }
            }
        }
        map.addAttribute("orderDetailView",example.getRows());
        OrderDetailViewQuery orderDetailViewQuery1=new OrderDetailViewQuery();
        orderDetailViewQuery1.setProductId(byOrderId.getRows().get(0).getProductId());
        orderDetailViewQuery1.setCustomerId(customer.getId());
        BootGrid<OrderDetailView> byExample = orderDetailQuery.findByExample(bootGrid, orderDetailViewQuery1);
        if (byExample.getResult()&&byExample.getRows().size()>0){
            map.addAttribute("orderDetail",byExample.getRows().get(0));
        }

        Orders payOrder = responseResult.getContent();
        map.addAttribute("order", payOrder);
        map.addAttribute("balance", customerService.getCustomerInfoById(customer.getId()).getContent().getBalance());
        return "/customer/orderPayfo";
    }

    /**
     * 订单列表 AJAX
     * @param grid
     * @param condition
     * @return
     */
    @RequestMapping(value = "/customer/orderList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String OrderList(BootGrid<Orders> grid, OrderQuery condition,@SessionAttribute("customerInfo") Customer customer) {
        logger.info("查询订单开始...");
        BootGrid<Orders> result = new BootGrid<Orders>();
        condition.setCustomerId(customer.getId());
        condition.setSource((byte) 2);
        result = orderService.findOrders(grid,condition);
        return JSON.toJSONString(result);
    }
    /**
     * 报告列表 AJAX
     * @param grid
     * @return
     */
    @RequestMapping(value = "/customer/orderDetailList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String OrderDetailList(BootGrid<OrderDetailView> grid, OrderDetailViewQuery orderDetailViewQuery,@SessionAttribute("customerInfo") Customer customer) {
        logger.info("查询报告开始...");
        BootGrid<OrderDetailView> result = new BootGrid<OrderDetailView>();
        orderDetailViewQuery.setCustomerId(customer.getId());
        orderDetailViewQuery.setHasPay(true);
        result = orderDetailQuery.findByExample(grid,orderDetailViewQuery);
//        List<OrderDetailView> orderDetails = result.getRows();
//        ListIterator<OrderDetailView> listIterator = orderDetails.listIterator();
//        while (listIterator.hasNext()){
//            OrderDetailView orderDetailView = listIterator.next();
//            if (!orderDetailView.getStatus().equals(OrderDetailStatus.FINISHED.getStatusCode())){
//                listIterator.remove();
//            }
//        }
        return JSON.toJSONString(result);
    }

    /**
     * 取消订单！！！
     * @param order
     * @return
     */
    @RequestMapping(value = "/customer/deleteOrder",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String customDeleteOrder(@RequestBody Orders order) {
        logger.info("取消订单开始...");
        String discribe = "";
        ResponseResult<Orders> result = null;
        if(order.getId() == null ){
            discribe += "The order ID can not be empty";
        }
        if(discribe.equals("")){
            result = orderService.deleteOrderPhysical(Long.parseLong(order.getId()+""));
        } else{
            result = new ResponseResult<>();
            result.setCode(false);
            result.setMsg(discribe);
        }
        return JSON.toJSONString(result);
    }

}