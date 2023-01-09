package pl.edu.ug.wknopp.javae.DBDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.ug.wknopp.javae.DBDemo.service.HouseService;

@SpringBootApplication
public class DbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner appSetup(@Autowired HouseService houseService){
		return args -> {
			houseService.learning();
			houseService.lab10();
		};

	}
}
