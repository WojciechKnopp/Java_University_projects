package pl.edu.ug.wknopp.javae.houseWebApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.edu.ug.wknopp.javae.houseWebApp.domain.House;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public House newHouse(){
        return new House();
    }
}
