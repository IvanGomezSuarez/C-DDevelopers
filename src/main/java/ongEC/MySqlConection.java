package ongEC;

import java . sql . Connection ;
import java . sql . DriverManager ;
import java . sql . SQLException ;
import java . sql . Statement ;
import java.sql.ResultSet;
import ongEC.*;



public class MySqlConection {
    
    public static void connect() throws SQLException{
    String url = "jdbc:mysql://127.0.0.1:3306/producto3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String pass = "Ivan2018";
    System.out.println("\n**********************************");
    System.out.println("Conectando con la base de datos...");
    System.out.println("**********************************");
    try(Connection connection = DriverManager.getConnection(url, user,pass)){
    System.out.println("\nConectado!!\n");
    Loggin.pulsaIntroParaContinuar();
    
    
   // vamos a insertar un registro
    System.out.println("Insertando ...");
    Statement s = connection.createStatement();
    String query1 = "insert into miembros (nombreMiembro,nombreUsuario,password,apellido1,apellido2,dni, direccion,rol,telefono) "
    		+ "value (\"Ivan\", \"Ivan2020\", \"ivan\", \"garcia\", \"manso\", \"47617367f\", \"josep estivill 75\", \"MIEMBRO\", \"618058878\")";
    s.executeUpdate(query1);
    
    // vamos a recorrer
    String query2 = "select * from miembros";
    ResultSet r = s.executeQuery(query2);
    //MOSTRAMOS POR PANTALLA LA INSERCION DE DATOS
    while(r.next()){
        System.out.println(r.getObject("nombreMiembro") + " - "+r.getObject("nombreUsuario") + " - "+r.getObject("nombreUsuario") + " - "+r.getObject("password") 
        + " - "+r.getObject("apellido1") + " - "+r.getObject("apellido2") + " - "+r.getObject("dni") + " - "+ r.getObject("direccion") 
        + " - "+r.getObject("rol") + " - "+r.getObject("telefono"));
    }
    
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }
    } 
