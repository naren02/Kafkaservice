package com.narentech.kafkaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaserviceApplication.class, args);
	}

}
