package com.mika.credit.web.globalsearch.controller.core;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globalsearch.core.model.CreditService;
import com.mika.credit.facade.globalsearch.core.model.Customer;
import com.mika.credit.facade.globalsearch.core.service.CreditServiceService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller  
public class CreditServiceController {
    private static final Logger logger = Logger.getLogger(CreditServiceController.class);
    @Resource
    private CreditServiceService creditServiceService;

    /**
     * 添加
     * @param creditService
     * @return
     */
    @RequestMapping(value = "/customer/creditServiceSave",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String creditServiceSave(@RequestBody CreditService creditService,@SessionAttribute("customerInfo") Customer customer) {
        logger.info("添加信用服务开始...");
        ResponseResult<CreditService> result = new ResponseResult<>();
        if (creditService.getType()==null||creditService.getType().equals("")){
            result.setCode(false);
            result.setMsg("不能为空");
            return JSON.toJSONString(result);
        }else {
            creditService.setCustomerId(customer.getId());
            creditServiceService.add(creditService);
            return JSON.toJSONString(result);
        }
    }
    /**
     * 分页查询
     * @return
     */
    @RequestMapping(value = "/customer/creditServiceList" ,method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String creditServiceList(BootGrid<CreditService> grid, CreditService creditService, @SessionAttribute("customerInfo") Customer customer) {
        logger.info("分页查询信用服务开始...");
        creditService.setCustomerId(customer.getId());
        BootGrid<CreditService> result = creditServiceService.getCreditService(grid,creditService);
        return JSON.toJSONString(result);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/customer/modifyCreditService",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String modify(@RequestBody CreditService creditService) {
        logger.info("修改信用服务开始...");
        ResponseResult<CreditService> result = null;
        result =creditServiceService.modify(creditService);
        return JSON.toJSONString(result);
    }

    /**
     * 根据id删除
     */
    @RequestMapping(value = "/customer/delCreditServiceById",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String delCreditServiceById(@RequestBody CreditService creditService) {
        logger.info("根据id删除信用服务开始...");
        ResponseResult<CreditService> result = null;
        result =creditServiceService.delById(creditService.getId());
        return JSON.toJSONString(result);
    }
}