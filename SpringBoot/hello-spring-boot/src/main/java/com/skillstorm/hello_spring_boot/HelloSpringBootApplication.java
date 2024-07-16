package com.skillstorm.hello_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication is a combo of three annotations:
 * 
 * @Configuration - Specifies that a class will be a configuration class. A
 * class with this annotation has beans that Spring needs to manage
 * 
 * @ComponentScan - Searches your pakcage for any class annotated
 * with @Component and make beans for those components
 * 
 * @EnableAutoConfiguration - Tells Spring Boot to auto-configure the
 * application context with things we need, like a server or a web app.
 */

@SpringBootApplication
public class HelloSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}

}
