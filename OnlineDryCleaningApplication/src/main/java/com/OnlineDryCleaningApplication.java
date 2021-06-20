package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication

public class OnlineDryCleaningApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineDryCleaningApplication.class, args);
		System.out.println("Connected to ONLINE DRY CLEANING ");
	}
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.rest")).build();
	   }
	
	//http://localhost:8089/swagger-ui/index.html
	

}
