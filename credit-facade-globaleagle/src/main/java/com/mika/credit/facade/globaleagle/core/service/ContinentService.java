package com.mika.credit.facade.globaleagle.core.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.globaleagle.core.model.Continent;

/**
 * Created by mika on 2016/8/29.
 */
public interface ContinentService {
    //获取所有区域信息
    BootGrid<Continent> getContinents();
    int remove(Integer id);
    int add(Continent record);
    int modify(Continent record);
    int merge(Continent record);
}
