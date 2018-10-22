package com.nsis.dao;
/**
 * 
 * @author Mathieu Boqué
 * Mail: mathieuboque@hotmail.com
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nsis.bo.Person;
import com.nsis.dto.PersonDTO;
import com.nsis.exception.PersonDAOException;
import com.nsis.util.HibernateUtil;

public class PersonDAO {
	private Session session;

	// Ouverture de la connexion
	public void openConnect() {
		session = HibernateUtil.currentSession();

	}

	// Fermeture de la connexion
	public void closeConnect() {
		HibernateUtil.closeSession();
	}

	/**
	 * insert une personne dans la base de données
	 * 
	 * @param person
	 * @return true si la ligne à été inseré
	 * @throws PersonDAOException
	 */
	public boolean insertPerson(Person person) throws PersonDAOException {
		boolean rowInserted = false;
		Transaction tx = session.beginTransaction();

		if (person == null) {
			throw new PersonDAOException("Personne null");

		}

		session.save(person);
		if (session.save(person) != null) {
			rowInserted = true;
		}
		tx.commit();

		return rowInserted;
	}

	/**
	 * Charge la liste de toutes les personnes
	 * 
	 * @return une liste de personne
	 * @throws PersonDAOException
	 */
	public List<PersonDTO> getAllPerson() throws PersonDAOException {
		List<PersonDTO> listPerson = new ArrayList<PersonDTO>();
		Transaction tx = session.beginTransaction();

		// 3 : recupérer la personne écrit en HQL

		Query query = session.createQuery("select p from Person as p ");

		listPerson = query.list();
		// 5 : Fermeture de la transaction
		tx.commit();
		return listPerson;

	}

	/**
	 * Supprime une personne dans la base de données
	 * 
	 * @param person
	 * @throws PersonDAOException
	 */
	public void deletePerson(Person person) throws PersonDAOException {
		if (person.getIdPersonne() == null) {
			throw new PersonDAOException("Identifiant requis");
		}

		Transaction tx = session.beginTransaction();

		session.delete(person);

		tx.commit();

	}

	/**
	 * Trouve une personne à partir de son nom et prénom
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public Person findByNames(String firstName, String lastName) {

		Person person = null;
		Transaction tx = session.beginTransaction();

		// 3 : recupérer la personne écrit en HQL

		Query query = session
				.createQuery("select p from Person as p where p.firstName=:firstName and lastName=:lastName");
		query.setString("firstName", firstName);
		query.setString("lastName", lastName);

		Iterator it = query.iterate();
		while (it.hasNext()) {
			person = (Person) it.next();

		}
		// 5 : Fermeture de la transaction
		tx.commit();
		return person;
	}

	/**
	 * Modifie le champ idCity d'une personne
	 * 
	 * @param person
	 * @param idCity
	 * @return 1 si la mise à jour à été effectué
	 * @throws PersonDAOException
	 */
	public int updateIdCity(Person person, int idCity) throws PersonDAOException {
		if (idCity <= -1) {
			throw new PersonDAOException("idCity négatif");
		}
		if (person == null) {
			throw new PersonDAOException("Personne null");
		}
		Query query = session.createQuery("update Person set id_city = :id_city WHERE id_person =:id_person");
		query.setParameter("id_city", idCity);
		query.setParameter("id_person", person.getIdPersonne());

		int result = query.executeUpdate();
		return result;
	}

	/**
	 * modifie les informations d'une personne
	 * 
	 * @param person
	 * @return 1 si la ligne à été mise à jour
	 * @throws PersonDAOException
	 */
	public int updatePerson(Person person) throws PersonDAOException {

		if (person == null) {
			throw new PersonDAOException("Personne null");
		}
		Query query = session.createQuery(
				"update Person set firstName = :firstName,lastName =:lastName,emails =:emails,phone =:phone WHERE id_person =:id_person");
		query.setParameter("firstName", person.getFirstName());
		query.setParameter("lastName", person.getLastName());
		query.setParameter("emails", person.getMail());
		query.setParameter("phone", person.getPhone());
		query.setParameter("id_person", person.getIdPersonne());
		int result = query.executeUpdate();

		return result;

	}

	/**
	 * Charge une liste de personnes de la même famille
	 * 
	 * @param family
	 * @return une liste de personne de la même famille
	 * @throws PersonDAOException
	 */
	public List<PersonDTO> getFamilyPerson(String family) throws PersonDAOException {
		List<PersonDTO> listPerson = new ArrayList<PersonDTO>();
		Transaction tx = session.beginTransaction();

		// 3 : recupérer la personne écrit en HQL

		Query query = session.createQuery("select p from Person as p where lastName=:lastName");
		query.setString("lastName", family);

		listPerson = query.list();
		// 5 : Fermeture de la transaction
		tx.commit();
		return listPerson;

	}

}