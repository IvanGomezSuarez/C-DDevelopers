package DAO.impl;

import DAO.impl.MySqlMiembroDAO;


public class MySQLDAOFactory extends DAOFactory{

   
    public IMiembroDAO getMiembroDAO() {
        return new MySqlMiembroDAO();
    }

	}
