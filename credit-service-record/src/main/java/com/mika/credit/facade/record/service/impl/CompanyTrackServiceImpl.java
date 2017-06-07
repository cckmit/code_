package com.mika.credit.facade.record.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.facade.record.dao.CompanyTrackMapper;
import com.mika.credit.facade.record.model.CompanyTrack;
import com.mika.credit.facade.record.model.CompanyTrackQuery;
import com.mika.credit.facade.record.service.CompanyTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mike on 2017/5/25.
 */
@Service("companyTrackService")
public class CompanyTrackServiceImpl implements CompanyTrackService {
    @Autowired
    private CompanyTrackMapper companyTrackMapper;

    @Override
    public ResponseResult<CompanyTrack> saveCompanyTrack(CompanyTrack companyTrack) {
        ResponseResult<CompanyTrack> companyTrackResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(companyTrack)) {
            if (companyTrack.getId() == null || companyTrack.getId() == 0) {
                companyTrack.setId(null);
                companyTrackMapper.insertSelective(companyTrack);
                companyTrackResponseResult.setCode(true);
                companyTrackResponseResult.setContent(companyTrack);
                companyTrackResponseResult.setMsg("新增记录成功！");

            } else {
                companyTrackMapper.updateByPrimaryKeySelective(companyTrack);
                companyTrackResponseResult.setCode(true);
                companyTrackResponseResult.setContent(companyTrack);
                companyTrackResponseResult.setMsg("更新记录成功！");

            }
        } else {
            companyTrackResponseResult.setCode(false);
            companyTrackResponseResult.setMsg("记录不能为空或者公司名不能为空！");
        }
        return companyTrackResponseResult;
    }

    @Override
    public ResponseResult<CompanyTrack> delCompanyTrack(CompanyTrack companyTrack) {
        ResponseResult<CompanyTrack> companyTrackResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(companyTrack)&&StringUtil.isNotNull(companyTrack.getId())){
            companyTrackMapper.deleteByPrimaryKey(companyTrack.getId());
            companyTrackResponseResult.setCode(true);
            companyTrackResponseResult.setMsg("删除成功！");
        }else {
            companyTrackResponseResult.setCode(false);
            companyTrackResponseResult.setMsg("删除失败，记录或记录Id不能为空！");
        }
        return companyTrackResponseResult;
    }

    @Override
    public BootGrid<CompanyTrackQuery> selSecCompanyTrack(CompanyTrackQuery companyTrackQuery) {
        BootGrid<CompanyTrackQuery> result = new BootGrid<>();
        Page<CompanyTrackQuery> page = PageHelper.startPage(result.getCurrent(), result.getRowCount());
        result.setTotal(companyTrackMapper.selectCountSelective(companyTrackQuery));
        result.setRows(companyTrackMapper.selectByPrimaryKeySelectiveQuery(companyTrackQuery));
        result.setResult(true);
        return result;
    }

    @Override
    public ResponseResult<CompanyTrack> selByIdCompanyTrack(Integer companyTrackId) {
        ResponseResult<CompanyTrack> companyTrackResponseResult = new ResponseResult<>();
        CompanyTrack companyTrack = companyTrackMapper.selectByPrimaryKey(companyTrackId);
        if (StringUtil.isNotNull(companyTrack)){
            companyTrackResponseResult.setCode(true);
            companyTrackResponseResult.setContent(companyTrack);
        }else {
            companyTrackResponseResult.setCode(false);
            companyTrackResponseResult.setMsg("未查询到该数据！");
        }
        return companyTrackResponseResult;
    }
}
