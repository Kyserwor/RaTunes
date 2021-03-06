package dao; /**
 * Created by rlukas on 07.09.2015.
 */
import java.sql.*;

    public class DatabaseConnection {

        private static final String hostName = "localhost";
        private static final String port = "3306";
        private static final String dbName = "ratunes";
        private static final String user = "root";
        private static final String password = "";
        public Connection connection = null;
        public Statement connectionStatement = null;


        public void connection(){
            driversLoad();
            try {
                connection = createConnection();
                connectionStatement = createStatement(connection);
            }
            catch (SQLException sqlException) {
                System.out.println("SQLException: " + sqlException.getMessage());
                System.out.println("SQLState: " + sqlException.getSQLState());
                System.out.println("VendorError: " + sqlException.getErrorCode());
                sqlException.printStackTrace();
            }
        }

        public void driversLoad(){
            try {
                Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            }
            catch (Exception e) {
                System.err.println("Unable to load driver.");
                e.printStackTrace();
            }
        }

        public Connection createConnection(){
            Connection connection = null;
            try {
                System.out.println("Verbindung aufbauen");
                String url = "jdbc:mysql://"+hostName+":"+port+"/"+dbName;
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException sqlException) {
                System.out.println("SQLException: " + sqlException.getMessage());
                System.out.println("SQLState: " + sqlException.getSQLState());
                System.out.println("VendorError: " + sqlException.getErrorCode());
                sqlException.printStackTrace();
            }
            return connection;
        }

        public Statement createStatement(Connection connection) throws SQLException {
            return connection.createStatement();
        }

        public void setDBQuery(String sqlCommand) throws SQLException {
            connectionStatement.executeQuery(sqlCommand);
        }

        public ResultSet getDBQuery(String sqlCommand) throws SQLException {
            return connectionStatement.executeQuery(sqlCommand);
        }

        public void closeStatement() throws SQLException {
            connectionStatement.close();
        }

        public void closeConnection() throws SQLException {
            connection.close();
        }

        public PreparedStatement getStatement(String query){
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return statement;
        }

        public int getLastInsertID(PreparedStatement statement){
            int id = 0;
            try {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()){
                    id = resultSet.getInt(1);
                }
            } catch (SQLException e){
                System.out.println(e);
            }
            return id;
        }

        public void closeDatabase(){
            try {
                this.closeConnection();
                this.closeStatement();
            } catch (SQLException e){
                System.out.println(e);
            }
        }
    }

