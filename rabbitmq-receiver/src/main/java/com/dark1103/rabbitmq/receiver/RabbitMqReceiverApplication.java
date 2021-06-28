package com.dark1103.rabbitmq.receiver;

import com.dark1103.rabbitmq.receiver.config.KafkaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.Random;

@SpringBootApplication
@Import(KafkaConfiguration.class)
public class RabbitMqReceiverApplication {

	public static final int Id = new Random().nextInt(1000);

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqReceiverApplication.class, args);
	}

}
