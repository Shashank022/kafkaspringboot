package com.techprimers.kafka.producer.service;

import com.techprimers.kafka.producer.model.Person;
import com.techprimers.kafka.producer.repo.PersonRepository;
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
