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

import com.lunatech.poc.pojo.CountryAirport;
import com.lunatech.poc.pojo.CountryRunwayType;
import com.lunatech.poc.repository.CountryRepository;
import com.lunatech.poc.util.ReturnPath;

@Controller
public class ReportController {

	@Autowired
	private CountryRepository countryRepository;

	@GetMapping(path = "/report")
	public String report(Model model) {
		Map<String, List<?>> reportMap = new HashMap<>();
		reportMap.put("HighestAirports", getHighestAirportList());
		reportMap.put("LowestAirports", getLowestAirportList());
		reportMap.put("CountryRunwayType", getCountryRunwayTypeList());
		model.addAttribute("reports", reportMap);
		return ReturnPath.REPORT_PAGE;
	}

	private List<CountryRunwayType> getCountryRunwayTypeList() {
		return countryRepository.getCountryRunways();
	}

	private List<CountryAirport> getHighestAirportList() {
		Pageable pageable = PageRequest.of(0, 10, JpaSort.unsafe(Sort.Direction.DESC, "count(airports) "));
		List<CountryAirport> countryAirportList = (List<CountryAirport>) countryRepository
				.getCountryByAirportCount(pageable);
		return countryAirportList;
	}

	private List<CountryAirport> getLowestAirportList() {
		Pageable pageable = PageRequest.of(0, 10, JpaSort.unsafe(Sort.Direction.ASC, "count(airports) "));
		List<CountryAirport> countryAirportList = (List<CountryAirport>) countryRepository
				.getCountryByAirportCount(pageable);
		return countryAirportList;
	}

}
