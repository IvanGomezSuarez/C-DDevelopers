package ongEC;

import java.util.ArrayList;

import java.util.GregorianCalendar;

/*
 * esta clase contiene la información de los miembros. los crea y añade a un array
 * 
 * 
 * */

public class miembros {

// atributos
	
	protected int idMiembro;
	private java.util.GregorianCalendar fechaAlta;
	private java.util.GregorianCalendar fechaBaja;
	protected String nombreMiembro;
	protected String apellido1;
	protected String apellido2;
	protected String dni;
	protected String pais;
	protected String ciudad;
	protected String direccion;
	protected String rol;
	private ArrayList<miembros> ALMiembros;
	

	// constructores
	

	/**
	 * este constructor crea objeto e inicialia los atributos.
	 *  
	 */
	public miembros(int idMiembro, java.util.GregorianCalendar fechaAlta,java.util.GregorianCalendar fechaBaja, String nombreMiembro, String apellido1, String apellido2,
			 String dni, String pais, String ciudad, String direccion, String rol) {
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
		this.rol = rol;
	}

	// constructor para el arraylist
	   public miembros()
	   {
	       ALMiembros = new ArrayList <miembros>();
	       
	     }
	
	//metodos
	
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
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}

    // metodo añadir miembro al array
	
 public void AddMiembro (miembros miembro)
 { 
     
      boolean b= true;
     for (miembros n:ALMiembros)
     { if(n.getDni().equals(miembro.getDni())){
         b=false;
         System.out.println(" el miembro ya existe");
         break;
     } else {
     }
     }
     
     if(b){
         this.ALMiembros.add (miembro);
         System.out.println(" El miembro se ha añadido a la base de datos"+'\n');
       }   
   }

// visualiza en pantalla los miembros 
public void mostrarMiembros() 
{
 for(miembros miembro : ALMiembros) {
      System.out.println(this.getDni()+'\n');  
  }    
}
//Lista los miebros
public void listMiembros()
{
 for(miembros miembro : ALMiembros) {
       miembro.mostrarMiembros();   
  }    
}

}


