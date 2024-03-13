package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

public class Dataservice {
    private static String url = "jdbc:oracle:thin:@localhost:1521:";
    public static String database = "";
    public static String user ="";
    public static String pass ="";
    public static Connection conn;
    public static boolean Connect(){
        try {
            if(user.equalsIgnoreCase("sys")){
                user += "as sysdba";
            }
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url+database, user, pass);
            return true;
        }catch(ClassNotFoundException | SQLException e){
            return false;
        }
    }
    
    public static Connection Getconnect(){
        if(conn== null){
            Connect();
        }
        return conn;
    }
    
}
