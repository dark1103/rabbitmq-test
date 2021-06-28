package com.dark1103.rabbitmq.receiver.receiver;

import com.dark1103.rabbitmq.receiver.RabbitMqReceiverApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiver {

    @KafkaListener(topics = "my-topic")
    void listener(String message) {
        System.out.println("r: " + RabbitMqReceiverApplication.Id + " :: " + message);
    }

}
