package DAO.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import ongEC.LineaAccion;
import ongEC.Miembros;
import ongEC.Proyecto;
import ongEC.SubLineaAccion;

public class ProyectoGuardarXmlTest {
  
	public static void main(String[] args) {
		try {
			Proyecto proyecto = setupProyecto();
			File file = new File("src/main/resources/Proyecto.xml");
			JAXBContext contexto = JAXBContext.newInstance(proyecto.getClass());
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(proyecto, file);
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
		proyecto.setMiembrosAsignados(new ArrayList<Miembros>());
		return proyecto;
	}
}