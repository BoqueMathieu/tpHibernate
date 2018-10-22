package com.nsis.bean;
/**
 * 
 * @author Mathieu Boqué
 * Mail: mathieuboque@hotmail.com
 *
 */
public class PersonBean {
	// Attributs de classe
	int idPersonne;
	String firstName;
	String lastName;
	String mail;
	String phone;

	/**
	 * Constructeur
	 */
	public PersonBean() {

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
	public PersonBean(int idPersonne, String firstName, String lastName, String mail, String phone) {
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
	 * @return le lastname de la personne
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
 * @return l'attribut mail concernant la personne
 */
	public String getMail() {
		return mail;
	}
/**
 * modifie l'attribut mail 
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
