package pl.edu.ug.wknopp.javae.DBDemo.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

// Switch Web to Webflux in build.gradle for it to work
// (Changing Tomcat to Netty)
// And commens application.properties

@SpringBootApplication
public class ReactiveDemoApp{

    Logger logger = LoggerFactory.getLogger(ReactiveDemoApp.class);

    public static void main(String[] args) {
        SpringApplication.run(ReactiveDemoApp.class, args);
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

