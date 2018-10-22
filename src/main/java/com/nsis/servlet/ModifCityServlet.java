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
 * Servlet implementation class ModifPersonServlet
 */
public class ModifCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifCityServlet() {

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
		// TODO Auto-generated method stub
		int result = 0;
		//recuperation des informations entrez par l'utilisateur
		String nom = request.getParameter("nom");
		String maire = request.getParameter("maire");
		String modifNom = request.getParameter("modifNom");
		String modifMaire = request.getParameter("modifMaire");
		int modifNbHabitants = Integer.parseInt(request.getParameter("modifNbHabitants"));
		int modifCP = Integer.parseInt(request.getParameter("modifCP"));
		CityService CityService = new CityService();
		 if(!nom.isEmpty() && !maire.isEmpty()) {
			 
			
			 
			try {
				 CityDTO CityDTO = CityService.selectCity(nom, maire);
				 CityDTO.setName(modifNom);
				 CityDTO.setMayor(modifMaire);
				 CityDTO.setInHabitants(modifNbHabitants);
				 CityDTO.setPostalCode(modifCP);
				 
				result = CityService.updateCity(CityDTO);
			} catch (PersonDAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 request.getSession().setAttribute("resultat", result);
				// Envoie les informations à la jsp

             request.getRequestDispatcher("ModifCity.jsp").forward(request,response);    
		 }
		 else {
			 response.sendRedirect("index.html");
		 }
		 
	}

}
