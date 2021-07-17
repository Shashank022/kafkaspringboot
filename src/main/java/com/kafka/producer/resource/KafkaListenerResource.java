package com.kafka.producer.resource;

import com.kafka.producer.model.Person;
import com.kafka.producer.model.User;
import com.kafka.producer.service.FileReaderService;
import com.kafka.producer.service.PersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("kafka")
public class KafkaListenerResource {

    private static final Logger log = Logger.getLogger(FileReaderService.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Person> kafkaPersonTemplate;

    @Autowired
    PersonService personService;

    @Value("${topic.example}")
    private String topicExmp;

    @Value("${topic.name}")
    private String topic;

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {
        kafkaTemplate.send(topicExmp, new User(name, "Technology", 12000L));
        return "Published successfully";
    }

    @GetMapping("/publish/person/{id}")
    public String postPerson(@PathVariable("id") final Integer id) {
        try{
            if(id != null){
                Person person = personService.findbyId(id);
                kafkaPersonTemplate.send(topic, new Person(id, person.getFirst_name(),person.getLast_name(),person.getEmail(),person.getGender(), person.getAddress(),
                        person.getCountry(), person.getZipcode(),person.getTimezone()));
            } else{
                log.error("The Person record given as Param doesn't exists in the DB Records : {}");
            }

        }catch ( Exception e){
            log.error("The Person record given as Param doesn't exists in the DB Records : {}");
        }
        return "Published successfully";
    }

    @GetMapping("/publish/allpersons")
    public String postAllPersonData() {
        List<Person> personList = new ArrayList<>();
        try{
            String id="all";
            if(id != null){
                personList = personService.getAllPersonsList();
                for (Person person: personList) {
                    kafkaPersonTemplate.send(topic, new Person(person.getId(), person.getFirst_name(),person.getLast_name(),person.getEmail(),person.getGender(), person.getAddress(),
                            person.getCountry(), person.getZipcode(),person.getTimezone()));
                     }

            } else{
                log.error("The Person record given as Param doesn't exists in the DB Records : {}");
            }

        }catch ( Exception e){
            log.error("The Person record given as Param doesn't exists in the DB Records : {}");
        }
        return "Published "+ personList.size() +"successfully";
    }
}
