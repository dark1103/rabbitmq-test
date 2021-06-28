package com.dark1103.rabbitmq.sender.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaProducer implements Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic topic;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, @Qualifier("my-topic") NewTopic topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void SendMessage(String text) {
        kafkaTemplate.send(topic.name(), text);
    }
}
