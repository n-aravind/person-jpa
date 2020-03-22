package com.example.people;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    public PersonController(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
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

    @PostMapping(path = "people/batch")
    public void addPeople(@RequestBody List<Person> personList){
        personService.addPeople(personList);
    }
}
