package com.dark1103.rabbitmq.sender.config;

import com.dark1103.rabbitmq.sender.producer.JmsProducer;
import com.dark1103.rabbitmq.sender.producer.Producer;
import com.rabbitmq.jms.admin.RMQConnectionFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

//@Configuration
public class RabbitMqConfiguration {

    @Bean(name = "my-topic")
    public TopicExchange myTopic() {
        return new TopicExchange("my-topic");
    }

//    @Bean(name = "jms.durable.topic")
//    public TopicExchange jmsTopic() {
//        return new TopicExchange("jms.durable.topic");
//    }


//    @Bean
//    public Queue queue3() {
//        return new Queue("queue3");
//    }

//    @Bean
//    Binding binding1(Queue queue, @Qualifier("my-topic") TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with("#");
//    }

//    @Bean
//    Binding binding2(@Qualifier("my-topic") TopicExchange topicExchange, @Qualifier("jms.durable.topic") TopicExchange jmsTopic){
//        return BindingBuilder.bind(topicExchange).to(jmsTopic).with(topicExchange.getName());
//    }

    @Bean
    public RMQConnectionFactory connectionFactory() {
        return new RMQConnectionFactory();
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Producer producer(JmsTemplate template, @Qualifier("my-topic") TopicExchange topic){
        return new JmsProducer(template, topic);
    }

}
