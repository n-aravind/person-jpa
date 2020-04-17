package com.example.people;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonRepository personRepository, PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(path = "/people")
    public void addPerson(@RequestBody Person person) {
        personService.save(person);
    }

    @GetMapping(path = "people")
    public List<Person> getPersons() {
        return personService.findAll();
    }

    @GetMapping(path = "people/{id}")
    public Person getPerson(@PathVariable long id) {
        return personService.get(id);
    }

    @PutMapping(path = "people")
    public void updatePerson(@RequestBody Person person){
        personService.save(person);
    }

    @DeleteMapping(path = "people/{id}")
    public void deletePerson(@PathVariable long id){
        personService.deleteById(id);
    }

    @PostMapping(path = "people/batch")
    public void addPeople(@RequestBody List<Person> personList){
        personService.addPeople(personList);
    }
}
