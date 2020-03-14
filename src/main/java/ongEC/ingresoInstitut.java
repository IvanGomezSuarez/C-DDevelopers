package ongEC;

public class ingresoInstitut {
	
	String nombreOrganizacion;
	Direccion direccion;
	float importe;
	String Descripcion;
	
	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}
	
	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public float getImporte() {
		return importe;
	}
	
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	public String getDescripcion() {
		return Descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	public ingresoInstitut(String nombreOrganizacion,Direccion direccion, float importe, String descripcion) { 
		super();
		this.nombreOrganizacion = nombreOrganizacion;
		this.direccion = direccion;
		this.importe = importe;
		Descripcion = descripcion;
	}
	
	public ingresoInstitut() {
		super();
	}	
	
}
