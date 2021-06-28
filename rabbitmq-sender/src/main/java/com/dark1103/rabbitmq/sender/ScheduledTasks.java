package com.dark1103.rabbitmq.sender;

import com.dark1103.rabbitmq.sender.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
    private final Producer producer;
    private int counter = 0;

    @Scheduled(fixedRate = 50)
    public void reportCurrentTime() {
        producer.SendMessage("f: " + RabbitMqSenderApplication.Id + " ||| " + dateFormat.format(new Date()) + " (" + counter++ + ")");
//        System.out.println("The time is now " + dateFormat.format(new Date()));
    }

//    @Scheduled(fixedRate = 100)
//    public void reportCurrentTime2() {
//        producer.SendMessage("The time is now " + dateFormat.format(new Date()));
////        System.out.println("The time is now " + dateFormat.format(new Date()));
//    }
//
//    @Scheduled(fixedRate = 100)
//    public void reportCurrentTime3() {
//        producer.SendMessage("The time is now " + dateFormat.format(new Date()));
////        System.out.println("The time is now " + dateFormat.format(new Date()));
//    }
}
