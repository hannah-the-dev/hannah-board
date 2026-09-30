package com.hannah.hannahboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HannahBoardApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(HannahBoardApplication.class, args);

        Environment env = context.getEnvironment();

        System.out.println(
                "DATASOURCE URL = " +
                        env.getProperty("spring.datasource.url")
        );

    }

}
