package pl.edu.ug.wknopp.javae.lab03.zadanie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.edu.ug.wknopp.javae.lab03.zadanie.domain.Person;
import pl.edu.ug.wknopp.javae.lab03.zadanie.service.Data;

import java.io.IOException;
import java.util.Map;

@SpringBootApplication
public class ZadanieApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ZadanieApplication.class, args);

		try {
			Map<String, Person> people = Data.parseData(applicationContext);
			people.forEach((k, v) -> System.out.println(k + " " + v));

		} catch (IOException e) {
			System.out.println("Could not connect to website");
		}
	}





}

//1000 520 779 482 U