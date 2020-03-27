package ongEC;



import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author josep
 */
@XmlRootElement(name = "Proyectos")
public class Proyectos {
List<Proyecto> proyectos;

    
    public List<Proyecto> getProyecto(){
        return proyectos;
    }
    
    @XmlElement(name = "Proyecto")
    public void setProyecto(List<Proyecto> proyectos){
        this.proyectos = proyectos;
    }
    public void add(Proyecto proyectos){
        if (this.proyectos == null){
            this.proyectos = new ArrayList<Proyecto>();
        }
        this.proyectos.add(proyectos);
    }

	public Object getProyectos() {
		// TODO Auto-generated method stub
		return null;
	}

	}
