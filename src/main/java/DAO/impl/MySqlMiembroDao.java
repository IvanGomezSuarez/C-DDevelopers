package DAO.impl;


import ongEC.*;
import MYSQL.Sql;

import java.sql.SQLException;
public class MySqlMiembroDao implements IMiembroDAO{


/** La clase MySqlMiembroDAO forma parte del patron DAO.
 *  Permite separar la logica para la persistencia de la logica del negocio.
 *
 *  MySqlMiembroDAO implementa la interfaz IMiembroDAO que declara los metodos que de deberan implementar
 *  todas las instancias DAO Miembro, ya sean XmlMiembroDAO o MySqlDAO.
 *
 *  En el caso de MySqlMiembroDAO se implementa toda la logica necesaria para que Miembro trabaje con MySQL,
 *  tan solo implementamos los metodos basicos CRUD (Create, Read, Update y Delete).
 *
*/
    private Miembro miembro;

    public MySqlMiembroDao() {

        //Implementación de la lógica
        //Inicialización
    }

    public void createMiembroDAO(Miembro miembro) {

       Sql Sql = new Sql();

        //En primer lugar borraremos los contenidos que puedan existir en la Base de datos.
        try {
            Sql.truncateAllContentDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Recorremos Miembro para insertarlo en la BD MySQL.
        for (int i = 0; i < miembro.lequipo.size(); i++) {

            String nombre, primerApellido, segundoApellido, direccion, telefono, mail, paisOrigen = null;

            nombre = miembro.lequipo.get(i).getNombreMiembro();
            primerApellido = miembro.lequipo.get(i).getApellido1();
            segundoApellido = miembro.lequipo.get(i).getApellido2();
            segundoApellido = miembro.lequipo.get(i).getApellido2();
            telefono = miembro.lequipo.get(i).getTelefono();
            direccion = miembro.lequipo.get(i).getDireccion().toString();

            }

            try {

                Sql.insertPersona(nombre, primerApellido, segundoApellido, direccion, telefono, mail);

                int idPersona = utilitySql.consultarIdGenerado("Persona");

                utilitySql.insertPersonal(idPersona);

                int idPersonal = utilitySql.consultarIdGenerado("Personal");

                utilitySql.insertPerVoluntario(numHoras, idPersona, idPersonal);

                //Hasta este punto todos las instancias son PerVoluntario, ahora verificamos si además son voluntarios
                //internacionales, para actuar en consecuencia.
                if ((ong.lequipo.get(i) instanceof PerVolInternacional)) {

                    int idPerVol = utilitySql.consultarIdGenerado("PerVoluntario");

                    utilitySql.insertPerVolInternacional(idPersona, idPersonal, idPerVol, direccion, paisOrigen, telefono);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public Miembro readMiembroDAO() {
        return null;
    }

    public boolean updateMiembroDAO(Miembro pMiembro) {
        return false;
    }

    public boolean deleteMiembroDAO(Miembro pMiembro) {
        return false;
    }
}
