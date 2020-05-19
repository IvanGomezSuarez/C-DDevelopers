package Ong.Models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the colaborador database table.
 * 
 */
@Entity
@Table(name = "colaborador")
public class ColaboradorSinRelaciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idColaborador;
	
	private Date fechaAlta;
	
	private Date fechaBaja;

	

	@Column(name = "idColaborador")
	public int getIdColaborador() {
		return this.idColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}
	
	@Column(name = "fechaAlta")
	public Date getFechaAlta() {
		return this.fechaAlta;
	}
	
	public void setFechaAlta(Date fechaAlta) {
		this
		.fechaAlta = fechaAlta;
	}

	@Column(name = "fechaBaja")
	public Date getFechaBaja() {
		return this.fechaBaja;
	}
	
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

}