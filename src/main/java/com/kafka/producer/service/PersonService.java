package com.kafka.producer.service;

import com.kafka.producer.model.Person;
import com.kafka.producer.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    @Autowired
    PersonRepository personRepository;

    /**
     * @param person
     */
    public void save(Person person) {
        personRepository.save(person);
       // log.info("Person Save Sucessfully {}" + person);
    }

}
