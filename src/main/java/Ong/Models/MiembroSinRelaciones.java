package Ong.Models;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import Ong.Models.Colaborador;
import Ong.Models.Personal;
import Ong.Models.Voluntario;


/**
 * The persistent class for the miembros database table.
 * 
 */
@Entity
@Table(name="miembros")
@NamedQueries({
})

public class MiembroSinRelaciones implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMiembro;
	private String nombreMiembro;
	private String nombreUsuario;
	private String pass;
	private String apellido1;
	private int direccion;
	private String apellido2;
	private String dni;
	private String rol;
	private String telefono;
//	private DireccionesUsuario direccionesUsuario;
	
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
	@Column(name = "direccion")
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "direccion")
//	public DireccionesUsuario getDireccionesUsuario() {
//		return direccionesUsuario;
//	}
//
//	public void setDireccionesUsuario(DireccionesUsuario direccionesUsuario) {
//		this.direccionesUsuario = direccionesUsuario;
//	}
}