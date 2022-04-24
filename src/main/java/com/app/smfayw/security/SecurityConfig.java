package com.app.smfayw.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder=passwordEncoder();
        /*auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("0000")).roles("USER");
        auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1111")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("ADMIN","USER");*/
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as credentials, active  from user where username=?")
                .authoritiesByUsernameQuery("select users_username as principal , roles_nom_role as role from role_users where users_username=?")
                .rolePrefix("ROLE_")
                .passwordEncoder(passwordEncoder);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").permitAll();
        http.logout().logoutSuccessUrl("/Accueil");
        http.authorizeRequests().antMatchers("/","/Accueil").permitAll();
        http.authorizeRequests().antMatchers("/Admin/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/User/**").hasRole("USER");
        http.authorizeRequests().antMatchers("/webjars/**","/css/**","/img/**").permitAll();
        http.csrf().disable();
        http.authorizeRequests().anyRequest().authenticated();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
