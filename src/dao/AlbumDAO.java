package dao;

import mvc.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlukas on 02.11.2015.
 */
public class AlbumDAO {
    private static DatabaseConnection databaseConnection = null;

    public AlbumDAO(){
        databaseConnection = new DatabaseConnection();
        databaseConnection.connection();
    }

    public void addAlbum(Album album, User user){

        try {
            String queryString = "INSERT INTO ratunes.album" +
                    "(title, coverID) " +
                    " VALUES " +
                    "(?, ?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setString(1, album.getTitle());
            statement.setInt(2, album.getCover().getId());
            statement.executeUpdate();
            album.setId(databaseConnection.getLastInsertID(statement));
            assignAlbumToGenre(album);
            assignAlbumToArtist(album);
            assignAlbumToUser(user.getId(), album.getId());
            updateSongAlbumId(album);
            new SongDAO().addSongs(album.getSongs());
            new CoverDAO().addCover(album.getCover());
            new ArtistDAO().addArtists(album.getArtists());
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
    }

    public void deleteAlbum(Album album){

    }

    public void assignAlbumToGenre(Album album){
        try {
            String queryString = "INSERT INTO " +
                        "ratunes.albumtogenre(albumID, genreID) "+
                    "VALUES (?, ?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setInt(1, album.getId());
            for (Genre genre: album.getGenres()){
                statement.setInt(2, genre.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void assignAlbumToArtist(Album album){
        try {
            String queryString = "INSERT INTO " +
                    "ratunes.albumtoartist(albumID, artistID) "+
                    "VALUES (?, ?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            for (Artist artist : album.getArtists()){
                statement.setInt(1, album.getId());
                statement.setInt(2, artist.getId());
            }
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void assignAlbumToUser(int userId, int albumId){
        try {
            String queryString = "INSERT INTO " +
                    "ratunes.usertoalbum(user_id, album_id) "+
                    "VALUES (?, ?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setInt(1, userId);
            statement.setInt(2, albumId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Album getAlbumById(int albumId){
        Album album = new Album(albumId,
                                getTitleByAlbumID(albumId),
                                new GenreDAO().getGenresByAlbumID(albumId),
                                new ArtistDAO().getArtistsByAlbumID(albumId),
                                new SongDAO().getSongsByAlbumId(albumId),
                                new CoverDAO().getCoverbyID(albumId));
        return album;
    }

    public List<Album> getAlbumsByUser(User user){
        List<Album> albums = new ArrayList<>();
        try {
            String query = "SELECT " +
                    "ratunes.usertoalbum.album_id as id " +
                    "FROM ratunes.usertoalbum " +
                    "WHERE ratunes.usertoalbum.user_id = ?";
            PreparedStatement statement = databaseConnection.getStatement(query);
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                albums.add( new AlbumDAO().getAlbumById(resultSet.getInt("id")));
            }
        } catch (SQLException e){
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
        return albums;

    }

    public String getTitleByAlbumID(int albumID){
        String title = null;
        try {
            String query = "SELECT " +
                           "ratunes.album.title " +
                           "FROM ratunes.album " +
                           "WHERE ratunes.album.id = ?";
            PreparedStatement statement = databaseConnection.getStatement(query);
            statement.setInt(1, albumID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                title = resultSet.getString("title");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
        return title;
    }

    public void updateSongAlbumId(Album album){
        for (Song song: album.getSongs()){
            song.setAlbumID(album.getId());
        }
    }

    public void addTitle(Album album){
        String queryString = "INSERT INTO ratunes.album " +
                    "(title)" +
                    " VALUES " +
                    "(?)";
       // SingleCallDB(queryString, album.getTitle());
    }

    public void addAritst(Artist artist){
        String queryString = "INSERT INTO ratunes.artist " +
                "(name)" +
                " VALUES " +
                "(?)";
        //SingleCallDB(queryString, artist.getName());
    }

    public void updateAlbum(Album album){
        try {
            String query = "UPDATE " +
                    "ratunes.album " +
                    "SET " +
                    "ratunes.album.title = ? " +
                    "WHERE " +
                    "ratunes.album.id = ?";
            PreparedStatement statement = databaseConnection.getStatement(query);
            statement.setString(1, album.getTitle());
            statement.setInt(2, album.getId());
            statement.executeUpdate();
            ArtistDAO artistDAO = new ArtistDAO();
            artistDAO.updateArtists(album.getArtists());
            SongDAO songDAO = new SongDAO();
            songDAO.updateSongs(album.getSongs());
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
    }
}
