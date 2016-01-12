package de.ratunes.auth;


import dao.AlbumDAO;
import dao.SongDAO;
import dao.UserDAO;
import mvc.model.Album;
import mvc.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    public static final int lengthOfInactivity = 30*60; // 30 min
    private static final long serialVersionUID = 1L;
    public static String requestParameterUsername= "username";
    public static String requestParameterPassword = "password";

    public LoginController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter(requestParameterUsername));
        user.setPassword(request.getParameter(requestParameterPassword));
        UserDAO userDAO = new UserDAO();


        try {
            if (userDAO.checkLogin(user)){

                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(lengthOfInactivity);
                getServletConfig().getServletContext().getRequestDispatcher("/view/RaTunesCreateAlbum.jsp").forward(request,response);
            } else {
                getServletConfig().getServletContext().getRequestDispatcher("/view/RaTunesRegistration.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
