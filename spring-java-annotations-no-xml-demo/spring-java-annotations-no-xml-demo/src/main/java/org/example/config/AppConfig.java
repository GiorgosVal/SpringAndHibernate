package org.example.config;

import org.example.models.Coach;
import org.example.models.SwimCoach;
import org.example.services.thirdparty.SadFortuneService;
import org.example.services.thirdparty.ThirdPartyFortuneService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:coach.properties")       // this way Spring loads the .properties file
public class AppConfig {

    // @Bean annotation is helpful while working with 3rd party classes
    @Bean
    public ThirdPartyFortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    // Since SwimCoach class is not a 3rd-party, we can avoid this @Bean definition by simply use @Autowire in the
    // SwimCoach constructor.
    // On the other hand, @Bean offers the possibility to create a bean with different scopes. This one is singleton.
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }

    @Bean
    @Scope("prototype")
    public Coach swimCoachPrototype() {
        return new SwimCoach(sadFortuneService());
    }



}
