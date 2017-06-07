package com.mika.credit.facade.gugu.service;

/**
 * Created by dell on 2017/5/15.
 */
public interface FinancingService {
    /**
     * 添加融资服务
     * @param json
     * @return
     */
    String add(String json, String path);

    /**
     * 更新融资服务
     * @param json
     * @return
     */
    String updateByPrimaryKeySelective(String json, String path);

    /**
     * 根据id删除
     * @param json
     * @return
     */
    String deleteByPrimaryKey(String json);

    /**
     * 根据id查找
     * @param json
     * @return
     */
    String selectByPrimaryKey(String json);

    /**
     * 根据条件查找
     * @param json
     * @return
     */
    String selectSelective(String json);
}
