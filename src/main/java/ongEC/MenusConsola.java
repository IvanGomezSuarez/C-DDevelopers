package ongEC;

import DAO.impl.*;
import ongEC.*;
import MYSQL.Sql;

import javax.xml.bind.*;
import java.io.File;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**Esta clase contiene todos los métodos que se encargan de interactuar con el usuario desde consola.
 *
 * */
public class MenusConsola implements IMiembroDAO {

    /**
     * Método para borrar la pantalla de la consola (multiplataforma)
     *
     */
    public void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    } // fin del método clearScreen

    /**
     * Método que muestra el menú principal de la aplicación
     *
     * @param ong objeto ONG
     */
    public void mostrarMenuPrincipal(Miembro miembro) throws SQLException {

        clearScreen();
        System.out.println( "-----------------  ENTRECULTURAS  ---------------");
        System.out.println( "  ONG jesuíta para la educación y el desarrollo");
        System.out.println( "-------------------------------------------------");
        System.out.println();
        System.out.println(  "1 - Dar de alta un empleado" );
        System.out.println(  "2 - Dar de baja un empleado" );
        System.out.println(  "3 - Mostrar datos del sistema" );
        System.out.println(  "4 - Opciones persistencia" );
        System.out.println(  "5 - Salir de la aplicación" );
        System.out.println();
        System.out.println(  "Seleccione una opción: ");

        seleccionarOpcionDeMenu(miembro);

    } // fin del método mostrarMenu

    /**
     * Método para seleccionar una opción del menú principal.
     * Llama a los métodos adecuados en función de la opción escogida.
     *
     * @param ong objeto ONG
     */
    public void seleccionarOpcionDeMenu(Miembro miembro) throws SQLException {

        Scanner entrada = new Scanner( System.in );
        boolean salir = false;

        while (!salir) {

            try {

                int opcion = entrada.nextInt();

                switch (opcion) {

                    /*case 1:
                        clearScreen();
                        seleccionarTipoEmpleado(miembro);
                        salir = true;
                        break;
                    case 2:
                        clearScreen();
                        System.out.println("Lo sentimos. Función no implementada.");
                        pulseEnterParaContinuar();
                        clearScreen();
                        mostrarMenuPrincipal(miembro);
                        salir = true;
                        break;
                    case 3:
                        clearScreen();
                        seleccionarTipoListado(miembro);
                        salir = true;
                        break;
                    case 4:
                        seleccionarOpcionesPersistencia(miembro);
                        salir = true;
                        break;
                    case 5:
                        System.out.println("\nSaliendo del programa. Gracias por usar nuestra aplicación.");
                        salir = true;
                        break;
                    default:
                        System.out.print("Selección no válida. Pruebe de nuevo: ");
                } // fin de switch
            } catch ( InputMismatchException e ) {

                System.out.print( "Solo se aceptan las opciones indicadas. Pruebe de nuevo:  " );
                entrada.next();

            } // fin de try...catch

        } // fin de while

    } // fin del método seleccionarOpcionDeMenu
*/
    /**
     * Método para seleccionar el tipo de empleado a dar de alta.
     * Según el tipo de empleado seleccionado, crea un objeto apropiado y llama
     * al método correspondiente.
     * @param ong objeto ONG
     */
/*    public void seleccionarTipoEmpleado(ONG ong) throws SQLException {

        Scanner entrada = new Scanner( System.in );
        boolean salir = false;
        System.out.println( "Seleccione el tipo de empleado a dar de alta:" );
        System.out.println( "1 - Personal voluntario" );
        System.out.println( "2 - Personal voluntario internacional" );
        System.out.print(  "\nSu elección: ");

        while (!salir) {

            try {

                int opcion = entrada.nextInt();

                switch (opcion) {

                    case 1:
                        clearScreen();
                        PerVoluntario perVol = new PerVoluntario();
                        perVol.introducirDatosPersona();
                        // Mostramos los datos del empleado
                        System.out.println("\n" + perVol.toString());
                        //Añadimos el nuevo empleado a la ONG
                        ong.addEquipo(perVol);
                        //TODO: ¿alguna forma de guardar los cambios aquí?
                        //Comprobar si funciona ésto...
                        createOngDAO(ong);
                        pulseEnterParaContinuar();
                        clearScreen();
                        mostrarMenuPrincipal(ong);
                        salir = true;
                        break;
                    case 2:
                        clearScreen();
                        PerVolInternacional perVolInt = new PerVolInternacional();
                        perVolInt.introducirDatosPersona();
                        // Mostramos los datos del empleado
                        System.out.println("\n" + perVolInt.toString());
                        //Añadimos el nuevo empleado a la ONG
                        ong.addEquipo(perVolInt);
                        //TODO: ¿alguna forma de guardar los cambios aquí?
                        //Comprobar si funciona ésto...
                        createOngDAO(ong);
                        pulseEnterParaContinuar();
                        clearScreen();
                        mostrarMenuPrincipal(ong);
                        salir = true;
                        break;
                    default:
                        System.out.print("Selección no válida. Pruebe de nuevo: ");
                        opcion = entrada.nextInt();

                } // fin de switch

            } catch ( InputMismatchException e ) {

                System.out.print( "Solo se aceptan las opciones indicadas. Pruebe de nuevo:  " );
                entrada.next();

            } // fin de try...catch

        } // fin de while

    } // fin del método seleccionarTipoEmpleado

    /**
     * Método para seleccionar el tipo de empleado a dar de alta.
     * Según el tipo de empleado seleccionado, crea un objeto apropiado y llama
     * al método correspondiente.
     * @param ong objeto ONG
     */
    public void seleccionarOpcionesPersistencia(Miembro miembro) throws SQLException {

        Scanner entrada = new Scanner( System.in );
        boolean salir = false;
        System.out.println( "Seleccione una de las siguientes opciones:" );
        System.out.println( "1 - Seleccionar fuente de datos: XML" );
        System.out.println( "2 - Seleccionar fuente de datos: MySQL" );
        System.out.println( "3 - Cargar datos desde el XML a MySQL" );
        System.out.println( "4 - Cargar datos desde MySQL a XML" );
        System.out.println( "5 - Volver al menú principal" );
        System.out.print(  "\nSu elección: ");

        while (!salir) {

            try {

                int opcion = entrada.nextInt();

                switch (opcion) {

                    case 1:
                        clearScreen();
                        Main.sourceSelected = Main.sourceType.XML;
                     //   Main = DAOFactory.getDAOFactory(DAOFactory.XML);
                        System.out.println("Persistencia fijada en XML con éxito!");
                        pulseEnterParaContinuar();
                        clearScreen();
                        mostrarMenuPrincipal(ong);
                        salir = true;
                        break;
               /*     case 2:
                        clearScreen();
                        Main.sourceSelected = Main.sourceType.MySQL;
                        Main.objetoFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
                        System.out.println("Persistencia fijada en MySQL con éxito!");
                        pulseEnterParaContinuar();
                        clearScreen();
                        mostrarMenuPrincipal(ong);
                        salir = true;
                 */       break;
                    case 3:
                        clearScreen();
                        DAOFactory.getDAOFactory(DAOFactory.MYSQL).getMiembrosDAO().createMiembroDAO(miembro);
                        System.out.println("Datos cargados correctamente de XML a MySQL!");
                        pulseEnterParaContinuar();
                        clearScreen();
                        seleccionarOpcionesPersistencia(miembro);
                        salir = true;
                        break;
                    case 4:
                        clearScreen();
                        System.out.println("Lo sentimos. Función no implementada.");
                        pulseEnterParaContinuar();
                        clearScreen();
                        mostrarMenuPrincipal(ong);
                        salir = true;
                        break;
                    case 5:
                        clearScreen();
                        mostrarMenuPrincipal(ong);
                        salir = true;
                        break;
                    default:
                        System.out.print("Selección no válida. Pruebe de nuevo: ");
                        opcion = entrada.nextInt();

                } // fin de switch

            } catch ( InputMismatchException e ) {

                System.out.print( "Solo se aceptan las opciones indicadas. Pruebe de nuevo:  " );
                entrada.next();

            } // fin de try...catch

        } // fin de while

    } // fin del método seleccionarTipoEmpleado

    /**
     * Método para seleccionar el tipo de listado a mostrar.
     * Según el tipo de listado, crea un objeto apropiado y llama
     * al método correspondiente.
     *
     * @param ong objeto ONG
     */
    public void seleccionarTipoListado(ONG ong) throws SQLException {

        Scanner entrada = new Scanner( System.in );
        boolean salir = false;
        System.out.println( "Seleccione los tipos de datos a consultar:" );
        System.out.println( "1 - Detalles ONG" );
        System.out.println( "2 - Listado de personal" );
        System.out.println( "3 - Listado de proyectos" );
        System.out.println( "4 - Volver al menú principal" );
        System.out.print(  "\nSu elección: ");

        while (!salir) {

            try {

                int opcion = entrada.nextInt();

                switch (opcion) {

                    case 1:
                        clearScreen();
                        System.out.printf("%s", ong.toString());
                        pulseEnterParaContinuar();
                        seleccionarTipoListado(ong);
                        salir = true;
                        break;
                    case 2:
                        clearScreen();
                        ong.lequipo.forEach(Personal -> System.out.printf(Personal.toString()+"\n"));
                        pulseEnterParaContinuar();
                        seleccionarTipoListado(ong);
                        salir = true;
                        break;
                    case 3:
                        clearScreen();
                        ong.lproyectos.forEach(Proyecto -> System.out.printf(Proyecto.toString()+"\n"));
                        pulseEnterParaContinuar();
                        seleccionarTipoListado(ong);
                        salir = true;
                        break;
                    case 4:
                        clearScreen();
                        mostrarMenuPrincipal(ong);
                        salir = true;
                        break;
                    default:
                        System.out.print("Selección no válida. Pruebe de nuevo: ");
                        opcion = entrada.nextInt();

                } // fin de switch

            } catch ( InputMismatchException e ) {

                System.out.print( "Solo se aceptan las opciones indicadas. Pruebe de nuevo:  " );
                entrada.next();

            } // fin de try...catch

        } // fin de while

    } // fin del método seleccionarTipoEmpleado

    /**
     * Método para continuar tras pulsar la tecla Enter.
     *
     */
    public void pulseEnterParaContinuar() {

        String tecla;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Presione Enter para continuar...");

        try {

            tecla = teclado.nextLine();

        }

        catch(Exception e)

        {}

    } // fin del método pulseEnterParaContinuar

    @Override
    public void createMiembroDAO(Miembro miembro) {


        try {

            //Hacemos un marshaller para transformar la instancia ong en un archivo xml.
            JAXBContext jaxbContext = JAXBContext.newInstance(Miembro.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File archivoXML = new File("XML/Miembro.xml");
            marshaller.marshal(Miembro, archivoXML);
            System.out.println("¡Cambios guardados correctamente en \"" + archivoXML.getAbsolutePath() + "\"!");

        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ONG readOngDAO() {

//        try {
//
//            File file = new File("XML/ong.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(ONG.class);
//            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            ong = (ONG) unmarshaller.unmarshal(file);
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

        return null;
    }

    @Override
    public boolean updateOngDAO(ONG pONG) {

        //Implementación de la lógica
        //Modifica la instancia de ONG.
        //Devuelve false si no se ha podido modificar los datos.

        return false;
    }

    @Override
    public boolean deleteOngDAO(ONG pONG) {

        //Implementación de la lógica
        //Elimina la instancia de ONG.
        //Devuelve false si no se ha podido eliminar los datos.

        return false;
    }

}
