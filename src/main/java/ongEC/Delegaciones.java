package ongEC;

public class Delegaciones {
	
	String nombre;
	String cip;
	Direccion direccion;

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCip() {
		return cip;
	}
	
	public void setCip(String cip) {
		this.cip = cip;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Delegaciones(String nombre, String cip, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.cip = cip;
		this.direccion = direccion;
	}

	public Delegaciones() {
		super();
	}	
}
