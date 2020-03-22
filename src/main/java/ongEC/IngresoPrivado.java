package ongEC;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
/**
 * Dicha clase gestiona las aportaciones privadas que están contempladas
 * en la clase enum Aportaciones
 * @author Ivan
 */

@XmlRootElement(name ="iPrivados")
@XmlAccessorType(XmlAccessType.FIELD)
public class IngresoPrivado extends Ingreso {
    @XmlElement(name = "aportacion")
    private Aportaciones aportacion;
    
	//CONTRUCTORES
    
    
    public IngresoPrivado()throws JAXBException{}
    
    public IngresoPrivado(int idIngresoPrivado, String nombre, AdminTipo administracion, int idIngreso, java.util.GregorianCalendar fechaRecepcionIngreso )throws JAXBException{
        super(idIngreso, fechaRecepcionIngreso);
    	this.setId(idIngresoPrivado);
        this.setNombre(nombre);
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