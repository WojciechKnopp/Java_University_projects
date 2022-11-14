package pl.edu.ug.wknopp.javae.lab03.zadanieAPI.service;

import org.springframework.web.bind.annotation.*;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain.Person;

import java.util.List;

public interface PersonService {

    @GetMapping("/api/persons")
    List<Person> getAllPersons();

    @GetMapping("/api/persons/{firstName}")
    Person getPerson(@PathVariable String firstName);

    @PostMapping("/api/persons")
    Person addPerson(Person person);

    @PutMapping("/api/persons/{firstName}")
    Person updatePerson(@PathVariable String firstName, Person person);

    @DeleteMapping("/api/persons/{firstName}")
    Person deletePerson(@PathVariable String firstName);
}
