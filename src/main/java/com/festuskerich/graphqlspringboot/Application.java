package com.festuskerich.graphqlspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	HttpGraphQlClient graphQlClient(){
		var eClient=WebClient.builder()
		.baseUrl("https://countries.trevorblades.com")
		.build();
		return HttpGraphQlClient.builder(eClient)
		.build();
	}
}
