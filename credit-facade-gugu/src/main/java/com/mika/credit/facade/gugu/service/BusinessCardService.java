package com.mika.credit.facade.gugu.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by dell on 2017/4/12.
 */
public interface BusinessCardService {
    /**
     * 添加名片
     * @param json
     * @return
     */
    String add(String json);
    /**
     * 批量添加
     * @param json
     * @return
     */
    String addList(String json);
    /**
     * 更新名片
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

    /**
     * 上传头像
     * @param json
     * @param file
     * @return
     */
    String updatePic(String json,String file);
}
