package com.mika.credit.web.globaleagle.controller.core.nomal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.creditsafe.globaldata.datatypes.reports.LtdCompanyFullReport;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.*;
import com.mika.credit.common.entity.report.cn.FullReport;
import com.mika.credit.common.util.HttpUtil;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.front.cn.service.FullReportService;
import com.mika.credit.facade.front.en.service.FullReportServiceEN;
import com.mika.credit.facade.globaleagle.core.model.Customer;
import com.mika.credit.facade.index.bean.Company;
import com.mika.credit.facade.index.bean.QueryENByName;
import com.mika.credit.facade.index.service.CompanyIndexService;
import com.mika.credit.facade.order.service.OrderDetailViewService;
import com.mika.credit.facade.order.service.OrderService;
import com.mika.credit.facade.order.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {
    private static Logger logger = Logger.getLogger(ReportController.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailViewService orderDetailViewService;
    @Autowired
    private ProductService productService;
    @Autowired
    private FullReportService fullReportService;
    @Autowired
    private FullReportServiceEN fullReportServiceEN;
    @Autowired
    private CompanyIndexService companyIndexService;

    /**
     * 产品选择页面
     *
     * @param map
     * @param companyNo
     * @param companyName
     * @param countryName
     * @return
     * @throws Exception
     */
    @RequestMapping("/user/reportChoose.do")
    public String reportChoose(HttpServletRequest request, String companyNo, String companyName, String countryName, ModelMap map) throws Exception {
        logger.info("产品选择页面跳转...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        BootGrid<Product> productBootGrid = new BootGrid<>();
        Product product = new Product();
        OrderDetailViewQuery orderDetail = new OrderDetailViewQuery();
        if (customer != null){
            //订购记录
            BootGrid<OrderDetailView> orderDetailBootGrid = new BootGrid<>();
            OrderDetailViewQuery orderDetailViewQuery = new OrderDetailViewQuery();
            orderDetailViewQuery.setCustomerId(customer.getId());
            orderDetailViewQuery.setCompanyName(companyName);
            orderDetailViewQuery.setCountryName(countryName);
            orderDetailViewQuery.setSource((byte) 1);
            orderDetailBootGrid = orderDetailViewService.findByExample(orderDetailBootGrid, orderDetailViewQuery);
            map.addAttribute("history", orderDetailBootGrid);
            orderDetail.setCustomerId(customer.getId());
            orderDetail.setCompanyName(companyName);
        }
        if (countryName.equals("中国")) {
            com.mika.credit.common.entity.report.cn.FullReport fullReportCN = new com.mika.credit.common.entity.report.cn.FullReport();
            fullReportCN.setNameCN(companyName);
            fullReportCN.setCrefoNo(companyNo);
            FullReport fullReport = fullReportService.getGlobalRegReport(fullReportCN);
            if (StringUtil.isNotNull(fullReport.getId())){
                map.addAttribute("message", true);
            }else {
                map.addAttribute("message", false);
            }
            map.put("report",fullReport);
            product.setSource((byte) 1);//来源全球鹰
            product.setProductType((byte) 1);//中国报告
            productBootGrid = productService.findCustomerProducts(productBootGrid,orderDetail,product);
        } else {
            com.mika.credit.common.entity.report.en.FullReport fullReportEN = new com.mika.credit.common.entity.report.en.FullReport();
            fullReportEN.setName(companyName);
            fullReportEN.setCompanyNo(companyNo);
            map.put("report", fullReportServiceEN.getFullReport(fullReportEN));
            product.setSource((byte) 1);//来源全球鹰
            product.setProductType((byte) 2);//外国报告
            productBootGrid = productService.findCustomerProducts(productBootGrid,orderDetail,product);
        };
        BootGrid<Company> bootGrid = companyIndexService.fillCompanyIndexSimple(companyName);
        if (bootGrid.getResult()) {
            List<Company> rows = bootGrid.getRows();
            if (rows.size() > 0) {
                map.addAttribute("companyBasicInfo", rows.get(0));
            }
        }
        map.addAttribute("products", productBootGrid);
        map.addAttribute("countryName", countryName);
        map.addAttribute("companyNo", companyNo);
        map.addAttribute("companyName", companyName);
        return "user/report";
    }

    /**
     * @param map
     * @param orderDetailId
     * @return
     * @throws Exception
     */
    @RequestMapping("/customer/openReport.do")
    public String openReport(HttpServletRequest request,ModelMap map, String orderDetailId) throws Exception {
        logger.info("报告页面跳转...");
        Customer customer = (Customer) request.getSession().getAttribute("customerInfo");
        BootGrid<Product> productBootGrid = new BootGrid<>();
        Product product = new Product();
        OrderDetailViewQuery orderDetailViewQuery = new OrderDetailViewQuery();
        ResponseResult<OrderDetail> responseResult = orderService.findOrderDetailByIdWithData(Long.parseLong(orderDetailId));
        OrderDetail orderDetail = responseResult.getContent();
        map.addAttribute("orderDetail", orderDetail);
        ResponseResult<Orders> ordersResponseResult = orderService.findOrdersById(orderDetail.getOrderId());
        map.addAttribute("order", ordersResponseResult.getContent());
        orderDetailViewQuery.setCustomerId(customer.getId());
        orderDetailViewQuery.setCompanyName(orderDetail.getCompanyName());
        map.addAttribute("companyName", orderDetailViewQuery.getCompanyName());
        if (orderDetail.getCountryName().equals("中国")) {
            map.addAttribute("companyNo", orderDetail.getCrefoNo());
            product.setSource((byte) 1);//来源全球鹰
            product.setProductType((byte) 1);//中国报告
            productBootGrid = productService.findCustomerProducts(productBootGrid, orderDetailViewQuery, product);
            map.addAttribute("products", productBootGrid);
            if (orderDetail.getData() == null || orderDetail.getData().equals("")) {
                map.addAttribute("message", false);
            } else {
                Map<String, Object> jsonResult = JSON.parseObject(orderDetail.getData(), Map.class);
                map.putAll(jsonResult);
            }
            BootGrid<Company> bootGrid = companyIndexService.fillCompanyIndexSimple(orderDetailViewQuery.getCompanyName());
            if (bootGrid.getResult()) {
                List<Company> rows = bootGrid.getRows();
                if (rows.size() > 0) {
                    map.addAttribute("companyBasicInfo", rows.get(0));
                }
            }
            return "cpm/report";
        } else {
            map.addAttribute("companyNo", orderDetail.getCompanyNo());
            product.setSource((byte) 1);//来源全球鹰
            product.setProductType((byte) 2);//外国报告
            productBootGrid = productService.findCustomerProducts(productBootGrid,orderDetailViewQuery, product);
            map.addAttribute("products", productBootGrid);
            if (orderDetail.getData() == null || orderDetail.getData().equals("")) {
                map.addAttribute("message", false);
            } else {
                LtdCompanyFullReport ltdCompanyFullReport = JSON.parseObject(orderDetail.getData(), LtdCompanyFullReport.class);
                map.put("searchDetail", ltdCompanyFullReport);
            }
            if (orderDetail.getCountryName().equals("美国") || orderDetail.getCountryName() == "美国") {
                return "creditsafe/reports/report_US";
            }
            if (orderDetail.getCountryName().equals("英国") || orderDetail.getCountryName() == "英国") {
                return "creditsafe/reports/report_GB";
            }
            if (orderDetail.getCountryName().equals("德国") || orderDetail.getCountryName() == "德国") {
                return "creditsafe/reports/report_DE";
            }
            if (orderDetail.getCountryName().equals("法国") || orderDetail.getCountryName() == "法国") {
                return "creditsafe/reports/report_FR";
            }
            if (orderDetail.getCountryName().equals("卢森堡") || orderDetail.getCountryName() == "卢森堡") {
                return "creditsafe/reports/report_LU";
            }
            if (orderDetail.getCountryName().equals("挪威") || orderDetail.getCountryName() == "挪威") {
                return "creditsafe/reports/report_NO";
            }
            if (orderDetail.getCountryName().equals("西班牙") || orderDetail.getCountryName() == "西班牙") {
                return "creditsafe/reports/report_ES";
            }
            if (orderDetail.getCountryName().equals("荷兰") || orderDetail.getCountryName() == "荷兰") {
                return "creditsafe/reports/report_NL";
            }
            if (orderDetail.getCountryName().equals("比利时") || orderDetail.getCountryName() == "比利时") {
                return "creditsafe/reports/report_BE";
            }
            if (orderDetail.getCountryName().equals("丹麦") || orderDetail.getCountryName() == "丹麦") {
                return "creditsafe/reports/report_DK";
            }
            if (orderDetail.getCountryName().equals("意大利") || orderDetail.getCountryName() == "意大利") {
                return "creditsafe/reports/report_IT";
            }
            if (orderDetail.getCountryName().equals("墨西哥") || orderDetail.getCountryName() == "墨西哥") {
                return "creditsafe/reports/report_MX";
            }
            if (orderDetail.getCountryName().equals("瑞典") || orderDetail.getCountryName() == "瑞典") {
                return "creditsafe/reports/report_SE";
            }
            if (orderDetail.getCountryName().equals("韩国") || orderDetail.getCountryName() == "韩国") {
                return "creditsafe/reports/report_KR";
            }
            if (orderDetail.getCountryName().equals("葡萄牙") || orderDetail.getCountryName() == "葡萄牙") {
                return "creditsafe/reports/report_PT";
            }
            return "cpm/report_EN";
        }
    }

    @RequestMapping(value = "/customer/judicialDetail", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String judicialDetail(@RequestBody String senddata) {
        if(senddata==null||senddata.equals("")){
            return "参数错误！";
        }
        String result = "";
        JSONObject jsonObject = JSON.parseObject(senddata);
        String dataType = jsonObject.getString("dataType");
        String id = jsonObject.getString("id");
        String url = "http://app.fahaicc.com/fhfk/query.jsp?authCode=G5YeGHulzHAb8Q7euku3&id=" + dataType + ":" + id;
        String data = HttpUtil.syncData(url);
        JSONObject jsonResult = JSON.parseObject(data);
        JSONArray jsonArray = jsonResult.getJSONArray(dataType);
        if (jsonArray == null || jsonArray.size() < 1) {
        } else {
            JSONObject jsonArrayObject = JSON.parseObject(String.valueOf(jsonArray.get(0)));
            result = jsonArrayObject.getString("body");
            if (result == null || result == "") {
                result = "无该条记录详情信息！";
            }
        }
        return JSON.toJSONString(result);
    }

}
