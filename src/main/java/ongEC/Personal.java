package ongEC;

/*
 * esta clase contiene la informaci�n de los datos de fechas del personal
 *
 *
 * */

//import java.sql.Date;
import java.util.Date;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class Personal extends Miembro{

	//Definicion de los Atributos


	int idPersonal;
	@XmlElement(name = "fechaAltaPer")
	private static Date fechaAlta;
	@XmlElement(name = "fechaBajaPer")
	private static Date fechaBaja;


	//Definiendo los Constructores



	public Personal() {
	}

	public Personal(int idPersonal, Date fechaAlta, Date fechaBaja) {
		this.idPersonal = idPersonal;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
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

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}
}
