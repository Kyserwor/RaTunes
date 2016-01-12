package dao; /**
 * Created by rlukas on 04.09.2015.
 */

import dao.DatabaseConnection;
import mvc.model.Album;

import java.awt.*;
import java.sql.SQLException;

public class InputDatabase {
    public static Album album;


    public Image coverImage = null;
    public TextField songText = null;
    public String songTextPath = "";
    public static DatabaseConnection databaseConnection = null;

    public static void main(String[] args) throws SQLException {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connection();
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
    /**
    public void setAlbumArtist() throws SQLException {
        java.util.List<Artist> artists = album.getArtists();
        for (int counter = 0; counter < artists.size(); counter++){
            databaseConnection.setDBQuery("insert into ratunes.artis(name) values('" + artists.get(counter) + "')");
        }
    }

    public void setSongArtist() throws SQLException {
        java.util.List<Song> songs = album.getSongs();
        for (int counter = 0; counter < songs.size(); counter++){
            databaseConnection.setDBQuery("insert into ratunes.artis(name) values('" + songs.get(counter) + "')");
        }
    }

    public void setCover() throws SQLException {
        if (coverImage != null){
            databaseConnection.setDBQuery("insert into ratunes.cover(image) values('" + album.getCovers() + "')");
        }
    }

    public void setAlbum() throws SQLException {
       if (coverImage != null){
           databaseConnection.setDBQuery("insert into ratunes.album(title, coverID) values ('" + album.title +", (select max(id) from cover)')");
       } else {
           databaseConnection.setDBQuery("insert into ratunes.album(title, coverID) values ('" + album.title +", (select top 1 id from cover)')");
       }
    }

    public void setAlbumToArtist()throws SQLException{
        databaseConnection.setDBQuery("insert into ratunes.albumtoartist(albumID, artistID) values ((select max(id) from album), (select id from artist where name = " + album.artist + "))");
    }

    public void addSong() throws SQLException{
        if (songText == null){
            databaseConnection.setDBQuery("insert into ratunes.song(title, songwriter, albumID) values ('" + song.title +","+ song.songWriter +", (select max(id) from album))");
        } else {
            // soll textdatei hochladen und pfard in der datenbank speichern
            databaseConnection.setDBQuery("insert into ratunes.song(title, songtext, songwriter, albumID) values ('" + song.title +", load_file('" + songTextPath + "'),"+ song.songWriter +", (select max(id) from album))");
        }
    }

    public void setSongToArtist() throws SQLException {
        databaseConnection.setDBQuery("insert into ratunes.songtoartist(artistID, SongID) values ((select id from artist where name = " + song.artist + "), (select max(id) from song))");
    }
}

     **/