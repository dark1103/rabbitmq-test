package com.dark1103.rabbitmq.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class RabbitMqReceiverApplication {

	public static final int Id = new Random().nextInt(100	);

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqReceiverApplication.class, args);
	}

}
