package com.narentech.kafkaservice.controller;

import com.narentech.kafkaservice.component.TopicConsumer;
import com.narentech.kafkaservice.component.TopicProducer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    public TopicProducer topicProducer;

    @Autowired
    public TopicConsumer topicConsumer;

    @PostMapping(value = "/send")
    public Integer sendMessage(@RequestBody String message){

         return topicProducer.send(message);
    }

}
