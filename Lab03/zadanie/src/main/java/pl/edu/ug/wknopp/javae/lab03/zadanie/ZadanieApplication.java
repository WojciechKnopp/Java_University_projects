package pl.edu.ug.wknopp.javae.lab03.zadanie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import pl.edu.ug.wknopp.javae.lab03.zadanie.domain.Person;
import pl.edu.ug.wknopp.javae.lab03.zadanie.service.Data;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.SortedMap;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class ZadanieApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ZadanieApplication.class, args);

		try {
			LinkedHashMap<String, Person> people = Data.parseData(Data.sendGet(), applicationContext);

			for (SortedMap.Entry<String, Person> entry : people.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}


		} catch (IOException e) {
			System.out.println("Could not connect to website");
		}
	}





}
