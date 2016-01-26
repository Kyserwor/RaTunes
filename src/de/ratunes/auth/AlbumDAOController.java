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

        List<Album> albums = new ArrayList<>();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Album album = new AlbumDAO().getAlbumById(1);

        try{
            Gson g = new Gson();
            Album album1 = g.fromJson(String.valueOf(jsonObject), Album.class);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }


        String wsqDFWeadfh = "safsdfsdfsd";

//        for (int counter = 0; counter < albums.size(); counter++){
//            albumDAO.addAlbum(albums.get(counter), user);
//        }


    }
}