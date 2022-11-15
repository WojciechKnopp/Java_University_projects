package pl.edu.ug.wknopp.javae.lab03.zadanieAPI.service;

import org.springframework.stereotype.Component;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonServiceInMemory implements PersonService {

    //private final List<Person> db = Data.parseData();
    private final List<Person> db = new ArrayList<>();
    @Override
    public List<Person> getAllPersons() {
        return db;
    }

    @Override
    public Person getPerson(String firstName) {
        for(Person person : db){
            if(person.getFirstName().equals(firstName)){
                return person;
            }
        }
        return null;
    }

    @Override
    public Person addPerson(Person person) {
        db.add(person);
        return person;
    }

    @Override
    public Person updatePerson(String firstName, Person person) {
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

    @Override
    public boolean deletePerson(String firstName) {
        Person personToDelete = null;
        for(Person person : db){
            if(person.getFirstName().equals(firstName)){
                personToDelete = person;
            }
        }
        if(personToDelete != null){
            db.remove(personToDelete);
            return true;
        }
        return false;
    }
}

