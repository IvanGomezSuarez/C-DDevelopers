package sql;

import java.util.*;
import java.sql.*;
import ongEC.*;

public class Prueba_Sql {


    public static void main(String[] args) {

        // Creamos un objeto menuSQL para mostrar el menu y realizar operaciones del mismo
        MenuSQL m = new MenuSQL();
        // Creamos un objeto UtilitySQL para realizar operaciones SQL posteriormente
        UtilitySql u = new UtilitySql();
        // Creamos dos objetos (Conexion y Connection) con estado inicial NULL.
        Conexion nuevaConexion = null;
        Connection newConnection = null;

        m.mostrarCabeceraMenuSQL(nuevaConexion, newConnection);






//        try {
//
//            //1.Creamos una conexion a la base de datos mediante un objeto Connection
//
//            Connection miConexion = DriverManager.getConnection("jdbc:mysql://192.168.168.111:3306/entreculturas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
//                    "root", "Qs122prt@34");
//
//            //2.Creamos un objeto Statement, para poder crear una sentencia después
//
//            Statement miStatement = miConexion.createStatement();
//
//            //3.Creamos un objeto ResultSet para ejecutar una sentencia SQL utilizando el método executeQuery()
//
//            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM Personal;");
//
//            //4.Utilizamos un ciclo while para mostrar los campos indicados mediante el método getString()
//
//            while (miResultSet.next()) {
//
//
//                System.out.println(miResultSet.getString("idPersonal") + " - " +
//                        miResultSet.getString("segundoApellido") + " " + miResultSet.getString("primerApellido") + ", " +
//                        miResultSet.getString("nombre") );
//            }
//        } catch (SQLException e) {
//            System.out.println("Error al mostrar la consulta.");
//            e.printStackTrace();
//        }

    }

    // Clase con los métodos para mostrar un menú y operaciones relacionadas con SQL para realizar pruebas

    public static class MenuSQL {

        // Creamos un objeto menusConsola para emplear algunos de los métodos de dicha clase
        MenusConsola mc = new MenusConsola();

        // METODOS DE CLASE
        // ----------------------------------------------------------------------
        // Muestra la cabecera con el estado de la conexión

        public void mostrarCabeceraMenuSQL(Conexion nuevaConexion, Connection newConnection) {

            mc.clearScreen();
            System.out.println("---------------------------------------------------------------");
            System.out.println("                 Entreculturas - Pruebas SQL");
            System.out.println("---------------------------------------------------------------");
            if(nuevaConexion == null) {
                System.out.println("Estado: sin conexion");
                } else {
                    System.out.println("Estado: conectado\n" + nuevaConexion.toString());
                }

            mostrarMenuSQL(nuevaConexion, newConnection);
        }

        // Muestra el menú principal

        public void mostrarMenuSQL(Conexion nuevaConexion, Connection newConnection) {

            System.out.println("\n1 - Conectar a una base de datos");
            System.out.println("2 - Crear tablas");
            System.out.println("3 - Insertar registros");
            System.out.println("0 - Salir de la aplicacion");

            elegirOpcion(nuevaConexion, newConnection);

        }

        public void elegirOpcion(Conexion nuevaConexion, Connection newConnection) throws InputMismatchException{

            // Creamos un objeto UtilitySQL para realizar operaciones SQL posteriormente
            UtilitySql u = new UtilitySql();
            int opcion;
            boolean escogido = false;
            Scanner entrada = new Scanner(System.in);
            System.out.print("\nEscoja una opción: ");

            while(!escogido) {

                try {
                    opcion = entrada.nextInt();
                    switch(opcion) {

                        case 1:
                            escogido = true;
                            nuevaConexion = new Conexion();
                            // Conectamos a la base de datos con los datos obtenidos utilizando el método conectarBD.
                            // Previamente creamos un objeto Connection y le asignamos la salida de conectarBD
                            newConnection = u.conectarBD(nuevaConexion);
                            mc.pulseEnterParaContinuar();
                            mostrarCabeceraMenuSQL(nuevaConexion, newConnection);
                            break;
                        case 2:
                            escogido = true;
                            mc.clearScreen();
                            crearTabla(u, newConnection);
                            mc.pulseEnterParaContinuar();
                            mostrarCabeceraMenuSQL(nuevaConexion, newConnection);
                            break;
                        case 3:
                            escogido = true;
                            boolean insertEscogido = false;
                            mc.clearScreen();
                            Scanner tipoInsercion = new Scanner(System.in);
                            System.out.println("1 - Importar desde archivo XML");
                            System.out.println("2 - Insertar registro manualmente");
                            System.out.print("\nEscoja una opción:");

                           while(!insertEscogido) {
                               try {
                                   int opcionInsert = tipoInsercion.nextInt();
                                   switch(opcionInsert) {
                                       case 1:
                                           System.out.println("Opción no implementada.");
                                           break;
                                       case 2:
                                           insertarRegistro(u, newConnection);
                                           mc.pulseEnterParaContinuar();
                                           mostrarCabeceraMenuSQL(nuevaConexion, newConnection);
                                           break;

                                   }
                               } catch (InputMismatchException e) {
                                   System.out.print( "Solo se aceptan las opciones indicadas. Pruebe de nuevo:  " );
                                   tipoInsercion.next();
                               }

                           }

                        case 0:
                            escogido = true;
                            System.out.println("Saliendo de la aplicación.");
                            if(newConnection != null) {
                                try {
                                    newConnection.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.exit(0);
                        default:
                            System.out.println("Opción no válida. Pruebe de nuevo: ");
                            entrada.next();
                    }

                } catch (InputMismatchException e) {
                    System.out.print( "Solo se aceptan las opciones indicadas. Pruebe de nuevo:  " );
                    entrada.next();

                } // fin de try..catch

            } // fin de while

        } // fin del método elegirOpcion

        public void crearTabla(UtilitySql u, Connection newConnection) {

        Scanner entrada = new Scanner(System.in);
            System.out.println("Introduzca la sentencia SQL completa para crear la tabla deseada:");
        String sentencia = entrada.nextLine();
            u.sentenciaDDL(newConnection, sentencia);

        } // fin del método crearTabla

        public void insertarRegistro(UtilitySql u, Connection newConnection) {

            Scanner entrada = new Scanner(System.in);
            System.out.println("Introduzca la sentencia SQL completa para crear el registro deseada:");
            String sentencia = entrada.nextLine();
            u.sentenciaDML(newConnection, sentencia);

        } // fin del método crearTabla

    }// fin de la clase MenuSQL

} // fin de la clase Prueba_Sql


