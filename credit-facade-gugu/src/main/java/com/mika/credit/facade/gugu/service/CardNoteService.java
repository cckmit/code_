package com.mika.credit.facade.gugu.service;

/**
 * Created by dell on 2017/4/13.
 */
public interface CardNoteService {
    /**
     * 添加名片备注
     * @param json
     * @return
     */
    String add(String json);

    /**
     * 更新名片备注
     * @param json
     * @return
     */
    String updateByPrimaryKeySelective(String json);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    String deleteByPrimaryKey(String id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    String selectByPrimaryKey(String id);

    /**
     * 根据条件查找
     * @param json
     * @return
     */
    String selectByPrimaryKeySelective(String json);
}
