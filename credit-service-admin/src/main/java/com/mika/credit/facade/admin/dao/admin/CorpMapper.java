package com.mika.credit.facade.admin.dao.admin;


import com.mika.credit.facade.admin.model.Corp;

import java.util.List;

/**
 * Created by credit on 2017/3/16.
 */
public interface CorpMapper {
    List<Corp> queryList(Corp corp);
    Corp queryById(String corpId);
    List<Corp> queryAll();
    int save(Corp corp);
    int update(Corp corp);
    int updateByIdSelective(Corp corp);
    int deleteById(String corp);
    int delete(Corp corp);
    int selectCountByType(String id);    //根据CorpType的id查找对应所有数据的总数量
}
