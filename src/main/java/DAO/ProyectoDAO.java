package DAO;

import javax.xml.bind.JAXBException;

import ongEC.Proyecto;
import ongEC.Proyectos;

public interface ProyectoDAO {
    public void guardar(Proyecto proyecto) throws JAXBException;
    public Proyecto listarProyectos() throws JAXBException;
}
