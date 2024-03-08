package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataService {
    private Connection con;
    public Connection getCon() {
        return con;
    }
    public void connectDatabase() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Properties props = new Properties();
            props.setProperty("user", "SYS AS SYSDBA");
            props.setProperty("password", "123");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", props);
            System.out.println("Connected to the database.");
        } catch (Exception e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing the connection: " + e.getMessage());
        }
    }

    public ResultSet fetchDataFromDatabase(String query) {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error fetching data from the database: " + e.getMessage());
        }
        return rs;
    }
    public void executeUpdate(String sql) throws SQLException {
        if (con == null || con.isClosed()) {
            throw new SQLException("Connection is not established.");
        }

        Statement statement = null;
        try {
            // Create a statement
            statement = con.createStatement();

            // Execute the update statement
            int rowsAffected = statement.executeUpdate(sql);
        } finally {
            // Close the statement
            if (statement != null)
                statement.close();
        }
    }
    public static void main(String[] args) {
        DataService t = new DataService();
        t.connectDatabase();
        // Example query: "select * from nhanvien"
        t.fetchDataFromDatabase("select * from nhanvien");
        t.closeConnection();
    }
    
}
