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
            	miembro=new Miembro();
            	direccion=new Direccion();
            	voluntario=new Voluntario();
            	 //System.out.println(rs.getString(1));   1 Column
             	miembro.setIdMiembro(rs.getString(1));
             	 //System.out.println(rs.getString(2));    //2 Column
             	miembro.setNombreMiembro(rs.getString(2));
             	 //System.out.println(rs.getString(3));    //3 Column
             	miembro.setNombreUsuario(rs.getString(3));
             	 //System.out.println(rs.getString(4));    //4 Column
             	miembro.setPassword(rs.getString(4));
             	 //System.out.println(rs.getString(5));    //5 Column
             	miembro.setApellido1(rs.getString(5));
             	 //System.out.println(rs.getString(6));    //6 Column
             	miembro.setApellido2(rs.getString(6));
             	 //System.out.println(rs.getString(7));    //7 Column
             	miembro.setDni(rs.getString(7));
             	 //System.out.println(rs.getString(8));    //8 Column
             	//No se utiliza el id de direccion de la tabla de miembros
             	 //System.out.println(rs.getString(9));    //9 Column
             	miembro.setRol(rs.getString(9));
             	 //System.out.println(rs.getString(10));    //10 Column
             	miembro.setTelefono(rs.getString(10));
             	 //System.out.println(rs.getString(11));    //11 Column
             	voluntario.setIdVoluntario(rs.getInt(11));
             	 //System.out.println(rs.getString(12));    //12 Column
             	voluntario.setFechaAlta(rs.getDate(12));
             	 //System.out.println(rs.getString(13));    //13 Column
             	voluntario.setFechaBaja(rs.getDate(13));
             	 //System.out.println(rs.getString(14));    //14 Column             	
             	 //System.out.println(rs.getString(15));    //15 Column
             	if (rs.getString(14)!="NULL") {  //Comprobamos si es de origen nacional o internacional
             		nacional.setOrigen(rs.getString(14));
             		voluntario.setNacional(nacional);
             	}else {
             		internacional.setPaisOrigen(rs.getString(15));
             		voluntario.setInternacional(internacional);
             	}
             	 //System.out.println(rs.getString(16));    //16 Column
             	direccion.setIdDireccion(rs.getInt(16));
             	 //System.out.println(rs.getString(17));    //17 Column
            	direccion.setTipoVia(rs.getString(17));
            	 //System.out.println(rs.getString(18));    //18 Column
             	direccion.setNumero(rs.getInt(18));
             	 //System.out.println(rs.getString(19));    //19 Column
             	direccion.setPuerta(rs.getString(19));
             	 //System.out.println(rs.getString(20));    //20 Column
             	direccion.setEscalera(rs.getString(20));
             	 //System.out.println(rs.getString(21));    //21 Column
             	direccion.setLocalidad(rs.getString(21));
             	 //System.out.println(rs.getString(22));    //22 Column
             	direccion.setCp(rs.getString(22));
             	 //System.out.println(rs.getString(23));    //23 Column
             	direccion.setPais(rs.getString(23));
             	 //System.out.println(rs.getString(24));    //24 Column
             	direccion.setProvincia(rs.getString(24));
             	miembro.setDireccion(direccion);
             	miembro.setVoluntario(voluntario);
             	miembros.add(miembro);
        }
        conexion=MySqlConection.getcon();
        Statement selectStmt1 = conexion.createStatement();
        ResultSet rs1 = selectStmt1.executeQuery("SELECT * FROM ong.miembros inner join personal on idMiembro=idPersonal inner join direccionesUsuarios on direccion=idDireccion ");
        while(rs1.next()){
        		miembro=new Miembro();
        		direccion=new Direccion();
        		personal=new Personal();
        		 //System.out.println(rs1.getString(1));    //1 Column
             	miembro.setIdMiembro(rs1.getString(1));
             	 //System.out.println(rs1.getString(2));    //2 Column
             	miembro.setNombreMiembro(rs1.getString(2));
             	 //System.out.println(rs1.getString(3));    //3 Column
             	miembro.setNombreUsuario(rs1.getString(3));
             	 //System.out.println(rs1.getString(4));    //4 Column
             	miembro.setPassword(rs1.getString(4));
             	 //System.out.println(rs1.getString(5));    //5 Column
             	miembro.setApellido1(rs1.getString(5));
             	 //System.out.println(rs1.getString(6));    //6 Column
             	miembro.setApellido2(rs1.getString(6));
             	 //System.out.println(rs1.getString(7));    //7 Column
             	miembro.setDni(rs1.getString(7));
             	 //System.out.println(rs1.getString(8));    //8 Column
             	//No se utiliza el id de direccion de la tabla de miembros
             	 //System.out.println(rs1.getString(9));    //9 Column
             	miembro.setRol(rs1.getString(9));
             	 //System.out.println(rs1.getString(10));    //10 Column
             	miembro.setTelefono(rs1.getString(10));
             	 //System.out.println(rs1.getString(11));    //11 Column
             	personal.setIdPersonal(rs1.getInt(11));
             	 //System.out.println(rs1.getString(12));    //12 Column
             	personal.setFechaAlta(rs1.getDate(12));
             	 //System.out.println(rs1.getString(13));    //13 Column
             	personal.setFechaBaja(rs1.getDate(13));
             	 //System.out.println(rs1.getString(14));    //16 Column
             	direccion.setIdDireccion(rs1.getInt(14));
             	 //System.out.println(rs1.getString(15));    //17 Column
            	direccion.setTipoVia(rs1.getString(15));
            	 //System.out.println(rs1.getString(16));    //18 Column
             	direccion.setNumero(rs1.getInt(16));
             	 //System.out.println(rs1.getString(17));    //19 Column
             	direccion.setPuerta(rs1.getString(17));
             	 //System.out.println(rs1.getString(18));    //20 Column
             	direccion.setEscalera(rs1.getString(18));
             	 //System.out.println(rs1.getString(19));    //21 Column
             	direccion.setLocalidad(rs1.getString(19));
             	 //System.out.println(rs1.getString(20));    //22 Column
             	direccion.setCp(rs1.getString(20));
             	 //System.out.println(rs1.getString(21));    //23 Column
             	direccion.setPais(rs1.getString(21));
             	 //System.out.println(rs1.getString(22));    //24 Column
             	direccion.setProvincia(rs1.getString(22));
             	miembro.setDireccion(direccion);
             	miembro.setPersonal(personal);
             	miembros.add(miembro);
        }
        conexion=MySqlConection.getcon();
        Statement selectStmt2 = conexion.createStatement();
        ResultSet rs2 = selectStmt2.executeQuery("SELECT * FROM ong.miembros inner join colaborador on idMiembro=idColaborador inner join direccionesUsuarios on direccion=idDireccion");
        while(rs2.next()){
            	miembro=new Miembro();
            	direccion=new Direccion();
            	colaborador=new Colaborador();
            	 //System.out.println(rs2.getString(1));    //1 Column
	         	miembro.setIdMiembro(rs2.getString(1));
	         	 //System.out.println(rs2.getString(2));    //2 Column
	         	miembro.setNombreMiembro(rs2.getString(2));
	         	 //System.out.println(rs2.getString(3));    //3 Column
	         	miembro.setNombreUsuario(rs2.getString(3));
	         	 //System.out.println(rs2.getString(4));    //4 Column
	         	miembro.setPassword(rs2.getString(4));
	         	 //System.out.println(rs2.getString(5));    //5 Column
	         	miembro.setApellido1(rs2.getString(5));
	         	 //System.out.println(rs2.getString(6));    //6 Column
	         	miembro.setApellido2(rs2.getString(6));
	         	 //System.out.println(rs2.getString(7));    //7 Column
	         	miembro.setDni(rs2.getString(7));
	         	 //System.out.println(rs2.getString(8));    //8 Column
	         	//No se utiliza el id de direccion de la tabla de miembros
	         	 //System.out.println(rs2.getString(9));    //9 Column
	         	miembro.setRol(rs2.getString(9));
	         	 //System.out.println(rs2.getString(10));    //10 Column
	         	miembro.setTelefono(rs2.getString(10));
	         	 //System.out.println(rs2.getString(11));    //11 Column
	         	colaborador.setIdColaborador(rs2.getInt(11));
	         	 //System.out.println(rs2.getString(12));    //12 Column
	         	colaborador.setFechaAlta(rs2.getDate(12));
	         	 //System.out.println(rs2.getString(13));    //13 Column
	         	colaborador.setFechaBaja(rs2.getDate(13));
	         	 //System.out.println(rs2.getString(14));    //16 Column
	         	direccion.setIdDireccion(rs2.getInt(14));
	         	 //System.out.println(rs2.getString(15));    //17 Column
	        	direccion.setTipoVia(rs2.getString(15));
	        	 //System.out.println(rs2.getString(16));    //18 Column
	         	direccion.setNumero(rs2.getInt(16));
	         	 //System.out.println(rs2.getString(17));    //19 Column
	         	direccion.setPuerta(rs2.getString(17));
	         	 //System.out.println(rs2.getString(18));    //20 Column
	         	direccion.setEscalera(rs2.getString(18));
	         	 //System.out.println(rs2.getString(19));    //21 Column
	         	direccion.setLocalidad(rs2.getString(19));
	         	 //System.out.println(rs2.getString(20));    //22 Column
	         	direccion.setCp(rs2.getString(20));
	         	 //System.out.println(rs2.getString(21));    //23 Column
	         	direccion.setPais(rs2.getString(21));
	         	 //System.out.println(rs2.getString(22));    //24 Column
	         	direccion.setProvincia(rs2.getString(22));
	         	miembro.setDireccion(direccion);
	         	miembro.setColaborador(colaborador);
	         	miembros.add(miembro);
	    }
        MiembroDAO.save(miembros);
     } 
    public static int consultarIdGenerado() throws SQLException {
    	
    	int idGenerado=0;
    	Connection conexion;
    	conexion=MySqlConection.getcon();    		    	
    	Statement selectStmt = conexion.createStatement();  
    	System.out.println("Recogemos el ultimo id de miembros");
    	ResultSet rs = selectStmt.executeQuery("Select MAX(idMiembro) from miembros");
    	while (rs.next()) {
    		idGenerado=rs.getInt(1);
    		//System.out.println(idGenerado);
    	}
    	return(idGenerado);
    }
    
    public static void updateMiembroDAOMysql(Miembro miembro, int miembroIdViejo) throws SQLException {
    	Connection conexion;
    	conexion=MySqlConection.getcon();    		    	
    	Statement selectStmt = conexion.createStatement();  
    	System.out.println("Updateamos Direccion");
    	System.out.println(miembro.getDireccion().getIdDireccion());
    	System.out.println("Update direccionesUsuarios SET idDireccion="+miembro.getIdMiembro() +","+
    	    	" tipovia="+miembro.getDireccion().getTipoVia()+","+ " numero=" +miembro.getDireccion().getNumero()+","+" puerta="+miembro.getDireccion().getPuerta()+","+
    	    	" escalera= "+ miembro.getDireccion().getEscalera()+","+ " localidad=" + miembro.getDireccion().getLocalidad()+","+" provincia=" +
    	    	miembro.getDireccion().getProvincia()+","+" cp=" +miembro.getDireccion().getCp() +","+ " pais= " + miembro.getDireccion().getPais() + 
    	    	" where idDireccion="+miembroIdViejo);
    	selectStmt.executeUpdate("Update direccionesUsuarios SET idDireccion="+miembro.getIdMiembro() +","+
    	    	" tipovia="+miembro.getDireccion().getTipoVia()+","+ " numero=" +miembro.getDireccion().getNumero()+","+" puerta="+miembro.getDireccion().getPuerta()+","+
    	    	" escalera= "+ miembro.getDireccion().getEscalera()+","+ " localidad=" + miembro.getDireccion().getLocalidad()+","+" provincia=" +
    	    	miembro.getDireccion().getProvincia()+","+" cp=" +miembro.getDireccion().getCp() +","+ " pais= " + miembro.getDireccion().getPais() + 
    	    	" where idDireccion="+miembroIdViejo);
//    	ResultSet rs5 = selectStmt.executeQuery("Update direccionesUsuarios SET idDireccion="+miembro.getDireccion().getIdDireccion() +","+
//    	" tipovia="+miembro.getDireccion().getTipoVia()+","+ " numero=" +miembro.getDireccion().getNumero()+","+" puerta="+miembro.getDireccion().getPuerta()+","+
//    	" escalera= "+ miembro.getDireccion().getEscalera()+","+ " localidad=" + miembro.getDireccion().getLocalidad()+","+" provincia=" +
//    	miembro.getDireccion().getProvincia()+","+" cp=" +miembro.getDireccion().getCp() +","+ " pais= " + miembro.getDireccion().getPais() + 
//    	" where idDireccion="+miembroIdViejo);
//    	rs5.executeUpdate(String.format("Update direccionesUsuarios SET idDireccion="+miembro.getDireccion().getIdDireccion() +","+
//    	    	" tipovia="+miembro.getDireccion().getTipoVia()+","+ " numero=" +miembro.getDireccion().getNumero()+","+" puerta="+miembro.getDireccion().getPuerta()+","+
//    	    	" escalera= "+ miembro.getDireccion().getEscalera()+","+ " localidad=" + miembro.getDireccion().getLocalidad()+","+" provincia=" +
//    	    	miembro.getDireccion().getProvincia()+","+" cp=" +miembro.getDireccion().getCp() +","+ " pais= " + miembro.getDireccion().getPais() + 
//    	    	" where idDireccion="+miembroIdViejo));
    	
    	System.out.println("Updateamos Miembro");
    	ResultSet rs6 = selectStmt.executeQuery("update miembros set idMiembro=" + miembro.getIdMiembro() + " nombreMiembro="+ miembro.getNombreMiembro() + " nombreUsuario="+ miembro.getNombreUsuario() + " password=" + miembro.getPassword() +
    			" apellido1=" + miembro.getApellido1() + " apellido2"+ miembro.getApellido2() + " dni=" + miembro.getDni() + " direccion=" +miembro.getDireccion().getIdDireccion() + " rol= "
    			+ miembro.getRol() + " telefono=" + miembro.getTelefono()+ " where idMiembro="+miembroIdViejo);
    	System.out.println("Comprobamos si es Voluntario,Personal,Colaborador");
    	if(miembro.getVoluntario()!=null) {
    		System.out.println("Es voluntario");
    		System.out.println("Comprobamos si antes era voluntario");
    		ResultSet rs = selectStmt.executeQuery("Select * from voluntario where idVoluntario="+miembroIdViejo);
    		if (rs!=null) {
    			System.out.println("Era voluntario, por lo que actualizamos la base de datos");   			
    			ResultSet rs3 = selectStmt.executeQuery("update voluntario set idVoluntario="+miembro.getIdMiembro()+" fechaAlta="+ 
    			miembro.getVoluntario().getFechaAlta()+ " fechaBaja="+ miembro.getVoluntario().getFechaBaja()+" origen="+ miembro.getVoluntario().getNacional().getOrigen()+
    			" paisOrigen=" +miembro.getVoluntario().getInternacional().getPaisOrigen()+ " where idVoluntario="+ miembroIdViejo);
    			System.out.println("Actualizamos ");   					  			
    		}else {
    			System.out.println("No era voluntario por lo que Borramos las relaciones de Colaborador y Personal");
    			ResultSet rs1 = selectStmt.executeQuery("Delete from colaborador where idColaborador="+miembro.getIdMiembro());
    			ResultSet rs2 = selectStmt.executeQuery("Delete from personal where idPersonal="+miembro.getIdMiembro());
    			ResultSet rs4 = selectStmt.executeQuery("insert into voluntario (idVoluntario,fechaAlta,fechaBaja,origen,paisOrigen) VALUES("+miembro.getIdMiembro()+"," + miembro.getVoluntario().getFechaAlta()
    					+"," + miembro.getVoluntario().getFechaBaja()+"," +miembro.getVoluntario().getNacional().getOrigen()+"," +miembro.getVoluntario().getInternacional().getPaisOrigen());
    		}
    	}else if (miembro.getPersonal()!=null) {
    		System.out.println("Es Personal");
    		ResultSet rs7 = selectStmt.executeQuery("Select * from personal where idPersonal="+miembroIdViejo);
    		if (rs7!=null) {
    			System.out.println("Era personal, por lo que actualizamos la base de datos");  
    			ResultSet rs8 = selectStmt.executeQuery("update personal set idPersonal="+miembro.getIdMiembro()+" fechaAlta="+ 
            			miembro.getPersonal().getFechaAlta()+ " fechaBaja="+ miembro.getPersonal().getFechaBaja()+ " where idVoluntario="+ miembroIdViejo);
    		}else {
    			System.out.println("No era Personal por lo que Borramos las relaciones de Colaborador y Personal");
    			ResultSet rs1 = selectStmt.executeQuery("Delete from colaborador where idColaborador="+miembro.getIdMiembro());
    			ResultSet rs2 = selectStmt.executeQuery("Delete from voluntario where idVoluntario="+miembro.getIdMiembro());
    			ResultSet rs4 = selectStmt.executeQuery("insert into personal (idPersonal,fechaAlta,fechaBaja) VALUES("+miembro.getIdMiembro()+"," + miembro.getPersonal().getFechaAlta()
    					+"," + miembro.getVoluntario().getFechaBaja()+")");
    		}
    	}else {
    		System.out.println("Es Colaborador");
    		ResultSet rs = selectStmt.executeQuery("Select * from colaborador where idVoluntario="+miembroIdViejo);
    		if (rs!=null) {
    			System.out.println("Era colaborador, por lo que actualizamos la base de datos");
    			ResultSet rs8 = selectStmt.executeQuery("update colaborador set idColabodarod="+miembro.getIdMiembro()+" fechaAlta="+ 
            			miembro.getColaborador().getFechaAlta()+ " fechaBaja="+ miembro.getColaborador().getFechaBaja()+ " where idVoluntario="+ miembroIdViejo);
    		}else {
    			System.out.println("No era voluntario por lo que Borramos las relaciones de Colaborador y Personal");
    			ResultSet rs1 = selectStmt.executeQuery("Delete from colaborador where idColaborador="+miembro.getIdMiembro());
    			ResultSet rs2 = selectStmt.executeQuery("Delete from personal where idPersonal="+miembro.getIdMiembro());
    			ResultSet rs4 = selectStmt.executeQuery("insert into colaborador (idColaborador,fechaAlta,fechaBaja) VALUES("+miembro.getIdMiembro()+"," + miembro.getVoluntario().getFechaAlta()
    					+"," + miembro.getVoluntario().getFechaBaja()+")");
    		}
    	}
    	System.out.println("Actualizado con exito");
    }
}
