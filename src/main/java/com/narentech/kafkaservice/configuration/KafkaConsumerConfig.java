package com.narentech.kafkaservice.configuration;


import com.narentech.kafkaservice.pojo.Employee;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConsumerConfig {

    @Value("${kafka.consumer.max.poll.interval.ms}")
    private String kafkaConsumerMaxPollIntervalMs;

    @Value("${kafka.consumer.max.poll.records}")
    private String kafkaConsumerMaxPollRecords;



    @Bean
    public ConsumerFactory<String, Employee> employeeConsumerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties(), new StringDeserializer(), new JsonDeserializer<>(Employee.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Employee> employeeKafkaListenerContainerFactory(KafkaProperties kafkaProperties) {

        kafkaProperties.getProperties().put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, kafkaConsumerMaxPollIntervalMs);
        kafkaProperties.getProperties().put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, kafkaConsumerMaxPollRecords);
      //  kafkaProperties.getProperties().put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");

        ConcurrentKafkaListenerContainerFactory<String, Employee> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        factory.setConsumerFactory(employeeConsumerFactory(kafkaProperties));


        return factory;
    }

}