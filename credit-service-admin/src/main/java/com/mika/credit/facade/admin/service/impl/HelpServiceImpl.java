package com.mika.credit.facade.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.admin.dao.admin.HelpCateMapper;
import com.mika.credit.facade.admin.dao.admin.HelpMapper;
import com.mika.credit.facade.admin.model.Help;
import com.mika.credit.facade.admin.model.HelpCate;
import com.mika.credit.facade.admin.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("helpService")
public class HelpServiceImpl implements HelpService {
    @Autowired
    private HelpMapper helpMapper;
    @Autowired
    private HelpCateMapper helpCateMapper;

    @Override
    public BootGrid<HelpCate> getHelpCates(HelpCate helpCate) {
        BootGrid<HelpCate> result = new BootGrid<>();
        result.setRows(helpCateMapper.selectSelective(helpCate));
        result.setTotal(helpCateMapper.selectSelective(helpCate).size());
        result.setResult(true);
        return result;
    }

    @Override
    public HelpCate getHelpCateById(Integer id) {
        return helpCateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int removeHelpCate(Integer id) {
        return helpCateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addHelpCate(HelpCate record) {
        return helpCateMapper.insertSelective(record);
    }

    @Override
    public int mergeHelpCate(HelpCate record) {
        if(record != null){
            if(record.getId() != null && record.getId() != 0){
                return helpCateMapper.updateByPrimaryKeySelective(record);
            }else{
                return helpCateMapper.insertSelective(record);
            }
        }
        return 0;
    }

    @Override
    public BootGrid<Help> getHelps(Help record, BootGrid<Help> grid) {
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(helpMapper.selectSelective(record));
        grid.setTotal(helpMapper.selectSelective(record).size());
        grid.setResult(true);
        return grid;
    }

    @Override
    public int removeHelp(Integer id) {
        return helpMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addHelp(Help record) {
        return helpMapper.insertSelective(record);
    }

    @Override
    public int mergeHelp(Help record) {
        if(record != null){
            if(record.getId() != null && record.getId() != 0){
                return helpMapper.updateByPrimaryKeySelective(record);
            }else{
                return helpMapper.insertSelective(record);
            }
        }
        return 0;
    }

    @Override
    public int selectCountByCate(Integer cateId) {
        return helpMapper.selectCountByCate(cateId);
    }

    @Override
    public Help getHelpById(Integer id) {
        return helpMapper.selectByPrimaryKey(id);
    }
}
