package com.festuskerich.graphqlspringboot.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.festuskerich.graphqlspringboot.models.Country;
import com.festuskerich.graphqlspringboot.service.CountriesService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/countries")
public class CountriesController {

    private final CountriesService countriesService;

    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @GetMapping("/")
    ResponseEntity<Mono<List<Country>>> getCounreies(){
        return ResponseEntity.ok(countriesService.getCountries());  
    }
    
}
