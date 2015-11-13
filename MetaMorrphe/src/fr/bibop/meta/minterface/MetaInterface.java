package fr.bibop.meta.minterface;

import fr.bibop.commons.DatabaseParameters;

public class MetaInterface {
	
	public final static String MINT_TYPE_FTP = "meta_int_ftp";
	public final static String MINT_TYPE_FTPS = "meta_int_ftps";
	public final static String MINT_TYPE_SFTP = "meta_int_sftp";
	public final static String MINT_TYPE_FILE = "meta_int_file";
	public final static String MINT_TYPE_JMS_CONSUMER = "meta_int_jms_consumer";
	public final static String MINT_TYPE_JMS_PRODUCER = "meta_int_jms_producer";
	public final static String MINT_TYPE_BDD = "meta_int_database";
	
	// Mandatory :
	private String type = null;
	private String id = null;
	
	// Optional :
		// File :
	private String folder = null;
	private String description = null;
	
		// Database, JMS (or either file)? :
	private DatabaseParameters dbParams = null;
	
	// TODO: Manage filters over interfaces.
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public DatabaseParameters addDatabaseParameters(){
		
		DatabaseParameters dbParams =  new DatabaseParameters();
		this.dbParams = dbParams;
		return dbParams;
	}
	/**
	 * @return the dbParams
	 */
	public DatabaseParameters getDbParams() {
		return dbParams;
	}
}
