package com.webapp.pressdistribution.application.config;

import com.webapp.pressdistribution.application.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private UserService userService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/", "/home", "/static/**/*", "/auth/**/*", "/api/**/*").permitAll().anyRequest()
        .authenticated().and().formLogin().defaultSuccessUrl("/home", true).loginPage("/login").permitAll().and()
        .logout().permitAll();
  }

  @SuppressWarnings({"deprecation"})
  @Bean
  public PasswordEncoder passwordEncoder() {
    return org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance();
  }


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
  }
}