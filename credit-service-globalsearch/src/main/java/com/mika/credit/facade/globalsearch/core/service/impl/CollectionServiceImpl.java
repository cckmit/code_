package com.mika.credit.facade.globalsearch.core.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globalsearch.core.dao.CollectionMapper;
import com.mika.credit.facade.globalsearch.core.model.Collection;
import com.mika.credit.facade.globalsearch.core.service.CollectionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("collectionService")
public class CollectionServiceImpl implements CollectionService {
	private static final Logger logger = Logger.getLogger(CollectionServiceImpl.class);
	@Resource
	private CollectionMapper collectionMapper;

	/**
	 * 添加收藏信息
	 * @param collection
	 * @return
	 */
	@Override
	public ResponseResult<Collection> add(Collection collection) {
		logger.info("添加收藏方法开始...");
		ResponseResult<Collection> result = new ResponseResult<>();
			int add=collectionMapper.insertSelective(collection);
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

	/**
	 * 修改收藏信息
	 * @param collection
	 * @return
	 */
	@Override
	public ResponseResult<Collection> modify(Collection collection) {
		logger.info("修改收藏方法开始...");
		ResponseResult<Collection> result = new ResponseResult<>();
		int update=collectionMapper.updateByPrimaryKeySelective(collection);
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

	/**
	 * 根据customerId查询该公司是否被该用户收藏
	 * @return
	 */
	@Override
	public ResponseResult<Collection> getCollectionByCidAndCname(Collection collection) {
		logger.info("根据customerId查询该公司是否被收藏方法开始...");
		ResponseResult<Collection> result = new ResponseResult<>();
		Collection collection1 = collectionMapper.getCollectionByCustomerId(collection);
		if (collection1 != null) {
			result.setCode(true);
			result.setMsg("The query is successful");
			result.setContent(collection);
			return result;
		} else {
			result.setCode(false);
			result.setMsg("query fails");
			return result;

		}
	}

	/**
	 * 根据客户ID和收藏公司删除收藏信息
	 * @return
	 */
	@Override
	public ResponseResult<Collection> del(Collection collection) {
		logger.info("根据客户ID和收藏公司删除收藏方法开始...");
		ResponseResult<Collection> result = new ResponseResult<>();
		if(collectionMapper.delByCidAndCname(collection)>0){
			result.setCode(true);
			result.setMsg("Delete success");
		} else{
			result.setCode(false);
			result.setMsg("Delete failed");
		}
		return result;
	}

	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	@Override
	public ResponseResult<Collection> delById(int id) {
		logger.info("根据ID删除收藏方法开始...");
		ResponseResult<Collection> result = new ResponseResult<>();
		if(collectionMapper.deleteByPrimaryKey(id)>0){
			result.setCode(true);
			result.setMsg("Delete success");
		} else{
			result.setCode(false);
			result.setMsg("Delete failed");
		}
		return result;
	}

	/**
	 * 分页查询
	 * @param grid
	 * @param collection
	 * @return
	 */
	@Override
	public BootGrid<Collection> getCollection(BootGrid<Collection> grid, Collection collection) {
		logger.info("分页查询收藏方法开始...");
		Page<Collection> page = PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
		grid.setRows(collectionMapper.selectSelective(collection));
		grid.setTotal(collectionMapper.selectCountSelective(collection));
		grid.setResult(true);
		return grid;
	}

}
