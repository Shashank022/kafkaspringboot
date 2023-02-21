package com.kafka.producer.service;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kafka.producer.model.Person;
import com.kafka.producer.resource.KafkaProducerResource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class FileReaderService {

    private static final Logger log = Logger.getLogger(FileReaderService.class);

    @Autowired
    PersonService personService;

    @Autowired
    KafkaProducerResource kafkaProducerResource;

    @Value("${file.resource}")
    private String fileResource;

    @Scheduled(cron = "${cron.expression}")
    public void launchJob() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Person data = mapper.readValue(new File(fileResource), Person.class);
        System.out.println(data);
        List<Map<String, Object>> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileResource)));
                String line;
                    while ((line = br.readLine()) != null) {
                        Person obj = mapper.readValue(line, Person.class);
                        personService.save(obj);
                        kafkaProducerResource.postPerson(obj.getId());
                    }
            }catch(Exception e){
            log.info("Exception occurred at FileReaderService:{}");
        }
    }
}
