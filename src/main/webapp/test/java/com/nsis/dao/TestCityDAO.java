package com.nsis.dao;

import java.util.Iterator;

import com.nsis.bean.CityBean;
import com.nsis.bo.City;
import com.nsis.bo.Person;
import com.nsis.dao.CityDAO;
import com.nsis.dto.CityDTO;
import com.nsis.dto.PersonDTO;
import com.nsis.exception.PersonDAOException;
import com.nsis.service.CityService;
import com.nsis.util.HibernateUtil;

import junit.framework.TestCase;

public class TestCityDAO extends TestCase{
	
	public void testHibernateConfiguration() {
		HibernateUtil.currentSession();
	}
	
	public void testGetAllPersonnesById() {
		CityDAO citydao = new CityDAO();

		try {
			citydao.openConnect();
			City city = citydao.getAllPersonnesByCity("ville2");
			assertNotNull(city);
			assertNotNull(city.getPersonnes());
			
			for (Person person : city.getPersonnes()) {
				assertNotNull(person);
				assertNotNull(person.getFirstName());
			}
			citydao.closeConnect();
		} catch (PersonDAOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	public void testGetIdCity() {
		CityDAO citydao = new CityDAO();
		citydao.openConnect();
		int idCity = citydao.getIdCity("ville1");
		System.out.println(idCity);
		assertEquals(162,idCity);
		citydao.closeConnect();
		
	}
	public void testGetCity() {
		CityDAO citydao = new CityDAO();
		citydao.openConnect();
		City city = citydao.findCityByNameMayor("amsterdam", "louis");
		System.out.println(city.getIdCity());
		assertEquals(1,city.getIdCity());
		citydao.closeConnect();
		
	}
	
	/*public void testUpdateCity() {
		CityDAO citydao = new CityDAO();
		City city = new City();
		
		try {
			citydao.openConnect();
			int result = citydao.updateCity(city);
			assertEquals(result, 1);
		} catch (PersonDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		citydao.closeConnect();
	}*/
	
	
	

}
