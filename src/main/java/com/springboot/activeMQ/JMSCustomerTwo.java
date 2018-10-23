package com.springboot.activeMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2018/10/17 14:38
 * @Modify by:
 */
@Component
public class JMSCustomerTwo {
    private final static Logger logger = LoggerFactory.getLogger(JMSCustomerTwo.class);

    @JmsListener(destination = "springBoot.queue.test")
    public void recieveQueue(String message){
        logger.info("消费者2接收的消息为{："+message+"}");
    }

    @JmsListener(destination = "springBoot.topic.test")
    public void recieveTopic(String message){
        logger.info("消费者2接收Topic的消息为{："+message+"}");
    }
}
