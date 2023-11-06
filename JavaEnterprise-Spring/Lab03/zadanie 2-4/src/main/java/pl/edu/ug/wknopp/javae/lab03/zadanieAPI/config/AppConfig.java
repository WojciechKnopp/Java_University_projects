package pl.edu.ug.wknopp.javae.lab03.zadanieAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain.Person;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public Person newPerson(){
        return new Person();
    }

    @Bean
    @Scope("singleton")
    public Person newPerson2(){
        return new Person();
    }
}
