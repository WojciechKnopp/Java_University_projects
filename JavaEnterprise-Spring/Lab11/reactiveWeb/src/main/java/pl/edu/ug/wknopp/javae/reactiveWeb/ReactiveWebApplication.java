package pl.edu.ug.wknopp.javae.reactiveWeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import pl.edu.ug.wknopp.javae.reactiveWeb.domain.Opinion;

@SpringBootApplication
public class ReactiveWebApplication{

	Logger logger = LoggerFactory.getLogger(pl.edu.ug.wknopp.javae.reactiveWeb.ReactiveWebApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(pl.edu.ug.wknopp.javae.reactiveWeb.ReactiveWebApplication.class, args);
	}

	@Bean
	ApplicationRunner runner() {
		return args -> {
			WebClient.create("http://localhost:8080/").get()
					.uri("opinionstream")
					.retrieve()
					.bodyToFlux(Opinion.class)
					.subscribe(data -> logger.info(data.toString()));
		};
	}
}

