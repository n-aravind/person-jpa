package com.example.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping(path = "/addPerson")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    @GetMapping(path = "getPersons")
    public List<Person> getPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @GetMapping(path = "getPerson", params = "id")
    public Person getPerson(@RequestParam long id) {
        return personRepository.findById(id);
    }

    @PutMapping(path = "updatePerson")
    public void updatePerson(@RequestBody Person person){
        personRepository.save(person);
    }

    @DeleteMapping(path = "deletePerson",params = "id")
    public void deletePerson(@RequestParam long id){
        personRepository.deleteById(id);
    }
}
