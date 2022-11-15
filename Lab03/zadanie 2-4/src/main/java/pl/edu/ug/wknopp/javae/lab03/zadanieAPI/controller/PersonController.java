package pl.edu.ug.wknopp.javae.lab03.zadanieAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain.Person;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.service.PersonService;

import java.util.List;

@RestController
public class PersonController{

    private final PersonService personService;

    PersonController(@Autowired PersonService personService){
        this.personService = personService;
    }

    @PostMapping("/api/persons")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping("/api/persons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/api/persons/{firstName}")
    public Person getPerson(@PathVariable String firstName){
        return personService.getPerson(firstName);
    }

    @PutMapping("/api/persons/{firstName}")
    public Person updatePerson(@PathVariable String firstName,@RequestBody Person person){
        return personService.updatePerson(firstName, person);
    }

    @DeleteMapping("/api/persons/{firstName}")
    public boolean deletePerson(@PathVariable String firstName){
        return personService.deletePerson(firstName);
    }
}

