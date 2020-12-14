package com.techprimers.kafka.producer;

import com.techprimers.kafka.producer.service.FileReaderService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootKafkaProducerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootKafkaProducerApplication.class)
				.sibling(FileReaderService.class).run(args);

	}
}
