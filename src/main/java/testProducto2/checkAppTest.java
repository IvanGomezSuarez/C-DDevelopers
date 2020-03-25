package testProducto2;

import DAO.DAOFactory;
import DAO.XmlProyectoDAO;
import ongEC.Main;
import ongEC.Proyecto;

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

    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
       // boolean result = Main.main(args); 
       // boolean expected = true;
        //assertEquals(expected, result);
    }

    
    @Test
    public void testProyectos() throws Exception {
        System.out.println("Socios");
        
        Proyecto proyecto1 = new Proyecto(01, "AguaPotable", "Ghana", null, null, null, null, null, null, null, null, null, null, null);
        
 //       boolean result = false; 
   //     boolean expected = true;
        
       // Socios socios = new Socios();
        //Socios sociosRead = new Socios();
        //socios.add(socio1);
        //socios.add(socio2);
        
        DAOFactory XmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
        /*XmlSocioDAO SociosDAO = XmlDAOFactory.getSocioDAO();
        sociosRead = SociosDAO.listarSocios();
       if(socios.getSocios().get(0).getNombre().equals(sociosRead.getSocios().get(0).getNombre())
               && socios.getSocios().get(1).getNombre().equals(sociosRead.getSocios().get(1).getNombre())){
            result = true;
        }
        assertEquals(expected, result);
    }*/
}
}