package ongEC;
import javax.xml.bind.annotation.*;
/**
 *
 * @author Ivan
 */
@XmlRootElement(name ="socio")
@XmlAccessorType(XmlAccessType.FIELD)

public class Socio extends Miembros {
    @XmlElement(name = "cuota")
    private CuotaSocio cuota;
    @XmlElement(name = "importe")
    private int importe;
    
    public Socio(String pNombre, String pApellidos, String pDni, CuotaSocio pCuota, int pImporte){
        this.cuota = pCuota;
        this.importe = pImporte;
        this.setDNI(pDni);
        this.setApellidos(pApellidos);
        this.setNombre(pNombre);
    }
        private void setNombre(String pNombre) {
		// TODO Auto-generated method stub
		
	}
		private void setApellidos(String pApellidos) {
		// TODO Auto-generated method stub
		
	}
		private void setDNI(String pDni) {
		// TODO Auto-generated method stub
		
	}
	//Constructor vacío
    public Socio(){}
    
    
    public CuotaSocio getCuota(){
        return cuota;
    }
    public void setCuota(CuotaSocio c){
        cuota = c;
    }
    public int getImporte(){
        return importe;
    }
    public void setImporte(int i){
        importe = i;
    }
	public String getDNI() {
		// TODO Auto-generated method stub
		return null;
	}
}