package DAO.impl;


import ongEC.*;
import MYSQL.Sql;

import java.sql.SQLException;
public class MySqlMiembroDao implements IMiembroDAO{


/** La clase MySqlMiembroDAO forma parte del patron DAO.
 *  Permite separar la lógica para la persistencia de la logica del negocio.
 *
 *  MySqlMiembroDAO implementa la interfaz IMiembroDAO que declara los metodos que de deberan implementar
 *  todas las instancias DAO ONG, ya sean XmlMiembroDAO o MySqlDAO.
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

       Sql utilitySql = new Sql();

        //En primer lugar borraremos los contenidos que puedan existir en la Base de datos.
        try {
            utilitySql.truncateAllContentDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Recorremos Miembro para insertarlo en la BD MySQL.
        for (int i = 0; i < miembro.lequipo.size(); i++) {

            String nombre, primerApellido, segundoApellido, direccion, telefono, mail, paisOrigen = null;

            nombre = miembro.lequipo.get(i).getNombre();
            primerApellido = miembro.lequipo.get(i).getPrimerApellido();
            segundoApellido = miembro.lequipo.get(i).getSegundoApellido();
            mail = miembro.lequipo.get(i).getMail();
            PerVoluntario perVoluntario = (PerVoluntario) ong.lequipo.get(i);
            int numHoras = perVoluntario.getNumHorasVol();

            //En función de que sea personal internacional o nacional tabla destino y campos varian
            if (!(ong.lequipo.get(i) instanceof PerVolInternacional)) {
                //Se ejecuta cuando es personal nacional
                telefono = ong.lequipo.get(i).getTelefono();
                direccion = ong.lequipo.get(i).getDireccion().toString();

            } else {
                //Se ejecuta cuando es personal internacional
                PerVolInternacional perVolutarioInternacional = (PerVolInternacional) ong.lequipo.get(i);
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
