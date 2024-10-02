package config;

import component.Coach;
import component.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("swim")
    public Coach getSwimCoach(){
        return new SwimCoach();
    }
}
