package ongEC;

import java . sql . Connection ;
import java . sql . DriverManager ;
import java . sql . SQLException ;
import java . sql . Statement ;
import java.sql.ResultSet;
import ongEC.*;
import sql.UtilitySql;



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
    
    /*----------------------------------------------------OK------------------------------------------------------------------------------------------------------------*/
 /*   Statement t = connection.createStatement();
    String query3= "insert into direccionesusuarios (idDireccion, tipoVia, numero, puerta, escalera, localidad, provincia, cp, pais) "
    		+ "value (\"01\", \"calle josep estivill\", \"75\", \"2-1\", \"b\", \"barcelona\", \"barcelona\", \"080027\", \"españa\")";
    t.executeUpdate(query3);
    
    // vamos a recorrer tabla direcciones, PRIMERO INSERTAMOS UNA DIRECCION
    String query4 = "select * from direccionesusuarios";
    ResultSet v = t.executeQuery(query4);
    //MOSTRAMOS POR PANTALLA LA INSERCION DE DATOS
    while(v.next()){
        System.out.println(v.getObject("idDireccion") + " - "+v.getObject("tipoVia") + " - "+v.getObject("numero") + " - "+v.getObject("puerta") 
        + " - "+v.getObject("escalera") + " - "+v.getObject("localidad") + " - "+v.getObject("provincia") + " - "+ v.getObject("cp") 
        + " - "+v.getObject("pais"));
    }
*/    
    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
 /*   
   // AHORA vamos a insertar un registro DE UN MIEMBRO 
    System.out.println("Insertando ...");
    Statement s = connection.createStatement();
    String query1 = "insert into miembros (nombreMiembro,nombreUsuario,password,apellido1,apellido2,dni, direccion,rol,telefono) "
    		+ "value (\"Ivan\", \"Ivan2020\", \"ivan\", \"garcia\", \"manso\", \"47617367f\", \"01\", \"MIEMBRO\", \"618058878\")";
    s.executeUpdate(query1);
    
    // vamos a recorrer miembros
    String query2 = "select * from miembros";
    ResultSet r = s.executeQuery(query2);
    //MOSTRAMOS POR PANTALLA LA INSERCION DE DATOS
    while(r.next()){
        System.out.println(r.getObject("nombreMiembro") + " - "+r.getObject("nombreUsuario") + " - "+r.getObject("nombreUsuario") + " - "+r.getObject("password") 
        + " - "+r.getObject("apellido1") + " - "+r.getObject("apellido2") + " - "+r.getObject("dni") + " - "+ r.getObject("direccion") 
        + " - "+r.getObject("rol") + " - "+r.getObject("telefono"));
    }
    
  */
   /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/ 

    
    /*-----------AHORA INSERTAMOS UN MIEMBRO VOLUNTARIO-----------------------------------------------OK------------------------------------------------------------------------------------------------------------*/ 
    /*Statement w = connection.createStatement();
    String query5= "insert into voluntario (idVoluntario, fechaAlta, fechaBaja, origen, paisOrigen) "
    		+ "value (\"01\", \"01/01/01\", \"01/01/01\", \"españa\", \"marruecos\")";
    w.executeUpdate(query5); 
  
    
    // vamos a recorrer tabla voluntario
    String query6 = "select * from voluntario";
    ResultSet p = w.executeQuery(query6);
    //MOSTRAMOS POR PANTALLA LA INSERCION DE DATOS
    while(p.next()){
        System.out.println(p.getObject("idVoluntario") + " - "+p.getObject("fechaAlta") + " - "+p.getObject("fechaBaja") + " - "+p.getObject("origen") 
        + " - "+p.getObject("paisOrigen"));
    } 
    */
    
    
  /*  Statement a = connection.createStatement();
    String query7= "insert into personal (idPersonal, fechaAlta, fechaBaja) "
    		+ "value (\"01\", \"02/02/02\", \"02/02/02\")";
    a.executeUpdate(query7);
    
    // vamos a recorrer tabla personnal
    String query8 = "select * from personal";
    ResultSet b = a.executeQuery(query8);
    //MOSTRAMOS POR PANTALLA LA INSERCION DE DATOS
    while(b.next()){
        System.out.println(b.getObject("idPersonal") + " - "+b.getObject("fechaAlta") + " - "+b.getObject("fechaBaja"));
    }
    
  */
    
    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
 /*   Statement c = connection.createStatement();
    String query9= "insert into colaborador (idColaborador, fechaAlta, fechaBaja) "
    		+ "value (\"01\", \"03/03/03\", \"03/03/03\")";
    c.executeUpdate(query9);
    
    // vamos a recorrer tabla colaborador
    String query10 = "select * from colaborador";
    ResultSet d = c.executeQuery(query10);
    //MOSTRAMOS POR PANTALLA LA INSERCION DE DATOS
    while(d.next()){
        System.out.println(d.getObject("idColaborador") + " - "+d.getObject("fechaAlta") + " - "+d.getObject("fechaBaja"));
    }
    
   */
    }catch(SQLException e){
        System.out.println(e.getMessage());
        //UtilitySql.truncateAllContentDB();// esta puesto para las pruebas parta que borre los datos insertados si hay error
    }
    }
    } 
