package Ong.Models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;


/**
 * The persistent class for the voluntario database table.
 * 
 */
@Entity
@NamedQuery(name="Voluntario.findAll", query="SELECT v FROM Voluntario v")
public class Voluntario implements Serializable {
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private int idVoluntario;

	@Temporal(TemporalType.DATE)
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	private Date fechaBaja;

	private String origen;

	private String paisOrigen;

	//bi-directional one-to-one association to Miembro
	@OneToOne
	@JoinColumn(name="idVoluntario")
	private Miembro miembro;

	public Voluntario() {
	}

	public int getIdVoluntario() {
		return this.idVoluntario;
	}

	public void setIdVoluntario(int idVoluntario) {
		this.idVoluntario = idVoluntario;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getPaisOrigen() {
		return this.paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public Miembro getMiembro() {
		return this.miembro;
	}

	public void setMiembro(Miembro miembro) {
		this.miembro = miembro;
	}

}