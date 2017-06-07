package com.mika.credit.facade.gugu.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by dell on 2017/4/17.
 */
public interface ScanningCardService {
    /**
     * 添加扫描名片
     * @param json
     * @return
     */
    String add(String json);
    /**
     * 更新扫描名片
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
     * 上传扫描名片头像
     * @param json
     * @param path
     * @return
     */
    String updatePic(String json,String path);
}
