package com.mika.credit.facade.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.common.util.UtilGenerateID;
import com.mika.credit.facade.admin.dao.admin.CorpMapper;
import com.mika.credit.facade.admin.dao.admin.CorpTypeMapper;
import com.mika.credit.facade.admin.model.Corp;
import com.mika.credit.facade.admin.model.CorpType;
import com.mika.credit.facade.admin.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2017/4/6.
 *
 * @author dhl007
 */
@Service("corpService")
public class CorpServiceImpl implements CorpService {

    @Autowired
    private CorpMapper corpMapper;

    @Autowired
    private CorpTypeMapper corpTypeMapper;

    public BootGrid<CorpType> getCorpTypes() {
        BootGrid<CorpType> result = new BootGrid<CorpType>();
        result.setRows(corpTypeMapper.queryAll());
        result.setTotal(corpTypeMapper.queryAll().size());
        result.setResult(true);
        return result;
    }

    public ResponseResult<CorpType> removeCorpTypes(String id) {
        ResponseResult<CorpType> result = new ResponseResult<CorpType>();
        if (corpTypeMapper.deleteById(id) > 0) {
            result.setCode(true);
            result.setMsg("机构类别删除成功！");
        } else {
            result.setCode(false);
            result.setMsg("机构类别删除失败！");
        }
        return result;
    }

    @Override
    public ResponseResult<CorpType> updateCorpType(CorpType corpType) {
        ResponseResult<CorpType> result = new ResponseResult<CorpType>();
        if (StringUtil.isNotNull(corpType)) {
                if (corpTypeMapper.updateByIdSelective(corpType) > 0) {
                    result.setCode(true);
                    result.setMsg("机构类别更新成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("机构类别更新失败！");
                }
        } else {
            result.setCode(false);
            result.setMsg("机构类别不能为空！");
        }
        return result;
    }

    public ResponseResult<CorpType> addCorpType(CorpType corpType) {
        ResponseResult<CorpType> result = new ResponseResult<CorpType>();
        if (StringUtil.isNotNull(corpType)) {
            if (corpTypeMapper.queryList(corpType).size() > 0) {
                result.setCode(false);
                result.setMsg("该机构类别已存在，添加失败！");
            } else {
                corpType.setId(UtilGenerateID.generateID("COT"));
                if (corpTypeMapper.save(corpType) > 0) {
                    result.setCode(true);
                    result.setMsg("机构类别添加成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("机构类别添加失败！");
                }
            }
        } else {
            result.setCode(false);
            result.setMsg("机构类别不能为空！");
        }
        return result;
    }

    public ResponseResult<CorpType> margeCorpType(CorpType corpType) {
        ResponseResult<CorpType> result = new ResponseResult<CorpType>();
        if (corpType != null) {
            if (corpType.getId() != null && !"".equals(corpType.getId())) {
                result=updateCorpType(corpType);
            } else {
                result=addCorpType(corpType);
            }
        }
        return result;
    }

    public BootGrid<Corp> getCorps(BootGrid<Corp> grid, Corp corp) {
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(corpMapper.queryList(corp));
        grid.setTotal(corpMapper.queryList(corp).size());
        grid.setResult(true);
        return grid;
    }

    public ResponseResult<Corp> removeCorp(String id) {
        ResponseResult<Corp> result = new ResponseResult<Corp>();
        if (corpMapper.deleteById(id) > 0) {
            result.setCode(true);
            result.setMsg("机构删除成功！");
        } else {
            result.setCode(false);
            result.setMsg("机构删除失败！");
        }
        return result;
    }

    @Override
    public ResponseResult<Corp> updateCorp(Corp corp) {
        ResponseResult<Corp> result = new ResponseResult<Corp>();
        if (StringUtil.isNotNull(corp)) {
                if (corpMapper.updateByIdSelective(corp) > 0) {
                    result.setCode(true);
                    result.setMsg("机构更新成功！");
                } else {
                    result.setCode(false);
                    result.setMsg("机构更新失败！");
                }
        } else {
            result.setCode(false);
            result.setMsg("机构不能为空！");
        }
        return result;
    }

    public ResponseResult<Corp> addCorp(Corp corp) {
        ResponseResult<Corp> result = new ResponseResult<Corp>();
        if (StringUtil.isNotNull(corp)) {
            if (corpMapper.queryList(corp).size() > 0) {
                result.setCode(false);
                result.setMsg("该机构已存在，添加失败！");
            } else {
                corp.setId(UtilGenerateID.generateID("COR"));
        if (corpMapper.save(corp) > 0) {
            result.setCode(true);
            result.setMsg("机构添加成功！");
        } else {
            result.setCode(false);
            result.setMsg("机构添加失败！");
        }
            }
        } else {
            result.setCode(false);
            result.setMsg("机构不能为空！");
        }
        return result;
    }

    public ResponseResult<Corp> margeCorp(Corp corp) {
        ResponseResult<Corp> result = new ResponseResult<Corp>();
        if (corp != null) {
            if (corp.getId() != null && !"".equals(corp.getId())) {
                result=updateCorp(corp);
            } else {
                result=addCorp(corp);
            }
        }
        return result;
    }

    public int selectCountByType(String id) {
        return corpMapper.selectCountByType(id);
    }

    public ResponseResult<Corp> getCorpById(String id) {
        ResponseResult<Corp> result = new ResponseResult<Corp>();
        Corp corp = corpMapper.queryById(id);
        if (corp != null) {
            result.setCode(true);
            result.setContent(corp);
            result.setMsg("查找成功！");
        } else {
            result.setCode(false);
            result.setMsg("查找失败！");
        }
        return result;
    }
}
