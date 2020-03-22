package com.example.people;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    // TODO use constructor injection.
    // TODO make it private final
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Not really REST. Should be a POST to
    // /people
    @PostMapping(path = "/people")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    // Not really REST. Should be a GET to
    // /people
    @GetMapping(path = "people")
    public List<Person> getPersons() {
        return (List<Person>) personRepository.findAll();
    }

    // Not really REST. Should be a GET to
    // /people/{id}
    @GetMapping(path = "people/{id}")
    public Person getPerson(@PathVariable long id) {
        return personRepository.findById(id);
    }

    // Not really REST. Should be a PUT to
    // /people
    @PutMapping(path = "people")
    public void updatePerson(@RequestBody Person person){
        personRepository.save(person);
    }

    // Not really REST. Should be a DELETE to
    // /people/{id}
    @DeleteMapping(path = "people/{id}")
    public void deletePerson(@PathVariable long id){
        personRepository.deleteById(id);
    }
}
