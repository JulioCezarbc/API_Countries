package com.julio.country.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Embedded
    private Name name;
    private List<String> capital;

    @ElementCollection
    @CollectionTable(name = "country_continents", joinColumns = @JoinColumn(name = "country_id"))
    private Set<String> continents;

    @ElementCollection
    @CollectionTable(name = "country_currencies", joinColumns = @JoinColumn(name = "country_id"))
    private Map<String, Currency> currencies;

    private String demonym;

    @ElementCollection
    @CollectionTable(name = "country_languages", joinColumns = @JoinColumn(name = "country_id"))
    private Map<String, String> languages;

    private Integer population;

    @ElementCollection
    @CollectionTable(name = "country_timezones", joinColumns = @JoinColumn(name = "country_id"))
    private Set<String> timezones;


    public Country(){}


    @Embeddable
    public static class Name{
        private String common;
        private String official;
    }

    @Embeddable
    public static class Currency{
        private String code;
        private String name;
        private String symbol;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public Set<String> getContinents() {
        return continents;
    }

    public void setContinents(Set<String> continents) {
        this.continents = continents;
    }

    public Map<String, Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, Currency> currencies) {
        this.currencies = currencies;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demomym) {
        this.demonym = demomym;
    }


    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Set<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(Set<String> timezones) {
        this.timezones = timezones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
