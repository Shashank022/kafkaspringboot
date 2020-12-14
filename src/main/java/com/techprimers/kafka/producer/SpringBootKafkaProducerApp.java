package com.techprimers.kafka.producer;

import com.techprimers.kafka.producer.service.FileReaderService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootKafkaProducerApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootKafkaProducerApp.class)
				.sibling(FileReaderService.class).run(args);

	}
}
