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

    public void fetchDataFromDatabase(String query) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error fetching data from the database: " + e.getMessage());
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
