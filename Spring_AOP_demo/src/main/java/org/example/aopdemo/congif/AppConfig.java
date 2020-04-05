package org.example.aopdemo.congif;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("org.example.aopdemo")
public class AppConfig {

    // other configuration stuff...

}
