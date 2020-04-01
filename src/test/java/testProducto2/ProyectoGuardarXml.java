package testProducto2;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import org.junit.Test;
import ongEC.LineaAccion;
import ongEC.Miembro;
import ongEC.Proyecto;
import ongEC.Proyectos;
import ongEC.SubLineaAccion;

public class ProyectoGuardarXml {
	@Test
	public void main() {
		try {
			Proyectos proyectos = setupProyectos();
			File file = new File("src/main/resources/Proyecto.xml");
			JAXBContext contexto = JAXBContext.newInstance(proyectos.getClass());
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(proyectos, file);
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Proyecto setupProyecto() {
		Proyecto proyecto = new Proyecto();
		proyecto.setIdProyecto(26);
		proyecto.setFinanciacionAportada(25.0);
		proyecto.setNombreProyecto("nombreProyecto");
		proyecto.setPais("pais");
		proyecto.setLocalizacion("localizacion");
		proyecto.setFinanciador("financiador");
		proyecto.setCodigoProyecto("codigoProyecto");
		proyecto.setAccionesRealizar("accionesRealizar");
		proyecto.setFechaInicio(new Date());
		proyecto.setFechaFin(new Date());
		proyecto.setLineaAccion(new LineaAccion());
		proyecto.setSubLineaAccion(new ArrayList<SubLineaAccion>());
		proyecto.setSocioLocal(new ArrayList<String>());
		proyecto.setMiembrosAsignados(new ArrayList<Miembro>());
		return proyecto;
	}
	
	private static Proyectos setupProyectos() {
		Proyectos proyectos = new Proyectos();
		Proyecto proyecto1 = setupProyecto();
		Proyecto proyecto2 = setupProyecto();
		proyecto2.setIdProyecto(5);
		proyectos.add(proyecto1);
		proyectos.add(proyecto2);
		return proyectos;
	}

}
