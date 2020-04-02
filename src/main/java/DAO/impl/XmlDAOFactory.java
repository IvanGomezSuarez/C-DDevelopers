package DAO.impl;

public abstract class XmlDAOFactory extends DAOFactory {

    public IMiembroDAO getMiembroDAO() {
        return new XmlMiembroDAO ();
    }

}
