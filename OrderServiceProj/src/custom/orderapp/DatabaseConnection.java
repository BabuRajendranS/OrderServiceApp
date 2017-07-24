package custom.orderapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

public class DatabaseConnection {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://mysqldb03.cayxgrvth2go.ap-south-1.rds.amazonaws.com/mysqldbdev";

    //  Database credentials
    static final String USER = "apps";
    static final String PASS = "appspassw0rd";
    
    public DatabaseConnection() {
        super();
    }
    public Connection getMySQLConnection() {
        Connection connection = null;
        try {
               Class.forName("com.mysql.jdbc.Driver");
               connection = DriverManager.getConnection(DB_URL, USER, PASS);
                   //DriverManager.getConnection(DB_URL,USER,PASS);
             } catch (Exception ex) {
               System.err.println("***exception trying to connect***");
                   ex.printStackTrace();
             }       
        return connection;
    }
    public Connection getOracleConnection() {
        Connection connection = null;
        try {
               DriverManager.registerDriver(new OracleDriver());
               //Class.forName("com.oracle.jdbc.Driver");
               connection=DriverManager.getConnection(  
                 "jdbc:oracle:thin:@wsqfa02.edc.cingular.net:30501:EN05","apps","temp1");  
             } catch (Exception ex) {
               System.err.println("***exception trying to connect***");
                   ex.printStackTrace();
             }       
        return connection;
    }   
}
