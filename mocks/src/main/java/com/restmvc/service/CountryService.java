package com.restmvc.service;

import com.restmvc.model.Country;

public interface CountryService {
  Country getCountry(String countryCode);
}
