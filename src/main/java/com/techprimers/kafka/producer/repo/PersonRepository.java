package com.techprimers.kafka.producer.repo;
import com.techprimers.kafka.producer.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {


}
