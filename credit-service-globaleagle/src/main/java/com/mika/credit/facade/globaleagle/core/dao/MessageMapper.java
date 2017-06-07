package com.mika.credit.facade.globaleagle.core.dao;

import com.mika.credit.facade.globaleagle.core.model.Message;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/19.
 */
public interface MessageMapper {

    List<Map<String,String>> mesCaution(Integer toId, String isRead);

    //新增意见
    Integer insMessage(Message message);

    List<Message> queryMessage(Map<String, String> map);

    int updateByFromId(Map<String, String> map);

}
