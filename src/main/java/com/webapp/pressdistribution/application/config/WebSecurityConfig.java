package com.webapp.pressdistribution.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  // @Autowired
  // private UserService userService;

  // @Autowired
  // private PasswordEncoder passwordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers("/", "/home", "/static/**/*", "/auth/**/*")
      .permitAll()
      .anyRequest()
      .authenticated()
    .and()
      .formLogin()
      .defaultSuccessUrl("/home", true)
      .loginPage("/login")
      .permitAll()
    // .and()
      // .rememberMe()
    .and()
      .logout()
      .permitAll();
  }

  @Bean
  @Override
  public UserDetailsService userDetailsService(){
    UserDetails user = User.withDefaultPasswordEncoder()
    .username("q@mail.ru")
    .password("p")
    .roles("USER")
    .build();

    return new InMemoryUserDetailsManager(user);
  }

  // @Override
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    

  //   auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
  // }
}