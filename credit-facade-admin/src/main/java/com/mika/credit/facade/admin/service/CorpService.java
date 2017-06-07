package com.mika.credit.facade.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.admin.model.Corp;
import com.mika.credit.facade.admin.model.CorpType;

/**
 * Created by dell on 2017/4/6.
 */
public interface CorpService {

    BootGrid<CorpType> getCorpTypes();      //查找所有机构类别
    ResponseResult<CorpType> removeCorpTypes(String id);   //删除机构类别
    ResponseResult<CorpType> addCorpType(CorpType corpType);   //添加机构类别
    ResponseResult<CorpType> updateCorpType(CorpType corpType);   //添加机构类别
    ResponseResult<CorpType> margeCorpType(CorpType corpType);   //合并机构类别（有就修改，无就添加）
    BootGrid<Corp> getCorps(BootGrid<Corp> grid, Corp corp);   //根据条件查找机构
    ResponseResult<Corp> removeCorp(String id);     //根据id删除机构
    ResponseResult<Corp> addCorp(Corp corp);      //添加机构
    ResponseResult<Corp> updateCorp(Corp corp);      //更新机构
    ResponseResult<Corp> margeCorp(Corp corp);    //合并机构（有就修改，无就添加）
    int selectCountByType(String id);    //通过机构类别id查找对应corp的总数量
    ResponseResult<Corp> getCorpById(String id);        //通过id查找Corp
}
