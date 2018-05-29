package com.lunatech.poc.pojo;

public class CountryAirport {

	private String countryName;
	private long airportCount;

	public CountryAirport() {

	}

	public CountryAirport(final String countryName, final long airportCount) {
		this.countryName = countryName;
		this.airportCount = airportCount;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public long getAirportCount() {
		return airportCount;
	}

	public void setAirportCount(long airportCount) {
		this.airportCount = airportCount;
	}

}
