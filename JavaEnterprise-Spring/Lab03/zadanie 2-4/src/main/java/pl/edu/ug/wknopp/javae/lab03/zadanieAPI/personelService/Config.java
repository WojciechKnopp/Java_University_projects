package pl.edu.ug.wknopp.javae.lab03.zadanieAPI.personelService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain.Person;

import java.util.UUID;

@Configuration
public class Config {
    @Bean
    public Person president(){
        return new Person("Chrystal","Havoc","chavocr@yahoo.com","Mymm");
    }

    @Bean
    public Person vicePresident(){
        return new Person("Halley","Gadaud","hgadaud9@sohu.com","Oyope");
    }

    @Bean
    public Person secretary(){
        return new Person("Kirbie","Wrettum","kwrettumj@slideshare.net","Browsetype");
    }
}

