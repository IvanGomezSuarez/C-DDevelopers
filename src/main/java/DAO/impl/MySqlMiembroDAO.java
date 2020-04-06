package DAO.impl;

import ongEC.*;
import sql.UtilitySql;

import java.sql.SQLException;

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
public abstract class MySqlMiembroDAO implements IMiembroDAO{

    @SuppressWarnings("unused")
	private Miembro miembro;

    public MySqlMiembroDAO() {

        //Implementación de la lógica
        //Inicialización
    }

    @Override
    public void createMiembroDAO(Miembro miembro) {

        UtilitySql utilitySql = new UtilitySql();

        //En primer lugar borraremos los contenidos que puedan existir en la Base de datos.
        try {
            utilitySql.truncateAllContentDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Recorremos miembros para insertarlo en la BD MySQL.
        for (int i = 0; i < Miembros.miembro.size(); i++) {

            String nombre, primerApellido, segundoApellido, direccion, telefono, mail, paisOrigen = null;

            nombre = Miembros.miembro.get(i).getNombreMiembro();
           
            //En función de que sea personal internacional o nacional tabla destino y campos varian
            if (!(Miembros.miembro.get(i) instanceof Voluntario)) {
                //Se ejecuta cuando es personal nacional
                telefono = Miembros.miembro.get(i).getTelefono();
                

            } else {
                //Se ejecuta cuando es personal voluntario
                Voluntario voluntario = (Voluntario) Miembros.miembro.get(i);
                telefono = perVolutarioInternacional.getCodInternaTelefono() + " " + perVolutarioInternacional.getTelefono();
                direccion = perVolutarioInternacional.getDir();
                paisOrigen = perVolutarioInternacional.getPaisOrigen();

            }

            try {

                utilitySql.insertPersona(nombre, primerApellido, segundoApellido, direccion, telefono, mail);

                int idPersona = utilitySql.consultarIdGenerado("Persona");

                utilitySql.insertPersonal(idPersona);

                int idPersonal = utilitySql.consultarIdGenerado("Personal");

                utilitySql.insertPerVoluntario(numHoras, idPersona, idPersonal);

                //Hasta este punto todos las instancias son PerVoluntario, ahora verificamos si además son voluntarios
                //internacionales, para actuar en consecuencia.
                if ((Miembros.miembro.get(i) instanceof Personal)) {

                    int idPerVol = utilitySql.consultarIdGenerado("PerVoluntario");

                    utilitySql.insertPerVolInternacional(idPersona, idPersonal, idPerVol, direccion, paisOrigen, telefono);

                }

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