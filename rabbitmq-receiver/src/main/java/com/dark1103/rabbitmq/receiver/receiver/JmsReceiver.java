package com.dark1103.rabbitmq.receiver.receiver;

import com.dark1103.rabbitmq.receiver.RabbitMqReceiverApplication;
import com.rabbitmq.jms.admin.RMQDestination;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageListener;

@Configuration
public class JmsReceiver {

    @JmsListener(destination = "queue2")
    public void Receive(String message){
        System.out.println(RabbitMqReceiverApplication.Id + ": " + message);
    }

    @JmsListener(destination = "my-topic", containerFactory = "topicJmsListenerContainerFactory")
    public void ReceiveTopic(String message){
        System.out.println("r: " + RabbitMqReceiverApplication.Id + " :: " + message);
    }


//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer1(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setDestination(new RMQDestination("queue2", true, false));
//        //тут ловим сообщения из queue1
//        container.setMessageListener(new MessageListener() {
//            @Override
//            public void onMessage(Message message) {
//                System.out.println("received from queue1 : " + new String(message.toString()));
//            }
//        });
//        return container;
//    }

}
