package com.nsis.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsis.bean.CityBean;
import com.nsis.bean.PersonBean;
import com.nsis.bo.Person;
import com.nsis.dao.CityDAO;
import com.nsis.dto.CityDTO;
import com.nsis.exception.PersonDAOException;
import com.nsis.service.CityService;
import com.nsis.util.ChangeLayer;

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ville = request.getParameter("ville");
		CityDTO cityDTO = new CityDTO();
		CityBean cityBean = new CityBean();
		ChangeLayer change = new ChangeLayer();
		if (!ville.isEmpty()) {
			CityService cityService = new CityService();
			try {

				cityDTO = cityService.getAllPersonneByCity(ville);
				System.out.println(cityDTO.getPersonnes());

				cityBean = change.createBean(cityDTO);
				System.out.println(cityBean.getPersonnes());
				request.getSession().setAttribute("city", cityBean);

			} catch (PersonDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Envoie les informations à la jsp
			request.getRequestDispatcher("Affiche.jsp").forward(request, response);
		} else {
			// erreur sur l'identifiant ou le mot de passe
			response.sendRedirect("index.html");
		}
	}

}
