package com.br.app.exercise2.service;

import com.br.app.exercise2.domain.Country;
import com.br.app.exercise2.repository.CountryRepository;

import java.io.IOException;
import java.util.*;

public class CountryService {
   CountryRepository countryRepository = null;
    public CountryService(){
        try {
            countryRepository = new CountryRepository();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long countCountries(){
        return this.countryRepository.getCountries().stream().count();
    }

    public Country getCountryWithMostLanguagesThatSpeakGerman(){
        List<Country> countriesThatSpeakGerman = this.countryRepository.getCountries().stream().filter(
                country -> country.getLanguages().contains("de")).toList();
        final Country countryWithMostLanguages = new Country();
        final int maxLanguages = 0;
        int languages = 0;
        countriesThatSpeakGerman.stream().reduce((a, b) -> {
            if (a.getLanguages().stream().count() > b.getLanguages().stream().count()){
                countryWithMostLanguages.setCountry( a.getCountry());
                countryWithMostLanguages.setLanguages(a.getLanguages());
            }
            return a;
        });
        return  countryWithMostLanguages;
    }

    public long countOfficialLanguages() {
        final List<String> officialLanguages = new ArrayList<String>();
        this.countryRepository.getCountries().stream().forEach(country -> {
            officialLanguages.addAll(country.getLanguages());
        });
        return officialLanguages.stream().distinct().count();
    }

    public Country getCountryHighestNumberOfLanguages(){
        final Country countryWithMostLanguages = new Country();
        this.countryRepository.getCountries().stream().reduce((a, b) -> {
            if (a.getLanguages().stream().count() > b.getLanguages().stream().count()){
                countryWithMostLanguages.setCountry( a.getCountry());
                countryWithMostLanguages.setLanguages(a.getLanguages());
                return a;
            }
            else if (a.getLanguages().stream().count() < b.getLanguages().stream().count()) {
                countryWithMostLanguages.setCountry( b.getCountry());
                countryWithMostLanguages.setLanguages(b.getLanguages());
                return b;
            }
            else
            {
                return a;
            }
        });
        return countryWithMostLanguages;
    }

    public String getMostCommonLanguage(){
        final List<String> officialLanguages = new ArrayList<String>();
        final HashMap<String, Integer> languagesPerQuantityOfCountries = new HashMap<String, Integer>();
        this.countryRepository.getCountries().stream().forEach(country -> {
            officialLanguages.addAll(country.getLanguages());
        });
        officialLanguages.stream().forEach( str -> {
         if (languagesPerQuantityOfCountries.isEmpty() || languagesPerQuantityOfCountries.get(str) == null ){
            languagesPerQuantityOfCountries.put(str,1);
         }
         else if(languagesPerQuantityOfCountries.get(str) != null){
             languagesPerQuantityOfCountries.put(str, languagesPerQuantityOfCountries.get(str)+ 1);
         }
        });
        int numberOfCountries = 0;
        String mostCommonLanguage = "";
        for (Map.Entry<String, Integer> entry: languagesPerQuantityOfCountries.entrySet() ) {
            if (numberOfCountries < entry.getValue()){
                numberOfCountries = entry.getValue();
                mostCommonLanguage = entry.getKey();
            }
        }
        return mostCommonLanguage;
    }

}
