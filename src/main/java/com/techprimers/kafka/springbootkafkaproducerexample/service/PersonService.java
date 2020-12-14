package com.techprimers.kafka.springbootkafkaproducerexample.service;

import com.techprimers.kafka.springbootkafkaproducerexample.model.Person;
import com.techprimers.kafka.springbootkafkaproducerexample.repo.PersonRepository;
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
