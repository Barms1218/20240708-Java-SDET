package com.skillstorm.hello_spring_boot;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.skillstorm.hello_spring_boot.beans.Vehicle;

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
public class HelloSpringBootApplication implements CommandLineRunner {

	@Autowired // Ask Spring to give us a bean instead of asking app context
	@Qualifier("Camaro") // Tells Spring which bean to give us
	private Vehicle car3;

	public static void main(String[] args) {
		// SpringApplication.run(HelloSpringBootApplication.class, args);

		/*
		 * APPLICATION CONTEXT
		 *  	Starts up your IoC Container where your beans live
		 */

		ApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);

		Vehicle car = (Vehicle) context.getBean("Tesla");
		System.out.println("I'm driving my new  Tesla! WOOO!");
		car.drive();

		Vehicle car2 = (Vehicle) context.getBean("Tesla");
		System.out.println("Car 1: " + car);
		System.out.println("Car 2: " + car2);
	}

	/*
	 * COMMAND LINE RUNNER
	 * 		Has a method that runs after the app context is loaded
	 * 
	 * 		Usually used to perform some setup for an application - like loading data
	 * 
	 * 		Also a functional interface - could be a lambda if desired
	 * 
	 * You no longer have to call context.getBean() - @AutoWired will do taht for you
	 */

	@Override
	public void run(String... args) throws Exception {
		System.out.println(car3);
		System.out.println("I'm driving my new Camaro!");
		car3.drive();
	}

}
