package com.enhakkore.webservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
public class Application {

    public static final String APPLICATION_LOCATION = "spring.config.location="
            + "classpath:application.yml,"
            + "/app/config/spring-webservice/real-application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .properties(APPLICATION_LOCATION)
                .run(args);
    }

}
