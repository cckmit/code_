package com.mika.credit.facade.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.order.dao.AccessOrderMapper;
import com.mika.credit.facade.order.entity.AccessOrder;
import com.mika.credit.facade.order.entity.AccessOrderQuery;
import com.mika.credit.facade.order.service.AccessOrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/5/19.
 */
@SuppressWarnings("Duplicates")
@Service("accessOrderService")
public class AccessOrderServiceImpl implements AccessOrderService {
    @Autowired
    private AccessOrderMapper accessOrderMapper;

    private static final Log logger = LogFactory.getLog(AccessOrderServiceImpl.class);

    @Override
    public ResponseResult<AccessOrder> save(AccessOrder record) {
        logger.info("进入保存订单save方法");
        ResponseResult<AccessOrder> result = new ResponseResult<>();
        if (record != null) {
            record.setCreateTime(new Date());
            record.setNo(UtilGenerateID.generateID("AO"));
            if (accessOrderMapper.insertSelective(record) > 0) {
                result.setCode(true);
                result.setContent(record);
            }
        } else {
            result.setMsg("保存订单不能为空");
        }
        logger.info("保存订单saveOrder方法结束,返回结果:" + JSON.toJSONString(result));
        return result;
    }

    @Override
    public BootGrid<AccessOrder> find(BootGrid<AccessOrder> bootGrid, AccessOrderQuery example) {
        logger.info("进入分页查询订单find方法");
        if (bootGrid != null && example != null) {
            //+1天，否则查询有误
            Date createDateTo = example.getCreateDateTo();
            if (createDateTo != null) {
                Calendar c = Calendar.getInstance();
                c.setTime(createDateTo);
                c.add(Calendar.DATE, 1);
                example.setCreateDateTo(c.getTime());
            }
            Page<AccessOrder> page = PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
            bootGrid.setRows(accessOrderMapper.select(example));
            bootGrid.setTotal((int) page.getTotal());
            bootGrid.setResult(true);
        }
        logger.info("分页查询订单find方法结束,返回结果:" + JSON.toJSONString(bootGrid));
        return bootGrid;
    }

    @Override
    public List<AccessOrder> find(AccessOrderQuery example) {
        logger.info("进入分页查询订单find方法");
        if (example != null) {
            //+1天，否则查询有误
            Date createDateTo = example.getCreateDateTo();
            if (createDateTo != null) {
                Calendar c = Calendar.getInstance();
                c.setTime(createDateTo);
                c.add(Calendar.DATE, 1);
                example.setCreateDateTo(c.getTime());
            }
            List<AccessOrder> accessOrders = accessOrderMapper.select(example);
            logger.info("分页查询订单find方法结束,返回结果:" + JSON.toJSONString(accessOrders));
            return accessOrders;
        }
        return null;
    }

    @Override
    public ResponseResult<AccessOrder> findById(Long id) {
        logger.info("进入根据订单id查询订单findById方法");
        ResponseResult<AccessOrder> result = new ResponseResult<>();
        if (id != null) {
            AccessOrder accessOrder = accessOrderMapper.selectByPrimaryKey(id);
            if (accessOrder != null) {
                result.setCode(true);
                result.setContent(accessOrder);
            }
        }
        if (!result.getCode()) {
            result.setMsg("无此订单,查询失败");
        }
        logger.info("根据订单id查询订单方法结束,返回结果:" + JSON.toJSONString(result));
        return result;
    }

    @Override
    public ResponseResult<AccessOrder> findByNO(String no) {
        logger.info("进入根据订单号查询订单findByNO方法");
        ResponseResult<AccessOrder> result = new ResponseResult<>();
        if (StringUtils.isNotBlank(no)) {
            AccessOrder accessOrder = accessOrderMapper.selectByNo(no);
            if (accessOrder != null) {
                result.setCode(true);
                result.setContent(accessOrder);
            }
        }
        if (!result.getCode()) {
            result.setMsg("无此订单,查询失败");
        }
        logger.info("根据订单号查询订单findByNO方法结束,返回结果:" + JSON.toJSONString(result));
        return result;
    }

    @Override
    public ResponseResult<AccessOrder> delete(AccessOrder record) {
        logger.info("进入删除订单delete方法");
        ResponseResult<AccessOrder> result = new ResponseResult<>();
        if (record != null) {
            if (accessOrderMapper.delete(record) > 0) {
                result.setCode(true);
                result.setMsg("订单删除成功");
            }
        }
        if (!result.getCode()) {
            result.setMsg("订单删除失败");
        }
        logger.info("删除订单delete方法结束,返回结果:" + JSON.toJSONString(result));
        return result;
    }

    @Override
    public ResponseResult<AccessOrder> updateFinish(AccessOrder record) {
        logger.info("进入更新订单完成updateFinish方法");
        ResponseResult<AccessOrder> result = new ResponseResult<>();
        if (record != null) {
            if (accessOrderMapper.updateFinish(record) > 0) {
                result.setCode(true);
                result.setMsg("订单标记完成成功");
            }
        }
        if (!result.getCode()) {
            result.setMsg("订单标记完成失败");
        }
        logger.info("更新订单完成updateFinish方法结束,返回结果:" + JSON.toJSONString(result));
        return result;
    }

    @Override
    public ResponseResult<AccessOrder> updateCrefoNo(AccessOrder record) {
        logger.info("进入修改订单企业crefoNo方法");
        ResponseResult<AccessOrder> result = new ResponseResult<>();
        if (record != null) {
            if (accessOrderMapper.updateCrefoNo(record) > 0) {
                result.setCode(true);
                result.setMsg("修改crefoNo成功");
            }
        }
        if (!result.getCode()) {
            result.setMsg("修改crefoNo失败");
        }
        logger.info("修改订单企业crefoNo方法结束,返回结果:" + JSON.toJSONString(result));
        return result;
    }

    @Override
    public ResponseResult<AccessOrder> updateDbTarget(AccessOrder record) {
        logger.info("进入更新订单入库updateDbTarget方法");
        ResponseResult<AccessOrder> result = new ResponseResult<>();
        if (record != null) {
            if (accessOrderMapper.updateDbTarget(record) > 0) {
                result.setCode(true);
                result.setMsg("修改入库目标成功");
            }
        }
        if (!result.getCode()) {
            result.setMsg("修改入库目标失败");
        }
        logger.info("更新订单入库updateDbTarget方法结束,返回结果:" + JSON.toJSONString(result));
        return result;
    }
}
