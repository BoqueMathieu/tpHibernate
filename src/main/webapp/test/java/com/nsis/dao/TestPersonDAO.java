package com.nsis.dao;

import java.util.List;

import com.nsis.bo.Person;
import com.nsis.dto.PersonDTO;
import com.nsis.exception.PersonDAOException;

import junit.framework.TestCase;

public class TestPersonDAO extends TestCase {
	/*
	 * public void testInsertOK() { PersonDAO personDAO=new PersonDAO(); Person
	 * person = new Person(1,"jean","jean","jean","jean"); try {
	 * personDAO.openConnect(); personDAO.insertPerson(person);
	 * System.out.println(personDAO.insertPerson(person));
	 * assertTrue(personDAO.insertPerson(person)==true); personDAO.closeConnect(); }
	 * catch (PersonDAOException e) { // TODO Auto-generated catch block
	 * e.getMessage(); e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * public void testDelete() { PersonDAO personDAO = new PersonDAO();
	 * 
	 * try { personDAO.openConnect();
	 * 
	 * Person person = personDAO.findByNames("jean", "jean");
	 * 
	 * 
	 * personDAO.deletePerson(person); personDAO.closeConnect();
	 * 
	 * } catch (PersonDAOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	public void testGetAllPerson() {
		PersonDAO personDAO = new PersonDAO();

		try {
			personDAO.openConnect();

			List<PersonDTO> persondto = personDAO.getAllPerson();

			assertNotNull(persondto);
			personDAO.closeConnect();
		} catch (PersonDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testGetAllPersonByFamilyName() {
		PersonDAO personDAO = new PersonDAO();

		try {
			personDAO.openConnect();

			List<PersonDTO> persondto = personDAO.getFamilyPerson("jean");

			assertNotNull(persondto);
			personDAO.closeConnect();
		} catch (PersonDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testUpdateCityOfPerson() {
		PersonDAO personDAO = new PersonDAO();

		try {
			personDAO.openConnect();
			Person person = new Person(343, "jean", "jean", "jean", "jean");
			
			personDAO.updateIdCity(person, 149);
			personDAO.closeConnect();
		} catch (PersonDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
