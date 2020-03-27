package testProducto2;

import DAO.DAOFactory;
import DAO.SocioDAO;
import DAO.XmlProyectoDAO;
import DAO.XmlSocioDAO;
import ongEC.CuotaSocio;
import ongEC.Socio;
import ongEC.Socios;
import ongEC.Main;
import ongEC.Proyecto;
import ongEC.Proyectos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ivan
 */
public class checkAppTest {
    
    public checkAppTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test método main
     */

/*
    @Test
    public void testProyectos() throws Exception {
        System.out.println("Proyectos");
        
        Proyecto proyecto1 = new Proyecto(01, "AguaPotable", "Ghana", null, null, null, null, null, null, null, null, null, null, null);
        
        boolean result = false; 
        boolean expected = true;
        
        Proyectos proyectos = new Proyectos();
        Proyecto proyectosRead = new Proyecto();
        proyectos.add(proyecto1);
        //socios.add(socio2);
        
        DAOFactory XmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
        XmlProyectoDAO ProyectoDAO = (XmlProyectoDAO) XmlDAOFactory.getProyectoDAO();
        proyectosRead = ProyectoDAO.listarProyectos();
       if(proyectos.getProyecto().get(0).getNombreProyecto().equals(proyectosRead.getProyecto().get(0).getNombreProyecto())
               && proyectos.getProyecto().get(1).getNombreProyecto().equals(proyectosRead.getProyecto().get(1).getNombreProyecto())){
            result = true;
        }
        assertEquals(expected, result);
    }
*/
    
    @Test
    public void testSocios() throws Exception {
        System.out.println("Socios");
        
        CuotaSocio mensual = CuotaSocio.MENSUAL;
        CuotaSocio anual = CuotaSocio.ANUAL;
        Socio socio1 = new Socio("Ivan", "Garcia", "12123456F", mensual, 150);
        Socio socio2 = new Socio("Yosu", "Lopes", "13125254Z", anual, 1800);

        boolean result = false; 
        boolean expected = true;
        
        Socios socios = new Socios();
        Socios sociosRead = new Socios();
        socios.add(socio1);
        socios.add(socio2);
        
        DAOFactory XmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
        SocioDAO SociosDAO = XmlDAOFactory.getSocioDAO();
        sociosRead = SociosDAO.listarSocios();
        if(socios.getSocios().get(0).getNombreMiembro().equals(sociosRead.getSocios().get(0).getNombreMiembro())
                && socios.getSocios().get(1).getNombreMiembro().equals(sociosRead.getSocios().get(1).getNombreMiembro())){
            result = true;
        }
        assertEquals(expected, result);
    }
    
    
    
    
}