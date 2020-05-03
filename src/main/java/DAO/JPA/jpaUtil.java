/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.JPA;

/**
 *
 * @author Ivan
 */

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaUtil {
	private static final String PERSISTENCE_UNIT_NAME = "persistencia";
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;				
	}
	public static void shutdown() {
		if (factory!=null) {
			factory.close();
		}		
	}
	
}