package com.mika.credit.facade.record.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.record.dao.SearchKeywordMapper;
import com.mika.credit.facade.record.model.SearchKeyword;
import com.mika.credit.facade.record.model.SearchKeywordQuery;
import com.mika.credit.facade.record.service.SearchKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mike on 2017/6/6.
 */
@Service("searchKeywordService")
public class SearchKeywordServiceImpl implements SearchKeywordService {
    @Autowired
    private SearchKeywordMapper searchKeywordMapper;

    @Override
    public ResponseResult<SearchKeyword> saveSearchKeyword(SearchKeyword searchKeyword) {
        ResponseResult<SearchKeyword> searchKeywordResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(searchKeyword)) {
            if (searchKeyword.getId() == null || searchKeyword.getId() == 0) {
                searchKeyword.setId(null);
                searchKeywordMapper.insertSelective(searchKeyword);
                searchKeywordResponseResult.setCode(true);
                searchKeywordResponseResult.setContent(searchKeyword);
                searchKeywordResponseResult.setMsg("新增记录成功！");

            } else {
                searchKeywordMapper.updateByPrimaryKeySelective(searchKeyword);
                searchKeywordResponseResult.setCode(true);
                searchKeywordResponseResult.setContent(searchKeyword);
                searchKeywordResponseResult.setMsg("更新记录成功！");

            }
        } else {
            searchKeywordResponseResult.setCode(false);
            searchKeywordResponseResult.setMsg("记录不能为空或者公司名不能为空！");
        }
        return searchKeywordResponseResult;
    }

    @Override
    public ResponseResult<SearchKeyword> delSearchKeyword(SearchKeyword searchKeyword) {
        ResponseResult<SearchKeyword> searchKeywordResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(searchKeyword)&&StringUtil.isNotNull(searchKeyword.getId())){
            searchKeywordMapper.deleteByPrimaryKey(searchKeyword.getId());
            searchKeywordResponseResult.setCode(true);
            searchKeywordResponseResult.setMsg("删除成功！");
        }else {
            searchKeywordResponseResult.setCode(false);
            searchKeywordResponseResult.setMsg("删除失败，记录或记录Id不能为空！");
        }
        return searchKeywordResponseResult;
    }

    @Override
    public BootGrid<SearchKeywordQuery> selSecSearchKeyword(SearchKeywordQuery searchKeywordQuery) {
        BootGrid<SearchKeywordQuery> result = new BootGrid<>();
        Page<SearchKeywordQuery> page = PageHelper.startPage(result.getCurrent(), result.getRowCount());
        result.setTotal(searchKeywordMapper.selectCountSelective(searchKeywordQuery));
        result.setRows(searchKeywordMapper.selectByPrimaryKeySelectiveQuery(searchKeywordQuery));
        result.setResult(true);
        return result;
    }

    @Override
    public ResponseResult<SearchKeyword> selByIdSearchKeyword(Integer searchKeywordId) {
        ResponseResult<SearchKeyword> searchKeywordResponseResult = new ResponseResult<>();
        SearchKeyword searchKeyword = searchKeywordMapper.selectByPrimaryKey(searchKeywordId);
        if (StringUtil.isNotNull(searchKeyword)){
            searchKeywordResponseResult.setCode(true);
            searchKeywordResponseResult.setContent(searchKeyword);
        }else {
            searchKeywordResponseResult.setCode(false);
            searchKeywordResponseResult.setMsg("未查询到该数据！");
        }
        return searchKeywordResponseResult;
    }
}
