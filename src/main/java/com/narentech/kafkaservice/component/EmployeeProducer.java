package com.narentech.kafkaservice.component;

import com.narentech.kafkaservice.pojo.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<Integer, Employee> kafkaTemplate;

    public Integer send(Employee employee){

        Integer hashCode = employee.hashCode();
        kafkaTemplate.send(topicName, hashCode, employee);
        return hashCode;
    }
}
