package com.stackroute.kafkaproducerconsumerpoc.configuration;

import com.stackroute.kafkaproducerconsumerpoc.domain.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.json}")
    public void receive(Car car) {
        System.out.println(car.toString());
        LOGGER.info("received car='{}'", car.toString());
        latch.countDown();
    }
}
