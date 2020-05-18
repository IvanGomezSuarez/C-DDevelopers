package Ong.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the miembros database table.
 * 
 */
@Entity
@Table(name="miembros")
@NamedQueries({
	@NamedQuery(name= Miembro.FIND_BY_ID, query="SELECT m FROM Miembro m WHERE m.idMiembro=:id"),
	@NamedQuery(name= Miembro.FIND_BY_DNI, query="SELECT m FROM Miembro m WHERE m.dni=:dni")
})

public class Miembro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_ID = "Miembro.findById";
	public static final String FIND_BY_DNI = "Miembro.findByDni";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMiembro;
	private String nombreMiembro;
	private String nombreUsuario;
	private String pass;
	private String apellido1;
	private String apellido2;
	private String dni;
	private String rol;
	private String telefono;
	private DireccionesUsuario direccionesUsuario;

	@Column(name = "idMiembro")
	public int getIdMiembro() {
		return idMiembro;
	}

	public void setIdMiembro(int idMiembro) {
		this.idMiembro = idMiembro;
	}

	@Column(name = "nombreMiembro")
	public String getNombreMiembro() {
		return nombreMiembro;
	}

	public void setNombreMiembro(String nombreMiembro) {
		this.nombreMiembro = nombreMiembro;
	}
	
	@Column(name = "nombreUsuario")
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Column(name = "pass")
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Column(name = "apellido1")
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column(name = "apellido2")
	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Column(name = "dni")
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name = "rol")
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Column(name = "telefono")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "direccion")
	public DireccionesUsuario getDireccionesUsuario() {
		return direccionesUsuario;
	}

	public void setDireccionesUsuario(DireccionesUsuario direccionesUsuario) {
		this.direccionesUsuario = direccionesUsuario;
	}

}