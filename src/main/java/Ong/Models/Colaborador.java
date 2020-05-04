package Ong.Models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the colaborador database table.
 * 
 */
@Entity
@NamedQuery(name="Colaborador.findAll", query="SELECT c FROM Colaborador c")
public class Colaborador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idColaborador;

	@Temporal(TemporalType.DATE)
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	private Date fechaBaja;

	//bi-directional one-to-one association to Miembro
	@OneToOne
	@JoinColumn(name="idColaborador")
	private Miembro miembro;

	public Colaborador() {
	}

	public int getIdColaborador() {
		return this.idColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
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

	public Miembro getMiembro() {
		return this.miembro;
	}

	public void setMiembro(Miembro miembro) {
		this.miembro = miembro;
	}

}