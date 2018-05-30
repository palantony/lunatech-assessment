package com.lunatech.poc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lunatech.poc.model.Country;
import com.lunatech.poc.pojo.CountryAirport;
import com.lunatech.poc.pojo.CountryRunwayType;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
	@Query("select country.countryCode , country.countryName from Country country")
	List<Country> getCountryCodeAndName();

	@Query("select new com.lunatech.poc.pojo.CountryAirport(country.countryName, COUNT(airports)) FROM Country country JOIN country.airports airports GROUP BY country.countryName")
	List<CountryAirport> getCountryByAirportCount(Pageable pagable);
	
	@Query(nativeQuery = true,  
			value=  " select  country.countryName countryName,airport.surfaceList runwayType "
					+"  from country country, "
					+" (select airport.isoCountry countryCode,GROUP_CONCAT(distinct(runway.surface) ) surfaceList "
					+" from airport airport, runway runway "
					+" where airport.airportId = runway.airportId "
					+" group by airport.isoCountry) as airport "
					+" where country.countryCode = airport.countryCode " 
					+" Order by country.countryName ASC" )
	List<CountryRunwayType> getCountryRunways();
	
}
