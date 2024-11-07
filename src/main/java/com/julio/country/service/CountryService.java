package com.julio.country.service;

import com.julio.country.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private  WebClient webClient;

    public List<Country> allCountries(){
        return webClient.get()
                .uri("all")
                .retrieve()
                .bodyToFlux(Country.class)
                .collectList()
                .block();
    }

    public Mono<List<Country>> countryByName(String name){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/name/{name}").build(name))
                .retrieve()
                .bodyToFlux(Country.class)
                .collectList();
    }

    public Mono<List<Country>> countryByNameTranslate(String name){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/translation/{name}").build(name))
                .retrieve()
                .bodyToFlux(Country.class)
                .collectList();
    }
}
