package mvc.main;

import dao.SongDAO;
import mvc.model.Song;

/**
 * Created by rlukas on 04.09.2015.
 */
public class Main {
    public static void main(String[] args) {
       // Controller instanzieren
        Song song;

        SongDAO songDAO = new SongDAO();
        song = songDAO.getSongByID(4);
    }
}
