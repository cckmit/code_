package com.mika.credit.facade.globaleagle.core.dao;

import com.mika.credit.facade.globaleagle.core.model.CollectionInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insertCol(CollectionInfo colInfo);

    List<CollectionInfo> loadColInfo(Integer customerId, Integer orderDetailId);

    String selContentById(Integer id);

    List<CollectionInfo> selectSelective(CollectionInfo colInfo);

    int selectCountSelective(CollectionInfo colInfo);




}