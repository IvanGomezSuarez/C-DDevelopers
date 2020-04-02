

package DAO.impl;
import ongEC.*;

import javax.xml.bind.*;
import java.io.File;

/** 
 *  @author C&D Group
 * */
public class XmlMiembroDAO implements IMiembroDAO {

       private Miembro miembro;

       public XmlMiembroDAO() {

       }

public void createMiembroDAO(Miembro miembro) {

      System.out.println("Por favor, no cierre la aplicacion mientras guardamos los cambios...");

        try {

                //Hacemos un marshaller para transformar la instancia Miembro en un archivo xml.
          JAXBContext jaxbContext = JAXBContext.newInstance(Miembro.class);
          Marshaller marshaller = jaxbContext.createMarshaller();
          marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
          File archivoXML = new File("src/main/resources/Miembros.xml");
          marshaller.marshal(miembro, archivoXML);
          System.out.println("¡Cambios guardados correctamente en \"" + archivoXML.getAbsolutePath() + "\"!");

          } catch (PropertyException e) {
               e.printStackTrace();
          } catch (JAXBException e) {
               e.printStackTrace();
           }

       }

       public Miembro readMiembroDAO() {

              try {

                     File file = new File("src/main/resources/Miembros.xml");
                     JAXBContext jaxbContext = JAXBContext.newInstance(Miembro.class);
                     Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                     miembro = (Miembro) unmarshaller.unmarshal(file);

              } catch (JAXBException e) {
                     e.printStackTrace();
              }

              return miembro;
       }

       public boolean updateOngDAO(Miembro pMiembro) {

              //Devuelve false si no se ha podido modificar los datos.

              return false;
       }

       public boolean deleteMiembroDAO(Miembro pMiembro) {

              //Devuelve false si no se ha podido eliminar los datos.

              return false;
       }

	public boolean updateMiembroDAO(Miembro pMiembro) {
		// TODO Auto-generated method stub
		return false;
	}
}
