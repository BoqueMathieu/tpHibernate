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

import com.nsis.bo.City;
import com.nsis.dto.CityDTO;
import com.nsis.exception.PersonDAOException;
import com.nsis.util.HibernateUtil;

public class CityDAO {
	// attribut de classe
	private Session session;

	// Constructeur
	public CityDAO() {
	}

	// Ouverture de la connexion
	public void openConnect() {
		session = HibernateUtil.currentSession();

	}

	// Fermeture de la connexion
	public void closeConnect() {
		HibernateUtil.closeSession();
	}

	/**
	 * 
	 * @param city
	 *            insert dans la base de donnes a partir d'un objet city
	 * @return 1 si l'enregistrement à été insérer
	 * @throws PersonDAOException
	 */
	public boolean insertCity(City city) throws PersonDAOException {
		boolean rowInserted = false;
		Transaction tx = session.beginTransaction();

		if (city == null) {
			throw new PersonDAOException("Personne null");

		}

		session.save(city);
		if (session.save(city) != null) {
			rowInserted = true;
		}
		tx.commit();

		return rowInserted;
	}

	/**
	 * Charge à partir de la base la données la liste de toutes les villes
	 * 
	 * @return une liste de personnes
	 * @throws PersonDAOException
	 */
	public List<CityDTO> getAllCity() throws PersonDAOException {
		List<CityDTO> listCity = new ArrayList<CityDTO>();
		Transaction tx = session.beginTransaction();

		// 3 : recupérer la personne écrit en HQL

		Query query = session.createQuery("select c from City as c ");

		listCity = query.list();
		// 5 : Fermeture de la transaction
		tx.commit();

		return listCity;
	}

	/**
	 * Charge les personnes d'une ville à partir du nom de la ville
	 * 
	 * @param idCity
	 * @return une city
	 * @throws PersonDAOException
	 */
	public City getAllPersonnesByCity(String theCity) throws PersonDAOException {

		City city = null;
		// 1 : Ouverture unité de travail hibernate
		// = openConnect();

		// 2 : Ouverture de la transaction
		Transaction tx = session.beginTransaction();

		// 3 : recupérer la ville et ses personnes associées écrit en HQL

		Query query = session.createQuery("select c from City as c where name=:theCity GROUP BY c.name ");
		query.setString("theCity", theCity);
		Iterator it = query.iterate();
		while (it.hasNext()) {
			city = (City) it.next();
			System.out.println("City: " + city.getName());
		}
		// 5 : Fermeture de la transaction
		tx.commit();

		return city;
	}

	/**
	 * 
	 * @param city
	 * @return 1 si la la ligne à été supprimé
	 * @throws PersonDAOException
	 */
	public int deleteCity(City city) throws PersonDAOException {
		if (city == null) {
			throw new PersonDAOException("Ville null");
		}
		Query query = session.createQuery("DELETE FROM City where id_city =:idCity");
		query.setParameter("idCity", city.getIdCity());
		int result = query.executeUpdate();

		return result;
	}

	/**
	 * Permet de modifier une ville à partir de la ville en paramètre
	 * 
	 * @param city
	 * @return 1 si la ligne est mise à jour
	 * @throws PersonDAOException
	 */
	public int updateCity(City city) throws PersonDAOException {
		Query query = session.createQuery(
				"update City set name = :Name,mayor =:mayor,inhabitants =:inHabitants,postalcode =:postalCode WHERE id_city =:id_city");
		query.setParameter("Name", city.getName());
		query.setParameter("mayor", city.getMayor());
		query.setParameter("inHabitants", city.getInHabitants());
		query.setParameter("postalCode", city.getPostalCode());
		query.setParameter("id_city", city.getIdCity());
		int result = query.executeUpdate();

		return result;
	}

	/**
	 * 
	 * @param nom
	 * @return l'id de la ville
	 */
	public int getIdCity(String nom) {
		City city = null;
		int idCity = 0;
		// 1 : Ouverture unité de travail hibernate
		// = openConnect();

		// 2 : Ouverture de la transaction
		Transaction tx = session.beginTransaction();

		// 3 : recupérer la ville et ses personnes associées écrit en HQL

		Query query = session.createQuery("select c from City as c where c.name=:nom");
		query.setString("nom", nom);
		Iterator it = query.iterate();
		while (it.hasNext()) {
			city = (City) it.next();
			idCity = city.getIdCity();
		}
		// 5 : Fermeture de la transaction
		tx.commit();

		return idCity;
	}

	/**
	 * Charge les informations d'une ville à partir de son nom et de son maire
	 * 
	 * @param nom
	 * @param maire
	 * @return
	 */
	public City findCityByNameMayor(String nom, String maire) {
		City city = null;

		// 1 : Ouverture unité de travail hibernate
		// = openConnect();

		// 2 : Ouverture de la transaction
		Transaction tx = session.beginTransaction();

		// 3 : recupérer la ville et ses personnes associées écrit en HQL

		Query query = session.createQuery("select c from City as c where c.name=:nom and c.mayor=:mayor");
		query.setString("nom", nom);
		query.setString("mayor", maire);
		Iterator it = query.iterate();
		while (it.hasNext()) {
			city = (City) it.next();
		}
		// 5 : Fermeture de la transaction
		tx.commit();

		return city;
	}
}