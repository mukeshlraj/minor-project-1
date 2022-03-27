package com.jbdl25.minorproject;

import com.jbdl25.minorproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LibraryConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Value("${app.security.admin_role}")
    private String ADMIN_ROLE;

    @Value("${app.security.student_role}")
    private String STUDENT_ROLE;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/book/**").hasAnyAuthority(ADMIN_ROLE,STUDENT_ROLE)
                .antMatchers("/book/**").permitAll()
                .antMatchers(HttpMethod.POST, "/student/**").hasAuthority(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/student/id/**").hasAuthority(ADMIN_ROLE)
                .antMatchers("/student/**").hasAuthority(STUDENT_ROLE)
                .antMatchers("/transaction/**").hasAuthority(STUDENT_ROLE)
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder getPE() {
        return new BCryptPasswordEncoder();
    }
}
