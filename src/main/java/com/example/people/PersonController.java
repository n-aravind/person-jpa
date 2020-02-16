package com.example.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    // TODO use constructor injection.
    // TODO make it private final
    @Autowired
    PersonRepository personRepository;

    // Not really REST. Should be a POST to
    // /people
    @PostMapping(path = "/addPerson")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    // Not really REST. Should be a GET to
    // /people
    @GetMapping(path = "getPersons")
    public List<Person> getPersons() {
        return (List<Person>) personRepository.findAll();
    }

    // Not really REST. Should be a GET to
    // /people/{id}
    @GetMapping(path = "getPerson", params = "id")
    public Person getPerson(@RequestParam long id) {
        return personRepository.findById(id);
    }

    // Not really REST. Should be a PUT to
    // /people
    @PutMapping(path = "updatePerson")
    public void updatePerson(@RequestBody Person person){
        personRepository.save(person);
    }

    // Not really REST. Should be a DELETE to
    // /people/{id}
    @DeleteMapping(path = "deletePerson",params = "id")
    public void deletePerson(@RequestParam long id){
        personRepository.deleteById(id);
    }
}
