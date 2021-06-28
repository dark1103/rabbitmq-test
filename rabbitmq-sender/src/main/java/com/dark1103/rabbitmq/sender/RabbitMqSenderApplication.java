package com.dark1103.rabbitmq.sender;

import com.dark1103.rabbitmq.sender.config.KafkaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.Random;

@SpringBootApplication
@Import(KafkaConfiguration.class)
public class RabbitMqSenderApplication {

	public static final int Id = new Random().nextInt(1000);

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqSenderApplication.class, args);
	}

}
