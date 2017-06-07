package com.mika.credit.facade.gugu.service;

/**
 * Created by dell on 2017/5/17.
 */
public interface MessageQuestionService {

        /**
         * 在线问答发送消息 message
         * 封装message实体内容
         *
         */
        String sendMessage(String json);


        /**
         * 通过fromId和toId查询消息框中的所有聊天内容，即message
         * fromId 发送方
         * toId   接收方
         */
        String findMessagesByUserId(String json);


        /**
         * 通过toId查询所有接收的message(消息内容和数量)
         * toId 消息接收方
         * ResponseResult<Message>
         */
        String findUnreadMessagesByToId(String json);


        /**
         * 通过fromId将未读消息修改为已读消息
         * fromId 发送方
         *
         */
        String updateMessageByFromId(String json);

}
