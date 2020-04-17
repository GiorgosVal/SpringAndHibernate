package org.example.springsecuritydemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import static org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder builder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(builder.username("john").password("1234").roles("EMPLOYEE"))
                .withUser(builder.username("mary").password("1234").roles("EMPLOYEE", "MANAGER"))
                .withUser(builder.username("susan").password("1234").roles("EMPLOYEE", "ADMIN"))
                .withUser(builder.username("george").password("1234").roles("ASSOCIATE"));

        // super.configure(auth);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()   // allow public access to home
                .antMatchers("/employees/**").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .antMatchers("/shared/**").hasAnyRole("MANAGER", "ASSOCIATE")
                .and()
                .formLogin()
                .loginPage("/login-form")
                .loginProcessingUrl("/authenticateUser")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/forbidden");  // custom access denied page
    }


    /**
     * With this configuration the application lands on login form on startup.
     * @param http
     * @throws Exception
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()              // restrict access based on HttpServletRequest
//                .anyRequest().authenticated() // any request to the app must be authenticated (logged in)
//                .and()
//                .formLogin()                             // override Spring Security default login form
//                .loginPage("/login-form")                // configure request mapping
//                .loginProcessingUrl("/authenticateUser") // configure mapping on form POST
//                .permitAll()                             // allow anyone to see the login page
//                .and()
//                .logout()                                // enable logout
//                .permitAll();                            // allow anyone to logout
//    }

}