package com.mika.credit.facade.admin.service;

import com.mika.credit.common.entity.BootGrid;
import com.mika.credit.facade.admin.model.Continent;

/**
 * Continent接口
 * Created by mika on 2016/8/29.
 * @author dhl007
 */
public interface ContinentService {
    //获取所有区域信息

    /**
     * 查询所有洲信息
     * @return 分页显示
     */
    BootGrid<Continent> getContinents();

    /**
     * 删除洲信息
     * @param id Continent的id
     * @return 删除是否成功
     */
    int remove(Integer id);

    /**
     * 添加洲信息
     * @param record Continent的信息
     * @return 添加是否成功
     */
    int add(Continent record);

    /**
     * 修改洲信息
     * @param record Continent的信息
     * @return 修改是否成功
     */
    int modify(Continent record);

    /**
     * 合并洲信息
     * @param record Continent的信息，判断id是否存在，实现增加或修改操作
     * @return 添加或修改是否成功
     */
    int merge(Continent record);
}
