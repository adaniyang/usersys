package com.springboot.activeMQ;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author:adayang
 * @Describe:支持同时发送和接收queue/topic
 * @Date:2018/10/20 16:47
 * @Modify by:
 */
@Configuration
public class JmsConfig {
    public final static String TOPIC = "springBoot.Topic.test";
    public final static String QUEUE = "springBoot.Queue.test";

    @Bean
    public Topic topic(){
        return new ActiveMQTopic(TOPIC);
    }

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(QUEUE);
    }

    // topic模式的ListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmslistenerContainerTopic(ConnectionFactory activeMQConnectionFactory){
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setPubSubDomain(true);
        jmsListenerContainerFactory.setConnectionFactory(activeMQConnectionFactory);
        return jmsListenerContainerFactory;
    }

    // queue模式的ListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory){
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(activeMQConnectionFactory);
        return jmsListenerContainerFactory;
    }
}
