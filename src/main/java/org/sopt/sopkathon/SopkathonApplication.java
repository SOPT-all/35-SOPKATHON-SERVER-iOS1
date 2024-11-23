package org.sopt.sopkathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SopkathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SopkathonApplication.class, args);
    }

}
