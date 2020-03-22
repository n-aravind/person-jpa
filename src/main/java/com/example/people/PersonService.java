package com.example.people;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void addPeople(List<Person> people) {
        for (Person person : people) {
            personRepository.save(person);
        }
    }
}
