package ongEC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.GregorianCalendar;

public class Ingreso {
	
	//ATRIBUTOS
	private int idIngreso;
	private java.util.GregorianCalendar fechaIngreso;
	
	
	//CONSTRUCTORES
	
	/**
	 * este constructor crea objeto e inicialia los atributos.
	 * @param cifOng 
	 */
	public Ingreso(int idIngreso, java.util.GregorianCalendar fechaIngreso) {
		
		this.setIdIngreso(idIngreso);
		this.setFechaIngreso(fechaIngreso);
	}
	
	
	
	//METODOS

	private void addIngresoPublico() {
}
	
	private void addIngresoPrivado() {
}
	
	
	private void delIngresoPublico() {
}
	
	
	private void delIngresoPrivado() {
}



	public java.util.GregorianCalendar getFechaIngreso() {
		return fechaIngreso;
	}



	public void setFechaIngreso(java.util.GregorianCalendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}



	public int getIdIngreso() {
		return idIngreso;
	}



	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}
}
