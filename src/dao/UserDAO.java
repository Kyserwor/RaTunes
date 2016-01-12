package dao;

import mvc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rlukas on 28.10.2015.
 */
public class UserDAO {

    private static DatabaseConnection databaseConnection = null;

    public UserDAO(){
        databaseConnection = new DatabaseConnection();
        databaseConnection.connection();
    }

    public boolean checkLogin(User user) throws SQLException {
        boolean result = false;
        try {
            String queryString = "SELECT id FROM user WHERE name=? and password=?";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                result = true;
                user.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e){
            System.out.println(e);
        } finally {
           databaseConnection.closeDatabase();
        }
        return result;
    }

    public void addNewUser(User user) throws SQLException {
        try {
            String queryString = "INSERT INTO ratunes.user " +
                                 "(name, email, password)" +
                                 " VALUES " +
                                 "(?, ?, ?)";
            PreparedStatement statement = databaseConnection.getStatement(queryString);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            } finally {
                databaseConnection.closeDatabase();
            }
    }

    public void closeDatabase(){
        try {
            databaseConnection.closeConnection();
            databaseConnection.closeStatement();
        } catch (SQLException e){
            System.out.println(e);
        }
    }

}
