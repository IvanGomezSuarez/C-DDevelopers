package testProducto2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import ongEC.Miembros;

// Test para chequear si el objeto miembro se adjunta correctamente a la lista de miembros
public class ListadoMiembrosTest {

	@Test
	public void testAdd() throws JAXBException {
		
		// Iniciamos 4 miembros
		Miembros t1 = new Miembros();
		Miembros t2 = new Miembros();
		Miembros t3 = new Miembros();
		Miembros t4 = new Miembros();
		
		// Se crra el listado de miembros
		List<Miembros> listadoMiembros = new ArrayList<Miembros>();
		assertEquals(0, listadoMiembros.size());
		listadoMiembros.add(t1); //se agrega los objetos pasados como parametros a la lista.
		assertEquals(1, listadoMiembros.size()); 
		listadoMiembros.add(t2);
		assertEquals(2, listadoMiembros.size());
		listadoMiembros.add(t3);
		assertEquals(3, listadoMiembros.size());
		listadoMiembros.add(t4);
		assertEquals(4, listadoMiembros.size());
	}
	
	//Si pasa la prueba significa que los miembros se agregan correctamente a la lista.

}
