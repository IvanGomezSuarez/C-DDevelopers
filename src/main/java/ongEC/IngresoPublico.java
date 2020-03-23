package ongEC;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
/**
 *
 * @author Ivan
 */

@XmlRootElement(name ="iPublicos")
@XmlAccessorType(XmlAccessType.FIELD)
public class IngresoPublico extends Ingreso {
    @XmlElement(name = "administracion")
    
    private AdminTipo administracion;
    
    String nombreOrganizacion;
    Direccion direccion;
    float importe;
    String descripcion;
    
	//CONTRUCTORES
    
    
    public IngresoPublico()throws JAXBException{}
    
    public IngresoPublico(AdminTipo administracion, String nombreOrganizacion, Direccion direccion, float importe,
		String descripcion) throws JAXBException {
		super();
		this.administracion = administracion;
		this.nombreOrganizacion = nombreOrganizacion;
		this.direccion = direccion;
		this.importe = importe;
		this.descripcion = descripcion;
	}


    	
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

		private void setId(int id) {
		// TODO Auto-generated method stub
		
	}

		private void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

    public AdminTipo getAdministracion(){
        return administracion;
    }

    public void setAdministracion(AdminTipo a){
        administracion = a;
    }
}
