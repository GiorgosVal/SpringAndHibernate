package org.example.config;

import org.example.models.Coach;
import org.example.models.FootballCoach;
import org.example.services.CoolFortuneService;
import org.example.services.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FootballConfig {

    @Bean
    public Coach footballCoach() {
        return new FootballCoach(coolFortuneService());
    }

    @Bean
    public FortuneService coolFortuneService(){
        return new CoolFortuneService();
    }

}
