package com.br.test.exercise2;

import com.br.app.exercise2.service.CountryService;
import org.junit.Assert;
import org.junit.Test;

public class TestCountries {
    private final CountryService countryService;

    public TestCountries() {
        this.countryService = new CountryService();
    }

    @Test
    public void validateCountryCounter() {
        Assert.assertEquals(6, countryService.countCountries());
    }

    @Test
    public void validateMostLanguagesThatSpeakGerman() {
        Assert.assertTrue("BE".equalsIgnoreCase(countryService.getCountryWithMostLanguagesThatSpeakGerman().getCountry()));
    }

    @Test
    public void validateCountOfOfficialLanguagesByCountries() {
        Assert.assertEquals(6, countryService.countOfficialLanguages());
    }

    @Test
    public void validateCountryWithMostSpokenLanguages() {
        Assert.assertTrue("BE".equalsIgnoreCase(countryService.getCountryHighestNumberOfLanguages().getCountry()));
    }

    @Test
    public void validateMostCommonLanguage() {
        Assert.assertTrue("de".equalsIgnoreCase(countryService.getMostCommonLanguage()));
    }

}
