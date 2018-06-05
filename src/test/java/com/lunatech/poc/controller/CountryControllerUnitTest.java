package com.lunatech.poc.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lunatech.poc.model.Country;
import com.lunatech.poc.repository.AirportRepository;
import com.lunatech.poc.repository.CountryRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(CountryController.class)
public class CountryControllerUnitTest {

	@Autowired  
	private MockMvc mvc;
	  
	    @MockBean
	    private CountryRepository countryRepository;
	    
	    @MockBean
	    private AirportRepository airportRepository;
	 
	    
	    private JacksonTester<List<Country>> jsonCountry;

  
    @Before
    public void setUp() throws Exception {
    	JacksonTester.initFields(this, new ObjectMapper());
    	
    }
    
    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
        // given
        given(countryRepository.getCountryCodeAndName())
                .willReturn(populateMockCountryCodeAndName());
        
        

        // when
        MockHttpServletResponse response = mvc.perform(
                get("/country/NL")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isNotNull();

    }

    private List<Country> populateMockCountryCodeAndName() {
		List<Country> countryList = new ArrayList<Country>();
		countryList.add(new Country("NL","Netherlands"));
		countryList.add(new Country("US","United States"));
		return countryList;
	}

	

}