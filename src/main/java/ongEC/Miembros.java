package ongEC;

import java.util.ArrayList;

import java.util.GregorianCalendar;

import javax.xml.bind.JAXBException;

/*
 * esta clase contiene la informaci�n de los miembros. los crea y a�ade a un array
 * 
 * 
 * */

public class Miembros {

// atributos
	
	protected int idMiembro;
	private java.util.GregorianCalendar fechaAlta;
	private java.util.GregorianCalendar fechaBaja;
	protected String nombreMiembro;
	protected String nombreUsuario;
	protected String password;
	protected String apellido1;
	protected String apellido2;
	protected String dni;
	protected String pais;
	protected String ciudad;
	protected String direccion;
	protected String rol;
	private ArrayList<Miembros> ALMiembros;
	

	// constructores
	
	public Miembros() {
		super();
	}


	/**
	 * este constructor crea objeto e inicialia los atributos.
	 * @param idMiembro
	 * @param fechaAlta
	 * @param fechaBaja
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
	public Miembros(int idMiembro, java.util.GregorianCalendar fechaAlta,java.util.GregorianCalendar fechaBaja, String nombreMiembro, String nombreUsuario, String password, String apellido1, String apellido2,
			 String dni, String pais, String ciudad, String direccion) {
		super();
		this.idMiembro =idMiembro;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.nombreMiembro = nombreMiembro;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.pais = pais;
		this.ciudad =ciudad;
		this.direccion = direccion;
	}

	// constructor para el arraylist
	/*   public Miembros()
	   {
	       ALMiembros = new ArrayList <Miembros>();
	       
	     }
	*/
	//metodos
	
	public Miembros(String nombreMiembro2, String dni2) {
		// TODO Auto-generated constructor stub
	}


	public int getIdMiembro() {
		return idMiembro;
	}


	public void setIdMiembro(int idMiembro) {
		this.idMiembro = idMiembro;
	}


	public java.util.GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(java.util.GregorianCalendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public java.util.GregorianCalendar getFechaBaja() {
		return fechaBaja;
	}


	public void setFechaBaja(java.util.GregorianCalendar fechaBaja) {
		this.fechaBaja = fechaBaja;
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

	public String getDni() {
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
	


    // metodo a�adir miembro al array
/*	
 public void AddMiembro (Miembros miembro)
 { 
     
      boolean b= true;
     for (Miembros n:ALMiembros)
     { if(n.getDni().equals(miembro.getDni())){
         b=false;
         System.out.println(" el miembro ya existe");
         break;
     } else {
     }
     }
     
     if(b){
         this.ALMiembros.add (miembro);
         System.out.println(" El miembro se ha a�adido a la base de datos"+'\n');
       }   
   }

// visualiza en pantalla los miembros 
public void mostrarMiembros() 
{
 for(Miembros miembro : ALMiembros) {
      System.out.println(this.getDni()+'\n');  
  }    
}
//Lista los miebros
public void listMiembros()
{
 for(Miembros miembro : ALMiembros) {
       miembro.mostrarMiembros();   
  }    
}
*/
}
