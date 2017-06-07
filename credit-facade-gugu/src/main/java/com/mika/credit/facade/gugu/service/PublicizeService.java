package com.mika.credit.facade.gugu.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by dell on 2017/4/23.
 */
public interface PublicizeService {
    /**
     * 添加企业推广信息
     * @param json
     * @return
     */
    String addPublicize(String json,String path);

    /**
     * 更新企业推广信息
     * @param json
     * @return
     */
    String updateSelectivePublicize(String json,String path);

    /**
     * 根据id删除企业推广信息
     * @param json
     * @return
     */
    String deleteByPrimaryKeyPublicize(String json);

    /**
     * 根据id查找企业推广信息
     * @param json
     * @return
     */
    String selectByPrimaryKeyPublicize(String json);

    /**
     * 根据条件查找企业推广信息
     * @param json
     * @return
     */
    String selectSelectivePublicize(String json);
    /**
     * 添加企业推广标签
     * @param json
     * @return
     */
    String addPublicizeFlag(String json);

    /**
     * 更新企业推广标签
     * @param json
     * @return
     */
    String updateSelectivePublicizeFlag(String json);

    /**
     * 根据id删除企业推广标签
     * @param json
     * @return
     */
    String deleteByPrimaryKeyPublicizeFlag(String json);

    /**
     * 根据id查找企业推广标签
     * @param json
     * @return
     */
    String selectByPrimaryKeyPublicizeFlag(String json);

    /**
     * 根据条件查找企业推广标签
     * @param json
     * @return
     */
    String selectSelectivePublicizeFlag(String json);
    /**
     * 上传或更新推广图片
     * @param json
     * @param path
     * @return
     */
    String updatePic(String json,String path);


    /**
     * 根据id删除推广图片
     * @param json
     * @return
     */
    String deleteByPrimaryKeyPublicizePhoto(String json);

    /**
     * 根据id查找推广图片
     * @param json
     * @return
     */
    String selectByPrimaryKeyPublicizePhoto(String json);

    /**
     * 根据条件查找推广图片
     * @param json
     * @return
     */
    String selectSelectivePublicizePhoto(String json);
}
