package com.springboot.activeMQ;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2018/10/22 11:37
 * @Modify by:
 */
public class TopicMyListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("消费者1收到的消息："+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
