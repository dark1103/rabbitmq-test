package com.dark1103.rabbitmq.sender;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService {

    @Autowired
    public void Declare(AmqpAdmin amqpAdmin, @Autowired(required = false) List<Exchange> exchanges, @Autowired(required = false) List<Binding> bindings){
        if(exchanges != null)
            exchanges.forEach(amqpAdmin::declareExchange);
        if(bindings != null)
            bindings.forEach(amqpAdmin::declareBinding);
    }

}
