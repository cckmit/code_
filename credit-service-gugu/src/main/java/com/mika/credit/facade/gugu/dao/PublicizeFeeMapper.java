package com.mika.credit.facade.gugu.dao;

import com.mika.credit.facade.gugu.model.PublicizeFee;

import java.util.List;

public interface PublicizeFeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PublicizeFee record);

    int insertSelective(PublicizeFee record);

    PublicizeFee selectByPrimaryKey(Integer id);

    List<PublicizeFee> selectByPrimaryKeySelective(PublicizeFee publicizeFee);

    int updateByPrimaryKeySelective(PublicizeFee record);

    int updateByPrimaryKey(PublicizeFee record);
}