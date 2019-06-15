package com.asol.config;

import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//@Configuration
//@EnableWebSecurity
public class BasicAuthConfiguration 
  extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("user")
          .password("password")
          .roles("USER");
    }
 
    @Override
    protected void configure(HttpSecurity http) 
      throws Exception {
     /*   http.csrf().disable()
          .authorizeRequests()
          .antMatchers("/login").permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();*/
    	//http.cors().disable().
    	//csrf().disable()
    	
    	http
    	//.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
        //.and()
        .authorizeRequests().antMatchers("/mall/login**").permitAll()
        .and()
        .csrf().disable()
        .cors();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}