package com.skillstorm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	// @Bean
	// CommandLineRunner commandLineRunner(MovieRepository repository) {
	// return (args) -> {
	// System.out.println(repository.findById(1)); // This causes an issue due to
	// lazy initialization
	// };
	// }
}
