package com.dark1103.rabbitmq.receiver.config;

import com.rabbitmq.jms.admin.RMQConnectionFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
public class RabbitMqConfiguration {

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

    @Bean(name = "topicJmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory getTopicFactory() {
        DefaultJmsListenerContainerFactory f = new  DefaultJmsListenerContainerFactory();
        f.setConnectionFactory(connectionFactory());
        f.setSessionTransacted(true);
        f.setPubSubDomain(true);
        return f;
    }

}
