package com.mika.credit.facade.order.mq;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by dell on 2017/3/13.
 */
public class OrderMessageCreator implements MessageCreator {

    private String data;

    public OrderMessageCreator(String data) {
        this.data = data;
    }

    public OrderMessageCreator() {
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
