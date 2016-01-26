package de.ratunes.auth;

import com.google.gson.Gson;
import dao.AlbumDAO;
import mvc.model.Album;
import mvc.model.User;
import org.json.JSONArray;
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
        response.setContentType("application/json;charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = new JSONObject(request.getParameter("jsonAlbum"));
            System.out.println(jsonObject);
            } catch (JSONException e) {
            e.printStackTrace();
        }


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Gson g = new Gson();
        Album album = g.fromJson(String.valueOf(jsonObject), Album.class);

        new AlbumDAO().updateAlbum(album);
    }
}