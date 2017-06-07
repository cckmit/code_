package com.mika.credit.facade.globalsearch.core.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.globalsearch.core.model.Collection;
import com.mika.credit.facade.globalsearch.core.model.History;


/**
 * Created by mika on 2016/7/28.
 */
public interface CollectionService {
    //添加收藏信息
    ResponseResult<Collection> add(Collection collection);
    //修改收藏信息
    ResponseResult<Collection> modify(Collection collection);
    //根据customerId和公司名查询收藏信息
    ResponseResult<Collection> getCollectionByCidAndCname(Collection collection);
    //根据客户ID和收藏公司删除收藏信息
    ResponseResult<Collection> del(Collection collection);
    //根据ID删除收藏信息
    ResponseResult<Collection> delById(int id);
    //分页查询
    BootGrid<Collection> getCollection(BootGrid <Collection> grid, Collection collection);
}
