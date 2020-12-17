package com.kafka.producer.service;

import com.kafka.producer.model.Person;
import com.kafka.producer.repo.PersonRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private static final Logger log = Logger.getLogger(PersonService.class);

    @Autowired
    PersonRepository personRepository;

    /**
     * @param person
     */
    public void save(Person person) {
        personRepository.save(person);
        log.info("Person Save Successfully {}" + person);
    }

    public Person findbyId(Integer id) {
        return personRepository.findOne(id);
    }
}
