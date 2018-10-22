package com.nsis.service;

/**
 * 
 * @author Mathieu Boqué
 * Mail: mathieuboque@hotmail.com
 *
 */
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import com.nsis.bean.CityBean;
import com.nsis.bean.PersonBean;
import com.nsis.bo.City;
import com.nsis.bo.Person;
import com.nsis.dao.CityDAO;
import com.nsis.dto.CityDTO;
import com.nsis.dto.PersonDTO;
import com.nsis.exception.PersonDAOException;
import com.nsis.util.ChangeLayer;

public class CityService {
	// attributs de classe
	CityDAO cityDao = new CityDAO();
	ChangeLayer change = new ChangeLayer();

	// Ouvre la connexion grâce au DAO
	private void openConnect() {
		cityDao.openConnect();
	}

	// Ferme la connexion grâce au DAO
	private void closeConnect() {
		cityDao.closeConnect();
	}

	/**
	 * Permet d'inserer une personne dans la base de donée grâce au DAO
	 * 
	 * @param city
	 * @return true si l'insertion est réussite
	 * @throws PersonDAOException
	 */
	public boolean Insert(City city) throws PersonDAOException {
		boolean result = cityDao.insertCity(city);

		// Si l'insertion est réussite on passe ici
		if (result != false)

			return result;
		else
			throw new PersonDAOException("Fail insert");

	}

	/**
	 * Charge une liste de CityDTO grâce au DAO
	 * 
	 * @return
	 * @throws PersonDAOException
	 */
	public List<CityDTO> getAllCity() throws PersonDAOException {
		List<CityDTO> cities = new ArrayList<CityDTO>();
		cityDao.getAllCity();

		return cities;

	}

	/**
	 * Charge une CityDTO grâce au DAO
	 * 
	 * @return
	 * @throws PersonDAOException
	 */
	public CityDTO getAllPersonneByCity(String theCity) throws PersonDAOException {
		openConnect();
		City city = cityDao.getAllPersonnesByCity(theCity);

		if (city != null) {

			CityDTO cityDTO = change.createDTO(city);
			closeConnect();
			return cityDTO;

		}

		else
			throw new PersonDAOException("Aucune personne associée à une ville");

	}
/**
 * Charge les informations d'une ville à partir de la DAO
 * @param nom
 * @param maire
 * @return
 * @throws PersonDAOException
 */
	public CityDTO selectCity(String nom, String maire) throws PersonDAOException {
		openConnect();
		// retourne la ville à partir des arguments en paramètres
		City city = cityDao.findCityByNameMayor(nom, maire);
		if (city != null) {

			CityDTO cityDTO = change.createDTO(city);
			closeConnect();
			return cityDTO;

		}

		else
			throw new PersonDAOException("Aucune ville trouvée");
	}
/**
 * Supprimes uen ville grâce au DAO
 * @param cityDTO
 */
	public void deleteCity(CityDTO cityDTO) {
		// TODO Auto-generated method stub
		openConnect();
		City city = change.City(cityDTO);
		try {
			cityDao.deleteCity(city);
		} catch (PersonDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnect();

	}
/**
 * Modifie une ville grâce au DAO
 * @param cityDTO
 * @return 1 si la modification est réussite
 * @throws PersonDAOException
 */
	public int updateCity(CityDTO cityDTO) throws PersonDAOException {
		int result = 0;
		openConnect();
		City city = change.City(cityDTO);
		// met à jour les informations de la ville
		cityDao.updateCity(city);
		if (city != null) {
			result = 1;
			closeConnect();
			return result;

		}

		else
			throw new PersonDAOException("Ville non mise à jour");

	}
/**
 * Insert une ville grâce au DAO
 * @param city
 * @return true si l'insertion est réussite
 * @throws PersonDAOException
 */
	public boolean insertCity(City city) throws PersonDAOException {
		openConnect();
		boolean result = cityDao.insertCity(city);
		closeConnect();
		if (result != false)

			return result;

		else
			throw new PersonDAOException("Insertion impossible");


	}

	
}
