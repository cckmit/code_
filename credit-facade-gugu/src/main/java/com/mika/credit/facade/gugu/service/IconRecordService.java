package com.mika.credit.facade.gugu.service;


import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Mike on 2017/4/13.
 */
public interface IconRecordService {


    /**
     * 用户已定制图标
     * @param data
     * @return
     */
    String getCustomIconList(String data);

    /**
     * 编辑用户定制图标
     * @param data
     * @return
     */
    String saveOrUpdateCustomerIcon(String data,String path);
}
