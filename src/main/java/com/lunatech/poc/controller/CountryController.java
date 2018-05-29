package com.lunatech.poc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lunatech.poc.model.Airport;
import com.lunatech.poc.model.Country;
import com.lunatech.poc.repository.AirportRepository;
import com.lunatech.poc.repository.CountryRepository;

@Controller
public class CountryController {
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private AirportRepository airportRepository;

	@GetMapping(path = "/country")
	public String getAllCountries(Model model) {
		List<Country> countryList = countryRepository.getCountryCodeAndName();
		model.addAttribute("country", countryList);
		return "country";
	}

	@GetMapping(path = "/country/{countryCode}")
	public String getAllAirportsByCountryCode(@PathVariable String countryCode, Model model) {
		List<Airport> airportList = airportRepository.getAirportByCountryCode(countryCode);
		System.out.println("Given Country code " + countryCode);
		System.out.println("Airport list size " + countryCode);
		model.addAttribute("airports", airportList);
		return "country";
	}

}
