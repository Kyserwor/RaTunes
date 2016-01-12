package dao;

import mvc.model.Artist;
import mvc.model.Genre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlukas on 04.11.2015.
 */
public class GenreDAO {
    private static DatabaseConnection databaseConnection = null;

    public GenreDAO(){
        databaseConnection = new DatabaseConnection();
        databaseConnection.connection();
    }

    public void addGenre(Genre genre){
        try {
            String queryString = "INSERT INTO ratunes.genre " +
                    "(name) " +
                    " VALUES " +
                    "(?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setString(1, genre.getName());
            statement.executeUpdate();
            genre.setId(databaseConnection.getLastInsertID(statement));
            assignAlbumToGenre(genre);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
    }

    private void assignAlbumToGenre(Genre genre){
        try {
            String queryString = "INSERT INTO ratunes.albumtogenre" +
                    "(albumID, genreID) " +
                    " VALUES " +
                    "(?, ?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setInt(1, genre.getAlbumID());
            statement.setInt(2, genre.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
    }


    public List<Genre> getGenresByAlbumID(int albumID){
        List<Genre> genres = new ArrayList<Genre>();
        try {
            String query = "SELECT " +
                           "ratunes.genre.id, " +
                           "ratunes.genre.name " +
                           "FROM ratunes.genre " +
                           "INNER JOIN ratunes.albumtogenre " +
                           "ON ratunes.genre.id = ratunes.albumtogenre.genreID " +
                           "WHERE ratunes.albumtogenre.albumID = ?";
            PreparedStatement statement = databaseConnection.getStatement(query);
            statement.setInt(1, albumID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                genres.add(new Genre(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        albumID));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
        return genres;
    }
}
