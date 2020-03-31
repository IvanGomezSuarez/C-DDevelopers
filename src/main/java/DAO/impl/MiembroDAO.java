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
import ongEC.Direccion;
import ongEC.LineaAccion;
import ongEC.Miembro;
import ongEC.Miembros;
import ongEC.Proyecto;
import ongEC.Proyectos;
import ongEC.SubLineaAccion;

public class MiembroDAO{
  
	public static List<Miembro> getAll() {
		// TODO Auto-generated method stub
		 try {
		        JAXBContext context = JAXBContext.newInstance(Miembros.class);
		        Unmarshaller unmarshaller = context.createUnmarshaller();
		        Miembros miembros = (Miembros) unmarshaller.unmarshal(new File("src/main/resources/Miembros.xml"));
		        printMiembros(miembros);
		      } catch (JAXBException e) {
		        // TODO Auto-generated catch block
		    	  System.out.println("No hay ningun registro");
		        e.printStackTrace();
		      }
		return null;
	}

	public static void save(Miembros t) {
		// TODO Auto-generated method stub
		try {
			File file = new File("src/main/resources/Miembros.xml");
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

	public static void update(Miembros t) throws IOException {
		// TODO Auto-generated method stub
		String idProyecto="";
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		String comprobacionStr="";
		
		System.out.println("Introduce el la miembro que se va a modificar");
		
		try {
			idProyecto=recuperado.next();
		} catch(Exception e) {
			System.out.println("No has introducido un id de proyecto");
		  return;
		}	
		if(t.getMiembro()!=null) {
		for (int i = 0;i<t.getMiembro().size();i++) {
			
				if (t.getMiembro().get(i).getIdMiembro().equals(idProyecto)){											
					while(!comprobacionStr.equals("exit")) {
						System.out.println("Selecciona la opcion que quieres modificar(para salir introduzca exit)");
						System.out.println("1.Idmiembro");
						System.out.println("2.Nombre");
						System.out.println("3.Apellido1");
						System.out.println("4.Apellido2");
						System.out.println("5.DNI");
						System.out.println("6.Pais");
						System.out.println("7.Ciudad");
						System.out.println("8.Direccion");
						System.out.println("9.Rol");
						System.out.println("10.Telefono");
						System.out.println("11.Usuario");
						System.out.println("12.Contrase�a");
						comprobacionStr=recuperado.next();
						if(comprobacionStr.equals("1"))
						{
							System.out.println("Introduzca el id del Miembro");
							try {
									t.getMiembro().get(i).setIdMiembro(recuperado.next());
								}
								catch(Exception e) {
									System.out.println("No has introducido un String");
								  return;
								}
						}
						if(comprobacionStr.equals("2"))
						{
							System.out.println("Introduzca el Nombre");
							try {
								t.getMiembro().get(i).setNombreMiembro(recuperado.next());
							}
							catch(Exception e) {
								System.out.println("No has introducido un String");
							  return;
							}
						}
						if(comprobacionStr.equals("3"))
						{
							System.out.println("Introduzca el Apellido 1");
							t.getMiembro().get(i).setApellido1(recuperado.next());
						}
						if(comprobacionStr.equals("4"))
						{
							System.out.println("Introduzca el Apellido 2");
							t.getMiembro().get(i).setApellido2(recuperado.next());
						}
						if(comprobacionStr.equals("5"))
						{
							System.out.println("Introduzca el DNI");
							t.getMiembro().get(i).setDni(recuperado.next());
						}
						if(comprobacionStr.equals("6"))
						{
							System.out.println("Introduzca el Pais");
							t.getMiembro().get(i).setPais(recuperado.next());
						}
						if(comprobacionStr.equals("7"))
						{
							System.out.println("Introduzca la Ciudad");
							t.getMiembro().get(i).setCiudad(recuperado.next());
						}
						if(comprobacionStr.equals("8"))
						{
							System.out.println("Introduzca la direccion");
							t.getMiembro().get(i).setDireccion(Direccion.addDireccion());
						}
						if(comprobacionStr.equals("9"))
						{
							System.out.println("Introduzca el Rol");
							t.getMiembro().get(i).setRol(recuperado.next());
						}
						if(comprobacionStr.equals("10"))
						{
							System.out.println("Introduzca el Telefono");
							t.getMiembro().get(i).setTelefono(recuperado.next());
						}
						if(comprobacionStr.equals("11"))
						{
							System.out.println("Introduzca el Usuario");
							t.getMiembro().get(i).setNombreUsuario(recuperado.next());
						}
						if(comprobacionStr.equals("12"))
						{
							System.out.println("Introduzca la Contrase�a");
							t.getMiembro().get(i).setPassword(recuperado.next());
						}
					}
				}
			}
		}else {
		System.out.println("Archivo Vacio");
		}
}

	public static void delete(Miembros t) {
		// TODO Auto-generated method stub
		String idMiembro="";
		Scanner recuperado = new Scanner(System.in);  // recuperar la informacion del usuario
		
		System.out.println("Introduce el  id la Delegacion que se va a borrar");
		
		try {
			idMiembro=recuperado.next();
		} catch(Exception e) {
			System.out.println("No has introducido un id de miembro");
		  return;
		}
		if(t.getMiembro()!=null) {
			for (int i = 0;i<t.getMiembro().size();i++) {
				if (t.getMiembro().get(i).equals(idMiembro)){
					System.out.println(t.getMiembro().get(i).getIdMiembro());
					t.getMiembro().remove(i);
					System.out.println("Borrado con exito");
				}
			}
		}else {
			System.out.println("Archivo Vacio");			
		}
		return;
	}
	
	private static void printMiembro(Miembro miembro, int i) {
		System.out.println("IdMiembro " + i + ":"+ miembro.getIdMiembro());
		System.out.println("Nombre:" + miembro.getNombreMiembro());
		System.out.println("Apellido1:" + miembro.getApellido1());
		System.out.println("Apellido2;"+ miembro.getApellido2());
		System.out.println("Dni:"+ miembro.getDni());
		System.out.println("Pais:" + miembro.getPais());
		System.out.println("Ciudad:" + miembro.getCiudad());
		System.out.println("Via:"+ miembro.getDireccion().getTipoVia());
		System.out.println("Puerta:"+ miembro.getDireccion().getPuerta());
		System.out.println("Escalera::"+ miembro.getDireccion().getEscalera());
		System.out.println("Localidad:"+ miembro.getDireccion().getLocalidad());
		System.out.println("Provincia:"+ miembro.getDireccion().getProvincia());
		System.out.println("CP:"+ miembro.getDireccion().getCp());
		System.out.println("Rol:"+ miembro.getRol());
		System.out.println("Telefono;"+ miembro.getTelefono());
		System.out.println("Nombre usuario:"+ miembro.getNombreUsuario());
		System.out.println("Nombre Contrase�a:"+ miembro.getPassword());
		System.out.println("==============================================");	
	}
	
	private static void printMiembros(Miembros miembros) {
		
		if(miembros.getMiembro()!=null) {
			for(int i = 0; i < miembros.getMiembro().size(); i++) {
				printMiembro(miembros.getMiembro().get(i), i);
			}
		}else{
			System.out.println("Archivo Vacio");			
		}
	}
	
	
	public static void altaMiembro() throws IOException, JAXBException {
		Miembro nuevoMiembro = new Miembro();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nIntroduce el nombre del miembro: ");
		nuevoMiembro.setNombreMiembro(br.readLine());
		System.out.println("\nIntroduce el primer apellido del miembro: ");
		nuevoMiembro.setApellido1(br.readLine());
		System.out.println("\nIntroduce el segundo apellido del trabajador: ");
		nuevoMiembro.setApellido1(br.readLine());
		System.out.println("\nIntroduce el DNI del miembro: ");
		nuevoMiembro.setDni(br.readLine());
		System.out.println("\nIntroduce el pais de residencia: ");
		nuevoMiembro.setPais(br.readLine());
		System.out.println("\nIntroduce la ciudad de residencia: ");
		nuevoMiembro.setCiudad(br.readLine());
		System.out.println("\nIntroduce la direccion de su domicilio: ");
		nuevoMiembro.setDireccion(Direccion.addDireccion());
		System.out.println("\nIntroduce el ID del miembro: ");
		nuevoMiembro.setIdMiembro(br.readLine());
		System.out.println("\nIntroduce el nombre que desee como usuario: ");
		nuevoMiembro.setNombreUsuario(br.readLine());
		System.out.println("\nIntroduce tu contrase�a: ");
		nuevoMiembro.setPassword(br.readLine());
		System.out.println("\nIntroduce el numero de movil del miembro: ");
		nuevoMiembro.setTelefono(br.readLine());
		
        // a�adir MIEMBRO AL DAO, para ISA
		//MiembrosDAO.;
		
		AddMiembro(nuevoMiembro);
		mostrarMiembros();

	}
	
    // metodo a�adir miembro al array

 static void AddMiembro (Miembro miembro)
 {    
      boolean b= true;
     for (@SuppressWarnings("unused") Miembro n:ALMiembros)
     { if(Miembro.getDni().equals(Miembro.getDni())){
         b=false;
         System.out.println(" el miembro ya existe");
         break;
     } else {
     }
     }
     
     if(b){
         ALMiembros.add (miembro);
         System.out.println(" El miembro se ha a�adido a la base de datos"+'\n');
       }   
   }

 // ABRIR SESION COMO MIEMBRO
 
 
// visualiza en pantalla los miembros 
 
@SuppressWarnings("unused")
static void mostrarMiembros() 
{
 for(Miembro miembro : ALMiembros) {
      System.out.println(getDni()+'\n');  
  }    
}
//Lista los miembros

static void listMiembros()
{
 for(@SuppressWarnings("unused") Miembro miembro : ALMiembros) {
       Miembro.mostrarMiembros();   
  }    
}

//Comprobar si el dni del miembro esta dado de alta

@SuppressWarnings("static-access")
public static Integer comprobarMiembro (String dni)
{    
	Integer existeMiembro=0;
	
    for (Miembro n:ALMiembros)   	
    { if(n.getDni().equals(dni)){
    	System.out.println("Dni Encontrado"); 
        return (existeMiembro);
    }
    existeMiembro++;
    }
    System.out.println("El Dni No existe"); 
    return(0);  
  }
}

