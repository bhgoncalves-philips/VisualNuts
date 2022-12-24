package com.br.app.exercise2.repository;

import com.br.app.exercise2.domain.Country;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CountryRepository {

    private List<Country> countries = null;

    public CountryRepository() throws IOException {
        List<Country> countries = this.getCountriesFromFile();
    }
    private List<Country> getCountriesFromFile() throws IOException {
        countries = new ArrayList<Country>();
        String data = new String(Files.readAllBytes(Paths.get("src/com/br/app/exercise2/json/countries.json")));
        JSONArray jsonArray = new JSONArray(data);
        for (int index = 0; index < jsonArray.length(); index++) {
            countries.add(getCountryFromFile(new JSONObject(jsonArray.get(index).toString())));
        }
        return countries;
    }

    private Country getCountryFromFile( JSONObject countryJson){
        Country country = new Country();
        country.setCountry(countryJson.getString("country"));
        country.setLanguages(getCountryLanguagesFromFile(countryJson.getJSONArray("languages")));
        return country;
    }

    private List<String> getCountryLanguagesFromFile(JSONArray languagesJson)
    {
        List<String> countryLanguages = new ArrayList<String>();
        for(int i = 0; i < languagesJson.length(); i++){
            countryLanguages.add(languagesJson.getString(i));
        }
        return countryLanguages;
    }

    public List<Country> getCountries(){
        return countries;
    }
}
