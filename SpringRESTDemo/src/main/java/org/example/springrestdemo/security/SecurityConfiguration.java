package org.example.springrestdemo.security;

import org.example.springrestdemo.mvc.models.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "org.example.springrestdemo")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String EMPLOYEE = RoleType.EMPLOYEE.toString();
    private final String MANAGER = RoleType.MANAGER.toString();
    private final String ADMIN = RoleType.ADMIN.toString();

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AccessDeniedHandler customAccessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/customers").hasAnyRole(EMPLOYEE, MANAGER, ADMIN)
                .antMatchers(HttpMethod.GET, "/api/customers/**").hasAnyRole(EMPLOYEE, MANAGER, ADMIN)
                .antMatchers(HttpMethod.POST, "/api/customers").hasAnyRole(MANAGER, ADMIN)
                .antMatchers(HttpMethod.POST, "/api/customers/**").hasAnyRole(MANAGER, ADMIN)
                .antMatchers(HttpMethod.PUT, "/api/customers").hasAnyRole(MANAGER, ADMIN)
                .antMatchers(HttpMethod.PUT, "/api/customers/**").hasAnyRole(MANAGER, ADMIN)
                .antMatchers(HttpMethod.DELETE, "/api/customers/**").hasRole(ADMIN)
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
}
