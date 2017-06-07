package com.mika.credit.facade.globaleagle.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.globaleagle.core.model.CollectionInfo;

import java.util.Map;

/**
 * Created by mika on 2016/7/27.
 */
public interface CollectionInfoManagerService {

    Map<String,Object> deleteByPrimaryKey(Integer id);

    int insertCol(CollectionInfo colInfo);

    BootGrid<CollectionInfo> loadColInfo(BootGrid<CollectionInfo> grid, CollectionInfo colInfo);

    String selContentById(Integer id);


}
