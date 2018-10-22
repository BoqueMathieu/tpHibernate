package com.nsis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsis.bo.Person;
import com.nsis.exception.PersonDAOException;
import com.nsis.service.PersonService;

/**
 * Servlet implementation class PersonServlet
 */
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean result = false;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		PersonService PersonService = new PersonService();
		 if(!firstName.isEmpty() && !lastName.isEmpty() && !mail.isEmpty() && !phone.isEmpty()) {
			 Person person = new Person (1,firstName,lastName,mail,phone);
			 try {
				result = PersonService.insertOk(person);
			} catch (PersonDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 request.getSession().setAttribute("resultat", result);
				// Envoie les informations à la jsp

             request.getRequestDispatcher("Ajout.jsp").forward(request,response);    
		 }
		 else {
			 response.sendRedirect("index.html");
		 }
	}

}
