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
import ongEC.Delegacion;
import DAO.DAOFactory;
import DAO.DelegacionesDAO;
import java.io.File;
import java.util.ArrayList;



public class DelegacionesDAOTest {

	@SuppressWarnings("static-access")
	@Test
    public void testDelagaciones() throws Exception {
        System.out.println("Delegaciones");

        Delegacion delegacion1 = new Delegacion("Barcelona", "01", "B43546864", "+34 93456258");
        Delegacion delegacion2 = new Delegacion("Valencia", "02", "B43558985", "+34 964568789");
        
        boolean result = false; 
        boolean expected = true;
        
        Delegacion delegacion = new Delegacion();
        Delegacion delegacionesRead = new Delegacion();
        Delegacion.add(delegacion1);
        Delegacion.add(delegacion2);
        
        
        DAOFactory XmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
        XmlDelegacionesDAO DelegacionesDAO = (XmlDelegacionesDAO) XmlDAOFactory.getDelegacionesDAO();
        delegacionesRead = DelegacionesDAO.listadoDelegaciones();
        if(delegacion.getdelegaciones().get(1).getNombre().equals(delegacionesRead.getDelegaciones().get(0).getNombre())
                && delegacion.getDelegaciones().get(1).getNombre().equals(delegacionesRead.getDelegaciones().get(1).getNombre())){
            result = true;
        }
        
        assertEquals(expected, result);
	}
}


