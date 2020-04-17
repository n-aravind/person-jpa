package com.example.people;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    private PersonRepository personRepository = mock(PersonRepository.class);

    private PersonService personService = new PersonService(personRepository);

    @Test
    void addPeople() {
        List<Person> people = new ArrayList<>();
        Person person1 = Person.builder().firstName("John").lastName("Doe").build();
        Person person2 = Person.builder().firstName("Jane").lastName("king").build();

        people.add(person1);
//        people.add(person2);

        personService.addPeople(people);
        ArgumentCaptor<Person> person1Arg = ArgumentCaptor.forClass(Person.class);


        verify(personRepository).save(person1Arg.capture());
        //verify(personRepository,times(1)).save(person2);

        assertEquals("John", person1Arg.getValue().getFirstName());
    }

    @Test
    void get() {
        Person person1 = Person.builder().firstName("John").lastName("Doe").build();
        when(personRepository.findById(1)).thenReturn(person1);
        Person person = personService.get(1);
        verify(personRepository,times(1)).findById(1);
        assertNotNull(person);
    }

    @Test
    void getTest() {
        when(personRepository.findById(2)).thenThrow(new RuntimeException("Oops"));
        try{
            personService.get(2);
            fail("Should have gotten a runtime exception");
        }catch (RuntimeException e){
            assertEquals("Oops",e.getMessage());
        }
    }

}