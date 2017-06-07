package com.mika.credit.facade.front.en.mq;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by dell on 2017/3/13.
 */
public class EnMessageCreator implements MessageCreator {

    private String data;

    public EnMessageCreator(String data) {
        this.data = data;
    }

    public EnMessageCreator() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(data);
    }
}
