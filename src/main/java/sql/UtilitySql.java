package sql;

import ongEC.*;

import java.sql.*;
import java.util.Scanner;
import DAO.impl.*;
import static java.lang.System.*;

/**La clse UtilitySql contiene todos los métodos necesarios para realizar operaciones
 * desde Java sobre una base de datos, incluyendo la conexión inicial con la BD.
 *
 * @author Aware Developers
 * @version 1.2
 *
 */

public class UtilitySql {
    //Variables de clase
    //Ub objeto Conexion que llamará a los métodos deseados.
    Conexion miConexion;

    //Constructores
    public UtilitySql() {
        Conexion miConexion = new Conexion();
    }

    public UtilitySql(Conexion miConexion) {
        this.miConexion = miConexion;
    }

    //Getters y Setters
    public Conexion getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Conexion miConexion) {
        this.miConexion = miConexion;
    }

    // Método main. Nos servirá para crear la base de datos.
    public static void main(String[] args) {

        // Creamos un objeto UtilitySql y un objeto ConexionBaseDeDatos.
        // Al usar el constructor por defecto de ConexionBaseDeDatos que hemos implementado,
        // se nos creará un objeto ConexionBaseDeDatos con los datos de conexión adecuados
        // para nuestro ejemplo.

        Conexion nuevaConexion = new Conexion();
        UtilitySql sesionSql = new UtilitySql(nuevaConexion);

        // Comprobamos que los datos son los que esperábamos.

        out.println("Intentando conectarse con los siguientes datos:");
        out.println(nuevaConexion.toString());

        // Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
        //conectar con la base de datos deseada.

        Connection newConnection = sesionSql.conectarBD(nuevaConexion);

    }


    // Métodos de clase

    /*---------------METODOS PARA CAPTURAR Y ASIGNAR LOS ID'S--------------------------------------*/

    // METODO PARA GENERAR ID EN LA TABLA MIEMBRO Y QUE SEAN SIEMPRE CONSECUTIVOS

    public static int generarIdDireccion() throws SQLException {

    	int idGenerado=0;
    	Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);
		Connection conexion = sesionSql.conectarBD(nuevaConexion);	    	
    	Statement selectStmt = conexion.createStatement();
    	System.out.println("Recogemos el ultimo id de Direcciones\n");
    	ResultSet rs = selectStmt.executeQuery("Select MAX(idDireccion) from direccionesusuarios");
    	while (rs.next()) {
    		idGenerado=rs.getInt(1)+1;
    		System.out.println("el id de Direcciones ser�:" + "" + idGenerado);
    	}
    	return(idGenerado);
    }


    public static int generarIdPersonal() throws SQLException {

    	int idGenerado=0;
    	Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);
		Connection conexion = sesionSql.conectarBD(nuevaConexion);	    	
    	Statement selectStmt = conexion.createStatement();
    	System.out.println("Recogemos el ultimo id de Miembro\n");
    	ResultSet rs = selectStmt.executeQuery("Select MAX(IdMiembro) from miembros");
    	while (rs.next()) {
    		idGenerado=rs.getInt(1)+1;
    		System.out.println("el id de la nueva persona contratada ser�:" + "" + idGenerado);
    	}
    	return(idGenerado);
    }


    public static int generarIdVoluntario() throws SQLException {

    	int idGenerado=0;
    	Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);
		Connection conexion = sesionSql.conectarBD(nuevaConexion);	    	
    	Statement selectStmt = conexion.createStatement();
    	System.out.println("Recogemos el ultimo id de Miembro\n");
    	ResultSet rs = selectStmt.executeQuery("Select MAX(IdMiembro) from miembros");
    	while (rs.next()) {
    		idGenerado=rs.getInt(1)+1;
    		System.out.println("el id de la nueva persona voluntario/a ser�:" + "" + idGenerado);
    	}
    	return(idGenerado);
    }


    public static int generarIdColaborador() throws SQLException {

    	int idGenerado=0;
    	Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);
		Connection conexion = sesionSql.conectarBD(nuevaConexion);	    	
    	Statement selectStmt = conexion.createStatement();
    	System.out.println("Recogemos el ultimo id de Miembro\n");
    	ResultSet rs = selectStmt.executeQuery("Select MAX(IdMiembro) from miembros");
    	while (rs.next()) {
    		idGenerado=rs.getInt(1)+1;
    		System.out.println("el id de la nueva persona colaborador/a ser�:" + "" + idGenerado);
    	}
    	return(idGenerado);
    }
    // ESTE M�TODO INSERTA EN LA COLUMNA DIRECCION DE LA TABLA MIEMBROS EL ID DE LA TABLA DIRECCIONES
    public static int generarColDireccion() throws SQLException {

    	int idGenerado=0;
    	Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);
		Connection conexion = sesionSql.conectarBD(nuevaConexion);	    	
    	Statement selectStmt = conexion.createStatement();
    	System.out.println("Recogemos el ultimo id de Direcciones\n");
    	ResultSet rs = selectStmt.executeQuery("Select MAX(idDireccion) from direccionesusuarios");
    	while (rs.next()) {
    		idGenerado=rs.getInt(1);
    		System.out.println("el id de Direcciones ser�:" + "" + idGenerado);
    	}
    	return(idGenerado);
    }

    /**
     * El metodo conectarBD crea una conexion con los datos establecidos para un
     * objeto Conexion.
     *
     * @param miConexion Objeto Conexion con datos sobre la conexion a la BD
     * @return Objeto Connection con la conexion a la BD establecida.
     */

    public Connection conectarBD(Conexion miConexion) {

        Connection newConnection = null;

        try {
            newConnection = DriverManager.getConnection("jdbc:mysql://" + miConexion.getHost()
                            + ":" + miConexion.getPuerto() + "/" + miConexion.getNombreBD()
                            + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    , miConexion.getUser(), miConexion.getPass());
        } catch (SQLException e) {
            out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        } finally {
            out.println("Conexion establecida.");
        }

        return newConnection;
    }

    /**
     * El método sentencia DDL nos vale para ejecutar sentencias tipo
     * CREATE, DROP, ALTER, en tablas, vistas e índices SQL.
     *
     * @param newConnection Objeto Connection con una conexión a la BD establecida
     * @param sentencia     String con la sentencia a ejecutar
     */

    public void sentenciaDDL(Connection newConnection, String sentencia) {

        // Creamos un objeto Statement
        Statement newStatement = null;

        try {
            newStatement = newConnection.createStatement();
            out.println("Statement creado con éxito.");
        } catch (SQLException e) {
            out.println("Error al crear el Statement.");
            e.printStackTrace();
        }
        // Como la sentencia que queremos usar es para crear una tabla, debemos usar el método
        // execute(String sentenciaSql), que devuelve un booleano.

        Boolean resultado = false;

        try {
            resultado = newStatement.execute(sentencia);
            out.println("Sentencia SQL ejecutada con éxito.");
        } catch (SQLException e) {
            out.println("Error al ejecutar la sentencia SQL.");
            e.printStackTrace();
        }
    }

    /**
     * El método sentencia DML nos sirve para ejecutar sentencias SQL de tipo INSERT, DELETE o
     * UPDATE. Para las consultas tipo SELECT utilizaremos el método sentenciaSELECT.
     *
     * @param newConnection Objeto Connection con una conexión a la BD establecida
     * @param sentencia     String con la sentencia a ejecutar
     * @return int para determinar el resultado positivo o negativo
     */

    public int sentenciaDML(Connection newConnection, String sentencia) {

        // Creamos un objeto Statement
        Statement newStatement = null;

        try {
            newStatement = newConnection.createStatement();
            out.println("Statement creado con éxito.");
        } catch (SQLException e) {
            out.println("Error al crear el Statement.");
            e.printStackTrace();
        }
        // Como la sentencia que queremos usar es para modificar una tabla,
        // debemos usar el método executeUpdate(String sentenciaSql), que devuelve un int.

        int resultado = 0;

        try {
            resultado = newStatement.executeUpdate(sentencia);
            out.println("Sentencia SQL ejecutada con éxito.");
            return resultado;
        } catch (SQLException e) {
            out.println("Error al ejecutar la sentencia SQL.");
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * El método sentencia SELECT devuelve un objeto ResultSet con el resultado de
     * una sentencia SQL de tipo SELECT. No muestra los resultados.
     *
     * @param newConnection Objeto Connection con una conexión a la BD establecida
     * @param sentencia     String con la sentencia a ejecutar
     * @return Objeto ResultSet con el resultado de una consulta SELECT
     */

    public ResultSet sentenciaSELECT(Connection newConnection, String sentencia) {

        // Creamos un objeto Statement
        Statement newStatement = null;

        try {
            newStatement = newConnection.createStatement();
            out.println("Statement creado con éxito.");
        } catch (SQLException e) {
            out.println("Error al crear el Statement.");
            e.printStackTrace();
        }
        // Como la sentencia que queremos usar es para modificar una tabla,
        // debemos usar el método executeUpdate(String sentenciaSql), que devuelve un int.

        ResultSet newResultSet = null;

        try {
            newResultSet = newStatement.executeQuery(sentencia);
            out.println("Sentencia SQL ejecutada con éxito.");
            return newResultSet;
        } catch (SQLException e) {
            out.println("Error al ejecutar la sentencia SQL.");
            e.printStackTrace();
        }
        return null;

    }

    public void consultaBD(Connection newConnection, ResultSet newResultSet) {

        Scanner entrada = new Scanner(in);
        out.print("¿Número de campos a mostrar? ");
        int numCampos = entrada.nextInt();

        // Creamos un array de Strings con el número de elementos indicado para almacenar
        // el nombre de los campos a mostrar, que se nos preguntarán y se almacenarán
        // a continuación

        String lCampos[] = new String[numCampos];
        Scanner nuevaEntrada = new Scanner(System.in);
        for (int i = 1; i <= (numCampos); i++) {

            System.out.printf("Campo %d: ", i);
            lCampos[i - 1] = nuevaEntrada.nextLine();
        }

        // Con dos ciclos  for y while anidados, por cada campo y mientras queden registros en la tabla
        // se irań mostrando en pantalla.

            while (true) {
                try {
                    if (!newResultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i <= (numCampos - 1); i++) {

                    try {
                        System.out.print(newResultSet.getString(lCampos[i]));
                        System.out.print("  ");
                    } catch (SQLException e) {
                        out.println("Error al mostrar la consulta.");
                        e.printStackTrace();
                    }
                }

                System.out.println("");

            }

    }


    /**
     * Este método nos devolverá el id que ha otorgado la base de datos al último registro insertado.
     * */
    public int consultarIdGenerado(String tablaObjetivo) throws SQLException {

        int idGenerado = 0;
        String sentenciaSql = null;
        Conexion nuevaConexion = new Conexion();
        UtilitySql sesionSql = new UtilitySql(nuevaConexion);
        Connection newConnection = sesionSql.conectarBD(nuevaConexion);

        if(tablaObjetivo == "miembros"){

            sentenciaSql = "SELECT MAX(IdMiembro) AS id FROM miembros;";
        }
        PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){

            idGenerado= rs.getInt("id");

        }

        return idGenerado;
    }


    public static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    /*----------------------------------LOS INSERTS A LA BASE DE DATOS---------------------------------------------------*/

    // PRIMERO INSERTAMOS LA DIRECCION

    public void insertDireccion(int idDireccion, String tipoVia, int numero, String puerta, String escalera, String localidad, String provincia, String cp, String pais) throws SQLException {
//hacer correctamente

        Conexion nuevaConexion = new Conexion();
        UtilitySql sesionSql = new UtilitySql(nuevaConexion);
        Connection newConnection = sesionSql.conectarBD(nuevaConexion);

        foreingKeyChecks(false, newConnection);

        String sentenciaSql = "CALL producto3.insertar_Direccion(?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
        ps.setInt(1, idDireccion);
        out.printf("Insertado idDireccion:", +idDireccion);
        ps.setString(2, tipoVia);
        ps.setInt(3, numero);
        ps.setString(4, puerta);
        ps.setString(5, escalera);
        ps.setString(6, localidad);
        ps.setString(7, provincia);
        ps.setString(8, cp);
        ps.setString(9, pais);
        ps.executeUpdate();
        out.println("\nSentencia DML ejecutada con exito. Se ha insertado\n: "
        		+ idDireccion + " " + tipoVia + " " + numero + " " + puerta + " " + escalera +
        		" " + localidad + " " + provincia + " " + cp + " "+ pais);

        foreingKeyChecks(true, newConnection);

    }
   // DESPU�S INSERTAMOS EL MIEMBRO

    public void insertPersona (String idMiembro,String nombreMiembro, String nombreUsuario, String pass, String apellido1,
            String apellido2,String dni, int idDireccion, String rol, String telefono  ) throws SQLException {

	Conexion nuevaConexion = new Conexion();
	UtilitySql sesionSql = new UtilitySql(nuevaConexion);

	// Comprobamos que los datos son los que esperabamos.

	out.println("Intentando conectarse con los siguientes datos:");
	out.println(nuevaConexion.toString());

	// Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
	//conectar con la base de datos deseada.

	Connection newConnection = sesionSql.conectarBD(nuevaConexion);

	String sentenciaSql = "CALL producto3.insertar_miembro(?,?,?,?,?,?,?,?,?,?);";

	PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
	ps.setInt(1, Integer.valueOf(idMiembro));
	ps.setString(2, nombreMiembro);
	ps.setString(3, nombreUsuario);
	ps.setString(4, pass);
	ps.setString(5, apellido1);
	ps.setString(6, apellido2);
	ps.setString(7, dni);
	ps.setInt(8, idDireccion);
	ps.setString(9, rol);
	ps.setString(10, telefono);
	ps.executeUpdate();
	out.println("\nSentencia DML ejecutada con exito. Se ha insertado:\n "
	+ nombreMiembro + " " + nombreUsuario + " " + pass + " " + apellido1 + " " + apellido2 + " " + dni + " " + rol + " " + telefono);

}

    // POR ULTIMO INSERTAMOS EL TIPO DE MIEMBRO

    public static void insertPersonal(int idPersonal, Date fechaAlta, Date fechaBaja) throws SQLException {


        Conexion nuevaConexion = new Conexion();
        UtilitySql sesionSql = new UtilitySql(nuevaConexion);
        Connection newConnection = sesionSql.conectarBD(nuevaConexion);

        foreingKeyChecks(false, newConnection);


        String sentenciaSql = "CALL producto3.insertar_Personal(?,?,?);";
        PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
        ps.setInt(1, idPersonal);
        ps.setDate(2, fechaAlta);
        ps.setDate(3, fechaBaja);
        ps.executeUpdate();

        foreingKeyChecks(true, newConnection);

    }


	public static void insertColaborador(int idColaborador, Date fechaAltaC, Date fechaBajaC) throws SQLException {

	Conexion nuevaConexion = new Conexion();
	UtilitySql sesionSql = new UtilitySql(nuevaConexion);
	Connection newConnection = sesionSql.conectarBD(nuevaConexion);

	String sentenciaSql = "CALL producto3.insertar_Colaborador(?,?,?);";
	PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
	ps.setInt(1, idColaborador);
	ps.setDate(2, fechaAltaC);
	ps.setDate(3, fechaBajaC);
	ps.executeUpdate();

	}


    public static void foreingKeyChecks(Boolean foreingKeyChecks, Connection newConnection) throws SQLException {

        String sentenciaSql = new String();

        if(!foreingKeyChecks) {

            sentenciaSql = "SET FOREIGN_KEY_CHECKS = 0;";
            out.println("FK Checks -> NO");

        } else {

            sentenciaSql = "SET FOREIGN_KEY_CHECKS = 1;";
            out.println("FK Checks -> SI");

        }

        PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
        ps.executeUpdate();

    }

    public static void insertVoluntario( int idVoluntario, Date fechaAlta, Date fechaBaja, String origen, String paisOrigen) throws SQLException {
    	// faltarian los campos date que por ahora fallan y se han omitido para las pruebas de insercion
        Conexion nuevaConexion = new Conexion();
        UtilitySql sesionSql = new UtilitySql(nuevaConexion);
        Connection newConnection = sesionSql.conectarBD(nuevaConexion);

        String sentenciaSql = "CALL producto3.insertar_Voluntario(?,?,?,?,?);";

        PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
        ps.setInt(1, idVoluntario);
        ps.setDate(2, fechaAlta);
        ps.setDate(3, fechaBaja);
        ps.setString(4, origen);
        ps.setString(5, paisOrigen);
        ps.executeUpdate();

    }
    /**
     * Este metodo se encarga de ir tabla por tabla borrando los registros que contengan.
     * */
    public static void truncateAllContentDB() throws SQLException {

        Conexion nuevaConexion = new Conexion();
        UtilitySql sesionSql = new UtilitySql(nuevaConexion);
        Connection newConnection = sesionSql.conectarBD(nuevaConexion);

        String[] tablesName = new String[]{"miembros", "voluntario", "personal", "colaborador", "direccionesusuarios"};

        //Quitamos la verificacion de foreing key para poder usar TRUNCATE (que no solo hace el borrado como delete,
        // sino que ademas resetea los autoincrement que tenga la tabla)


        foreingKeyChecks(false, newConnection);
        //Ejecutamos el Truncate para cada nombre de tabla que hemos indicado en tablesName.
        for(int i=0; tablesName.length > i; i++){

            String sentenciaSql = "TRUNCATE "+tablesName[i];
            Statement stmt = newConnection.createStatement();
            stmt.executeUpdate(sentenciaSql);
            out.println("TRUNCATE TABLA --> "+tablesName[i]);

        }
        foreingKeyChecks(true, newConnection);
    }
    public static void updateDireccionesMiembro (int idDireccion,String tipoVia, int numero, String puerta,String escalera,String localidad,String provincia,String cp,String pais, int idAntiguo ) throws SQLException {

		Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);

		// Comprobamos que los datos son los que esperabamos.

		out.println("Intentando conectarse con los siguientes datos:");
		out.println(nuevaConexion.toString());

		// Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
		//conectar con la base de datos deseada.

		Connection newConnection = sesionSql.conectarBD(nuevaConexion);

		String sentenciaSql = "CALL update_direccionesUsuarios(?,?,?,?,?,?,?,?,?);";

		PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
		ps.setInt(1, idDireccion);
		ps.setString(2, tipoVia);
		ps.setInt(3, numero);
		ps.setString(4, puerta);
		ps.setString(5, escalera);
		ps.setString(6, localidad);
		ps.setString(7, provincia);
		ps.setString(8, cp);
		ps.setString(9, pais);
		ps.executeUpdate();
		//out.println("Sentencia DML ejecutada con exito. Se ha insertado: "
		//      + nombreMiembro + " " + nombreUsuario + " " + pass + " " + apellido1 + " " + apellido2 + " " + dni + " " + rol + " " + telefono);

		}
    public static void updateMiembros (int idMiembro,String nombreMiembro, String nombreUsuario, String password,String apellido1,String apellido2,String dni,int direccion,String rol,String telefono,int idAntiguo ) throws SQLException {

		Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);

		// Comprobamos que los datos son los que esperabamos.

		out.println("Intentando conectarse con los siguientes datos:");
		out.println(nuevaConexion.toString());

		// Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
		//conectar con la base de datos deseada.

		Connection newConnection = sesionSql.conectarBD(nuevaConexion);

		String sentenciaSql = "CALL update_miembros(?,?,?,?,?,?,?,?,?,?,?);";

		PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
		ps.setInt(1, idMiembro);
		ps.setString(2, nombreMiembro);
		ps.setString(3, nombreUsuario);
		ps.setString(4, password);
		ps.setString(5, apellido1);
		ps.setString(6, apellido2);
		ps.setString(7, dni);
		ps.setInt(8, direccion);
		ps.setString(9, rol);
		ps.setString(10, telefono);
		ps.setInt(11, idAntiguo);
		ps.executeUpdate();
		//out.println("Sentencia DML ejecutada con exito. Se ha insertado: "
		//      + nombreMiembro + " " + nombreUsuario + " " + pass + " " + apellido1 + " " + apellido2 + " " + dni + " " + rol + " " + telefono);

		}
    public static void updateColaborador (int idColaborador,Date fechaAlta, Date fechaBaja, int idAntiguo) throws SQLException {

		Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);

		// Comprobamos que los datos son los que esperabamos.

		out.println("Intentando conectarse con los siguientes datos:");
		out.println(nuevaConexion.toString());

		// Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
		//conectar con la base de datos deseada.

		Connection newConnection = sesionSql.conectarBD(nuevaConexion);

		String sentenciaSql = "CALL update_colaborador(?,?,?,?);";

		PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
		ps.setInt(1, idColaborador);
		ps.setDate(2, fechaAlta);
		ps.setDate(3, fechaBaja);
		ps.setInt(4, idAntiguo);
		ps.executeUpdate();
		//out.println("Sentencia DML ejecutada con exito. Se ha insertado: "
		//      + nombreMiembro + " " + nombreUsuario + " " + pass + " " + apellido1 + " " + apellido2 + " " + dni + " " + rol + " " + telefono);

		}
    public static void updatePersonal (int idPersonal,Date fechaAlta, Date fechaBaja,int idAntiguo) throws SQLException {

		Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);

		// Comprobamos que los datos son los que esperabamos.

		out.println("Intentando conectarse con los siguientes datos:");
		out.println(nuevaConexion.toString());

		// Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
		//conectar con la base de datos deseada.

		Connection newConnection = sesionSql.conectarBD(nuevaConexion);

		String sentenciaSql = "CALL update_personal(?,?,?,?);";

		PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
		ps.setInt(1, idPersonal);
		ps.setDate(2, fechaAlta);
		ps.setDate(3, fechaBaja);
		ps.setInt(4, idAntiguo);
		ps.executeUpdate();
		//out.println("Sentencia DML ejecutada con exito. Se ha insertado: "
		//      + nombreMiembro + " " + nombreUsuario + " " + pass + " " + apellido1 + " " + apellido2 + " " + dni + " " + rol + " " + telefono);

		}
    public static void updateVoluntario (int idVoluntario,Date fechaAlta, Date fechaBaja,String origen,String paisOrigen,int idAntiguo ) throws SQLException {

		Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);

		// Comprobamos que los datos son los que esperabamos.

		out.println("Intentando conectarse con los siguientes datos:");
		out.println(nuevaConexion.toString());

		// Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
		//conectar con la base de datos deseada.

		Connection newConnection = sesionSql.conectarBD(nuevaConexion);

		String sentenciaSql = "CALL update_voluntario(?,?,?,?,?,?);";

		PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
		ps.setInt(1, idVoluntario);
		ps.setDate(2, fechaAlta);
		ps.setDate(3, fechaBaja);
		ps.setString(4, origen);
		ps.setString(5, paisOrigen);
		ps.setInt(6, idAntiguo);
		ps.executeUpdate();
		//out.println("Sentencia DML ejecutada con exito. Se ha insertado: "
		//      + nombreMiembro + " " + nombreUsuario + " " + pass + " " + apellido1 + " " + apellido2 + " " + dni + " " + rol + " " + telefono);

		}
    public static void deleteColaborador(int idColaborador) throws SQLException {

		Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);

		// Comprobamos que los datos son los que esperabamos.

		out.println("Intentando conectarse con los siguientes datos:");
		out.println(nuevaConexion.toString());

		// Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
		//conectar con la base de datos deseada.

		Connection newConnection = sesionSql.conectarBD(nuevaConexion);

		String sentenciaSql = "CALL delete_colaborador(?);";

		PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
		ps.setInt(1, idColaborador);
		ps.executeUpdate();
    }
    public static void deleteVoluntario(int idVoluntario) throws SQLException {

		Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);

		// Comprobamos que los datos son los que esperabamos.

		out.println("Intentando conectarse con los siguientes datos:");
		out.println(nuevaConexion.toString());

		// Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
		//conectar con la base de datos deseada.

		Connection newConnection = sesionSql.conectarBD(nuevaConexion);

		String sentenciaSql = "CALL delete_voluntario(?);";

		PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
		ps.setInt(1, idVoluntario);
		ps.executeUpdate();

    }
    public static void deletePersonal(int idPersonal) throws SQLException {

		Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);

		// Comprobamos que los datos son los que esperabamos.

		out.println("Intentando conectarse con los siguientes datos:");
		out.println(nuevaConexion.toString());

		// Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
		//conectar con la base de datos deseada.

		Connection newConnection = sesionSql.conectarBD(nuevaConexion);

		String sentenciaSql = "CALL delete_personal(?);";

		PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
		ps.setInt(1, idPersonal);
		ps.executeUpdate();

    }
    public static void deleteMiembro(Miembro miembro) throws SQLException {

		Conexion nuevaConexion = new Conexion();
		UtilitySql sesionSql = new UtilitySql(nuevaConexion);

		// Comprobamos que los datos son los que esperabamos.

		out.println("Intentando conectarse con los siguientes datos:");
		out.println(nuevaConexion.toString());

		// Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
		//conectar con la base de datos deseada.

		Connection newConnection = sesionSql.conectarBD(nuevaConexion);

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
}



