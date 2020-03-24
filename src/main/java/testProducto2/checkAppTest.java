package testProducto2;

import DAO.DAOFactory;
import DAO.XmlSocioDAO;
import DAO.XmlProyectoDAO;
import ongEC.Main;

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
     * Test of main method, of class main.
     */

    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        boolean result = main.main(args); 
        boolean expected = true;
        assertEquals(expected, result);
    }

    
    @Test
    public void testSocios() throws Exception {
        System.out.println("Socios");
        
        Cuota mensual = Cuota.mensual;
        Cuota anual = Cuota.anual;
        Socio socio1 = new Socio("Lluc", "Caset", "12345678Z", mensual, 100);
        Socio socio2 = new Socio("Jana", "Garli", "12874678Z", anual, 1300);

        boolean result = false; 
        boolean expected = true;
        
        Socios socios = new Socios();
        Socios sociosRead = new Socios();
        socios.add(socio1);
        socios.add(socio2);
        
        DAOFactory XmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
        XmlSocioDAO SociosDAO = XmlDAOFactory.getSocioDAO();
        sociosRead = SociosDAO.listarSocios();
        if(socios.getSocios().get(0).getNombre().equals(sociosRead.getSocios().get(0).getNombre())
                && socios.getSocios().get(1).getNombre().equals(sociosRead.getSocios().get(1).getNombre())){
            result = true;
        }
        assertEquals(expected, result);
    }
}