package com.lunatech.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lunatech.poc.model.AirportType;

public interface AirportTypeRepository extends JpaRepository<AirportType, Long> {

}
