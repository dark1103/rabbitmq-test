package com.dark1103.rabbitmq.sender;

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
    private final JmsSender sender;

    @Scheduled(fixedRate = 100)
    public void reportCurrentTime() {
        sender.SendMessage("The time is now " + dateFormat.format(new Date()));
//        System.out.println("The time is now " + dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 100)
    public void reportCurrentTime2() {
        sender.SendMessage("The time is now " + dateFormat.format(new Date()));
//        System.out.println("The time is now " + dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 100)
    public void reportCurrentTime3() {
        sender.SendMessage("The time is now " + dateFormat.format(new Date()));
//        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}
