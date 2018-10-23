package com.springboot.activeMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2018/10/20 17:10
 * @Modify by:
 */
@Component
public class JmsCustomerTopicQueue {
    private final static Logger logger = LoggerFactory.getLogger(JmsCustomerTopicQueue.class);

    @JmsListener(destination = JmsConfig.TOPIC,containerFactory = "jmslistenerContainerTopic")
    public void recivedTopicMessage(String msg){
        logger.info("接收到的Topic的消息是："+msg);
    }

    @JmsListener(destination = JmsConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
    public void recivedQueueMessage(String msg){
        logger.info("接收到的Queue的消息是："+msg);
    }
}
