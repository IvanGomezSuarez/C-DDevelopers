package ongEC;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * CLASE PARA EMPLEAR CON EL PATRÓN DAO
 */
@XmlRootElement(name = "Delegaciones")
public class Delegaciones {
	
	private List<Delegacion> delegacion;

    public void setDelegacion(List<Delegacion> delegacion) {
		this.delegacion = delegacion;
	}
    
	@XmlElement(name = "Delegacion")
	public List<Delegacion> getDelegacion() {
		return delegacion;
	}
	public void add(Delegacion delegacion){
        if (this.delegacion == null){
            this.delegacion = new ArrayList<Delegacion>();
        }
        this.delegacion.add(delegacion);
    }
	

}
