package com.nsis.dto;
/**
 * 
 * @author Mathieu Boqué
 * Mail: mathieuboque@hotmail.com
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.nsis.bean.PersonBean;

public class CityDTO {
	//Attributs de classe
	int idCity;
	String name;
	String mayor;
	int inHabitants;
	int postalCode;
	List<PersonDTO> personnes = new ArrayList<PersonDTO>();
	public CityDTO() {
		
	}
	/**
	 * 
	 * @param name
	 * @param mayor
	 * @param inHabitants
	 * @param postalCode
	 * Constructeur
	 */
	public CityDTO( String name, String mayor, int inHabitants, int postalCode) {
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
	public CityDTO(int id, String name, String mayor, int inHabitants, int postalCode) {
		this.idCity=id;
		this.name = name;
		this.mayor = mayor;
		this.inHabitants = inHabitants;
		this.postalCode = postalCode;
	}
	/**
	 * 
	 * @param person
	 * entre une personne dans la liste de personne en attribut
	 */
	public void ajouterPersonne(PersonDTO person) {
		this.personnes.add(person);
	}
	/**
	 * 
	 * @return une lsite de personne
	 */
	public List<PersonDTO> getPersonnes() {
		return personnes;
	}
	/**
	 * 
	 * @param personnes
	 * modifie la liste de personnes
	 */
	public void setPersonnes(List<PersonDTO> personnes) {
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
	 * modifie le nombre de personne par ville
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
	

}