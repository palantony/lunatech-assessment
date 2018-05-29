package com.lunatech.poc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "airport")
public class Airport extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "airportId")
	@NonNull
	private long id;

	@NonNull
	private String airportCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airportType", referencedColumnName = "airportTypeId")
	@JsonIgnoreProperties("airports")
	private AirportType airportType;

	private String airportName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isoCountry", referencedColumnName = "countryCode")
	 @JsonIgnoreProperties("airports")
	private Country country;
	
	@OneToMany(mappedBy = "airport", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonIgnoreProperties("airport")
	private List<Runway> runways = new ArrayList<>();


	public List<Runway> getRunways() {
		return runways;
	}

	public void setRunways(List<Runway> runways) {
		this.runways = runways;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setAirportType(AirportType airportType) {
		this.airportType = airportType;
	}

	public AirportType getAirportType() {
		return airportType;
	}

}
