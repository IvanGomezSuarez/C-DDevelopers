package ongEC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/*
 * esta clase contiene la informaci�n de los miembros. los crea y a�ade a un array
 * 
 * 
 * */
@XmlRootElement(name ="Miembro")
@XmlAccessorType(XmlAccessType.FIELD)

public class Miembro {

// atributos
	
	@XmlElement(name = "IdMiembro")
	private String idMiembro;
	@XmlElement(name = "Nombre")
	private String nombreMiembro;
	@XmlElement(name = "NombreUsuario")
	private String nombreUsuario;
	@XmlElement(name = "Password")
	private String password;
	@XmlElement(name = "Apellido1")
	private String apellido1;
	@XmlElement(name = "Apellido2")
	private String apellido2;
	@XmlElement(name = "Dni")
	private static String dni;
	@XmlElement(name = "Direccion")
	private Direccion direccion;
	@XmlElement(name = "Rol")
	private String rol;
	@XmlElement(name = "Telefono")
	private String telefono;
	
	@XmlElement(name = "Personal")
	Personal personal;
	@XmlElement(name = "Voluntario")
	Voluntario voluntario;
	@XmlElement(name = "Colaborador")
	Colaborador colaborador;
    @XmlElement(name= "Personal")
    public List<Personal> lequipo;
	
	

	// constructores
	
	/**
	 * este constructor crea objeto e inicialia los atributos.
	 * @param idMiembro
	 * @param nombreMiembro
	 * @param nombreUsuario
	 * @param password
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param pais
	 * @param ciudad
	 * @param direccion
	 * 
	 * 
	 */


	// constructor para el arraylist
	public Miembro(){  
	}
	
	public Miembro(String idMiembro, String nombreMiembro, String nombreUsuario, String password, String apellido1,
			String apellido2, Direccion direccion, String rol, Personal personal, Voluntario voluntario,
			Colaborador colaborador, String telefono,List<Personal> lequipo) {
		super();
		this.idMiembro = idMiembro;
		this.nombreMiembro = nombreMiembro;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.rol = rol;
		this.personal = personal;
		this.voluntario = voluntario;
		this.colaborador = colaborador;
		this.telefono = telefono;
		this.lequipo = new ArrayList<>();
	}
	
	// METODOS
	
    public List<Personal> getEquipo() {
        return lequipo;
    }

    /** Getter para obtener un miembro del personal según su idPersonal.
     * Si no existe un miembro del personal con el id proporcionado devolverá una excepción controlada y
     * una instancia de tipo Personal vacia.
     *
     * @param idPersonal int con el id de personal
     * @return devuelve un tipo Personal, que contiene un miembro concreto del personal según idPersonal
     */
    public Personal getMiembroDelEquipo(int idPersonal) {

        Personal pPersonaBuscada = null;

        for (Personal personal : lequipo) {

            try {

                if (personal.getIdMiembro() == idMiembro) {
                    pPersonaBuscada = personal;
                    return pPersonaBuscada;
                } else {
                    return null;
                }

            } catch (Exception e) {
                System.out.println("ERROR: No existe ningún miembros del personal con el id proporcionado.");
            }
        }

        return pPersonaBuscada;

    }

	public Miembro(String nombreMiembro2, String dni2) {
		// TODO Auto-generated constructor stub
	}


	public String getIdMiembro() {
		return idMiembro;
	}


	public void setIdMiembro(String idMiembro) {
		this.idMiembro = idMiembro;
	}
	
	public String getNombreMiembro() {
		return nombreMiembro;
	}

	public void setNombreMiembro(String nombreMiembro) {
		this.nombreMiembro = nombreMiembro;
	}

	public String getApellido1() {
		return apellido1;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getNomUsuario() {
		return nombreUsuario;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPass() {
		return password;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public static String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Voluntario getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
}
