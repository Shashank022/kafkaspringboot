package com.techprimers.kafka.springbootkafkaproducerexample;

import com.techprimers.kafka.springbootkafkaproducerexample.service.FileReaderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootKafkaProducerExampleApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootKafkaProducerExampleApplication.class)
				.sibling(FileReaderService.class).run(args);

	}
}
