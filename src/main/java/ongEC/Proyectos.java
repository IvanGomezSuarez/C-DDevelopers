package ongEC;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josep
 */
@XmlRootElement(name = "Proyectos")
public class Proyectos {
	
	private List<Proyecto> proyecto;

    public void setProyecto(List<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}
    
	@XmlElement(name = "Proyecto")
	public List<Proyecto> getProyecto() {
		return proyecto;
	}

	public void add(Proyecto proyecto){
        if (this.proyecto == null){
            this.proyecto = new ArrayList<Proyecto>();
        }
        this.proyecto.add(proyecto);
    }

}
