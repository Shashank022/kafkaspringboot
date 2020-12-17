package com.kafka.producer;

import com.kafka.producer.service.FileReaderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class SpringBootKafkaProducerApp {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootKafkaProducerApp.class, args);
		context.getBean(FileReaderService.class).launchJob();
	}
}
