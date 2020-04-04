package ongEC;

import java . sql . Connection ;
import java . sql . DriverManager ;
import java . sql . SQLException ;
import java . sql . Statement ;
import java.sql.ResultSet;



public class MySqlConection {
    
    public static void connect(){
    String url = "jdbc:mysql://127.0.0.1:3306/producto3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String pass = "Ivan2018";
    System.out.println("Conectando...");
    try(Connection connection = DriverManager.getConnection(url, user,pass)){
    System.out.println("Conectado!!");
    
    // vamos a insertar un registro
    System.out.println("Insertando ...");
    Statement s = connection.createStatement();
    String query1 = "insert into delegacion (nomDelegacion, cip) value (\"barcelona\", \"B45878\")";
    //(idMiembro,nombreMiembro,nombreUsuario,password,apellido1,apellido2,dni,pais,ciudad,direccion,rol,telefono) value (3,\"Ivan\", \"Ivan2020\", \"ivan\", \"garcia\", \"manso\", \"47617367f\", \"españa\", \"josep estivill 75\", \"NULL\", \"618058878\")";
    s.executeUpdate(query1);
    
    // vamos a recorrer
    String query2 = "select * from delegacion";
    ResultSet r = s.executeQuery(query2);
    //MOSTRAMOS POR PANTALLA LA INSERCION DE DATOS
    while(r.next()){
        System.out.println(r.getObject("nomDelegacion") +" - " +r.getObject("cip"));
    }
    
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        connect();
    }
    
}