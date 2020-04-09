package ongEC;

/*
 * esta clase contiene la informaci�n de los datos de fechas del personal
 * 
 * 
 * */

//import java.sql.Date;
import java.util.Date;

public class Personal extends Miembro {
	
	//Definicion de los Atributos
	
	private static Date fechaAlta;
	private static Date fechaBaja;		
	
	//Definiendo los Constructores
	
	public Personal(Date fechaAlta, Date fechaBaja) {
		super();
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}
	
	public Personal() {
		super();
	}

	//Defincion de los Gets y Sets
	
	public static Date getFechaAlta() {
		return fechaAlta;
	}
	


	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public static Date getFechaBaja() {
		return fechaBaja;
	}
	
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

}
