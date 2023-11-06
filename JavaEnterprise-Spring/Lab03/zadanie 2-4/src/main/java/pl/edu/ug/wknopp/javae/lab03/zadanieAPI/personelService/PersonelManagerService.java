package pl.edu.ug.wknopp.javae.lab03.zadanieAPI.personelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain.Person;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.service.PersonService;

@Component
public class PersonelManagerService {
    private final Person president;
    private final Person vicePresident;
    private final Person secretary;

    public PersonelManagerService(@Autowired Person president, @Autowired Person vicePresident, @Autowired Person secretary, @Autowired PersonService personService) {
        this.president = president;
        this.vicePresident = vicePresident;
        this.secretary = secretary;
        personService.addPerson(president);
        personService.addPerson(vicePresident);
        personService.addPerson(secretary);
    }


    public Person getPresident() {
        return president;
    }

    public Person getVicePresident() {
        return vicePresident;
    }

    public Person getSecretary() {
        return secretary;
    }
}

