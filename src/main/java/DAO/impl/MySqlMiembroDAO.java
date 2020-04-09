package DAO.impl;

import ongEC.*;
import ongEC.Voluntario;
import sql.UtilitySql;

import java.sql.SQLException;
import java.util.Date;

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
public class MySqlMiembroDAO implements IMiembroDAO{

    @SuppressWarnings("unused")
	private Miembro miembro;

    public MySqlMiembroDAO() {

        //Implementación de la lógica
        //Inicialización
    }

    @Override
    public void createMiembroDAO(Miembros miembrosNuevos) {

        UtilitySql utilitySql = new UtilitySql();

        //En primer lugar borraremos los contenidos que puedan existir en la Base de datos.
        try {
            utilitySql.truncateAllContentDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Recorremos miembros para insertarlo en la BD MySQL.
        for (int i = 0; i < Miembros.miembro.size(); i++) {

            String nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, rol, telefono = null;
			Direccion direccion;
			Date fechaAlta, fechaBaja, fechaAltaP, fechaBajaP, fechaAltaC, fechaBajaC;

            nombreMiembro = Miembros.miembro.get(i).getNombreMiembro();
            nombreUsuario = Miembros.miembro.get(i).getNombreUsuario();
            password = Miembros.miembro.get(i).getPassword();
            direccion = Miembros.miembro.get(i).direccion;
            apellido1 = Miembros.miembro.get(i).getApellido1();
            apellido2 = Miembros.miembro.get(i).getApellido2();
            dni = Miembros.miembro.get(i).getDni();
            direccion = Miembros.miembro.get(i).getDireccion();
            rol = Miembros.miembro.get(i).getRol();
            telefono = Miembros.miembro.get(i).getTelefono();
            // �COMO LECHES COJO LOS DATOS DE TODO EL ARRAY?
           
            //En funcion de que sea personal contratado, colaborador o voluntario la tabla destino y campos varian
            if (!(Miembros.miembro.get(i) instanceof Personal)) {
                //Se ejecuta cuando es personal nacional
                fechaAltaP = Personal.getFechaAlta();
                fechaBajaP = Personal.getFechaBaja();

            } else if (!(Miembros.miembro.get(i) instanceof Voluntario)){
                //Se ejecuta cuando es personal voluntario
                Voluntario voluntario = (Voluntario) Miembros.miembro.get(i);
                fechaAlta = Voluntario.getFechaAlta();
                fechaBaja = Voluntario.getFechaBaja();
                
            } else if (!(Miembros.miembro.get(i) instanceof Colaborador)) {
                Colaborador colaborador = (Colaborador) Miembros.miembro.get(i);
                fechaAltaC = Colaborador.getFechaAlta();
                fechaBajaC = Colaborador.getFechaBaja();
            }
            
            try {

                utilitySql.insertPersona(nombreMiembro, nombreUsuario, password, apellido1, apellido2, dni, Direccion direccion, rol, telefono);

                int idPersona = utilitySql.consultarIdGenerado("Persona");

                utilitySql.insertPersonal(idPersona);

               // int idPersonal = utilitySql.consultarIdGenerado("Personal");

              //  utilitySql.insertPerVoluntario(numHoras, idPersona, idPersonal);

                //Hasta este punto todos las instancias son PerVoluntario, ahora verificamos si además son voluntarios
                //internacionales, para actuar en consecuencia.
           /*     if ((Miembros.miembro.get(i) instanceof Personal)) {

                    int idPerVol = utilitySql.consultarIdGenerado("PerVoluntario");

                    utilitySql.insertPerVolInternacional(idPersona, idPersonal, idPerVol, direccion, paisOrigen, telefono);

                }
*/
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

	public void createMiembroDAO1(Miembros miembrosNuevos) {
		// TODO Auto-generated method stub
		
	}
}
