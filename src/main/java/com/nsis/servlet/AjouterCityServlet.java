package com.nsis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsis.bo.City;
import com.nsis.exception.PersonDAOException;
import com.nsis.service.CityService;

/**
 * Servlet implementation class PersonServlet
 */
public class AjouterCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterCityServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		boolean result = false;
		String nom = request.getParameter("nom");
		String maire = request.getParameter("maire");
		int nbHabitants = Integer.parseInt(request.getParameter("nbHabitants"));
		int codePostal = Integer.parseInt(request.getParameter("codePostal"));

		CityService cityService = new CityService();
		if (!nom.isEmpty() && !maire.isEmpty() && nbHabitants > -1 && codePostal > -1) {
			City city = new City(nom,maire,nbHabitants,codePostal);
			try {
				result = cityService.insertCity(city);
			} catch (PersonDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("resultat", result);

			request.getRequestDispatcher("AjoutCity.jsp").forward(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

}
