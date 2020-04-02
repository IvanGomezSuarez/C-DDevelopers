package DAO.impl;


public class MySQLDAOFactory extends DAOFactory{

	public IMiembroDAO getMiembroDAO() {
	        return new MySqlMiembroDao();
	    }


	}

