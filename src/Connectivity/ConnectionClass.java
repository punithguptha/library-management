package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    public Connection connection=null;
    public Connection getConnection(){
        String dbname="librarymanagement";
        String username="root";
        String password="Karthik@2602";
        String jdbcurl="jdbc:mysql://localhost/librarymanagement?useSSL=false";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection= DriverManager.getConnection("jdbc:mysql://localhost/librarymanagement?useSSL=false",username,password);
                System.out.println("Connection successfully established");
            } catch (SQLException e) {
                System.out.println("Problem with establishing connection");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found exception");
            e.printStackTrace();
        }
        return connection;
    }
}
