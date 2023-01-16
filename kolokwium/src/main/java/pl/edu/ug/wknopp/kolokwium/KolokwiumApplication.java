package pl.edu.ug.wknopp.kolokwium;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.ug.wknopp.kolokwium.service.PackOfCardsService;

@SpringBootApplication
public class KolokwiumApplication {

	public static void main(String[] args) {
		SpringApplication.run(KolokwiumApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PackOfCardsService packOfCardsService) {
		return args -> {
			packOfCardsService.presentation();
		};
	}

}
