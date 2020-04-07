package ongEC;

/*
 * esta clase contiene la informaci�n de los datos de fechas del personal
 * 
 * 
 * */

//import java.sql.Date;
import java.util.Date;

public class Personal{
	
	//Definicion de los Atributos
	
	int idPersonal;
	private Date fechaAlta;
	private Date fechaBaja;		
	
	//Definiendo los Constructores
	
	
	
	public Personal() {
	}

	public Personal(int idPersonal, Date fechaAlta, Date fechaBaja) {
		this.idPersonal = idPersonal;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}
	//Defincion de los Gets y Sets

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

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}
}
