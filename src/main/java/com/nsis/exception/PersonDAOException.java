package com.nsis.exception;
/**
 * 
 * @author Mathieu Boqué
 * Mail: mathieuboque@hotmail.com
 *
 */
import java.sql.SQLException;

public class PersonDAOException extends SQLException {
	String message;
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * 
	 * @param message
	 */
	public PersonDAOException(String message) {
		this.message = message;
	}

	/**
	 * Méthode hériter de la classe Exception
	 */
	@Override
	public String toString() {

		return new String("Erreur base de données");

	}
}
