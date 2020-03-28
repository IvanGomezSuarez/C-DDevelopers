
package DAO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import ongEC.Delegaciones;
import ongEC.Direccion;


import java.io.File;
import java.util.ArrayList;

public class XmlDelegacionesDAO implements DelegacionesDAO{
    private String nombreFichero = null;
    
    public XmlDelegacionesDAO() throws JAXBException {
        JAXBContext.newInstance(Delegaciones.class);
        this.nombreFichero = "Delegaciones.xml";
    }
    
    
    public void obtenerDelegaciones(String nombre, String cip) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Delegaciones.class);
    	Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(Delegaciones(null, null, null, null), new File(nombreFichero));
        System.out.println();
        System.out.println("Se ha escrito el fichero " + nombreFichero + " con el siguiente contenido:");
        System.out.println();
        marshaller.marshal(Delegaciones(null, null, null, null), System.out);
        
    }

	public int Delegaciones(ongEC.Delegaciones delegaciones, String cip, Direccion direccion, String nombre) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int eliminarDelegaciones(String cip) {
		// TODO Auto-generated method stub
		return 0;
	}


	public ArrayList<ongEC.Delegaciones> listadoDelegaciones() {
		// TODO Auto-generated method stub
		return null;
	}


	public void crearNuevo(String nomDelegacion, String idDelegacion, String cip, String telefono)
			throws JAXBException {
		// TODO Auto-generated method stub
		
	}
    


}


