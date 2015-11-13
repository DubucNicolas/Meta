package fr.bibop.commons.dao;

import java.sql.Connection;

/**
 * Connection manager interface
 * @author Nicolas Dubuc
 *
 */
public interface ConnectionManager {

	/**
	 * Retrieving connection method
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception;
	
}
