package com.festuskerich.graphqlspringboot.service;

import java.util.List;


import com.festuskerich.graphqlspringboot.models.Country;

import reactor.core.publisher.Mono;

public interface CountriesService {
public Mono<List<Country>> getCountries();
    
}
