package com.example.people;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {


    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping(path = "/people")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    @GetMapping(path = "people")
    public List<Person> getPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @GetMapping(path = "people/{id}")
    public Person getPerson(@PathVariable long id) {
        return personRepository.findById(id);
    }

    @PutMapping(path = "people")
    public void updatePerson(@RequestBody Person person){
        personRepository.save(person);
    }

    @DeleteMapping(path = "people/{id}")
    public void deletePerson(@PathVariable long id){
        personRepository.deleteById(id);
    }
}
