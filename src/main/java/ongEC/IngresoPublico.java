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
    
	//CONTRUCTORES
    
    
    public IngresoPublico()throws JAXBException{}
    
    public IngresoPublico(int idIngresoPublico, String nombre, AdminTipo administracion, int idIngreso, java.util.GregorianCalendar fechaRecepcionIngreso )throws JAXBException{
        super(idIngreso, fechaRecepcionIngreso);
    	this.setId(idIngresoPublico);
        this.setNombre(nombre);
        this.administracion = administracion;
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
