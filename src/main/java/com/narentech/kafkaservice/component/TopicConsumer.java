package com.narentech.kafkaservice.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicConsumer {

    @Value("${topic.name.consumer}")
    private String topicName;


   // @KafkaListener(topics = "${topic.name.consumer}", containerFactory = "employeeKafkaListenerContainerFactory",groupId = "group_id")
    public void consume(ConsumerRecord payload){
        System.out.println("Consumer Message value "+payload.value());
        System.out.println("Consumer Message key"+payload.key());
        System.out.println("Consumer Offset"+payload.offset());
        System.out.println("Consumer Header"+payload.headers());
    }

}
