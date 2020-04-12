package DAO.impl;

import ongEC.*;
import sql.UtilitySql;
import DAO.impl.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
       /* try {
            utilitySql.truncateAllContentDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
        //Recorremos miembros para insertarlo en la BD MySQL.
        for (int i = 0; i < Miembros.miembro.size(); i++) {

            String nombreMiembro, nombreUsuario, pass, apellido1, apellido2, dni, rol, telefono, origen = null, paisOrigen = null,
            		tipoVia = null, puerta = null, escalera = null, localidad = null, provincia = null, cp = null, pais = null;
			int idDireccion = 0, numero = 0; Direccion direccion;
			Date fechaAlta, fechaBaja, fechaAltaP, fechaBajaP, fechaAltaC, fechaBajaC;
		

            nombreMiembro = Miembros.miembro.get(i).getNombreMiembro();
            nombreUsuario = Miembros.miembro.get(i).getNombreUsuario();
            pass = Miembros.miembro.get(i).getPass();
           // direccion = Miembros.miembro.get(i).direccion;
            apellido1 = Miembros.miembro.get(i).getApellido1();
            apellido2 = Miembros.miembro.get(i).getApellido2();
			dni = Miembros.miembro.get(i).getDni();
			direccion = miembrosNuevos.getMiembro().get(i).getDireccion();
            rol = Miembros.miembro.get(i).getRol();
            telefono = Miembros.miembro.get(i).getTelefono();
          
            //En funcion de que sea personal contratado, colaborador o voluntario la tabla destino y campos varian
            
            //java.sql.Date sqldateFechaAlta = new java.sql.Date(Voluntario.getFechaAlta().getTime());
        	//java.sql.Date sqldateFechaBaja = new java.sql.Date(Voluntario.getFechaBaja().getTime());
            //java.sql.Date sqldateFechaAltaC = new java.sql.Date(Colaborador.getFechaAlta().getTime());
        	//java.sql.Date sqldateFechaBajaC= new java.sql.Date(Colaborador.getFechaBaja().getTime());
            //java.sql.Date sqldateFechaAltaP = new java.sql.Date(Personal.getFechaAlta().getTime());
        	//java.sql.Date sqldateFechaBajaP = new java.sql.Date(Personal.getFechaBaja().getTime());
        	
          /*  if (!(Miembros.miembro.get(i) instanceof Personal)) {
                
                fechaAltaP = Personal.getFechaAlta();
                fechaBajaP = Personal.getFechaBaja();

            } else if (!(miembrosNuevos.getMiembro().get(i) instanceof Voluntario)){
                //Se ejecuta cuando es personal voluntario
                Voluntario voluntario = (Voluntario) miembrosNuevos.getMiembro();
                fechaAlta = Voluntario.getFechaAlta();
                fechaBaja = Voluntario.getFechaBaja();
                origen = Voluntario.getOrigen();
                paisOrigen= Voluntario.getPaisOrigen();
                
            } else if (!(miembrosNuevos.getMiembro().get(i) instanceof Colaborador)) {
                Colaborador colaborador = (Colaborador) miembrosNuevos.getMiembro();
                fechaAltaC = Colaborador.getFechaAlta();
                fechaBajaC = Colaborador.getFechaBaja();

            }
            */
            try {
            	
            	/*------------INSERTAREMOS LA DIRECCION PRIMERO---------------------------------------------------------*/
            	
            	 utilitySql.insertDireccion(idDireccion, tipoVia, numero, puerta, escalera, localidad, provincia, cp, pais);
            	
                 //utilitySql.insertPersona(nombreMiembro, nombreUsuario, pass, apellido1, apellido2, dni, rol, telefono);
                
               
                

                //int idPersonal = utilitySql.consultarIdGenerado("miembros");

               // utilitySql.insertPersonal(idPersonal, sqldateFechaAltaP, sqldateFechaBajaP);

                //int idVoluntario = utilitySql.consultarIdGenerado("miembros");

                //utilitySql.insertVoluntario(idVoluntario, origen, paisOrigen);
                
                //int idColaborador = utilitySql.consultarIdGenerado("miembros");

                //utilitySql.insertColaborador(idColaborador, fechaAltaC, fechaBajaC);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    

    @Override
    public Miembro readMiembroDAO() {
        return null;
    }

    @Override
    public boolean updateMiembroDAO(Miembro pMiembro) {
        return false;
    }

    @Override
    public boolean deleteMiembroDAO(Miembro pMiembro) {
        return false;
    }

}
