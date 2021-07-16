package com.kafka.producer.service;

import com.kafka.producer.model.Person;
import com.kafka.producer.repo.PersonRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private static final Logger log = Logger.getLogger(PersonService.class);

    @Autowired
    PersonRepository pRepo;

    /**
     * @param person
     */
    public void save(Person person) {
        pRepo.save(person);
        log.info("Person Save Successfully {}" + person);
    }

    public Person findbyId(Integer id) {
        return pRepo.findOne(id);
    }

    public List<Person> getAllPersonsList() {
        return (List<Person>) pRepo.findAll();
    }
}
