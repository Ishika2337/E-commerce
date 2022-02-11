package com.ecommerce.WomensDressStore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService userDetailsService;
    //Authentication-- it just check username and password is correct or not
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    //Authorization-- it check for roles
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
                .antMatchers("/addDresses","/allDresses","/update/*").hasRole("ADMIN")
                .antMatchers("/cart/*","/pay/*","/cart","/myOrder","/profile","/updateProfile","/buy/*").hasRole("USER")
                .antMatchers("/").permitAll()
//                .antMatchers("/*").hasRole("USER")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/success");


//        http.csrf().disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .antMatchers("/addDress","/allDresses","/update/*").hasRole("ADMIN")
//                .antMatchers("/cart/*").hasRole("USER")
//                .antMatchers("/").permitAll()
//                .and().formLogin().loginPage("/login").defaultSuccessUrl("/success");



 //       .authorizeRequests()
//                .antMatchers("/", "/home","/registration").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
