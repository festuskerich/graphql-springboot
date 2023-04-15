package com.festuskerich.graphqlspringboot.service;

import java.util.List;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;

import com.festuskerich.graphqlspringboot.models.Country;

import reactor.core.publisher.Mono;
@Service
public class CountriesServiceImp implements CountriesService{

    private final HttpGraphQlClient graphQlClient;

    public CountriesServiceImp(HttpGraphQlClient graphQlClient) {
        this.graphQlClient = graphQlClient;
    }

    @Override
    public Mono<List<Country>> getCountries() {
        String document = """
            query {
                countries {
                  name
                  emoji
                  currency
                  code
                  capital
                }
            }
            """;
            return graphQlClient.document(document)
                    .retrieve("countries")
                    .toEntityList(Country.class);
        }
    
}
