package ongEC;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
/**
 * Dicha clase gestiona las aportaciones privadas que estï¿½n contempladas
 * en la clase enum Aportaciones
 * @author Ivan
 */

@XmlRootElement(name ="iPrivados")
@XmlAccessorType(XmlAccessType.FIELD)

public class IngresoPrivado extends Ingreso {
    @XmlElement(name = "aportacion")
    private Aportaciones aportacion;

    // ATRIBUTOS
    
    String nombreOrganizacion;
    Direccion direccion;
    float importe;
    String descripcion;
    
	//CONTRUCTORES


    public IngresoPrivado()throws JAXBException{}
    
    public IngresoPrivado(Aportaciones aportacion, String nombreOrganizacion, Direccion direccion, float importe,
		String descripcion) throws JAXBException {
		super();
		this.aportacion = aportacion;
		this.nombreOrganizacion = nombreOrganizacion;
		this.direccion = direccion;
		this.importe = importe;
		this.descripcion = descripcion;
	}
    
    // MÉTODOS
    
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

	public void setAportacion(Aportaciones aportacion) {
		this.aportacion = aportacion;
	}

		private void setId(int id) {
		// TODO Auto-generated method stub

	}

		private void setNombre(String nombre) {
		// TODO Auto-generated method stub

	}

    public Aportaciones getAportacion(){
        return aportacion;
    }

    public void setAdministracion(Aportaciones a){
        aportacion = a;
    }
}
