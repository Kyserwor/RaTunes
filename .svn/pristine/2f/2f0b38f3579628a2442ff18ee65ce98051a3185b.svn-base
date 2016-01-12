package dao;

import mvc.model.Artist;
import mvc.model.Cover;
import mvc.model.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rlukas on 03.11.2015.
 */
public class CoverDAO {
    private static DatabaseConnection databaseConnection = null;

    public CoverDAO(){
        databaseConnection = new DatabaseConnection();
        databaseConnection.connection();
    }

    public void addCover(Cover cover){
        try {
            String queryString = "INSERT INTO ratunes.cover" +
                                 "(url) " +
                                 " VALUES " +
                                 "(?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setString(1, cover.getUrl());
            statement.executeUpdate();
            cover.setId(databaseConnection.getLastInsertID(statement));
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
    }

    public Cover getCoverbyID(int coverID){
        Cover cover = null;
        try {
            String query = "SELECT url FROM ratunes.cover WHERE id=?";
            PreparedStatement statement = databaseConnection.getStatement(query);
            statement.setInt(1, coverID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cover = new Cover(coverID,
                        resultSet.getString("url"));
            }
        } catch (SQLException e) {
                System.out.println(e);
        } finally {
            databaseConnection.closeDatabase();
        }
        return cover;
    }
}
