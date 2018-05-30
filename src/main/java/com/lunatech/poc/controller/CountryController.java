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
import com.lunatech.poc.util.ReturnPath;

@Controller
public class CountryController {
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private AirportRepository airportRepository;

	@GetMapping(path = "/country")
	public String getAllCountries(Model model) {
		model.addAttribute("country", getCountryList());
		return ReturnPath.COUNTRY_PAGE;
	}

	@GetMapping(path = "/country/{countryCode}")
	public String getAllAirportsByCountryCode(@PathVariable String countryCode, Model model) {
		model.addAttribute("country", getCountryList());
		model.addAttribute("airports", getAirportList(countryCode));
		return ReturnPath.COUNTRY_PAGE;
	}

	private List<Airport> getAirportList(String countryCode) {
		return airportRepository.getAirportByCountryCode(countryCode);
	}

	private List<Country> getCountryList() {
		return countryRepository.getCountryCodeAndName();
	}

}
