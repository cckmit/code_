package com.mika.credit.facade.gugu.service;


import com.mika.credit.facade.gugu.model.Inform;

/**
 * Created by Mike on 2017/4/13.
 */
public interface InformService {

    /**
     * 新增通知
     * @param inform
     * @return
     */
    Inform addInform(Inform inform);

    /**
     * 通知列表
     * @param data
     * @return
     */
    String getInformList(String data);

    /**
     * 通知标记为已阅
     * @param data
     * @return
     */
    String isInformRead(String data);

    /**
     * 删除通知
     * @param data
     * @return
     */
    String deleteInform(String data);

    /**
     * 获取通知信息
     * @param data
     * @return
     */
    String getInformInfo(String data);


}
