package com.julio.country.controller;

import com.julio.country.domain.Country;
import com.julio.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping
    public List<Country> findAll(){
        return service.allCountries();
    }

    @GetMapping("/name/{name}")
    public List<Country> findByName(@PathVariable String name){
        return service.countryByName(name).block();
    }
    @GetMapping("/translation/{name}")
    public List<Country> findByNameTranslate(@PathVariable String name){
        return service.countryByNameTranslate(name).block();
    }
}
