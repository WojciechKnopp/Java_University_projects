package pl.edu.ug.wknopp.javae.lab03.zadanieAPI.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain.Person;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.service.Data;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.service.PersonService;

import java.util.List;

@RestController
public class PersonController implements PersonService {

    private final List<Person> db;
    PersonController(){
        db = Data.parseData();
    }

    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person) {
        db.add(person);
        return person;
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return db;
    }

    @GetMapping("/persons/{firstName}")
    public Person getPerson(@PathVariable String firstName){
        for(Person person : db){
            if(person.getFirstName().equals(firstName)){
                return person;
            }
        }
        return null;
    }

    @PutMapping("/persons/{firstName}")
    public Person updatePerson(@PathVariable String firstName,@RequestBody Person person){
        for(Person p : db){
            if(p.getFirstName().equals(firstName)){
                p.setId(person.getId());
                p.setFirstName(person.getFirstName());
                p.setLastName(person.getLastName());
                p.setEmail(person.getEmail());
                p.setCompanyName(person.getCompanyName());
                p.setPosition(person.getPosition());
                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/persons/{firstName}")
    public Person deletePerson(@PathVariable String firstName){
        Person personToDelete = null;
        for(Person person : db){
            if(person.getFirstName().equals(firstName)){
                personToDelete = person;
            }
        }
        if(personToDelete != null){
            db.remove(personToDelete);
        }
        return personToDelete;
    }
}

