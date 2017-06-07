package com.mika.credit.facade.globalsearch.core.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globalsearch.core.dao.CreditServiceMapper;
import com.mika.credit.facade.globalsearch.core.model.CreditService;
import com.mika.credit.facade.globalsearch.core.service.CreditServiceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("creditServiceService")
public class CreditServiceServiceImpl implements CreditServiceService {
    private static Logger logger = Logger.getLogger(CreditServiceServiceImpl.class);
	@Autowired
	private CreditServiceMapper creditServiceMapper;

	@Override
	public ResponseResult<CreditService> add(CreditService creditService) {
        logger.info("添加服务方法开始...");
		ResponseResult<CreditService> result = new ResponseResult<>();
		int add=creditServiceMapper.insertSelective(creditService);
		if (add>0){
			result.setCode(true);
			result.setMsg("添加成功");
			return result;
		}else {
			result.setCode(false);
			result.setMsg("添加失败");
			return result;
		}
	}

	@Override
	public ResponseResult<CreditService> modify(CreditService creditService) {
        logger.info("修改服务方法开始...");
        ResponseResult<CreditService> result = new ResponseResult<>();
        int update=creditServiceMapper.updateByPrimaryKeySelective(creditService);
        if (update>0){
            result.setCode(true);
            result.setMsg("修改成功");
            return result;
        }else {
            result.setCode(false);
            result.setMsg("修改失败");
            return result;
        }
	}

	@Override
	public ResponseResult<CreditService> getCreditServiceById(CreditService creditService) {
        logger.info("查询服务方法开始...");
        ResponseResult<CreditService> result = new ResponseResult<>();
        CreditService creditService1 = creditServiceMapper.selectByPrimaryKey(creditService.getCustomerId());
        if (creditService != null) {
            result.setCode(true);
            result.setMsg("The query is successful");
            result.setContent(creditService);
            return result;
        } else {
            result.setCode(false);
            result.setMsg("query fails");
            return result;

        }
	}

	@Override
	public ResponseResult<CreditService> delById(int id) {
        logger.info("删除服务方法开始...");
        ResponseResult<CreditService> result = new ResponseResult<>();
        if(creditServiceMapper.deleteByPrimaryKey(id)>0){
            result.setCode(true);
            result.setMsg("Delete success");
        } else{
            result.setCode(false);
            result.setMsg("Delete failed");
        }
        return result;
	}

    @Override
    public BootGrid<CreditService> getCreditService(BootGrid<CreditService> grid, CreditService creditService) {
        logger.info("分页查询服务方法开始...");
        Page<CreditService> page = PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(creditServiceMapper.selectSelective(creditService));
        grid.setTotal(creditServiceMapper.selectCountSelective(creditService));
        grid.setResult(true);
        return grid;
    }
}
