package org.jbossgroup.numerico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

     @Autowired
     private JwtAuthenticationConverter jwtAuthenticatorConverter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
               .csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(http -> {
                    http.requestMatchers("/numerico/welcome").permitAll();
                    http.anyRequest().authenticated();
                }) 
               .oauth2ResourceServer(oauth ->{
                 oauth.jwt(jwt -> {
                   jwt.jwtAuthenticationConverter(jwtAuthenticatorConverter);
                 });
               })
               .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .build();
    }

   
}
