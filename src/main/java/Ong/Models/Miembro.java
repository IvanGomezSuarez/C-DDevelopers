package Ong.Models;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/**
 * The persistent class for the miembros database table.
 * 
 */
@Entity
@Table(name="miembros")
@NamedQuery(name="Miembro.findAll", query="SELECT m FROM Miembro m")
public class Miembro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idMiembro;

	private String apellido1;

	private String apellido2;

	private String dni;

	private String nombreMiembro;

	private String nombreUsuario;

	private String pass;

	private String rol;

	private String telefono;

	//bi-directional one-to-one association to Colaborador
	@OneToOne(mappedBy="miembro")
	private Colaborador colaborador;

	//bi-directional many-to-one association to DireccionesUsuario
	@ManyToOne
	@JoinColumn(name="direccion")
	private DireccionesUsuario direccionesUsuario;

	//bi-directional one-to-one association to Personal
	@OneToOne(mappedBy="miembro")
	private Personal personal;

	//bi-directional one-to-one association to Voluntario
	@OneToOne(mappedBy="miembros")
	private Voluntario voluntario;

	public Miembro() {
	}

	public int getIdMiembro() {
		return this.idMiembro;
	}

	public void setIdMiembro(int idMiembro) {
		this.idMiembro = idMiembro;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreMiembro() {
		return this.nombreMiembro;
	}

	public void setNombreMiembro(String nombreMiembro) {
		this.nombreMiembro = nombreMiembro;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public DireccionesUsuario getDireccionesUsuario() {
		return this.direccionesUsuario;
	}

	public void setDireccionesUsuario(DireccionesUsuario direccionesUsuario) {
		this.direccionesUsuario = direccionesUsuario;
	}

	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Voluntario getVoluntario() {
		return this.voluntario;
	}

	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}

}