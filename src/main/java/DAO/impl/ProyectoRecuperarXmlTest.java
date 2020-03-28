package DAO.impl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ongEC.Proyecto;
import ongEC.Proyectos;

public class ProyectoRecuperarXmlTest {
  
	public static void main(String[] args) {
	    try {
	        JAXBContext context = JAXBContext.newInstance(Proyectos.class);
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	        Proyectos proyectos = (Proyectos) unmarshaller.unmarshal(new File("src/main/resources/Proyecto.xml"));
	        printProyectos(proyectos);
	      } catch (JAXBException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
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
	
		
}