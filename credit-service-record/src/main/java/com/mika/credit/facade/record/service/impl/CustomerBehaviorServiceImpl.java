package com.mika.credit.facade.record.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.record.dao.CustomerBehaviorMapper;
import com.mika.credit.facade.record.model.CustomerBehavior;
import com.mika.credit.facade.record.model.CustomerBehaviorQuery;
import com.mika.credit.facade.record.service.CustomerBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mike on 2017/6/6.
 */
@Service("customerBehaviorService")
public class CustomerBehaviorServiceImpl implements CustomerBehaviorService {
    @Autowired
    private CustomerBehaviorMapper customerBehaviorMapper;

    @Override
    public ResponseResult<CustomerBehavior> saveCustomerBehavior(CustomerBehavior customerBehavior) {
        ResponseResult<CustomerBehavior> customerBehaviorResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(customerBehavior)) {
            if (customerBehavior.getId() == null || customerBehavior.getId() == 0) {
                customerBehavior.setId(null);
                customerBehaviorMapper.insertSelective(customerBehavior);
                customerBehaviorResponseResult.setCode(true);
                customerBehaviorResponseResult.setContent(customerBehavior);
                customerBehaviorResponseResult.setMsg("新增记录成功！");

            } else {
                customerBehaviorMapper.updateByPrimaryKeySelective(customerBehavior);
                customerBehaviorResponseResult.setCode(true);
                customerBehaviorResponseResult.setContent(customerBehavior);
                customerBehaviorResponseResult.setMsg("更新记录成功！");

            }
        } else {
            customerBehaviorResponseResult.setCode(false);
            customerBehaviorResponseResult.setMsg("记录不能为空或者公司名不能为空！");
        }
        return customerBehaviorResponseResult;
    }

    @Override
    public ResponseResult<CustomerBehavior> delCustomerBehavior(CustomerBehavior customerBehavior) {
        ResponseResult<CustomerBehavior> customerBehaviorResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(customerBehavior)&&StringUtil.isNotNull(customerBehavior.getId())){
            customerBehaviorMapper.deleteByPrimaryKey(customerBehavior.getId());
            customerBehaviorResponseResult.setCode(true);
            customerBehaviorResponseResult.setMsg("删除成功！");
        }else {
            customerBehaviorResponseResult.setCode(false);
            customerBehaviorResponseResult.setMsg("删除失败，记录或记录Id不能为空！");
        }
        return customerBehaviorResponseResult;
    }

    @Override
    public BootGrid<CustomerBehaviorQuery> selSecCustomerBehavior(CustomerBehaviorQuery customerBehaviorQuery) {
        BootGrid<CustomerBehaviorQuery> result = new BootGrid<>();
        Page<CustomerBehaviorQuery> page = PageHelper.startPage(result.getCurrent(), result.getRowCount());
        result.setTotal(customerBehaviorMapper.selectCountSelective(customerBehaviorQuery));
        result.setRows(customerBehaviorMapper.selectByPrimaryKeySelectiveQuery(customerBehaviorQuery));
        result.setResult(true);
        return result;
    }

    @Override
    public ResponseResult<CustomerBehavior> selByIdCustomerBehavior(Integer customerBehaviorId) {
        ResponseResult<CustomerBehavior> customerBehaviorResponseResult = new ResponseResult<>();
        CustomerBehavior customerBehavior = customerBehaviorMapper.selectByPrimaryKey(customerBehaviorId);
        if (StringUtil.isNotNull(customerBehavior)){
            customerBehaviorResponseResult.setCode(true);
            customerBehaviorResponseResult.setContent(customerBehavior);
        }else {
            customerBehaviorResponseResult.setCode(false);
            customerBehaviorResponseResult.setMsg("未查询到该数据！");
        }
        return customerBehaviorResponseResult;
    }
}
