package com.restmvc.controller;

import com.restmvc.model.Country;
import com.restmvc.service.CountryService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

  @Autowired private CountryService countryService;

  public void setCountryService(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping("alpha/{countryCode}")
  public Country getCountry(@PathVariable(name = "countryCode") String countryCode) {
    return countryService.getCountry(countryCode.toUpperCase());
  }

  @GetMapping("alpha")
  public List<Country> getCountries(@RequestParam(name = "codes") String queryParameters) {
    List<String> queryParametersList =
        new ArrayList<>(Arrays.asList(queryParameters.split(";")));
    List<Country> results = new ArrayList<>();
    for (String countryCode : queryParametersList) {
      results.add(countryService.getCountry(countryCode.toUpperCase()));
    }
    return results;
  }
}
