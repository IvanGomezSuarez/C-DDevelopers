package ongEC;
import javax.xml.bind.annotation.*;



@XmlRootElement(name ="delegacion")
@XmlAccessorType(XmlAccessType.FIELD)

public class Delegaciones {
	
	//atributos de la clase
	
	private String idDelegacion;
	private String nomDelegacion;
	private String cip;
	private String telefono;
	
	//CONSTRUCTORES
	
	public Delegaciones() {
		super();
	}
	
	/**
	 * este constructor crea objeto e inicialia los atributos.
	 * @param cifOng 
	 */
	
	public Delegaciones(String nomDelegacion, String idDelegacion, String cip, String telefono) {
		super();
		this.nomDelegacion = nomDelegacion;
		this.idDelegacion = idDelegacion;
		this.cip = cip;
		this.telefono = telefono;
	}

	// METODOS
	
	public String getIdDelegacion() {
		return idDelegacion;
	}


	public void setIdDelegacion(String idDelegacion) {
		this.idDelegacion = idDelegacion;
	}


	public String getNomDelegacion() {
		return nomDelegacion;
	}


	public void setNomDelegacion(String nomDelegacion) {
		this.nomDelegacion = nomDelegacion;
	}


	public String getCip() {
		return cip;
	}


	public void setCip(String cip) {
		this.cip = cip;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
