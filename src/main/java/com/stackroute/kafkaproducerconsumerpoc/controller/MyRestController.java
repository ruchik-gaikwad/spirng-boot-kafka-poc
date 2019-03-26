package com.stackroute.kafkaproducerconsumerpoc.controller;

import com.stackroute.kafkaproducerconsumerpoc.configuration.KafkaSender;
import com.stackroute.kafkaproducerconsumerpoc.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Autowired
    KafkaSender kafkaSender;

    @PostMapping("/produce")
    public String produceData(@RequestBody Car car) {

        System.out.println("REQUEST BODY..!! "+  car);

        kafkaSender.send(car);

        return "Produced to Kafka Topic !!";

    };
}