/**
 * Se incluye la clase Conexion, que utilizará la clase UtilitySql.
 */
//
//class Conexion {
//
//    //Variables de clase
//
//    private String host;
//    private String puerto;
//    private String nombreBD;
//    private String user;
//    private String pass;
//
//    //Constructores
//    //Al llamar al constructor por defecto, le pasaremos automaticamente unos datos
//    //de conexion prefijados
//
//    public Conexion() {
//        this.host = "127.0.0.1";
//        this.puerto = "3306";
//        this.nombreBD = "ong";
//        this.user = "root";
//        this.pass = "tesTed4a";
//
//    }
//
//    public Conexion(String host, String puerto, String nombreBD, String user, String pass) {
//        this.host = host;
//        this.puerto = puerto;
//        this.nombreBD = nombreBD;
//        this.user = user;
//        this.pass = pass;
//    }
//
//    //Getters y Setters
//    public String getHost() {
//        return host;
//    }
//
//    public void setHost(String host) {
//        this.host = host;
//    }
//
//    public String getPuerto() {
//        return puerto;
//    }
//
//    public void setPuerto(String puerto) {
//        this.puerto = puerto;
//    }
//
//    public String getNombreBD() {
//        return nombreBD;
//    }
//
//    public void setNombreBD(String nombreBD) {
//        this.nombreBD = nombreBD;
//    }
//
//    public String getUser() {
//        return user;
//    }
//
//    public void setUser(String user) {
//        this.user = user;
//    }
//
//    public String getPass() {
//        return pass;
//    }
//
//    public void setPass(String pass) {
//        this.pass = pass;
//    }
//
//    public String toString() {
//
//        return String.format("Host: %s - Puerto: %s\nBase de Datos: %s - Usuario: %s.",
//                host, puerto, nombreBD, user);
//
//    }
//}
