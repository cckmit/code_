package com.mika.credit.facade.globaleagle.admin.service.impl;


import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.globaleagle.core.dao.ContinentMapper;
import com.mika.credit.facade.globaleagle.core.model.Continent;
import com.mika.credit.facade.globaleagle.admin.service.ContinentManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("continentManagerService")
public class ContinentServiceImpl implements ContinentManagerService {

	private static Logger logger = Logger.getLogger(ContinentServiceImpl.class);
	@Autowired
	private ContinentMapper continentMapper;

	/**
	 * 查询所有洲信息
	 * @return
	 */
	@Override
	public BootGrid<Continent> getContinents() {
		logger.info("查询所有洲信息方法开始...");
		BootGrid<Continent> result = new BootGrid<>();
		result.setRows(continentMapper.selectAll());
		return result;
	}

	/**
	 * 删除洲信息
	 * @param id
	 * @return
	 */
	@Override
	public int remove(Integer id) {
		logger.info("删除洲信息方法开始...");
		return continentMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 添加洲信息
	 * @param record
	 * @return
	 */
	@Override
	public int add(Continent record) {
		logger.info("添加洲信息方法开始...");
		return continentMapper.insert(record);
	}

	/**
	 * 修改洲信息
	 * @param record
	 * @return
	 */
	@Override
	public int modify(Continent record) {
		logger.info("修改洲信息方法开始...");
		return continentMapper.updateByPrimaryKey(record);
	}

	/**
	 * 合并洲信息
	 * @param record
	 * @return
	 */
	@Override
	public int merge(Continent record) {
		logger.info("合并洲信息方法开始...");
		Integer id = record.getId();
		if(id == null || id.intValue() == 0){
			return add(record);
		}else {
			return modify(record);
		}
	}
}
