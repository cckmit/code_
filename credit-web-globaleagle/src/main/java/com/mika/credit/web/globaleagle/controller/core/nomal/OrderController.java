package com.mika.credit.web.globaleagle.controller.core.nomal;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.*;
import com.mika.credit.common.util.UtilDateTime;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.email.service.EmailService;
import com.mika.credit.facade.globaleagle.core.model.CompanyInfo;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.globaleagle.core.service.CustomerService;
import com.mika.credit.facade.order.service.OrderDetailViewService;
import com.mika.credit.facade.order.service.OrderService;
import com.mika.credit.facade.order.service.ProductService;
import com.mika.credit.facade.order.service.QuickOrderService;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


/**
 *
 */
@Controller
public class OrderController {
    private static Logger logger = Logger.getLogger(OrderController.class);
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private QuickOrderService quickOrderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailViewService orderDetailViewService;
    @Autowired
    private EmailService emailService;

    /**
     * 订单列表 AJAX
     *
     * @param grid
     * @param condition
     * @param customer
     * @param map
     * @return
     */
    @RequestMapping(value = "/customer/orderList", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String customOrderList(BootGrid<Orders> grid, OrderQuery condition, @SessionAttribute("customerInfo") Customer customer, ModelMap map) {
        logger.info("查询订单开始...");
        BootGrid<Orders> result = new BootGrid<Orders>();
        condition.setCustomerId(customer.getId());
        condition.setSource((byte) 1);
        result = orderService.findOrders(grid, condition);
        return JSON.toJSONString(result);
    }

    /**
     * 报告列表 AJAX
     *
     * @param grid
     * @param condition
     * @param customer
     * @param map
     * @return
     */
    @RequestMapping(value = "/customer/orderDetailList", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String customOrderDetailList(BootGrid<OrderDetailView> grid, OrderDetailViewQuery condition, @SessionAttribute("customerInfo") Customer customer, ModelMap map) {
        logger.info("查询报告开始...");
        BootGrid<OrderDetailView> result = new BootGrid<OrderDetailView>();
        condition.setCustomerId(customer.getId());
        condition.setHasPay(true);
        condition.setSource((byte) 1);
        result = orderDetailViewService.findByExample(grid, condition);
        return JSON.toJSONString(result);
    }



    /**
     * 新增报告
     * @param request
     * @param optionsRadios
     * @param companyNo
     * @param companyName
     * @param countryName
     * @param customer
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping("/customer/addOrder.do")
    public String reportChoose(HttpServletRequest request, String optionsRadios, String companyNo, String companyName, String countryName, @SessionAttribute("customerInfo") Customer customer, ModelMap map) throws Exception {
        logger.info("添加报告开始...");
        if (customer == null) {
            return "/login";
        }
        Orders orders = new Orders();
        OrderDetail orderDetail = new OrderDetail();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orders.setSource((byte) 1);
        orders.setStatus((byte) 1);
        orders.setCreateTime(new Date());
        orders.setCustomerId(customer.getId());
        orders.setCustomerName(customer.getName());
        orders.setCustomerEmail(customer.getEmail());
        orders.setHasPay(false);
        orders.setDetailCount((byte) 1);
        if (countryName.equals("中国")) {
            orderDetail.setCrefoNo(companyNo);
        } else {
            orderDetail.setCompanyNo(companyNo);
        }
        orderDetail.setCompanyName(companyName);
        orderDetail.setReportLang((byte) 1);
        orderDetail.setStatus((byte) 1);
        orderDetail.setCountryName(countryName);
        orderDetail.setProductId(Integer.parseInt(optionsRadios));
        orderDetailList.add(orderDetail);
        orders.setOrderDetails(orderDetailList);
        ResponseResult<Orders> ordersResponseResult = orderService.saveOrder(orders);
        if (ordersResponseResult.getCode()) {
            map.addAttribute("order", ordersResponseResult.getContent());
            map.addAttribute("balance", customerService.getCustomerInfoById(customer.getId()).getContent().getBalance());
            return "/customer/payOrder";
        } else {
            map.addAttribute("msg", ordersResponseResult.getMsg());
            return "/user/confirmSuccess";
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
        emailService.sendEmail("globalEagle","fastOrder",mapQuick);
        map.addAttribute("msg", "感谢您的订购，稍后会由我们工作人员和您联系！");
        return "/user/confirmSuccess";
    }


    /**
     * excel下载对账单
     * @param
     * @param
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/customer/orderDetailListExcelDown",method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public @ResponseBody void orderDetailListExcelDown(HttpServletResponse response,BootGrid<OrderDetailView> grid, OrderDetailViewQuery condition, @SessionAttribute("customerInfo") Customer customer) {
        logger.info("excel下载对账单开始...");
        if (customer == null){
        } else {
            BootGrid<OrderDetailView> result = new BootGrid<OrderDetailView>();
            condition.setCustomerId(customer.getId());
            condition.setHasPay(true);
            condition.setSource((byte) 1);
            result = orderDetailViewService.findByExample(grid,condition);
            HSSFWorkbook workbook = getStatementExcelDown(customer, result.getRows());
            String fileName = UtilGenerateID.generateID("GlobalEagleStatement") + ".xls";
            //清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
            try {
                workbook.write(response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //通过customerID查询对账单信息并下载excel
    HSSFWorkbook getStatementExcelDown(Customer customer, List<OrderDetailView> orderDetailViews){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("对账单信息");
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cell00 = row.createCell(0);
        cell00.setCellValue("对账单信息");
        HSSFCell cell01 = row.createCell(1);
        cell01.setCellValue("用户账号："+ customer.getEmail());
        HSSFCell cell02 = row.createCell(2);
        cell02.setCellValue("账单生成时间："+ UtilDateTime.nowStdDateString());

        row = sheet.createRow(1);
        HSSFCell cell10 = row.createCell(0);
        cell10.setCellValue("订单号");
        HSSFCell cell11 = row.createCell(1);
        cell11.setCellValue("国家");
        HSSFCell cell12 = row.createCell(2);
        cell12.setCellValue("公司名");
        HSSFCell cell13 = row.createCell(3);
        cell13.setCellValue("报告类型");
        HSSFCell cell14 = row.createCell(4);
        cell14.setCellValue("报告状态");
        HSSFCell cell15 = row.createCell(5);
        cell15.setCellValue("报告开始时间");
        HSSFCell cell16 = row.createCell(6);
        cell16.setCellValue("报告结束时间");

        for (int i=0;i<orderDetailViews.size();i++){
            row = sheet.createRow(i+2);
            HSSFCell cell1 = row.createCell(0);
            cell1.setCellValue(orderDetailViews.get(i).getOrderNo());

            HSSFCell cell2 = row.createCell(1);
            cell2.setCellValue(orderDetailViews.get(i).getCountryName());
            HSSFCell cell3 = row.createCell(2);
            cell3.setCellValue(orderDetailViews.get(i).getCompanyName());

            HSSFCell cell4 = row.createCell(3);
            if (orderDetailViews.get(i).getProductType().equals("1")){
                cell4.setCellValue("数据库报告");
            }else if (orderDetailViews.get(i).getProductType().equals("2")){
                cell4.setCellValue("数据库完整报告");
            }else if (orderDetailViews.get(i).getProductType().equals("3")){
                cell4.setCellValue("完整版报告");
            }else if (orderDetailViews.get(i).getProductType().equals("4")){
                cell4.setCellValue("完整版报告-加急");
            }
            HSSFCell cell5 = row.createCell(4);
            cell5.setCellValue(orderDetailViews.get(i).getStatusNameCN());

            HSSFCell cell6 = row.createCell(5);
            cell6.setCellValue(UtilDateTime.toStdDateString(orderDetailViews.get(i).getCreateTime()));
            HSSFCell cell7 = row.createCell(6);
            cell7.setCellValue(UtilDateTime.toStdDateString(orderDetailViews.get(i).getUpdateTime()));

        }
        return workbook;

    }


    /**
     * 跳转收据下载页面
     *
     * @param map
     * @param orderId
     * @param customer
     * @return
     */
    @RequestMapping(value = "customer/toReceiptDown")
    public String toReceiptDown(ModelMap map, String orderId, @SessionAttribute("customerInfo") Customer customer) {
        logger.info("跳转收据下载页面开始...");
        ResponseResult<Orders> order = orderService.findOrdersById(Long.parseLong(orderId));
        List<OrderDetail> orderDetailList = orderService.findOrderDetailByOrderId(Long.parseLong(orderId));
        order.getContent().setOrderDetails(orderDetailList);
        map.addAttribute("order", order.getContent());
        map.addAttribute("customer", customer);
        return "customer/receiptDown";
    }

}