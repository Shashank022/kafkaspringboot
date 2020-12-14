package com.techprimers.kafka.springbootkafkaproducerexample.repo;
import com.techprimers.kafka.springbootkafkaproducerexample.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {


}
