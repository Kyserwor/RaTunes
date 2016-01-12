package dao;

import mvc.model.Artist;
import mvc.model.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlukas on 03.11.2015.
 */
public class ArtistDAO {
    private static DatabaseConnection databaseConnection = null;

    public ArtistDAO(){
        databaseConnection = new DatabaseConnection();
        databaseConnection.connection();
    }

    public void addArtist(Artist artist){
        try {
            String queryString = "INSERT INTO ratunes.artist " +
                    "(name) " +
                    " VALUES " +
                    "(?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setString(1, artist.getName());
            statement.executeUpdate();
            artist.setId(databaseConnection.getLastInsertID(statement));
            assignAlbumToArtist(artist);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
    }

    private void assignAlbumToArtist(Artist artist){
        try {
            String queryString = "INSERT INTO ratunes.albumtoartist " +
                    "(albumID, artistID) " +
                    " VALUES " +
                    "(?, ?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setInt(1, artist.getAlbumID());
            statement.setInt(2, artist.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
    }

    public void addArtists(List<Artist> artists) {
        for (Artist artist : artists) {
            addArtist(artist);
        }
    }

    public List<Artist> getArtistsByAlbumID(int albumID){
        List<Artist> artists = new ArrayList<Artist>();
        try {
            String query = "SELECT " +
                    "ratunes.artist.id, " +
                    "ratunes.artist.name " +
                    "FROM ratunes.artist " +
                    "INNER JOIN ratunes.albumtoartist " +
                    "ON ratunes.artist.id = ratunes.albumtoartist.artistID " +
                    "WHERE ratunes.albumtoartist.albumID = ?";
            PreparedStatement statement = databaseConnection.getStatement(query);
            statement.setInt(1, albumID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                artists.add(new Artist(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        albumID));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
        return artists;
    }

    public List<Artist> getArtistsBySongID(Song song){
        List<Artist> artists = new ArrayList<Artist>();
        try {
            String query = "SELECT " +
                    "ratunes.artist.id, " +
                    "ratunes.artist.name " +
                    "FROM ratunes.artist " +
                    "INNER JOIN ratunes.songtoartist" +
                    "ON ratunes.artist.id = ratunes.songtoartist.artistID " +
                    "WHERE ratunes.songtoartist.songID = ?";
            PreparedStatement statement = databaseConnection.getStatement(query);
            statement.setInt(1, song.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                artists.add(new Artist(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        song.getAlbumID()));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
        return artists;
    }
}
