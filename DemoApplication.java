package com.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoApplication {

	
	public static void main(String[] args) {
		
		//SpringApplication.run(DemoApplication.class, args);
		System.out.println("Let's inspect the beans provided by Spring Boot:");
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
	}
}
