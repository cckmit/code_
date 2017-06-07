package com.mika.credit.facade.email.mq;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by dell on 2017/3/13.
 */
public class EmailMessageCreator implements org.springframework.jms.core.MessageCreator {

    private String data;

    public EmailMessageCreator(String data) {
        this.data = data;
    }

    public EmailMessageCreator() {
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
