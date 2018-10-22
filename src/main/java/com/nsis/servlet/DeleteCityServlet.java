package com.nsis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsis.dto.CityDTO;
import com.nsis.exception.PersonDAOException;
import com.nsis.service.CityService;

/**
 * Servlet implementation class DeletePersonServlet
 */
public class DeleteCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCityServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String maire = request.getParameter("maire");
		CityService CityService = new CityService();
		 if(!nom.isEmpty() && !maire.isEmpty()) {
			 
			try {
				 CityDTO cityDTO = CityService.selectCity(nom, maire);
				 CityService.deleteCity(cityDTO);
			} catch (PersonDAOException e1) {
				e1.printStackTrace();
			}
			// Envoie les informations à la jsp
             request.getRequestDispatcher("DeleteCity.jsp").forward(request,response);    
		 }
		 else {
			 response.sendRedirect("index.html");
		 }
		 
	}
	

}
