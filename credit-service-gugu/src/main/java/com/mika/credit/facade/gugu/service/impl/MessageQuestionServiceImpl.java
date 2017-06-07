package com.mika.credit.facade.gugu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mika.credit.common.entity.ResponseResult;
import com.mika.credit.common.util.StringUtil;
import com.mika.credit.common.util.UtilDateTime;
import com.mika.credit.facade.gugu.dao.UserTokenMapper;
import com.mika.credit.facade.gugu.dao.UsersMapper;
import com.mika.credit.facade.gugu.model.UserToken;
import com.mika.credit.facade.gugu.model.Users;
import com.mika.credit.facade.gugu.service.MessageQuestionService;
import com.mika.credit.facade.gugu.util.push.PushAPI;
import com.mika.credit.facade.messagebox.model.Message;
import com.mika.credit.facade.messagebox.service.MessageboxService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/5/17.
 */
@Service("messageQuestionService")
public class MessageQuestionServiceImpl implements MessageQuestionService {
    private static Logger logger = Logger.getLogger(MessageQuestionServiceImpl.class);

    @Autowired
    private MessageboxService messageboxService;

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public String sendMessage(String json){
        logger.debug("进入在线问答发送消息方法！");
        ResponseResult<String> result=new ResponseResult<>();
        Message message= JSON.parseObject(json,Message.class);
        if(StringUtil.isNotNull(message)){
            message.setInvokeObj("估估");
            result=messageboxService.sendMessage(message);
            if(result.getCode()) {

                //手机推送
                Map pushMap = new HashMap<>();
                pushMap.put("接收方：", result.getContent());

                Users users=usersMapper.selectByPrimaryKey(Integer.parseInt(message.getToId()));
                logger.info("推送消息接收方："+users);

                if (StringUtil.isNotNull(users)){
                    //判断是否在有效时间内
                    logger.info("进入推送消息方法！");
                    PushAPI push = new PushAPI();
                    //安卓信息推送
                    try{
                        push.sendAndroidUnicast(users.getPhoneToken()+"", "ticker", "估估网", "认证完成", pushMap);
                        //ios信息推送
                        push.sendIOSUnicast(users.getPhoneToken()+"", "ticker", "估估网", "认证完成", pushMap);
                    }catch (Exception e){
                        logger.error(e);
                        System.out.printf("message:"+e.getStackTrace());
                    }
                }
            }
        }else{
            result.setCode(false);
            result.setMsg("传入参数为空");
        }
        logger.info("在线问答发送消息方法的返回结果："+JSON.toJSONString(result));
        return JSONObject.toJSONString(result);
    }

    @Override
    public String findMessagesByUserId(String json) {
        logger.debug("进入查找对话框内消息方法！");
        ResponseResult<Message> result=new ResponseResult<>();
        JSONObject jsonObject=JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject)){
            String fromId=jsonObject.getString("fromId");
            String toId=jsonObject.getString("toId");
            result=messageboxService.findMessagesByUserId(fromId,toId);
        }else{
            result.setCode(false);
            result.setMsg("传入参数为空");
        }
        logger.info("查询对话框内消息方法的返回结果："+JSON.toJSONString(result));
        return JSONObject.toJSONString(result);
    }

    @Override
    public String findUnreadMessagesByToId(String json) {
        logger.debug("进入根据接收方查找未读消息方法！");
        ResponseResult<Message> result=new ResponseResult<>();
        JSONObject jsonObject=JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject)){
            String toId=jsonObject.getString("toId");
            result=messageboxService.findUnreadMessagesByToId(toId);
        }else{
            result.setCode(false);
            result.setMsg("传入参数为空");
        }
        logger.info("根据接收方查找未读消息方法的返回结果："+JSON.toJSONString(result));
        return JSONObject.toJSONString(result);
    }

    @Override
    public String updateMessageByFromId(String json) {
        logger.debug("进入通过fromId将未读消息修改为已读消息方法！");
        ResponseResult<String> result=new ResponseResult<>();
        JSONObject jsonObject=JSON.parseObject(json);
        if(StringUtil.isNotNull(jsonObject)){
            String fromId=jsonObject.getString("fromId");
            result=messageboxService.updateMessageByFromId(fromId);
        }else{
            result.setCode(false);
            result.setMsg("传入参数为空");
        }
        logger.info("通过fromId将未读消息修改为已读消息方法的返回结果："+JSON.toJSONString(result));
        return JSONObject.toJSONString(result);
    }

}
