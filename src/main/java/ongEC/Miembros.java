package ongEC;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Miembros")
public class Miembros {
	
	public static List<Miembro> miembro;

    public void setMiembro(List<Miembro> miembro) {
		this.miembro = miembro;
	}
    
	@XmlElement(name = "Miembro")
	public List<Miembro> getMiembro() {
		return miembro;
	}
	
	public void add(Miembro miembro){
        if (this.miembro == null){
            this.miembro = new ArrayList<Miembro>();
        }
        this.miembro.add(miembro);
    }

}
