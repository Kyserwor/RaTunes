package de.ratunes.auth;

import dao.UserDAO;
import mvc.main.Main;
import mvc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String requestParameterUsername		 = "usernamesignup";
	public static String requestParameterEmail 		     = "emailsignup";
	public static String requestParameterPassword	 	 = "passwordsignup";
	public static String requestParameterPasswordConfirm = "passwordsignup_confirm";

	public RegistrationController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		User user = new User();
		user.setName(request.getParameter(requestParameterUsername));
		user.setEmail(request.getParameter(requestParameterEmail));
		user.setPassword(request.getParameter(requestParameterPassword));

		UserDAO userDAO = new UserDAO();
		try {
			userDAO.addNewUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("new user has been added in DB.");
		getServletConfig().getServletContext().getRequestDispatcher("/view/RaTunesRegistration.jsp").forward(request,response);

	}



}
