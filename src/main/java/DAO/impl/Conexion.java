package DAO.impl;

public class Conexion {

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


