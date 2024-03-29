package com.mika.credit.facade.admin.service.impl;


import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.admin.dao.ge.GEContinentMapper;
import com.mika.credit.facade.admin.model.Continent;
import com.mika.credit.facade.admin.service.ContinentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("continentService")
public class ContinentServiceImpl implements ContinentService{

	private static Logger logger = Logger.getLogger(ContinentServiceImpl.class);
	@Autowired
	private GEContinentMapper continentMapper;

	/**
	 * 查询所有洲信息
	 * @return
	 */
	@Override
	public BootGrid<Continent> getContinents() {
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
		return continentMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 添加洲信息
	 * @param record
	 * @return
	 */
	@Override
	public int add(Continent record) {
		return continentMapper.insert(record);
	}

	/**
	 * 修改洲信息
	 * @param record
	 * @return
	 */
	@Override
	public int modify(Continent record) {
		return continentMapper.updateByPrimaryKey(record);
	}

	/**
	 * 合并洲信息
	 * @param record
	 * @return
	 */
	@Override
	public int merge(Continent record) {
		Integer id = record.getId();
		if(id == null || id.intValue() == 0){
			return add(record);
		}else {
			return modify(record);
		}
	}
}
