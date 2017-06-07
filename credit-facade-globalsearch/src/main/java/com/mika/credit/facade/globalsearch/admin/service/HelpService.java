package com.mika.credit.facade.globalsearch.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.globalsearch.admin.model.Help;
import com.mika.credit.facade.globalsearch.admin.model.HelpCate;


public interface HelpService {
    BootGrid<HelpCate> getHelpCates();
    int removeHelpCate(Integer id);
    int addHelpCate(HelpCate record);
    int mergeHelpCate(HelpCate record);

    BootGrid<Help> getHelps(Help record, BootGrid<Help> grid);
    int removeHelp(Integer id);
    int addHelp(Help record);
    int mergeHelp(Help record);

    int selectCountByCate(Integer cateId);

    Help getHelpById(Integer id);
}
