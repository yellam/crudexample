package com.cashapona.crudexample;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CrudexampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CrudexampleApplication.class, args);
	}

}
