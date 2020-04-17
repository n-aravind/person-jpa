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

    public Person get(long id) {
        return personRepository.findById(id);
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    public void deleteById(long id) {
        personRepository.deleteById(id);
    }
}
