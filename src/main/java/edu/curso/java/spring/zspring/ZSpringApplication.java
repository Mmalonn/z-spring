package edu.curso.java.spring.zspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ZSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZSpringApplication.class, args);
		System.out.println("Api funcionando");
	}

}
