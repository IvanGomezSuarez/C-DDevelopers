package DAO.impl;

import ongEC.*;
import sql.UtilitySql;
import DAO.impl.*;

import static java.lang.System.out;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/** La clase MySqlMiembroDAO forma parte del patrón DAO.
 *  Permite separar la lógica para la persistencia de la lógica del negocio.
 *
 *  MySqlMiembroDAO implementa la interfaz IMiembroDAO que declara los métodos que de deberán implementar
 *  todas las instancias DAO Miembro, ya sean XmlMiembroDAO o MySQLDAO.
 *
 *  En el caso de MySqlMiembroDAO se implementa toda la lógica necesaria para que Miembro trabaje con MySQL,
 *  tan solo implementamos los métodos básicos CRUD (Create, Read, Update y Delete).
 *

 * */
public class MySqlMiembroDAO implements IMiembroDAO{

    @SuppressWarnings("unused")
	private Miembro miembro;

    public MySqlMiembroDAO() {

        //ImplementaciÃ³n de la lÃ³gica
        //InicializaciÃ³n
    }


    
    
    @Override
    public void createMiembroDAO(Miembros miembrosNuevos) throws IOException {

        UtilitySql utilitySql = new UtilitySql();

        //En primer lugar borraremos los contenidos que puedan existir en la Base de datos.
        try {
            utilitySql.truncateAllContentDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //Recorremos miembros para insertarlo en la BD MySQL.
        for (int i = 0; i < Miembros.miembro.size(); i++) {

            String nombreMiembro, nombreUsuario, pass, apellido1, apellido2, dni, rol, telefono, origen = null, idMiembro=null,
            paisOrigen = null, tipoVia = null, puerta = null, escalera = null, localidad = null, provincia = null, cp = null, pais= null;
			int idDireccion = 0;
			int numero = 0;
			java.sql.Date sqldateFechaAltaP=null;
			java.sql.Date sqldateFechaBajaP=null;
			
			Date fechaAlta, fechaBaja, fechaAltaP, fechaBajaP, fechaAltaC, fechaBajaC;
		
			idMiembro=miembrosNuevos.getMiembro().get(i).getIdMiembro();
            nombreMiembro = miembrosNuevos.getMiembro().get(i).getNombreMiembro();
            nombreUsuario = miembrosNuevos.getMiembro().get(i).getNombreUsuario();
            pass = miembrosNuevos.getMiembro().get(i).getPassword();
            apellido1 = miembrosNuevos.getMiembro().get(i).getApellido1();
            apellido2 = miembrosNuevos.getMiembro().get(i).getApellido2();
			dni = miembrosNuevos.getMiembro().get(i).getDni();
			Direccion direccion = miembrosNuevos.getMiembro().get(i).getDireccion();
            rol = miembrosNuevos.getMiembro().get(i).getRol();
            telefono = miembrosNuevos.getMiembro().get(i).getTelefono();
            idDireccion = miembrosNuevos.getMiembro().get(i).getDireccion().getIdDireccion();
          
            //En funcion de que sea personal contratado, colaborador o voluntario la tabla destino y campos varian
            //fechaAlta=miembrosNuevos.getMiembro().get(i).getVoluntario().getFechaAlta();
            //fechaAlta = voluntario.setFechaAlta(UtilitySql.getCurrentDate());
        	//java.sql.Date sqldateFechaBaja = new java.sql.Date(Voluntario.getFechaBaja().getTime());
            //java.sql.Date sqldateFechaAltaC = new java.sql.Date(Colaborador.getFechaAlta().getTime());
            //java.sql.Date sqldateFechaBajaC= new java.sql.Date(Colaborador.getFechaBaja().getTime());
           // java.sql.Date sqldateFechaAltaP = new java.sql.Date(Personal.getFechaAlta().getTime());
        	//java.sql.Date sqldateFechaBajaP = new java.sql.Date(Personal.getFechaBaja().getTime());
        	
            try {
            	/*------------INSERTAREMOS LA DIRECCION PRIMERO---------------------------------------------------------*/
            	
           	 utilitySql.insertDireccion(direccion.getIdDireccion(), direccion.getTipoVia(), direccion.getNumero(), direccion.getPuerta(), 
           			 direccion.getEscalera(), direccion.getLocalidad(), direccion.getProvincia(), direccion.getCp(), direccion.getPais());
           	 
           	 /* despues insertamos al miembro*/
         	
             utilitySql.insertPersona(idMiembro,nombreMiembro, nombreUsuario, pass, apellido1, apellido2,dni,idDireccion, rol, telefono);
             
            }catch (SQLException e) {
                e.printStackTrace();
            }
            //DEPENDE DE SI ES personal voluntario o colaborador se inserta lo correspondiente       
            
            if ((miembrosNuevos.getMiembro().get(i).getPersonal() instanceof Personal)) {
                
                sqldateFechaAltaP = new java.sql.Date(miembrosNuevos.getMiembro().get(i).getPersonal().getFechaAlta().getTime());
            	sqldateFechaBajaP = new java.sql.Date(miembrosNuevos.getMiembro().get(i).getPersonal().getFechaBaja().getTime());
                         	
            	try {
            		utilitySql.insertPersonal(Integer.parseInt(miembrosNuevos.getMiembro().get(i).getIdMiembro()), sqldateFechaAltaP, sqldateFechaBajaP);
            	}catch (SQLException e) {
                    e.printStackTrace();
                }

            } else if ((miembrosNuevos.getMiembro().get(i).getVoluntario() instanceof Voluntario)){
                //Se ejecuta cuando es personal voluntario
                //Voluntario voluntario = (Voluntario) miembrosNuevos.getMiembro();
                fechaAlta = miembrosNuevos.getMiembro().get(i).getVoluntario().getFechaAlta();
                fechaBaja = miembrosNuevos.getMiembro().get(i).getVoluntario().getFechaBaja();               
                sqldateFechaAltaP = new java.sql.Date(miembrosNuevos.getMiembro().get(i).getVoluntario().getFechaAlta().getTime());
            	sqldateFechaBajaP = new java.sql.Date(miembrosNuevos.getMiembro().get(i).getVoluntario().getFechaBaja().getTime());
            	
            	try {
            		if(miembrosNuevos.getMiembro().get(i).getVoluntario().getNacional()!=null) {
            			origen = miembrosNuevos.getMiembro().get(i).getVoluntario().getNacional().getOrigen();
            			utilitySql.insertVoluntario(Integer.parseInt(miembrosNuevos.getMiembro().get(i).getIdMiembro()),sqldateFechaAltaP,sqldateFechaBajaP, origen, null);
            		}else {
            			paisOrigen= miembrosNuevos.getMiembro().get(i).getVoluntario().getInternacional().getPaisOrigen();
            			utilitySql.insertVoluntario(Integer.parseInt(miembrosNuevos.getMiembro().get(i).getIdMiembro()),sqldateFechaAltaP,sqldateFechaBajaP, null, paisOrigen);
            		}
            	}catch (SQLException e) {
                    e.printStackTrace();
                }
                
            } else if ((miembrosNuevos.getMiembro().get(i).getColaborador() instanceof Colaborador)) {
                //Colaborador colaborador = (Colaborador) miembrosNuevos.getMiembro();
                fechaAltaC = miembrosNuevos.getMiembro().get(i).getColaborador().getFechaAlta();
                fechaBajaC = miembrosNuevos.getMiembro().get(i).getColaborador().getFechaBaja();
                sqldateFechaAltaP = new java.sql.Date(miembrosNuevos.getMiembro().get(i).getColaborador().getFechaAlta().getTime());
            	sqldateFechaBajaP = new java.sql.Date(miembrosNuevos.getMiembro().get(i).getColaborador().getFechaBaja().getTime());
            	try {
            		utilitySql.insertColaborador(Integer.parseInt(miembrosNuevos.getMiembro().get(i).getIdMiembro()), sqldateFechaAltaP, sqldateFechaBajaP);
              		
            	}catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

    }
    

    @Override
    public Miembro readMiembroDAO() {
        return null;
    }
    
    @Override
    public void updateMiembroDAO(Miembro miembro, int miembroIdViejo, int opcioncambiotipomiembro) throws SQLException {
    	

		Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);
		Connection conexion = sesionSql.conectarBD(nuevaConexion);	    	
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

    
    @Override
    public void deleteMiembroDAO(Miembro miembro)throws SQLException {
    	
    	Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);
		Connection newConnection = sesionSql.conectarBD(nuevaConexion);    	
    	Statement selectStmt = newConnection.createStatement();

		// Comprobamos que los datos son los que esperabamos.

		out.println("Intentando conectarse con los siguientes datos:");
		out.println(nuevaConexion.toString());

		// Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
		//conectar con la base de datos deseada.



		String sentenciaSql = "CALL delete_personal(?);";

		PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
		ps.setInt(1, Integer.parseInt(miembro.getIdMiembro()));

		ps.executeUpdate();

		String sentenciaSql1 = "CALL delete_voluntario(?);";

		PreparedStatement ps1 = newConnection.prepareStatement(sentenciaSql1);
		ps1.setInt(1, Integer.parseInt(miembro.getIdMiembro()));

		ps1.executeUpdate();

		String sentenciaSql2 = "CALL delete_colaborador(?);";

		PreparedStatement ps2 = newConnection.prepareStatement(sentenciaSql2);
		ps2.setInt(1, Integer.parseInt(miembro.getIdMiembro()));

		ps2.executeUpdate();

		String sentenciaSql3 = "CALL delete_miembro(?);";

		PreparedStatement ps3 = newConnection.prepareStatement(sentenciaSql3);
		ps3.setInt(1, Integer.parseInt(miembro.getIdMiembro()));

		ps3.executeUpdate();

		String sentenciaSql4 = "CALL delete_direccion(?);";

		PreparedStatement ps4 = newConnection.prepareStatement(sentenciaSql4);
		ps4.setInt(1, miembro.getDireccion().getIdDireccion());

		ps4.executeUpdate();
		out.println("Borrado ok");
    }
    
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
	   	Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);
		Connection newConnection = sesionSql.conectarBD(nuevaConexion);    	
    	Statement selectStmt = newConnection.createStatement();
    	
    	ResultSet rs = selectStmt.executeQuery("SELECT * FROM producto3.miembros inner join voluntario on idMiembro=idVoluntario inner join direccionesUsuarios on direccion=idDireccion ");
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
        newConnection = sesionSql.conectarBD(nuevaConexion);    	
    	Statement selectStmt1 = newConnection.createStatement();
        ResultSet rs1 = selectStmt1.executeQuery("SELECT * FROM producto3.miembros inner join personal on idMiembro=idPersonal inner join direccionesUsuarios on direccion=idDireccion ");
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
        newConnection = sesionSql.conectarBD(nuevaConexion);    	
    	Statement selectStmt2 = newConnection.createStatement();
        ResultSet rs2 = selectStmt2.executeQuery("SELECT * FROM producto3.miembros inner join colaborador on idMiembro=idColaborador inner join direccionesUsuarios on direccion=idDireccion");
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
    	Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);
		Connection newConnection = sesionSql.conectarBD(nuevaConexion);    	
    	Statement selectStmt = newConnection.createStatement();
    	System.out.println("Recogemos el ultimo id de miembros");
    	ResultSet rs = selectStmt.executeQuery("Select MAX(idMiembro) from miembros");
    	while (rs.next()) {
    		idGenerado=rs.getInt(1);
    		System.out.println(idGenerado);
    	}
    	return(idGenerado);
    }
}
