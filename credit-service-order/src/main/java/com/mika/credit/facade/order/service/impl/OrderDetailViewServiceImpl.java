package com.mika.credit.facade.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.entity.order.OrderDetailView;
import com.mika.credit.common.entity.order.OrderDetailViewQuery;
import com.mika.credit.facade.order.dao.OrderDetailViewMapper;
import com.mika.credit.facade.order.service.OrderDetailViewService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by dell on 2017/3/15.
 */
@Service("orderDetailViewService")
public class OrderDetailViewServiceImpl implements OrderDetailViewService {
    @Autowired
    private OrderDetailViewMapper orderDetailViewMapper;

    private static final Log logger = LogFactory.getLog(OrderDetailViewServiceImpl.class);


    @Override
    public ResponseResult<OrderDetailView> findByDetailId(Long orderDetailId) {
        logger.info("进入根据订单明细id查询订单视图findByDetailId方法");
        ResponseResult<OrderDetailView> responseResult = new ResponseResult<>();
        if (orderDetailId != null) {
            OrderDetailView orderDetailView = orderDetailViewMapper.queryById(orderDetailId);
            if (orderDetailView != null) {
                responseResult.setContent(orderDetailView);
                responseResult.setCode(true);
            }
        }
        if (!responseResult.getCode()) {
            responseResult.setMsg("无此订单");
        }
        logger.info("根据订单明细id查询订单视图findByDetailId方法结束,返回结果:"+ JSON.toJSONString(responseResult));
        return responseResult;
    }

    @Override
    public BootGrid<OrderDetailView> findByOrderId(BootGrid<OrderDetailView> bootGrid, Long orderId) {
        logger.info("进入根据订单id查询订单视图findByOrderId方法");
        if (bootGrid != null && orderId != null) {
            PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            OrderDetailViewQuery orderDetailViewQuery = new OrderDetailViewQuery();
            orderDetailViewQuery.setOrderId(orderId);
            return findByExample(bootGrid, orderDetailViewQuery);
        }
        logger.info("根据订单id查询订单视图findByOrderId方法结束,返回结果:"+ JSON.toJSONString(bootGrid));
        return bootGrid;
    }

    @Override
    public BootGrid<OrderDetailView> findByExample(BootGrid<OrderDetailView> bootGrid, OrderDetailViewQuery example) {
        logger.info("进入根据订单条件查询订单视图findByExample方法");
        if (bootGrid != null && example != null) {
            //+1天，否则查询有误
            Date createDateTo = example.getCreateDateTo();
            if (createDateTo != null) {
                Calendar c = Calendar.getInstance();
                c.setTime(createDateTo);
                c.add(Calendar.DATE, 1);
                example.setCreateDateTo(c.getTime());
            }
            Page<OrderDetailView> page = PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            bootGrid.setRows(orderDetailViewMapper.queryListByOrderDetailQuery(example));
            bootGrid.setTotal((int) page.getTotal());
            bootGrid.setResult(true);
        }
        logger.info("根据订单条件查询订单视图findByExample方法结束,返回结果:"+ JSON.toJSONString(bootGrid));
        return bootGrid;
    }

}
