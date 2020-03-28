package DAO.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import ongEC.LineaAccion;
import ongEC.Miembros;
import ongEC.Proyecto;
import ongEC.Proyectos;
import ongEC.SubLineaAccion;

public class ProyectoDAO{
  
	public static List<Proyecto> getAll() {
		// TODO Auto-generated method stub
		 try {
		        JAXBContext context = JAXBContext.newInstance(Proyectos.class);
		        Unmarshaller unmarshaller = context.createUnmarshaller();
		        Proyectos proyectos = (Proyectos) unmarshaller.unmarshal(new File("src/main/resources/Proyecto.xml"));
		        printProyectos(proyectos);
		      } catch (JAXBException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		      }
		return null;
	}

	public static void save( Proyecto t) {
		// TODO Auto-generated method stub
		try {
			File file = new File("src/main/resources/Proyecto.xml");
			JAXBContext contexto = JAXBContext.newInstance(t.getClass());
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(t, file);
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Proyecto t, String[] params) {
		// TODO Auto-generated method stub
	}

	public void delete(Proyecto t) {
		// TODO Auto-generated method stub
	}
	
	private static void printProyecto(Proyecto proyecto, int i) {
		System.out.println("Proyecto " + i + ":");
		System.out.println(proyecto.getIdProyecto());
		System.out.println(proyecto.getFinanciacionAportada());
		System.out.println(proyecto.getNombreProyecto());
		System.out.println(proyecto.getPais());
		System.out.println(proyecto.getLocalizacion());
		System.out.println(proyecto.getFinanciador());
		System.out.println(proyecto.getCodigoProyecto());
		System.out.println(proyecto.getAccionesRealizar());
		System.out.println(proyecto.getFechaInicio());
		System.out.println(proyecto.getFechaFin());
		System.out.println(proyecto.getLineaAccion());
		System.out.println(proyecto.getSubLineaAccion());
		System.out.println(proyecto.getSocioLocal());
		System.out.println(proyecto.getMiembrosAsignados());
		System.out.println("==============================================");
		
	}
	
	private static void printProyectos(Proyectos proyectos) {
		for(int i = 0; i < proyectos.getProyecto().size(); i++) {
			printProyecto(proyectos.getProyecto().get(i), i);
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
