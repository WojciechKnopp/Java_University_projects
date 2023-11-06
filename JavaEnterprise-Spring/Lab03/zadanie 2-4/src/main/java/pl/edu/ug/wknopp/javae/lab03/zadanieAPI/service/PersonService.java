package pl.edu.ug.wknopp.javae.lab03.zadanieAPI.service;

import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    Person getPerson(String firstName);

    Person addPerson(Person person);

    Person updatePerson(String firstName, Person person);

    boolean deletePerson(String firstName);
}