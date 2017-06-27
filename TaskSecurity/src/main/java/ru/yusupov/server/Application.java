package ru.yusupov.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 23.06.2017
 * Application
 *
 * @author Aivar Yusupov
 * @version v0.1
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ru.yusupov.config")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
