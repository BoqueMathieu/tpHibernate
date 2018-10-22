package com.nsis.util;

import com.nsis.bean.CityBean;
import com.nsis.bean.PersonBean;
import com.nsis.bo.City;
import com.nsis.bo.Person;
import com.nsis.dto.CityDTO;
import com.nsis.dto.PersonDTO;
import com.nsis.service.PersonService;

public class ChangeLayer {
	

	/**
	 * 
	 * @param cityDTO
	 * @return City
	 */
	public City City(CityDTO cityDTO) {
		City City = new City();
		City.setIdCity(cityDTO.getIdCity());
		City.setName(cityDTO.getName());
		City.setMayor(cityDTO.getMayor());
		City.setInHabitants(cityDTO.getInHabitants());
		City.setPostalCode(cityDTO.getPostalCode());
		for (PersonDTO personDTO : cityDTO.getPersonnes()) {
			PersonService PersonService = new PersonService();
			Person Person = new Person();
			Person = PersonService.Person(personDTO);
			City.ajouterPersonne(Person);
		}
		return City;
	}
/**
 * 
 * @param City
 * @return CityDTO
 */
	public CityDTO createDTO(City City) {
		CityDTO CityDto = new CityDTO();
		CityDto.setIdCity(City.getIdCity());
		CityDto.setName(City.getName());
		CityDto.setMayor(City.getMayor());
		CityDto.setInHabitants(City.getInHabitants());
		CityDto.setPostalCode(City.getPostalCode());
		for (Person person : City.getPersonnes()) {
			PersonService PersonService = new PersonService();
			PersonDTO PersonDTO = new PersonDTO();
			PersonDTO = PersonService.PersonDTO(person);
			CityDto.ajouterPersonne(PersonDTO);
		}
		return CityDto;
	}
/**
 * 
 * @param CityDTO
 * @return CityBean
 */
	public CityBean createBean(CityDTO CityDTO) {
		CityBean CityBean = new CityBean();
		CityBean.setIdCity(CityDTO.getIdCity());
		CityBean.setName(CityDTO.getName());
		CityBean.setMayor(CityDTO.getMayor());
		CityBean.setInHabitants(CityDTO.getInHabitants());
		CityBean.setPostalCode(CityDTO.getPostalCode());
		for (int i = 0; i < CityDTO.getPersonnes().size(); i++) {
			PersonService PersonService = new PersonService();
			PersonBean PersonBean = new PersonBean();
			PersonBean = PersonService.PersonBean((CityDTO.getPersonnes().get(i)));
			CityBean.ajouterPersonne(PersonBean);

		}
		return CityBean;
	}

}
