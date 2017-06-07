package com.mika.credit.web.admin.controller.core;


import com.alibaba.fastjson.JSON;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.order.OrderDetail;
import com.mika.credit.common.entity.order.OrderDetailQuery;
import com.mika.credit.common.entity.order.OrderDetailView;
import com.mika.credit.common.entity.order.OrderDetailViewQuery;
import com.mika.credit.facade.order.service.OrderDetailViewService;
import com.mika.credit.facade.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountStatementManagerController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailViewService orderDetailViewService;
	/**
	 * 对账单页面 AJAX
	 * @param grid
	 * @param condition
	 * @return
	 */
	@RequestMapping(value = "/core/accountStatementList",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody String customOrderDetailList(BootGrid<OrderDetailView> grid, OrderDetailViewQuery condition) {
		condition.setHasPay(true);                                                                      //只查找支付成功的订单
		BootGrid<OrderDetailView> result = orderDetailViewService.findByExample(grid, condition);
		return JSON.toJSONString(result);
	}
}