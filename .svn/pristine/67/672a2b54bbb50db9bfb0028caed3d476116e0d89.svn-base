package dao;

import mvc.model.Artist;
import mvc.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlukas on 02.11.2015.
 */
public class SongDAO {
    private static DatabaseConnection databaseConnection = null;

    public SongDAO() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connection();
    }

    public void addSong(Song song) {
        try {
            String queryString = "INSERT INTO ratunes.song" +
                    "(title, songtext, albumID) " +
                    " VALUES " +
                    "(?, ?, ?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setString(1, song.getTitle());
            statement.setString(2, song.getSongText());
            statement.setInt(3, song.getAlbumID());
            statement.executeUpdate();
            song.setId(databaseConnection.getLastInsertID(statement));
            assignSongToArtist(song);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                databaseConnection.closeConnection();
                databaseConnection.closeStatement();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    private void assignSongToArtist(Song song){
        try {
            String queryString = "INSERT INTO " +
                    "ratunes.songtoartist(songID, artistID) "+
                    "VALUES (?, ?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);

            statement.setInt(1, song.getId());
            for (Artist artist : song.getArtists()){
                statement.setInt(2, artist.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                databaseConnection.closeConnection();
                databaseConnection.closeStatement();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void addSongs(List<Song> songs) {
        for (Song song : songs) {
            addSong(song);
        }
    }

    public void updateSong(Song song) {
        try {
            String queryString = "UPDATE ratunes.song " +
                    "SET (title, songtext, albumID) " +
                    "VALUES " +
                    "(?, ?, ?)" +
                    " WHERE id = ?";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setString(1, song.getTitle());
            statement.setString(2, song.getSongText());
            statement.setInt(3, song.getAlbumID());
            statement.setInt(4, song.getId());
            assignSongToArtist(song);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateSongs(List<Song> songs){
        for (Song song : songs){
            updateSong(song);
        }
    }

    private void updateAssignSongToArtist(Song song){
        try {
            deleteAssignSongToArtist(song);
            String queryString = "UPDATE INTO ratunes.songtoartist " +
                    "SET (songID, artistID) "+
                    "VALUES (?, ?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);

            statement.setInt(1, song.getId());
            for (Artist artist : song.getArtists()){
                statement.setInt(2, artist.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                databaseConnection.closeConnection();
                databaseConnection.closeStatement();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    private void deleteAssignSongToArtist(Song song){
        try {
            String queryString = "DELETE " +
                    "FROM " +
                    "ratunes.songtoartist " +
                    "WHERE SongID = ?";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setInt(1, song.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                databaseConnection.closeConnection();
                databaseConnection.closeStatement();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void deleteSong(Song song){
        try {
            String queryString = "DELETE " +
                    "FROM " +
                    "ratunes.song" +
                    "WHERE id = ?";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setInt(1, song.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                databaseConnection.closeConnection();
                databaseConnection.closeStatement();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public Song getSongByID(int songId) {
        Song song = null;
        try {
            String query = "SELECT title,songtext, albumID FROM ratunes.song WHERE id=?";
            PreparedStatement statement = databaseConnection.getStatement(query);
            statement.setInt(1, songId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                song = new Song(songId,
                        resultSet.getString("title"),
                        resultSet.getString("songtext"),
                        getSongArtistsById(songId),
                        resultSet.getInt("albumID"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
        return song;
    }

    public List<Artist> getSongArtistsById(int songId){
        List<Artist> artists = new ArrayList<>();
        try {
            String query = "SELECT " +
                    "ratunes.artist.id, ratunes.artist.name, ratunes.albumtoartist.albumID " +
                    "FROM ratunes.artist " +
                    "INNER JOIN ratunes.songtoartist " +
                    "ON ratunes.artist.id = ratunes.songtoartist.artistID " +
                    "INNER JOIN ratunes.albumtoartist " +
                    "ON ratunes.albumtoartist.artistID = ratunes.songtoartist.artistID " +
                    "WHERE ratunes.songtoartist.SongID = ?";
            PreparedStatement statement = databaseConnection.getStatement(query);
            statement.setInt(1, songId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                artists.add(new Artist(resultSet.getInt("ratunes.artist.id"), resultSet.getString("ratunes.artist.name"), resultSet.getInt("ratunes.albumtoartist.albumID")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return artists;
    }

    public List<Song> getSongsByAlbumId(int albumID) {
        List<Song> songs = new ArrayList<Song>();
        try {
            String query = "SELECT title,songtext,id FROM ratunes.song WHERE albumID=?";
            PreparedStatement statement = databaseConnection.getStatement(query);
            statement.setInt(1, albumID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                songs.add(new Song(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("songtext"),
                        getSongArtistsById(resultSet.getInt("id")),
                        albumID));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
        return songs;
    }
}
