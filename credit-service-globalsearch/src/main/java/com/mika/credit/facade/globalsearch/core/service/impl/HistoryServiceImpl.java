package com.mika.credit.facade.globalsearch.core.service.impl;


import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globalsearch.core.dao.HistoryMapper;
import com.mika.credit.facade.globalsearch.core.model.History;
import com.mika.credit.facade.globalsearch.core.service.HistoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("historyService")
public class HistoryServiceImpl implements HistoryService {

	private static Logger logger = Logger.getLogger(HistoryServiceImpl.class);
	@Autowired
	private HistoryMapper historyMapper;

	@Override
	public BootGrid<History> getHistories(History history) {
		logger.info("查询浏览历史方法开始...");
		BootGrid<History> result = new BootGrid<>();
		result.setTotal(historyMapper.selectCountSelective(history));
		result.setRows(historyMapper.selectSelective(history));
		result.setResult(true);
		return result;
	}

	@Override
	public ResponseResult<History> addCart(History history){
		logger.info("添加浏览历史方法开始...");
		ResponseResult<History> result = new ResponseResult<>();
		if(historyMapper.insertSelective(history)>0){
			result.setCode(true);
			result.setMsg("浏览历史添加成功");
		}
		else{
			result.setCode(false);
			result.setMsg("浏览历史添加失败");
		}
		return result;
	}

	@Override
	public ResponseResult<History> deleteCart(int id){
		logger.info("删除浏览历史方法开始...");
		ResponseResult<History> result = new ResponseResult<>();
		if(historyMapper.deleteByPrimaryKey(id)>0){
			result.setCode(true);
			result.setMsg("浏览历史删除成功");
		}
		else{
			result.setCode(false);
			result.setMsg("浏览历史删除失败");
		}
		return result;
	}
}
