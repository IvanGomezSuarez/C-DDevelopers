package Ong.Models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the personal database table.
 * 
 */
@Entity
@Table(name = "personal")
public class PersonalSinRelaciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPersonal;
	
	@Column(name = "fechaAlta")
	@Temporal(TemporalType.DATE)
	private Date fechaAlta;
	@Column(name = "fechaBaja")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaBaja;


	public PersonalSinRelaciones() {
	}

	public int getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
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


}