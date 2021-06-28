package com.dark1103.rabbitmq.sender.producer;

import lombok.SneakyThrows;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

//@Component
public class JmsProducer implements Producer {

    private final JmsTemplate template;
    //    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange topic;

    public JmsProducer(JmsTemplate template, @Qualifier("my-topic") TopicExchange topic) {
        this.template = template;
        this.topic = topic;
    }


    @SneakyThrows
    public void SendMessage(String text) {
        Topic tpc = template.getConnectionFactory().createConnection().createSession(false, Session.AUTO_ACKNOWLEDGE).createTopic(topic.getName());
        template.convertAndSend(tpc, text);
    }

}
