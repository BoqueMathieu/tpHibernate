package com.nsis.service;


import com.nsis.bo.Person;
import com.nsis.dao.PersonDAO;
import com.nsis.dto.CityDTO;
import com.nsis.dto.PersonDTO;
import com.nsis.exception.PersonDAOException;
import com.nsis.bean.PersonBean;

public class PersonService {
	PersonDAO personDAO = new PersonDAO();
	
	public boolean insertOk(Person person) throws PersonDAOException {
		openConnect();
		boolean result = personDAO.insertPerson(person);
		closeConnect();
        if (result != false)
              
                    return result;
              
        else
              throw new PersonDAOException("Identifiant inconnu");
  
  }
	public PersonDTO selectPerson(String firstName,String lastName) throws PersonDAOException {
		openConnect();
		Person person = personDAO.findByNames(firstName, lastName);
		PersonDTO personDTO = PersonDTO(person);
		closeConnect();
        if (personDTO != null)
              
                    return personDTO;
              
        else
              throw new PersonDAOException("Identifiant inconnu");
  
  }
	public int updatePerson(PersonDTO personDTO) throws PersonDAOException {
		openConnect();
		Person person = Person(personDTO);
		int result = personDAO.updatePerson(person);
		closeConnect();
        if (result != 0)
             return   result;     
              
        else
              throw new PersonDAOException("Identifiant inconnu");
  
  }
	public void deletePerson(PersonDTO personDTO) throws PersonDAOException {
		openConnect();
		Person person = Person(personDTO);
		personDAO.deletePerson(person);
		closeConnect();
  }
	public PersonBean PersonBean(PersonDTO personDto) {
		PersonBean PersonBean = new PersonBean();
		PersonBean.setIdPersonne(personDto.getIdPersonne());
		PersonBean.setFirstName(personDto.getFirstName());
		PersonBean.setLastName(personDto.getLastName());
		PersonBean.setMail(personDto.getMail());
		PersonBean.setPhone(personDto.getPhone());
		return PersonBean;
	}
	public PersonDTO PersonDTO(Person person) {
		PersonDTO PersonDTO = new PersonDTO();
		PersonDTO.setIdPersonne(person.getIdPersonne());
		PersonDTO.setFirstName(person.getFirstName());
		PersonDTO.setLastName(person.getLastName());
		PersonDTO.setMail(person.getMail());
		PersonDTO.setPhone(person.getPhone());
		return PersonDTO;
	}
	public Person Person(PersonDTO PersonDTO) {
		Person Person = new Person();
		Person.setIdPersonne(PersonDTO.getIdPersonne());
		Person.setFirstName(PersonDTO.getFirstName());
		Person.setLastName(PersonDTO.getLastName());
		Person.setMail(PersonDTO.getMail());
		Person.setPhone(PersonDTO.getPhone());
		return Person;
	}
	private void openConnect() {
		personDAO.openConnect();
	}
	
	private void closeConnect() {
		personDAO.closeConnect();
	}

}
