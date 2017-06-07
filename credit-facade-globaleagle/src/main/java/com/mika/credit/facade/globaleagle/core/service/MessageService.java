package com.mika.credit.facade.globaleagle.core.service;

import com.mika.credit.facade.globaleagle.core.model.Message;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/20.
 */
public interface MessageService {

    List<Map<String,String>> mesCaution(Integer toId, String isRead);

    //发送意见
    Message insMessage(String textContent, String url, String fromId, String toId);

    List<Message> queryMessage(Map<String, String> map);

    void updateByFromId(Map<String, String> map);

    String selCusEmail(Integer cusId);

    String selManEmail(Integer manId);

}
