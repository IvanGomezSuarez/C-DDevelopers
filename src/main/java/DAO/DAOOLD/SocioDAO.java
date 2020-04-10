package DAO;

import javax.xml.bind.JAXBException;

import ongEC.Socios;

public interface SocioDAO {

    public void guardar(Socios socios) throws JAXBException;
    public Socios listarSocios() throws JAXBException;

}
