package com.stackroute.kafkaproducerconsumerpoc.configuration;

import com.stackroute.kafkaproducerconsumerpoc.domain.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

    @Value("${kafka.topic.json}")
    private String jsonTopic;

    @Autowired
    private KafkaTemplate<String, Car> kafkaTemplate;

    public void  send(Car car) {
        LOGGER.info("sending car='{}'", car.toString());
        kafkaTemplate.send(jsonTopic, car);
    }
}
