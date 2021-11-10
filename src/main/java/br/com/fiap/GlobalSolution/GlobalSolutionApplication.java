package br.com.fiap.GlobalSolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GlobalSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalSolutionApplication.class, args);
	}
}
