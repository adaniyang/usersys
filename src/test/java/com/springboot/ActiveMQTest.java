package com.springboot;

import com.springboot.activeMQ.JMSProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2018/10/17 14:50
 * @Modify by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.springboot.activeMQ"})
public class ActiveMQTest {
    @Autowired
    private JMSProducer producer;

    @Autowired
    private Topic topic;//用于testRecivedTopicQueue方法

    @Autowired
    private Queue queue;//用于testRecivedTopicQueue方法

    @Test
    public void test1() {
        System.out.println("888888888");
    }

    @Test
    public void testRecievedQueue(){    //默认activeMQ是支持queue的模式，不用再yml文件中添加其他配置
        Destination destination = new ActiveMQQueue("springBoot.queue.test");
        for(int i = 0; i < 100; i++){
            producer.sendMessage(destination,"queue : Hello World "+i);
        }
    }

    @Test
    public void testRecievedTopic(){    //topic要配合yml文件中的jms.pub-sub-domain=true，才能单元测试成功
        Destination destination = new ActiveMQTopic("springBoot.topic.test");
        for(int i = 0; i < 50; i++){
            producer.sendMessage(destination,"topic : Hello World "+i);
        }
    }

    //JmsConfig、JmsCustomerTopicQueue、JMSProducer、ActiveMQTest.testRecivedTopicQueue方法组合即为同时支持queue和topic的
    @Test
    public void testRecivedTopicQueue(){
        for(int i = 0; i < 30; i++){
            producer.sendMessage(topic,"Topic message "+ i);
            producer.sendMessage(queue,"Queue meassage "+i);
        }
    }

}
