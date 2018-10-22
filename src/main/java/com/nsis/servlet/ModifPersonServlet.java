package com.nsis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsis.bean.PersonBean;
import com.nsis.bo.Person;
import com.nsis.dto.PersonDTO;
import com.nsis.exception.PersonDAOException;
import com.nsis.service.PersonService;

/**
 * Servlet implementation class ModifPersonServlet
 */
public class ModifPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifPersonServlet() {
        super();
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String firstNameModif = request.getParameter("modifFirstName");
		String lastNameModif = request.getParameter("modiflastName");
		String mailModif = request.getParameter("modifMail");
		String phoneModif = request.getParameter("modifPhone");
		PersonService PersonService = new PersonService();
		 if(!firstName.isEmpty() && !lastName.isEmpty()) {
			 
			
			 
			try {
				 PersonDTO personDTO = PersonService.selectPerson(firstName, lastName);
				 personDTO.setFirstName(firstNameModif);
				 personDTO.setLastName(lastNameModif);
				 personDTO.setMail(mailModif);
				 personDTO.setPhone(phoneModif);
				 
				result = PersonService.updatePerson(personDTO);
			} catch (PersonDAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 request.getSession().setAttribute("resultat", result);
				// Envoie les informations à la jsp

             request.getRequestDispatcher("ModifPersonne.jsp").forward(request,response);    
		 }
		 else {
			 response.sendRedirect("index.html");
		 }
		 
	}

}
