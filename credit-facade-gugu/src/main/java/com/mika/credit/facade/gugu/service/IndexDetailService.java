package com.mika.credit.facade.gugu.service;

/**
 * Created by dell on 2017/4/18.
 */
public interface IndexDetailService {

    /**
     * 搜索列表
     * @param json
     * @return
     */
    String fillCompanyIndex(String json);


    /**
     * 获取搜索目标工商信息
     */
    String targetRegistration(String data);

    /**
     * 获取搜索目标工商信息
     * @param data
     * @return
     */
    String searchRegistration(String data);

    /**
     * 获取搜索目标的基本信息
     * @param data
     * @return
     */
    String basicInfoDetail(String data);


}
