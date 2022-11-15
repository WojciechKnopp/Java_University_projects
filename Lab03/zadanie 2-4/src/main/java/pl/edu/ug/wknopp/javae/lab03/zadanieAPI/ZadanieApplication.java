package pl.edu.ug.wknopp.javae.lab03.zadanieAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain.Person;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.service.Data;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.service.PersonService;

import java.util.List;

@SpringBootApplication
public class ZadanieApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ZadanieApplication.class, args);

		PersonService personService = applicationContext.getBean(PersonService.class);
		List<Person> people = Data.parseData();
		if(people != null){
			for(Person person : people){
				personService.addPerson(person);
			}
		}
		if(people != null){
			for(Person person : personService.getAllPersons()){
				System.out.println(person);
			}
		}
	}
}
