package ongEC;

import java.sql.Date;

public class Voluntario extends Miembros  {
	
	Date fechaAlta;
	Date fechaBaja;
	
	Nacional nacional;
	Internacional internacional;
	
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
	
	public Nacional getNacional() {
		return nacional;
	}

	public void setNacional(Nacional nacional) {
		this.nacional = nacional;
	}

	public Internacional getInternacional() {
		return internacional;
	}

	public void setInternacional(Internacional internacional) {
		this.internacional = internacional;
	}

	public Voluntario(Date fechaAlta, Date fechaBaja, Nacional nacional, Internacional internacional) {
		super();
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.nacional = nacional;
		this.internacional = internacional;
	}

	public Voluntario() {
		super();
	}	
}
