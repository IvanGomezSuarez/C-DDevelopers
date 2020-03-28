package DAO;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ongEC.Proyecto;

import java.io.File;
/**
 *
 * @author Ivan
 */
public class XmlProyectoDAO implements ProyectoDAO{
    private JAXBContext jaxbContext = null;
    private String nombreFichero = null;
    
    public XmlProyectoDAO() throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(Proyecto.class);
        this.nombreFichero = "Proyectos.xml";
    }
    
    public void guardar(Proyecto proyecto) throws JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(proyecto, new File(nombreFichero));
        System.out.println();
        System.out.println("Se ha escrito el fichero " + nombreFichero + " con el siguiente contenido:");
        System.out.println();
        marshaller.marshal(proyecto, System.out);
    }
    
    public Proyecto listarProyectos() throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Proyecto proyectos = (Proyecto) unmarshaller.unmarshal (new File(nombreFichero));
        
        System.out.println();
        System.out.println("Estos son los proyectos contenidas en el fichero " + nombreFichero);
        
        for(Proyecto proyecto : proyectos.getProyectos())
        {
            System.out.println("---");
            System.out.println("Pais del proyecto: \t" + proyecto.getPais());
            System.out.println("Localizacion del proyecto: \t" + proyecto.getLocalizacion());
            System.out.println("Linea de accion del proyecto: \t" + proyecto.getLineaAccion());
        }
        return proyectos;
    }
}
