package DAO.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;

import ongEC.ActualLineasAccion;
import ongEC.Delegacion;
import ongEC.Delegaciones;
import ongEC.LineaAccion;
import ongEC.Miembros;
import ongEC.Proyecto;
import ongEC.Proyectos;
import ongEC.SubLineaAccion;

public class DelegacionDAO{
  
	public static List<Delegacion> getAll() {
		// TODO Auto-generated method stub
		 try {
		        JAXBContext context = JAXBContext.newInstance(Delegaciones.class);
		        Unmarshaller unmarshaller = context.createUnmarshaller();
		        Delegaciones delegaciones = (Delegaciones) unmarshaller.unmarshal(new File("src/main/resources/Delegacion.xml"));
		        printDelegaciones(delegaciones);
		      } catch (JAXBException e) {
		        // TODO Auto-generated catch block
		    	  System.out.println("No hay ningun registro");
		        e.printStackTrace();
		      }
		return null;
	}

	public static void save(Delegaciones t) {
		// TODO Auto-generated method stub
		try {
			File file = new File("src/main/resources/Delegacion.xml");
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

	public static void update(Delegaciones t) {
		// TODO Auto-generated method stub
		String idProyecto="";
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		String comprobacionStr="";
		
		System.out.println("Introduce el  id de proyecto que se va a modificar");
		
		try {
			idProyecto=recuperado.next();
		} catch(Exception e) {
			System.out.println("No has introducido un id de proyecto");
		  return;
		}	
		for (int i = 0;i<t.getDelegacion().size();i++) {
			
			if (t.getDelegacion().get(i).getIdDelegacion().equals(idProyecto)){											
				while(!comprobacionStr.equals("exit")) {
					System.out.println("Selecciona la opcion que quieres modificar(para salir introduzca exit)");
					System.out.println("1.Iddelegacion");
					System.out.println("2.Nombre Delegacion");
					System.out.println("3.Cip Delegacion");
					System.out.println("4.Telefono Delegacion");
					comprobacionStr=recuperado.next();
					if(comprobacionStr.equals("1"))
					{
						System.out.println("Introduzca el id de la Delegacion");
						try {
								t.getDelegacion().get(i).setIdDelegacion(recuperado.next());
							}
							catch(Exception e) {
								System.out.println("No has introducido un String");
							  return;
							}
					}
					if(comprobacionStr.equals("2"))
					{
						System.out.println("Introduzca el Nombre de la Delegacion");
						try {
							t.getDelegacion().get(i).setNomDelegacion(recuperado.next());
						}
						catch(Exception e) {
							System.out.println("No has introducido un String");
						  return;
						}
					}
					if(comprobacionStr.equals("3"))
					{
						System.out.println("Introduzca el Cip de la delegacion");
						t.getDelegacion().get(i).setCip(recuperado.next());
					}
					if(comprobacionStr.equals("4"))
					{
						System.out.println("Introduzca el telefono de la delegacion");
						t.getDelegacion().get(i).setTelefono(recuperado.next());
					}
					
			}
		}
	}
}

	public static void delete(Delegaciones t) {
		// TODO Auto-generated method stub
		String idDelegacion="";
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		
		System.out.println("Introduce el  id la Delegacion que se va a borrar");
		
		try {
			idDelegacion=recuperado.next();
		} catch(Exception e) {
			System.out.println("No has introducido un id de delegacion");
		  return;
		}
		if(t.getDelegacion()!=null) {
			for (int i = 0;i<t.getDelegacion().size();i++) {
				if (t.getDelegacion().get(i).getIdDelegacion().equals(idDelegacion)){
					System.out.println(t.getDelegacion().get(i).getIdDelegacion());
					t.getDelegacion().remove(i);
					System.out.println("Borrado con exito");
				}
			}
		}else {
			System.out.println("Archivo Vacio");			
		}
		return;
	}
	
	private static void printDelegacion(Delegacion delegacion, int i) {
		System.out.println("Delegacion " + i + ":");
		System.out.println("CIP:" + delegacion.getCip());
		System.out.println("ID delegacion:" + delegacion.getIdDelegacion());
		System.out.println("Nombre;"+ delegacion.getNomDelegacion());
		System.out.println("Telefono:"+ delegacion.getTelefono());
		System.out.println("==============================================");	
	}
	
	private static void printDelegaciones(Delegaciones delegaciones) {
		
		if(delegaciones.getDelegacion()!=null) {
			for(int i = 0; i < delegaciones.getDelegacion().size(); i++) {
				printDelegacion(delegaciones.getDelegacion().get(i), i);
			}
		}else{
			System.out.println("Archivo Vacio");			
		}
	}
	
	
//	private static Proyecto setupProyecto() {
//		Proyecto proyecto = new Proyecto();
//		proyecto.setIdProyecto(26);
//		proyecto.setFinanciacionAportada(25.0);
//		proyecto.setNombreProyecto("nombreProyecto");
//		proyecto.setPais("pais");
//		proyecto.setLocalizacion("localizacion");
//		proyecto.setFinanciador("financiador");
//		proyecto.setCodigoProyecto("codigoProyecto");
//		proyecto.setAccionesRealizar("accionesRealizar");
//		proyecto.setFechaInicio(new Date());
//		proyecto.setFechaFin(new Date());
//		proyecto.setLineaAccion(new LineaAccion());
//		proyecto.setSubLineaAccion(new ArrayList<SubLineaAccion>());
//		proyecto.setSocioLocal(new ArrayList<String>());
//		proyecto.setMiembrosAsignados(new ArrayList<Miembros>());
//		return proyecto;
//	}
//	
//	private static Proyectos setupProyectos() {
//		Proyectos proyectos = new Proyectos();
//		Proyecto proyecto1 = setupProyecto();
//		Proyecto proyecto2 = setupProyecto();
//		proyecto2.setIdProyecto(5);
//		proyectos.add(proyecto1);
//		proyectos.add(proyecto2);
//		return proyectos;
//	}
	// método para dar de alta una delegación
	
	public static Delegacion addDelegacion() throws IOException, JAXBException {
		Delegacion newDelegacion = new Delegacion();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nIntroduce el nombre de la delegación: ");
		newDelegacion.setNomDelegacion(br.readLine());
		System.out.println("\nIntroduce el ID de la delegación: ");
		newDelegacion.setIdDelegacion(br.readLine());
		System.out.println("\nIntroduce el teléfono de la delegación: ");
		newDelegacion.setTelefono(br.readLine());
		System.out.println("\nIntroduce el CIP de la delegacion: ");
		newDelegacion.setCip(br.readLine());
		
		return(newDelegacion);
		
	}
}
