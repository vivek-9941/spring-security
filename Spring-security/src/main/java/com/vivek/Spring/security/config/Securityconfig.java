package com.vivek.Spring.security.config;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//need to create the config class to specify configuration that i want .
//i dont want any default filter chain i want my own configurations for security filter so this config class is made
@Configuration
@EnableWebSecurity//this specifies that dont go with the default filter chain flow go with my own flow

public class Securityconfig {
    //return a bean for security filter chain so dont use default
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(customizer -> customizer.disable());//disabling csrf
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());//this will authenticate every requesst
        //but need form to authenticate

//        http.formLogin(Customizer.withDefaults());


        //if this form login is not used hhtpbasic will give the login using browser
        //but to do from postman
        http.httpBasic(Customizer.withDefaults());
        //here we are not using the csrf so  we can secure webpage by making it stateless21
    //In a stateless system, the concept of a session ID as used in traditional stateful systems is
    // typically not present. Instead, stateless systems rely on alternatives like tokens (e.g., JWTs) to maintain context without the need for server-side session storage.
        http.sessionManagement(Session -> Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));



        //this above can be written as

//        http
//                .csrf(customizer -> customizer.disable())
//                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(Session -> Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }
}
