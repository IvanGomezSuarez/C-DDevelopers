package DAO.impl;

import DAO.impl.*;


public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IMiembroDAO getMiembroDAO() {
        return new MySqlMiembroDAO();
    }

	}
