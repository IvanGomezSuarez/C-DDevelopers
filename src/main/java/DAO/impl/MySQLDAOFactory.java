package DAO.impl;

import DAO.impl.MySqlMiembroDAO;


public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IMiembroDAO getMiembroDAO() {
        return new MySqlMiembroDAO();
    }

	}
