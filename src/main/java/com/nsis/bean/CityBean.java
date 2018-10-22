package com.nsis.bean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.nsis.bo.Person;
import com.nsis.dto.CityDTO;
import com.nsis.dto.PersonDTO;
/**
 * 
 * @author Mathieu Boqué
 * Mail: mathieuboque@hotmail.com
 *
 */
public class CityBean {
	//Attributs de classe
	int idCity;
	String name;
	String mayor;
	int inHabitants; 
	int postalCode;
	Set<PersonBean> personnes = new HashSet<PersonBean>();
	public CityBean() {
		
	}
	/**
	 * 
	 * @param name
	 * @param mayor
	 * @param inHabitants
	 * @param postalCode
	 * Constructeur
	 */
	public CityBean( String name, String mayor, int inHabitants, int postalCode) {
		this.name = name;
		this.mayor = mayor;
		this.inHabitants = inHabitants;
		this.postalCode = postalCode;
	}
	/**
	 * 
	 * @param id
	 * @param name
	 * @param mayor
	 * @param inHabitants
	 * @param postalCode
	 * Constructeur surcharger
	 */
	public CityBean(int id, String name, String mayor, int inHabitants, int postalCode) {
		this.idCity=id;
		this.name = name;
		this.mayor = mayor;
		this.inHabitants = inHabitants;
		this.postalCode = postalCode;
	}
	/**
	 * 
	 * @param person
	 * entre une personne dans la liste de personnes en attribut
	 */
	public void ajouterPersonne(PersonBean person) {
		this.personnes.add(person);
	}
	/**
	 * 
	 * @return une liste de personnes
	 */
	public Set<PersonBean> getPersonnes() {
		return personnes;
	}
	/**
	 * 
	 * @param personnes
	 * modifie la liste de personnes
	 */
	public void setPersonnes(Set<PersonBean> personnes) {
		this.personnes = personnes;
	}
	/**
	 * 
	 * @return l'id de la ville
	 */
	public int getIdCity() {
		return idCity;
	}
	/**
	 * 
	 * @param idCity
	 * modifie l'id de la ville
	 */
	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}
	/**
	 * 
	 * @return le nom de la ville
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 * modifie le nom de la ville
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return le nom du maire
	 */
	public String getMayor() {
		return mayor;
	}
	/**
	 * 
	 * @param mayor
	 * modifie le nom du maire
	 */
	public void setMayor(String mayor) {
		this.mayor = mayor;
	}
	/**
	 * 
	 * @return le nombre de personne
	 */
	public int getInHabitants() {
		return inHabitants;
	}
	/**
	 * 
	 * @param inHabitants
	 * modifie le nombre de personnes par ville
	 */
	public void setInHabitants(int inHabitants) {
		this.inHabitants = inHabitants;
	}
	/**
	 * 
	 * @return le code postale de ville
	 */
	public int getPostalCode() {
		return postalCode;
	}
	/**
	 * 
	 * @param postalCode
	 * modifie le cp de la ville
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * Permet de passez d'une ville DTO à une ville Bean
	 * @param citiesDTO
	 */
	public void CityDTOToCityBean(List<CityDTO> citiesDTO) {
			for (CityDTO cityDTO : citiesDTO) {
				this.setName(cityDTO.getName());
				this.setMayor(cityDTO.getMayor());
				this.setInHabitants(cityDTO.getInHabitants());
				this.setPostalCode(cityDTO.getPostalCode());
				for (PersonBean person : this.getPersonnes()) {
					for (PersonDTO person2 : cityDTO.getPersonnes()) {
						person.setFirstName( person2.getFirstName());
						person.setLastName( person2.getLastName());
						person.setMail( person2.getMail());
						person.setPhone( person2.getPhone());
					}
					
				}
			}
			
			

		}
		
	}
	
	


