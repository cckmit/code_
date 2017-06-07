package com.mika.credit.facade.globaleagle.core.service.impl;


import com.mika.credit.facade.globaleagle.core.dao.CustomerMapper;
import com.mika.credit.facade.globaleagle.core.dao.ManagerMapper;
import com.mika.credit.facade.globaleagle.core.dao.MessageMapper;
import com.mika.credit.facade.globaleagle.core.model.Message;
import com.mika.credit.facade.globaleagle.core.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/20.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    public MessageMapper messageMapper;
    @Autowired
    public CustomerMapper customerMapper;
    @Autowired
    public ManagerMapper managerMapper;

    @Override
    public List<Map<String, String>> mesCaution(Integer toId,String isRead) {

        return messageMapper.mesCaution(toId,isRead);
    }

    public Message insMessage(String textContent, String url, String fromId, String toId){

        Message message = new Message();
        //插入内容
        message.setUrl(url);
        message.setContent(textContent);
        message.setFromId(toId);
        message.setToId(fromId);
        message.setIsRead("否");
        message.setisDelete("否");
        Date sendTime = new Date();
        SimpleDateFormat sdfSend = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdfSend.format(sendTime);
        message.setSendTime(sendTime);
        Date recevieTime = new Date();
        SimpleDateFormat sdfRecive = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdfRecive.format(recevieTime);
        message.setReceiveTime(recevieTime);
        if(messageMapper.insMessage(message)>0){
           return message;
        }
        return null;
    }

    public List<Message> queryMessage(Map<String,String> map){
        return this.messageMapper.queryMessage(map);
    }

    public void updateByFromId(Map<String, String> map) {
        this.messageMapper.updateByFromId(map);
    }

    @Override
    public String selCusEmail(Integer cusId) {
        return this.customerMapper.selCusEmail(cusId);
    }

    @Override
    public String selManEmail(Integer manId) {
        return this.managerMapper.selManEmail(manId);
    }
}
