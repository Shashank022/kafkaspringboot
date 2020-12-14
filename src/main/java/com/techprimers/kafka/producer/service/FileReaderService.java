package com.techprimers.kafka.producer.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techprimers.kafka.producer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



@Service
public class FileReaderService {

    @Autowired
    PersonService personService;

    @Value("${file.resource}")
    private String fileResource;

   // private AtomicInteger batchRunCounter = new AtomicInteger(0);

    @Scheduled(cron = "${cron.expression}")
    public void launchJob() {

        try {
            //if (batchRunCounter.get() <= 0) {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = Person.class.getResourceAsStream(fileResource);
            Person testObj = mapper.readValue(is, Person.class);

				//for (Person person : testObj) {
					personService.save(testObj);
				//}

        } catch (IllegalStateException | FileNotFoundException e) {
            //log.error(ExceptionUtils.getFullStackTrace(e));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // batchRunCounter.incrementAndGet();
    }

}
