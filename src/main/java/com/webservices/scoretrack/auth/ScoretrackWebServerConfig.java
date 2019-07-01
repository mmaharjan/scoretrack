package com.webservices.scoretrack.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(1) // need to make the Basic http authentication to run before the OAuth2 resource server authentication
public class ScoretrackWebServerConfig extends WebSecurityConfigurerAdapter {

    /** uncomment this method later on in local dev
    @Override
    public void configure(WebSecurity web) throws Exception {
        if(!profile is dev) {
            web.ignoring().anyRequest();
        }
    }
    */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/api/admin/**")
                .authorizeRequests()
                //ROLE will automatically be prepended
                .antMatchers("/v1/game/**").permitAll()
                .anyRequest().hasAnyRole("USER", "SYSTEM_ADMIN", "GROUP_ADMIN" );

        http
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("demo1")
                .password("demo1Pass")
                .roles("SYSTEM_ADMIN");

        auth
                .inMemoryAuthentication()
                .withUser("demo2")
                .password("demo2Pass")
                .roles("USER");
    }
}
