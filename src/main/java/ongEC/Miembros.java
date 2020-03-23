package ongEC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;


/*
 * esta clase contiene la informaciï¿½n de los miembros. los crea y aï¿½ade a un array
 * 
 * 
 * */

public class Miembros {

// atributos
	
	protected String idMiembro;
	protected String nombreMiembro;
	protected String nombreUsuario;
	protected String password;
	protected String apellido1;
	protected String apellido2;
	protected static String dni;
	protected String pais;
	protected String ciudad;
	protected String direccion;
	protected String rol;
	protected String telefono;
	private static ArrayList<Miembros> ALMiembros;
	

	// constructores
	
	/**
	 * este constructor crea objeto e inicialia los atributos.
	 * @param idMiembro
	 * @param nombreMiembro
	 * @param nombreUsuario
	 * @param password
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param pais
	 * @param ciudad
	 * @param direccion
	 * 
	 * 
	 */
	public Miembros(String idMiembro, String nombreMiembro, String nombreUsuario, String password, String apellido1, String apellido2,
			 String dni, String pais, String ciudad, String direccion, String telefono) {
		super();
		this.idMiembro =idMiembro;
		this.nombreMiembro = nombreMiembro;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.pais = pais;
		this.ciudad =ciudad;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	// constructor para el arraylist
	public Miembros()
	   {
	       ALMiembros = new ArrayList <Miembros>();
	       
	     }
	
	//metodos
	
	public Miembros(String nombreMiembro2, String dni2) {
		// TODO Auto-generated constructor stub
	}


	public String getIdMiembro() {
		return idMiembro;
	}


	public void setIdMiembro(String idMiembro) {
		this.idMiembro = idMiembro;
	}
	
	public String getNombreMiembro() {
		return nombreMiembro;
	}

	public void setNombreMiembro(String nombreMiembro) {
		this.nombreMiembro = nombreMiembro;
	}

	public String getApellido1() {
		return apellido1;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getNomUsuario() {
		return nombreUsuario;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPass() {
		return password;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	static void altaMiembro() throws IOException, JAXBException {
		Miembros nuevoMiembro = new Miembros();
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
		nuevoMiembro.setDireccion(br.readLine());
		System.out.println("\nIntroduce el ID del miembro: ");
		nuevoMiembro.setIdMiembro(br.readLine());
		System.out.println("\nIntroduce el nombre que desee como usuario: ");
		nuevoMiembro.setNombreUsuario(br.readLine());
		System.out.println("\nIntroduce tu contraseña: ");
		nuevoMiembro.setPassword(br.readLine());
		System.out.println("\nIntroduce el numero de movil del miembro: ");
		nuevoMiembro.setTelefono(br.readLine());
		
        // añadir MIEMBRO AL DAO, para ISA
		//MiembrosDAO.;
		
		AddMiembro(nuevoMiembro);
		mostrarMiembros();

	}
	
    // metodo añadir miembro al array

 static void AddMiembro (Miembros miembro)
 { 
     
      boolean b= true;
     for (@SuppressWarnings("unused") Miembros n:ALMiembros)
     { if(Miembros.getDni().equals(Miembros.getDni())){
         b=false;
         System.out.println(" el miembro ya existe");
         break;
     } else {
     }
     }
     
     if(b){
         ALMiembros.add (miembro);
         System.out.println(" El miembro se ha aï¿½adido a la base de datos"+'\n');
       }   
   }

// visualiza en pantalla los miembros 
 
@SuppressWarnings("unused")
static void mostrarMiembros() 
{
 for(Miembros miembro : ALMiembros) {
      System.out.println(getDni()+'\n');  
  }    
}
//Lista los miembros

static void listMiembros()
{
 for(@SuppressWarnings("unused") Miembros miembro : ALMiembros) {
       Miembros.mostrarMiembros();   
  }    
}

//Comprobar si el dni del miembro esta dado de alta

public Integer comprobarMiembro (String dni)
{    
	Integer existeMiembro=0;
	
    for (Miembros n:ALMiembros)   	
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
