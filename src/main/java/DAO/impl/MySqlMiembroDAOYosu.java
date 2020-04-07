package DAO.impl;

import ongEC.*;
import sql.UtilitySql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

/** La clase MySqlOngDAO forma parte del patrón DAO.
 *  Permite separar la lógica para la persistencia de la lógica del negocio.
 *
 *  MySqlOngDAO implementa la interfaz IOngDAO que declara los métodos que de deberán implementar
 *  todas las instancias DAO ONG, ya sean XmlOngDAO o MySQLDAO.
 *
 *  En el caso de MySqlOngDAO se implementa toda la lógica necesaria para que ONG trabaje con MySQL,
 *  tan solo implementamos los métodos básicos CRUD (Create, Read, Update y Delete).
 *

 * */
public abstract class MySqlMiembroDAOYosu implements IMiembroDAO{

    @SuppressWarnings("unused")
	private Miembro miembro;
    
    public static void incializarXMLdesdeSQL() throws SQLException {
    	
    	Miembros miembros=new Miembros();
    	Miembro miembro=new Miembro();
    	Direccion direccion=new Direccion();
    	Voluntario voluntario=new Voluntario();
    	Colaborador colaborador=new Colaborador();
    	Personal personal=new Personal();
    	Nacional nacional=new Nacional();
    	Internacional internacional=new Internacional();
    	
	   	System.out.println("Recogemos los datos Relacionados con los Miembros y los almacenamos en un XML");
    	Connection conexion;
    	conexion=MySqlConection.getcon();    		    	
    	Statement selectStmt = conexion.createStatement();  	
    	ResultSet rs = selectStmt.executeQuery("SELECT * FROM ong.miembros inner join voluntario on idMiembro=idVoluntario inner join direccionesUsuarios on direccion=idDireccion ");
        while(rs.next()){
             	System.out.println(rs.getString(1));    //First Column
             	miembro.setIdMiembro(rs.getString(1));
             	System.out.println(rs.getString(2));    //Second Column
             	miembro.setNombreMiembro(rs.getString(2));
             	System.out.println(rs.getString(3));    //Third Column
             	miembro.setNombreUsuario(rs.getString(3));
             	System.out.println(rs.getString(4));    //Fourth Column
             	miembro.setPassword(rs.getString(4));
             	System.out.println(rs.getString(5));    //First Column
             	miembro.setApellido1(rs.getString(5));
             	System.out.println(rs.getString(6));    //Second Column
             	miembro.setApellido2(rs.getString(6));
             	System.out.println(rs.getString(7));    //Third Column
             	miembro.setDni(rs.getString(7));
             	System.out.println(rs.getString(8));    //Fourth Column
             	//direccion.set
             	System.out.println(rs.getString(9));    //First Column
             	miembro.setRol(rs.getString(9));
             	System.out.println(rs.getString(10));    //Second Column
             	miembro.setTelefono(rs.getString(10));
             	System.out.println(rs.getString(11));    //Third Column
             	voluntario.setIdMiembro(rs.getString(11));
             	System.out.println(rs.getString(12));    //Fourth Column
             	voluntario.setFechaAlta(rs.getDate(12));
             	System.out.println(rs.getString(13));    //First Column
             	voluntario.setFechaBaja(rs.getDate(13));
             	System.out.println(rs.getString(14));    //Second Column             	
             	System.out.println(rs.getString(15));    //Third Column
             	if (!rs.getString(14).equals("NULL")) {
             		nacional.setOrigen(rs.getString(14));
             	}else {
             		internacional.setPaisOrigen(rs.getString(15));
             	}
             	System.out.println(rs.getString(16));    //Fourth Column
             	//id
            	System.out.println(rs.getString(17));    //Second Column
            	direccion.setTipoVia(rs.getString(17));
             	System.out.println(rs.getString(18));    //Third Column
             	direccion.setNumero(rs.getInt(18));
             	System.out.println(rs.getString(19));    //Fourth Column
             	direccion.setPuerta(rs.getString(19));
             	System.out.println(rs.getString(20));    //First Column
             	direccion.setEscalera(rs.getString(20));
             	System.out.println(rs.getString(21));    //Second Column
             	direccion.setLocalidad(rs.getString(21));
             	System.out.println(rs.getString(22));    //Third Column
             	direccion.setCp(rs.getString(22));
             	System.out.println(rs.getString(23));    //Fourth Column
             	direccion.setPais(rs.getString(23));
        }
     } 
}
