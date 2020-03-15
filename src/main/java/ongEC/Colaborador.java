package ongEC;

import java.sql.Date;

public class Colaborador {
	
	Date fechaAlta;
	Date fechaBaja;
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public Date getFechaBaja() {
		return fechaBaja;
	}
	
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Colaborador(Date fechaAlta, Date fechaBaja) {
		super();
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}

	public Colaborador() {
		super();
	}	

}
