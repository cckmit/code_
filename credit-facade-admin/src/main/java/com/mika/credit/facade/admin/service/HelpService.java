package com.mika.credit.facade.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.admin.model.Help;
import com.mika.credit.facade.admin.model.HelpCate;

/**
 * Help的接口
 * @author dhl007
 */
public interface HelpService {

    /**
     * 查找帮助类别
     * @return 查找结果分页显示
     */
    BootGrid<HelpCate> getHelpCates(HelpCate helpCate);

    /**
     * 通过id查找helpCate
     * @param id helpCate的id
     * @return 查找结果
     */
    HelpCate getHelpCateById(Integer id);

    /**
     * 删除帮助类别
     * @param id HelpCate的id
     * @return 删除结果
     */
    int removeHelpCate(Integer id);

    /**
     * 添加帮助类别
     * @param record HelpCate的信息
     * @return 添加结果
     */
    int addHelpCate(HelpCate record);

    /**
     * 合并帮助类别信息
     * @param record HelpCate的信息，有就修改，无就添加
     * @return 添加或修改结果
     */
    int mergeHelpCate(HelpCate record);

    /**
     * 查找帮助内容
     * @param record 帮助内容查找条件
     * @param grid 分页对象
     * @return 查找结果，分页显示
     */
    BootGrid<Help> getHelps(Help record, BootGrid<Help> grid);

    /**
     * 删除帮助内容
     * @param id help的id
     * @return 删除结果
     */
    int removeHelp(Integer id);

    /**
     * 添加help
     * @param record Help的信息
     * @return 添加结果
     */
    int addHelp(Help record);

    /**
     * 合并Help信息
     * @param record help信息，有就修改，无就添加
     * @return 添加或修改结果
     */
    int mergeHelp(Help record);

    /**
     * 通过帮助类别id查找对应help的总数
     * @param cateId 帮助类别的id
     * @return 查找结果
     */
    int selectCountByCate(Integer cateId);

    /**
     * 通过id查找help
     * @param id help的id
     * @return 查找结果
     */
    Help getHelpById(Integer id);
}
