
package DAO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ongEC.Ong;
import java.io.File;

public class XmlOngDAO implements OngDAO{
    private JAXBContext jaxbContext = null;
    private String nombreFichero = null;
    
    public XmlOngDAO() throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(Ong.class);
        this.nombreFichero = "Ong.xml";
    }
    @Override
    public void guardar(Ong ong) throws JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(ongs, new File(nombreFichero));
        System.out.println();
        System.out.println("Se ha escrito el fichero " + nombreFichero + " con el siguiente contenido:");
        System.out.println();
        marshaller.marshal(ongs, System.out);
    }
    
    @Override
    public Ong listadoOng() throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Ongs ongs = (Ongs) unmarshaller.unmarshal (new File(nombreFichero));
        
        System.out.println();
        System.out.println("Esta es la ONG contenida en el fichero " + nombreFichero);
        
        for(Ong ong : ongs.getOngs())
        {
            System.out.println("---");
            System.out.println("Nombre de la ONG: \t" + ong.getNombre());
        }
        return ongs;
    }
}