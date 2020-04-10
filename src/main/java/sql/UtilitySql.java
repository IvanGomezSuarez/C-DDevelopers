package sql;

import ongEC.*;

import java.sql.*;
import java.sql.Date;
import java.util.*;

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

    public void insertPersona (String nombreMiembro, String nombreUsuario, String pass, String apellido1,
                                       String apellido2, String dni, String rol, String telefono  ) throws SQLException {

            Conexion nuevaConexion = new Conexion();
            UtilitySql sesionSql = new UtilitySql(nuevaConexion);

            // Comprobamos que los datos son los que esperabamos.

            out.println("Intentando conectarse con los siguientes datos:");
            out.println(nuevaConexion.toString());

            // Ahora llamamos al metodo conectarBD con miConexion como parametro para efectivamente
            //conectar con la base de datos deseada.

            Connection newConnection = sesionSql.conectarBD(nuevaConexion);

            String sentenciaSql = "CALL producto3.insertar_miembro(?,?,?,?,?,?,?,?);";

            PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
            ps.setString(1, nombreMiembro);
            ps.setString(2, nombreUsuario);
            ps.setString(3, pass);
            ps.setString(4, apellido1);
            ps.setString(5, apellido2);
            ps.setString(6, dni);
            ps.setString(7, rol);
            ps.setString(8, telefono);
            ps.executeUpdate();
            //out.println("Sentencia DML ejecutada con exito. Se ha insertado: "
              //      + nombreMiembro + " " + nombreUsuario + " " + pass + " " + apellido1 + " " + apellido2 + " " + dni + " " + rol + " " + telefono);

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

    public void insertPersonal(int idPersonal, Date fechaAlta, Date fechaBaja) throws SQLException {

        Conexion nuevaConexion = new Conexion();
        UtilitySql sesionSql = new UtilitySql(nuevaConexion);
        Connection newConnection = sesionSql.conectarBD(nuevaConexion);

        foreingKeyChecks(false, newConnection);

        String sentenciaSql = "INSERT INTO personal(idPersonal) VALUES (null,?,?);";
        PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
        ps.setInt(1, idPersonal);
        ps.setDate(2, fechaAlta);
        ps.setDate(3, fechaBaja);
        ps.executeUpdate();

        foreingKeyChecks(true, newConnection);

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

        public void insertColaborador(int idColaborador, Date fechaAlta, Date fechaBaja) throws SQLException {

        Conexion nuevaConexion = new Conexion();
        UtilitySql sesionSql = new UtilitySql(nuevaConexion);
        Connection newConnection = sesionSql.conectarBD(nuevaConexion);
        
        String sentenciaSql = "INSERT INTO voluntario(idColaborador, fechaAlta, fechaBaja) VALUES (null, ?, ?);";
        PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
        ps.setInt(1, idColaborador);
        ps.setDate(2, fechaAlta);
        ps.setDate(3, fechaBaja);
        ps.executeUpdate();

    }

    public void insertVoluntario( int idVoluntario, Date fechaAlta, Date fechaBaja, String origen, String paisOrigen) throws SQLException {

        Conexion nuevaConexion = new Conexion();
        UtilitySql sesionSql = new UtilitySql(nuevaConexion);
        Connection newConnection = sesionSql.conectarBD(nuevaConexion);

        String sentenciaSql = "INSERT INTO voluntario(idVoluntario, fechaAlta, fechaBaja, origen, paisOrigen) VALUES ( null, ?, ?, ?, ?);";
        
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
}



/**
 * Se incluye la clase Conexion, que utilizará la clase UtilitySql.
 */

class Conexion {

    //Variables de clase

    private String host;
    private String puerto;
    private String nombreBD;
    private String user;
    private String pass;

    //Constructores
    //Al llamar al constructor por defecto, le pasaremos automaticamente unos datos
    //de conexion prefijados

    public Conexion() {
        this.host = "127.0.0.1";
        this.puerto = "3306";
        this.nombreBD = "ong";
        this.user = "root";
        this.pass = "tesTed4a";

    }

    public Conexion(String host, String puerto, String nombreBD, String user, String pass) {
        this.host = host;
        this.puerto = puerto;
        this.nombreBD = nombreBD;
        this.user = user;
        this.pass = pass;
    }

    //Getters y Setters
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getNombreBD() {
        return nombreBD;
    }

    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String toString() {

        return String.format("Host: %s - Puerto: %s\nBase de Datos: %s - Usuario: %s.",
                host, puerto, nombreBD, user);

    }
}

