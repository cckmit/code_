package com.mika.credit.facade.record.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.facade.record.model.SearchKeyword;
import com.mika.credit.facade.record.model.SearchKeywordQuery;


/**
 * Created by Mike on 2017/6/6.
 */
public interface SearchKeywordService {
    /**
     *  根据id判断是否新增/修改
     * @param searchKeyword
     * @return
     */
    ResponseResult<SearchKeyword> saveSearchKeyword(SearchKeyword searchKeyword);

    /**
     * 删除
     * @param searchKeyword
     * @return
     */
    ResponseResult<SearchKeyword> delSearchKeyword(SearchKeyword searchKeyword);

    /**
     * 按条件查询/分页
     * @param searchKeyword
     * @return
     */
    BootGrid<SearchKeywordQuery> selSecSearchKeyword(SearchKeywordQuery searchKeyword);

    /**
     * 根据Id查
     * @param searchKeywordId
     * @return
     */
    ResponseResult<SearchKeyword> selByIdSearchKeyword(Integer searchKeywordId);


}
