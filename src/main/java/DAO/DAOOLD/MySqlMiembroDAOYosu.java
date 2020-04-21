package DAO.DAOOLD;

import ongEC.*;
import sql.UtilitySql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import DAO.impl.IMiembroDAO;

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
public abstract class MySqlMiembroDAOYosuO implements IMiembroDAO{

    @SuppressWarnings("unused")
	private Miembro miembro;
    
    public static int consultarIdGenerado() throws SQLException {
    	
    	int idGenerado=0;
    	Connection conexion;
    	conexion=MySqlConection.getcon();    		    	
    	Statement selectStmt = conexion.createStatement();  
    	System.out.println("Recogemos el ultimo id de miembros");
    	ResultSet rs = selectStmt.executeQuery("Select MAX(idMiembro) from miembros");
    	while (rs.next()) {
    		idGenerado=rs.getInt(1);
    		System.out.println(idGenerado);
    	}
    	return(idGenerado);
    }
    
    public static void updateMiembroDAOMysql(Miembro miembro, int miembroIdViejo, int opcioncambiotipomiembro) throws SQLException {
    	Connection conexion;
    	conexion=MySqlConection.getcon();    		    	
    	Statement selectStmt = conexion.createStatement();
    	UtilitySql.updateDireccionesMiembro(miembro.getDireccion().getIdDireccion(),miembro.getDireccion().getTipoVia(),miembro.getDireccion().getNumero(),miembro.getDireccion().getPuerta(),
    	miembro.getDireccion().getEscalera(),miembro.getDireccion().getLocalidad(),miembro.getDireccion().getProvincia(),miembro.getDireccion().getCp(),miembro.getDireccion().getPais(),miembroIdViejo);
    	System.out.println("Updateamos Direccion OK");    		
    	System.out.println("Updateamos Miembro");
    	UtilitySql.updateMiembros(Integer.parseInt(miembro.getIdMiembro()),miembro.getNombreMiembro(),miembro.getNombreUsuario(),miembro.getPassword(),miembro.getApellido1(),miembro.getApellido2(),miembro.getDni(),+miembro.getDireccion().getIdDireccion(),miembro.getRol(),
    	miembro.getTelefono(),miembroIdViejo);
    	System.out.println("Updateamos Miembro OK");    		
    	System.out.println("Comprobamos si es Voluntario,Personal,Colaborador");
    	if(opcioncambiotipomiembro!=0) {
	    	if(opcioncambiotipomiembro==3) {
	    		System.out.println("Es Colaborador");
	    		java.sql.Date sqldateFechaAlta = new java.sql.Date(miembro.getColaborador().getFechaAlta().getTime());
				java.sql.Date sqldateFechaBaja = new java.sql.Date(miembro.getColaborador().getFechaBaja().getTime());
	    		ResultSet rs = selectStmt.executeQuery("Select * from colaborador where idColaborador="+miembroIdViejo);
	    		if (rs.getRow()!=0) {
	    			System.out.println("Era colaborador, por lo que actualizamos la base de datos");
	    			UtilitySql.updateColaborador(Integer.parseInt(miembro.getIdMiembro()),sqldateFechaAlta,sqldateFechaBaja,miembroIdViejo);
	    		}else {
	    			System.out.println("No era voluntario por lo que Borramos las relaciones de Colaborador y Personal");
	    			
	    			try {
	    				UtilitySql.deleteVoluntario(miembro.getVoluntario().getIdVoluntario());
	    			}catch(Exception e) {
	    				  //  Block of code to handle errors
	    			}
	    			try {
	    			UtilitySql.deletePersonal(miembro.getPersonal().getIdPersonal());
	    			}catch(Exception e) {
	    				  //  Block of code to handle errors
	    			}
	    			UtilitySql.insertColaborador(Integer.parseInt(miembro.getIdMiembro()),sqldateFechaAlta,sqldateFechaBaja);

	    		}
	    	}else if (opcioncambiotipomiembro==1) {
	    		System.out.println("Es Personal");
	    		java.sql.Date sqldateFechaAlta = new java.sql.Date(miembro.getPersonal().getFechaAlta().getTime());
				java.sql.Date sqldateFechaBaja = new java.sql.Date(miembro.getPersonal().getFechaBaja().getTime());
	    		ResultSet rs7 = selectStmt.executeQuery("Select * from personal where idPersonal="+miembroIdViejo);
	    		if (rs7.getRow()!=0) {
	    			System.out.println("Era personal, por lo que actualizamos la base de datos");
	    			UtilitySql.updatePersonal(Integer.parseInt(miembro.getIdMiembro()),sqldateFechaAlta,sqldateFechaBaja,miembroIdViejo);
	    		}else {
	    			System.out.println("No era Personal por lo que Borramos las relaciones de Colaborador y Personal");
	    			try {
	    			UtilitySql.deleteColaborador(miembro.getColaborador().getIdColaborador());
	    			}catch(Exception e) {
	    				  //  Block of code to handle errors
	    			}
	    			try {
	    			UtilitySql.deleteVoluntario(miembro.getVoluntario().getIdVoluntario());
	    			}catch(Exception e) {
	    				  //  Block of code to handle errors
	    			}
	    			UtilitySql.insertPersonal(Integer.parseInt(miembro.getIdMiembro()),sqldateFechaAlta,sqldateFechaBaja);
	    		}
	    	}else {
	    		System.out.println("Es voluntario");
	    		java.sql.Date sqldateFechaAlta = new java.sql.Date(miembro.getVoluntario().getFechaAlta().getTime());
				java.sql.Date sqldateFechaBaja = new java.sql.Date(miembro.getVoluntario().getFechaBaja().getTime());
	    		System.out.println("Comprobamos si antes era voluntario");
	    		ResultSet rs = selectStmt.executeQuery("Select * from voluntario where idVoluntario="+miembroIdViejo);
	    		if (rs.getRow()!=0) {
	    			System.out.println("Era voluntario, por lo que actualizamos la base de datos");
	    			UtilitySql.updateVoluntario(Integer.parseInt(miembro.getIdMiembro()),sqldateFechaAlta,sqldateFechaBaja, miembro.getVoluntario().getNacional().getOrigen(), miembro.getVoluntario().getInternacional().getPaisOrigen(), miembroIdViejo);
	    			System.out.println("Actualizamos OK ");   					  			
	    		}else {
	    			System.out.println("No era voluntario por lo que Borramos las relaciones de Colaborador y Personal");
	    			try {
	    				UtilitySql.deletePersonal(miembro.getPersonal().getIdPersonal());
		    			}catch(Exception e) {
		    				  //  Block of code to handle errors
		    			}
	    			try {
	    				UtilitySql.deleteColaborador(miembro.getColaborador().getIdColaborador());
		    			}catch(Exception e) {
		    				  //  Block of code to handle errors
		    			}
	    			if (miembro.getVoluntario().getInternacional()==null){
	    				UtilitySql.insertVoluntario(Integer.parseInt(miembro.getIdMiembro()),sqldateFechaAlta,sqldateFechaBaja,miembro.getVoluntario().getNacional().getOrigen(),null);
	    			}
	    			if (miembro.getVoluntario().getNacional()==null) {
	    				UtilitySql.insertVoluntario(Integer.parseInt(miembro.getIdMiembro()),sqldateFechaAlta,sqldateFechaBaja,null ,miembro.getVoluntario().getInternacional().getPaisOrigen());
	    			}
	    				
	    		}
	    	}
    	}
    	System.out.println("Actualizado con exito");
    }
}
