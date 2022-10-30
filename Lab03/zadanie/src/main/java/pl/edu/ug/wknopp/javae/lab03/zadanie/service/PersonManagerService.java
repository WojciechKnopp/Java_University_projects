package pl.edu.ug.wknopp.javae.lab03.zadanie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.ug.wknopp.javae.lab03.zadanie.domain.Person;

@Component
public class PersonManagerService {
    private final Person examplePerson;
    public PersonManagerService(@Autowired @Qualifier("addPerson") Person person){
        this.examplePerson = person;
    }

    public Person getExamplePerson(){
        return examplePerson;
    }
}
