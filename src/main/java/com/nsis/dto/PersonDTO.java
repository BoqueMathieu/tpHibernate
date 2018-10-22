package com.nsis.dto;
/**
 * 
 * @author Mathieu Boqué
 * Mail: mathieuboque@hotmail.com
 *
 */
public class PersonDTO {
	// Attributs de classe
	int idPersonne;
	String firstName;
	String lastName;
	String mail;
	String phone;

	/**
	 * Constructeur
	 */
	public PersonDTO() {

	}

	/**
	 * 
	 * @param idPersonne
	 * @param firstName
	 * @param lastName
	 * @param mail
	 * @param phone
	 *            Constructeur surchargé
	 */
	public PersonDTO(int idPersonne, String firstName, String lastName, String mail, String phone) {
		this.idPersonne = idPersonne;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.phone = phone;
	}

	/**
	 * 
	 * @return retourne l'id de la personne
	 */
	public int getIdPersonne() {
		return idPersonne;
	}

	/**
	 * 
	 * @param idPersonne
	 *            modifie l'id de la personne
	 */
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	/**
	 * 
	 * @return le firstname de la personne
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName
	 *            modifie le firstname de la personne
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return le last de la personne
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 *            modifie le lastname de la personne
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
/**
 * 
 * @return l'attribut email
 */
	public String getMail() {
		return mail;
	}
/**
 * modifie l'attribut email
 * @param mail
 */
	public void setMail(String mail) {
		this.mail = mail;
	}
/**
 * 
 * @return l'attribut phone
 */
	public String getPhone() {
		return phone;
	}
/**
 * modifie l'attribut phone
 * @param phone
 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}

