package com.restmvc.service;

import com.restmvc.model.Country;
import com.restmvc.repository.CountryRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

  @Autowired private CountryRepository countryRepository;

  public void setCountryRepository(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  public Country getCountry(String countryCode) {
    Optional<Country> optionalCountry = countryRepository.findById(countryCode);
    return optionalCountry.orElse(null);
  }
}
