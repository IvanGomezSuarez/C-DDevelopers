package DAO;

import javax.xml.bind.JAXBException;

import ongEC.Proyecto;

public interface ProyectoDAO {
    public void guardar(Proyecto proyecto) throws JAXBException;
    public Proyecto listarProyectos() throws JAXBException;
}
