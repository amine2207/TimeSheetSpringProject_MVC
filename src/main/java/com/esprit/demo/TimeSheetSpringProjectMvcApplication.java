package com.esprit.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class TimeSheetSpringProjectMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeSheetSpringProjectMvcApplication.class, args);
	}

}
