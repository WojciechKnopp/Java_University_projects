package pl.edu.ug.wknopp.javae.lab03.zadanieAPI.service;

import org.springframework.web.bind.annotation.*;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain.Person;

import java.util.List;

public interface PersonService {

    @GetMapping("/persons")
    List<Person> getAllPersons();

    @GetMapping("/persons/{firstName}")
    Person getPerson(@PathVariable String firstName);

    @PostMapping("/persons")
    Person addPerson(Person person);

    @PutMapping("/persons/{firstName}")
    Person updatePerson(@PathVariable String firstName, Person person);

    @DeleteMapping("/persons/{firstName}")
    Person deletePerson(@PathVariable String firstName);
}
