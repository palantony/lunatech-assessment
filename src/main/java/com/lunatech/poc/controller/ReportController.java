package com.lunatech.poc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lunatech.poc.pojo.CountryAirport;
import com.lunatech.poc.pojo.CountryRunwayType;
import com.lunatech.poc.repository.CountryRepository;

@Controller
public class ReportController {

	@Autowired
	private CountryRepository countryRepository;

	public enum SortOrder {
		ASC, DESC
	}

	@GetMapping(path = "/report")
	public String report(Model model) {
		List<CountryAirport> highestAirportList = null;
		List<CountryAirport> leastAirportList = null;
		List<CountryRunwayType> countryRunwayTypeList = null;
		highestAirportList = getCountryByAirportCount(SortOrder.DESC);
		leastAirportList = getCountryByAirportCount(SortOrder.ASC);
		countryRunwayTypeList = countryRepository.getCountryRunways();
		Map<String, List<?>> countryAirportMap = new HashMap<>();
		countryAirportMap.put("HighestAirports", highestAirportList);
		countryAirportMap.put("LowestAirports", leastAirportList);
		countryAirportMap.put("CountryRunwayType", countryRunwayTypeList);
		model.addAttribute("results", countryAirportMap);
		return "report";
	}

	private List<CountryAirport> getCountryByAirportCount(SortOrder sortOrder) {
		Pageable pageable = PageRequest.of(0, 10,
				JpaSort.unsafe(Sort.Direction.valueOf(sortOrder.toString()), "count(airports) "));
		List<CountryAirport> countryAirportList = (List<CountryAirport>) countryRepository
				.getCountryByAirportCount(pageable);
		System.out.println("Object is Empty " + countryAirportList.size());
		return countryAirportList;
	}

}
