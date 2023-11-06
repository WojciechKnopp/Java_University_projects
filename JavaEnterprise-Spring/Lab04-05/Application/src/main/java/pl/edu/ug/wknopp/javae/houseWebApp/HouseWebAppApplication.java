package pl.edu.ug.wknopp.javae.houseWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.ug.wknopp.javae.houseWebApp.domain.House;
import pl.edu.ug.wknopp.javae.houseWebApp.service.HouseService;

import java.util.UUID;

@SpringBootApplication
public class HouseWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseWebAppApplication.class, args);
	}

	@Bean
	CommandLineRunner applicationRunner(@Autowired HouseService houseService) {
		return args -> {
			houseService.addHouse(new House(UUID.randomUUID().toString(), 1, 40, "Gdańsk, ul. Przykładowa 10", 250000.0, 2000, "Przykładowy opis nr1"));
			houseService.addHouse(new House(UUID.randomUUID().toString(), 2, 60, "Mieścin, ul. Krótka 43", 300000.0, 1995, "Przykładowy opis nr2"));
			houseService.addHouse(new House(UUID.randomUUID().toString(), 2, 85, "Kubocin, ul. Uszka 8", 425000.0, 2010, "Przykładowy opis nr3"));
		};
	}

}
