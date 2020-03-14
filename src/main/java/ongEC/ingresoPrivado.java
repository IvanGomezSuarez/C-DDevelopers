package ongEC;

import java.sql.Date;

public class ingresoPrivado {
	
	int idIngreso;
	Date fechaIngreso;
	
	public int getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public ingresoPrivado(int idIngreso, Date fechaIngreso) {
		super();
		this.idIngreso = idIngreso;
		this.fechaIngreso = fechaIngreso;
	}

	public ingresoPrivado() {
		super();
	}		
}
