package com.springboot.activeMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2018/10/17 13:34
 * @Modify by:
 */
@Service
public class JMSProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    //发送消息
    public void sendMessage(Destination destination, String message){
        jmsTemplate.convertAndSend(destination,message);
    }

}
