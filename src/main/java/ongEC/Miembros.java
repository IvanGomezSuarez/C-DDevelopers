package ongEC;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josep
 */
@XmlRootElement(name = "Miembros")
public class Miembros {
	
	private List<Miembro> Miembro;

    public void setMiembro(List<Miembro> Miembro) {
		this.Miembro = Miembro;
	}
    
	@XmlElement(name = "Miembro")
	public List<Miembro> getMiembro() {
		return Miembro;
	}

}
