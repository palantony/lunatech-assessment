package com.lunatech.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lunatech.poc.model.Airport;
import com.lunatech.poc.pojo.CountryAirport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

	@Query("select airport  from Airport airport where LOWER(airport.country.countryCode) = LOWER(:countryCode)")
	List<Airport> getAirportByCountryCode(String countryCode);
	
}
