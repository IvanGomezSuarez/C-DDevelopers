package DAO.DAOOLD;

import java . sql . Connection ;
import java . sql . DriverManager ;
import java . sql . SQLException ;
import java . sql . Statement ;
import java.sql.ResultSet;
import ongEC.*;
import sql.UtilitySql;



public class MySqlConectionO {

    public static void connect() throws SQLException{
    String url = "jdbc:mysql://127.0.0.1:3306/ong?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //String url = "jdbc:mysql://127.0.0.1:3306/mysql";
    String user = "root";
    String pass = "tesTed4a";
    System.out.println("\n**********************************");
    System.out.println("Conectando con la base de datos...");
    System.out.println("**********************************");
    Connection connection = DriverManager.getConnection(url, user,pass);
    }
    public static Connection getcon(){
        try{
        	String url = "jdbc:mysql://127.0.0.1:3306/ong?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        	String user = "root";
            String pass = "tesTed4a";
            return DriverManager.getConnection(url, user,pass);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("no puede conectar!");
            throw new RuntimeException(ex);
        }
    }
}
