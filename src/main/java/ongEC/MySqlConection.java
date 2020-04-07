package ongEC;

import java . sql . Connection ;
import java . sql . DriverManager ;
import java . sql . SQLException ;
import java . sql . Statement ;
import java.sql.ResultSet;
import ongEC.*;



public class MySqlConection {
    
    public static void connect() throws SQLException{
    String url = "jdbc:mysql://127.0.0.1:3306/ong?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //String url = "jdbc:mysql://127.0.0.1:3306/mysql";
    String user = "root";
    String pass = "tesTed4a";
    System.out.println("\n**********************************");
    System.out.println("Conectando con la base de datos...");
    System.out.println("**********************************");
    try(Connection connection = DriverManager.getConnection(url, user,pass)){
    System.out.println("\nConectado!!\n");
    Loggin.pulsaIntroParaContinuar();
    
   /* // vamos a insertar un registro
    System.out.println("Insertando ...");
    Statement s = connection.createStatement();
    String query1 = "insert into miembros (IdMiembro,nombreMiembro,nombreUsuario,password,apellido1,apellido2,dni,pais,ciudad,direccion,rol,telefono) "
    		+ "value (\"2\",\"Ivan\", \"Ivan2020\", \"ivan\", \"garcia\", \"manso\", \"47617367f\", \"españa\", \"Barcelona\", \"josep estivill 75\", \"MIEMBRO\", \"618058878\")";
    s.executeUpdate(query1);
    
    // vamos a recorrer
    String query2 = "select * from miembros";
    ResultSet r = s.executeQuery(query2);
    //MOSTRAMOS POR PANTALLA LA INSERCION DE DATOS
    while(r.next()){
        System.out.println(r.getObject("IdMiembro") +" - " +r.getObject("nombreMiembro") + " - "+r.getObject("nombreUsuario") + " - "+r.getObject("nombreUsuario") + " - "+r.getObject("password") 
        + " - "+r.getObject("apellido1") + " - "+r.getObject("apellido2") + " - "+r.getObject("dni") + " - "+r.getObject("pais") + " - "+r.getObject("ciudad") + " - "+r.getObject("direccion") 
        + " - "+r.getObject("rol") + " - "+r.getObject("telefono"));
    }
    
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }
*/

    }
    } 
    
    public static Connection getcon(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
        	String url = "jdbc:mysql://127.0.0.1:3306/ong?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        	String user = "root";
            String pass = "tesTed4a";            
            return DriverManager.getConnection(url, user,pass);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("couldn't connect!");
            throw new RuntimeException(ex);
        }
    }
}