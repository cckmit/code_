package com.mika.credit.web.admin.controller.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Country;
import com.mika.credit.facade.admin.model.Customer;
import com.mika.credit.facade.admin.service.CustomerService;
import com.mika.credit.facade.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户信息
 */
@Controller
public class CustomerController {
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmailService emailService;

    /**
     * 后台客户信息列表 AJAX
     *
     * @return
     */
    @RequestMapping(value = "/basic/customerList", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String managerCustomerList(Customer customer) {
        BootGrid<Customer> result = customerService.getCustomers(customer);
        return JSON.toJSONString(result);
    }

    /**
     * 后台保存客户信息 AJAX
     *
     * @param grid
     * @param customer
     * @return
     */
    @RequestMapping(value = "/basic/customerSave", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String managerCustomerSave(BootGrid<Country> grid, Customer customer) {
        System.out.println("in managerCustomerSave--------->");
        System.out.println(customer);
        if (customerService.merge(customer) > 0) {
            grid.setResult(true);
        } else {
            grid.setResult(false);
        }
        return JSON.toJSONString(grid);
    }

    /**
     * 后台删除客户信息
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "/basic/deleteCustomer", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String managerDeleteCustomer(@RequestBody Customer customer) {
        ResponseResult<Customer> result = null;
        result = customerService.deleteCustomer(customer.getId());
        return JSON.toJSONString(result);
    }

    /**
     * 条件查询客户信息
     *
     * @param customer
     * @param map
     * @return
     */
    @RequestMapping(value = "/basic/getCustomerInfoGE", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getCustomerInfoGE(@RequestBody Customer customer, ModelMap map) {
        ResponseResult<Customer> customerResult = customerService.getCustomerInfoByIdGE(customer.getId());
        return JSON.toJSONString(customerResult);
    }

    @RequestMapping(value = "/basic/getCustomerInfoGS", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String getCustomerInfoGS(@RequestBody Customer customer, ModelMap map) {
        ResponseResult<Customer> customerResult = customerService.getCustomerInfoByIdGS(customer.getId());
        return JSON.toJSONString(customerResult);
    }


    /**
     * 修改客户信息
     *
     * @param customer
     * @param request
     * @return
     */
    @RequestMapping(value = "/basic/modifyCustomerInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String modifyManagerCustomerInfo(@RequestBody Customer customer, HttpServletRequest request) {
        ResponseResult<Customer> result = customerService.modifyMyInfomation(customer);
        return JSON.toJSONString(result);
    }

    /**
     * 认证客户
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "/basic/modifyCertify", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody String modifyCertify(@RequestBody Customer customer) {
        ResponseResult<Customer> result = customerService.modifyCertify(customer);
        if (customer.getCheckStatus().equals("是")) {
            if (result.getCode()) {
                ResponseResult<Customer> result1 = customerService.getCustomerInfoByIdGE(customer.getId());    //修改认证状态查找customer的email发送邮件
                Map<String, Object> map = new HashMap();
                map.put("toAddress", result1.getContent().getEmail());
                emailService.sendEmail("globalEagle", "approveSuccess", map);
            }
        }
            return JSON.toJSONString(result);
        }
    /**
     * 跳转用户修改个人信息界面
     *
     * @param request
     * @param map
     * @return
     */
//    @RequestMapping(value = "/customer/tochangedInformation")
//    public String tochangedInformation(HttpServletRequest request, ModelMap map) {
//        Customer c = (Customer) request.getSession().getAttribute("customerInfo");
//        if (c == null) {
//            return "/index";
//        }
//        Customer customerNew = customerService.getCustomerInfoById(c.getId()).getContent();
//        request.setAttribute("customerInfo", customerNew);
//        map.addAttribute("c", customerNew);
//        return "/customer/myInformation";
//    }

    /**
     * 修改个人信息 AJAX
     *
     * @param customer
     * @param request
     * @return
     */
    @RequestMapping(value = "/customer/changedInformation", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String changedInformation(@RequestBody Customer customer, HttpServletRequest request, ModelMap map) {
        Customer sessionCustomer = (Customer) request.getSession().getAttribute("customerInfo");
        customer.setId(sessionCustomer.getId());
        ResponseResult<Customer> result = customerService.modifyMyInfomation(customer);
        request.setAttribute("customerInfo", result.getContent());
        map.addAttribute("c", result.getContent());
        return JSON.toJSONString(result);
    }

    /**
     * 提交 申请审核
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/customer/authCompanyCommit", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String authCompanyCommit(HttpServletRequest request, ModelMap map) {
        ResponseResult<Customer> result = new ResponseResult<>();
        Customer sessionCustomer = (Customer) request.getSession().getAttribute("customerInfo");
        if (sessionCustomer.getAuthSubTime() == null) {
            sessionCustomer.setAuthSubTime(new Date());
            result = customerService.modifyMyInfomation(sessionCustomer);
            map.addAttribute("c", result.getContent());
            request.setAttribute("customerInfo", result.getContent());
        } else {
            result.setCode(false);
        }
        return JSON.toJSONString(result);
    }

    /**
     * 检查余额
     *
     * @param price
     * @param customer
     * @return
     */
    @RequestMapping(value = "/customer/checkBalance", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String customerCheckBalance(@RequestBody String price, @SessionAttribute("customerInfo") Customer customer) {
        JSONObject jsonObject = JSON.parseObject(price);
        price = jsonObject.getString("price");
        float amount = 0;
        if (price != null && !price.equals("")) {
            amount = Float.parseFloat(price);
        }
        ResponseResult<Customer> result = customerService.customerCheckBalance(amount, customer.getId());
        return JSON.toJSONString(result);
    }


    /**
     * 修改验证状态
     *
     * @param
     * @param json
     * @return
     */
    @RequestMapping(value = "/basic/editCheckStatus", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody String editCheckStatus(@RequestBody String json, HttpServletRequest request) {
        Customer customer = new Customer();
        JSONObject jsonObject = JSON.parseObject(json);
        String id = jsonObject.getString("id");
        String companyNameStatus = jsonObject.getString("companyNameStatus");
        String companyAddressStatus = jsonObject.getString("companyAddressStatus");
        String companyPhoneStatus = jsonObject.getString("companyPhoneStatus");
        String positionStatus = jsonObject.getString("positionStatus");
        customer.setId(Integer.parseInt(id));
        if (companyNameStatus.equals("1") && companyAddressStatus.equals("1") && companyPhoneStatus.equals("1") && positionStatus.equals("1")) {
            customer.setCheckStatus("是");
        } else {
            customer.setCheckStatus("否");
        }
        JSONObject jsonObj = new JSONObject();
        Map<String, String> data = new HashMap<String, String>();
        data.put("companyNameStatus", companyNameStatus);
        data.put("companyAddressStatus", companyAddressStatus);
        data.put("companyPhoneStatus", companyPhoneStatus);
        data.put("positionStatus", positionStatus);
        jsonObj.put("data", data);
        customer.setCheckStatusOption(jsonObj.toString());
        ResponseResult<Customer> result = customerService.editCheckStatus(customer);
        if(customer.getCheckStatus().equals("是")) {
            if (result.getCode()) {
                ResponseResult<Customer> result1 = customerService.getCustomerInfoByIdGE(Integer.parseInt(id));    //修改认证状态查找customer的email发送邮件
                Map<String, Object> map = new HashMap();
                map.put("toAddress", result1.getContent().getEmail());
                emailService.sendEmail("globalEagle", "approveSuccess", map);
            }
        }
        System.out.println("in editCheckStatus................" + result);
        return JSON.toJSONString(result);
    }
}

