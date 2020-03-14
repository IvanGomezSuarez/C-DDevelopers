package ongEC;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Esta clase representa a los socios de la ONG que pagan una cuota
 * periódica la cual puede ser mensual, trimestral o anual.
 * 
 * @author Yaiza, Teresa y Marc.
 * @version 1.0
 *
 */

@XmlRootElement(name = "socio")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder={"idSocio", "periodicidadCuota"})

public class socio extends miembros implements ingreso {

}
