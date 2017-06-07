package com.mika.credit.facade.globaleagle.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.globaleagle.core.dao.CollectionInfoMapper;
import com.mika.credit.facade.globaleagle.core.model.CollectionInfo;
import com.mika.credit.facade.globaleagle.admin.service.CollectionInfoManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service("CollectionInfoManagerService")
public class CollectionInfoServiceImpl implements CollectionInfoManagerService {

	private static Logger logger = Logger.getLogger(CollectionInfoServiceImpl.class);
	@Autowired
	private CollectionInfoMapper collectionInfoMapper;

	public Map<String,Object> deleteByPrimaryKey(Integer id) {
		//获取返回值
		Map<String,Object> result = new HashMap<String, Object>();
		int coll=0;
		coll= collectionInfoMapper.deleteByPrimaryKey(id);
		result.put("stauts", 0);
		result.put("msg", "删除成功");
		return result;
	}

	public int insertCol(CollectionInfo colInfo) {
		if(collectionInfoMapper.insertCol(colInfo)>0){
			return 1;
		}
		return 0;
	}

	public BootGrid<CollectionInfo> loadColInfo(BootGrid<CollectionInfo> grid, CollectionInfo colInfo) {
		PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
		grid.setRows(collectionInfoMapper.selectSelective(colInfo));
		grid.setTotal(collectionInfoMapper.selectCountSelective(colInfo));
		grid.setResult(true);
		return grid;
	}

	public String selContentById(Integer id) {
		String content = collectionInfoMapper.selContentById(id);
		return content;
	}


}
