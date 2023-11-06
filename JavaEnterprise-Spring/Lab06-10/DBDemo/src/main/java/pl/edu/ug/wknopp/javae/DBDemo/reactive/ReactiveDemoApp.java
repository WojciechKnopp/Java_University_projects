package pl.edu.ug.wknopp.javae.DBDemo.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

// Comment Tomcat in build.gradle
// (Changing Tomcat to Netty)
// And comment application.properties or have database server running

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

