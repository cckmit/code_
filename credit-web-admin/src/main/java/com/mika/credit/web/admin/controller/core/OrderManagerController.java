package com.mika.credit.web.admin.controller.core;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderQuery;
import com.mika.credit.common.entity.order.Orders;
import com.mika.credit.facade.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OrderManagerController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表 AJAX
     *
     * @param grid
     * @param condition
     * @return
     */
    @RequestMapping(value = "/core/orderList", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String customOrderList(BootGrid<Orders> grid, OrderQuery condition) {
        BootGrid<Orders> result;
        result = orderService.findOrders(grid,condition);
        return JSON.toJSONString(result);
    }
    /**
     * 删除订单
     */
    @RequestMapping(value = "/core/delOrder",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody String delOrder(Orders order) {
        ResponseResult<Orders> result;
        result = orderService.deleteOrderPhysical(order.getId());
        return JSON.toJSONString(result);
    }

}