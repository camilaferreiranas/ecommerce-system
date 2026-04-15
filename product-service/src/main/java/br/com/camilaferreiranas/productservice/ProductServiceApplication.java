package br.com.camilaferreiranas.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ProductServiceApplication.class, args);
        Environment env = ctx.getEnvironment();

        System.out.println(">>> MONGO URI: " + env.getProperty("spring.data.mongodb.uri"));
    }
    }


