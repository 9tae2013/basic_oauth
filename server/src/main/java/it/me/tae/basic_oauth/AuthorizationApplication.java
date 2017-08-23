package it.me.tae.basic_oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


@EnableAuthorizationServer
@SpringBootApplication
public class AuthorizationApplication {

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("dave").password("secret").authorities("ROLE_USER")
                .and()
                .withUser("tae").password("secret").authorities("ROLE_USER", "ROLE_ADMIN");
    }


    public static void main(String[] args) {
        SpringApplication.run(AuthorizationApplication.class, args);
    }
}