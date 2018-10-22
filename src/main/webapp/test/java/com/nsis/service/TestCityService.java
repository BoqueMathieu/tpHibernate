package com.nsis.service;

import com.nsis.bean.CityBean;
import com.nsis.dto.CityDTO;
import com.nsis.dto.PersonDTO;
import com.nsis.exception.PersonDAOException;

import junit.framework.TestCase;

public class TestCityService extends TestCase {

	public void testGetAllPersonById(){
		CityService cityService = new CityService();
		CityDTO cityDTO;
		try { 
			cityDTO = cityService.getAllPersonneByCity("ville1");
			assertNotNull(cityDTO.getPersonnes());
			assertTrue(cityDTO.getPersonnes().size()>0);
			for (PersonDTO personDTO : cityDTO.getPersonnes()) {
				assertNotNull(personDTO);
			}
		
		} catch (PersonDAOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		

				
	}
}
