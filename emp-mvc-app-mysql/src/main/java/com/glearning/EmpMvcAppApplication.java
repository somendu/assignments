package com.glearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.glearning.*")
//@EntityScan("com.glearning.*")
//@EnableJpaRepositories(basePackages = "com.glearning.*")

public class EmpMvcAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpMvcAppApplication.class, args);
	}

}
