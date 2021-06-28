package com.dark1103.rabbitmq.sender;

import lombok.SneakyThrows;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Session;
import javax.jms.Topic;

@Component
public class JmsSender {

    private final JmsTemplate template;
    //    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange topic;
    private int counter = 0;

    public JmsSender(JmsTemplate template, @Qualifier("my-topic") TopicExchange topic) {
        this.template = template;
        this.topic = topic;
    }


    @SneakyThrows
    public void SendMessage(String message) {
//        template.convertAndSend("queue2", message + " (" + counter++ + ")");
        template.setPubSubDomain(true);
        Topic tpc = template.getConnectionFactory().createConnection().createSession(false, Session.AUTO_ACKNOWLEDGE).createTopic(topic.getName());
        template.convertAndSend(tpc, message + " (" + counter++ + ")");

//        template.convertAndSend(topic.getName(),message + " (" + counter++ + ")");

    }

}
