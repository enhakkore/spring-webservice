package com.enhakkore.webservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    public void configure(WebSecurity web) throws Exception
//    {
//        web.ignoring().antMatchers("/createMember", "/h2-console/**", "/posts/**");
//    }

    public SecurityConfig(){
        super(true);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").authorities("USER")
                .and()
                .withUser("admin").password("{noop}admin").authorities("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        HttpSessionCsrfTokenRepository repo = new HttpSessionCsrfTokenRepository();
        repo.setSessionAttributeName("csrf_token");
        repo.setParameterName("csrf_token");

        http
                .securityContext()
                    .and()
                .exceptionHandling()
                    .and()
                .servletApi()
                    .and()
                .formLogin()
                    .loginPage("/")
                    .and()
                .logout()
                    .and()
                .csrf().disable();

//        .csrf()
//            .csrfTokenRepository(repo)
//            .and()



//        http.httpBasic();

//        http.authorizeRequests()
//                .antMatchers("/**").hasAnyAuthority("USER")
//                .antMatchers(HttpMethod.DELETE, "/**").hasAnyAuthority("ADMIN")
//                .and()
//                .formLogin().loginPage("/login");


    }
}
