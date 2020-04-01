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
import ongEC.Miembro;
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

	public static void update(Delegaciones t) throws IOException {
		// TODO Auto-generated method stub
		String idProyecto="";
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		String comprobacionStr="";
		String recuperadoString="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduce el Id la delegacion que se va a modificar");
		
		try {
			idProyecto=recuperado.next();
		} catch(Exception e) {
			System.out.println("No has introducido un id de proyecto");
		  return;
		}	
		if(t.getDelegacion()!=null) {
			for (int i = 0;i<t.getDelegacion().size();i++){
				if (t.getDelegacion().get(i).getIdDelegacion().equals(idProyecto)){											
					while(!recuperadoString.equals("exit")) {
						System.out.println("Selecciona la opcion que quieres modificar(para salir introduzca exit)");
						System.out.println("1.Iddelegacion");
						System.out.println("2.Nombre Delegacion");
						System.out.println("3.Cip Delegacion");
						System.out.println("4.Telefono Delegacion");
						recuperadoString=recuperado.next();
						if(recuperadoString.equals("1"))
						{
							System.out.println("Introduzca el id de la Delegacion");
							recuperadoString=br.readLine();
							for (int x = 0;x<t.getDelegacion().size();x++) {
								if (t.getDelegacion().get(x).getIdDelegacion().equals(recuperadoString)){
									System.out.println("\n ID REPETIDO ");
									return;
								} 			
								
							}
							try {
								t.getDelegacion().get(i).setIdDelegacion(recuperadoString);
							}
							catch(Exception e) {
								System.out.println("No has introducido un String");
							  return;
							}
						}
						if(recuperadoString.equals("2"))
						{
							System.out.println("Introduzca el Nombre de la Delegacion");
							try {
								t.getDelegacion().get(i).setNomDelegacion(br.readLine());
							}
							catch(Exception e) {
								System.out.println("No has introducido un String");
							  return;
							}
						}
						if(recuperadoString.equals("3"))
						{
							System.out.println("Introduzca el Cip de la delegacion");
							t.getDelegacion().get(i).setCip(br.readLine());
						}
						if(recuperadoString.equals("4"))
						{
							
							t.getDelegacion().get(i).setTelefono(br.readLine());
						}
						
					}
				}
			}
		}else {
			System.out.println("Archivo Vacío");
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
	
	public static Delegacion addDelegacion(Delegaciones t) throws IOException, JAXBException {
		Delegacion newDelegacion = new Delegacion();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\nIntroduce el ID de la delegación: ");
		newDelegacion.setIdDelegacion(br.readLine());
		if (t.getDelegacion()!=null) {
			for (int i = 0;i<t.getDelegacion().size();i++) {
				if (t.getDelegacion().get(i).getIdDelegacion().equals(newDelegacion.getIdDelegacion())){
					System.out.println("\n ID REPETIDO ");
					return null;
				}
				
			}
		}
		System.out.println("\nIntroduce el nombre de la delegación: ");
		newDelegacion.setNomDelegacion(br.readLine());
		System.out.println("\nIntroduce el teléfono de la delegación: ");
		newDelegacion.setTelefono(br.readLine());
		System.out.println("\nIntroduce el CIP de la delegacion: ");
		newDelegacion.setCip(br.readLine());
		
		return(newDelegacion);
		
	}
	
	public static Delegaciones readfirst() {
		// TODO Auto-generated method stub
		 try {
		        JAXBContext context = JAXBContext.newInstance(Delegaciones.class);
		        Unmarshaller unmarshaller = context.createUnmarshaller();
		        Delegaciones delegaciones = (Delegaciones) unmarshaller.unmarshal(new File("src/main/resources/Delegacion.xml"));
		        return(delegaciones);
		      } catch (JAXBException e) {
		        // TODO Auto-generated catch block
		    	  System.out.println("No hay ningun registro");
		        e.printStackTrace();
		      }
		return null;
	}

}

