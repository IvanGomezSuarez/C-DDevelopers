package testProducto2;

import static org.junit.Assert.*;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import DAO.XmlDelegacionesDAO;
import DAO.XmlSocioDAO;
import ongEC.Delegaciones;
import DAO.DAOFactory;
import DAO.DelegacionesDAO;
import java.io.File;
import java.util.ArrayList;



public class DelegacionesDAOTest {

	@SuppressWarnings("static-access")
	@Test
    public void testDelagaciones() throws Exception {
        System.out.println("Delegaciones");

        Delegaciones delegacion1 = new Delegaciones("Barcelona", "01", "B43546864", "+34 93456258");
        Delegaciones delegacion2 = new Delegaciones("Valencia", "02", "B43558985", "+34 964568789");
        
        boolean result = false; 
        boolean expected = true;
        
        Delegaciones delegaciones = new Delegaciones();
        Delegaciones delegacionesRead = new Delegaciones();
        Delegaciones.add(delegacion1);
        Delegaciones.add(delegacion2);
        
        
        DAOFactory XmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
        XmlDelegacionesDAO DelegacionesDAO = (XmlDelegacionesDAO) XmlDAOFactory.getDelegacionesDAO();
        delegacionesRead = DelegacionesDAO.listadoDelegaciones();
        if(delegaciones.getdelegaciones().get(1).getNombre().equals(delegacionesRead.getDelegaciones().get(0).getNombre())
                && delegaciones.getDelegaciones().get(1).getNombre().equals(delegacionesRead.getDelegaciones().get(1).getNombre())){
            result = true;
        }
        
        assertEquals(expected, result);
	}
}


