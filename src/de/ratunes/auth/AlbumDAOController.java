package de.ratunes.auth;

import dao.AlbumDAO;
import mvc.model.Album;
import mvc.model.User;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by rlukas on 04.12.2015.
 */
@WebServlet("/AlbumDAOController")
public class AlbumDAOController extends HttpServlet {

    public AlbumDAOController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//          response.setContentType("application/json;charset=utf-8");
//        JSONObject json = new JSONObject();
//        List<Album> albums = new ArrayList<>();
//        Object debugger = request.getParameter("albums");
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        try {
//            albums = (List<Album>) json.get("albumsJson");
//            session.setAttribute("albums", albums);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        AlbumDAO albumDAO = new AlbumDAO();
//        albumDAO.addAlbum((Album) albums, user);
        response.setContentType("application/json, charset=UTF-8");
        PrintWriter out = response.getWriter();
        String code_array = request.getParameter("albums");
        System.out.println("il players_code è: " + code_array);
        String jsonData = code_array;
        JSONObject jsonObject = null;
        try {
            jsonObject.getJSONArray(code_array);
            System.out.println();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);
    }
}