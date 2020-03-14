package ongEC;

public class ingresoInstitut {
	
	String nombreOrganizacion;
	Direccion direccion;
	float importe;
	String descripcion;
	
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
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ingresoInstitut(String nombreOrganizacion, Direccion direccion, float importe, String descripcion) {
		super();
		this.nombreOrganizacion = nombreOrganizacion;
		this.direccion = direccion;
		this.importe = importe;
		this.descripcion = descripcion;
	}

	public ingresoInstitut() {
		super();
	}		
}
